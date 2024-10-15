package Modelo;

import Vista.frmAgregareventos;
import Vista.frmAgregareventoscoordi;
import java.sql.*;
import java.util.UUID;
import javax.swing.JTable;
import javax.swing.JTextField;
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
    
    /*//Método cargar combobox eventos
   
    public Eventos(){
    
    }
    
    public Eventos (String uuidev, String nombreev){
        this.UUID_Evento = uuidev;
        this.nombre = nombreev;
    }
    
    @Override
    public String toString(){
        return nombre;
    }
    
    public void CargarComboboxEventos (JComboBox comboBox) {
    
    Connection conexion = ClaseConexion.getConexion();
    
    comboBox.removeAllItems();
   
    try {
        Statement statement = conexion.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM Eventos");
        
        while (rs.next()) {
            String uuidev = rs.getString("UUID_Evento");
            String nombreev = rs.getString("nombre");
            comboBox.addItem(new Eventos(uuidev, nombreev)); 
        }
        
    } catch (SQLException e) {
        e.printStackTrace();
    }
    }*/
    
    
    //Método Buscar evento
    
    public void BuscarEventos(JTable tabla, JTextField txtBuscarev) {
        //Creamos una variable igual a ejecutar el método de la clase de conexión
        Connection conexion = ClaseConexion.getConexion();

        //Definimos el modelo de la tabla
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"Identificador", "Anfitrión", "Lugar", "Descripcion", "Evento", "Fecha", "Hora"});
        try {
            
            String sql = "SELECT e.UUID_Evento AS Identificador, " +
                     "u.nombre AS Anfitrión, " +
                     "e.lugar AS Lugar, " +
                     "e.descripcion AS Descripcion, " +
                     "e.nombre AS Evento, " +
                     "e.fecha AS Fecha, " +
                     "e.hora AS Hora " +
                     "FROM Eventos e " +
                     "LEFT JOIN Usuario u ON e.UUID_Usuario = u.UUID_Usuario " +
                     "WHERE e.nombre LIKE ? || '%'";
            
            PreparedStatement deleteEstudiante = conexion.prepareStatement(sql);
            deleteEstudiante.setString(1, txtBuscarev.getText());
            ResultSet rs = deleteEstudiante.executeQuery();

            while (rs.next()) {
                //Llenamos el modelo por cada vez que recorremos el resultSet
                modelo.addRow(new Object[]{
                    rs.getString("Identificador"),
                    rs.getString("Anfitrión"), 
                    rs.getString("Lugar"),
                    rs.getString("Descripcion"),
                    rs.getString("Evento"),
                    rs.getString("Fecha"), 
                    rs.getString("Hora")
                });
            }

            //Asignamos el nuevo modelo lleno a la tabla
            tabla.setModel(modelo);
            tabla.getColumnModel().getColumn(0).setMinWidth(0);
            tabla.getColumnModel().getColumn(0).setMaxWidth(0);
            tabla.getColumnModel().getColumn(0).setWidth(0);
            
        } catch (Exception e) {
            System.out.println("Error en metodo buscar eventos: " + e);
        }
    }

    // Método Guardar Usuario
    
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
        DefaultTableModel modeloEventos = new DefaultTableModel();
        
        modeloEventos.setColumnIdentifiers(new Object[]{"Identificador", "Anfitrión", "Lugar", "Descripcion", "Evento", "Fecha", "Hora"});
        
        try {
            //Creamos un statement para que se conecte con la base y realice una acción         
            Statement statement = conexion.createStatement();
            
            String sql = "SELECT e.UUID_Evento AS Identificador, " +
                         "u.nombre AS Anfitrión, " +
                         "e.lugar AS Lugar, " +
                         "e.descripcion AS Descripcion, " +
                         "e.nombre AS Evento, " +
                         "e.fecha AS Fecha, " +
                         "e.hora AS Hora " +
                         "FROM Eventos e " +
                         "LEFT JOIN Usuario u ON e.UUID_Usuario = u.UUID_Usuario";
            
            //Ejecutamos el Statement con la consulta y lo asignamos a una variable de tipo ResultSet          
            ResultSet rs = statement.executeQuery(sql);
            //Recorremos el ResultSet
            while (rs.next()) {
                //Llenamos el modelo por cada vez que recorremos el resultSet
                modeloEventos.addRow(new Object[]{
                    rs.getString("Identificador"),
                    rs.getString("Anfitrión"), 
                    rs.getString("Lugar"),
                    rs.getString("Descripcion"),
                    rs.getString("Evento"),
                    rs.getString("Fecha"), 
                    rs.getString("Hora")});
            }
            //Asignamos el nuevo modelo lleno a la tabla
            tabla.setModel(modeloEventos);
        } catch (Exception e) {
            System.out.println("Este es el error en el modelo, metodo mostrar eventos " + e);
        }
    }
    
    //Método Cargar Datos en la tabla
    
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
            
            vista.cbUsuarios.setSelectedItem(UUID_Usuario);
            vista.txtLugar.setText(lugar);
            vista.txtDescripcion.setText(descripcion);
            vista.txtNombreevento.setText(nombre);
            vista.txtFecha.setText(fecha);
            vista.txtHora.setText(hora);
            
        }
    }
    
    //Método Cargar Datos en la tabla eventos del coordinador
    
    public void cargarDatosTablacoordi(frmAgregareventoscoordi vista) {
        
        // ObtÃ©n la fila seleccionada
        int filaSeleccionada = vista.jtbEventosc.getSelectedRow();
        
        // Debemos asegurarnos que haya una fila seleccionada antes de acceder a sus valores
        if (filaSeleccionada != -1) {
            String UUID_Evento = vista.jtbEventosc.getValueAt(filaSeleccionada, 0).toString();
            String UUID_Usuario = vista.jtbEventosc.getValueAt(filaSeleccionada, 1).toString();
            String lugar = (vista.jtbEventosc.getValueAt(filaSeleccionada, 2).toString());
            String descripcion = (vista.jtbEventosc.getValueAt(filaSeleccionada, 3).toString());
            String nombre = (vista.jtbEventosc.getValueAt(filaSeleccionada, 4).toString());
            String fecha = vista.jtbEventosc.getValueAt(filaSeleccionada, 5).toString();
            String hora = vista.jtbEventosc.getValueAt(filaSeleccionada, 6).toString();

            // Establece los valores en los campos de texto
            
            vista.cbUsuarios.setSelectedItem(UUID_Usuario);
            vista.txtLugar.setText(lugar);
            vista.txtDescripcion.setText(descripcion);
            vista.txtNombreevento.setText(nombre);
            vista.txtFecha.setText(fecha);
            vista.txtHora.setText(hora);
            
        }
    }
}

