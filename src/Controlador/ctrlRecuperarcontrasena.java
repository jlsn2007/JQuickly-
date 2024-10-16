package Controlador;

//import Modelo.EnviarCorreos;
import Vista.frmAgregarusuarios;
import Modelo.EnviarCorreos;
import Modelo.Usuario;
import Vista.frmRecuperarcontrasena;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.JOptionPane;


public class ctrlRecuperarcontrasena implements MouseListener, KeyListener{
    
    private Usuario ModeloUsrecucontra;
    private frmRecuperarcontrasena VistaRecucontrasena;
    public static String correoglobal;
    public static int codigorecuperacion;

    
    public ctrlRecuperarcontrasena(Usuario ModeUsRecuperarcontrasena, frmRecuperarcontrasena VisRecuperarcontrasena){
    
        this.ModeloUsrecucontra = ModeUsRecuperarcontrasena;
        this.VistaRecucontrasena = VisRecuperarcontrasena;
        
        VisRecuperarcontrasena.txtCorreorecu.addMouseListener(this);
        VisRecuperarcontrasena.btnSiguiente.addMouseListener(this);
        VisRecuperarcontrasena.Volverrecu.addMouseListener(this);
    }
    

    @Override
    public void mouseClicked(MouseEvent e) {
         
       if (e.getSource() == VistaRecucontrasena.btnSiguiente) {
           
           correoglobal = VistaRecucontrasena.txtCorreorecu.getText();
           
        // Validación del correo
        System.out.println("Se dió clic en el botón siguiente");
        
        if (!VistaRecucontrasena.txtCorreorecu.getText().endsWith("@ricaldone.edu.sv")) 
        {
            JOptionPane.showMessageDialog(VistaRecucontrasena, "El correo debe terminar con @ricaldone.edu.sv");
            return;
        } 
        
        Random random = new Random();
        
        int numeroAleatorio = 1000 + random.nextInt(9000);
        
        codigorecuperacion = numeroAleatorio;

        String recipient = VistaRecucontrasena.txtCorreorecu.getText();
        String subject = "¡Hey, Recupera tu contraseña rápido!";
        String content = "Recuerda guardar tu contraseña en un lugar seguro"
                + " para no olvidar de nuevo tu contraseña. "
                + ""
                + "Este es el código de recuperación: " + numeroAleatorio;
        
        EnviarCorreos.enviarCorreo(recipient, subject, content);

        Vista.frmCodigoverificacion.initfrmCodigoveri();
        VistaRecucontrasena.dispose();
        return;
        
    }
    
    if (e.getSource() == VistaRecucontrasena.Volverrecu) {
        Vista.frmLogin.initfrmLogin();
        VistaRecucontrasena.dispose();
        return;
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