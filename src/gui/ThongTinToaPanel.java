/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

import javax.swing.ImageIcon;

import entity.ToaTauEntity;

/**
 *
 * @author ploc2
 */
public class ThongTinToaPanel extends javax.swing.JPanel {

    private ToaTauEntity toa;
    private int soToa;

    public ThongTinToaPanel(String anh, int soToa, ToaTauEntity toa) {
        this.soToa = soToa;
        this.toa = toa;

        initComponents();
        URL urlBtnLamMoi = getClass().getResource("/pic/icon/" + anh);
        ImageIcon img_btnLamMoi = new ImageIcon(urlBtnLamMoi);
        img_btnLamMoi = new ImageIcon(img_btnLamMoi.getImage());
        jLabel1.setIcon(img_btnLamMoi);

        String tenToa = toa != null ? toa.getTenToa() : "0";
        jLabel_TenToa.setText(tenToa);

        // Tạo hiệu ứng hover (optional)
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                batMauNut();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                resetMauNut();
            }
        });

        // Tạo hiệu ứng hover (optional)
        jLabel1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                batMauNut();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                resetMauNut();

            }
        });
    }

    private void resetMauNut() {
        setBackground(new Color(204, 204, 204));
        jLabel1.setBackground(new Color(204, 204, 204));
    }

    private void batMauNut() {
        setBackground(new Color(153, 153, 153));
        jLabel1.setBackground(new Color(153, 153, 153));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel_TenToa = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 204));
        setToolTipText("");
        setName(""); // NOI18N

        jLabel1.setBackground(new java.awt.Color(153, 153, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setToolTipText("");
        jLabel1.setMaximumSize(new java.awt.Dimension(60, 60));
        jLabel1.setMinimumSize(new java.awt.Dimension(60, 60));
        jLabel1.setPreferredSize(new java.awt.Dimension(50, 50));

        jLabel_TenToa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_TenToa.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel_TenToa, javax.swing.GroupLayout.Alignment.TRAILING,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                layout.createSequentialGroup()
                                                        .addGap(0, 0, Short.MAX_VALUE)
                                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel_TenToa)));
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_TenToa;
    // End of variables declaration//GEN-END:variables
}
