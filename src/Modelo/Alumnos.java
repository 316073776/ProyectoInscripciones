
package Modelo;

public class Alumnos extends Personas{
    
    private int idAlumno;
    private String numCuenta;
    private int generacion;

    public Alumnos() {
    }
    
       
    public Alumnos(int idAlumno, String numCuenta, int generacion, int idPersona, String persNombre, String persApPaterno, String persApMaterno) {
        super(idPersona, persNombre, persApPaterno, persApMaterno);
        this.idAlumno = idAlumno;
        this.numCuenta = numCuenta;
        this.generacion = generacion;
    }


    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public void setGeneracion(int generacion) {
        this.generacion = generacion;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public String getNumCuenta() {
        return numCuenta;
    }

    public int getGeneracion() {
        return generacion;
    }
    
    
    
}
