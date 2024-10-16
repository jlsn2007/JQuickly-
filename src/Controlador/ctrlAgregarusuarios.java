package Controlador;

import Modelo.Comite;
import Modelo.Grado;
import Modelo.Rol;
import Modelo.Usuario;
import Vista.frmAgregarusuarios;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;


public class ctrlAgregarusuarios implements MouseListener, KeyListener {
    
    //Creamos los métodos
    
    private frmAgregarusuarios vistaus;
    
    private Usuario ModeloUsuario;
    private Rol ModeloRol;
    private Grado ModeloGrado;
    private Comite ModeloComite;
    
    public ctrlAgregarusuarios(frmAgregarusuarios Vistaus, Rol modeloRol, Grado modeloGrado, Comite modeloComite, Usuario modeloUsuario){
        
        this.vistaus = Vistaus;
        this.ModeloRol = modeloRol;
        this.ModeloGrado = modeloGrado;
        this.ModeloComite = modeloComite;
        this.ModeloUsuario = modeloUsuario;
        
        this.vistaus.cbGrado.addMouseListener(this);
        this.ModeloGrado.CargarComboboxGrados(vistaus.cbGrado);
        this.vistaus.cbRol.addMouseListener(this);
        this.ModeloRol.CargarComboboxRoles(vistaus.cbRol);
        this.vistaus.cbComite.addMouseListener(this);
        this.ModeloComite.CargarComboboxComites(vistaus.cbComite);
        
        //Mandamos a llamar los elementos de la vista
        
        Vistaus.txtNombreus.addMouseListener(this);
        Vistaus.txtCorreous.addMouseListener(this);
        Vistaus.txtContraus.addMouseListener(this);
        Vistaus.btnAgregarusuarios.addMouseListener(this);
        Vistaus.btnEditar.addMouseListener(this);
        Vistaus.btnEliminar.addMouseListener(this);
        Vistaus.volverprin.addMouseListener(this);
        Vistaus.jtbUsuarios.addMouseListener(this);
        Vistaus.txtBuscarus.addKeyListener(this);
        
        
        //Cargar los datos del combobox de roles con el método en el modelo Rol
        
        vistaus.cbRol.addActionListener(e -> {
            if(e.getSource() == vistaus.cbRol) {
                Rol selectedRol = (Rol) vistaus.cbRol.getSelectedItem();
                if(selectedRol != null) {
                    int idr = selectedRol.getId_rol();
                    ModeloRol.setId_rol(idr);
                    System.out.println("Esto es lo que se manda a traer de la base de datos (Rol): " + selectedRol.getTipo_rol() + " con ID: " + idr);
                }
            }
        });
        
        //Cargar los datos del combobox de roles con el método en el modelo Grado
        
        vistaus.cbGrado.addActionListener(e ->{
            if(e.getSource()== vistaus.cbGrado){
                Grado selectedGrado =(Grado) vistaus.cbGrado.getSelectedItem();
                if(selectedGrado != null){
                    int idg = selectedGrado.getId_grado();
                    ModeloGrado.setId_grado(idg);
                    System.out.println("Esto es lo que se manda a traer de la base de datos (Grado): " + selectedGrado.getGrado()+ " con ID: " + idg);
                }
            }
        });
        
        //Cargar los datos del combobox de roles con el método en el modelo Comite
        
        vistaus.cbComite.addActionListener(e ->{
            if(e.getSource()== vistaus.cbComite){
                Comite selectedComite =(Comite) vistaus.cbComite.getSelectedItem();
                if(selectedComite != null){
                    int idc = selectedComite.getId_comite();
                    ModeloComite.setId_comite(idc);
                     System.out.println("Esto es lo que se manda a traer de la base de datos (Comité): " + selectedComite.getComite()+ " con ID: " + idc);
                }
            }
        });
        
        //Se manda a llamar el método de mostrar en el ModeloUsuario para que muestre los usuarios
        
        ModeloUsuario.Mostrar(vistaus.jtbUsuarios);
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        //Botón para guardar Usuario
        
        if(e.getSource() == vistaus.btnAgregarusuarios){
            
            if (ModeloRol.getId_rol() <= 0) {
                JOptionPane.showMessageDialog(vistaus, "Debe seleccionar un Rol");
                return;
            }
            
            if (ModeloGrado.getId_grado() <= 0) {
                JOptionPane.showMessageDialog(vistaus, "Debe seleccionar un Grado");
                return;
            }
            
            if (ModeloComite.getId_comite() <= 0) {
                JOptionPane.showMessageDialog(vistaus, "Debe seleccionar un Comité");
                return;
            }
            
            //Validaciones para el nombre
            try {
                String nombre = vistaus.txtNombreus.getText().trim();
                if (nombre.isEmpty()) {
                    throw new IllegalArgumentException("El nombre es obligatorio.");
                }
                
                if (!Character.isUpperCase(nombre.charAt(0))) {
                    JOptionPane.showMessageDialog(vistaus, "El nombre del Usuario debe comenzar con mayúscula");
                    return;
                }
                
                if (!nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
                    throw new IllegalArgumentException("El nombre solo puede contener letras.");
                }
            
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(vistaus, ex.getMessage());
                return;
            } 
            
            //Validaciones para el correo
                        
            try {
                String correo = vistaus.txtCorreous.getText().trim();
                if (correo.isEmpty()) {
                    throw new IllegalArgumentException("El correo es obligatorio.");
                }
                
                if (!correo.equals(correo.toLowerCase())) {
                    throw new IllegalArgumentException("El correo solo puede contener letras en minúsculas.");
                }
                
                if (!correo.endsWith("@ricaldone.edu.sv")) {
                    throw new IllegalArgumentException("El correo debe terminar con @ricaldone.edu.sv");
                }
            
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(vistaus, ex.getMessage());
                return;
            }
            
            //Validación para la contraseña
            
            try {
                String contrasena = vistaus.txtContraus.getText();
                if (contrasena.length() < 7) {
                    throw new IllegalArgumentException("La contraseña debe tener más de 7 caracteres.");
                }
                
                if (!contrasena.matches(".*[a-z].*") || !contrasena.matches(".*[A-Z].*")) {
                    throw new IllegalArgumentException("La contraseña debe contener al menos una letra mayúscula y una letra minúscula.");
                }
            
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(vistaus, ex.getMessage());
                return;
            }
            
            // Validación para el ComboBox de Rol
                
                try {
                    if (vistaus.cbRol.getSelectedItem()== null) { 
                        throw new Exception("Debe seleccionar un Rol válido.");
                    }  
                
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(vistaus, ex.getMessage());
                    return;
                }
            
            // Validación para el ComboBox de Grado
            
                
                try {
                    if (vistaus.cbGrado.getSelectedItem() == null) { 
                        throw new IllegalArgumentException("Debe seleccionar un Grado.");
                    }
                
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(vistaus, ex.getMessage());
                    return;
                }
                
                // Validación para el ComboBox de Comité
                
                try {
                    if (vistaus.cbComite.getSelectedItem() == null) {
                        throw new IllegalArgumentException("Debe seleccionar un Comité.");
                    }
                
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(vistaus, ex.getMessage());
                    return;
                }
            
            ModeloUsuario.setNombre(vistaus.txtNombreus.getText());
            ModeloUsuario.setCorreo_electronico(vistaus.txtCorreous.getText());
            ModeloUsuario.setContraseña(ModeloUsuario.SHA256(vistaus.txtContraus.getText()));
            ModeloUsuario.setId_grado(ModeloGrado.getId_grado());
            ModeloUsuario.setId_rol(ModeloRol.getId_rol());
            ModeloUsuario.setId_comite(ModeloComite.getId_comite());
            ModeloUsuario.GuardarUsuario();     
            ModeloUsuario.Mostrar(vistaus.jtbUsuarios);
            
            JOptionPane.showMessageDialog(vistaus, "Usuario Guardado");
                        
        }
        
        // Botón para editar al usuario
        
        if(e.getSource() == vistaus.btnEditar){
            
                // Validación para el nombre
                
                try {
                    String nombre = vistaus.txtNombreus.getText().trim();
                    if (nombre.isEmpty()) {
                        throw new IllegalArgumentException("El nombre es obligatorio.");
                    }
                    
                    if (!Character.isUpperCase(nombre.charAt(0))) {
                        JOptionPane.showMessageDialog(vistaus, "El nombre del Usuario debe comenzar con mayúscula");
                        return;
                    }
                    
                    if (!nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
                        throw new IllegalArgumentException("El nombre solo puede contener letras.");
                    }
                    
                    //ModeloUsuario.setNombre(nombre);
                    
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(vistaus, ex.getMessage());
                    return;
                }
                
                // Validación para el correo
                
                try {
                    String correo = frmAgregarusuarios.txtCorreous.getText().trim(); 
                    
                    if (correo.isEmpty()) {
                        throw new IllegalArgumentException("El correo es obligatorio.");
                    }
                    
                    if (!correo.equals(correo.toLowerCase())) {
                    throw new IllegalArgumentException("El correo solo puede contener letras en minúsculas.");
                }
            
                    if (!correo.endsWith("@ricaldone.edu.sv")) {
                        throw new IllegalArgumentException("El correo debe terminar con @ricaldone.edu.sv.");
                    }
                    
                    frmAgregarusuarios.txtCorreous.setText(correo); 
                } 
                catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(vistaus, ex.getMessage());
                    return;
                }

                // Validación para la contraseña
                
                try {
                    String contrasena = vistaus.txtContraus.getText();
                    if (contrasena.length() < 7) {
                        throw new IllegalArgumentException("La contraseña debe tener más de 7 caracteres.");
                    }
                    
                    if (!contrasena.matches(".*[a-z].*") || !contrasena.matches(".*[A-Z].*")) {
                        throw new IllegalArgumentException("La contraseña debe contener al menos una letra mayúscula y una letra minúscula.");
                    }
                    
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(vistaus, ex.getMessage());
                    return;
                }
                
                //Otras validaciones para los combobox
                
                if (ModeloRol.getId_rol() <= 0) {
                    JOptionPane.showMessageDialog(vistaus, "Debe seleccionar un Rol");
                    return;
                }
            
            
                if (ModeloGrado.getId_grado() <= 0) {
                    JOptionPane.showMessageDialog(vistaus, "Debe seleccionar un Grado");
                    return;
                }
            
            
                if (ModeloComite.getId_comite() <= 0) {
                    JOptionPane.showMessageDialog(vistaus, "Debe seleccionar un Comité");
                    return;
                }
                
            
            ModeloUsuario.setNombre(vistaus.txtNombreus.getText());
            ModeloUsuario.setCorreo_electronico(vistaus.txtCorreous.getText());
            ModeloUsuario.setContraseña(ModeloUsuario.SHA256(vistaus.txtContraus.getText()));
            ModeloUsuario.setId_grado(ModeloGrado.getId_grado());
            ModeloUsuario.setId_rol(ModeloRol.getId_rol());
            ModeloUsuario.setId_comite(ModeloComite.getId_comite());
            ModeloUsuario.ActualizarUsuario(vistaus.jtbUsuarios);
            ModeloUsuario.Mostrar(vistaus.jtbUsuarios);
            
            JOptionPane.showMessageDialog(vistaus, "Usuario actualizado.");

  
        }
        
        // Botón para eliminar al usuario
        
        if(e.getSource() == vistaus.btnEliminar){
            int confirmacion = JOptionPane.showConfirmDialog(vistaus, "¿Seguro de eliminar a este usuario?", "Eliminar", JOptionPane.YES_NO_OPTION);
            
            if (confirmacion == JOptionPane.YES_OPTION) {
                ModeloUsuario.EliminarUsuario(vistaus.jtbUsuarios);
                ModeloUsuario.Mostrar(vistaus.jtbUsuarios);
                JOptionPane.showMessageDialog(vistaus, "Usuario eliminado.");
            } 
            else {
                JOptionPane.showMessageDialog(vistaus, "Acción Cancelada");
            }
        }
        
        if(e.getSource() == vistaus.volverprin){
            vistaus.dispose();
        }
        
        if(e.getSource() == vistaus.jtbUsuarios){
            ModeloUsuario.cargarDatosTabla(vistaus);
        }
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        
        if (e.getSource()== vistaus.txtBuscarus){          
            ModeloUsuario.BuscarUsuario(vistaus.jtbUsuarios, vistaus.txtBuscarus); 
        }
        
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }
}