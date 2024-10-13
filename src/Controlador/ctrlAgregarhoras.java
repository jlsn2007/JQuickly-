package Controlador;

import Modelo.Usuario;
import Vista.frmAgregarhoras;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ctrlAgregarhoras implements MouseListener{
    
    private frmAgregarhoras vistahoras;
    private Usuario modelousuario;
    
    public ctrlAgregarhoras(frmAgregarhoras Vistahoras, Usuario modeloUsuario){
        
        this.vistahoras = Vistahoras;
        this.modelousuario = modeloUsuario;
        
        vistahoras.volverhoras.addMouseListener(this);
        
    }
    
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
        if (e.getSource() == vistahoras.volverhoras){
            vistahoras.dispose();
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
