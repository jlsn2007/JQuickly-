package Controlador;

import Modelo.Expediente;
import Modelo.Usuario;
import Vista.frmAgregarhorascoordi;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;


public class ctrlAgregarhorascoodi implements MouseListener, KeyListener{
    
    private frmAgregarhorascoordi vfhorascoordi;
    
    private Usuario uscoordi;
    private Expediente excoordi;
    
    public ctrlAgregarhorascoodi(frmAgregarhorascoordi vfHorascoordi, Usuario Uscoordi, Expediente Excoordi){
        
        this.vfhorascoordi = vfHorascoordi;
        this.uscoordi = Uscoordi;
        this.excoordi = Excoordi;
        
        this.vfhorascoordi.cbAlumnos.addMouseListener(this);
        this.uscoordi.CargarComboboxAlumnos(vfhorascoordi.cbAlumnos);
        
        vfHorascoordi.volverhoras.addMouseListener(this);
        vfHorascoordi.btnAgregar.addMouseListener(this);
        vfHorascoordi.txtNombredelevento.addMouseListener(this);
        vfHorascoordi.txtBuscaralum.addKeyListener(this);
        vfHorascoordi.btnEditar.addMouseListener(this);
        //vfHorascoordi.btnEliminarexp.addMouseListener(this);
        vfHorascoordi.jtbAlumnos.addMouseListener(this);
        vfHorascoordi.txtCantidadhoras.addMouseListener(this);
        
        vfHorascoordi.cbAlumnos.addActionListener(e ->{
            if(e.getSource()== vfHorascoordi.cbAlumnos){
                Usuario selectedAlumno =(Usuario) vfHorascoordi.cbAlumnos.getSelectedItem();
                if(selectedAlumno != null){
                    String ida = selectedAlumno.getUUID_Usuario();
                    uscoordi.setUUID_Usuario(ida);
                    System.out.println("Esto es lo que se manda a traer de la base de datos (Usuario): " + selectedAlumno.getNombre()+ " con ID: " + ida);
                }
            }
        });
        
        excoordi.Mostrar(vfhorascoordi.jtbAlumnos);
            
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if (e.getSource() == vfhorascoordi.volverhoras){
            vfhorascoordi.dispose();
        }
        
        if(e.getSource() == vfhorascoordi.jtbAlumnos){
            excoordi.cargarDatosTablacoordi(vfhorascoordi);
        }
        
        if (e.getSource() == vfhorascoordi.btnAgregar){
            
            //Validaciones para el nombre del evento
            
            try {
                String nombreevento = vfhorascoordi.txtNombredelevento.getText().trim();
                if (nombreevento.isEmpty()) {
                    throw new IllegalArgumentException("El nombre del evento es obligatorio.");
                }
                
                if (!Character.isUpperCase(nombreevento.charAt(0))) {
                    JOptionPane.showMessageDialog(vfhorascoordi, "El nombre del evento debe comenzar con mayúscula");
                    return;
                }
                
                if (!nombreevento.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
                    throw new IllegalArgumentException("El nombre del evento solo puede contener letras.");
                }
            
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(vfhorascoordi, ex.getMessage());
                return;
            } 
                       
            // Validaciones para las horas del evento
            
            try {
            
            int horasNumericas = Integer.parseInt(vfhorascoordi.txtCantidadhoras.getText().trim());

            if (horasNumericas > 25) {
                throw new IllegalArgumentException("Las horas no pueden exceder de 25.");
            }

            excoordi.setHoras_agregadas(horasNumericas);
            
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(vfhorascoordi, "Las horas deben ser un valor numérico.");
                return;
            
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(vfhorascoordi, ex.getMessage());
                return;
            }
            
            if (uscoordi.getUUID_Usuario() == null || uscoordi.getUUID_Usuario().isEmpty()) {
                JOptionPane.showMessageDialog(vfhorascoordi, "Debe seleccionar un Alumno a quien asignar horas.");
                return;
            }
            
            excoordi.setNombre_evento(vfhorascoordi.txtNombredelevento.getText());
            
            int horasNumericas = Integer.parseInt(vfhorascoordi.txtCantidadhoras.getText().trim());
            excoordi.setHoras_agregadas(horasNumericas);
            
            excoordi.setUUID_Usuario(uscoordi.getUUID_Usuario());
            
            excoordi.Guardarhistorialalumno();
            JOptionPane.showMessageDialog(vfhorascoordi, "Expediente Guardado");
            excoordi.Mostrar(vfhorascoordi.jtbAlumnos);
         
        }
        
        if (e.getSource() == vfhorascoordi.btnEditar){
            
            //Validaciones para el nombre del evento
            try {
                String nombreevento = vfhorascoordi.txtNombredelevento.getText().trim();
                if (nombreevento.isEmpty()) {
                    throw new IllegalArgumentException("El nombre del evento es obligatorio.");
                }
                
                if (!Character.isUpperCase(nombreevento.charAt(0))) {
                    JOptionPane.showMessageDialog(vfhorascoordi, "El nombre del evento debe comenzar con mayúscula");
                    return;
                }
                
                if (!nombreevento.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
                    throw new IllegalArgumentException("El nombre del evento solo puede contener letras.");
                }
            
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(vfhorascoordi, ex.getMessage());
                return;
            } 
            
            try {
            
            int horasNumericas = Integer.parseInt(vfhorascoordi.txtCantidadhoras.getText().trim());

            if (horasNumericas > 25) {
                throw new IllegalArgumentException("Las horas no pueden exceder de 25.");
            }

            excoordi.setHoras_agregadas(horasNumericas);
            
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(vfhorascoordi, "Las horas deben ser un valor numérico.");
                return;
            
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(vfhorascoordi, ex.getMessage());
                return;
            }
            
            if (uscoordi.getUUID_Usuario() == null || uscoordi.getUUID_Usuario().isEmpty()) {
                JOptionPane.showMessageDialog(vfhorascoordi, "Debe seleccionar un Alumno a quien asignar horas.");
                return;
            }
            
            int horasNumericas = Integer.parseInt(vfhorascoordi.txtCantidadhoras.getText().trim());
            
            excoordi.setNombre_evento(vfhorascoordi.txtNombredelevento.getText()); 
            excoordi.setHoras_agregadas(horasNumericas);
            excoordi.setUUID_Usuario(uscoordi.getUUID_Usuario());
            excoordi.Actualizarhoras(vfhorascoordi.jtbAlumnos);
            
            JOptionPane.showMessageDialog(vfhorascoordi, "Expediente actualizado");
            excoordi.Mostrar(vfhorascoordi.jtbAlumnos);
            
        }
        
        /*if (e.getSource()== vfhorascoordi.btnEliminarexp){          
            
            int confirmacion = JOptionPane.showConfirmDialog(vfhorascoordi, "¿Seguro de eliminar este expediente?", "Eliminar", JOptionPane.YES_NO_OPTION);
            
            if (confirmacion == JOptionPane.YES_OPTION) {
                excoordi.Eliminarexpediente(vfhorascoordi.jtbAlumnos);
                excoordi.Mostrar(vfhorascoordi.jtbAlumnos);
                JOptionPane.showMessageDialog(vfhorascoordi, "Expediente eliminado.");
            } 
            else {
                JOptionPane.showMessageDialog(vfhorascoordi, "Acción Cancelada");
            }
            
        }*/
        
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        
        if (e.getSource()== vfhorascoordi.txtBuscaralum){          
            excoordi.BuscarAlumno(vfhorascoordi.jtbAlumnos, vfhorascoordi.txtBuscaralum); 
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
