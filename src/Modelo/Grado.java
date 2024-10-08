package Modelo;

import java.sql.*;
import javax.swing.JComboBox;

public class Grado {
    
    int id_grado;
    String grado;
    

    public int getId_grado() {
        return id_grado;
    }

    public void setId_grado(int id_grado) {
        this.id_grado = id_grado;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }
    
    
    //Extras combobox Grado
    
     public Grado(){
    
    }
    
    public Grado(int id_grado, String grado) {
        this.id_grado = id_grado;
        this.grado = grado;
    }
    
    @Override
    public String toString() {
        return grado; 
    }
    
    
    public void CargarComboboxGrados(JComboBox comboBox) {
    Connection conexion = ClaseConexion.getConexion();
    comboBox.removeAllItems();
    
    try {
        Statement statement = conexion.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM Grado");
        
        while (rs.next()) {
            int id = rs.getInt("id_grado");
            String grado = rs.getString("grado");
            comboBox.addItem(new Grado(id, grado)); 
        }
        
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
    
}