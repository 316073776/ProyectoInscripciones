
package Modelo;

import Conexion.Conection;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class SqlHorarios extends Conection{
    
    PreparedStatement ps;
    ResultSet rs;
    private String sql;
    
    public Horarios buscarHorario(int idHorario){
        Connection conexion = getConnection();
        Horarios horarioC = null;
        
        try{
           
            sql = "SELECT * " +
                 "FROM horario h " +
                 "INNER JOIN grupo g ON h.hora_id_grupo = g.grup_id_grupo " +
                 "INNER JOIN hora ho ON h.hora_id_hora = ho.hora_id_hora " +
                 "INNER JOIN dia d ON h.hora_id_dia = d.dia_id_dia " +
                 "INNER JOIN salon s ON h.hora_id_salon = s.salo_id_salon " +
                "WHERE h.hora_id_horario = ?";
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, idHorario);
            rs = ps.executeQuery();
           
            if(rs.next()){
                
                horarioC = new Horarios(rs.getInt("hora_id_horario"), rs.getInt("hora_id_dia"), rs.getInt("hora_id_hora"), rs.getString("hora_id_salon"), rs.getString("salo_edificio").charAt(0), 
                        rs.getString("salo_piso"), rs.getString("dia_nombre"), rs.getTime("hora_ini"), rs.getTime("hora_fin"), rs.getString("grup_clave"));
                
                return horarioC;
            } else {
                return null;
            }
           
        }catch(Exception ex){
            System.err.println("Eror, " + ex);
            return null;
        }finally{
            try {
                conexion.close();
            } catch(Exception ex) {
                System.err.println("Eror, " + ex);
            }
        } 
        
    }
    
    public boolean guardarHorario(Horarios horario){
        
        Connection conexion = getConnection();
                     
        try {
            sql = "{call insertar_horario (?,?,?,?)}";
            CallableStatement call = conexion.prepareCall(sql);
            call.setString(1, horario.getIdSalon());
            call.setString(2, horario.getGrupoClave());
            call.setInt(3, horario.getIdDia());
            call.setInt(4, horario.getIdHora());
            call.execute();
            return true;
            
        } catch(SQLException ex){
            System.err.println("Eror, " + ex);
            return false;
        }finally {
            try {
                conexion.close();
            } catch(Exception ex) {
                System.err.println("Eror, " + ex);
            }
        }
    } 
    
    public boolean actualizarHorario(Horarios horario){
        
        Connection conexion = getConnection();
                     
        try {
            sql = "{call actualizar_horario (?,?,?,?,?)}";
            CallableStatement call = conexion.prepareCall(sql);
            call.setInt(1, horario.getIdHorario());
            call.setString(2, horario.getIdSalon());
            call.setString(3, horario.getGrupoClave());
            call.setInt(4, horario.getIdDia());
            call.setInt(5, horario.getIdHora());
            call.execute();
            return true;
            
        } catch(SQLException ex){
            System.err.println("Eror, " + ex);
            return false;
        }finally {
            try {
                conexion.close();
            } catch(SQLException ex) {
                System.err.println("Eror, " + ex);
            }
        }
    }
    
    public boolean borrarHorario(int idHorario){
        
        Connection conexion = getConnection();
        int resultado;
        
        try {
            sql = "DELETE FROM horario WHERE hora_id_horario = ?";
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, idHorario);
            resultado = ps.executeUpdate();
            if (resultado > 0){            
                return true;
            } else {
                return false;
            }
        }catch(SQLException ex){
            System.err.println("Eror, " + ex);
            return false;
        }finally {
            try {
                conexion.close();
            } catch(Exception ex) {
                System.err.println("Eror, " + ex);
            }
        }
    }
    
    public boolean crearSalon(String idSalon, char edificio, String piso){
        
        Connection conexion = getConnection();
        int resultado;
                     
        try {
            sql = "INSERT INTO salon (salo_id_salon, salo_edificio, salo_piso) VALUES (?,?,?);";
            ps = conexion.prepareStatement(sql);
            ps.setString(1, idSalon);
            ps.setString(2, String.valueOf(edificio));
            ps.setString(3, piso);
            resultado = ps.executeUpdate();
            if (resultado > 0){            
                return true;
            } else {
                return false;
            }
            
        } catch(SQLException ex){
            System.err.println("Eror, " + ex);
            return false;
        }finally {
            try {
                conexion.close();
            } catch(Exception ex) {
                System.err.println("Eror, " + ex);
            }
        }
    } 
    
    public String[] buscarSalon(String idSalon){
        
        Connection conexion = getConnection();
        int resultado;
        
                     
        try {
            sql = "SELECT salo_edificio, salo_piso FROM salon WHERE salo_id_salon = ?;";
            ps = conexion.prepareStatement(sql);
            ps.setString(1, idSalon);
            rs = ps.executeQuery();
            
            if (rs.next()){ 
                
                String [] valores = { rs.getString("salo_edificio"), rs.getString("salo_piso")};
                return valores;
            
            } else {
                return null;
            }
            
        } catch(SQLException ex){
            System.err.println("Eror, " + ex);
            return null;
        }finally {
            try {
                conexion.close();
            } catch(Exception ex) {
                System.err.println("Eror, " + ex);
            }
        }
    } 
    
    public Vector<Horarios> establecerModeloTablaHorarios(){
        
        Connection conexion = getConnection();      
        Vector<Horarios> arregloDatos = new Vector<Horarios>();
        Horarios horario;
        
        try{
           
           sql = "SELECT * " +
                "FROM horario h " +
                "INNER JOIN grupo g ON h.hora_id_grupo = g.grup_id_grupo " +
                "INNER JOIN hora ho ON h.hora_id_hora = ho.hora_id_hora " +
                "INNER JOIN dia d ON h.hora_id_dia = d.dia_id_dia " +
                "INNER JOIN salon s ON h.hora_id_salon = s.salo_id_salon";
           ps = conexion.prepareStatement(sql);
           rs = ps.executeQuery();
           
            while(rs.next()){
                
                horario = new Horarios(rs.getInt("hora_id_horario"), rs.getInt("hora_id_dia"), rs.getInt("hora_id_hora"), rs.getString("hora_id_salon"), rs.getString("salo_edificio").charAt(0), 
                        rs.getString("salo_piso"), rs.getString("dia_nombre"), rs.getTime("hora_ini"), rs.getTime("hora_fin"), rs.getString("grup_clave"));
                
                arregloDatos.add(horario);
            } 
            
            if(arregloDatos == null){
               return null;
            }
            
            return arregloDatos;
           
        }catch(Exception ex){
            System.err.println("Eror, " + ex);
            return null;
        }finally{
            try {
                conexion.close();
            } catch(Exception ex) {
                System.err.println("Eror, " + ex);
            }
        }     
    }
    
    
}
