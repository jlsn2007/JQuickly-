package Controlador;

import Vista.frmAgregareventos;
import Vista.panelCalendario;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class ctrlpanelCalendario implements MouseListener {
    
    panelCalendario panel;
    frmAgregareventos vistaa;
    
    public ctrlpanelCalendario(panelCalendario Panel, frmAgregareventos Vistaa){
        
        this.panel = Panel;
        this.vistaa = Vistaa;
        
        panel.btnAgregareventos.addMouseListener(this);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
        if(e.getSource() == panel.btnAgregareventos){ 
            Vista.frmAgregareventos.initfrmAgregareventos();
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
