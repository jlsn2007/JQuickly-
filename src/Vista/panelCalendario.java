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
        jCalendar1 = new com.toedter.calendar.JCalendar();
        jLabel2 = new javax.swing.JLabel();
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
        add(btnAgregareventos, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 360, 160, 45));

        jCalendar1.setBackground(new java.awt.Color(255, 255, 255));
        jCalendar1.setForeground(new java.awt.Color(0, 0, 0));
        jCalendar1.setDecorationBackgroundColor(new java.awt.Color(255, 255, 255));
        jCalendar1.setMaxSelectableDate(new java.util.Date(253370790083000L));
        jCalendar1.setMinSelectableDate(new java.util.Date(-62135744317000L));
        add(jCalendar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 520, 260));

        jLabel2.setFont(new java.awt.Font("Inter 24pt ExtraBold", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Calendario");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/pntcalen.png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregareventosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregareventosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregareventosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAgregareventos;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
