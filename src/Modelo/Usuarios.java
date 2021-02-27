
package Modelo;

public class Usuarios extends Personas{

    private int idUsr;
    private String usuario;
    private String contrasenia;
    private String ultimoInicio;
    private String inicioActual;  
    
       
    public Usuarios(int idUsr, String usuario, String contrasenia, String ultimoInicio, int idPersona, String persNombre, String persApPaterno, String persApMaterno) {
        super(idPersona, persNombre, persApPaterno, persApMaterno);
        this.idUsr = idUsr;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.ultimoInicio = ultimoInicio;
    }

    public Usuarios() {
        
    }
    
    public void setIdUsr(int idUsr) {
        this.idUsr = idUsr;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public void setUltimoInicio(String ultimoInicio) {
        this.ultimoInicio = ultimoInicio;
    }

    public String getInicioActual() {
        return inicioActual;
    }

    public void setInicioActual(String inicioActual) {
        this.inicioActual = inicioActual;
    }
    
    public int getIdUsr() {
        return idUsr;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public String getUltimoInicio() {
        return ultimoInicio;
    }    
    
}
