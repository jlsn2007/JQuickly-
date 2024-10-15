package Controlador;

import Modelo.Eventos;
import Modelo.Usuario;
import Vista.frmAgregareventos;
import Vista.frmMenu;
import Vista.panelCalendario;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;


public class ctrlAgregareventos implements MouseListener, KeyListener{

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
        VistaaAgregareventos.txtBuscarev.addKeyListener(this);
        
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
            
            //Validaciones para la descripción del evento
            
            if (vistaagregareventos.txtDescripcion.getText().isEmpty()) {

                JOptionPane.showMessageDialog(vistaagregareventos, "La descripción del evento es obligatoria");
                return;
            } 
            
            //Validaciones para el lugar del evento
            
            if (vistaagregareventos.txtLugar.getText().isEmpty()) {

                JOptionPane.showMessageDialog(vistaagregareventos, "La ubicación del evento es obligatoria");
                return;
            } 
            
            //Validaciones para la fecha del evento
            
            if (vistaagregareventos.txtFecha.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaagregareventos, "La fecha del evento es obligatoria");
                return;
            } 
            
            else { 
              // Verificar si el formato de la fecha es válido
              String fecha = vistaagregareventos.txtFecha.getText();
              
              if (!fecha.matches("\\d{2}-\\d{2}-\\d{4}")) { // DD-MM-YYY
                  JOptionPane.showMessageDialog(vistaagregareventos, "La fecha debe tener el formato DD-MM-YYYY");
                  return;
              }
              
              String[] partesFecha = fecha.split("-");
              int dia = Integer.parseInt(partesFecha[0]);
              int mes = Integer.parseInt(partesFecha[1]);
              int anio = Integer.parseInt(partesFecha[2]);

              // Validar si la fecha es lógica
              
              if (mes < 1 || mes > 12) {
                  JOptionPane.showMessageDialog(vistaagregareventos, "El mes debe estar entre 1 y 12");
                  return;
              }
              
              if (dia < 1 || dia > 31) {
                  JOptionPane.showMessageDialog(vistaagregareventos, "El día debe estar entre 1 y 31");
                  return;
              }
              
              // Verificar los días del més
              
              if ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && dia > 30) {
                  JOptionPane.showMessageDialog(vistaagregareventos, "El mes seleccionado solo tiene 30 días");
                  return;
              }
              
              // Verificar años bisiestos
              
              if (mes == 2) { 
                  boolean Bisiesto = (anio % 4 == 0 && (anio % 100 != 0 || anio % 400 == 0));
                  if (Bisiesto && dia > 29) {
                      JOptionPane.showMessageDialog(vistaagregareventos, "Febrero solo tiene 29 días en años bisiestos");
                      return;
                  } else if (!Bisiesto && dia > 28) {
                      JOptionPane.showMessageDialog(vistaagregareventos, "Febrero solo tiene 28 días en años no bisiestos");
                      return;
                  }
              }
            } 
            
            //Validaciones para la hora del evento
            
            if (vistaagregareventos.txtHora.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaagregareventos, "La hora del evento es obligatoria");
                return;
            } 
            else {
              
              String hora = vistaagregareventos.txtHora.getText();
              if (!hora.matches("\\d{2}:\\d{2}")) {
                  JOptionPane.showMessageDialog(vistaagregareventos, "La hora debe tener el formato HH:MM");
                  return;
              }
              
              String[] partesHora = hora.split(":");
              int horas = Integer.parseInt(partesHora[0]);
              int minutos = Integer.parseInt(partesHora[1]);
              
              if (horas < 0 || horas > 23) {
                  JOptionPane.showMessageDialog(vistaagregareventos, "La hora debe estar entre 00 y 23");
                  return;
              }
              
              if (minutos < 0 || minutos > 59) {
                  JOptionPane.showMessageDialog(vistaagregareventos, "Los minutos deben estar entre 00 y 59");
                  return;
              }
            }
            
            //Validación para el combobox Usuarios
            
            try {
                if (vistaagregareventos.cbUsuarios.getSelectedIndex() == 0) {
                    throw new IllegalArgumentException("Debe seleccionar un Usuario.");
                }
            
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(vistaagregareventos, ex.getMessage());
                return;
            }
            
            
            ModeloEventos.setNombre(vistaagregareventos.txtNombreevento.getText());
            ModeloEventos.setDescripcion(vistaagregareventos.txtDescripcion.getText());
            ModeloEventos.setLugar(vistaagregareventos.txtLugar.getText());
            ModeloEventos.setFecha(vistaagregareventos.txtFecha.getText());
            ModeloEventos.setHora(vistaagregareventos.txtHora.getText());
            ModeloEventos.setUUID_Usuario(ModeloUsuario.getUUID_Usuario());
   
            ModeloEventos.Agregarevento();
            JOptionPane.showMessageDialog(vistaagregareventos, "Evento Agregado");
            ModeloEventos.MostrarEventos(vistaagregareventos.jtbEventos);
            
        }
        
        // Botón para editar eventos
        
        if(e.getSource()== vistaagregareventos.btnEditar){
            
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
            
            //Validaciones para la descripción del evento
            
            if (vistaagregareventos.txtLugar.getText().isEmpty()) {

                JOptionPane.showMessageDialog(vistaagregareventos, "La ubicación del evento es obligatoria");
                return;
            } 
            
            //Validaciones para la fecha del evento
            
            if (vistaagregareventos.txtFecha.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaagregareventos, "La fecha del evento es obligatoria");
                return;
            } 
            
            else { 
              // Verificar si el formato de la fecha es válido
              String fecha = vistaagregareventos.txtFecha.getText();
              
              if (!fecha.matches("\\d{2}-\\d{2}-\\d{4}")) { // DD-MM-YYY
                  JOptionPane.showMessageDialog(vistaagregareventos, "La fecha debe tener el formato DD-MM-YYYY");
                  return;
              }
              
              String[] partesFecha = fecha.split("-");
              int dia = Integer.parseInt(partesFecha[0]);
              int mes = Integer.parseInt(partesFecha[1]);
              int anio = Integer.parseInt(partesFecha[2]);

              // Validar si la fecha es lógica
              
              if (mes < 1 || mes > 12) {
                  JOptionPane.showMessageDialog(vistaagregareventos, "El mes debe estar entre 1 y 12");
                  return;
              }
              
              if (dia < 1 || dia > 31) {
                  JOptionPane.showMessageDialog(vistaagregareventos, "El día debe estar entre 1 y 31");
                  return;
              }
              
              // Verificar los días del més
              
              if ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && dia > 30) {
                  JOptionPane.showMessageDialog(vistaagregareventos, "El mes seleccionado solo tiene 30 días");
                  return;
              }
              
              // Verificar años bisiestos
              
              if (mes == 2) { 
                  boolean Bisiesto = (anio % 4 == 0 && (anio % 100 != 0 || anio % 400 == 0));
                  if (Bisiesto && dia > 29) {
                      JOptionPane.showMessageDialog(vistaagregareventos, "Febrero solo tiene 29 días en años bisiestos");
                      return;
                  } else if (!Bisiesto && dia > 28) {
                      JOptionPane.showMessageDialog(vistaagregareventos, "Febrero solo tiene 28 días en años no bisiestos");
                      return;
                  }
              }
            } 
            
            //Validaciones para la hora del evento
            
            if (vistaagregareventos.txtHora.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaagregareventos, "La hora del evento es obligatoria");
                return;
            } 
            else {
              
              String hora = vistaagregareventos.txtHora.getText();
              if (!hora.matches("\\d{2}:\\d{2}")) {
                  JOptionPane.showMessageDialog(vistaagregareventos, "La hora debe tener el formato HH:MM");
                  return;
              }
              
              String[] partesHora = hora.split(":");
              int horas = Integer.parseInt(partesHora[0]);
              int minutos = Integer.parseInt(partesHora[1]);
              
              if (horas < 0 || horas > 23) {
                  JOptionPane.showMessageDialog(vistaagregareventos, "La hora debe estar entre 00 y 23");
                  return;
              }
              
              if (minutos < 0 || minutos > 59) {
                  JOptionPane.showMessageDialog(vistaagregareventos, "Los minutos deben estar entre 00 y 59");
                  return;
              }
            }
                      
            //Validación para el combobox Usuarios
            
            try {
                if (vistaagregareventos.cbUsuarios.getSelectedIndex() == 0) {
                    throw new IllegalArgumentException("Debe seleccionar un Usuario.");
                }
            
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(vistaagregareventos, ex.getMessage());
                return;
            }
            
            ModeloEventos.setNombre(vistaagregareventos.txtNombreevento.getText());
            ModeloEventos.setDescripcion(vistaagregareventos.txtDescripcion.getText());
            ModeloEventos.setLugar(vistaagregareventos.txtLugar.getText());
            ModeloEventos.setFecha(vistaagregareventos.txtFecha.getText());
            ModeloEventos.setHora(vistaagregareventos.txtHora.getText());
            
            ModeloEventos.ActualizarEvento(vistaagregareventos.jtbEventos);
            JOptionPane.showMessageDialog(vistaagregareventos, "Evento actualizado");
            ModeloEventos.MostrarEventos(vistaagregareventos.jtbEventos);
  
        }
        
        //Botón para eliminar eventos
        
        if(e.getSource() == vistaagregareventos.btnEliminar){
            
            int confirmacion = JOptionPane.showConfirmDialog(
                    vistaagregareventos, "¿Seguro de eliminar este evento?", "Eliminar", JOptionPane.YES_NO_OPTION
            );
            
            if (confirmacion == JOptionPane.YES_OPTION) {
                
                ModeloEventos.EliminarEvento(vistaagregareventos.jtbEventos);
                ModeloEventos.MostrarEventos(vistaagregareventos.jtbEventos);
                JOptionPane.showMessageDialog(vistaagregareventos, "Evento eliminado.");
            } 
            else {
                JOptionPane.showMessageDialog(vistaagregareventos, "Acción Cancelada");
            }
        }
        
        if(e.getSource() == vistaagregareventos.jtbEventos){
            ModeloEventos.cargarDatosTabla(vistaagregareventos);
        }
        
    }
    
    @Override
    public void keyReleased(KeyEvent e) {

        if (e.getSource()== vistaagregareventos.txtBuscarev){          
            ModeloEventos.BuscarEventos(vistaagregareventos.jtbEventos, vistaagregareventos.txtBuscarev); 
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

