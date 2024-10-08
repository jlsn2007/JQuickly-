package Modelo;

import java.sql.*;
import javax.swing.JComboBox;

public class Comite {
    
    int id_comite;
    String comite;
    String descripcion;
    int cupos;

    
    public int getId_comite() {
        return id_comite;
    }

    public void setId_comite(int id_comite) {
        this.id_comite = id_comite;
    }

    public String getComite() {
        return comite;
    }

    public void setComite(String comite) {
        this.comite = comite;
    }

    public String getDescripcio() {
        return descripcion;
    }

    public void setDescripcio(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCupos() {
        return cupos;
    }

    public void setCupos(int cupos) {
        this.cupos = cupos;
    }
    
    //Extras combobox
    
    public Comite(){
    
    }
    
    public Comite(int id_comite, String comite) {
    this.id_comite = id_comite;
    this.comite = comite;
    }
    
    @Override
    public String toString() {
        return comite; 
    }
    
    public void CargarComboboxComites(JComboBox comboBox) {
    Connection conexion = ClaseConexion.getConexion();
    comboBox.removeAllItems();
    
    try {
        Statement statement = conexion.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM Comite");
        
        while (rs.next()) {
            int id = rs.getInt("id_comite");
            String comite = rs.getString("comite");
            comboBox.addItem(new Comite(id, comite)); 
        }
        
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
    
}
