package Vista;

import Controlador.ctrlpanelPrincipalcoordi;


public class panelPrincipalcoordi extends javax.swing.JPanel {


    public panelPrincipalcoordi() {
        initComponents();
        
        panelPrincipalcoordi panelprincoordi = this;
        frmAgregarhorascoordi vistahorascoordi = new frmAgregarhorascoordi();
        
        ctrlpanelPrincipalcoordi controlador = new ctrlpanelPrincipalcoordi(panelprincoordi, vistahorascoordi);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnAgregarhorascoordi = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Inter 24pt ExtraBold", 0, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("¡Coordi, Es bueno volver a verte!");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, -1, -1));

        jLabel3.setFont(new java.awt.Font("Inter 24pt SemiBold", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("¡B I E N V E N I D O!");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, -1, -1));

        jLabel4.setFont(new java.awt.Font("Inter 24pt ExtraBold", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("¿Qué tal si agregamos un par de horas?");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 30, -1, -1));

        jLabel5.setFont(new java.awt.Font("Inter 24pt ExtraBold", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(57, 125, 214));
        jLabel5.setText("Siempre hay tiempo");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 200, -1, -1));

        jLabel6.setFont(new java.awt.Font("Inter 24pt ExtraBold", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(57, 125, 214));
        jLabel6.setText("para todo");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 220, -1, -1));

        jLabel7.setFont(new java.awt.Font("Inter 24pt ExtraBold", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 153, 255));
        jLabel7.setText("El tiempo en manos");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, -1, -1));

        jLabel8.setFont(new java.awt.Font("Inter 24pt ExtraBold", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(153, 153, 255));
        jLabel8.setText("valiosas, es la");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, -1, -1));

        jLabel9.setFont(new java.awt.Font("Inter 24pt ExtraBold", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(153, 153, 255));
        jLabel9.setText("mejor herramienta");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 330, -1, -1));

        btnAgregarhorascoordi.setBackground(new java.awt.Color(255, 210, 167));
        btnAgregarhorascoordi.setFont(new java.awt.Font("Inter 24pt ExtraBold", 0, 12)); // NOI18N
        btnAgregarhorascoordi.setForeground(new java.awt.Color(255, 153, 51));
        btnAgregarhorascoordi.setText("Agregar horas sociales");
        add(btnAgregarhorascoordi, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 90, 390, 150));

        jLabel10.setFont(new java.awt.Font("Inter 24pt ExtraBold", 0, 8)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 204, 204));
        jLabel10.setText("@jlsn Quickly! - 2024");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/pntprin.png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAgregarhorascoordi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
