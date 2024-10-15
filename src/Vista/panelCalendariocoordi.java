package Vista;

import Controlador.ctrlpanelCalendariocoordi;


public class panelCalendariocoordi extends javax.swing.JPanel {


    public panelCalendariocoordi() {
        initComponents();
        
        panelCalendariocoordi panelcoordi = this;
        frmAgregareventoscoordi vistacordi = new frmAgregareventoscoordi();
        
        ctrlpanelCalendariocoordi controlador = new ctrlpanelCalendariocoordi (panelcoordi, vistacordi);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jCalendar1 = new com.toedter.calendar.JCalendar();
        btnAgregareventoscoordi = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Inter 24pt ExtraBold", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Calendario");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, -1, -1));

        jCalendar1.setBackground(new java.awt.Color(255, 255, 255));
        jCalendar1.setForeground(new java.awt.Color(0, 0, 0));
        jCalendar1.setDecorationBackgroundColor(new java.awt.Color(255, 255, 255));
        jCalendar1.setMaxSelectableDate(new java.util.Date(253370790083000L));
        jCalendar1.setMinSelectableDate(new java.util.Date(-62135744317000L));
        add(jCalendar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 520, 260));

        btnAgregareventoscoordi.setBackground(new java.awt.Color(215, 62, 84));
        btnAgregareventoscoordi.setFont(new java.awt.Font("Inter 24pt Black", 0, 12)); // NOI18N
        btnAgregareventoscoordi.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregareventoscoordi.setText("Agregar Eventos");
        add(btnAgregareventoscoordi, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 360, 160, 45));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/pntcalen.png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAgregareventoscoordi;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
