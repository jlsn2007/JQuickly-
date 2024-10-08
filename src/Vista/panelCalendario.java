package Vista;

import Controlador.ctrlpanelCalendario;


public class panelCalendario extends javax.swing.JPanel {


    public panelCalendario() {
        initComponents();
        
        panelCalendario panel = this;
        frmAgregareventos vista = new frmAgregareventos();
        
        ctrlpanelCalendario controlador = new ctrlpanelCalendario(panel, vista);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAgregareventos = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAgregareventos.setBackground(new java.awt.Color(215, 62, 84));
        btnAgregareventos.setFont(new java.awt.Font("Inter 24pt Black", 0, 12)); // NOI18N
        btnAgregareventos.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregareventos.setText("Agregar Eventos");
        btnAgregareventos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregareventosActionPerformed(evt);
            }
        });
        add(btnAgregareventos, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 310, 160, 45));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/pntcalen.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregareventosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregareventosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregareventosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAgregareventos;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
