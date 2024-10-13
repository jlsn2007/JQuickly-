package Controlador;

import Modelo.Eventos;
import Modelo.Usuario;
import Vista.frmAgregareventos;
import Vista.frmMenu;
import Vista.panelCalendario;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;



public class ctrlAgregareventos implements MouseListener{

    private frmMenu vistaa;
    private panelCalendario panel;
    private frmAgregareventos vistaagregareventos;
    
    private Eventos ModeloEventos;
    private Usuario ModeloUsuario;
    
    
    public ctrlAgregareventos (frmMenu Vistaa, panelCalendario Panel, frmAgregareventos VistaaAgregareventos, Eventos modeEventos, Usuario modeUs){
        
        this.vistaagregareventos = VistaaAgregareventos;
        this.vistaa = Vistaa;
        this.panel = Panel;
        this.ModeloEventos = modeEventos;
        this.ModeloUsuario = modeUs;
        
        
        this.vistaagregareventos.cbUsuarios.addMouseListener(this);
        this.ModeloUsuario.CargarComboboxUsuarios(vistaagregareventos.cbUsuarios);
            
        
        vistaa.jpContenedor.addMouseListener(this);
        
        VistaaAgregareventos.btnvolvercalendario.addMouseListener(this);
        VistaaAgregareventos.btnAgregareventos.addMouseListener(this);
        VistaaAgregareventos.btnEditar.addMouseListener(this);
        VistaaAgregareventos.btnEliminar.addMouseListener(this);
        VistaaAgregareventos.txtNombreevento.addMouseListener(this);
        VistaaAgregareventos.txtDescripcion.addMouseListener(this);
        VistaaAgregareventos.txtLugar.addMouseListener(this);
        VistaaAgregareventos.txtFecha.addMouseListener(this);
        VistaaAgregareventos.txtHora.addMouseListener(this);
        VistaaAgregareventos.jtbEventos.addMouseListener(this);
        
        vistaagregareventos.cbUsuarios.addActionListener(e ->{
            if(e.getSource()== vistaagregareventos.cbUsuarios){
            Usuario selectedItem =(Usuario) vistaagregareventos.cbUsuarios.getSelectedItem();
            if(selectedItem != null){
                String idus =selectedItem.getUUID_Usuario();
                ModeloUsuario.setUUID_Usuario(idus);
            }
        }
        });
        
        ModeloEventos.MostrarEventos(vistaagregareventos.jtbEventos);
        
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
        if(e.getSource() == vistaagregareventos.btnvolvercalendario){
            System.out.println("Se dio clic en el botón para volver al frmmenu");
            vistaagregareventos.dispose();
        }
        
        //Botón para guardar un usuario nuevo
        
        if(e.getSource()== vistaagregareventos.btnAgregareventos){
            
            //Validaciones para el nombre del evento
            
            if (vistaagregareventos.txtNombreevento.getText().isEmpty()) {

                JOptionPane.showMessageDialog(vistaagregareventos, "El nombre del evento es obligatorio");
                return;
            }
            
            //Validaciones para el lugar del evento
            
            if (vistaagregareventos.txtDescripcion.getText().isEmpty()) {

                JOptionPane.showMessageDialog(vistaagregareventos, "La descripción del evento es obligatoria");
                return;
            } 
            
            
            
            //Validaciones para la descripciÃ³n del evento
            
            if (vistaagregareventos.txtLugar.getText().isEmpty()) {

                JOptionPane.showMessageDialog(vistaagregareventos, "La ubicación del evento es obligatoria");
                return;
            } 
            
            //Validaciones para la fecha del evento
            
            if (vistaagregareventos.txtFecha.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaagregareventos, "La fecha del evento es obligatoria");
                return;
            } else { 
              // Verificar si el formato de la fecha es vÃ¡lido
              String fecha = vistaagregareventos.txtFecha.getText();
              
              if (!fecha.matches("\\d{2}-\\d{2}-\\d{4}")) { // DD-MM-YYY
                  JOptionPane.showMessageDialog(vistaagregareventos, "La fecha debe tener el formato DD-MM-YYYY");
                  return;
              }
            } 
            
            //Validaciones para la hora del evento
            
            if (vistaagregareventos.txtHora.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaagregareventos, "La hora del evento es obligatoria");
                return;
            } else {
              // Verificar si el formato de la hora es válido
              String hora = vistaagregareventos.txtHora.getText();
              if (!hora.matches("\\d{2}:\\d{2}")) { // HH:MM
                  JOptionPane.showMessageDialog(vistaagregareventos, "La hora debe tener el formato HH:MM");
                  return;
              }
            }
            
            
            ModeloEventos.setNombre(vistaagregareventos.txtNombreevento.getText());
            ModeloEventos.setDescripcion(vistaagregareventos.txtDescripcion.getText());
            ModeloEventos.setLugar(vistaagregareventos.txtLugar.getText());
            ModeloEventos.setFecha(vistaagregareventos.txtFecha.getText());
            ModeloEventos.setHora(vistaagregareventos.txtHora.getText());
            ModeloEventos.setUUID_Usuario(ModeloUsuario.getUUID_Usuario());
            
            ModeloEventos.Agregarevento();
            
            //Muestro una alerta que el evento se ha guardado
            
            JOptionPane.showMessageDialog(vistaagregareventos, "Evento Agregado");
            
            ModeloEventos.MostrarEventos(vistaagregareventos.jtbEventos);
            
        }
        
        // Botón para editar eventos
        
        if(e.getSource()== vistaagregareventos.btnEditar){
            
            ModeloEventos.setNombre(vistaagregareventos.txtNombreevento.getText());
            ModeloEventos.setDescripcion(vistaagregareventos.txtDescripcion.getText());
            ModeloEventos.setLugar(vistaagregareventos.txtLugar.getText());
            ModeloEventos.setFecha(vistaagregareventos.txtFecha.getText());
            ModeloEventos.setHora(vistaagregareventos.txtHora.getText());
            
            ModeloEventos.ActualizarEvento(vistaagregareventos.jtbEventos);
            ModeloEventos.MostrarEventos(vistaagregareventos.jtbEventos);
  
        }
        
        //Botón para eliminar eventos
        
        if(e.getSource()== vistaagregareventos.btnEliminar){
            
            System.err.println("Se ha eliminado un Evento");
            
            ModeloEventos.EliminarEvento(vistaagregareventos.jtbEventos);
            ModeloEventos.MostrarEventos(vistaagregareventos.jtbEventos);
  
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

