package Modelo;

import Vista.frmAgregarhoras;
import Vista.frmAgregarhorascoordi;
import java.sql.*;
import java.util.UUID;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Expediente {
    
    String UUID_expediente;
    String UUID_Usuario;
    String nombre_evento;
    int horas_agregadas;

    public String getUUID_expediente() {
        return UUID_expediente;
    }

    public void setUUID_expediente(String UUID_expediente) {
        this.UUID_expediente = UUID_expediente;
    }

    public String getUUID_Usuario() {
        return UUID_Usuario;
    }

    public void setUUID_Usuario(String UUID_Usuario) {
        this.UUID_Usuario = UUID_Usuario;
    }

    public String getNombre_evento() {
        return nombre_evento;
    }

    public void setNombre_evento(String nombre_evento) {
        this.nombre_evento = nombre_evento;
    }

    public int getHoras_agregadas() {
        return horas_agregadas;
    }

    public void setHoras_agregadas(int horas_agregadas) {
        this.horas_agregadas = horas_agregadas;
    }
    
    
    //Método Mostrar datos en la tabla
    
    public void Mostrar(JTable tabla) {
        //Creamos una variable de la clase conexión       
        Connection conexion = ClaseConexion.getConexion();
        
        //Definimos el modelo de la tabla
        DefaultTableModel modeloExpedientes = new DefaultTableModel();
        
        modeloExpedientes.setColumnIdentifiers(new Object[]{"Expediente", "Usuario", "Evento", "Horas_Agregadas"});
        
        try {
            //Creamos un statement para que se conecte con la base y realice una acción         
            Statement statement = conexion.createStatement();
            
            String sql = "SELECT u.nombre AS Usuario, "
                       + "ex.UUID_expediente AS Expediente, "
                       + "ex.nombre_evento AS Evento, "
                       + "ex.horas_agregadas AS Horas_Agregadas " +
                         "FROM Expediente ex " +
                         "LEFT JOIN Usuario u ON ex.UUID_Usuario = u.UUID_Usuario";
            
            //Ejecutamos el Statement con la consulta y lo asignamos a una variable de tipo ResultSet          
            ResultSet rs = statement.executeQuery(sql);
            
            //Recorremos el ResultSet
            while (rs.next()) {
                //Llenamos el modelo por cada vez que recorremos el resultSet
                modeloExpedientes.addRow(new Object[]{
                    rs.getString("Expediente"), 
                    rs.getString("Usuario"), 
                    rs.getString("Evento"),
                    rs.getString("Horas_Agregadas")
                    });
            }
            
            //Asignamos el nuevo modelo lleno a la tabla
            tabla.setModel(modeloExpedientes);
            
        } catch (Exception e) {
            System.out.println("Este es el error en el metodo mostrar expedientes: " + e);
        }
    }
    
    //Método Cargar Datos en la tabla
    
    public void cargarDatosTabla(frmAgregarhoras vista) {
        
        // Obtenemos la fila seleccionada
        int filaSeleccionada = vista.jtbAlumnos.getSelectedRow();
        
        // Debemos asegurarnos que haya una fila seleccionada antes de acceder a sus valores
        if (filaSeleccionada != -1) {
            String UUID_expediente = vista.jtbAlumnos.getValueAt(filaSeleccionada, 0).toString();
            String UUID_Usuario = vista.jtbAlumnos.getValueAt(filaSeleccionada, 1).toString();
            String nombre_evento = vista.jtbAlumnos.getValueAt(filaSeleccionada, 2).toString();
            String horas_agregadas = vista.jtbAlumnos.getValueAt(filaSeleccionada, 3).toString();

            // Establece los valores en los campos de texto
            
            vista.txtNombredelevento.setText(nombre_evento);
            vista.cbAlumnos.setSelectedItem(UUID_Usuario);
            vista.txtCantidadhoras.setText(String.valueOf(horas_agregadas));

        }
    }
    
    //Método Cargar Datos en la tabla expedientes del coordinador
    
    public void cargarDatosTablacoordi(frmAgregarhorascoordi vista) {
        
        // Obtenemos la fila seleccionada
        int filaSeleccionada = vista.jtbAlumnos.getSelectedRow();
        
        // Debemos asegurarnos que haya una fila seleccionada antes de acceder a sus valores
        if (filaSeleccionada != -1) {
            String UUID_expediente = vista.jtbAlumnos.getValueAt(filaSeleccionada, 0).toString();
            String UUID_Usuario = vista.jtbAlumnos.getValueAt(filaSeleccionada, 1).toString();
            String nombre_evento = vista.jtbAlumnos.getValueAt(filaSeleccionada, 2).toString();
            String horas_agregadas = vista.jtbAlumnos.getValueAt(filaSeleccionada, 3).toString();

            // Establece los valores en los campos de texto
            
            vista.txtNombredelevento.setText(nombre_evento);
            vista.cbAlumnos.setSelectedItem(UUID_Usuario);
            vista.txtCantidadhoras.setText(String.valueOf(horas_agregadas));

        }
    }
    
    
    // Método Guardar historial alumno
    
    public void Guardarhistorialalumno(){       
    // Creamos una variable igual a ejecutar el método de la clase de conexión       
    Connection conexion = ClaseConexion.getConexion();
    
    try {         
        
        // Creamos el PreparedStatement que ejecutará la Query           
        PreparedStatement newUs = conexion.prepareStatement("INSERT INTO Expediente (UUID_Usuario, nombre_evento, horas_agregadas) Values (?, ?, ?)");          
        
        newUs.setString (1, getUUID_Usuario());
        newUs.setString (2, getNombre_evento());
        newUs.setInt    (3, getHoras_agregadas());
        
        // Ejecutar la consulta            
        newUs.executeUpdate();
        
    } catch (SQLException ex) {
    System.out.println("Este es el error en el método guardar historial: " + ex );
}
}

    
    // Método Actualizar Horas
    
    public void Actualizarhoras(JTable tabla){

        Connection conexion = ClaseConexion.getConexion();

        int filaseleccionada = tabla.getSelectedRow();
        
        if(filaseleccionada != -1){

            String UUIDexp = tabla.getValueAt(filaseleccionada, 0).toString();
            
            try{
                
                PreparedStatement UpdtExp = conexion.prepareStatement("UPDATE Expediente set UUID_Usuario =?, nombre_evento =?, horas_agregadas =? WHERE UUID_Expediente =?");
                
                UpdtExp.setString (1, getUUID_Usuario());
                UpdtExp.setString (2, getNombre_evento());
                UpdtExp.setInt    (3, getHoras_agregadas());
                UpdtExp.setString (4, UUIDexp);
                
                System.out.println("Nombre del evento: " + getNombre_evento());            
                System.out.println("Horas agregadas: " + getHoras_agregadas());           
                System.out.println("UUID del Usuario: " + getUUID_Usuario());
                System.out.println("ID del Comité: " + UUIDexp);
                
                UpdtExp.executeUpdate();
            }
            catch(Exception e){
                System.out.println("este es el error en el metodo de Actualizar expediente: " + e);
            }
        }
        else {
            System.out.println("no funciona actualizar Expediente");
        }

    }
    
    public void Eliminarexpediente (JTable tabla){
        
        Connection conexion = ClaseConexion.getConexion();
        
        int filaSeleccionada = tabla.getSelectedRow();
        
        String miId = tabla.getValueAt(filaSeleccionada, 0).toString();
        
        //Eliminamos al usuario 
        
        try{
            PreparedStatement Deleteexp = conexion.prepareStatement("DELETE FROM Expediente WHERE UUID_Expediente =?");
            Deleteexp.setString(1, miId);
            Deleteexp.executeUpdate();
        }
        catch(Exception e){
            System.out.println("este es el error en la beta del método eliminar expediente: " + e);
        }
    }
    
    public void BuscarAlumno(JTable tabla, JTextField miTextField) {
        
        //Creamos una variable igual a ejecutar el método de la clase de conexión
        Connection conexion = ClaseConexion.getConexion();

        //Definimos el modelo de la tabla
        DefaultTableModel modelo = new DefaultTableModel();
        
        modelo.setColumnIdentifiers(new Object[]{"Expediente", "Alumno", "Evento", "Horas_Agregadas"});
        
        try {
            
            String sql = "SELECT u.nombre AS Alumno, "
                       + "ex.UUID_expediente AS Expediente, "
                       + "ex.nombre_evento AS Evento, "
                       + "ex.horas_agregadas AS Horas_Agregadas " +
                         "FROM Expediente ex " +
                         "LEFT JOIN Usuario u ON ex.UUID_Usuario = u.UUID_Usuario " +
                         "WHERE u.nombre LIKE ? || '%'";
            
            
            PreparedStatement buscarAlumno = conexion.prepareStatement(sql);
            
            buscarAlumno.setString(1, miTextField.getText());
           
            
            ResultSet rs = buscarAlumno.executeQuery();

            while (rs.next()) {
                //Llenamos el modelo por cada vez que recorremos el resultSet
                
                modelo.addRow(new Object[]{
                    rs.getString("Expediente"), 
                    rs.getString("Alumno"), 
                    rs.getString("Evento"), 
                    rs.getString("Horas_Agregadas")
                });
            }

            //Asignamos el nuevo modelo lleno a la tabla
            tabla.setModel(modelo);
            tabla.getColumnModel().getColumn(0).setMinWidth(0);
            tabla.getColumnModel().getColumn(0).setMaxWidth(0);
            tabla.getColumnModel().getColumn(0).setWidth(0);
            
        } catch (Exception e) {
            System.out.println("Error en metodo buscar alumnos: " + e);
        }
    }
}
