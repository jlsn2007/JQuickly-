package Controlador;

import Vista.frmAgregarcomites;
import Vista.frmAgregarhoras;
import Vista.frmAgregarusuarios;
import Vista.frmExpedientes;
import Vista.panelPrincipal;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class ctrlpanelPrincipal implements MouseListener{
    
    panelPrincipal panel;
    frmAgregarusuarios vistaa;
    frmAgregarhoras vistaagregarhoras;
    frmExpedientes vistaexp;
    frmAgregarcomites vistcom;
    
    public ctrlpanelPrincipal(panelPrincipal Panel, frmAgregarusuarios Vistaa, frmAgregarhoras vistaAgregarhoras, frmExpedientes vistaExp, frmAgregarcomites vistaCom){
        
        this.panel = Panel;
        this.vistaa = Vistaa;
        this.vistaagregarhoras = vistaAgregarhoras;
        this.vistaexp = vistaExp;
        this.vistcom = vistaCom;
        
        panel.btnPagregarus.addMouseListener(this);
        panel.btnExpedientes.addMouseListener(this);
        panel.btngregarhoras.addMouseListener(this);
        panel.btnAgregarcomites.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if(e.getSource() == panel.btnPagregarus){ 
            Vista.frmAgregarusuarios.initfrmAgregarusuarios();      
        }     
        
        if(e.getSource() == panel.btnExpedientes){ 
            Vista.frmExpedientes.initfrmExpedientes();
        }
        
        if(e.getSource() == panel.btngregarhoras){ 
            Vista.frmAgregarhoras.initfrmAgregarhoras();
        }
        
        if(e.getSource() == panel.btnAgregarcomites){ 
            Vista.frmAgregarcomites.initfrmAgregarcomites();
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
