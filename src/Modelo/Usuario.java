package Modelo;

import Controlador.ctrlRecuperarcontrasena;
import Controlador.ctrlReestablecercontrasena;
import java.sql.*;
import java.util.UUID;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Vista.frmAgregarusuarios;
import Vista.frmMenu;
import Vista.frmMenucoordi;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.JComboBox;
import javax.swing.JTextField;



public class Usuario {
    
    //Parámetros de la tabla Usuarios
    
    private String UUID_Usuario;
    private String nombre;
    private String correo_electronico;
    private String contraseña;
    
    //Parámetros foraneas de la tabla Usuarios
    
    int id_grado;
    int id_rol;
    int id_comite;

    //Getters y Setters
    
    public String getUUID_Usuario() {
        return UUID_Usuario;
    }

    public void setUUID_Usuario(String UUID_Usuario) {
        this.UUID_Usuario = UUID_Usuario;
    }

    public int getId_grado() {
        return id_grado;
    }

    public void setId_grado(int id_grado) {
        this.id_grado = id_grado;
    }

    public int getId_rol() {
        return id_rol;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    public int getId_comite() {
        return id_comite;
    }

    public void setId_comite(int id_comite) {
        this.id_comite = id_comite;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    public Usuario(){
    
    }
    
    public Usuario (String uuidus, String nombre){
        this.UUID_Usuario = uuidus;
        this.nombre = nombre;
    }
    
    @Override
    public String toString(){
        return nombre;
    }
    
    public void CargarComboboxUsuarios (JComboBox comboBox) {
    Connection conexion = ClaseConexion.getConexion();
    comboBox.removeAllItems();
   
    try {
        Statement statement = conexion.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM Usuario WHERE id_rol IN (2, 3)");
        
        while (rs.next()) {
            String uuidus = rs.getString("UUID_Usuario");
            String nombre = rs.getString("nombre");
            comboBox.addItem(new Usuario(uuidus, nombre)); 
        }
        
    } catch (SQLException e) {
        e.printStackTrace();
    }
    }
    
    //Método combobox de alumnos a quien agregar horas
    
    public void CargarComboboxAlumnos (JComboBox comboBox) {
    Connection conexion = ClaseConexion.getConexion();
    comboBox.removeAllItems();
   
    try {
        Statement statement = conexion.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM Usuario WHERE id_rol = 1 ");
        
        while (rs.next()) {
            String uuidus = rs.getString("UUID_Usuario");
            String nombre = rs.getString("nombre");
            comboBox.addItem(new Usuario(uuidus, nombre)); 
        }
        
    } catch (SQLException e) {
        e.printStackTrace();
    }
    }
    
       
    // Método iniciar sesión
    
    public int IniciarSesion() {

    Connection conexion = ClaseConexion.getConexion();
    int id_rol = -1;  // Retornamos -1 si el inicio de sesión falla

    try {
        String sql = "SELECT id_rol FROM Usuario WHERE correo_electronico = ? AND contraseña = ? AND (id_rol = 2 OR id_rol = 3)";
        PreparedStatement statement = conexion.prepareStatement(sql);
        statement.setString(1, getCorreo_electronico());
        statement.setString(2, getContraseña());

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            id_rol = resultSet.getInt("id_rol");  // Obtener el id_rol del usuario
        }

    } catch (SQLException ex) {
        System.out.println("Error en el método Iniciar Sesion: " + ex);
    }

    return id_rol;
}
    
       
       //Método Encriptar contraseña
       
       public String SHA256(String password) {
	MessageDigest md = null;
	try {
		md = MessageDigest.getInstance("SHA-256");
	}
	catch (NoSuchAlgorithmException e) {
		System.out.println(e.toString());
		return null;
	}
	byte[] hash = md.digest(password.getBytes());
	StringBuffer sb = new StringBuffer();
 
	for(byte b : hash) {
		sb.append(String.format("%02x", b));
	}
 
	return sb.toString();
       }
       
    //Método Actualizar contraseña
       
    public void Actualizarcontra(Usuario usuario){
          
        //Creamos el objeto de la clase conexión
        
        Connection conexion = ClaseConexion.getConexion();
        try{
            
            //Preparamos el prepare statement para que actualice las credenciales
            
            PreparedStatement smpt = conexion.prepareStatement("UPDATE Usuario set contraseña = ? WHERE correo_electronico = ?");
            
            smpt.setString(1, ctrlReestablecercontrasena.nuevacontra);
            smpt.setString(2, ctrlRecuperarcontrasena.correoglobal);
            smpt.executeUpdate();
        }
        catch(SQLException e){
            System.err.println("Error al actualizar la contraseña" + e.getMessage());
        }
    }
    
    //Método Mostrar datos en la tabla
    
    public void Mostrar(JTable tabla) {
        //Creamos una variable de la clase conexión       
        Connection conexion = ClaseConexion.getConexion();
        
        //Definimos el modelo de la tabla
        DefaultTableModel modeloUsuario = new DefaultTableModel();
        modeloUsuario.setColumnIdentifiers(new Object[]{"UUID_Usuario", "Nombre", "Grado", "Rol", "Comite", "Correo", "Contraseña"});
        
        try {
            //Creamos un statement para que se conecte con la base y realice una acción         
            Statement statement = conexion.createStatement();
            
            String sql = "SELECT "
                + "u.UUID_Usuario AS UUID_Usuario, "
                + "u.nombre AS Nombre, "
                + "g.grado AS Grado, " 
                + "r.tipo_rol AS Rol, " 
                + "c.comite AS Comite, " 
                + "u.correo_electronico AS Correo, "
                + "u.contraseña AS Contraseña "
                + "FROM Usuario u "
                + "LEFT JOIN Grado g ON u.id_grado = g.id_grado "
                + "LEFT JOIN Rol r ON u.id_rol = r.id_rol "
                + "LEFT JOIN Comite c ON u.id_comite = c.id_comite";
            
            //Ejecutamos el Statement con la consulta y lo asignamos a una variable de tipo ResultSet          
            ResultSet rs = statement.executeQuery(sql);
            
            //Recorremos el ResultSet
            while (rs.next()) {
                //Llenamos el modelo por cada vez que recorremos el resultSet
                modeloUsuario.addRow(new Object[]{rs.getString("UUID_Usuario"), 
                    rs.getString("Nombre"), 
                    rs.getString("Grado"),
                    rs.getString("Rol"),
                    rs.getString("Comite"),
                    rs.getString("Correo"), 
                    rs.getString("Contraseña")});
            }
            
            //Asignamos el nuevo modelo lleno a la tabla
            tabla.setModel(modeloUsuario);
            
        } catch (Exception e) {
            System.out.println("Este es el error en el modelo, metodo mostrar " + e);
        }
    }
    
    //Método Cargar Datos en la tabla
    
    public void cargarDatosTabla(frmAgregarusuarios vista) {
        
        // Obtenemos la fila seleccionada
        int filaSeleccionada = vista.jtbUsuarios.getSelectedRow();
        
        // Debemos asegurarnos que haya una fila seleccionada antes de acceder a sus valores
        if (filaSeleccionada != -1) {
            String UUID_Usuario = vista.jtbUsuarios.getValueAt(filaSeleccionada, 0).toString();
            String nombre = vista.jtbUsuarios.getValueAt(filaSeleccionada, 1).toString();
            String id_grado = vista.jtbUsuarios.getValueAt(filaSeleccionada, 2).toString();
            String id_rol = vista.jtbUsuarios.getValueAt(filaSeleccionada, 3).toString();
            String id_comite = vista.jtbUsuarios.getValueAt(filaSeleccionada, 4).toString();
            String correo_electronico = vista.jtbUsuarios.getValueAt(filaSeleccionada, 5).toString();
            String contraseña = vista.jtbUsuarios.getValueAt(filaSeleccionada, 6).toString();

            // Establece los valores en los campos de texto
            
            vista.txtNombreus.setText(nombre);
            vista.cbGrado.setSelectedItem(id_grado);
            vista.cbRol.setSelectedItem(id_rol);
            vista.cbComite.setSelectedItem(id_comite);
            vista.txtCorreous.setText(correo_electronico);
            vista.txtContraus.setText(contraseña);
        }
        
    }
    
    
    // Método Guardar Usuario
    
    public void GuardarUsuario(){       
    // Creamos una variable igual a ejecutar el método de la clase de conexión       
    Connection conexion = ClaseConexion.getConexion();
    
    try {           
        // Creamos el PreparedStatement que ejecutará la Query           
        PreparedStatement newUs = conexion.prepareStatement(
            "Insert into Usuario (UUID_Usuario, nombre, id_grado, id_rol, id_comite, contraseña, correo_electronico) Values (?, ?, ?, ?, ?, ?, ?)"
        );          
        
        // Establecer valores de la consulta SQL
        newUs.setString(1, UUID.randomUUID().toString());
        newUs.setString(2, getNombre());
        newUs.setInt(3, getId_grado());
        newUs.setInt(4, getId_rol());
        newUs.setInt(5, getId_comite());
        newUs.setString(6, getContraseña());
        newUs.setString(7, getCorreo_electronico());
        
        // Ejecutar la consulta            
        newUs.executeUpdate();
        
    } catch (SQLException ex) {
        
        if (ex.getErrorCode() == 2291) { 
            System.out.println("Error: Clave principal no encontrada para los siguientes IDs:");
            if (getId_grado() <= 0) {
                System.out.println("ID Grado: " + getId_grado() + " es inválido.");
            }
            if (getId_rol() <= 0) {
                System.out.println("ID Rol: " + getId_rol() + " es inválido.");
            }
            if (getId_comite() <= 0) {
                System.out.println("ID Comité: " + getId_comite() + " es inválido.");
            }
        } else {
            System.out.println("Este es el error en el modelo usuario: método guardar " + ex);
        }
    }
}

    
    // Método Actualizar Usuario
    
    public void ActualizarUsuario(JTable tabla){
        //Creamos una variable igual a ejecutar el mÃ©todo de la clase de conexión
        Connection conexion = ClaseConexion.getConexion();
        //obtenemos que fila selecciona el usuario
        int filaseleccionada = tabla.getSelectedRow();
        if(filaseleccionada != -1){
            //Obtenemos el id de la fila seleccionada
            String UUIDus = tabla.getValueAt(filaseleccionada, 0).toString();
            try{
                //Ejecutamos la Query
                PreparedStatement Actualizarus = conexion.prepareStatement("UPDATE Usuario set nombre =?, id_grado =?, id_rol=?, id_comite=?, correo_electronico =?, contraseña =? WHERE UUID_Usuario =?");
                Actualizarus.setString(1, getNombre());
                Actualizarus.setInt (2, getId_grado());
                Actualizarus.setInt(3, getId_rol());
                Actualizarus.setInt(4, getId_comite());
                Actualizarus.setString(5, getCorreo_electronico());
                Actualizarus.setString(6, getContraseña());
                Actualizarus.setString(7, UUIDus);
                Actualizarus.executeUpdate();
            }
            catch(Exception e){
                System.out.println("este es el error en el metodo de actualizar" + e);
            }
        }
        else {
            System.out.println("no funciona actualizar");
        }

    }
    
    
    // Método Eliminar Usuario
    
    public void EliminarUsuario(JTable tabla){
        
        //Creamos una variable igual a ejecutar el mÃ©todo de la clase de conexiÃ³n
        Connection conexion = ClaseConexion.getConexion();
        
        //Obtenemos que fila seleccionÃ³ el usuario
        int filaSeleccionada = tabla.getSelectedRow();
        
        //Obtenemos el id de la fila seleccionada
        String miId = tabla.getValueAt(filaSeleccionada, 0).toString();
        
        //Eliminamos al usuario 
        try{
            PreparedStatement EliminarUsuario = conexion.prepareStatement("DELETE FROM Usuario WHERE UUID_Usuario =?");
            EliminarUsuario.setString(1, miId);
            EliminarUsuario.executeUpdate();
        }
        catch(Exception e){
            System.out.println("este es el error metodo de eliminar" + e);
        }
    }
    
    //Método buscar Usuario
    
    public void BuscarUsuario(JTable tabla, JTextField miTextField) {
        
        //Creamos una variable igual a ejecutar el método de la clase de conexión
        Connection conexion = ClaseConexion.getConexion();

        //Definimos el modelo de la tabla
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"UUID_Usuario", "Nombre", "Grado", "Rol", "Comite", "Contraseña", "Correo"});
        try {
            
            String sql = "SELECT "
                + "u.UUID_Usuario AS UUID_Usuario, "
                + "u.nombre AS Nombre, "
                + "g.grado AS Grado, " 
                + "r.tipo_rol AS Rol, " 
                + "c.comite AS Comite, " 
                + "u.correo_electronico AS Correo, "
                + "u.contraseña AS Contraseña "
                + "FROM Usuario u "
                + "LEFT JOIN Grado g ON u.id_grado = g.id_grado "
                + "LEFT JOIN Rol r ON u.id_rol = r.id_rol "
                + "LEFT JOIN Comite c ON u.id_comite = c.id_comite "
                + "WHERE u.nombre LIKE ? || '%'";
            
            PreparedStatement deleteEstudiante = conexion.prepareStatement(sql);
            deleteEstudiante.setString(1, miTextField.getText());
            ResultSet rs = deleteEstudiante.executeQuery();

            while (rs.next()) {
                //Llenamos el modelo por cada vez que recorremos el resultSet
                modelo.addRow(new Object[]{rs.getString("UUID_Usuario"), rs.getString("Nombre"), rs.getString("Grado"), rs.getString("Rol"), rs.getString("Comite"), rs.getString("Contraseña"), rs.getString("Correo")});
            }

            //Asignamos el nuevo modelo lleno a la tabla
            tabla.setModel(modelo);
            tabla.getColumnModel().getColumn(0).setMinWidth(0);
            tabla.getColumnModel().getColumn(0).setMaxWidth(0);
            tabla.getColumnModel().getColumn(0).setWidth(0);
            
        } catch (Exception e) {
            System.out.println("Error en metodo buscar usuarios: " + e);
        }
    }
}



