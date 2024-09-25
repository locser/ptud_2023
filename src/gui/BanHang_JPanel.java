package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
//import bus.ChiTietHoaDon_bus;
//import bus.ChuongTrinhKhuyenMai_bus;
//import bus.HoaDon_bus;
//import bus.KhachHang_bus;
//import bus.SanPham_bus;
//import entity.ChiTietHoaDonEntity;
//import entity.ChuongTrinhKhuyenMaiEntity;
//import entity.HoaDonEntity;
//import entity.KhachHangEntity;
//import entity.NhanVienEntity;
//import entity.SanPhamEntity;
//import entity.TinhTrangSPEnum;
import java.awt.Image;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.layout.GroupLayout;
import org.jdesktop.layout.LayoutStyle;
import util.ConvertDoubleToMoney;
import util.ConvertStringToEnum;
import util.GenerateID;
import util.ToanCuc;

public class BanHang_JPanel extends javax.swing.JPanel {
    private DefaultTableModel tableModel_GioHang;
    private DefaultTableModel tableModel_HoaDon;
    private SpinnerNumberModel spinnerModel;
//    private SanPham_bus sp_bus = new SanPham_bus();
//    private KhachHang_bus kh_bus = new KhachHang_bus();
//    private ChuongTrinhKhuyenMai_bus ctkm_bus = new ChuongTrinhKhuyenMai_bus();
//    private HoaDon_bus hd_bus = new HoaDon_bus();
//    private ChiTietHoaDon_bus cthd_bus = new ChiTietHoaDon_bus();
//    
//    private ArrayList<HoaDonEntity> hdList = new ArrayList<HoaDonEntity>();
//    private HoaDonEntity hoaDon = new HoaDonEntity();
//    private ArrayList<ChiTietHoaDonEntity> cthdList = new ArrayList<ChiTietHoaDonEntity>();
    private ToanCuc tc = new ToanCuc();
    private ConvertStringToEnum toEnum = new ConvertStringToEnum();
    private ConvertDoubleToMoney convert = new ConvertDoubleToMoney();

    public BanHang_JPanel() {
        initComponents();
         setBounds(0, 0, 1186, 748);
         
        URL image_btnTimKiemSanPham = BanHang_JPanel.class.getResource("/pic/icon/buttonTimKiem.png");
        ImageIcon img_btnTimKiemSanPham = new ImageIcon("image_btnTimKiemSanPham");
        Image scaled_btnTimKiemSanPham = img_btnTimKiemSanPham.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        img_btnTimKiemSanPham = new ImageIcon(scaled_btnTimKiemSanPham);
        btn_TimKiemSanPham.setIcon(img_btnTimKiemSanPham);
         
        URL image_btnTimKiemHoaDon = BanHang_JPanel.class.getResource("/pic/icon/buttonTimKiem.png");
        ImageIcon img_btnTimKiemHoaDon = new ImageIcon("image_btnTimKiemHoaDon");
        Image scaled_btnTimKiemHoaDon = img_btnTimKiemHoaDon.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        img_btnTimKiemHoaDon = new ImageIcon(scaled_btnTimKiemHoaDon);
        btn_TimKiemHoaDon.setIcon(img_btnTimKiemHoaDon);
        
        URL image_btnThanhToan = BanHang_JPanel.class.getResource("/pic/icon/buttonThem.png");
        ImageIcon img_btnThanhToan = new ImageIcon("image_btnThanhToan");
        Image scaled_btnThanhToan = img_btnThanhToan.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        img_btnThanhToan = new ImageIcon(scaled_btnThanhToan);
        btn_ThanhToan.setIcon(img_btnThanhToan);
        
        URL image_btnXoaHoaDon = BanHang_JPanel.class.getResource("/pic/icon/buttonXoa.png");
        ImageIcon img_btnXoaHoaDon = new ImageIcon("image_btnXoaHoaDon");
        Image scaled_btnXoaHoaDon = img_btnXoaHoaDon.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        img_btnXoaHoaDon = new ImageIcon(scaled_btnXoaHoaDon);
        btn_XoaHoaDon.setIcon(img_btnXoaHoaDon);
        
        URL image_btnTimKiemKhachHang = BanHang_JPanel.class.getResource("/pic/icon/buttonTimKiem.png");
        ImageIcon img_btnTimKiemKhachHang = new ImageIcon("image_btnTimKiemKhachHang");
        Image scaled_btnTimKiemKhachHang = img_btnTimKiemKhachHang.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        img_btnTimKiemKhachHang = new ImageIcon(scaled_btnTimKiemKhachHang);
        btn_TimKiemKhachHang.setIcon(img_btnTimKiemKhachHang);
        
        URL image_btnThemVaoGio = BanHang_JPanel.class.getResource("/pic/icon/buttonThem.png");
        ImageIcon img_btnThemVaoGio = new ImageIcon("image_btnThemVaoGio");
        Image scaled_btnThemVaoGio = img_btnThemVaoGio.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        img_btnThemVaoGio = new ImageIcon(scaled_btnThemVaoGio);
        btn_ThemVaoGio.setIcon(img_btnThemVaoGio);
        
        URL image_btnXoaKhoiGio = BanHang_JPanel.class.getResource("/pic/icon/buttonXoa.png");
        ImageIcon img_btnXoaKhoiGio = new ImageIcon("image_btnXoaKhoiGio");
        Image scaled_btnXoaKhoiGio = img_btnXoaKhoiGio.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        img_btnXoaKhoiGio = new ImageIcon(scaled_btnXoaKhoiGio);
        btn_XoaKhoiGio.setIcon(img_btnXoaKhoiGio);
        
        URL image_btnCapNhatSoLuong = BanHang_JPanel.class.getResource("/pic/icon/buttonCapNhat.png");
        ImageIcon img_btnCapNhatSoLuong = new ImageIcon("image_btnCapNhatSoLuong");
        Image scaled_btnCapNhatSoLuong = img_btnCapNhatSoLuong.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        img_btnCapNhatSoLuong = new ImageIcon(scaled_btnCapNhatSoLuong);
        btn_CapNhatSoLuong.setIcon(img_btnCapNhatSoLuong);
        
        URL image_btnLamMoi = BanHang_JPanel.class.getResource("/pic/icon/buttonLamMoi.png");
        ImageIcon img_btnLamMoi = new ImageIcon("image_btnLamMoi");
        Image scaled_btnLamMoi = img_btnLamMoi.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        img_btnLamMoi = new ImageIcon(scaled_btnLamMoi);
        btn_LamMoi.setIcon(img_btnLamMoi);
        
        URL image_btnTaoHoaDon = BanHang_JPanel.class.getResource("/pic/icon/buttonThem.png");
        ImageIcon img_btnTaoHoaDon = new ImageIcon("image_btnTaoHoaDon");
        Image scaled_btnTaoHoaDon = img_btnTaoHoaDon.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        img_btnTaoHoaDon = new ImageIcon(scaled_btnTaoHoaDon);
        btn_TaoHoaDon.setIcon(img_btnTaoHoaDon);
        
        URL image_btnLuuTam = BanHang_JPanel.class.getResource("/pic/icon/buttonThem.png");
        ImageIcon img_btnLuuTam = new ImageIcon("image_btnLuuTam");
        Image scaled_btnLuuTam = img_btnLuuTam.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        img_btnLuuTam = new ImageIcon(scaled_btnLuuTam);
        btn_LuuTam.setIcon(img_btnLuuTam);
        
        URL image_btnTinh = BanHang_JPanel.class.getResource("/pic/icon/buttonThem.png");
        ImageIcon img_btnTinh = new ImageIcon("image_btnTinh");
        Image scaled_btnTinh = img_btnTinh.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        img_btnTinh = new ImageIcon(scaled_btnTinh);
        btn_Tinh.setIcon(img_btnTinh);
        
        String[] cols_GioHang = {"Mã sản phẩm", "Tên sản phẩm", "Kích thước", "Màu sắc", "Số lượng", "Giá gốc", "Giá bán", "Thành tiền"};
        tableModel_GioHang = new DefaultTableModel(cols_GioHang, 0);
        table_GioHang.setModel(tableModel_GioHang);
        
        String[] cols_HoaDon = {"Mã hoá đơn", "Mã khách hàng", "Mã nhân viên", "Mã khuyến mãi", "Ngày lập", "Tiền khuyến mãi", "Tổng tiền", "Tiền thanh toán", "Tinh trạng"};
        tableModel_HoaDon = new DefaultTableModel(cols_HoaDon, 0);
        table_HoaDon.setModel(tableModel_HoaDon);
        
        // spinner
        spinnerModel = new SpinnerNumberModel(0, 0, 100, 1);
        spinner_SoLuong.setModel(spinnerModel);
        spinner_SoLuong.setEnabled(false);
        
        JComponent editor = spinner_SoLuong.getEditor();
            if(editor instanceof JSpinner.DefaultEditor) {
                JTextField textField = ((JSpinner.DefaultEditor) editor).getTextField();

                textField.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        char typedChar = e.getKeyChar();
                        if (!Character.isDigit(typedChar)) {                        
                            e.consume(); 
                        }
                    }
                    
                     @Override
                    public void keyReleased(KeyEvent e) {
                         try {
                             int val = Integer.parseInt(textField.getText());
                             spinnerModel.setValue(val);
                         } catch (NumberFormatException evt) {
                             JOptionPane.showMessageDialog(null, "Số lượng nhập phải là chữ số!");
                         }
                    }
                });

//                textField.addFocusListener(new FocusAdapter() {
//                    @Override
//                    public void focusLost(FocusEvent e) {
//                        kiemTraSoLuongNhap();
//                    }
//                });
            }
        
//        importHoaDon();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_MaSanPham = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        lbl_TenSanPham = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbl_KichThuoc = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbl_ChatLieu = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbl_MauSac = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lbl_ThuongHieu = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lbl_DanhMuc = new javax.swing.JLabel();
        btn_ThemVaoGio = new javax.swing.JButton();
        jLabel36 = new javax.swing.JLabel();
        spinner_SoLuong = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        lbl_KhuyenMaiSP = new javax.swing.JLabel();
        btn_CapNhatSoLuong = new javax.swing.JButton();
        lbl_DonGia1 = new javax.swing.JLabel();
        btn_TimKiemSanPham = new javax.swing.JButton();
        btn_XoaKhoiGio = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        lbl_DonGia = new javax.swing.JLabel();
        lbl_KhuyenMai2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_GioHang = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        txt_SoDienThoai = new javax.swing.JTextField();
        btn_TimKiemKhachHang = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        lbl_MaKhachHang = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lbl_TenKhachHang = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lbl_GioiTinh = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        lbl_DiaChi = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        lbl_TongTien = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        lbl_KhuyenMai = new javax.swing.JLabel();
        lbl_ThueVAT = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        lbl_TienThanhToan = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        txt_TienNhan = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        btn_Tinh = new javax.swing.JButton();
        lbl_TienTraLai = new javax.swing.JLabel();
        btn_LamMoi = new javax.swing.JButton();
        btn_TaoHoaDon = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lbl_KhuyenMai1 = new javax.swing.JLabel();
        btn_LuuTam = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txt_SoDienThoaiKH = new javax.swing.JTextField();
        btn_ThanhToan = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_HoaDon = new javax.swing.JTable();
        btn_TimKiemHoaDon = new javax.swing.JButton();
        btn_XoaHoaDon = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        lbl_BH = new javax.swing.JLabel();

        setBackground(new java.awt.Color(187, 205, 197));
        setPreferredSize(new java.awt.Dimension(1186, 748));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(187, 205, 197));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Thông tin sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel1.setText("Mã sản phẩm");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel2.setText("Tên sản phẩm");

        lbl_TenSanPham.setBackground(new java.awt.Color(255, 255, 255));
        lbl_TenSanPham.setFont(new java.awt.Font("Times New Roman", 2, 20)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel4.setText("Kích thước");

        lbl_KichThuoc.setFont(new java.awt.Font("Times New Roman", 2, 20)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel6.setText("Chất liệu");

        lbl_ChatLieu.setFont(new java.awt.Font("Times New Roman", 2, 20)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel8.setText("Màu sắc");

        lbl_MauSac.setFont(new java.awt.Font("Times New Roman", 2, 20)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel10.setText("Thương hiệu");

        lbl_ThuongHieu.setFont(new java.awt.Font("Times New Roman", 2, 20)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel12.setText("Danh mục");

        lbl_DanhMuc.setFont(new java.awt.Font("Times New Roman", 2, 20)); // NOI18N

        btn_ThemVaoGio.setBackground(new java.awt.Color(0, 51, 51));
        btn_ThemVaoGio.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        btn_ThemVaoGio.setForeground(new java.awt.Color(255, 255, 255));
        btn_ThemVaoGio.setText("Thêm vào giỏ");
        btn_ThemVaoGio.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn_ThemVaoGio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemVaoGioActionPerformed(evt);
            }
        });

        jLabel36.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel36.setText("Số lượng");

        spinner_SoLuong.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel3.setText("Đơn giá");

        lbl_KhuyenMaiSP.setFont(new java.awt.Font("Times New Roman", 2, 20)); // NOI18N

        btn_CapNhatSoLuong.setBackground(new java.awt.Color(0, 51, 51));
        btn_CapNhatSoLuong.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        btn_CapNhatSoLuong.setForeground(new java.awt.Color(255, 255, 255));
        btn_CapNhatSoLuong.setText("Cập nhật số lượng");
        btn_CapNhatSoLuong.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn_CapNhatSoLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CapNhatSoLuongActionPerformed(evt);
            }
        });

        lbl_DonGia1.setFont(new java.awt.Font("Times New Roman", 2, 20)); // NOI18N
        lbl_DonGia1.setText("VND");

        btn_TimKiemSanPham.setBackground(new java.awt.Color(0, 51, 51));
        btn_TimKiemSanPham.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        btn_TimKiemSanPham.setForeground(new java.awt.Color(255, 255, 255));
        btn_TimKiemSanPham.setText("Tìm kiếm");
        btn_TimKiemSanPham.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn_TimKiemSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TimKiemSanPhamActionPerformed(evt);
            }
        });

        btn_XoaKhoiGio.setBackground(new java.awt.Color(204, 0, 0));
        btn_XoaKhoiGio.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        btn_XoaKhoiGio.setForeground(new java.awt.Color(255, 255, 255));
        btn_XoaKhoiGio.setText("Xoá khỏi giỏ");
        btn_XoaKhoiGio.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn_XoaKhoiGio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XoaKhoiGioActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel13.setText("Khuyến mãi");

        lbl_DonGia.setFont(new java.awt.Font("Times New Roman", 2, 20)); // NOI18N

        lbl_KhuyenMai2.setFont(new java.awt.Font("Times New Roman", 2, 20)); // NOI18N
        lbl_KhuyenMai2.setText("%");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txt_MaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbl_TenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_ThuongHieu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_ChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_KichThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_DanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_MauSac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(50, 50, 50)
                                .addComponent(jLabel13)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addComponent(lbl_KhuyenMaiSP, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_KhuyenMai2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(lbl_DonGia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(lbl_DonGia1)
                        .addGap(14, 14, 14))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(btn_TimKiemSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel36)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(spinner_SoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_ThemVaoGio, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_CapNhatSoLuong, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_XoaKhoiGio, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_MaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_ThemVaoGio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36)
                    .addComponent(spinner_SoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_CapNhatSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_TimKiemSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_XoaKhoiGio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(lbl_TenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(lbl_ThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(lbl_KhuyenMai2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_DonGia1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(jLabel10))
                                    .addComponent(lbl_DonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(1, 1, 1))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(lbl_MauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel8))
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel4)
                                                .addComponent(lbl_KichThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(lbl_KhuyenMaiSP, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13))
                                .addGap(19, 19, 19)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbl_ChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel12))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(lbl_DanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(1, 1, 1))))))))
                .addGap(1, 8, Short.MAX_VALUE))
        );

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 1170, 160));

        jPanel3.setBackground(new java.awt.Color(187, 205, 197));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Giỏ hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table_GioHang.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        table_GioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã", "Tên sản phẩm", "Kích thước", "Màu sắc", "Số lượng", "Giá bán", "Thành tiền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_GioHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_GioHangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_GioHang);
        if (table_GioHang.getColumnModel().getColumnCount() > 0) {
            table_GioHang.getColumnModel().getColumn(0).setResizable(false);
            table_GioHang.getColumnModel().getColumn(0).setPreferredWidth(150);
            table_GioHang.getColumnModel().getColumn(0).setHeaderValue("Mã");
            table_GioHang.getColumnModel().getColumn(1).setResizable(false);
            table_GioHang.getColumnModel().getColumn(1).setPreferredWidth(150);
            table_GioHang.getColumnModel().getColumn(1).setHeaderValue("Tên sản phẩm");
            table_GioHang.getColumnModel().getColumn(2).setResizable(false);
            table_GioHang.getColumnModel().getColumn(2).setPreferredWidth(20);
            table_GioHang.getColumnModel().getColumn(2).setHeaderValue("Kích thước");
            table_GioHang.getColumnModel().getColumn(3).setResizable(false);
            table_GioHang.getColumnModel().getColumn(3).setPreferredWidth(50);
            table_GioHang.getColumnModel().getColumn(3).setHeaderValue("Màu sắc");
            table_GioHang.getColumnModel().getColumn(4).setResizable(false);
            table_GioHang.getColumnModel().getColumn(4).setPreferredWidth(20);
            table_GioHang.getColumnModel().getColumn(4).setHeaderValue("Số lượng");
            table_GioHang.getColumnModel().getColumn(5).setResizable(false);
            table_GioHang.getColumnModel().getColumn(5).setPreferredWidth(100);
            table_GioHang.getColumnModel().getColumn(5).setHeaderValue("Giá bán");
            table_GioHang.getColumnModel().getColumn(6).setResizable(false);
            table_GioHang.getColumnModel().getColumn(6).setPreferredWidth(100);
            table_GioHang.getColumnModel().getColumn(6).setHeaderValue("Thành tiền");
        }

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 1150, 110));

        add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 1170, 140));

        jPanel4.setBackground(new java.awt.Color(187, 205, 197));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Thông tin hoá đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14))); // NOI18N

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel14.setText("Số điện thoại");

        btn_TimKiemKhachHang.setBackground(new java.awt.Color(0, 51, 51));
        btn_TimKiemKhachHang.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        btn_TimKiemKhachHang.setForeground(new java.awt.Color(255, 255, 255));
        btn_TimKiemKhachHang.setText("Tìm kiếm");
        btn_TimKiemKhachHang.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn_TimKiemKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TimKiemKhachHangActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel15.setText("Mã khách hàng");

        lbl_MaKhachHang.setFont(new java.awt.Font("Times New Roman", 2, 20)); // NOI18N

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel17.setText("Tên khách hàng");

        lbl_TenKhachHang.setFont(new java.awt.Font("Times New Roman", 2, 20)); // NOI18N

        jLabel21.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel21.setText("Giới tính");

        lbl_GioiTinh.setFont(new java.awt.Font("Times New Roman", 2, 20)); // NOI18N

        jLabel23.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel23.setText("Địa chỉ");

        lbl_DiaChi.setFont(new java.awt.Font("Times New Roman", 2, 20)); // NOI18N
        lbl_DiaChi.setText(" ");

        jLabel25.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel25.setText("Tổng tiền");

        lbl_TongTien.setFont(new java.awt.Font("Times New Roman", 2, 20)); // NOI18N

        jLabel27.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel27.setText("Khuyến mãi");

        lbl_KhuyenMai.setFont(new java.awt.Font("Times New Roman", 2, 20)); // NOI18N

        lbl_ThueVAT.setFont(new java.awt.Font("Times New Roman", 2, 16)); // NOI18N

        jLabel31.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel31.setText("Tiền phải thanh toán");

        lbl_TienThanhToan.setFont(new java.awt.Font("Times New Roman", 2, 20)); // NOI18N

        jLabel33.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel33.setText("Tiền nhận");

        txt_TienNhan.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N

        jLabel34.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel34.setText("Tiền trả lại");

        btn_Tinh.setBackground(new java.awt.Color(0, 51, 51));
        btn_Tinh.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        btn_Tinh.setForeground(new java.awt.Color(255, 255, 255));
        btn_Tinh.setText("Tính");
        btn_Tinh.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn_Tinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TinhActionPerformed(evt);
            }
        });

        lbl_TienTraLai.setFont(new java.awt.Font("Times New Roman", 2, 20)); // NOI18N

        btn_LamMoi.setBackground(new java.awt.Color(0, 51, 51));
        btn_LamMoi.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        btn_LamMoi.setForeground(new java.awt.Color(255, 255, 255));
        btn_LamMoi.setText("Làm mới");
        btn_LamMoi.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn_LamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LamMoiActionPerformed(evt);
            }
        });

        btn_TaoHoaDon.setBackground(new java.awt.Color(0, 51, 51));
        btn_TaoHoaDon.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        btn_TaoHoaDon.setForeground(new java.awt.Color(255, 255, 255));
        btn_TaoHoaDon.setText("Tạo hoá đơn");
        btn_TaoHoaDon.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn_TaoHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TaoHoaDonActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 2, 20)); // NOI18N
        jLabel5.setText("VND");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 2, 20)); // NOI18N
        jLabel7.setText("VND");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 2, 20)); // NOI18N
        jLabel9.setText("VND");

        lbl_KhuyenMai1.setFont(new java.awt.Font("Times New Roman", 2, 20)); // NOI18N
        lbl_KhuyenMai1.setText("%");

        btn_LuuTam.setBackground(new java.awt.Color(0, 51, 51));
        btn_LuuTam.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        btn_LuuTam.setForeground(new java.awt.Color(255, 255, 255));
        btn_LuuTam.setText("Lưu tạm");
        btn_LuuTam.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn_LuuTam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LuuTamActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(461, 461, 461)
                                        .addComponent(lbl_TenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(jLabel15)
                                                .addGap(14, 14, 14)
                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                                        .addComponent(lbl_MaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(jLabel17))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                                        .addComponent(lbl_TongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jLabel9))))
                                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addGap(46, 46, 46)
                                                .addComponent(lbl_ThueVAT, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                                .addGap(20, 20, 20)
                                                .addComponent(lbl_KhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(lbl_KhuyenMai1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(3, 3, 3))))))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel33)
                                .addGap(52, 52, 52)
                                .addComponent(txt_TienNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_Tinh, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel34))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lbl_TienThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbl_TienTraLai, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_GioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel23)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_DiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txt_SoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_TimKiemKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_LamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_TaoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_LuuTam, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_SoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(btn_TimKiemKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_LamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_TaoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_LuuTam, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_MaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(lbl_TenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_GioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_DiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15)
                        .addComponent(jLabel23)))
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_ThueVAT, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel25)
                                .addComponent(lbl_TongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9)))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jLabel7))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel33))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(lbl_TienThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(lbl_TienTraLai, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel31)
                                .addComponent(lbl_KhuyenMai1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbl_KhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addComponent(jLabel34))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel27)
                        .addGap(14, 14, 14)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_TienNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_Tinh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 550, 1170, 190));

        jPanel1.setBackground(new java.awt.Color(187, 205, 197));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Hoá đơn chưa thanh toán", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14))); // NOI18N

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel11.setText("Số điện thoại");

        btn_ThanhToan.setBackground(new java.awt.Color(0, 51, 51));
        btn_ThanhToan.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        btn_ThanhToan.setForeground(new java.awt.Color(255, 255, 255));
        btn_ThanhToan.setText("Thanh toán");
        btn_ThanhToan.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn_ThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThanhToanActionPerformed(evt);
            }
        });

        table_HoaDon.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        table_HoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(table_HoaDon);

        btn_TimKiemHoaDon.setBackground(new java.awt.Color(0, 51, 51));
        btn_TimKiemHoaDon.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        btn_TimKiemHoaDon.setForeground(new java.awt.Color(255, 255, 255));
        btn_TimKiemHoaDon.setText("Tìm kiếm");
        btn_TimKiemHoaDon.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn_TimKiemHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TimKiemHoaDonActionPerformed(evt);
            }
        });

        btn_XoaHoaDon.setBackground(new java.awt.Color(204, 0, 0));
        btn_XoaHoaDon.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        btn_XoaHoaDon.setForeground(new java.awt.Color(255, 255, 255));
        btn_XoaHoaDon.setText("Xoá hoá đơn");
        btn_XoaHoaDon.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn_XoaHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XoaHoaDonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txt_SoDienThoaiKH, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_TimKiemHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_ThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_XoaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(3, 3, 3))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel11))
                    .addComponent(txt_SoDienThoaiKH, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_TimKiemHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_ThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_XoaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(14, 14, 14)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 1170, 170));

        jPanel5.setBackground(new java.awt.Color(187, 205, 197));

        lbl_BH.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lbl_BH.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_BH.setText("QUẢN LÝ BÁN HÀNG");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(471, Short.MAX_VALUE)
                .addComponent(lbl_BH)
                .addGap(469, 469, 469))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lbl_BH)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1186, 50));
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThanhToanActionPerformed
//        thanhToan();
    }//GEN-LAST:event_btn_ThanhToanActionPerformed

    private void btn_ThemVaoGioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemVaoGioActionPerformed
//        themVaoGioHang();
    }//GEN-LAST:event_btn_ThemVaoGioActionPerformed

    private void btn_XoaKhoiGioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XoaKhoiGioActionPerformed
//        xoaKhoiGioHang();
    }//GEN-LAST:event_btn_XoaKhoiGioActionPerformed

    private void btn_TimKiemKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TimKiemKhachHangActionPerformed
        timKiemKhachHang();
    }//GEN-LAST:event_btn_TimKiemKhachHangActionPerformed

    private void btn_TinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TinhActionPerformed
//        tinhTien();
    }//GEN-LAST:event_btn_TinhActionPerformed

    private void btn_LamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LamMoiActionPerformed
//        lamMoi();
    }//GEN-LAST:event_btn_LamMoiActionPerformed

    private void btn_TaoHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TaoHoaDonActionPerformed
//        taoHoaDon();
    }//GEN-LAST:event_btn_TaoHoaDonActionPerformed

    private void btn_CapNhatSoLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CapNhatSoLuongActionPerformed
//        capNhatSoLuong();
    }//GEN-LAST:event_btn_CapNhatSoLuongActionPerformed

    private void btn_LuuTamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LuuTamActionPerformed
//        luuTam();
    }//GEN-LAST:event_btn_LuuTamActionPerformed

    private void btn_TimKiemSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TimKiemSanPhamActionPerformed
        timKiemSanPham();
    }//GEN-LAST:event_btn_TimKiemSanPhamActionPerformed

    private void btn_TimKiemHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TimKiemHoaDonActionPerformed
//        timKiemHoaDon();
    }//GEN-LAST:event_btn_TimKiemHoaDonActionPerformed

    private void table_GioHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_GioHangMouseClicked
        int row = table_GioHang.getSelectedRow();
        int soLuong = Integer.parseInt(tableModel_GioHang.getValueAt(row, 4).toString());
        String maSP = tableModel_GioHang.getValueAt(row, 0).toString();
//        int soLuongMax = hd_bus.getSoLuongTonTheoMa(maSP);
                int soLuongMax = 0;

        spinnerModel.setValue(soLuong);
        spinnerModel.setMaximum(soLuongMax);
        spinner_SoLuong.setEnabled(true);
    }//GEN-LAST:event_table_GioHangMouseClicked
//
    private void btn_XoaHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XoaHoaDonActionPerformed
//        xoaHoaDon();
    }//GEN-LAST:event_btn_XoaHoaDonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_CapNhatSoLuong;
    private javax.swing.JButton btn_LamMoi;
    private javax.swing.JButton btn_LuuTam;
    private javax.swing.JButton btn_TaoHoaDon;
    private javax.swing.JButton btn_ThanhToan;
    private javax.swing.JButton btn_ThemVaoGio;
    private javax.swing.JButton btn_TimKiemHoaDon;
    private javax.swing.JButton btn_TimKiemKhachHang;
    private javax.swing.JButton btn_TimKiemSanPham;
    private javax.swing.JButton btn_Tinh;
    private javax.swing.JButton btn_XoaHoaDon;
    private javax.swing.JButton btn_XoaKhoiGio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_BH;
    private javax.swing.JLabel lbl_ChatLieu;
    private javax.swing.JLabel lbl_DanhMuc;
    private javax.swing.JLabel lbl_DiaChi;
    private javax.swing.JLabel lbl_DonGia;
    private javax.swing.JLabel lbl_DonGia1;
    private javax.swing.JLabel lbl_GioiTinh;
    private javax.swing.JLabel lbl_KhuyenMai;
    private javax.swing.JLabel lbl_KhuyenMai1;
    private javax.swing.JLabel lbl_KhuyenMai2;
    private javax.swing.JLabel lbl_KhuyenMaiSP;
    private javax.swing.JLabel lbl_KichThuoc;
    private javax.swing.JLabel lbl_MaKhachHang;
    private javax.swing.JLabel lbl_MauSac;
    private javax.swing.JLabel lbl_TenKhachHang;
    private javax.swing.JLabel lbl_TenSanPham;
    private javax.swing.JLabel lbl_ThueVAT;
    private javax.swing.JLabel lbl_ThuongHieu;
    private javax.swing.JLabel lbl_TienThanhToan;
    private javax.swing.JLabel lbl_TienTraLai;
    private javax.swing.JLabel lbl_TongTien;
    private javax.swing.JSpinner spinner_SoLuong;
    private javax.swing.JTable table_GioHang;
    private javax.swing.JTable table_HoaDon;
    private javax.swing.JTextField txt_MaSanPham;
    private javax.swing.JTextField txt_SoDienThoai;
    private javax.swing.JTextField txt_SoDienThoaiKH;
    private javax.swing.JTextField txt_TienNhan;
    // End of variables declaration//GEN-END:variables
    
    public void timKiemSanPham() { 
//        String maSP = txt_MaSanPham.getText().trim();
//        if(maSP.equals("")) {
//            JOptionPane.showMessageDialog(this, "Mã sản phẩm chưa nhập !");
//            return;
//        }
//        SanPhamEntity sanPham = sp_bus.timKiemSanPham(maSP);
//        if(sanPham != null) {
//            if(sanPham.getTinhTrang().equals(TinhTrangSPEnum.HETHANG)) {
//                JOptionPane.showMessageDialog(this, "Sản phẩm đã hết hàng!");
//                return;
//            }
//            if(sanPham.getTinhTrang().equals(TinhTrangSPEnum.NGUNGBAN)) {
//                JOptionPane.showMessageDialog(this, "Sản phẩm đã ngừng bán!");
//                return;
//            }
//            
//            spinner_SoLuong.setEnabled(true);
//            spinnerModel.setMinimum(0);
//            int sl = cthd_bus.getSoLuongCTHD(maSP);
//            if(sl > 0) {
//                if(sanPham.getSoLuongTonKho() - sl == 0) {
//                    JOptionPane.showMessageDialog(this, "Sản phẩm đã hết hàng!");
//                    return;
//                } else {
//                    spinnerModel.setMaximum(sanPham.getSoLuongTonKho() - sl);
//                }
//            } else {
//                spinnerModel.setMaximum(sanPham.getSoLuongTonKho());
//            }
//            
//            lbl_TenSanPham.setText(sanPham.getTenSP());
//            lbl_KichThuoc.setText(sanPham.getKichThuoc().toString());
//            lbl_ChatLieu.setText(sanPham.getChatLieu().getTenChatLieu());
//            lbl_MauSac.setText(sanPham.getMauSac().toString());
//            lbl_ThuongHieu.setText(sanPham.getThuongHieu().getTenThuongHieu());
//            lbl_DanhMuc.setText(sanPham.getDanhMucSanPham().getTenDanhMuc());
//            lbl_DonGia.setText(convert.toMoney(sanPham.getDonGia()));
//            if(sanPham.getChuongTrinhKhuyenMai() != null) {
//                lbl_KhuyenMaiSP.setText(sanPham.getChuongTrinhKhuyenMai().getGiamGia()+"");
//            } else {
//                lbl_KhuyenMaiSP.setText("0");
//            }
//
//        } else {
//            JOptionPane.showMessageDialog(this, "Mã sản phẩm không tồn tại!");
//        }
    }
    
    public void timKiemKhachHang() {
//        String soDienThoai = txt_SoDienThoai.getText().trim();
//        if(soDienThoai.equals("")) {
//            JOptionPane.showMessageDialog(this, "Số điện thoại chưa nhập !");
//            return;
//        }
//        KhachHangEntity khachHang = kh_bus.timKiemTheoSDT(soDienThoai);
//        if(khachHang != null) {
//            lbl_MaKhachHang.setText(khachHang.getMaKH());
//            lbl_TenKhachHang.setText(khachHang.getHoTen());
//            lbl_GioiTinh.setText(khachHang.getGioiTinh().toString());
//            lbl_DiaChi.setText(khachHang.getDiaChi());
//            
//            hoaDon.setKhachHang(khachHang);
//        } else {
//            JOptionPane.showMessageDialog(this, "Khách hàng không tồn tại !");
//        }
    }
    
//    public boolean kiemTraSoLuongNhap() {
//        Object val = spinner_SoLuong.getValue();
//
//        if(val instanceof Number) {
//            int sl = ((Number) val).intValue();
//            Object slMax = spinnerModel.getMaximum();
//            if(sl <= 0) {
//                JOptionPane.showMessageDialog(null, "Số lượng nhập lớn hơn 0");
//                return false;
//            } else if(sl > ((int) slMax)) {
//                JOptionPane.showMessageDialog(null, "Số lượng nhập nhỏ hơn hoặc bằng "+slMax);
//                return false;
//            }
//        } else {
//            JOptionPane.showMessageDialog(this, "Số lượng nhập phải là chữ số!");
//            return false;
//        }
//        return true;
//    }
//
//    public void themVaoGioHang() {
//        String maSP = txt_MaSanPham.getText().trim();
//        String tenSP = lbl_TenSanPham.getText().trim();
//        String kichThuoc = lbl_KichThuoc.getText().trim();
//        String mauSac = lbl_MauSac.getText().trim();
//        int soLuong = Integer.parseInt(spinner_SoLuong.getValue().toString());
//        String khuyenMai = lbl_KhuyenMaiSP.getText().trim();
//        String donGia = lbl_DonGia.getText().trim();
//        
//        if(maSP.equals("") || tenSP.equals("") || kichThuoc.equals("") || mauSac.equals("") || donGia.equals("")) {
//            JOptionPane.showMessageDialog(this, "Sản phẩm chưa được tìm thấy !");
//            return;
//        }
//        
//        if(!kiemTraSoLuongNhap()) return;
//  
//        for (ChiTietHoaDonEntity chiTietHD : cthdList) {
//            if(chiTietHD.getSanPham().getMaSP().equals(maSP)) {
//                  JOptionPane.showMessageDialog(this, "Sản phẩm đã tồn tại trong giỏ hàng");
//                  return;
//            }
//        }
//
//        SanPhamEntity sanPham = new SanPhamEntity();
//        sanPham.setMaSP(maSP);
//        sanPham.setTenSP(tenSP);
//        sanPham.setKichThuoc(toEnum.KichThuoctoEnum(kichThuoc));
//        sanPham.setMauSac(toEnum.MauSactoEnum(mauSac));
//        sanPham.setDonGia(convert.toDouble(donGia));
//        ChuongTrinhKhuyenMaiEntity ctkm = new ChuongTrinhKhuyenMaiEntity();
//        ctkm.setGiamGia(Integer.parseInt(khuyenMai));
//        sanPham.setChuongTrinhKhuyenMai(ctkm);
//
//        ChiTietHoaDonEntity cthd = new ChiTietHoaDonEntity();
//        cthd.setSanPham(sanPham);
//        cthd.setSoLuong(soLuong);
//        cthd.setGiaGoc();
//        cthd.setGiaBan();
//        cthd.setThanhTien();
//        cthdList.add(cthd);   
//        
//        importGioHang();
//        txt_MaSanPham.setText("");
//        spinnerModel.setValue(0);
//        
//        tinhTienGioHang();
//        
//        lbl_TenSanPham.setText("");
//        lbl_KichThuoc.setText("");
//        lbl_MauSac.setText("");
//        lbl_ThuongHieu.setText("");
//        lbl_ChatLieu.setText("");
//        lbl_DanhMuc.setText("");
//        lbl_KhuyenMaiSP.setText("");
//        lbl_DonGia.setText("");
//        spinner_SoLuong.setEnabled(false);
//    }
//    
//    private void importGioHang() {
//        tableModel_GioHang.setRowCount(0);
//        for (ChiTietHoaDonEntity cthd : cthdList) {
//            String[] data = {cthd.getSanPham().getMaSP(), cthd.getSanPham().getTenSP(), cthd.getSanPham().getKichThuoc().toString(), cthd.getSanPham().getMauSac().toString(), cthd.getSoLuong()+"", convert.toMoney(cthd.getGiaGoc()),convert.toMoney(cthd.getGiaBan()), convert.toMoney(cthd.getThanhTien())};
//            tableModel_GioHang.addRow(data);
//        }
//    }
//
//    public void xoaKhoiGioHang() {
//        int row = table_GioHang.getSelectedRow();
//        if(row < 0) {
//            JOptionPane.showMessageDialog(this, "Sản phẩm chưa được chọn !");
//            return;
//        }
//        String maSP = table_GioHang.getValueAt(row, 0).toString();
//        ChiTietHoaDonEntity chiTietHoaDon = new ChiTietHoaDonEntity();
//        for (ChiTietHoaDonEntity cthd : cthdList) {
//            if(cthd.getSanPham().getMaSP().equals(maSP)) {
//                chiTietHoaDon = cthd;
//                break;
//            }
//        }
//        cthdList.remove(chiTietHoaDon);
//        tableModel_GioHang.removeRow(row);
//        spinnerModel.setValue(0);
//        spinner_SoLuong.setEnabled(false);
//        tinhTienGioHang();
//    }
//    
//    public void capNhatSoLuong() {
//        int row = table_GioHang.getSelectedRow();
//        if(row < 0) {
//            JOptionPane.showMessageDialog(this, "Sản phẩm chưa được chọn!");
//            return;
//        }
//        
//        if(!kiemTraSoLuongNhap()) return;
//        
//        int soLuong = (int) spinnerModel.getValue();
//        String maSP = tableModel_GioHang.getValueAt(row, 0).toString();
//        for (ChiTietHoaDonEntity cthd : cthdList) {
//            if(cthd.getSanPham().getMaSP().equals(maSP)){
//                cthd.setSoLuong(soLuong);
//                cthd.setThanhTien();
//                
//                tableModel_GioHang.setValueAt(soLuong, row, 4);
//                tableModel_GioHang.setValueAt(convert.toMoney(cthd.getThanhTien()), row, 7);
//                break;
//            }
//        }
//        tinhTienGioHang();
//        table_GioHang.clearSelection();
//        spinnerModel.setValue(1);
//        spinner_SoLuong.setEnabled(false);
//    }
//    
//    public void tinhTienGioHang() {
//        double tongTien=0;
//        for(int i = 0; i <= table_GioHang.getRowCount() -1; i++) {
//               double thanhTien = convert.toDouble(table_GioHang.getValueAt(i, 7).toString());
//               tongTien+=thanhTien;
//        }
//        lbl_TongTien.setText(convert.toMoney(tongTien));
//        
//        ChuongTrinhKhuyenMaiEntity ctkm = ctkm_bus.kiemTraKhuyenMai(tongTien);
//        if(ctkm != null) {
//            lbl_KhuyenMai.setText(ctkm.getGiamGia()+""); 
//            hoaDon.setChuongTrinhKM(ctkm);
//        } else {
//            lbl_KhuyenMai.setText("0"); 
//            hoaDon.setChuongTrinhKM(new ChuongTrinhKhuyenMaiEntity());
//        }
//        hoaDon.setTongTien(tongTien);
//        hoaDon.setTienKhuyenMai();
//        hoaDon.setTienThanhToan();
//        double tienThanhToan = hoaDon.getTienThanhToan();
//        
//        lbl_TienThanhToan.setText(convert.toMoney(tienThanhToan));
//    }
//    
//    public void taoHoaDon() {
//        int rowCount = table_GioHang.getRowCount();
//        if(rowCount == 0) {
//            JOptionPane.showMessageDialog(this, "Giỏ hàng chưa có sản phẩm !");
//            return;
//        }
//        
//        if(lbl_TienTraLai.getText().equals("") || txt_TienNhan.getText().equals("")) {
//            JOptionPane.showMessageDialog(this, "Khách hàng chưa thanh toán !");
//            return;
//        }
//        // Khach Hang
//        if(hoaDon.getKhachHang() == null) {
//           hoaDon.setKhachHang(new KhachHangEntity());
//        }
//
//        // Nhan Vien
//        NhanVienEntity nhanVien = new NhanVienEntity(tc.getMa());
//        hoaDon.setNhanVien(nhanVien);
//        LocalDate now = LocalDate.now();
//        hoaDon.setNgayLapHD(java.sql.Date.valueOf(now));
//        
//        for (ChiTietHoaDonEntity cthd : cthdList) {
//            cthd.setHoaDon(hoaDon);
//        }
//        
//        boolean kq = false;
//        if(table_HoaDon.getSelectedRow() < 0) {
//            GenerateID generateID = new GenerateID();
//            hoaDon.setMaHD(generateID.sinhMa("HD"));
//            kq = hd_bus.themHoaDon(hoaDon, cthdList);
//        } else {
//            kq = hd_bus.themHoaDonLuuTam(hoaDon, cthdList);
//            tableModel_HoaDon.removeRow(table_HoaDon.getSelectedRow());
//        }
//        
//        if(kq) {
//            for (ChiTietHoaDonEntity cthd : cthdList) {
//                boolean ketQua = sp_bus.capNhatSoLuongTonSauKhiTaoHD(cthd.getSanPham().getMaSP(), cthd.getSoLuong());
//                if(!ketQua) {
//                    JOptionPane.showMessageDialog(this, "Cập nhật số lượng tồn kho thất bại!");
//                    return;
//                }
//            }
//            double tienNhan = Double.parseDouble(txt_TienNhan.getText().trim());
//            double tienTraLai = convert.toDouble(lbl_TienTraLai.getText().trim());
//            new ThongTinHoaDon_GUI(hoaDon, cthdList, tienNhan, tienTraLai).setVisible(true);
//            lamMoi();
//        } else {
//            JOptionPane.showMessageDialog(this, "Tạo hoá đơn thất bại !");
//        }
//    }
//    
//    public void luuTam() {
//        int rowCount = table_GioHang.getRowCount();
//        if(rowCount == 0) {
//            JOptionPane.showMessageDialog(this, "Giỏ hàng chưa có sản phẩm !");
//            return;
//        }
//        
//        String soDienThoai = txt_SoDienThoai.getText().trim();
//        String maKH = lbl_MaKhachHang.getText().trim();
//        if(soDienThoai.equals("") || maKH.equals("")) {
//            JOptionPane.showMessageDialog(this, "Lưu tạm bắt buộc khách hàng tồn tại!");
//            return;
//        }
//        
//        // Nhan Vien
//        NhanVienEntity nhanVien = new NhanVienEntity(tc.getMa());
//        hoaDon.setNhanVien(nhanVien);
//        hoaDon.setNgayLapHD(new java.sql.Date(new Date().getTime()));
//        
//        for (ChiTietHoaDonEntity cthd : cthdList) {
//            cthd.setHoaDon(hoaDon);
//        }
//        
//        int rowHD = table_HoaDon.getSelectedRow();
//        if(rowHD >= 0) {
//            String maHD = tableModel_HoaDon.getValueAt(rowHD, 0).toString();
//            ArrayList<HoaDonEntity> luuTamList = hd_bus.timKiemHoaDonChuaThanhToan(soDienThoai);
//            for (HoaDonEntity hd : luuTamList) {
//                if(hd.getMaHD().equals(maHD)) {
//                    boolean kq = hd_bus.capNhatHoaDonLuuTam(hoaDon, cthdList);
//                    if(kq) { 
//                        JOptionPane.showMessageDialog(this, "Cập nhật hoá đơn lưu tạm thành công!");
//                        lamMoi();
//                    } else {
//                        JOptionPane.showMessageDialog(this, "Cập nhật hoá đơn lưu tạm thất bại!");
//                    }
//                    return;
//                }
//            }
//        }
//        
//        GenerateID generateID = new GenerateID();
//        hoaDon.setMaHD(generateID.sinhMa("HD"));
//
//        boolean kq = hd_bus.luuTamHoaDon(hoaDon, cthdList);
//        if(kq) {
//            JOptionPane.showMessageDialog(this, "Lưu tạm thành công !");
//            lamMoi();
//        } else {
//            JOptionPane.showMessageDialog(this, "Lưu tạm thất bại !");
//        }
//    }
//    
//    public void importHoaDon() {
//        tableModel_HoaDon.setRowCount(0);
//        hdList = hd_bus.getAllHDChuaThanhToan();
//        for (HoaDonEntity hd : hdList) {
//            String[] data = {hd.getMaHD(), hd.getKhachHang().getMaKH(), hd.getNhanVien().getMaNV(), hd.getChuongTrinhKM().getMaCTKM(), hd.getNgayLapHD().toString(), convert.toMoney(hd.getTienKhuyenMai()), convert.toMoney(hd.getTongTien()), convert.toMoney(hd.getTienThanhToan()), hd.getTinhTrang().toString()};
//            tableModel_HoaDon.addRow(data);
//        }
//    }
//    
//    public void lamMoi() {
//        txt_SoDienThoaiKH.setText("");
//        tableModel_HoaDon.setRowCount(0);
//        txt_MaSanPham.setText("");
//        lbl_TenSanPham.setText("");
//        lbl_KichThuoc.setText("");
//        lbl_MauSac.setText("");
//        lbl_ThuongHieu.setText("");
//        lbl_ChatLieu.setText("");
//        lbl_DanhMuc.setText("");
//        lbl_DonGia.setText("");
//        lbl_KhuyenMaiSP.setText("");
//        spinnerModel.setValue(0);
//        spinner_SoLuong.setEnabled(false);
//        
//        tableModel_GioHang.setRowCount(0);
//        importHoaDon();
//        hoaDon = new HoaDonEntity();
//        cthdList = new ArrayList<ChiTietHoaDonEntity>();
//        
//        txt_SoDienThoai.setText("");
//        lbl_MaKhachHang.setText("");
//        lbl_TenKhachHang.setText("");
//        lbl_GioiTinh.setText("");
//        lbl_DiaChi.setText("");
//        lbl_TongTien.setText("");
//        lbl_KhuyenMai.setText("");
//        lbl_TienThanhToan.setText("");
//        txt_TienNhan.setText("");
//        lbl_TienTraLai.setText("");
//    }
//    
//    public void tinhTien() {
//        if(lbl_TienThanhToan.getText().trim().equals("")) {
//            JOptionPane.showMessageDialog(this, "Tiền thanh toán chưa có !");
//            return;
//        }
//        String tienNhan = txt_TienNhan.getText().trim();
//        if(tienNhan.equals("")) {
//            JOptionPane.showMessageDialog(this, "Tiền nhận chưa nhập !");
//            return;
//        }
//        try {
//        double tienNhanKH = Double.parseDouble(tienNhan);
//        if(tienNhanKH > 1000000000) {
//            JOptionPane.showMessageDialog(this, "Tiền nhận tối đa là 1,000,000,000");
//            return;
//        }
//        double tienThanhToan = convert.toDouble(lbl_TienThanhToan.getText());
//
//        if (tienNhanKH < tienThanhToan) {
//            JOptionPane.showMessageDialog(this, "Tiền nhận phải lớn hơn hoặc bằng tiền phải thanh toán !");
//            return;
//        }
//        double tienTraLai = tienNhanKH - tienThanhToan;
//        lbl_TienTraLai.setText(convert.toMoney(tienTraLai));
//        } catch (NumberFormatException e) {
//            JOptionPane.showMessageDialog(this, "Tiền nhận phải là chữ số!");
//        }
//    }
//    
//    public void timKiemHoaDon() {
//        String sdt = txt_SoDienThoaiKH.getText().trim();
//        if(sdt.equals("")) {
//            JOptionPane.showMessageDialog(this, "Số điện thoại khách hàng chưa được nhập!");
//            return;
//        }
//        
//        hdList = hd_bus.timKiemHoaDonChuaThanhToan(sdt);
//        if(hdList != null && hdList.isEmpty() == false) {
//            tableModel_HoaDon.setRowCount(0);
//            for (HoaDonEntity hd : hdList) {
//                String[] data = {hd.getMaHD(), hd.getKhachHang().getMaKH(), hd.getNhanVien().getMaNV(), hd.getChuongTrinhKM().getMaCTKM(), hd.getNgayLapHD().toString(), convert.toMoney(hd.getTienKhuyenMai()), convert.toMoney(hd.getTongTien()), convert.toMoney(hd.getTienThanhToan()), hd.getTinhTrang().toString()};
//                tableModel_HoaDon.addRow(data);
//            }
//
//        } else {
//            JOptionPane.showMessageDialog(this, "Số điện thoại không có hoá đơn nào chưa thanh toán!");
//        }
//    }
//    
//    public void thanhToan() {
//        int row = table_HoaDon.getSelectedRow();
//        if(row < 0) {
//            JOptionPane.showMessageDialog(this, "Hoá đơn chưa được chọn!");
//            return;
//        }
//        String maHD = tableModel_HoaDon.getValueAt(row, 0).toString();
//        for (HoaDonEntity hd : hdList) {
//            if(hd.getMaHD().equals(maHD)) {
//                hoaDon = hd;
//                break;
//            }
//        }
//        
//        txt_SoDienThoai.setText(hoaDon.getKhachHang().getSoDienThoai());
//        lbl_MaKhachHang.setText(hoaDon.getKhachHang().getMaKH());
//        lbl_TenKhachHang.setText(hoaDon.getKhachHang().getHoTen());
//        lbl_GioiTinh.setText(hoaDon.getKhachHang().getGioiTinh().toString());
//        lbl_DiaChi.setText(hoaDon.getKhachHang().getDiaChi());
//
//        cthdList = cthd_bus.getAllCTHDTheoMaHD(hoaDon.getMaHD());
//        importGioHang();
//        tinhTienGioHang();
//    }
//    
//    public void xoaHoaDon() {
//        int row = table_HoaDon.getSelectedRow();
//        if(row < 0) {
//            JOptionPane.showMessageDialog(this, "Hoá đơn chưa được chọn!");
//            return;
//        }
//        String maHD = tableModel_HoaDon.getValueAt(row, 0).toString();
//        boolean kq = hd_bus.xoaHoaDon(maHD);
//        if(kq) {
//            importHoaDon();
//        } else {
//            JOptionPane.showMessageDialog(this, "Xoá hoá đơn thất bại!");
//        }
//    }
}
