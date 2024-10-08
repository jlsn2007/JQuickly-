package Controlador;

import Vista.frmAgregarusuarios;
import Vista.panelPrincipal;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class ctrlpanelPrincipal implements MouseListener{
    
    panelPrincipal panel;
    frmAgregarusuarios vistaa;
    
    public ctrlpanelPrincipal(panelPrincipal Panel, frmAgregarusuarios Vistaa){
        
        this.panel = Panel;
        this.vistaa = Vistaa;
        
        panel.btnPagregarus.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if(e.getSource() == panel.btnPagregarus){ 
            Vista.frmAgregarusuarios.initfrmAgregarusuarios();
            vistaa.dispose();
            
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
