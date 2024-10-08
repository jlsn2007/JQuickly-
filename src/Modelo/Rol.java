package Modelo;

import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Rol {
    
    private int id_rol;
    private String tipo_rol;

    public int getId_rol() {
        return id_rol;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    public String getTipo_rol() {
        return tipo_rol;
    }

    public void setTipo_rol(String tipo_rol) {
        this.tipo_rol = tipo_rol;
    }
    
    //Extras combobox
    
    public Rol(){
    
    }
    
    public Rol (int id_rol, String tipo_rol){
        this.id_rol= id_rol;
        this.tipo_rol= tipo_rol;
    }
    
    @Override
    public String toString(){
    return tipo_rol;
    }
    
    public void CargarComboboxRoles(JComboBox comboBox) {
    Connection conexion = ClaseConexion.getConexion();
    comboBox.removeAllItems();
   
    try {
        Statement statement = conexion.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM Rol");
        
        while (rs.next()) {
            int id = rs.getInt("id_rol");
            String tipoRol = rs.getString("tipo_rol");
            comboBox.addItem(new Rol(id, tipoRol)); 
        }
        
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
}

