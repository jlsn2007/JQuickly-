package Controlador;

import Modelo.Comite;
import Vista.frmAgregarcomites;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ctrlAgregarcomites implements MouseListener{

    private frmAgregarcomites vistacom;
    private Comite modelocomite;
    
    public ctrlAgregarcomites(frmAgregarcomites vistaCom, Comite modeloComite){
        
        this.vistacom = vistaCom;
        this.modelocomite = modeloComite;
        
        vistacom.volvercom.addMouseListener(this);
        
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
        if (e.getSource() == vistacom.volvercom){
            vistacom.dispose();
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
