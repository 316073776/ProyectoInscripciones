
package Modelo;

import java.sql.Time;

public class Horarios /*extends Grupos*/{
    
    private String idSalon;
    private String grupoClave;
    private int idDia;
    private int idHora;
    private int idHorario;
    private char edificio;
    private String piso;
    private String dia;
    private Time horaInicio;
    private Time horaFin;

    public Horarios (){
        
    }
    
    public Horarios(String idSalon, String grupoClave, int idDia, int idHora) {
        this.idSalon = idSalon;
        this.grupoClave = grupoClave;
        this.idDia = idDia;
        this.idHora = idHora;
    }
    
    public Horarios(int idHorario, int idDia, int idHora, String idSalon, char edificio, String piso, String dia, Time horaInicio, Time horaFin, String grupoClave){
        this.idHorario = idHorario;
        this.idDia = idDia;
        this.idHora = idHora;
        this.idSalon = idSalon;
        this.edificio = edificio;
        this.piso = piso;
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.grupoClave = grupoClave;
    }
    
    public String getIdSalon() {
        return idSalon;
    }

    public void setIdSalon(String idSalon) {
        this.idSalon = idSalon;
    }

    public String getGrupoClave() {
        return grupoClave;
    }

    public void setGrupoClave(String grupoClave) {
        this.grupoClave = grupoClave;
    }

    public int getIdDia() {
        return idDia;
    }

    public void setIdDia(int idDia) {
        this.idDia = idDia;
    }

    public int getIdHora() {
        return idHora;
    }

    public void setIdHora(int idHora) {
        this.idHora = idHora;
    }

    public int getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(int idHorario) {
        this.idHorario = idHorario;
    }

    public char getEdificio() {
        return edificio;
    }

    public void setEdificio(char edificio) {
        this.edificio = edificio;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public Time getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Time horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Time getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Time horaFin) {
        this.horaFin = horaFin;
    }
    
    
    
}
