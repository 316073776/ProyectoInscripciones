
package Modelo;

public class Personas {
    
    private int idPersona;
    private String persNombre;
    private String persApPaterno;
    private String persApMaterno;

    public Personas(int idPersona, String persNombre, String persApPaterno, String persApMaterno) {
        this.idPersona = idPersona;
        this.persNombre = persNombre;
        this.persApPaterno = persApPaterno;
        this.persApMaterno = persApMaterno;
    }

    public Personas() {
        
    }
    
    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public void setPersNombre(String persNombre) {
        this.persNombre = persNombre;
    }

    public void setPersApPaterno(String persApPaterno) {
        this.persApPaterno = persApPaterno;
    }

    public void setPersApMaterno(String persApMaterno) {
        this.persApMaterno = persApMaterno;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public String getPersNombre() {
        return persNombre;
    }

    public String getPersApPaterno() {
        return persApPaterno;
    }

    public String getPersApMaterno() {
        return persApMaterno;
    }
    
    
}
