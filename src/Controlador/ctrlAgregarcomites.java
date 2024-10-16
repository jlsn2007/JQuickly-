package Controlador;

import Modelo.Comite;
import Vista.frmAgregarcomites;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

public class ctrlAgregarcomites implements MouseListener, KeyListener{

    private frmAgregarcomites vistacom;
    private Comite modelocomite;
    
    public ctrlAgregarcomites(frmAgregarcomites vistaCom, Comite modeloComite){
        
        this.vistacom = vistaCom;
        this.modelocomite = modeloComite;
        
        vistacom.volvercom.addMouseListener(this);
        vistacom.txtBuscarcomite.addKeyListener(this);
        vistacom.txtNombrecomite.addMouseListener(this);
        vistacom.txtDescripcioncomite.addMouseListener(this);
        vistacom.txtCupos.addMouseListener(this);
        vistacom.btnAgregarcomite.addMouseListener(this);
        vistacom.btnEditarcomite.addMouseListener(this);
        vistacom.btnEliminarcomite.addMouseListener(this);
        vistacom.jtbComites.addMouseListener(this);
        
        modeloComite.MostrarComites(vistaCom.jtbComites);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
        if (e.getSource() == vistacom.volvercom){
            vistacom.dispose();
        }
        
        if(e.getSource() == vistacom.jtbComites){
            modelocomite.cargarDatosTabla(vistacom);
        }
        
        if(e.getSource() == vistacom.btnAgregarcomite){
            
            // Validaciones para el nombre del comité
        
            try {
            
                String nombre = vistacom.txtNombrecomite.getText().trim();
            
                if (nombre.isEmpty()) {
                    throw new IllegalArgumentException("El nombre del comité es obligatorio.");
                }
                
                if (!nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
                    throw new IllegalArgumentException("El nombre solo puede contener letras.");
                }
                
                if (!Character.isUpperCase(nombre.charAt(0))) {
                    throw new IllegalArgumentException("El nombre debe empezar con una letra mayúscula.");
                }
        
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(vistacom, ex.getMessage());
                return;
            }
             
            // Validaciones para la descripción
        
            try {
            
                String descripcion = vistacom.txtDescripcioncomite.getText().trim();
            
                if (!descripcion.matches("[a-zA-Z0-9áéíóúÁÉÍÓÚñÑ ]+")) {
                    throw new IllegalArgumentException("La descripción solo puede contener letras y números sin caracteres especiales.");
                }
                
                if (!Character.isUpperCase(descripcion.charAt(0))) {
                    throw new IllegalArgumentException("La descripción debe de iniciar con mayúscula");
                }
                
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(vistacom, ex.getMessage());
                return;
            }

            try {
                
                int cupos = Integer.parseInt(vistacom.txtCupos.getText().trim());
                
                if (cupos < 1 || cupos > 115) {
                    throw new IllegalArgumentException("El número de cupos debe estar entre 1 y 115.");
                }
                
                modelocomite.setCupos(cupos);

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(vistacom, "Los cupos deben ser de carácter numérico.");
                return;

            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(vistacom, ex.getMessage());
                return;
            }
            
            modelocomite.setComite(vistacom.txtNombrecomite.getText());
            modelocomite.setDescripcion(vistacom.txtDescripcioncomite.getText());
            
            int Cupos = Integer.parseInt(vistacom.txtCupos.getText().trim());
            modelocomite.setCupos(Cupos);
            
            modelocomite.AgregarComites();
            JOptionPane.showMessageDialog(vistacom, "Comité Agregado");
            modelocomite.MostrarComites(vistacom.jtbComites);
            
        }
        
        if(e.getSource() == vistacom.btnEditarcomite){
            
            // Validaciones para el nombre del comité
        
            try {
            
                String nombre = vistacom.txtNombrecomite.getText().trim();
            
                if (nombre.isEmpty()) {
                    throw new IllegalArgumentException("El nombre del comité es obligatorio.");
                }
                
                if (!nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
                    throw new IllegalArgumentException("El nombre solo puede contener letras.");
                }
                
                if (!Character.isUpperCase(nombre.charAt(0))) {
                    throw new IllegalArgumentException("El nombre debe empezar con una letra mayúscula.");
                }
        
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(vistacom, ex.getMessage());
                return;
            }
             
            // Validaciones para la descripción
        
            try {
            
                String descripcion = vistacom.txtDescripcioncomite.getText().trim();
            
                if (!descripcion.matches("[a-zA-Z0-9áéíóúÁÉÍÓÚñÑ ]+")) {
                    throw new IllegalArgumentException("La descripción solo puede contener letras y números sin caracteres especiales.");
                }
                
                if (!Character.isUpperCase(descripcion.charAt(0))) {
                    throw new IllegalArgumentException("La descripción debe de iniciar con mayúscula");
                }
                
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(vistacom, ex.getMessage());
                return;
            }

            try {
                
                int cupos = Integer.parseInt(vistacom.txtCupos.getText().trim());
                
                if (cupos < 1 || cupos > 115) {
                    throw new IllegalArgumentException("El número de cupos debe estar entre 1 y 115.");
                }
                
                modelocomite.setCupos(cupos);

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(vistacom, "Los cupos deben ser de carácter numérico.");
                return;

            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(vistacom, ex.getMessage());
                return;
            }
            
            modelocomite.setComite(vistacom.txtNombrecomite.getText());
            modelocomite.setDescripcion(vistacom.txtDescripcioncomite.getText());
            
            int Cupos = Integer.parseInt(vistacom.txtCupos.getText().trim());
            modelocomite.setCupos(Cupos);
            
            modelocomite.ActualizarComites(vistacom.jtbComites);
            JOptionPane.showMessageDialog(vistacom, "Comité Actualizado");
            modelocomite.MostrarComites(vistacom.jtbComites);

        }
        
        if (e.getSource()== vistacom.btnEliminarcomite){          
            
            int confirmacion = JOptionPane.showConfirmDialog(vistacom, "¿Seguro de eliminar este comité?", "Eliminar", JOptionPane.YES_NO_OPTION);
            
            if (confirmacion == JOptionPane.YES_OPTION) {
                modelocomite.BETAEliminarComite(vistacom.jtbComites);
                modelocomite.MostrarComites(vistacom.jtbComites);
                JOptionPane.showMessageDialog(vistacom, "Comité eliminado.");
            } 
            else {
                JOptionPane.showMessageDialog(vistacom, "Acción Cancelada");
            }
            
        }
        
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        
        if (e.getSource()== vistacom.txtBuscarcomite){          
            modelocomite.Buscarcomites(vistacom.jtbComites, vistacom.txtBuscarcomite); 
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
