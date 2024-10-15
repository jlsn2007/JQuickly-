package Controlador;

import Vista.frmAgregareventoscoordi;
import Vista.panelCalendariocoordi;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class ctrlpanelCalendariocoordi implements MouseListener{
    
    panelCalendariocoordi panelcoordi;
    frmAgregareventoscoordi vistaeventoscoordi;
    
    public ctrlpanelCalendariocoordi (panelCalendariocoordi Panelcoordi, frmAgregareventoscoordi Vistaeventoscoordi){
        
        this.panelcoordi = Panelcoordi;
        this.vistaeventoscoordi = Vistaeventoscoordi;
        
        panelcoordi.btnAgregareventoscoordi.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if(e.getSource() == panelcoordi.btnAgregareventoscoordi){ 
            Vista.frmAgregareventoscoordi.initfrmAgregareventoscoordi();
            vistaeventoscoordi.dispose();
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
