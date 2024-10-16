package Controlador;

import Modelo.Expediente;
import Modelo.Usuario;
import Vista.frmAgregarhoras;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

public class ctrlAgregarhoras implements MouseListener, KeyListener{
    
    private frmAgregarhoras vistahoras;
    
    private Expediente modeloexpediente;
    private Usuario modelousuario;
    
    
    public ctrlAgregarhoras(frmAgregarhoras Vistahoras, Usuario modeloUsuario, Expediente modeloExpediente){
        
        this.vistahoras = Vistahoras;
        this.modelousuario = modeloUsuario;
        this.modeloexpediente = modeloExpediente;
        
        this.vistahoras.cbAlumnos.addMouseListener(this);
        this.modelousuario.CargarComboboxAlumnos(vistahoras.cbAlumnos);
        
        Vistahoras.volverhoras.addMouseListener(this);
        Vistahoras.btnAgregar.addMouseListener(this);
        Vistahoras.txtNombredelevento.addMouseListener(this);
        Vistahoras.txtBuscaralum.addKeyListener(this);
        Vistahoras.btnEditar.addMouseListener(this);
        Vistahoras.btnEliminarexp.addMouseListener(this);
        Vistahoras.jtbAlumnos.addMouseListener(this);
        Vistahoras.txtCantidadhoras.addMouseListener(this);
        
        vistahoras.cbAlumnos.addActionListener(e ->{
            if(e.getSource()== vistahoras.cbAlumnos){
                Usuario selectedAlumno =(Usuario) vistahoras.cbAlumnos.getSelectedItem();
                if(selectedAlumno != null){
                    String ida = selectedAlumno.getUUID_Usuario();
                    modelousuario.setUUID_Usuario(ida);
                    System.out.println("Esto es lo que se manda a traer de la base de datos (Usuario): " + selectedAlumno.getNombre()+ " con ID: " + ida);
                }
            }
        });
        
        modeloexpediente.Mostrar(vistahoras.jtbAlumnos);
        
    }
    
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
        if (e.getSource() == vistahoras.volverhoras){
            vistahoras.dispose();
        }
        
        if(e.getSource() == vistahoras.jtbAlumnos){
            modeloexpediente.cargarDatosTabla(vistahoras);
        }
        
        if (e.getSource() == vistahoras.btnAgregar){
            
            //Validaciones para el nombre del evento
            
            try {
                String nombreevento = vistahoras.txtNombredelevento.getText().trim();
                
                if (nombreevento.isEmpty()) {
                    throw new IllegalArgumentException("El nombre del evento es obligatorio.");
                }
                
                if (!nombreevento.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
                    throw new IllegalArgumentException("El nombre del evento solo puede contener letras.");
                }
                
                if (!Character.isUpperCase(nombreevento.charAt(0))) {
                    JOptionPane.showMessageDialog(vistahoras, "El nombre del evento debe comenzar con mayúscula");
                    return;
                }
            
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(vistahoras, ex.getMessage());
                return;
            } 
                       
            // Validaciones para las horas del evento
            
            try {
            
            int horasNumericas = Integer.parseInt(vistahoras.txtCantidadhoras.getText().trim());

            if (horasNumericas > 25) {
                throw new IllegalArgumentException("Las horas no pueden exceder de 25.");
            }

            modeloexpediente.setHoras_agregadas(horasNumericas);
            
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(vistahoras, "Las horas deben ser un valor numérico.");
                return;
            
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(vistahoras, ex.getMessage());
                return;
            }
            
            if (modelousuario.getUUID_Usuario() == null || modelousuario.getUUID_Usuario().isEmpty()) {
                JOptionPane.showMessageDialog(vistahoras, "Debe seleccionar un alumno a quien asignar horas.");
                return;
            }
            
            modeloexpediente.setNombre_evento(vistahoras.txtNombredelevento.getText());
            
            int horasNumericas = Integer.parseInt(vistahoras.txtCantidadhoras.getText().trim());
            modeloexpediente.setHoras_agregadas(horasNumericas);
            
            modeloexpediente.setUUID_Usuario(modelousuario.getUUID_Usuario());
            
            modeloexpediente.Guardarhistorialalumno();
            JOptionPane.showMessageDialog(vistahoras, "Expediente Guardado");
            modeloexpediente.Mostrar(vistahoras.jtbAlumnos);
         
        }
        
        if (e.getSource() == vistahoras.btnEditar){
            
            //Validaciones para el nombre del evento
            try {
                String nombreevento = vistahoras.txtNombredelevento.getText().trim();
                if (nombreevento.isEmpty()) {
                    throw new IllegalArgumentException("El nombre del evento es obligatorio.");
                }
                
                if (!Character.isUpperCase(nombreevento.charAt(0))) {
                    JOptionPane.showMessageDialog(vistahoras, "El nombre del evento debe comenzar con mayúscula");
                    return;
                }
                
                if (!nombreevento.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
                    throw new IllegalArgumentException("El nombre del evento solo puede contener letras.");
                }
            
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(vistahoras, ex.getMessage());
                return;
            } 
            
            try {
            
            int horasNumericas = Integer.parseInt(vistahoras.txtCantidadhoras.getText().trim());

            if (horasNumericas > 25) {
                throw new IllegalArgumentException("Las horas no pueden exceder de 25.");
            }

            modeloexpediente.setHoras_agregadas(horasNumericas);
            
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(vistahoras, "Las horas deben ser un valor numérico.");
                return;
            
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(vistahoras, ex.getMessage());
                return;
            }
            
            if (modelousuario.getUUID_Usuario() == null || modelousuario.getUUID_Usuario().isEmpty()) {
                JOptionPane.showMessageDialog(vistahoras, "Debe seleccionar un alumno a quien asignar horas.");
                return;
            }
            
            int horasNumericas = Integer.parseInt(vistahoras.txtCantidadhoras.getText().trim());
            
            modeloexpediente.setNombre_evento(vistahoras.txtNombredelevento.getText()); 
            modeloexpediente.setHoras_agregadas(horasNumericas);
            modeloexpediente.setUUID_Usuario(modelousuario.getUUID_Usuario());
            modeloexpediente.Actualizarhoras(vistahoras.jtbAlumnos);
            
            JOptionPane.showMessageDialog(vistahoras, "Expediente actualizado");
            modeloexpediente.Mostrar(vistahoras.jtbAlumnos);
            
        }
        
        if (e.getSource()== vistahoras.btnEliminarexp){          
            
            int confirmacion = JOptionPane.showConfirmDialog(vistahoras, "¿Seguro de eliminar este expediente?", "Eliminar", JOptionPane.YES_NO_OPTION);
            
            if (confirmacion == JOptionPane.YES_OPTION) {
                modeloexpediente.Eliminarexpediente(vistahoras.jtbAlumnos);
                modeloexpediente.Mostrar(vistahoras.jtbAlumnos);
                JOptionPane.showMessageDialog(vistahoras, "Expediente eliminado.");
            } 
            else {
                JOptionPane.showMessageDialog(vistahoras, "Acción Cancelada");
            }
            
        }
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        
        if (e.getSource()== vistahoras.txtBuscaralum){          
            modeloexpediente.BuscarAlumno(vistahoras.jtbAlumnos, vistahoras.txtBuscaralum); 
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
