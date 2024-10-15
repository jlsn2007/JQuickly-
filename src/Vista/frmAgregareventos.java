package Vista;

import Controlador.ctrlAgregareventos;
import Modelo.Eventos;
import Modelo.Usuario;


public class frmAgregareventos extends javax.swing.JFrame {


    public frmAgregareventos() {
        initComponents();
        setLocationRelativeTo(this);
        setSize(1015, 532); 
        setResizable(false);
    }
    
    public static void initfrmAgregareventos(){  
        
        frmMenu vistaMenuAdmin = new frmMenu();
        panelCalendario panelCalendadio = new panelCalendario();
        frmAgregareventos vistaAgregareventos = new frmAgregareventos();
        Eventos modeloEventos = new Eventos();
        Usuario modeloUsuario = new Usuario();
        
        ctrlAgregareventos controlador = new ctrlAgregareventos(vistaMenuAdmin, panelCalendadio, vistaAgregareventos, modeloEventos, modeloUsuario);
        
        vistaAgregareventos.setVisible(true);
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbEventos = new javax.swing.JTable();
        txtNombreevento = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        btnvolvercalendario = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtLugar = new javax.swing.JTextField();
        txtFecha = new javax.swing.JTextField();
        txtHora = new javax.swing.JTextField();
        btnAgregareventos = new javax.swing.JButton();
        btnEditar = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbUsuarios = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        txtBuscarev = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBorder(null);

        jtbEventos.setBackground(new java.awt.Color(255, 255, 255));
        jtbEventos.setFont(new java.awt.Font("Inter 24pt ExtraBold", 0, 12)); // NOI18N
        jtbEventos.setForeground(new java.awt.Color(153, 0, 0));
        jtbEventos.setModel(new javax.swing.table.DefaultTableModel(
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
        jtbEventos.setGridColor(new java.awt.Color(153, 0, 0));
        jScrollPane1.setViewportView(jtbEventos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 110, 580, 300));

        txtNombreevento.setBackground(new java.awt.Color(230, 230, 230));
        txtNombreevento.setFont(new java.awt.Font("Inter 18pt SemiBold", 0, 12)); // NOI18N
        txtNombreevento.setForeground(new java.awt.Color(102, 102, 102));
        txtNombreevento.setText("Nombre del evento");
        txtNombreevento.setBorder(null);
        jPanel1.add(txtNombreevento, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 345, 50));

        txtDescripcion.setBackground(new java.awt.Color(230, 230, 230));
        txtDescripcion.setFont(new java.awt.Font("Inter 18pt SemiBold", 0, 12)); // NOI18N
        txtDescripcion.setForeground(new java.awt.Color(102, 102, 102));
        txtDescripcion.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtDescripcion.setText("Descripción");
        txtDescripcion.setBorder(null);
        txtDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescripcionActionPerformed(evt);
            }
        });
        jPanel1.add(txtDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 345, 90));

        btnvolvercalendario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/back.png"))); // NOI18N
        jPanel1.add(btnvolvercalendario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Inter 24pt ExtraBold", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(215, 62, 84));
        jLabel2.setText("Agregar Eventos");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, -1, -1));

        txtLugar.setBackground(new java.awt.Color(230, 230, 230));
        txtLugar.setFont(new java.awt.Font("Inter 18pt SemiBold", 0, 12)); // NOI18N
        txtLugar.setForeground(new java.awt.Color(102, 102, 102));
        txtLugar.setText("Lugar");
        txtLugar.setBorder(null);
        jPanel1.add(txtLugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 345, 50));

        txtFecha.setBackground(new java.awt.Color(230, 230, 230));
        txtFecha.setFont(new java.awt.Font("Inter 18pt SemiBold", 0, 12)); // NOI18N
        txtFecha.setForeground(new java.awt.Color(102, 102, 102));
        txtFecha.setText("Fecha");
        txtFecha.setBorder(null);
        jPanel1.add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 160, 50));

        txtHora.setBackground(new java.awt.Color(230, 230, 230));
        txtHora.setFont(new java.awt.Font("Inter 18pt SemiBold", 0, 12)); // NOI18N
        txtHora.setForeground(new java.awt.Color(102, 102, 102));
        txtHora.setText("Hora");
        txtHora.setBorder(null);
        jPanel1.add(txtHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 340, 165, 50));

        btnAgregareventos.setBackground(new java.awt.Color(215, 62, 84));
        btnAgregareventos.setFont(new java.awt.Font("Inter 24pt Black", 0, 12)); // NOI18N
        btnAgregareventos.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregareventos.setText("Agregar ");
        jPanel1.add(btnAgregareventos, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 410, 160, 45));

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/e.png"))); // NOI18N
        jPanel1.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 420, -1, -1));

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/b.png"))); // NOI18N
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 420, -1, -1));

        jLabel5.setFont(new java.awt.Font("Inter 24pt ExtraBold", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(207, 115, 207));
        jLabel5.setText("Editar");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 460, -1, -1));

        jLabel6.setFont(new java.awt.Font("Inter 24pt ExtraBold", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(121, 121, 235));
        jLabel6.setText("Eliminar");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 460, -1, -1));

        cbUsuarios.setBackground(new java.awt.Color(230, 230, 230));
        cbUsuarios.setFont(new java.awt.Font("Inter 18pt SemiBold", 0, 12)); // NOI18N
        cbUsuarios.setForeground(new java.awt.Color(102, 102, 102));
        cbUsuarios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cbUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, 160, 40));

        jLabel1.setFont(new java.awt.Font("Inter 24pt ExtraBold", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(215, 62, 84));
        jLabel1.setText("Usuario que lo agrega:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, -1, -1));

        txtBuscarev.setBackground(new java.awt.Color(230, 230, 230));
        txtBuscarev.setFont(new java.awt.Font("Inter 18pt SemiBold", 0, 10)); // NOI18N
        txtBuscarev.setForeground(new java.awt.Color(102, 102, 102));
        txtBuscarev.setText("Buscar evento");
        txtBuscarev.setBorder(null);
        jPanel1.add(txtBuscarev, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 70, 380, 30));

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

    private void txtDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescripcionActionPerformed

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
            java.util.logging.Logger.getLogger(frmAgregareventos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmAgregareventos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmAgregareventos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmAgregareventos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                initfrmAgregareventos();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAgregareventos;
    public javax.swing.JLabel btnEditar;
    public javax.swing.JLabel btnEliminar;
    public javax.swing.JLabel btnvolvercalendario;
    public javax.swing.JComboBox<String> cbUsuarios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jtbEventos;
    public javax.swing.JTextField txtBuscarev;
    public javax.swing.JTextField txtDescripcion;
    public javax.swing.JTextField txtFecha;
    public javax.swing.JTextField txtHora;
    public javax.swing.JTextField txtLugar;
    public javax.swing.JTextField txtNombreevento;
    // End of variables declaration//GEN-END:variables
}
