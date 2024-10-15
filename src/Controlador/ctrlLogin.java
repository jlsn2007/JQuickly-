package Controlador;

import Modelo.Usuario;
import Vista.frmLogin;
import Vista.frmMenu;
import Vista.frmMenucoordi;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;


public class ctrlLogin implements MouseListener, KeyListener{
    
     Usuario ModeloUsuario;
     frmLogin Vistalogin;
    
    public ctrlLogin(Usuario usuarios, frmLogin frmlogin){
        
        this.ModeloUsuario = usuarios;
        this.Vistalogin = frmlogin;
        
        
        frmlogin.btntxtRecucontra.addMouseListener(this);
        frmlogin.btnSiguiente.addMouseListener(this);
        frmlogin.txtCorreo.addMouseListener(this);
        frmlogin.txtContra.addMouseListener(this);
        
    }
       

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if (e.getSource() == Vistalogin.btnSiguiente) {
            
            ModeloUsuario.setCorreo_electronico(Vistalogin.txtCorreo.getText());
            ModeloUsuario.setContraseña(ModeloUsuario.SHA256(Vistalogin.txtContra.getText()));
        
            
        // Validación del correo electrónico en el login
        String correo = Vistalogin.txtCorreo.getText();
        
        if (!correo.endsWith("@ricaldone.edu.sv")) {
            JOptionPane.showMessageDialog(Vistalogin, "El correo debe terminar con @ricaldone.edu.sv");
            return;
        }

        // Validación de la contraseña en el login
        try {
                String contrasena = Vistalogin.txtContra.getText();
                
                // Validar longitud de la contraseña
                if (contrasena.length() < 7) {
                    throw new IllegalArgumentException("La contraseña debe tener más de 7 caracteres.");
                }
                
                // Validar que la contraseña contenga al menos una letra mayúscula y una letra minúscula
                if (!contrasena.matches(".*[a-z].*") || !contrasena.matches(".*[A-Z].*")) {
                    throw new IllegalArgumentException("La contraseña debe contener al menos una letra mayúscula y una letra minúscula.");
                }

                ModeloUsuario.setContraseña(ModeloUsuario.SHA256(contrasena));

            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(Vistalogin, ex.getMessage());
                return;
            } 
        
        int id_rol = ModeloUsuario.IniciarSesion();

        if (id_rol != -1) {  
            JOptionPane.showMessageDialog(Vistalogin, "¡Bienvenido!");

            // Redirigir según el rol
            if (id_rol == 2) {
                // Redirigir a la interfaz de Coordinador
                frmMenucoordi menuCoordi = new frmMenucoordi();
                menuCoordi.initfrmMenucoordi();  
                
                
            } else if (id_rol == 3) {
                // Redirigir a la interfaz de Alumno
                frmMenu menu = new frmMenu();
                menu.initfrmMenu();  
                
            }

            Vistalogin.dispose();  // Cerrar la ventana de login
        } else {
            JOptionPane.showMessageDialog(Vistalogin, "Credenciales inválidas");
        }
    }
        
      
        if (e.getSource() == Vistalogin.btntxtRecucontra) {
            Vista.frmRecuperarcontrasena.initfrmRecucontra();
            Vistalogin.dispose();
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

    @Override
    public void keyReleased(KeyEvent e) {

    }
    
}