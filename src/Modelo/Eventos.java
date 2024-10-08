package Modelo;

import Vista.frmAgregareventos;
import java.sql.*;
import java.util.UUID;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Eventos {
    
    String UUID_Evento;
    String UUID_Usuario;
    String lugar;
    String descripcion;
    String nombre;
    String fecha;
    String hora;

    public String getUUID_Evento() {
        return UUID_Evento;
    }

    public void setUUID_Evento(String UUID_Evento) {
        this.UUID_Evento = UUID_Evento;
    }

    public String getUUID_Usuario() {
        return UUID_Usuario;
    }

    public void setUUID_Usuario(String UUID_Usuario) {
        this.UUID_Usuario = UUID_Usuario;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    
    // MÃ©todo Guardar Usuario
    
    public void Agregarevento(){       
        //Creamos una variable igual a ejecutar el mÃ©todo de la clase de conexiÃ³n       
        Connection conexion = ClaseConexion.getConexion();
        try {           
            //Creamos el PreparedStatement que ejecutarÃ¡ la Query           
            PreparedStatement newEv = conexion.prepareStatement ("Insert into Eventos (UUID_Evento, UUID_Usuario, lugar, descripcion, nombre, fecha, hora) Values (?, ?, ?, ?, ?, ?, ?)");          
            //Establecer valores de la consulta SQL
            newEv.setString (1, UUID.randomUUID().toString());
            newEv.setString (2, getUUID_Usuario());
            newEv.setString (3, getLugar());
            newEv.setString (4, getDescripcion());
            newEv.setString (5, getNombre());
            newEv.setString (6, getFecha());
            newEv.setString (7, getHora());
            
            //Ejecutar la consulta
            
            newEv.executeUpdate();

        } 
        
        catch (SQLException ex) {
            System.out.println("este es el error en el modelo Eventos: metodo guardar evento " + ex) ;
        }
                
    }
    
    // MÃ©todo Actualizar Usuario
    
    public void ActualizarEvento(JTable tabla){
        //Creamos una variable igual a ejecutar el mÃ©todo de la clase de conexiÃ³n
        Connection conexion = ClaseConexion.getConexion();
        //obtenemos que fila seleccionÃ³ el usuario
        int filaseleccionada = tabla.getSelectedRow();
        if(filaseleccionada != -1){
            //Obtenemos el id de la fila seleccionada
            String UUIDev = tabla.getValueAt(filaseleccionada, 0).toString();
            try{
                //Ejecutamos la Query
                PreparedStatement Updtev = conexion.prepareStatement("UPDATE Eventos set UUID_Usuario =?, lugar =?, descripcion =?, nombre =?, fecha =?, hora =? WHERE UUID_Evento =?");
                Updtev.setString(1, getUUID_Usuario());
                Updtev.setString(2, getLugar());
                Updtev.setString (3, getDescripcion());
                Updtev.setString(4, getNombre());
                Updtev.setString(5, getFecha());
                Updtev.setString(6, getHora());
                Updtev.setString(7, UUIDev);
                
                Updtev.executeUpdate();
            }
            catch(Exception e){
                System.out.println("este es el error en el metodo de actualizar eventos " + e);
            }
        }
        else {
            System.out.println("no funciona actualizar eventos");
        }

    }
    
    
    // MÃ©todo Eliminar Usuario
    
    public void EliminarEvento(JTable tabla){
        
        //Creamos una variable igual a ejecutar el mÃ©todo de la clase de conexiÃ³n
        Connection conexion = ClaseConexion.getConexion();
        
        //Obtenemos que fila seleccionÃ³ el usuario
        int filaSeleccionada = tabla.getSelectedRow();
        
        //Obtenemos el id de la fila seleccionada
        String miId = tabla.getValueAt(filaSeleccionada, 0).toString();
        
        //Eliminamos al usuario 
        try{
            PreparedStatement delEv = conexion.prepareStatement("DELETE FROM Eventos WHERE UUID_Evento =?");
            delEv.setString(1, miId);
            
            delEv.executeUpdate();
        }
        catch(Exception e){
            System.out.println("este es el error metodo de eliminar eventos " + e);
        }
    }
    
    //MÃ©todo Mostrar datos en la tabla
    
    public void MostrarEventos(JTable tabla) {
        //Creamos una variable de la clase conexiÃ³n       
        Connection conexion = ClaseConexion.getConexion();
        //Definimos el modelo de la tabla
        DefaultTableModel modeloUsuario = new DefaultTableModel();
        modeloUsuario.setColumnIdentifiers(new Object[]{"UUID_Evento", "UUID_Usuario", "lugar", "descripcion", "nombre", "fecha", "hora"});
        try {
            //Creamos un statement para que se conecte con la base y realice una acciÃ³n         
            Statement statement = conexion.createStatement();
            //Ejecutamos el Statement con la consulta y lo asignamos a una variable de tipo ResultSet          
            ResultSet rs = statement.executeQuery("SELECT * FROM Eventos");
            //Recorremos el ResultSet
            while (rs.next()) {
                //Llenamos el modelo por cada vez que recorremos el resultSet
                modeloUsuario.addRow(new Object[]{rs.getString("UUID_Evento"), 
                    rs.getString("UUID_Usuario"), 
                    rs.getString("lugar"),
                    rs.getString("descripcion"),
                    rs.getString("nombre"),
                    rs.getString("fecha"), 
                    rs.getString("hora")});
            }
            //Asignamos el nuevo modelo lleno a la tabla
            tabla.setModel(modeloUsuario);
        } catch (Exception e) {
            System.out.println("Este es el error en el modelo, metodo mostrar eventos " + e);
        }
    }
    
    //MÃ©todo Cargar Datos en la tabla
    
    public void cargarDatosTabla(frmAgregareventos vista) {
        
        // ObtÃ©n la fila seleccionada
        int filaSeleccionada = vista.jtbEventos.getSelectedRow();
        
        // Debemos asegurarnos que haya una fila seleccionada antes de acceder a sus valores
        if (filaSeleccionada != -1) {
            String UUID_Evento = vista.jtbEventos.getValueAt(filaSeleccionada, 0).toString();
            String UUID_Usuario = vista.jtbEventos.getValueAt(filaSeleccionada, 1).toString();
            String lugar = (vista.jtbEventos.getValueAt(filaSeleccionada, 2).toString());
            String descripcion = (vista.jtbEventos.getValueAt(filaSeleccionada, 3).toString());
            String nombre = (vista.jtbEventos.getValueAt(filaSeleccionada, 4).toString());
            String fecha = vista.jtbEventos.getValueAt(filaSeleccionada, 5).toString();
            String hora = vista.jtbEventos.getValueAt(filaSeleccionada, 6).toString();

            // Establece los valores en los campos de texto
            
            //vista.cbUsuario.setSelectedItem(UUID_Usuario);
            vista.txtLugar.setText(lugar);
            vista.txtDescripcion.setText(descripcion);
            vista.txtNombreevento.setText(nombre);
            vista.txtFecha.setText(fecha);
            vista.txtHora.setText(hora);
            
        }
    }
}

