
package Modelo;

public class Profesores extends Personas{
    
    private int idProfesor;
    private String numTrabajador;
    private String cedula;
    private char grado;
    
    public Profesores(){
        
    }
    
    public Profesores(int idProfesor, String numTrabajador, String cedula, char grado, int idPersona, String persNombre, String persApPaterno, String persApMaterno) {
        super(idPersona, persNombre, persApPaterno, persApMaterno);
        this.idProfesor = idProfesor;
        this.numTrabajador = numTrabajador;
        this.cedula = cedula;
        this.grado = grado;
    }

    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }

    public void setNumTrabajador(String numTrabajador) {
        this.numTrabajador = numTrabajador;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setGrado(char grado) {
        this.grado = grado;
    }

    public int getIdProfesor() {
        return idProfesor;
    }

    public String getNumTrabajador() {
        return numTrabajador;
    }

    public String getCedula() {
        return cedula;
    }

    public char getGrado() {
        return grado;
    }
    
    
}
