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
            String nuevaContra = VistafrmRescontra.txtNewcontra.getText();
            String confirmarContra = VistafrmRescontra.txtNewcontradnv.getText();

            // Validar longitud de la contraseÃ±a nueva
            if (nuevaContra.length() < 7) {
                JOptionPane.showMessageDialog(VistafrmRescontra, "La contraseÃ±a debe tener mÃ¡s de 7 caracteres");
                return;
            }

            // Validar longitud de la confirmaciÃ³n de contraseÃ±a
            if (confirmarContra.length() < 7) {
                JOptionPane.showMessageDialog(VistafrmRescontra, "La confirmaciÃ³n de la contraseÃ±a debe tener mÃ¡s de 7 caracteres");
                return;
            }

            // Validar que ambas contraseÃ±as sean iguales
            if (!nuevaContra.equals(confirmarContra)) {
                JOptionPane.showMessageDialog(VistafrmRescontra, "Las contraseÃ±as no coinciden, favor de verificarlas");
                return;
            }

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