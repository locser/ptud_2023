/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import dao.NhanVien_dao;
import dao.TaiKhoan_dao;
import entity.NhanVienEntity;
import entity.TaiKhoanEntity;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.net.URL;
import javax.swing.*;
import util.MD5Encode;
import util.ToanCuc;

/**
 *
 * @author ploc2
 */
public class DangNhap extends javax.swing.JFrame {

    private TaiKhoan_dao tkDao;

    /**
     * Creates new form DangNhap
     */
    public DangNhap() {
        initComponents();
        
        URL image_home = TrangChu_GUI.class.getResource("/pic/icon/anh-tau-1.png");   
        ImageIcon img_home = new ImageIcon(image_home);
        Image scaled_home = img_home.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        img_home = new ImageIcon(scaled_home);
        jLabel4.setIcon(img_home);    
        
        KeyStroke enterKey = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);
        btn_DangNhap.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(enterKey, "enterPressed");
        btn_DangNhap.getActionMap().put("enterPressed", dangNhapAction);
        
        btn_DangNhap.addActionListener(dangNhapAction);
        
        tkDao = new TaiKhoan_dao();
    }
    
    Action dangNhapAction = new AbstractAction("Đăng Nhập") {
        @Override
        public void actionPerformed(ActionEvent e) {
           thucHienDangNhap();
        }
    };

    private void thucHienDangNhap() {
        // Commented out the original login logic
//        /*
        try {
            String taiKhoan = txt_TaiKhoan.getText().trim();
            String matKhau = new String(txt_MatKhau.getPassword());
//            
            if(taiKhoan.isEmpty() || matKhau.isEmpty()) {
                txt_BaoLoi.setText("Vui lòng nhập đầy đủ thông tin!");
                txt_TaiKhoan.requestFocus();
                return;
            }

//            if(!taiKhoan.matches("^[a-zA-Z0-9]{6,20}$")) {
//                txt_BaoLoi.setText("Tài khoản phải từ 6-20 ký tự và không chứa ký tự đặc biệt!");
//                return;
//            }

//            String matKhauMaHoa = MD5Encode.md5Encode(matKhau);
            
//            TaiKhoanEntity tk = tkDao.getTaiKhoan(taiKhoan, matKhauMaHoa);

            NhanVien_dao nv_dao = new NhanVien_dao();
            NhanVienEntity nhanVien = nv_dao.dangNhap(taiKhoan, matKhau);
            
            if (nhanVien == null) {
                txt_BaoLoi.setText("Thông tin tài khoản hoặc mật khẩu không chính xác!");
                return;
            }
            
            if(nhanVien.getTrangThai() == 0) {
                txt_BaoLoi.setText("Tài khoản đã bị khóa!");
                return;
            }

            ToanCuc.setTen(nhanVien.getTen());
            ToanCuc.setMa(nhanVien.getMaNV());
            ToanCuc.setLoai(nhanVien.getLoai());
            ToanCuc.setSoDienThoai(nhanVien.getSoDienThoai());

            dispose();
            gui.TrangChu_GUI trangChu_GUI = new TrangChu_GUI();
            trangChu_GUI.setVisible(true);
        } catch (Exception ex) {
            txt_BaoLoi.setText("Lỗi hệ thống: " + ex.getMessage());
            ex.printStackTrace();
        }
//        */


//            NhanVienEntity nhanVien = new NhanVienEntity("123");
//            nhanVien.setLoai(1);
//            nhanVien.setTen("aaaaa");
//            
//            if (nhanVien == null) {
//                txt_BaoLoi.setText("Thông tin tài khoản, mật khẩu không chính xác!");
//            }else {
//                System.out.println(nhanVien.toString());                
//                System.out.println("đăng nhập thành công");
//
//                ToanCuc.setTen(nhanVien.getTen());
//                ToanCuc.setMa(nhanVien.getMaNV());
//                ToanCuc.setLoai(nhanVien.getLoai());
//                ToanCuc.setSoDienThoai(nhanVien.getSoDienThoai());
////                this.setVisible(false);
//                dispose();
//                gui.TrangChu_GUI trangChu_GUI = new TrangChu_GUI();
//                trangChu_GUI.setVisible(true);
//            }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        Right = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Left = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_TaiKhoan = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_MatKhau = new javax.swing.JPasswordField();
        btn_DangNhap = new javax.swing.JButton();
        txt_BaoLoi = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel2.setLayout(null);

        Right.setBackground(new java.awt.Color(0, 102, 102));
        Right.setMinimumSize(new java.awt.Dimension(300, 500));
        Right.setPreferredSize(new java.awt.Dimension(400, 500));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Hệ thống vé tàu ABC");

        javax.swing.GroupLayout RightLayout = new javax.swing.GroupLayout(Right);
        Right.setLayout(RightLayout);
        RightLayout.setHorizontalGroup(
            RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        RightLayout.setVerticalGroup(
            RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightLayout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(jLabel6)
                .addGap(44, 44, 44)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                .addGap(115, 115, 115))
        );

        jPanel2.add(Right);
        Right.setBounds(0, 0, 400, 500);

        Left.setBackground(new java.awt.Color(255, 255, 255));
        Left.setMinimumSize(new java.awt.Dimension(400, 500));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("Đăng nhập");

        jLabel2.setBackground(new java.awt.Color(102, 102, 102));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Tài khoản");

        txt_TaiKhoan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_TaiKhoan.setForeground(new java.awt.Color(102, 102, 102));
        txt_TaiKhoan.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_TaiKhoan.setToolTipText("Tài khoản của bạn");
        txt_TaiKhoan.setRequestFocusEnabled(false);
        txt_TaiKhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_TaiKhoanActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(102, 102, 102));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Mật khẩu");

        txt_MatKhau.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_MatKhau.setToolTipText("Vui lòng không cung cấp mật khẩu cá nhân cho người khác");

        btn_DangNhap.setBackground(new java.awt.Color(0, 102, 102));
        btn_DangNhap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_DangNhap.setForeground(new java.awt.Color(255, 255, 255));
        btn_DangNhap.setText("Đăng nhập");
        btn_DangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DangNhapActionPerformed(evt);
            }
        });

        txt_BaoLoi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_BaoLoi.setForeground(new java.awt.Color(255, 51, 51));
        txt_BaoLoi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_BaoLoi.setToolTipText("");
        txt_BaoLoi.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout LeftLayout = new javax.swing.GroupLayout(Left);
        Left.setLayout(LeftLayout);
        LeftLayout.setHorizontalGroup(
            LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LeftLayout.createSequentialGroup()
                .addContainerGap(109, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(106, 106, 106))
            .addGroup(LeftLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_BaoLoi, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_TaiKhoan)
                    .addComponent(txt_MatKhau)
                    .addComponent(btn_DangNhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        LeftLayout.setVerticalGroup(
            LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LeftLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_TaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_MatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(txt_BaoLoi, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_DangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(110, Short.MAX_VALUE))
        );

        txt_BaoLoi.getAccessibleContext().setAccessibleName("");

        jPanel2.add(Left);
        Left.setBounds(400, 0, 400, 500);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_DangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DangNhapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_DangNhapActionPerformed

    private void txt_TaiKhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_TaiKhoanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_TaiKhoanActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new DangNhap().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Left;
    private javax.swing.JPanel Right;
    private javax.swing.JButton btn_DangNhap;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel txt_BaoLoi;
    private javax.swing.JPasswordField txt_MatKhau;
    private javax.swing.JTextField txt_TaiKhoan;
    // End of variables declaration//GEN-END:variables
}
