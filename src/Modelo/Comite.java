package Modelo;

import Vista.frmAgregarcomites;
import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
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
    
    public void MostrarComites(JTable tabla) {
        //Creamos una variable de la clase conexión       
        Connection conexion = ClaseConexion.getConexion();
        //Definimos el modelo de la tabla
        DefaultTableModel modeloComite = new DefaultTableModel();
        
        modeloComite.setColumnIdentifiers(new Object[]{"N_Comite", "Nombre", "Descripción", "Cupos"});
        try {
            //Creamos un statement para que se conecte con la base y realice una acción         
            Statement statement = conexion.createStatement();
            
            String sql = "SELECT c.id_comite AS N_Comite, " +
                         "c.comite AS Nombre, " +
                         "c.descripcion AS Descripción, " +
                         "c.cupos AS Cupos " +
                         "FROM Comite c";
            
            //Ejecutamos el Statement con la consulta y lo asignamos a una variable de tipo ResultSet          
            ResultSet rs = statement.executeQuery(sql);
            //Recorremos el ResultSet
            while (rs.next()) {
                //Llenamos el modelo por cada vez que recorremos el resultSet
                modeloComite.addRow(new Object[]{
                    rs.getString("N_Comite"), 
                    rs.getString("Nombre"), 
                    rs.getString("Descripción"),
                    rs.getString("Cupos")
                });
            }
            //Asignamos el nuevo modelo lleno a la tabla
            tabla.setModel(modeloComite);
        } catch (Exception e) {
            System.out.println("Este es el error en el metodo mostrar comites " + e);
        }
    }
    
    //MÃ©todo Cargar Datos en la tabla
    
    public void cargarDatosTabla(frmAgregarcomites vista) {
        
        // Obtenemos la fila seleccionada
        int filaSeleccionada = vista.jtbComites.getSelectedRow();
        
        // Debemos asegurarnos que haya una fila seleccionada antes de acceder a sus valores
        if (filaSeleccionada != -1) {
            String id_comite = vista.jtbComites.getValueAt(filaSeleccionada, 0).toString();
            String comite = vista.jtbComites.getValueAt(filaSeleccionada, 1).toString();
            String descripcion = (vista.jtbComites.getValueAt(filaSeleccionada, 2).toString());
            String cupos = vista.jtbComites.getValueAt(filaSeleccionada, 3).toString();

            // Establece los valores en los campos de texto
            
            vista.txtNombrecomite.setText(comite);
            vista.txtDescripcioncomite.setText(descripcion);
            vista.txtCupos.setText(String.valueOf(cupos));
            
        }
    }
    
    //Método Buscar evento
    
    public void Buscarcomites(JTable tabla, JTextField txtBuscarcomite) {
        //Creamos una variable igual a ejecutar el método de la clase de conexión
        Connection conexion = ClaseConexion.getConexion();

        //Definimos el modelo de la tabla
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"N_Comité", "Comité", "Descripción", "Cupos"});
        
        try {
            
            String sql = "SELECT c.id_comite AS N_Comité, " +
                         "c.comite AS Comité, " +
                         "c.descripcion AS Descripción, " +
                         "c.cupos AS Cupos " +
                         "FROM Comite c " +
                         "WHERE c.comite LIKE ? || '%'";
            
            PreparedStatement deleteEstudiante = conexion.prepareStatement(sql);
            deleteEstudiante.setString(1, txtBuscarcomite.getText());
            ResultSet rs = deleteEstudiante.executeQuery();

            while (rs.next()) {
                //Llenamos el modelo por cada vez que recorremos el resultSet
                modelo.addRow(new Object[]{
                    rs.getInt("N_Comité"), 
                    rs.getString("Comité"), 
                    rs.getString("Descripción"), 
                    rs.getInt("Cupos")});
            }

            //Asignamos el nuevo modelo lleno a la tabla
            tabla.setModel(modelo);
            tabla.getColumnModel().getColumn(0).setMinWidth(0);
            tabla.getColumnModel().getColumn(0).setMaxWidth(0);
            tabla.getColumnModel().getColumn(0).setWidth(0);
            
        } catch (Exception e) {
            System.out.println("Error en metodo buscar comites: " + e);
        }
    }

    // Método Guardar Usuario
    
    public void AgregarComites(){       
        //Creamos una variable igual a ejecutar el método de la clase de conexiÃ³n       
        Connection conexion = ClaseConexion.getConexion();
        try {           
            
            //Creamos el PreparedStatement que ejecutará la Query           
            PreparedStatement newCom = conexion.prepareStatement ("INSERT INTO Comite (comite, descripcion, cupos) VALUES (?, ?, ?)");          
            
            //Establecemos valores de la consulta SQL
            
            newCom.setString (1, getComite());
            newCom.setString (2, getDescripcion());
            newCom.setInt    (3, getCupos());
            
            
            System.out.println("Nombre del comité: " + getComite());            
            System.out.println("Descripción: " + getDescripcion());           
            System.out.println("Cupos: " + getCupos());
            System.out.println("ID del Comité: " + newCom);

            //Ejecutar la consulta
            
            newCom.executeUpdate();

        } 
        
        catch (SQLException ex) {
            System.out.println("este es el error en el metodo Agregar comites: " + ex);
        }
                
    }
    
    // Método para Actualizar comites
    
    public void ActualizarComites(JTable tabla){

        Connection conexion = ClaseConexion.getConexion();

        int filaseleccionada = tabla.getSelectedRow();
        
        if(filaseleccionada != -1){

            int IDcom = Integer.parseInt(tabla.getValueAt(filaseleccionada, 0).toString());
            
            try{
                
                PreparedStatement Updtcom = conexion.prepareStatement("UPDATE Comite set comite =?, descripcion =?, cupos =? WHERE id_comite =?");
                
                Updtcom.setString (1, getComite());
                Updtcom.setString (2, getDescripcion());
                Updtcom.setInt    (3, getCupos());
                Updtcom.setInt    (4, IDcom);
                
                System.out.println("Nombre del comité: " + getComite());            
                System.out.println("Descripción: " + getDescripcion());           
                System.out.println("Cupos: " + getCupos());
                System.out.println("ID del Comité: " + IDcom);
                
                Updtcom.executeUpdate();
            }
            catch(Exception e){
                System.out.println("este es el error en el metodo de Actualizar comites: " + e);
            }
        }
        else {
            System.out.println("no funciona actualizar eventos");
        }

    }
    
    // Método Eliminar Comité solo para volver a empezar
    
    public void BETAEliminarComite(JTable tabla){
        
        Connection conexion = ClaseConexion.getConexion();
        
        int filaSeleccionada = tabla.getSelectedRow();
        
        String miId = tabla.getValueAt(filaSeleccionada, 0).toString();
        
        //Eliminamos al usuario 
        
        try{
            PreparedStatement BETAdeleteCOM = conexion.prepareStatement("DELETE FROM Comite WHERE id_comite =?");
            BETAdeleteCOM.setString(1, miId);
            BETAdeleteCOM.executeUpdate();
        }
        catch(Exception e){
            System.out.println("este es el error en la beta del método eliminar comite: " + e);
        }
    }
    
    
}
