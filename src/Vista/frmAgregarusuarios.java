package Vista;

import Controlador.ctrlAgregarusuarios;
import Modelo.Comite;
import Modelo.Grado;
import Modelo.Rol;
import Modelo.Usuario;


public class frmAgregarusuarios extends javax.swing.JFrame {


    public frmAgregarusuarios() {
        initComponents();
    }
    
    public static void initfrmAgregarusuarios(){
      
       frmAgregarusuarios vista2 = new frmAgregarusuarios();
       Rol modeloRol = new Rol();
       Grado modeloGrado = new Grado();
       Comite modeloComite = new Comite();
       Usuario modeloUsuario = new Usuario();
       
       ctrlAgregarusuarios controlador = new ctrlAgregarusuarios(vista2, modeloRol, modeloGrado, modeloComite, modeloUsuario);
       
       vista2.setVisible(true);
   }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombreus = new javax.swing.JTextField();
        txtContraus = new javax.swing.JTextField();
        txtCorreous = new javax.swing.JTextField();
        cbRol = new javax.swing.JComboBox<>();
        cbGrado = new javax.swing.JComboBox<>();
        cbComite = new javax.swing.JComboBox<>();
        btnAgregarusuarios = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbUsuarios = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        volverprin = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JLabel();
        btnEditar = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Inter 24pt ExtraBold", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(99, 99, 209));
        jLabel1.setText("Agregar Usuarios");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, -1, -1));

        txtNombreus.setBackground(new java.awt.Color(230, 230, 230));
        txtNombreus.setFont(new java.awt.Font("Inter 18pt SemiBold", 0, 12)); // NOI18N
        txtNombreus.setForeground(new java.awt.Color(102, 102, 102));
        txtNombreus.setText("Nombre");
        txtNombreus.setBorder(null);
        txtNombreus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreusActionPerformed(evt);
            }
        });
        jPanel1.add(txtNombreus, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 345, 50));

        txtContraus.setBackground(new java.awt.Color(230, 230, 230));
        txtContraus.setFont(new java.awt.Font("Inter 18pt SemiBold", 0, 12)); // NOI18N
        txtContraus.setForeground(new java.awt.Color(102, 102, 102));
        txtContraus.setText("Contraseña");
        txtContraus.setBorder(null);
        jPanel1.add(txtContraus, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 345, 50));

        txtCorreous.setBackground(new java.awt.Color(230, 230, 230));
        txtCorreous.setFont(new java.awt.Font("Inter 18pt SemiBold", 0, 12)); // NOI18N
        txtCorreous.setForeground(new java.awt.Color(102, 102, 102));
        txtCorreous.setText("Correo electrónico");
        txtCorreous.setBorder(null);
        jPanel1.add(txtCorreous, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 345, 50));

        cbRol.setBackground(new java.awt.Color(230, 230, 230));
        cbRol.setFont(new java.awt.Font("Inter 18pt SemiBold", 0, 12)); // NOI18N
        cbRol.setForeground(new java.awt.Color(102, 102, 102));
        cbRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cbRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 160, 40));

        cbGrado.setBackground(new java.awt.Color(230, 230, 230));
        cbGrado.setFont(new java.awt.Font("Inter 18pt SemiBold", 0, 12)); // NOI18N
        cbGrado.setForeground(new java.awt.Color(102, 102, 102));
        cbGrado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cbGrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 310, 160, 40));

        cbComite.setBackground(new java.awt.Color(230, 230, 230));
        cbComite.setFont(new java.awt.Font("Inter 18pt SemiBold", 0, 12)); // NOI18N
        cbComite.setForeground(new java.awt.Color(102, 102, 102));
        cbComite.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cbComite, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 160, 40));

        btnAgregarusuarios.setBackground(new java.awt.Color(51, 153, 0));
        btnAgregarusuarios.setFont(new java.awt.Font("Inter 24pt Black", 0, 12)); // NOI18N
        btnAgregarusuarios.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarusuarios.setText("Agregar");
        btnAgregarusuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarusuariosActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregarusuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 380, 160, 45));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);
        jScrollPane1.setForeground(new java.awt.Color(255, 255, 255));

        jtbUsuarios.setBackground(new java.awt.Color(255, 255, 255));
        jtbUsuarios.setFont(new java.awt.Font("Inter 18pt ExtraBold", 0, 11)); // NOI18N
        jtbUsuarios.setForeground(new java.awt.Color(112, 78, 197));
        jtbUsuarios.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtbUsuarios);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 90, 580, 320));

        jLabel2.setFont(new java.awt.Font("Inter 24pt ExtraBold", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(99, 99, 209));
        jLabel2.setText("Rol:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, -1, -1));

        jLabel3.setFont(new java.awt.Font("Inter 24pt ExtraBold", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(99, 99, 209));
        jLabel3.setText("Grado:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 290, -1, -1));

        jLabel4.setFont(new java.awt.Font("Inter 24pt ExtraBold", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(99, 99, 209));
        jLabel4.setText("Comité:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, -1, -1));

        volverprin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/back.png"))); // NOI18N
        jPanel1.add(volverprin, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/b.png"))); // NOI18N
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 420, -1, -1));

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/e.png"))); // NOI18N
        jPanel1.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 420, -1, -1));

        jLabel8.setFont(new java.awt.Font("Inter 24pt ExtraBold", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(207, 115, 207));
        jLabel8.setText("Editar");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 460, -1, -1));

        jLabel9.setFont(new java.awt.Font("Inter 24pt ExtraBold", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(121, 121, 235));
        jLabel9.setText("Eliminar");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 460, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1015, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreusActionPerformed

    private void btnAgregarusuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarusuariosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarusuariosActionPerformed

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
            java.util.logging.Logger.getLogger(frmAgregarusuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmAgregarusuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmAgregarusuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmAgregarusuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                initfrmAgregarusuarios();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAgregarusuarios;
    public javax.swing.JLabel btnEditar;
    public javax.swing.JLabel btnEliminar;
    public javax.swing.JComboBox<String> cbComite;
    public javax.swing.JComboBox<String> cbGrado;
    public javax.swing.JComboBox<String> cbRol;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jtbUsuarios;
    public javax.swing.JTextField txtContraus;
    public static javax.swing.JTextField txtCorreous;
    public javax.swing.JTextField txtNombreus;
    public javax.swing.JLabel volverprin;
    // End of variables declaration//GEN-END:variables
}
