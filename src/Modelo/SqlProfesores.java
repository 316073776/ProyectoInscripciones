package Modelo;

import Conexion.Conection;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Vector;

public class SqlProfesores extends Conection {
    
    PreparedStatement ps;
    ResultSet rs;
    private String sql;
    
    public Profesores buscarProfesor(String profesor){
        Connection conexion = getConnection();
        Profesores profesorC = null;
                     
        try {
            
            sql = "SELECT * FROM persona INNER JOIN profesor ON pers_id_persona = prof_id_persona WHERE prof_num_trabajador LIKE ?";
            
            ps = conexion.prepareStatement(sql);
            ps.setString(1, profesor);
            rs = ps.executeQuery();
            
            if(rs.next()){
                profesorC = new Profesores(rs.getInt("prof_id_profesor"),
                rs.getString("prof_num_trabajador"),
                rs.getString("prof_cedula"),
                rs.getString("prof_grado").charAt(0),
                rs.getInt("pers_id_persona"),
                rs.getString("pers_nombre"),
                rs.getString("pers_apaterno"),
                rs.getString("pers_amaterno"));
                
                return profesorC;
                
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
    
    public boolean guardarProfesor(Profesores profesor){
        
        Connection conexion = getConnection();
                     
        try {
            sql = "{call insertar_profesor (?,?,?,?,?,?)}";
            CallableStatement call = conexion.prepareCall(sql);
            call.setString(1, profesor.getPersNombre());
            call.setString(2, profesor.getPersApPaterno());
            call.setString(3, profesor.getPersApMaterno());
            call.setString(4, profesor.getNumTrabajador());
            call.setString(5, profesor.getCedula());
            call.setString(6, String.valueOf(profesor.getGrado()));
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
    
    public boolean actualizarProfesor(Profesores profesor){
        
        Connection conexion = getConnection();
                     
        try {
            sql = "{call actualizar_profesor (?,?,?,?,?,?)}";
            CallableStatement call = conexion.prepareCall(sql);
            call.setString(1, profesor.getPersNombre());
            call.setString(2, profesor.getPersApPaterno());
            call.setString(3, profesor.getPersApMaterno());
            call.setString(4, profesor.getNumTrabajador());
            call.setString(5, profesor.getCedula());
            call.setString(6, String.valueOf(profesor.getGrado()));
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
    
    public boolean borrarProfesor(String cuenta){
        Connection conexion = getConnection();
                     
        try {
            sql = "{call borrar_profesor (?)}";
            CallableStatement call = conexion.prepareCall(sql);
            call.setString(1, cuenta);
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
    
    public boolean existeProfesor(Profesores profesor){
        
        Connection conexion = getConnection();
        
        try {
            sql = "{? = call existe_profesor(?,?,?,?)}";
            CallableStatement call = conexion.prepareCall(sql);
            call.registerOutParameter(1, Types.INTEGER);
            call.setString(2, profesor.getPersNombre());
            call.setString(3, profesor.getPersApPaterno());
            call.setString(4, profesor.getPersApMaterno());
            call.setString(5, profesor.getNumTrabajador());
            call.execute();
            
            int retorno = call.getInt(1);
            
            if(retorno == 0){
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
    
    public Vector<Profesores> insertarDatosTabla(){
        
        Connection conexion = getConnection();      
        Vector<Profesores> arregloDatos = new Vector<Profesores>();
        Profesores profesor;
        
        try{
           
           sql = "SELECT * FROM profesor pr INNER JOIN persona p ON pr.prof_id_persona = p.pers_id_persona";
           ps = conexion.prepareStatement(sql);
           rs = ps.executeQuery();
           
            while(rs.next()){
                
                profesor = new Profesores(rs.getInt("prof_id_profesor"), rs.getString("prof_num_trabajador"), rs.getString("prof_cedula"), 
                        rs.getString("prof_grado").charAt(0), rs.getInt("pers_id_persona"), rs.getString("pers_nombre"), rs.getString("pers_apaterno"), rs.getString("pers_amaterno"));
                
                arregloDatos.add(profesor);
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
