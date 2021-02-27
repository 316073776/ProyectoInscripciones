
package Modelo;

import java.sql.Date;
import java.sql.Time;

public class Inscripciones {
    
    private int idAlumno;
    private int idGrupo;
    private String cuentaAlumno;
    private String claveGrupo;
    private Time horaInscripcion;
    private Date fechaInscripcion;
    private String ipHost;

    public Inscripciones(){
        
    }
    
    public Inscripciones(int idAlumno, int idGrupo, String cuentaAlumno, String claveGrupo) {
        this.idAlumno = idAlumno;
        this.idGrupo = idGrupo;
        this.cuentaAlumno = cuentaAlumno;
        this.claveGrupo = claveGrupo;
    }
    
    public Inscripciones(int idAlumno, int idGrupo, String cuentaAlumno, String claveGrupo, Time horaInscripcion, Date fechaInscripcion, String ipHost) {
        this.idAlumno = idAlumno;
        this.idGrupo = idGrupo;
        this.cuentaAlumno = cuentaAlumno;
        this.claveGrupo = claveGrupo;
        this.horaInscripcion = horaInscripcion;
        this.fechaInscripcion = fechaInscripcion;
        this.ipHost = ipHost;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }

    public String getCuentaAlumno() {
        return cuentaAlumno;
    }

    public void setCuentaAlumno(String cuentaAlumno) {
        this.cuentaAlumno = cuentaAlumno;
    }

    public String getClaveGrupo() {
        return claveGrupo;
    }

    public void setClaveGrupo(String claveGrupo) {
        this.claveGrupo = claveGrupo;
    }

    public Time getHoraInscripcion() {
        return horaInscripcion;
    }

    public void setHoraInscripcion(Time horaInscripcion) {
        this.horaInscripcion = horaInscripcion;
    }

    public Date getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(Date fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public String getIpHost() {
        return ipHost;
    }

    public void setIpHost(String ipHost) {
        this.ipHost = ipHost;
    }
    
    
}
