package Controlador;

import Modelo.Comite;
import Modelo.Grado;
import Modelo.Rol;
import Modelo.Usuario;
import Vista.frmAgregarusuarios;
import Vista.frmMenu;
import Vista.panelPrincipal;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;


public class ctrlAgregarusuarios implements MouseListener{
    
    //Creamos los métodos
    
    private frmMenu vistaa;
    private panelPrincipal panel;
    private frmAgregarusuarios vistaus;
    
    private Usuario ModeloUsuario;
    private Rol ModeloRol;
    private Grado ModeloGrado;
    private Comite ModeloComite;
    
    public ctrlAgregarusuarios(frmAgregarusuarios Vistaus, frmMenu Vistaa, panelPrincipal Panel, 
            Rol modeloRol, Grado modeloGrado, Comite modeloComite, Usuario modeloUsuario){
        
        this.vistaus = Vistaus;
        this.vistaa = Vistaa;
        this.panel = Panel;
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
        
        Vistaus.btnAgregarusuarios.addMouseListener(this);
        Vistaus.btnEditar.addMouseListener(this);
        Vistaus.btnEliminar.addMouseListener(this);
        Vistaus.jtbUsuarios.addMouseListener(this);
        
        
        //Cargar los datos del combobox de roles con el mÃ©todo en el modelo Rol
        
        vistaus.cbRol.addActionListener(e -> {
            if(e.getSource() == vistaus.cbRol) {
                Rol selectedRol = (Rol) vistaus.cbRol.getSelectedItem();
                if(selectedRol != null) {
                    int idr = selectedRol.getId_rol();
            // Si el rol es Administrador (supongamos que el ID es 1)
            
            if(idr == 3) { 
                vistaus.cbGrado.setEnabled(false);
                vistaus.cbComite.setEnabled(false);
            } 
            // Si el rol es Coordinador (supongamos que el ID es 2)
            else if(idr == 2) { 
                vistaus.cbGrado.setEnabled(false);
                vistaus.cbComite.setEnabled(true);
            } 
            // Si el rol es Alumno (supongamos que el ID es 3)
            else if(idr == 1) {
                vistaus.cbGrado.setEnabled(true);
                vistaus.cbComite.setEnabled(true);
            }
            ModeloRol.setId_rol(idr);
                }
            }
        });
        
        //Cargar los datos del combobox de roles con el mÃ©todo en el modelo Grado
        
        vistaus.cbGrado.addActionListener(e ->{
            if(e.getSource()== vistaus.cbGrado){
                Grado selectedItem =(Grado) vistaus.cbGrado.getSelectedItem();
                if(selectedItem != null){
                    int idg = selectedItem.getId_grado();
                    ModeloGrado.setId_grado(idg);
                }
            }
        });
        
        //Cargar los datos del combobox de roles con el mÃ©todo en el modelo Comite
        
        vistaus.cbComite.addActionListener(e ->{
            if(e.getSource()== vistaus.cbComite){
                Comite selectedItem =(Comite) vistaus.cbComite.getSelectedItem();
                if(selectedItem != null){
                    String idc =selectedItem.getComite();
                    ModeloComite.setComite(idc);
                }
            }
        });
        
        //Se manda a llamar el mÃ©todo de mostrar en el ModeloUsuario para que muestre los usuarios
        
        ModeloUsuario.Mostrar(vistaus.jtbUsuarios);
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        //Botón para guardar Usuario
        
        if(e.getSource()== vistaus.btnAgregarusuarios){
            
            //Validaciones para el nombre
            try {
                String nombre = vistaus.txtNombreus.getText().trim();
                if (nombre.isEmpty()) {
                    throw new IllegalArgumentException("El nombre es obligatorio.");
                }
                
                if (!nombre.matches("[a-zA-Z]+")) {
                    throw new IllegalArgumentException("El nombre solo puede contener letras.");
                }
                
                ModeloUsuario.setNombre(nombre);
            
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
                if (!correo.endsWith("@ricaldone.edu.sv")) {
                    throw new IllegalArgumentException("El correo debe terminar con @ricaldone.edu.sv.");
                }
            
                ModeloUsuario.setCorreo_electronico(correo);
            
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
            
                ModeloUsuario.setContraseña(ModeloUsuario.SHA256(contrasena));
            
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(vistaus, ex.getMessage());
                return;
            }
            
            ModeloUsuario.setNombre(vistaus.txtNombreus.getText());
            ModeloUsuario.setCorreo_electronico(vistaus.txtCorreous.getText());
            ModeloUsuario.setContraseña(ModeloUsuario.SHA256(vistaus.txtContraus.getText()));
            ModeloUsuario.GuardarUsuario();     
            ModeloUsuario.Mostrar(vistaus.jtbUsuarios);
            
            JOptionPane.showMessageDialog(vistaus, "Usuario Guardado");
                        
        }
        
        // Botón para editar al usuario
        
        if(e.getSource()== vistaus.btnEditar){
            
                // Validación para el nombre
                
                try {
                    String nombre = vistaus.txtNombreus.getText().trim();
                    if (nombre.isEmpty()) {
                        throw new IllegalArgumentException("El nombre es obligatorio.");
                    }
                    
                    if (!nombre.matches("[a-zA-Z]+")) {
                        throw new IllegalArgumentException("El nombre solo puede contener letras.");
                    }
                    
                    ModeloUsuario.setNombre(nombre);
                    
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(vistaus, ex.getMessage());
                    return;
                }
                
                // Validación para el correo
                
                try {
                    String correo = vistaus.txtCorreous.getText().trim();
                    if (correo.isEmpty()) {
                        throw new IllegalArgumentException("El correo es obligatorio.");
                    }
                    
                    if (!correo.endsWith("@ricaldone.edu.sv")) {
                        throw new IllegalArgumentException("El correo debe terminar con @ricaldone.edu.sv.");
                    }
                    
                    ModeloUsuario.setCorreo_electronico(correo);
                
                } catch (IllegalArgumentException ex) {
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
                    
                    ModeloUsuario.setContraseña(ModeloUsuario.SHA256(contrasena));
                    
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(vistaus, ex.getMessage());
                    return;
                }
            
            ModeloUsuario.setNombre(vistaus.txtNombreus.getText());
            ModeloUsuario.setCorreo_electronico(vistaus.txtCorreous.getText());
            ModeloUsuario.setContraseña(ModeloUsuario.SHA256(vistaus.txtContraus.getText()));
            ModeloUsuario.ActualizarUsuario(vistaus.jtbUsuarios);
            ModeloUsuario.Mostrar(vistaus.jtbUsuarios);
            
            JOptionPane.showMessageDialog(vistaus, "Usuario actualizado.");

  
        }
        
        // Botón para eliminar al usuario
        
        if(e.getSource()== vistaus.btnEliminar){
            int confirmacion = JOptionPane.showConfirmDialog(vistaus, "¿Seguro de eliminar a este usuario?", "Eliminar", JOptionPane.YES_NO_OPTION);
            
            if (confirmacion == JOptionPane.YES_OPTION) {
                ModeloUsuario.EliminarUsuario(vistaus.jtbUsuarios);
                ModeloUsuario.Mostrar(vistaus.jtbUsuarios);
                JOptionPane.showMessageDialog(vistaus, "Usuario eliminado.");
            } 
            else {
                JOptionPane.showMessageDialog(vistaus, "Cancelado");
            }
        }
        
        if(e.getSource()== vistaus.jtbUsuarios){
            ModeloUsuario.cargarDatosTabla(vistaus);
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
    
}