package Vista;

import Controlador.ctrlRecuperarcontrasena;
import Modelo.Usuario;
import javax.swing.ImageIcon;


public class frmRecuperarcontrasena extends javax.swing.JFrame {


    public frmRecuperarcontrasena() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/Imgs/quicklywindow.png")).getImage());
        setLocationRelativeTo(this);
        setSize(1015, 532); 
        setResizable(false);
    }
    
    public static void initfrmRecucontra(){
        Usuario Modelo = new Usuario();
        frmRecuperarcontrasena Vista = new frmRecuperarcontrasena();
        ctrlRecuperarcontrasena Controlador = new ctrlRecuperarcontrasena(Modelo, Vista);
        
        Vista.setVisible(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCorreorecu = new javax.swing.JTextField();
        btnSiguiente = new javax.swing.JButton();
        Volverrecu = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Inter 24pt ExtraBold", 0, 26)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("¿Has olvidado tu contraseña?");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, -1, -1));

        jLabel3.setFont(new java.awt.Font("Inter 18pt ExtraBold", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Ingresa tu correo para recibir un código");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 170, -1, -1));

        txtCorreorecu.setBackground(new java.awt.Color(230, 230, 230));
        txtCorreorecu.setFont(new java.awt.Font("Inter 18pt SemiBold", 0, 12)); // NOI18N
        txtCorreorecu.setForeground(new java.awt.Color(102, 102, 102));
        txtCorreorecu.setText("Correo electrónico");
        txtCorreorecu.setBorder(null);
        jPanel1.add(txtCorreorecu, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 210, 345, 50));

        btnSiguiente.setBackground(new java.awt.Color(54, 161, 68));
        btnSiguiente.setFont(new java.awt.Font("Inter 24pt ExtraBold", 0, 12)); // NOI18N
        btnSiguiente.setForeground(new java.awt.Color(255, 255, 255));
        btnSiguiente.setText("Siguiente");
        jPanel1.add(btnSiguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 290, 200, 45));

        Volverrecu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/back.png"))); // NOI18N
        jPanel1.add(Volverrecu, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/Recucontra.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1015, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmRecuperarcontrasena.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmRecuperarcontrasena.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmRecuperarcontrasena.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmRecuperarcontrasena.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                initfrmRecucontra();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel Volverrecu;
    public javax.swing.JButton btnSiguiente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JTextField txtCorreorecu;
    // End of variables declaration//GEN-END:variables
}
