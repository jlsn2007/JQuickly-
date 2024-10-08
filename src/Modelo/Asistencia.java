package Modelo;

import java.sql.*;
import java.util.UUID;

public class Asistencia {
    
    String UUID_asistencia;
    String hora_de_entrada;
    String hora_de_salida;
    String asistencia_total;
    String UUID_Evento;

    public String getUUID_asistencia() {
        return UUID_asistencia;
    }

    public void setUUID_asistencia(String UUID_asistencia) {
        this.UUID_asistencia = UUID_asistencia;
    }

    public String getHora_de_entrada() {
        return hora_de_entrada;
    }

    public void setHora_de_entrada(String hora_de_entrada) {
        this.hora_de_entrada = hora_de_entrada;
    }

    public String getHora_de_salida() {
        return hora_de_salida;
    }

    public void setHora_de_salida(String hora_de_salida) {
        this.hora_de_salida = hora_de_salida;
    }

    public String getAsistencia_total() {
        return asistencia_total;
    }

    public void setAsistencia_total(String asistencia_total) {
        this.asistencia_total = asistencia_total;
    }

    public String getUUID_Evento() {
        return UUID_Evento;
    }

    public void setUUID_Evento(String UUID_Evento) {
        this.UUID_Evento = UUID_Evento;
    }
  
}
