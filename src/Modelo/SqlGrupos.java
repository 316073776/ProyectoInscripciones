
package Modelo;

import Conexion.Conection;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;


public class SqlGrupos extends Conection{
    
    PreparedStatement ps;
    ResultSet rs;
    private String sql;
    
    public Grupos buscarAsignatura(String claveAsignatura){
    
        Connection conexion = getConnection();
        Grupos asignaturaC = null;
                     
        try {
            
            sql = "SELECT * FROM asignatura WHERE asig_id_asignatura = ?";
            
            ps = conexion.prepareStatement(sql);
            ps.setString(1, claveAsignatura);
            rs = ps.executeQuery();
            
            if(rs.next()){
                asignaturaC = new Grupos(rs.getString("asig_id_asignatura"),
                rs.getString("asig_nombre"),
                rs.getString("asig_plan_estudio"));
                
                return asignaturaC;
                
           } else {
                return null;
           }
            
            
        } catch(SQLException ex){
            System.err.println("Eror, " + ex);
            return null;
        }finally {
            try {
                conexion.close();
            } catch(SQLException ex) {
                System.err.println("Eror, " + ex);
            }
        }
    }
    
    public boolean crearAsignatura(Grupos asignatura){
        
        Connection conexion = getConnection();
                     
        try {
            sql = "INSERT INTO asignatura VALUES (?,?,?)";
            
            ps = conexion.prepareStatement(sql);
            ps.setString(1, asignatura.getIdAsignatura());
            ps.setString(2, asignatura.getNomAsignatura());
            ps.setString(3, asignatura.getPlanEstudios());
            int resultado = ps.executeUpdate();
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
    
    public Grupos buscarPeriodo(String idPeriodo){
        Connection conexion = getConnection();
        Grupos periodoC = null;
                     
        try {
            
            sql = "SELECT * FROM periodo WHERE peri_id_periodo = ?";
            
            ps = conexion.prepareStatement(sql);
            ps.setString(1, idPeriodo);
            rs = ps.executeQuery();
            
            if(rs.next()){
                periodoC = new Grupos(rs.getString("peri_id_periodo"),
                rs.getDate("peri_fec_inicio"),
                rs.getDate("peri_fec_fin"),
                rs.getBoolean("peri_estado"));
                
                return periodoC;
                
           } else {
                return null;
           }
            
            
        } catch(SQLException ex){
            System.err.println("Eror, " + ex);
            return null;
        }finally {
            try {
                conexion.close();
            } catch(SQLException ex) {
                System.err.println("Eror, " + ex);
            }
        }
    }
    
    public boolean crearPeriodo(Grupos periodo){
        
        Connection conexion = getConnection();
                     
        try {
            sql = "INSERT INTO periodo VALUES (?,?,?,?)";
            
            ps = conexion.prepareStatement(sql);
            ps.setString(1, periodo.getIdPriodo());
            ps.setDate(2, periodo.getFechaInicioPer());
            ps.setDate(3, periodo.getFechaFinPer());
            ps.setBoolean(4, periodo.isEstadoPer());
            int resultado = ps.executeUpdate();
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
    
    public Grupos buscarGrupo(String grupoClave){
        Connection conexion = getConnection();
        Grupos grupoC = null;
                     
        try {
            
            sql = "SELECT g.grup_id_asignatura, a.asig_nombre, a.asig_plan_estudio, g.grup_id_periodo, pe.peri_fec_inicio, pe.peri_fec_fin, pe.peri_estado, " +
                "g.grup_id_grupo, g.grup_clave, g.grupo_cupo, p.prof_num_trabajador " +
                "FROM grupo g INNER JOIN profesor p ON g.grup_id_profesor = p.prof_id_profesor " +
                "INNER JOIN periodo pe ON g.grup_id_periodo = pe.peri_id_periodo " +
                "INNER JOIN asignatura a ON g.grup_id_asignatura = a.asig_id_asignatura " +
                "WHERE g.grup_clave = ?";
            
            ps = conexion.prepareStatement(sql);
            ps.setString(1, grupoClave);
            rs = ps.executeQuery();
            
            if(rs.next()){
               
                grupoC = new Grupos(rs.getString(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getDate(5),
                rs.getDate(6),        
                rs.getBoolean(7),
                rs.getInt(8),
                rs.getString(9),
                rs.getInt(10),
                rs.getString(11));
                
                return grupoC;
                
           } else {
                return null;
           }
            
            
        } catch(SQLException ex){
            System.err.println("Eror, " + ex);
            return null;
        }finally {
            try {
                conexion.close();
            } catch(SQLException ex) {
                System.err.println("Eror, " + ex);
            }
        }
    }
    
    public boolean guardarGrupo(Grupos grupo){
        
        Connection conexion = getConnection();
                     
        try {
            sql = "{call insertar_grupo (?,?,?,?,?)}";
            CallableStatement call = conexion.prepareCall(sql);
            call.setString(1, grupo.getClaveProfesor());
            call.setString(2, grupo.getIdPriodo());
            call.setString(3, grupo.getIdAsignatura());
            call.setString(4, grupo.getGrupoClave());
            call.setInt(5, grupo.getCupo());
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
    
    public boolean borrarGrupo(String claveGrupo){
        Connection conexion = getConnection();
                     
        try {
            sql = "DELETE FROM grupo WHERE grup_clave = ?";
            
            ps = conexion.prepareStatement(sql);
            ps.setString(1, claveGrupo);
            int resultado = ps.executeUpdate();
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
            } catch(SQLException ex) {
                System.err.println("Eror, " + ex);
            }
        }
    }
    
    public boolean actualizarGrupo(Grupos grupo){
        Connection conexion = getConnection();
                     
        try {
            sql = "{call actualizar_grupo (?,?,?,?,?)}";
            CallableStatement call = conexion.prepareCall(sql);
            call.setString(1, grupo.getClaveProfesor());
            call.setString(2, grupo.getIdPriodo());
            call.setString(3, grupo.getIdAsignatura());
            call.setString(4, grupo.getGrupoClave());
            call.setInt(5, grupo.getCupo());
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
    
    
    
    public Vector<Grupos> establecerModeloTablaGrupos(){
        
        Connection conexion = getConnection();      
        Vector<Grupos> arregloDatos = new Vector<Grupos>();
        Grupos grupo;
        
        try{
           
           sql = "SELECT g.grup_id_asignatura, a.asig_nombre, a.asig_plan_estudio, g.grup_id_periodo, pe.peri_fec_inicio, pe.peri_fec_fin, pe.peri_estado, " +
                "g.grup_id_grupo, g.grup_clave, g.grupo_cupo, p.prof_num_trabajador " +
                "FROM grupo g INNER JOIN profesor p ON g.grup_id_profesor = p.prof_id_profesor " +
                "INNER JOIN periodo pe ON g.grup_id_periodo = pe.peri_id_periodo " +
                "INNER JOIN asignatura a ON g.grup_id_asignatura = a.asig_id_asignatura ";
           ps = conexion.prepareStatement(sql);
           rs = ps.executeQuery();
           
            while(rs.next()){
                
                grupo = new Grupos(rs.getString(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getDate(5),
                rs.getDate(6),        
                rs.getBoolean(7),
                rs.getInt(8),
                rs.getString(9),
                rs.getInt(10),
                rs.getString(11));
                
                arregloDatos.add(grupo);
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
    
    public Vector<Grupos> establecerModeloTablaPeriodos(){
        
        Connection conexion = getConnection();      
        Vector<Grupos> arregloDatos = new Vector<Grupos>();
        Grupos grupo;
        
        try{
           
           sql = "SELECT pe.peri_id_periodo, pe.peri_fec_inicio, pe.peri_fec_fin, pe.peri_estado FROM periodo pe";
           ps = conexion.prepareStatement(sql);
           rs = ps.executeQuery();
           
            while(rs.next()){
                
                grupo = new Grupos(rs.getString(1),
                rs.getDate(2),
                rs.getDate(3),        
                rs.getBoolean(4));
                
                arregloDatos.add(grupo);
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
    
    public Vector<Grupos> establecerModeloTablaAsignatura(){
        
        Connection conexion = getConnection();      
        Vector<Grupos> arregloDatos = new Vector<Grupos>();
        Grupos grupo;
        
        try{
           
           sql = "SELECT asig_id_asignatura, asig_nombre, asig_plan_estudio FROM asignatura";
           ps = conexion.prepareStatement(sql);
           rs = ps.executeQuery();
           
            while(rs.next()){
                
                grupo = new Grupos(rs.getString(1),
                rs.getString(2),
                rs.getString(3));
                
                arregloDatos.add(grupo);
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
