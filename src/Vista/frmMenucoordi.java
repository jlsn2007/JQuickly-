package Vista;

import Controlador.ctrlMenucoordi;
import javax.swing.ImageIcon;


public class frmMenucoordi extends javax.swing.JFrame {


    public frmMenucoordi() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/Imgs/quicklywindow.png")).getImage());
        setLocationRelativeTo(this);
        setSize(1015, 532); 
        setResizable(false);
    }
    
    public static void initfrmMenucoordi(){
        
        frmMenucoordi vista = new frmMenucoordi();
        
        ctrlMenucoordi controlador = new ctrlMenucoordi(vista);
        
        vista.setVisible(true);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpContenedorc = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnHomec = new javax.swing.JLabel();
        btnCalendarc = new javax.swing.JLabel();
        btnLogout = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpContenedorc.setBackground(new java.awt.Color(255, 255, 255));
        jpContenedorc.setLayout(new java.awt.BorderLayout());

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/Quickly.png"))); // NOI18N
        jpContenedorc.add(jLabel4, java.awt.BorderLayout.CENTER);

        jPanel2.setBackground(new java.awt.Color(17, 22, 31));

        btnHomec.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/Casa.png"))); // NOI18N

        btnCalendarc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/Calen.png"))); // NOI18N

        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/logout.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(btnHomec)
                .addGap(69, 69, 69)
                .addComponent(btnCalendarc)
                .addGap(71, 71, 71)
                .addComponent(btnLogout)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnLogout)
                    .addComponent(btnCalendarc)
                    .addComponent(btnHomec))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpContenedorc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jpContenedorc, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE))
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
            java.util.logging.Logger.getLogger(frmMenucoordi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMenucoordi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMenucoordi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMenucoordi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                initfrmMenucoordi();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel btnCalendarc;
    public javax.swing.JLabel btnHomec;
    public javax.swing.JLabel btnLogout;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JPanel jpContenedorc;
    // End of variables declaration//GEN-END:variables
}
