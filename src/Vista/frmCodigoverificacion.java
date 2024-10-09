package Vista;

import Controlador.ctrlCodigoverificacion;
import Modelo.Usuario;


public class frmCodigoverificacion extends javax.swing.JFrame {


    public frmCodigoverificacion() {
        initComponents();
    }
    
    public static void initfrmCodigoveri(){
        Usuario Modelo = new Usuario();
        frmCodigoverificacion Vista = new frmCodigoverificacion();
        ctrlCodigoverificacion Controlador = new ctrlCodigoverificacion(Modelo, Vista);
        
        Vista.setVisible(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        btnVerificarcodigo = new javax.swing.JButton();
        Volvercod = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Inter 18pt ExtraBold", 0, 26)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("¡Ingresa el código que recibiste!");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, -1, -1));

        txtCodigo.setBackground(new java.awt.Color(230, 230, 230));
        txtCodigo.setFont(new java.awt.Font("Inter 18pt SemiBold", 0, 12)); // NOI18N
        txtCodigo.setForeground(new java.awt.Color(102, 102, 102));
        txtCodigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCodigo.setText("XXXX");
        jPanel3.add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 200, 345, 50));

        btnVerificarcodigo.setBackground(new java.awt.Color(255, 224, 192));
        btnVerificarcodigo.setFont(new java.awt.Font("Inter 24pt ExtraBold", 0, 12)); // NOI18N
        btnVerificarcodigo.setForeground(new java.awt.Color(255, 153, 0));
        btnVerificarcodigo.setText("Veríficar");
        jPanel3.add(btnVerificarcodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 270, 200, 45));

        Volvercod.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/back.png"))); // NOI18N
        jPanel3.add(Volvercod, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/Codigoverificacion.png"))); // NOI18N
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            java.util.logging.Logger.getLogger(frmCodigoverificacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmCodigoverificacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmCodigoverificacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmCodigoverificacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                initfrmCodigoveri();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel Volvercod;
    public javax.swing.JButton btnVerificarcodigo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel3;
    public javax.swing.JTextField txtCodigo;
    // End of variables declaration//GEN-END:variables
}
