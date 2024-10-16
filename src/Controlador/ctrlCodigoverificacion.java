package Controlador;

import Modelo.EnviarCorreos;
import Modelo.Usuario;
import Vista.frmCodigoverificacion;
import Vista.frmReestablecercontrasena;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;


public class ctrlCodigoverificacion implements MouseListener, KeyListener{
    
    private Usuario Modelous;
    private frmCodigoverificacion  VisCodigoverificacion;
    
    public ctrlCodigoverificacion(Usuario usuarios, frmCodigoverificacion VisCodigoverificacion){

        this.Modelous = usuarios;
        this.VisCodigoverificacion = VisCodigoverificacion;

        
        VisCodigoverificacion.txtCodigo.addMouseListener(this);
        VisCodigoverificacion.btnVerificarcodigo.addMouseListener(this);
        VisCodigoverificacion.Volvercod.addMouseListener(this);
    }
    
    public void verificarCodigo(int codigo) {

        if (codigo == ctrlRecuperarcontrasena.codigorecuperacion) {

            frmReestablecercontrasena.initfrmRescontra();
            
            VisCodigoverificacion.dispose();  
            
        } else {
            JOptionPane.showMessageDialog(VisCodigoverificacion, "El código que has ingresado es incorrecto.", "Error", JOptionPane.ERROR_MESSAGE);
        }
}

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == VisCodigoverificacion.Volvercod) {
                      
            Vista.frmRecuperarcontrasena.initfrmRecucontra();
            VisCodigoverificacion.dispose();
            
        }
        
        if (e.getSource() == VisCodigoverificacion.btnVerificarcodigo) {
                        
            String codigoIngresado = VisCodigoverificacion.txtCodigo.getText().trim();
            
            if (codigoIngresado.isEmpty()) {

                JOptionPane.showMessageDialog(VisCodigoverificacion, "Ingrése el código que se le ha proporcionado");
                return;
            } 
            
            // Verificar si el código contiene solo números
            if (!codigoIngresado.matches("\\d+")) {
                JOptionPane.showMessageDialog(VisCodigoverificacion, "El código debe contener solo números");
                return;
            }
            
            // Verificar si el código tiene exactamente 4 dígitos
            if (codigoIngresado.length() != 4) {
                JOptionPane.showMessageDialog(VisCodigoverificacion, "Longitud del correo inválida");
                return;
            }
            
             try {
                    int codigo = Integer.parseInt(VisCodigoverificacion.txtCodigo.getText());
                    verificarCodigo(codigo);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(VisCodigoverificacion, "Por favor, ingrese un código válido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            
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