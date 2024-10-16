package Vista;

import Controlador.ctrlAgregarhoras;
import Modelo.Expediente;
import Modelo.Usuario;
import javax.swing.ImageIcon;

public class frmAgregarhoras extends javax.swing.JFrame {

    public frmAgregarhoras() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/Imgs/quicklywindow.png")).getImage());
        setLocationRelativeTo(this);
        setSize(1015, 532); 
        setResizable(false);
    }
    
    public static void initfrmAgregarhoras(){
        
        frmAgregarhoras vistaAgregarhoras = new frmAgregarhoras();
        Usuario modus = new Usuario();
        Expediente modex = new Expediente();
        
        ctrlAgregarhoras controlador = new ctrlAgregarhoras(vistaAgregarhoras, modus, modex);
        
        vistaAgregarhoras.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnEliminarexp = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        volverhoras = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cbAlumnos = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbAlumnos = new javax.swing.JTable();
        txtBuscaralum = new javax.swing.JTextField();
        txtCantidadhoras = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnEditar = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNombredelevento = new javax.swing.JTextField();

        btnEliminarexp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/b.png"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        volverhoras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/back.png"))); // NOI18N
        jPanel1.add(volverhoras, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel1.setFont(new java.awt.Font("Inter 24pt ExtraBold", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 153));
        jLabel1.setText("Agregar Horas sociales");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, -1, -1));

        cbAlumnos.setBackground(new java.awt.Color(221, 221, 221));
        cbAlumnos.setFont(new java.awt.Font("Inter 18pt SemiBold", 0, 12)); // NOI18N
        cbAlumnos.setForeground(new java.awt.Color(102, 102, 102));
        cbAlumnos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cbAlumnos, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 340, 40));

        jLabel2.setFont(new java.awt.Font("Inter 24pt ExtraBold", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 153));
        jLabel2.setText("Alumno a quien agregar horas:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, -1));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setForeground(new java.awt.Color(0, 153, 153));

        jtbAlumnos.setBackground(new java.awt.Color(255, 255, 255));
        jtbAlumnos.setFont(new java.awt.Font("Inter 24pt ExtraBold", 0, 12)); // NOI18N
        jtbAlumnos.setForeground(new java.awt.Color(0, 153, 153));
        jtbAlumnos.setModel(new javax.swing.table.DefaultTableModel(
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
        jtbAlumnos.setSelectionBackground(new java.awt.Color(0, 153, 153));
        jtbAlumnos.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(jtbAlumnos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 110, 580, 360));

        txtBuscaralum.setBackground(new java.awt.Color(221, 221, 221));
        txtBuscaralum.setFont(new java.awt.Font("Inter 18pt SemiBold", 0, 10)); // NOI18N
        txtBuscaralum.setForeground(new java.awt.Color(102, 102, 102));
        txtBuscaralum.setText("Buscar alumno");
        txtBuscaralum.setBorder(null);
        jPanel1.add(txtBuscaralum, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 70, 380, 30));

        txtCantidadhoras.setBackground(new java.awt.Color(221, 221, 221));
        txtCantidadhoras.setFont(new java.awt.Font("Inter 18pt SemiBold", 0, 12)); // NOI18N
        txtCantidadhoras.setForeground(new java.awt.Color(102, 102, 102));
        txtCantidadhoras.setText("Cantidad de horas");
        txtCantidadhoras.setBorder(null);
        jPanel1.add(txtCantidadhoras, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 340, 50));

        btnAgregar.setBackground(new java.awt.Color(0, 153, 153));
        btnAgregar.setFont(new java.awt.Font("Inter 24pt Black", 0, 12)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setText("Agregar");
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 160, 45));

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/e.png"))); // NOI18N
        jPanel1.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 340, -1, -1));

        jLabel5.setFont(new java.awt.Font("Inter 24pt ExtraBold", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(207, 115, 207));
        jLabel5.setText("Editar");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 380, -1, -1));

        txtNombredelevento.setBackground(new java.awt.Color(221, 221, 221));
        txtNombredelevento.setFont(new java.awt.Font("Inter 18pt SemiBold", 0, 12)); // NOI18N
        txtNombredelevento.setForeground(new java.awt.Color(102, 102, 102));
        txtNombredelevento.setText("Nombre del evento");
        txtNombredelevento.setBorder(null);
        jPanel1.add(txtNombredelevento, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 340, 50));

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
            java.util.logging.Logger.getLogger(frmAgregarhoras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmAgregarhoras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmAgregarhoras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmAgregarhoras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                initfrmAgregarhoras();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAgregar;
    public javax.swing.JLabel btnEditar;
    public javax.swing.JLabel btnEliminarexp;
    public javax.swing.JComboBox<String> cbAlumnos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jtbAlumnos;
    public javax.swing.JTextField txtBuscaralum;
    public javax.swing.JTextField txtCantidadhoras;
    public javax.swing.JTextField txtNombredelevento;
    public javax.swing.JLabel volverhoras;
    // End of variables declaration//GEN-END:variables
}
