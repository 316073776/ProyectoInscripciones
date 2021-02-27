
package Modelo;

import Conexion.Conection;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SqlUsuarios extends Conection{
    
    PreparedStatement ps;
    ResultSet rs;
    private String sql;
    
    public boolean registrar(Usuarios usuario){
        
        Connection conexion = getConnection();
                     
        try {
            sql = "{call crear_usuario (?,?,?,?,?)}";
            CallableStatement call = conexion.prepareCall(sql);
            call.setString(1, usuario.getPersNombre());
            call.setString(2, usuario.getPersApPaterno());
            call.setString(3, usuario.getPersApMaterno());
            call.setString(4, usuario.getUsuario());
            call.setString(5, usuario.getContrasenia());
            call.execute();
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(SqlUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch(Exception ex) {
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
    
    public int existeUsuario(String usuario){
        
        Connection conexion = getConnection();
        
        try {
            sql = "SELECT count(usr_id_usuario) FROM usuario WHERE usr_nombre_usuario = ? ";
            
            ps = conexion.prepareStatement(sql);
            ps.setString(1, usuario);
            rs = ps.executeQuery();
            
            if (rs.next()){
                return rs.getInt(1);
            }
            return 1;
            
        } catch (SQLException ex) {
            Logger.getLogger(SqlUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            return 1;
        } catch(Exception ex) {
            System.err.println("Eror, " + ex);
            return 1;
        }finally {
            try {
                conexion.close();
            } catch(Exception ex) {
                System.err.println("Eror, " + ex);
            }
        }
    }
    
    public boolean inicioSesion(Usuarios usuario){
        
        Connection conexion = getConnection();
        
        try {
            sql = "SELECT usr_id_usuario, usr_nombre_usuario, usr_contrasenia, usr_ultimo_inicio, pers_nombre, pers_apaterno FROM usuario u INNER JOIN persona p ON " +
                    "u.usr_id_persona = p.pers_id_persona WHERE usr_nombre_usuario = ? ";
            
            ps = conexion.prepareStatement(sql);
            ps.setString(1, usuario.getUsuario());
            rs = ps.executeQuery();
            
            if (rs.next()){
                if(usuario.getContrasenia().equals(rs.getString(3))){
                    
                    usuario.setIdUsr(rs.getInt(1));
                    usuario.setUsuario(rs.getString(2));
                    usuario.setUltimoInicio(rs.getString(4));
                    usuario.setPersNombre(rs.getString(5));
                    usuario.setPersApPaterno(rs.getString(6));
                    
                    String sqlUpdate = "UPDATE usuario SET usr_ultimo_inicio = ? WHERE usr_id_usuario = ?";
                    ps = conexion.prepareStatement(sqlUpdate);
                    ps.setString(1, usuario.getInicioActual());
                    ps.setInt(2, rs.getInt(1));
                    ps.execute();
                    return true;
                    
                } else {
                    return false;
                }
            }
            return false;
            
        } catch (SQLException ex) {
            Logger.getLogger(SqlUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch(Exception ex) {
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
}
