package Controlador;

import Vista.frmMenucoordi;
import Vista.panelCalendariocoordi;
import Vista.panelPrincipalcoordi;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class ctrlMenucoordi implements MouseListener{
    
    frmMenucoordi vistacord;
    
    public ctrlMenucoordi(frmMenucoordi vistaCord){
        
        this.vistacord = vistaCord;
     
        vistacord.btnHomec.addMouseListener(this);
        vistacord.btnCalendarc.addMouseListener(this);
        vistacord.btnLogout.addMouseListener(this);

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if(e.getSource() == vistacord.btnHomec){
            
            panelPrincipalcoordi objprinc = new panelPrincipalcoordi();
            
            vistacord.jpContenedorc.removeAll();
            vistacord.jpContenedorc.add(objprinc);
            vistacord.jpContenedorc.revalidate();
            vistacord.jpContenedorc.repaint();
            
        }
        
        if(e.getSource() == vistacord.btnCalendarc){
            
            panelCalendariocoordi objcalc = new panelCalendariocoordi();
            
            vistacord.jpContenedorc.removeAll();
            vistacord.jpContenedorc.add(objcalc);
            vistacord.jpContenedorc.revalidate();
            vistacord.jpContenedorc.repaint();
        }
        
        if(e.getSource() == vistacord.btnLogout){
            Vista.frmLogin.initfrmLogin();
            vistacord.dispose();
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
