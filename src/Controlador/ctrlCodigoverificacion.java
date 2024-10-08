package Controlador;

import Modelo.Usuario;
import Vista.frmCodigoverificacion;
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

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == VisCodigoverificacion.Volvercod) {
                      
            Vista.frmRecuperarcontrasena.initfrmRecucontra();
            VisCodigoverificacion.dispose();
            
        }
        
        if (e.getSource() == VisCodigoverificacion.btnVerificarcodigo) {
            
            if (VisCodigoverificacion.txtCodigo.getText().isEmpty()) {

                JOptionPane.showMessageDialog(VisCodigoverificacion, "Ingrése el código que se le ha proporcionado");
                return;
            } 
            
            Vista.frmReestablecercontrasena.initfrmRescontra();
            VisCodigoverificacion.dispose();
            
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