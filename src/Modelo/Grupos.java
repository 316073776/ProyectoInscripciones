
package Modelo;

import java.sql.Date;

public class Grupos {
    
    private String idAsignatura;
    private String nomAsignatura;
    private String planEstudios;
    private String idPriodo;
    private Date fechaInicioPer;
    private Date fechaFinPer;
    private boolean estadoPer;
    private int idGrupo;
    private String grupoClave;
    private int cupo;
    private String claveProfesor;

    
    public Grupos(){
        
    }
    
    public Grupos(String idAsignatura, String nomAsignatura, String planEstudios, String idPriodo, Date fechaInicioPer, Date fechaFinPer, boolean estadoPer, int idGrupo, String grupoClave, int cupo, String claveProfesor) {
        this.idAsignatura = idAsignatura;
        this.nomAsignatura = nomAsignatura;
        this.planEstudios = planEstudios;
        this.idPriodo = idPriodo;
        this.fechaInicioPer = fechaInicioPer;
        this.fechaFinPer = fechaFinPer;
        this.estadoPer = estadoPer;
        this.idGrupo = idGrupo;
        this.grupoClave = grupoClave;
        this.cupo = cupo;
        this.claveProfesor = claveProfesor;
    }
    
    public Grupos(String idPriodo, Date fechaInicioPer, Date fechaFinPer, boolean estadoPer) {
        this.idPriodo = idPriodo;
        this.fechaInicioPer = fechaInicioPer;
        this.fechaFinPer = fechaFinPer;
        this.estadoPer = estadoPer;
    }

    public Grupos(String idAsignatura, String nomAsignatura, String planEstrudios) {
        this.idAsignatura = idAsignatura;
        this.nomAsignatura = nomAsignatura;
        this.planEstudios = planEstrudios;
    }
    
    

    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }

    public String getGrupoClave() {
        return grupoClave;
    }

    public void setGrupoClave(String grupoClave) {
        this.grupoClave = grupoClave;
    }

    public int getCupo() {
        return cupo;
    }

    public void setCupo(int cupo) {
        this.cupo = cupo;
    }

    public String getClaveProfesor() {
        return claveProfesor;
    }

    public void setClaveProfesor(String claveProfesor) {
        this.claveProfesor = claveProfesor;
    }

    
    public String getIdPriodo() {
        return idPriodo;
    }

    public void setIdPriodo(String idPriodo) {
        this.idPriodo = idPriodo;
    }

    public Date getFechaInicioPer() {
        return fechaInicioPer;
    }

    public void setFechaInicioPer(Date fechaInicioPer) {
        this.fechaInicioPer = fechaInicioPer;
    }

    public Date getFechaFinPer() {
        return fechaFinPer;
    }

    public void setFechaFinPer(Date fechaFinPer) {
        this.fechaFinPer = fechaFinPer;
    }

    public boolean isEstadoPer() {
        return estadoPer;
    }

    public void setEstadoPer(boolean estadoPer) {
        this.estadoPer = estadoPer;
    }
    
    public String getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(String idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    public String getNomAsignatura() {
        return nomAsignatura;
    }

    public void setNomAsignatura(String nomAsignatura) {
        this.nomAsignatura = nomAsignatura;
    }

    public String getPlanEstudios() {
        return planEstudios;
    }

    public void setPlanEstudios(String planEstrudios) {
        this.planEstudios = planEstrudios;
    }

    
    
    
}
