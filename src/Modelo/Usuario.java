package Modelo;

import Controlador.ctrlRecuperarcontrasena;
import java.sql.*;
import java.util.UUID;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Vista.frmAgregarusuarios;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;



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
        ResultSet rs = statement.executeQuery("SELECT * FROM Usuario");
        
        while (rs.next()) {
            String uuidus = rs.getString("UUID_Usuario");
            String nombre = rs.getString("nombre");
            comboBox.addItem(new Usuario(uuidus, nombre)); 
        }
        
    } catch (SQLException e) {
        e.printStackTrace();
    }
    }
    
       
    //Método iniciar sesión    
       //El mÃ©todo devuelve un valor booleano (verdadero o falso)
       //Verdadero si existe el usuario y Falso si no existe
    
       public boolean IniciarSesion() {
           
        //Obtenemos la Conexion con la base de datos
           
        Connection conexion = ClaseConexion.getConexion();
        boolean resultado = false;

        try {
            
            //Preparamos la consulta SQL para verificar el usuario
            
            String sql = "SELECT * FROM Usuario WHERE correo_electronico = ? AND contraseña = ?";
            PreparedStatement statement = conexion.prepareStatement(sql);
            statement.setString(1, getCorreo_electronico());
            statement.setString(2, getContraseña());

            //Ejecutamos la consulta
            
            ResultSet resultSet = statement.executeQuery();

            //Si hay un resultado, significa que el usuario existe y la contraseÃ±a es correcta
            
            if (resultSet.next()) {
                resultado = true;
            }

        } catch (SQLException ex) {
            System.out.println("Error en el modelo: método iniciarSesion " + ex);
        }

        return resultado;
    }
       
       //Método Encriptar contraseña, Esto permitirá¡ que la contraseña se 
       //guarde de forma segura en la base y sea dificil de hackear
       
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
            
            smpt.setString(1, usuario.getContraseña());
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
        modeloUsuario.setColumnIdentifiers(new Object[]{"UUID_Usuario", "nombre", "id_grado", "id_rol", "id_comite", "correo_electronico", "contraseña"});
        
        try {
            //Creamos un statement para que se conecte con la base y realice una acción         
            Statement statement = conexion.createStatement();
            
            //Ejecutamos el Statement con la consulta y lo asignamos a una variable de tipo ResultSet          
            ResultSet rs = statement.executeQuery("SELECT * FROM Usuario");
            
            //Recorremos el ResultSet
            while (rs.next()) {
                //Llenamos el modelo por cada vez que recorremos el resultSet
                modeloUsuario.addRow(new Object[]{rs.getString("UUID_Usuario"), 
                    rs.getString("nombre"), 
                    rs.getInt("id_grado"),
                    rs.getInt("id_rol"),
                    rs.getInt("id_comite"),
                    rs.getString("correo_electronico"), 
                    rs.getString("contraseña")});
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
            int id_grado = Integer.parseInt(vista.jtbUsuarios.getValueAt(filaSeleccionada, 2).toString());
            int id_rol = Integer.parseInt(vista.jtbUsuarios.getValueAt(filaSeleccionada, 3).toString());
            int id_comite = Integer.parseInt(vista.jtbUsuarios.getValueAt(filaSeleccionada, 4).toString());
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
    
    //Método comprobar Usuario
    
    public boolean Usuario(){
        
        Connection conexion = ClaseConexion.getConexion();
        boolean resultado = false;
        
        try {
          
            String sql = "Select * from Usuario WHERE correo_electronico = ? AND contraseña = ?";
            PreparedStatement statement = conexion.prepareStatement(sql);
            
            statement.setString(1,getCorreo_electronico());
            statement.setString(2,getContraseña());
            
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                resultado = true;
            }

        } 
        
        catch (Exception ex) {
            System.out.println("Error en el modélo: En el método Iniciar sesión ha ocurrido: " + ex);
        }
        
        return resultado;
    }
    
}



