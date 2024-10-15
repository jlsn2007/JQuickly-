package Controlador;

import Vista.frmAgregarhorascoordi;
import Vista.panelPrincipalcoordi;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class ctrlpanelPrincipalcoordi implements MouseListener{
    
    panelPrincipalcoordi panelprincoordi;
    frmAgregarhorascoordi vhorascoordi;
    
    public ctrlpanelPrincipalcoordi(panelPrincipalcoordi panelPrincoordi, frmAgregarhorascoordi vHorascoordi){
        
        this.panelprincoordi = panelPrincoordi;
        this.vhorascoordi = vHorascoordi;
        
        panelprincoordi.btnAgregarhorascoordi.addMouseListener(this);
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if(e.getSource() == panelprincoordi.btnAgregarhorascoordi){ 
            Vista.frmAgregarhorascoordi.initfrmAgregarhorascoordi();
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
