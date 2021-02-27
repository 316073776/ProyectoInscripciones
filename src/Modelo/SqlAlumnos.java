
package Modelo;

import Conexion.Conection;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Vector;

public class SqlAlumnos extends Conection{
    
    PreparedStatement ps;
    ResultSet rs;
    private String sql;
    
    public Alumnos buscarAlumno(String alumno){
        Connection conexion = getConnection();
        Alumnos alumnoC = null;
                     
        try {
            
            sql = "SELECT * FROM persona INNER JOIN alumno ON pers_id_persona = alum_id_persona WHERE alum_num_cuenta LIKE ?";
            
            ps = conexion.prepareStatement(sql);
            ps.setString(1, alumno);
            rs = ps.executeQuery();
            
            if(rs.next()){
                alumnoC = new Alumnos(rs.getInt("alum_id_alumno"),
                rs.getString("alum_num_cuenta"),
                rs.getInt("alum_generacion"),
                rs.getInt("pers_id_persona"),
                rs.getString("pers_nombre"),
                rs.getString("pers_apaterno"),
                rs.getString("pers_amaterno"));
                
                return alumnoC;
                
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
    
    public boolean guardarAlumno(Alumnos alumno){
        
        Connection conexion = getConnection();
                     
        try {
            sql = "{call insertar_alumno (?,?,?,?,?)}";
            CallableStatement call = conexion.prepareCall(sql);
            call.setString(1, alumno.getPersNombre());
            call.setString(2, alumno.getPersApPaterno());
            call.setString(3, alumno.getPersApMaterno());
            call.setString(4, alumno.getNumCuenta());
            call.setInt(5, alumno.getGeneracion());
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
    
    public boolean actualizarAlumno(Alumnos alumno){
        
        Connection conexion = getConnection();
                     
        try {
            sql = "{call actualizar_alumno (?,?,?,?,?)}";
            CallableStatement call = conexion.prepareCall(sql);
            call.setString(1, alumno.getPersNombre());
            call.setString(2, alumno.getPersApPaterno());
            call.setString(3, alumno.getPersApMaterno());
            call.setString(4, alumno.getNumCuenta());
            call.setInt(5, alumno.getGeneracion());
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
    
    public boolean borrarAlumno(String cuenta){
        Connection conexion = getConnection();
                     
        try {
            sql = "{call borrar_alumno (?)}";
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
    
    public boolean existeAlumno(Alumnos alumno){
        
        Connection conexion = getConnection();
        
        try {
            sql = "{? = call existe_alumno(?,?,?,?)}";
            CallableStatement call = conexion.prepareCall(sql);
            call.registerOutParameter(1, Types.INTEGER);
            call.setString(2, alumno.getPersNombre());
            call.setString(3, alumno.getPersApPaterno());
            call.setString(4, alumno.getPersApMaterno());
            call.setString(5, alumno.getNumCuenta());
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
    
    
    public Vector<Alumnos> insertarDatosTabla(){
        
        Connection conexion = getConnection();      
        Vector<Alumnos> arregloDatos = new Vector<Alumnos>();
        Alumnos alumno;
        
        try{
           
           sql = "SELECT * FROM alumno a INNER JOIN persona p ON a.alum_id_persona = p.pers_id_persona";
           ps = conexion.prepareStatement(sql);
           rs = ps.executeQuery();
           
            while(rs.next()){
                
                alumno = new Alumnos(rs.getInt("alum_id_alumno"), rs.getString("alum_num_cuenta"), rs.getInt("alum_generacion"),
                                     rs.getInt("pers_id_persona"), rs.getString("pers_nombre"), rs.getString("pers_apaterno"), rs.getString("pers_amaterno"));
                
                arregloDatos.add(alumno);
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