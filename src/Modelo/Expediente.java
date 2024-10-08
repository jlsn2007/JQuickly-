package Modelo;

import java.sql.*;
import java.util.UUID;

public class Expediente {
    
    String UUID_expediente;
    String UUID_Evento;
    String nombre_evento;
    String horas_agregadas;

    public String getUUID_expediente() {
        return UUID_expediente;
    }

    public void setUUID_expediente(String UUID_expediente) {
        this.UUID_expediente = UUID_expediente;
    }

    public String getUUID_Evento() {
        return UUID_Evento;
    }

    public void setUUID_Evento(String UUID_Evento) {
        this.UUID_Evento = UUID_Evento;
    }

    public String getNombre_evento() {
        return nombre_evento;
    }

    public void setNombre_evento(String nombre_evento) {
        this.nombre_evento = nombre_evento;
    }

    public String getHoras_agregadas() {
        return horas_agregadas;
    }

    public void setHoras_agregadas(String horas_agregadas) {
        this.horas_agregadas = horas_agregadas;
    }
}
