package Controlador;

import Modelo.Usuario;
import Vista.frmReestablecercontrasena;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

public class ctrlReestablecercontrasena implements MouseListener, KeyListener{
    
    private Usuario ModeloUsrescontra;
    private frmReestablecercontrasena VistafrmRescontra;
    public static String nuevacontra;
    
    public ctrlReestablecercontrasena(Usuario ModeUsrescontra, frmReestablecercontrasena Visfrmrescontra){
        
        this.ModeloUsrescontra = ModeUsrescontra;
        this.VistafrmRescontra = Visfrmrescontra;
        
        Visfrmrescontra.txtNewcontra.addMouseListener(this);
        Visfrmrescontra.txtNewcontradnv.addMouseListener(this);
        Visfrmrescontra.btnSiguiente.addMouseListener(this);
        Visfrmrescontra.Volverres.addMouseListener(this);
        
    }
    

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if (e.getSource() == VistafrmRescontra.Volverres) {
           Vista.frmCodigoverificacion.initfrmCodigoveri();
           VistafrmRescontra.dispose();
           return;
        }
         
        if (e.getSource() == VistafrmRescontra.btnSiguiente) {
            
            nuevacontra = ModeloUsrescontra.SHA256(VistafrmRescontra.txtNewcontradnv.getText());
            
            String nuevaContra = VistafrmRescontra.txtNewcontra.getText();
            String confirmarContra = VistafrmRescontra.txtNewcontradnv.getText();

            // Validar longitud de la contraseña nueva
            if (nuevaContra.length() < 7) {
                JOptionPane.showMessageDialog(VistafrmRescontra, "La contraseña debe tener más de 7 caracteres");
                return;
            }

            // Validar longitud de la confirmación de contraseña
            if (confirmarContra.length() < 7) {
                JOptionPane.showMessageDialog(VistafrmRescontra, "La confirmación de la contraseña debe tener más de 7 caracteres");
                return;
            }

            // Validar que ambas contraseñas sean iguales
            if (!nuevaContra.equals(confirmarContra)) {
                JOptionPane.showMessageDialog(VistafrmRescontra, "Las contraseñas no coinciden, favor de verificarlas");
                return;
            }
            
            ModeloUsrescontra.Actualizarcontra(ModeloUsrescontra);            
            // Si pasa todas las validaciones
            
            Vista.frmContrasenrestablecida.initfrmContrares();
            VistafrmRescontra.dispose();
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