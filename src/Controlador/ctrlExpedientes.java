package Controlador;

import Modelo.Expediente;
import Modelo.Usuario;
import Vista.frmExpedientes;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ctrlExpedientes implements  MouseListener{
    
    private frmExpedientes vistaexpedientes;
    private Usuario modelousuario;
    private Expediente modeloexpediente;
    
    public ctrlExpedientes(frmExpedientes vistaExpedientes, Usuario modeloUsuario, Expediente modeloExpediente){
        
        this.vistaexpedientes = vistaExpedientes;
        this.modelousuario = modeloUsuario;
        this.modeloexpediente = modeloExpediente;
        
        vistaExpedientes.volverexp.addMouseListener(this);
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if (e.getSource() == vistaexpedientes.volverexp){
            vistaexpedientes.dispose();
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
