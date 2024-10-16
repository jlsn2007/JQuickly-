package Vista;

import Controlador.ctrlAgregarcomites;
import Modelo.Comite;
import javax.swing.ImageIcon;

public class frmAgregarcomites extends javax.swing.JFrame {

    public frmAgregarcomites() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/Imgs/quicklywindow.png")).getImage());
        setLocationRelativeTo(this);
        setSize(1015, 532); 
        setResizable(false);
    }
    
    public static void initfrmAgregarcomites(){
        
        frmAgregarcomites vComites = new frmAgregarcomites();
        Comite modCom = new Comite();
        
        ctrlAgregarcomites controlador = new ctrlAgregarcomites(vComites, modCom);
        
        vComites.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnEliminarcomite = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        volvercom = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtDescripcioncomite = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbComites = new javax.swing.JTable();
        txtCupos = new javax.swing.JTextField();
        txtNombrecomite = new javax.swing.JTextField();
        btnAgregarcomite = new javax.swing.JButton();
        txtBuscarcomite = new javax.swing.JTextField();
        btnEditarcomite = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        btnEliminarcomite.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/b.png"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        volvercom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/back.png"))); // NOI18N
        jPanel1.add(volvercom, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel1.setFont(new java.awt.Font("Inter 24pt ExtraBold", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 0));
        jLabel1.setText("Agregar Comites");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, -1, -1));

        txtDescripcioncomite.setBackground(new java.awt.Color(221, 221, 221));
        txtDescripcioncomite.setFont(new java.awt.Font("Inter 18pt SemiBold", 0, 12)); // NOI18N
        txtDescripcioncomite.setForeground(new java.awt.Color(102, 102, 102));
        txtDescripcioncomite.setText("Descripción del comité");
        txtDescripcioncomite.setBorder(null);
        jPanel1.add(txtDescripcioncomite, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 320, 110));

        jtbComites.setBackground(new java.awt.Color(255, 255, 255));
        jtbComites.setFont(new java.awt.Font("Inter 24pt ExtraBold", 0, 12)); // NOI18N
        jtbComites.setForeground(new java.awt.Color(0, 153, 0));
        jtbComites.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtbComites.setSelectionBackground(new java.awt.Color(0, 153, 0));
        jtbComites.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(jtbComites);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 110, 580, 330));

        txtCupos.setBackground(new java.awt.Color(221, 221, 221));
        txtCupos.setFont(new java.awt.Font("Inter 18pt SemiBold", 0, 12)); // NOI18N
        txtCupos.setForeground(new java.awt.Color(102, 102, 102));
        txtCupos.setText("Cupos");
        txtCupos.setBorder(null);
        jPanel1.add(txtCupos, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 320, 45));

        txtNombrecomite.setBackground(new java.awt.Color(221, 221, 221));
        txtNombrecomite.setFont(new java.awt.Font("Inter 18pt SemiBold", 0, 12)); // NOI18N
        txtNombrecomite.setForeground(new java.awt.Color(102, 102, 102));
        txtNombrecomite.setText("Nombre del comité");
        txtNombrecomite.setBorder(null);
        jPanel1.add(txtNombrecomite, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 320, 45));

        btnAgregarcomite.setBackground(new java.awt.Color(0, 153, 0));
        btnAgregarcomite.setFont(new java.awt.Font("Inter 24pt Black", 0, 12)); // NOI18N
        btnAgregarcomite.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarcomite.setText("Agregar");
        jPanel1.add(btnAgregarcomite, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, 160, 45));

        txtBuscarcomite.setBackground(new java.awt.Color(221, 221, 221));
        txtBuscarcomite.setFont(new java.awt.Font("Inter 18pt SemiBold", 0, 10)); // NOI18N
        txtBuscarcomite.setForeground(new java.awt.Color(102, 102, 102));
        txtBuscarcomite.setText("Buscar comité");
        txtBuscarcomite.setBorder(null);
        jPanel1.add(txtBuscarcomite, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 70, 380, 30));

        btnEditarcomite.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/e.png"))); // NOI18N
        jPanel1.add(btnEditarcomite, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 390, -1, -1));

        jLabel5.setFont(new java.awt.Font("Inter 24pt ExtraBold", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(207, 115, 207));
        jLabel5.setText("Editar");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 430, -1, -1));

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
            java.util.logging.Logger.getLogger(frmAgregarcomites.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmAgregarcomites.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmAgregarcomites.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmAgregarcomites.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                initfrmAgregarcomites();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAgregarcomite;
    public javax.swing.JLabel btnEditarcomite;
    public javax.swing.JLabel btnEliminarcomite;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jtbComites;
    public javax.swing.JTextField txtBuscarcomite;
    public javax.swing.JTextField txtCupos;
    public javax.swing.JTextField txtDescripcioncomite;
    public javax.swing.JTextField txtNombrecomite;
    public javax.swing.JLabel volvercom;
    // End of variables declaration//GEN-END:variables
}
