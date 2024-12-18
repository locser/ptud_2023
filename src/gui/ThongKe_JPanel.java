package gui;

import java.awt.*;
import java.awt.Image;
import javax.swing.*;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import org.jdesktop.layout.GroupLayout;

public class ThongKe_JPanel extends javax.swing.JPanel {

    private final DoanhThu_JPanel panel_doanhthu ;
    private final DoanhSo_JPanel panel_doanhso ;
    private final ThongKeNVKH_Panel panel_nvkh;

    public ThongKe_JPanel() {
        initComponents();
        setBounds(0, 0, 1186, 748);
//        ImageIcon img_btnTimKiem = new ImageIcon("src//pic//icon//buttonTimKiem.png");
//        Image scaled_btnTimKiem = img_btnTimKiem.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
//        img_btnTimKiem = new ImageIcon(scaled_btnTimKiem);
//        btn_TimKiem.setIcon(img_btnTimKiem);
        ImageIcon img_btnXemChiTiet = new ImageIcon("src//pic//icon//buttonXemChiTiet.png");
        Image scaled_btnXemChiTiet = img_btnXemChiTiet.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        img_btnXemChiTiet = new ImageIcon(scaled_btnXemChiTiet);
//        btn_XemChiTiet.setIcon(img_btnXemChiTiet);
        
//        ButtonGroup btnGR = new ButtonGroup();
//        btnGR.add(rdo_XemDoanhSo);
//        btnGR.add(rdo_XemDoanhThu);
//        rdo_XemDoanhThu.setSelected(true);
        panel_doanhthu = new DoanhThu_JPanel();
        panel_doanhso = new DoanhSo_JPanel();
        panel_nvkh = new ThongKeNVKH_Panel();
//        Jpanel_TK.add(panel_doanhthu);
//        Jpanel_TK.add(panel_doanhso);
            Panel_doanhthu.add(panel_doanhthu);
            Panel_doanhso.add(panel_doanhso);
            Panel_NVKH.add(panel_nvkh);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane3 = new javax.swing.JTabbedPane();
        Panel_NVKH = new javax.swing.JPanel();
        Panel_doanhso = new javax.swing.JPanel();
        Panel_doanhthu = new javax.swing.JPanel();

        setBackground(new java.awt.Color(187, 205, 197));
        setMinimumSize(new java.awt.Dimension(1020, 700));
        setPreferredSize(new java.awt.Dimension(1020, 700));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Panel_NVKH.setBackground(new java.awt.Color(187, 205, 197));

        javax.swing.GroupLayout Panel_NVKHLayout = new javax.swing.GroupLayout(Panel_NVKH);
        Panel_NVKH.setLayout(Panel_NVKHLayout);
        Panel_NVKHLayout.setHorizontalGroup(
            Panel_NVKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1190, Short.MAX_VALUE)
        );
        Panel_NVKHLayout.setVerticalGroup(
            Panel_NVKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jTabbedPane3.addTab("Thống Kê", Panel_NVKH);

        Panel_doanhso.setBackground(new java.awt.Color(187, 205, 197));

        javax.swing.GroupLayout Panel_doanhsoLayout = new javax.swing.GroupLayout(Panel_doanhso);
        Panel_doanhso.setLayout(Panel_doanhsoLayout);
        Panel_doanhsoLayout.setHorizontalGroup(
            Panel_doanhsoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1190, Short.MAX_VALUE)
        );
        Panel_doanhsoLayout.setVerticalGroup(
            Panel_doanhsoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 715, Short.MAX_VALUE)
        );

        jTabbedPane3.addTab("Doanh Số", Panel_doanhso);

        Panel_doanhthu.setBackground(new java.awt.Color(187, 205, 197));
        Panel_doanhthu.setPreferredSize(new java.awt.Dimension(1181, 715));

        javax.swing.GroupLayout Panel_doanhthuLayout = new javax.swing.GroupLayout(Panel_doanhthu);
        Panel_doanhthu.setLayout(Panel_doanhthuLayout);
        Panel_doanhthuLayout.setHorizontalGroup(
            Panel_doanhthuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1190, Short.MAX_VALUE)
        );
        Panel_doanhthuLayout.setVerticalGroup(
            Panel_doanhthuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 715, Short.MAX_VALUE)
        );

        jTabbedPane3.addTab("Doanh Thu", Panel_doanhthu);

        add(jTabbedPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, 750));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel_NVKH;
    private javax.swing.JPanel Panel_doanhso;
    private javax.swing.JPanel Panel_doanhthu;
    private javax.swing.JTabbedPane jTabbedPane3;
    // End of variables declaration//GEN-END:variables
}
