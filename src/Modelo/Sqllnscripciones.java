package Modelo;

import Conexion.Conection;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class Sqllnscripciones extends Conection{
    
    PreparedStatement ps;
    ResultSet rs;
    private String sql;
    
    public boolean guardarInscripcion(Inscripciones inscripcion){
        
        Connection conexion = getConnection();
                     
        try {
            sql = "{call insertar_inscripcion (?,?)}";
            CallableStatement call = conexion.prepareCall(sql);
            call.setString(1, inscripcion.getCuentaAlumno());
            call.setString(2, inscripcion.getClaveGrupo());
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
    
    public boolean borrarInscripcion(String cuentaAlumno, String claveGrupo){
        
        Connection conexion = getConnection();
                     
        try {
            sql = "{call borrar_inscripcion (?,?)}";
            CallableStatement call = conexion.prepareCall(sql);
            call.setString(1, cuentaAlumno);
            call.setString(2, claveGrupo);
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
    
    public Inscripciones buscarInscripcion(String cuentaAlumno, String claveGrupo){
        Connection conexion = getConnection();
        Inscripciones inscripcionC = null;
                     
        try {
            
            sql = "SELECT * FROM inscripcion i INNER JOIN grupo g ON i.insc_id_grupo = g.grup_id_grupo INNER JOIN alumno a ON i.insc_id_alumno = a.alum_id_alumno WHERE a.alum_num_cuenta = ? AND g.grup_clave = ?";
            
            ps = conexion.prepareStatement(sql);
            ps.setString(1, cuentaAlumno);
            ps.setString(2, claveGrupo);
            rs = ps.executeQuery();
            
            if(rs.next()){
                inscripcionC = new Inscripciones(rs.getInt("insc_id_alumno"), rs.getInt("insc_id_grupo"), rs.getString("alum_num_cuenta"), rs.getString("grup_clave"));
                
                return inscripcionC;
                
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
    
    public boolean actualizarInscripcion(Inscripciones inscripcion){
        
        Connection conexion = getConnection();
                     
        try {
            sql = "{call actualizar_inscripcion (?,?)}";
            CallableStatement call = conexion.prepareCall(sql);
            call.setString(1, inscripcion.getCuentaAlumno());
            call.setString(2, inscripcion.getClaveGrupo());
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
    
    public Vector<Inscripciones> insertarDatosTabla(){
        
        Connection conexion = getConnection();      
        
        Vector<Inscripciones> arregloDatos = new Vector<Inscripciones>();
        Inscripciones inscripcion;
        
        try{
           
           sql = "SELECT * FROM inscripcion i INNER JOIN grupo g ON i.insc_id_grupo = g.grup_id_grupo INNER JOIN alumno a ON i.insc_id_alumno = a.alum_id_alumno";
           ps = conexion.prepareStatement(sql);
           rs = ps.executeQuery();
           
            while(rs.next()){
                
                inscripcion = new Inscripciones(rs.getInt("insc_id_alumno"), rs.getInt("insc_id_grupo"), rs.getString("alum_num_cuenta"), rs.getString("grup_clave"),
                                     rs.getTime("insc_hora"), rs.getDate("insc_fecha"), rs.getString("insc_host"));
                
                arregloDatos.add(inscripcion);
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
