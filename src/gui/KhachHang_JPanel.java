package gui;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import bus.KhachHang_bus;
import dao.KhachHang_dao;
import entity.GioiTinhEnum;
import entity.KhachHangEntity;
import java.awt.Image;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.BadLocationException;
import org.jdesktop.layout.GroupLayout;
import org.jdesktop.layout.LayoutStyle;
import util.GenerateID;

/**
 *
 * @author 84335
 */
public class KhachHang_JPanel extends javax.swing.JPanel {

    /**
     * Creates new form KhachHang_JPanel
     */
    private DefaultTableModel tableModel = new DefaultTableModel();
    private KhachHang_bus bus = new KhachHang_bus();
    
    public KhachHang_JPanel() {
        initComponents();
        setBounds(0, 0, 1186, 748);
        
        URL imageURL = KhachHang_JPanel.class.getResource("/pic/icon/buttonTimKiem.png");
        ImageIcon img_btnTimKiem = new ImageIcon(imageURL);
        Image scaled_btnTimKiem = img_btnTimKiem.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        img_btnTimKiem = new ImageIcon(scaled_btnTimKiem);
        btn_TimKiem.setIcon(img_btnTimKiem);
        
        URL imageThem = KhachHang_JPanel.class.getResource("/pic/icon/buttonThem.png");
        ImageIcon img_btnThem = new ImageIcon(imageThem);
        Image scaled_btnThem = img_btnThem.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        img_btnThem = new ImageIcon(scaled_btnThem);
        btn_Them.setIcon(img_btnThem);
        
        URL imageLamMoi = KhachHang_JPanel.class.getResource("/pic/icon/buttonLamMoi.png");
        ImageIcon img_btnLamMoi = new ImageIcon(imageLamMoi);
        Image scaled_btnLamMoi = img_btnLamMoi.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        img_btnLamMoi = new ImageIcon(scaled_btnLamMoi);
        btn_LamMoi.setIcon(img_btnLamMoi);
        
        URL imageCapNhat = KhachHang_JPanel.class.getResource("/pic/icon/buttonCapNhat.png");
        ImageIcon img_btnCapNhat = new ImageIcon(imageCapNhat);
        Image scaled_btnCapNhat = img_btnCapNhat.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        img_btnCapNhat = new ImageIcon(scaled_btnCapNhat);
        btn_CapNhat.setIcon(img_btnCapNhat);
        
        btg.add(rad_Nu);
        btg.add(rad_Nam);
        btg.add(rad_Khac);
        
        tableModel = (DefaultTableModel) table_KhachHang.getModel();
        table_KhachHang.setModel(tableModel);
        
//        loadData();
        
        table_KhachHang.setDefaultEditor(Object.class, null);
    }
    
    private void loadData() {
        ArrayList<KhachHangEntity> listKH = new ArrayList<>();
        listKH = bus.findAll();
        for (KhachHangEntity kh : listKH) {
            tableModel.addRow(new Object[]{kh.getMaKH(), kh.getHoTen(), kh.getGioiTinh().toString(), kh.getSoDienThoai() ,kh.getDiaChi()});
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_QuanLyKhachHang = new javax.swing.JPanel();
        lbl_QuanLyKhachHang = new javax.swing.JLabel();
        panel_ThongTinKH = new javax.swing.JPanel();
        lbl_MaKH = new javax.swing.JLabel();
        lbl_GioiTinhKH = new javax.swing.JLabel();
        lbl_HoTenKH = new javax.swing.JLabel();
        lbl_SDTKhachHang = new javax.swing.JLabel();
        lbl_DiaChiKH = new javax.swing.JLabel();
        txt_MaKH = new javax.swing.JTextField();
        txt_HoTen = new javax.swing.JTextField();
        txt_DiaChi = new javax.swing.JTextField();
        txt_SDT = new javax.swing.JTextField();
        rad_Nam = new javax.swing.JRadioButton();
        rad_Nu = new javax.swing.JRadioButton();
        rad_Khac = new javax.swing.JRadioButton();
        panel_ThaoTaoKH = new javax.swing.JPanel();
        lbl_NhapSDT = new javax.swing.JLabel();
        txt_NhapSDT = new javax.swing.JTextField();
        btn_TimKiem = new javax.swing.JButton();
        btn_LamMoi = new javax.swing.JButton();
        btn_Them = new javax.swing.JButton();
        btn_CapNhat = new javax.swing.JButton();
        panel_TableKhachHang = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_KhachHang = new javax.swing.JTable();

        setBackground(new java.awt.Color(187, 205, 197));
        setPreferredSize(new java.awt.Dimension(1020, 700));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_QuanLyKhachHang.setBackground(new java.awt.Color(187, 205, 197));
        panel_QuanLyKhachHang.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_QuanLyKhachHang.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lbl_QuanLyKhachHang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_QuanLyKhachHang.setText("QUẢN LÝ KHÁCH HÀNG");
        lbl_QuanLyKhachHang.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        panel_QuanLyKhachHang.add(lbl_QuanLyKhachHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1186, 42));

        add(panel_QuanLyKhachHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1186, -1));

        panel_ThongTinKH.setBackground(new java.awt.Color(187, 205, 197));
        panel_ThongTinKH.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Thông tin khách hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 12))); // NOI18N

        lbl_MaKH.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbl_MaKH.setText("Mã khách hàng");

        lbl_GioiTinhKH.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbl_GioiTinhKH.setText("Giới tính");

        lbl_HoTenKH.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbl_HoTenKH.setText("Họ tên");

        lbl_SDTKhachHang.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbl_SDTKhachHang.setText("Số điện thoại");

        lbl_DiaChiKH.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbl_DiaChiKH.setText("Địa chỉ");

        txt_MaKH.setEditable(false);
        txt_MaKH.setPreferredSize(new java.awt.Dimension(200, 30));
        txt_MaKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_MaKHActionPerformed(evt);
            }
        });

        txt_HoTen.setPreferredSize(new java.awt.Dimension(200, 30));
        txt_HoTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_HoTenActionPerformed(evt);
            }
        });

        txt_DiaChi.setPreferredSize(new java.awt.Dimension(200, 30));
        txt_DiaChi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_DiaChiActionPerformed(evt);
            }
        });

        txt_SDT.setPreferredSize(new java.awt.Dimension(200, 30));

        rad_Nam.setBackground(new java.awt.Color(187, 205, 197));
        rad_Nam.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        rad_Nam.setText("Nam");

        rad_Nu.setBackground(new java.awt.Color(187, 205, 197));
        rad_Nu.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        rad_Nu.setText("Nữ");

        rad_Khac.setBackground(new java.awt.Color(187, 205, 197));
        rad_Khac.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        rad_Khac.setText("Khác");

        javax.swing.GroupLayout panel_ThongTinKHLayout = new javax.swing.GroupLayout(panel_ThongTinKH);
        panel_ThongTinKH.setLayout(panel_ThongTinKHLayout);
        panel_ThongTinKHLayout.setHorizontalGroup(
            panel_ThongTinKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_ThongTinKHLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(panel_ThongTinKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_MaKH)
                    .addComponent(lbl_GioiTinhKH))
                .addGap(18, 18, 18)
                .addGroup(panel_ThongTinKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panel_ThongTinKHLayout.createSequentialGroup()
                        .addComponent(rad_Nam)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rad_Nu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rad_Khac)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_DiaChiKH))
                    .addGroup(panel_ThongTinKHLayout.createSequentialGroup()
                        .addComponent(txt_MaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(83, 83, 83)
                        .addComponent(lbl_HoTenKH)))
                .addGap(18, 18, 18)
                .addGroup(panel_ThongTinKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_ThongTinKHLayout.createSequentialGroup()
                        .addComponent(txt_HoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(lbl_SDTKhachHang)
                        .addGap(18, 18, 18)
                        .addComponent(txt_SDT, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_DiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(202, Short.MAX_VALUE))
        );
        panel_ThongTinKHLayout.setVerticalGroup(
            panel_ThongTinKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_ThongTinKHLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(panel_ThongTinKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_ThongTinKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_MaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_MaKH)
                        .addComponent(lbl_HoTenKH)
                        .addComponent(txt_HoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_ThongTinKHLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(panel_ThongTinKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_SDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_SDTKhachHang))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_ThongTinKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_GioiTinhKH)
                    .addGroup(panel_ThongTinKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rad_Nam)
                        .addComponent(rad_Nu)
                        .addComponent(rad_Khac))
                    .addGroup(panel_ThongTinKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_DiaChiKH)
                        .addComponent(txt_DiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27))
        );

        txt_MaKH.getAccessibleContext().setAccessibleName("");
        txt_HoTen.getAccessibleContext().setAccessibleName("");
        txt_DiaChi.getAccessibleContext().setAccessibleName("");
        txt_SDT.getAccessibleContext().setAccessibleName("");

        add(panel_ThongTinKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 54, 1175, 124));

        panel_ThaoTaoKH.setBackground(new java.awt.Color(187, 205, 197));
        panel_ThaoTaoKH.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Các thao tác", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 12))); // NOI18N
        panel_ThaoTaoKH.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_NhapSDT.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbl_NhapSDT.setText("Nhập số điện thoại");
        panel_ThaoTaoKH.add(lbl_NhapSDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        txt_NhapSDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_NhapSDTActionPerformed(evt);
            }
        });
        panel_ThaoTaoKH.add(txt_NhapSDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, 200, 30));

        btn_TimKiem.setBackground(new java.awt.Color(0, 51, 51));
        btn_TimKiem.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        btn_TimKiem.setForeground(new java.awt.Color(255, 255, 255));
        btn_TimKiem.setText("Tìm kiếm");
        btn_TimKiem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_TimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_TimKiemMouseClicked(evt);
            }
        });
        btn_TimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TimKiemActionPerformed(evt);
            }
        });
        panel_ThaoTaoKH.add(btn_TimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, 120, 30));

        btn_LamMoi.setBackground(new java.awt.Color(0, 51, 51));
        btn_LamMoi.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        btn_LamMoi.setForeground(new java.awt.Color(255, 255, 255));
        btn_LamMoi.setText("Làm mới");
        btn_LamMoi.setToolTipText("");
        btn_LamMoi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_LamMoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_LamMoiMouseClicked(evt);
            }
        });
        btn_LamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LamMoiActionPerformed(evt);
            }
        });
        panel_ThaoTaoKH.add(btn_LamMoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 30, 120, 30));

        btn_Them.setBackground(new java.awt.Color(0, 51, 51));
        btn_Them.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        btn_Them.setForeground(new java.awt.Color(255, 255, 255));
        btn_Them.setText("Thêm");
        btn_Them.setToolTipText("");
        btn_Them.setActionCommand("");
        btn_Them.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemActionPerformed(evt);
            }
        });
        panel_ThaoTaoKH.add(btn_Them, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 30, 120, 30));

        btn_CapNhat.setBackground(new java.awt.Color(0, 51, 51));
        btn_CapNhat.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        btn_CapNhat.setForeground(new java.awt.Color(255, 255, 255));
        btn_CapNhat.setText("Cập nhật");
        btn_CapNhat.setToolTipText("");
        btn_CapNhat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_CapNhat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_CapNhatMouseClicked(evt);
            }
        });
        btn_CapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CapNhatActionPerformed(evt);
            }
        });
        panel_ThaoTaoKH.add(btn_CapNhat, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 30, 120, 30));

        add(panel_ThaoTaoKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 184, 1175, 83));

        panel_TableKhachHang.setBackground(new java.awt.Color(187, 205, 197));
        panel_TableKhachHang.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Bảng danh sách khách hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 12))); // NOI18N
        panel_TableKhachHang.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table_KhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Khách Hàng", "Tên Khách Hàng", "Giới tính", "Số điện thoại", "Địa chỉ"
            }
        ));
        table_KhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_KhachHangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_KhachHang);

        panel_TableKhachHang.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 1150, 440));

        add(panel_TableKhachHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 273, 1175, 470));
    }// </editor-fold>//GEN-END:initComponents

    private void txt_MaKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_MaKHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_MaKHActionPerformed

    private void txt_HoTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_HoTenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_HoTenActionPerformed

    private void txt_DiaChiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_DiaChiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_DiaChiActionPerformed

    private void txt_NhapSDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_NhapSDTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_NhapSDTActionPerformed

    private void btn_ThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemActionPerformed
        KhachHang_dao dao = new KhachHang_dao();
        ArrayList<KhachHangEntity> listKH = bus.findAll();
        try {
            if (checkInput()) {
                GioiTinhEnum gt = null;
//                KhachHangEntity kh = new KhachHangEntity();
//                kh.setMaKH(GenerateID.sinhMa("KH"));
//                kh.setHoTen(txt_HoTen.getText());
//                if (rad_Nam.isSelected()) gt = GioiTinhEnum.NAM;
//                else if (rad_Nu.isSelected()) gt = GioiTinhEnum.NU;
//                else gt = GioiTinhEnum.KHAC;
//                kh.setGioiTinh(gt);
//                kh.setSoDienThoai(txt_SDT.getText());
//                kh.setDiaChi(txt_DiaChi.getText());
//                if (!listKH.contains(kh) && bus.insert(kh)) {
//                    tableModel.addRow(new Object[]{kh.getMaKH(), kh.getHoTen(), kh.getGioiTinh().toString(), kh.getSoDienThoai() ,kh.getDiaChi()});
//                    refresh();
//                    JOptionPane.showMessageDialog(this, "Thêm khách hàng thành công!");
//                }
//                else JOptionPane.showMessageDialog(this, "Thêm thất bại! Số điện thoại khách hàng đã bị trùng!");
            }
        } catch (BadLocationException ex) {
            Logger.getLogger(KhachHang_JPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_ThemActionPerformed
    
    public void refresh() {
        txt_MaKH.setText("");
        txt_HoTen.setText("");
        txt_DiaChi.setText("");
        txt_SDT.setText("");
        txt_NhapSDT.setText("");
        btg.clearSelection();
        tableModel.setRowCount(0);
        rad_Nam.setSelected(true);
        loadData();
    }
    
    public boolean checkInput() throws BadLocationException {
        String hoTen = txt_HoTen.getText();
        String SDT = txt_SDT.getText();
        String diaChi = txt_DiaChi.getText();
        if (hoTen.isBlank() || SDT.isBlank() || diaChi.isBlank() || (rad_Nam.isSelected() == false && rad_Nu.isSelected() == false && rad_Khac.isSelected() == false)) {
            JOptionPane.showMessageDialog(this, "Tất cả thông tin không được rỗng!");
            return false;
        }
        else if (!hoTen.matches("^[A-ZÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ][a-zàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđ]*(?:[ ][A-ZÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ][a-zàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđ]*)*$")) {
            JOptionPane.showMessageDialog(this, "Họ tên phải viết hoa chữ cái đầu và phải có khoảng trắng giữa các cụm!");
            return false;
        }
        else if (!SDT.matches("^(0|84)[1-9]\\d{8}$")) {
            JOptionPane.showMessageDialog(this, "Số điện thoại phải có 10 ký số và thuộc quốc gia Việt Nam!");
            return false;
        }
        else if (!diaChi.matches("^([A-ZÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ][a-zàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđ]*(?:[ ][A-ZÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ][a-zàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđ,]*))*|([a-zA-Z0-9.]+)+$") && diaChi.length() > 50) {
            JOptionPane.showMessageDialog(this, "Địa chỉ tối đa 50 kí tự"
                    + "!");
            return false;
        }
        
        return true;
    }
    
    private void btn_CapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CapNhatActionPerformed
//        KhachHang_dao dao = new KhachHang_dao();
//        ArrayList<KhachHangEntity> listKH = bus.findAll();
        try {
            if (table_KhachHang.getSelectedColumn() != -1 && table_KhachHang.getSelectedRow() != -1) {
                if (checkInput()) {
                
                    GioiTinhEnum gt = null;
//                    KhachHangEntity kh = new KhachHangEntity();
//                    kh.setMaKH(txt_MaKH.getText());
//                    kh.setHoTen(txt_HoTen.getText());
//                    if (rad_Nam.isSelected()) gt = GioiTinhEnum.NAM;
//                    else if (rad_Nu.isSelected()) gt = GioiTinhEnum.NU;
//                    else gt = GioiTinhEnum.KHAC;
//                    kh.setGioiTinh(gt);
//                    kh.setSoDienThoai(txt_SDT.getText());
//                    kh.setDiaChi(txt_DiaChi.getText());

    //                listKH.remove(kh);

//                    if (bus.update(kh)) {
//    //                    listKH.add(kh);
//                        refresh();
//                        JOptionPane.showMessageDialog(this, "Đã sửa dữ liệu khách hàng thành công!");
//                    }
//                    else JOptionPane.showMessageDialog(this, "Hệ thống không thể cập nhật dữ liệu do số điện thoại đã tồn tại!");
                }
                
            }
            else JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần chỉnh sửa!");
        } catch (BadLocationException ex) {
            Logger.getLogger(KhachHang_JPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btn_CapNhatActionPerformed

    private void btn_LamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LamMoiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_LamMoiActionPerformed

    private void table_KhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_KhachHangMouseClicked
//        tableModel = (DefaultTableModel) table_KhachHang.getModel();
        int rowSeleted = table_KhachHang.getSelectedRow();
        txt_MaKH.setText(tableModel.getValueAt(rowSeleted, 0) + "");
        txt_HoTen.setText(tableModel.getValueAt(rowSeleted, 1) + "");
        String gener = tableModel.getValueAt(rowSeleted, 2).toString();
        switch (gener) {
            case "Nam" -> rad_Nam.setSelected(true);
            case "Nữ" -> rad_Nu.setSelected(true);
            default -> rad_Khac.setSelected(true);
        }
        txt_SDT.setText(tableModel.getValueAt(rowSeleted, 3) + "");
        txt_DiaChi.setText(tableModel.getValueAt(rowSeleted, 4) + "");
        btn_Them.setEnabled(false);
    }//GEN-LAST:event_table_KhachHangMouseClicked

    private void btn_CapNhatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_CapNhatMouseClicked
        
    }//GEN-LAST:event_btn_CapNhatMouseClicked

    private void btn_TimKiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_TimKiemMouseClicked
        String id = txt_NhapSDT.getText();
        if (id.isBlank()) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập số điện thoại của khách hàng!");
            return;
        }
        KhachHangEntity kh = bus.findOne(id);
        if (kh == null) {
            JOptionPane.showMessageDialog(this, "Khách hàng không tồn tại!");
            return;
        }
        txt_MaKH.setText(kh.getMaKH());
        txt_HoTen.setText(kh.getHoTen());
        String gener = kh.getGioiTinh().toString();
        switch (gener) {
            case "Nam" -> rad_Nam.setSelected(true);
            case "Nữ" -> rad_Nu.setSelected(true);
            default -> rad_Khac.setSelected(true);
        }
        txt_SDT.setText(kh.getSoDienThoai());
        txt_DiaChi.setText(kh.getDiaChi());
        
//        int selectedRow = -1;
//        for (int i = 0; i < table_KhachHang.getRowCount(); i++) {
//            String title = tableModel.getValueAt(i, 3).toString();
//            if (title.equals(id)) {
//                selectedRow = i;
//                break;
//            }
//        }
//				
//        if (selectedRow != -1) {
////            Chọn dòng vừa tạo
//            table_KhachHang.setRowSelectionInterval(selectedRow, selectedRow);
////            Scroll đến dòng vừa tạo đó
//            table_KhachHang.scrollRectToVisible(table_KhachHang.getCellRect(selectedRow, 0, true));
//        }
       tableModel.setRowCount(0);
       tableModel.addRow(new Object[]{kh.getMaKH(), kh.getHoTen(), kh.getGioiTinh().toString(), kh.getSoDienThoai() ,kh.getDiaChi()});

    }//GEN-LAST:event_btn_TimKiemMouseClicked

    private void btn_LamMoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_LamMoiMouseClicked
        refresh();
        btn_Them.setEnabled(true);
    }//GEN-LAST:event_btn_LamMoiMouseClicked

    private void btn_TimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_TimKiemActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_CapNhat;
    private javax.swing.JButton btn_LamMoi;
    private javax.swing.JButton btn_Them;
    private javax.swing.JButton btn_TimKiem;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_DiaChiKH;
    private javax.swing.JLabel lbl_GioiTinhKH;
    private javax.swing.JLabel lbl_HoTenKH;
    private javax.swing.JLabel lbl_MaKH;
    private javax.swing.JLabel lbl_NhapSDT;
    private javax.swing.JLabel lbl_QuanLyKhachHang;
    private javax.swing.JLabel lbl_SDTKhachHang;
    private javax.swing.JPanel panel_QuanLyKhachHang;
    private javax.swing.JPanel panel_TableKhachHang;
    private javax.swing.JPanel panel_ThaoTaoKH;
    private javax.swing.JPanel panel_ThongTinKH;
    private javax.swing.JRadioButton rad_Khac;
    private javax.swing.JRadioButton rad_Nam;
    private javax.swing.JRadioButton rad_Nu;
    private javax.swing.JTable table_KhachHang;
    private javax.swing.JTextField txt_DiaChi;
    private javax.swing.JTextField txt_HoTen;
    private javax.swing.JTextField txt_MaKH;
    private javax.swing.JTextField txt_NhapSDT;
    private javax.swing.JTextField txt_SDT;
    // End of variables declaration//GEN-END:variables
    private javax.swing.ButtonGroup btg = new ButtonGroup();
}
