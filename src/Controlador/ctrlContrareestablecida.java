package Controlador;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import Modelo.Usuario;
import Vista.frmLogin;
import Vista.frmContrasenrestablecida;


public class ctrlContrareestablecida implements MouseListener, KeyListener{
    
    private Usuario ModeloUsuarios;
    private frmContrasenrestablecida Vistacontrares;

    public ctrlContrareestablecida(Usuario contrasenareestablecida, frmContrasenrestablecida frmcontrares) {
        
        this.ModeloUsuarios = contrasenareestablecida;
        this.Vistacontrares = frmcontrares;
        
        frmcontrares.btnEmpezar.addMouseListener(this);
   
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if(e.getSource() == Vistacontrares.btnEmpezar) {
            Vista.frmLogin.initfrmLogin();
            Vistacontrares.dispose();
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

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}