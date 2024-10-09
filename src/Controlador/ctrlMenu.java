package Controlador;


import Vista.frmMenu;
import Vista.panelCalendario;
import Vista.panelPerfil;
import Vista.panelPrincipal;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class ctrlMenu implements MouseListener{
    
    frmMenu vistaa;
    
    
    public ctrlMenu(frmMenu Vista){
        
        this.vistaa = Vista;
     
        vistaa.btnProfile.addMouseListener(this);
        vistaa.btnHome.addMouseListener(this);
        vistaa.btnCalendar.addMouseListener(this);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if(e.getSource() == vistaa.btnHome){
            panelPrincipal objprin = new panelPrincipal();
            
            vistaa.jpContenedor.removeAll();
            vistaa.jpContenedor.add(objprin);
            vistaa.jpContenedor.revalidate();
            vistaa.jpContenedor.repaint();
            
        }
        
        if(e.getSource() == vistaa.btnCalendar){
            panelCalendario objcal = new panelCalendario();
            
            vistaa.jpContenedor.removeAll();
            vistaa.jpContenedor.add(objcal);
            vistaa.jpContenedor.revalidate();
            vistaa.jpContenedor.repaint();
        }
        
        if(e.getSource() == vistaa.btnProfile){
            panelPerfil objprof = new panelPerfil();
            
            vistaa.jpContenedor.removeAll();
            vistaa.jpContenedor.add(objprof);
            vistaa.jpContenedor.revalidate();
            vistaa.jpContenedor.repaint();
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