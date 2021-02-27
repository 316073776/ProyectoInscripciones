
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conection {
    
    private static final String URL = "jdbc:postgresql://localhost:5432/Inscripciones";
    private static final String USERNAME = "rdbms";
    private static final String PASSWD = "rbms2021**";
    
    public Connection getConnection(){
        
        Connection conexion = null;
        
        try {
            
            Class.forName("org.postgresql.Driver");
            conexion = DriverManager.getConnection(URL, USERNAME, PASSWD);
            
        } catch (ClassNotFoundException | SQLException ex){
            
            System.out.println("Error de conexión" + ex.getMessage());
        }
        
        return conexion;
    }
}
