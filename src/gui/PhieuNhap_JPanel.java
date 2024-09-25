/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui;

import bus.MatHangNhap_bus;
import bus.NhaCungCap_bus;
import bus.SanPham_bus;
import entity.MatHangNhapEntity;
import entity.NhaCungCapEntity;
import entity.SanPhamEntity;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Image;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import util.GenerateID;

/**
 *
 * @author 84335
 */
public class PhieuNhap_JPanel extends javax.swing.JPanel {

    private MatHangNhap_bus mhn_bus;
    private NhaCungCap_bus ncc_bus;
    private SanPham_bus sp_bus;
    private SanPham_JPanel sp_panel;

    /**
     * Creates new form PhieuNhap_JPanel
     */
    public PhieuNhap_JPanel() {
        initComponents();
        //Khỏi tạo
        mhn_bus = new MatHangNhap_bus();
        ncc_bus = new NhaCungCap_bus();
        sp_bus = new SanPham_bus();
        sp_panel = new SanPham_JPanel();
        //------------
        setBounds(0, 0, 1186, 748);
        
        URL urlBtnTimKiem = getClass().getResource("/pic/icon/buttonTimKiem.png");
        ImageIcon img_btnTimKiem = new ImageIcon(urlBtnTimKiem);
        Image scaled_btnTimKiem = img_btnTimKiem.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        img_btnTimKiem = new ImageIcon(scaled_btnTimKiem);
        btn_TimKiem.setIcon(img_btnTimKiem);
        
        URL urlBtnLamMoi = getClass().getResource("/pic/icon/buttonLamMoi.png");
        ImageIcon img_btnLamMoi = new ImageIcon(urlBtnLamMoi);
        Image scaled_btnLamMoi = img_btnLamMoi.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        img_btnLamMoi = new ImageIcon(scaled_btnLamMoi);
        btn_LamMoi.setIcon(img_btnLamMoi);
        
        URL urlBtnNhapHang = getClass().getResource("/pic/icon/buttonNhapHang.png");
        ImageIcon img_btn_NhapHang = new ImageIcon(urlBtnNhapHang);
        Image scaled_btn_NhapHang = img_btn_NhapHang.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        img_btn_NhapHang = new ImageIcon(scaled_btn_NhapHang);
        btn_NhapHang.setIcon(img_btn_NhapHang);
        
        URL urlBtnCapNhat = getClass().getResource("/pic/icon/buttonCapNhat.png");
        ImageIcon img_btn_CapNhat = new ImageIcon(urlBtnCapNhat);
        Image scaled_btn_CapNhat = img_btn_CapNhat.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        img_btn_CapNhat = new ImageIcon(scaled_btn_CapNhat);
        btn_CapNhat.setIcon(img_btn_CapNhat);
        
        URL urlBtnNhapExcel = getClass().getResource("/pic/icon/buttonNhapExcel.png");
        ImageIcon img_btn_NhapExcel = new ImageIcon(urlBtnNhapExcel);
        Image scaled_btn_NhapExcel = img_btn_NhapExcel.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        img_btn_NhapExcel = new ImageIcon(scaled_btn_NhapExcel);
        btn_NhapExcel.setIcon(img_btn_NhapExcel);
        
        URL urlBtnXuatExcel = getClass().getResource("/pic/icon/buttonXuatExcel.png");
        ImageIcon img_btn_XuatExcel = new ImageIcon(urlBtnXuatExcel);
        Image scaled_btn_XuatExcel = img_btn_XuatExcel.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        img_btn_XuatExcel = new ImageIcon(scaled_btn_XuatExcel);
        btn_XuatExcel.setIcon(img_btn_XuatExcel);
        
        URL urlBtnLuu = getClass().getResource("/pic/icon/buttonLuu.png");
        ImageIcon img_btn_Luu = new ImageIcon(urlBtnLuu);
        Image scaled_btn_Luu = img_btn_Luu.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        img_btn_Luu = new ImageIcon(scaled_btn_Luu);
        btn_Luu.setIcon(img_btn_Luu);

        loadDuLieuTuDataLenTable();
        duaDuLieuVaoComboBox(cbo_MaNhaCungCap, ncc_bus.layDSNCCDangNhap(), "TenNCC");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_TieuDe = new javax.swing.JLabel();
        panel_ThongTin = new javax.swing.JPanel();
        lbl_MaMatHangNhap = new javax.swing.JLabel();
        lbl_MaNhaCungCap = new javax.swing.JLabel();
        txt_MaMatHangNhap = new javax.swing.JTextField();
        lbl_NgayNhap = new javax.swing.JLabel();
        lbl_SoLuong = new javax.swing.JLabel();
        cbo_MaNhaCungCap = new javax.swing.JComboBox<>();
        jdc_NgayNhap = new com.toedter.calendar.JDateChooser();
        spinner_SoLuong = new javax.swing.JSpinner();
        txt_An = new javax.swing.JTextField();
        txt_MaSanPham = new javax.swing.JTextField();
        lbl_MaSanPham = new javax.swing.JLabel();
        panel_ThaoTac = new javax.swing.JPanel();
        lbl_NgayNhap_Search = new javax.swing.JLabel();
        btn_TimKiem = new javax.swing.JButton();
        btn_LamMoi = new javax.swing.JButton();
        btn_NhapHang = new javax.swing.JButton();
        btn_CapNhat = new javax.swing.JButton();
        jdc_NgayNhap_Search = new com.toedter.calendar.JDateChooser();
        btn_NhapExcel = new javax.swing.JButton();
        btn_XuatExcel = new javax.swing.JButton();
        btn_Luu = new javax.swing.JButton();
        panel_DanhSachPhieuNhapHang = new javax.swing.JPanel();
        scroll_TablePhieuNhapHang = new javax.swing.JScrollPane();
        Object[][] data = {};
        String[] columnNames = {"Mã mặt hàng nhập","Mã sản phẩm", "Tên nhà cung cấp", "Số lượng", "Ngày nhập"};
        model=new DefaultTableModel(data, columnNames){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        table_PhieuNhapHang = new javax.swing.JTable();

        setBackground(new java.awt.Color(187, 205, 197));
        setPreferredSize(new java.awt.Dimension(1355, 843));

        lbl_TieuDe.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lbl_TieuDe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_TieuDe.setText("PHIẾU NHẬP HÀNG");
        lbl_TieuDe.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_TieuDe.setPreferredSize(new java.awt.Dimension(675, 40));

        panel_ThongTin.setBackground(new java.awt.Color(187, 205, 197));
        panel_ThongTin.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Thông tin phiếu nhập hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 12))); // NOI18N
        panel_ThongTin.setPreferredSize(new java.awt.Dimension(998, 87));
        panel_ThongTin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_MaMatHangNhap.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbl_MaMatHangNhap.setText("Mã mặt hàng nhập");
        lbl_MaMatHangNhap.setPreferredSize(new java.awt.Dimension(85, 15));
        panel_ThongTin.add(lbl_MaMatHangNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 120, 20));

        lbl_MaNhaCungCap.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbl_MaNhaCungCap.setText("Nhà cung cấp");
        lbl_MaNhaCungCap.setPreferredSize(new java.awt.Dimension(85, 15));
        panel_ThongTin.add(lbl_MaNhaCungCap, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 120, 30));

        txt_MaMatHangNhap.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_MaMatHangNhap.setPreferredSize(new java.awt.Dimension(68, 26));
        txt_MaMatHangNhap.setEditable(false);
        panel_ThongTin.add(txt_MaMatHangNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 200, 30));

        lbl_NgayNhap.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbl_NgayNhap.setText("Ngày nhập");
        lbl_NgayNhap.setPreferredSize(new java.awt.Dimension(85, 15));
        panel_ThongTin.add(lbl_NgayNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 60, -1, 30));

        lbl_SoLuong.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbl_SoLuong.setText("Số lượng");
        lbl_SoLuong.setMaximumSize(new java.awt.Dimension(82, 15));
        lbl_SoLuong.setMinimumSize(new java.awt.Dimension(82, 15));
        lbl_SoLuong.setPreferredSize(new java.awt.Dimension(85, 15));
        panel_ThongTin.add(lbl_SoLuong, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 20, 70, 26));

        cbo_MaNhaCungCap.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        panel_ThongTin.add(cbo_MaNhaCungCap, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 200, 30));

        jdc_NgayNhap.setDate(new Date());
        jdc_NgayNhap.setLocale(new Locale("vi","VN"));
        //jdc_NgayNhap.setSelectableDateRange(new Date(), null);
        //jdc_NgayNhap.setMinSelectableDate(new Date());
        jdc_NgayNhap.setMaxSelectableDate(new Date());
        jdc_NgayNhap.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        panel_ThongTin.add(jdc_NgayNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 60, 200, 30));

        spinner_SoLuong.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        SpinnerNumberModel modelSpinner = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
        spinner_SoLuong.setModel(modelSpinner);
        panel_ThongTin.add(spinner_SoLuong, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 20, 108, 30));

        txt_An.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_An.setText("jTextField1");
        panel_ThongTin.add(txt_An, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 200, 30));

        txt_MaSanPham.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        panel_ThongTin.add(txt_MaSanPham, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, 200, 30));

        lbl_MaSanPham.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbl_MaSanPham.setText("Mã sản phẩm");
        panel_ThongTin.add(lbl_MaSanPham, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, -1, -1));

        panel_ThaoTac.setBackground(new java.awt.Color(187, 205, 197));
        panel_ThaoTac.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Các thao tác", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 12))); // NOI18N
        panel_ThaoTac.setPreferredSize(new java.awt.Dimension(990, 50));

        lbl_NgayNhap_Search.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lbl_NgayNhap_Search.setText("Ngày nhập");

        btn_TimKiem.setBackground(new java.awt.Color(0, 51, 51));
        btn_TimKiem.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        btn_TimKiem.setForeground(java.awt.Color.white);
        btn_TimKiem.setText("Tìm kiếm");
        btn_TimKiem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_TimKiem.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btn_TimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TimKiemActionPerformed(evt);
            }
        });

        btn_LamMoi.setBackground(new java.awt.Color(0, 51, 51));
        btn_LamMoi.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        btn_LamMoi.setForeground(java.awt.Color.white);
        btn_LamMoi.setText("Làm mới");
        btn_LamMoi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_LamMoi.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btn_LamMoi.setPreferredSize(new java.awt.Dimension(90, 31));
        btn_LamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LamMoiActionPerformed(evt);
            }
        });

        btn_NhapHang.setBackground(new java.awt.Color(0, 51, 51));
        btn_NhapHang.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        btn_NhapHang.setForeground(java.awt.Color.white);
        btn_NhapHang.setText("Nhập hàng");
        btn_NhapHang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_NhapHang.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btn_NhapHang.setPreferredSize(new java.awt.Dimension(90, 31));
        btn_NhapHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_NhapHangActionPerformed(evt);
            }
        });

        btn_CapNhat.setBackground(new java.awt.Color(0, 51, 51));
        btn_CapNhat.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        btn_CapNhat.setForeground(java.awt.Color.white);
        btn_CapNhat.setText("Cập nhật");
        btn_CapNhat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_CapNhat.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btn_CapNhat.setPreferredSize(new java.awt.Dimension(90, 31));
        btn_CapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CapNhatActionPerformed(evt);
            }
        });

        jdc_NgayNhap_Search.setDate(new Date());
        jdc_NgayNhap_Search.setLocale(new Locale("vi","VN"));
        jdc_NgayNhap_Search.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        btn_NhapExcel.setBackground(new java.awt.Color(0, 51, 51));
        btn_NhapExcel.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        btn_NhapExcel.setForeground(java.awt.Color.white);
        btn_NhapExcel.setText("Nhập Excel");
        btn_NhapExcel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_NhapExcel.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btn_NhapExcel.setPreferredSize(new java.awt.Dimension(90, 31));
        btn_NhapExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_NhapExcelActionPerformed(evt);
            }
        });

        btn_XuatExcel.setBackground(new java.awt.Color(0, 51, 51));
        btn_XuatExcel.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        btn_XuatExcel.setForeground(java.awt.Color.white);
        btn_XuatExcel.setText("Xuất Excel");
        btn_XuatExcel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_XuatExcel.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btn_XuatExcel.setPreferredSize(new java.awt.Dimension(90, 31));
        btn_XuatExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XuatExcelActionPerformed(evt);
            }
        });

        btn_Luu.setBackground(new java.awt.Color(0, 51, 51));
        btn_Luu.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        btn_Luu.setForeground(java.awt.Color.white);
        btn_Luu.setText("Lưu");
        btn_Luu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Luu.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btn_Luu.setPreferredSize(new java.awt.Dimension(90, 31));
        btn_Luu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LuuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_ThaoTacLayout = new javax.swing.GroupLayout(panel_ThaoTac);
        panel_ThaoTac.setLayout(panel_ThaoTacLayout);
        panel_ThaoTacLayout.setHorizontalGroup(
            panel_ThaoTacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_ThaoTacLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(lbl_NgayNhap_Search)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jdc_NgayNhap_Search, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_LamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_NhapHang, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_CapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_NhapExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_XuatExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_Luu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panel_ThaoTacLayout.setVerticalGroup(
            panel_ThaoTacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_ThaoTacLayout.createSequentialGroup()
                .addGroup(panel_ThaoTacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_ThaoTacLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lbl_NgayNhap_Search))
                    .addGroup(panel_ThaoTacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_LamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_NhapHang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_CapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_NhapExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_XuatExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_Luu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jdc_NgayNhap_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7))
        );

        panel_DanhSachPhieuNhapHang.setBackground(new java.awt.Color(187, 205, 197));
        panel_DanhSachPhieuNhapHang.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Bảng danh sách phiếu nhập hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 12))); // NOI18N

        JTableHeader tableHeader=table_PhieuNhapHang.getTableHeader();
        tableHeader.setFont(new Font("Times New Roman", Font.BOLD, 13));
        table_PhieuNhapHang.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        table_PhieuNhapHang.setModel(model);
        table_PhieuNhapHang.getColumnModel().getColumn(2).setPreferredWidth(5);
        table_PhieuNhapHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_PhieuNhapHangMouseClicked(evt);
            }
        });
        scroll_TablePhieuNhapHang.setViewportView(table_PhieuNhapHang);

        javax.swing.GroupLayout panel_DanhSachPhieuNhapHangLayout = new javax.swing.GroupLayout(panel_DanhSachPhieuNhapHang);
        panel_DanhSachPhieuNhapHang.setLayout(panel_DanhSachPhieuNhapHangLayout);
        panel_DanhSachPhieuNhapHangLayout.setHorizontalGroup(
            panel_DanhSachPhieuNhapHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scroll_TablePhieuNhapHang)
        );
        panel_DanhSachPhieuNhapHangLayout.setVerticalGroup(
            panel_DanhSachPhieuNhapHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scroll_TablePhieuNhapHang, javax.swing.GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_TieuDe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_ThongTin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel_DanhSachPhieuNhapHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel_ThaoTac, javax.swing.GroupLayout.DEFAULT_SIZE, 1345, Short.MAX_VALUE))
                .addGap(5, 5, 5))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_TieuDe, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_ThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_ThaoTac, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_DanhSachPhieuNhapHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    //Hàn load dữ liệu từ database lên table
    private void loadDuLieuTuDataLenTable() {
        ArrayList<MatHangNhapEntity> dsMHN = mhn_bus.getAllMatHangNhap();
        for (MatHangNhapEntity mhn : dsMHN) {
            String tenNCC = ncc_bus.layTenNhaCungCapTheoMa(mhn.getNhaCungCap().getMaNCC());
            model.addRow(new Object[]{mhn.getMaMHN(), mhn.getSanPham().getMaSP(), tenNCC, mhn.getSoLuongNhap(), mhn.getNgayNhap()});
        }
    }

    //Hàm đưa dữ liệu vào combobox
    private void duaDuLieuVaoComboBox(JComboBox comboBox, ArrayList<?> data, String thuocTinh) {
        DefaultComboBoxModel<Object> model = new DefaultComboBoxModel<>();
        for (Object item : data) {
            try {
                Object propertyValue = item.getClass().getMethod("get" + thuocTinh).invoke(item);
                model.addElement(propertyValue);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        comboBox.setModel(model);
    }

    private void btn_TimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TimKiemActionPerformed
        // TODO add your handling code here:
        Date date = jdc_NgayNhap_Search.getDate();
        LocalDate ngayTim = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        timKiemTheoNgay(ngayTim);

    }//GEN-LAST:event_btn_TimKiemActionPerformed

    //Hàm tìm kiếm theo ngày
    private void timKiemTheoNgay(LocalDate ngayTimKiem) {
        model.setRowCount(0);
        ArrayList<MatHangNhapEntity> dsMHN = mhn_bus.timKiemMHN(ngayTimKiem);
        if (dsMHN.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Không có phiếu nhập hàng");
            lamMoi();
        } else {
            for (MatHangNhapEntity mhn : dsMHN) {
                String tenNCC = ncc_bus.layTenNhaCungCapTheoMa(mhn.getNhaCungCap().getMaNCC());
                model.addRow(new Object[]{mhn.getMaMHN(), mhn.getSanPham().getMaSP(), tenNCC, mhn.getSoLuongNhap(), mhn.getNgayNhap()});
            }
        }
    }

    private void btn_LamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LamMoiActionPerformed
        // TODO add your handling code here:
        lamMoi();
    }//GEN-LAST:event_btn_LamMoiActionPerformed

    //Hàm làm mới
    private void lamMoi() {
        txt_MaMatHangNhap.setText("");
        cbo_MaNhaCungCap.setSelectedIndex(0);
        txt_MaSanPham.setText("");
        txt_MaSanPham.setEditable(true);
        spinner_SoLuong.setValue(0);
        jdc_NgayNhap.setDate(new Date());
        jdc_NgayNhap_Search.setDate(new Date());
        model.setRowCount(0);
        cbo_MaNhaCungCap.removeAllItems();
        duaDuLieuVaoComboBox(cbo_MaNhaCungCap, ncc_bus.layDSNCCDangNhap(), "TenNCC");
        loadDuLieuTuDataLenTable();
//        cbo_MaNhaCungCap.setEnabled(true);
        btn_NhapHang.setEnabled(true);
    }

    private void btn_NhapHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_NhapHangActionPerformed
        // TODO add your handling code here:
        nhapHang();
    }//GEN-LAST:event_btn_NhapHangActionPerformed

    //Hàm nhập hàng
    private void nhapHang() {
        if (validata()) {
            String maMHN = GenerateID.sinhMa("MHN");
            String maSP = txt_MaSanPham.getText().trim();
            String tenNCC = cbo_MaNhaCungCap.getSelectedItem().toString();
            int soLuongNhap = (int) spinner_SoLuong.getValue();
            Date ngayNhap_Date = jdc_NgayNhap.getDate();
            LocalDate ngayNhap_LocalDate = ngayNhap_Date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            SanPhamEntity sp = new SanPhamEntity(maSP);
            String maNCC = ncc_bus.layMaNhaCungCapTheoTen(tenNCC);
            NhaCungCapEntity ncc = new NhaCungCapEntity(maNCC);
            MatHangNhapEntity mhn = new MatHangNhapEntity(maMHN, ncc, sp, soLuongNhap, ngayNhap_LocalDate);
            boolean kiemTra = mhn_bus.nhapHang(mhn);
            if (kiemTra) {
                int soLuongHienTai = sp_bus.laySoLuongTonKhoTheoMaSP(maSP);
                int soLuongMoi = soLuongHienTai + soLuongNhap;
                sp_bus.capNhatSoLuong(maSP, soLuongMoi);
                String nCC = ncc_bus.layTenNhaCungCapTheoMa(mhn.getNhaCungCap().getMaNCC());
                model.addRow(new Object[]{mhn.getSanPham().getMaSP(), nCC, mhn.getSoLuongNhap(), mhn.getNgayNhap()});
                lamMoi();
                JOptionPane.showMessageDialog(null, "Nhập hàng thành công");
            } else {
                JOptionPane.showMessageDialog(null, "Nhập hàng không thành công");
            }
        }
    }

    private void btn_CapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CapNhatActionPerformed
        // TODO add your handling code here:
        capNhatMatHangNhap();
    }//GEN-LAST:event_btn_CapNhatActionPerformed

    //Hàm cập nhập mặt hàng nhập
    private void capNhatMatHangNhap() {
        int row = table_PhieuNhapHang.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(null, "Chưa chọn phiếu nhập hàng để cập nhật");
        } else {
            if (table_PhieuNhapHang.getSelectedRowCount() == 1) {
                LocalDate ngayHienTai = LocalDate.now();
                LocalDate ngayNhap_Date_Table = (LocalDate) table_PhieuNhapHang.getValueAt(row, 4);
                if (ngayNhap_Date_Table.isEqual(ngayHienTai)) {
                    if (validata()) {
                        if (JOptionPane.showConfirmDialog(null, "Bạn có chắc chắc cập nhật phiếu nhập hàng có mã sản phẩm" + table_PhieuNhapHang.getValueAt(row, 0) + " này không?", "Cảnh báo cập nhật", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

                            String maMHN = txt_MaMatHangNhap.getText();
                            int soLuongNhapMoi = (int) spinner_SoLuong.getValue();
                            int soLuongNhapBanDau = laySoLuongNhapBanDau(maMHN);
                            if (soLuongNhapBanDau != -1) {
                                String maSP = txt_MaSanPham.getText().trim();
                                String tenNCC = cbo_MaNhaCungCap.getSelectedItem().toString();
                                int soLuongHT = sp_bus.laySoLuongTonKhoTheoMaSP(txt_MaSanPham.getText().trim());
                                int soLuongThayDoi = soLuongNhapBanDau - soLuongNhapMoi;
                                int soLuongMoiCapNhat = soLuongHT - soLuongThayDoi;
                                Date ngayNhap_Date = jdc_NgayNhap.getDate();
                                LocalDate ngayNhap_LocalDate = ngayNhap_Date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                                SanPhamEntity sp = new SanPhamEntity(maSP);
                                String maNCC = ncc_bus.layMaNhaCungCapTheoTen(tenNCC);
                                NhaCungCapEntity ncc = new NhaCungCapEntity(maNCC);
                                MatHangNhapEntity mhn = new MatHangNhapEntity(maMHN, ncc, sp, soLuongNhapMoi, ngayNhap_LocalDate);
                                boolean kq = mhn_bus.capNhapMatHangNhap(mhn);
                                if (kq) {
                                    JOptionPane.showMessageDialog(null, "Cập nhật thành công");
                                    sp_bus.capNhatSoLuong(maSP, soLuongMoiCapNhat);
                                    lamMoi();
                                } else {
                                    JOptionPane.showMessageDialog(null, "Cập nhật không thành công");
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Không tìm thấy đơn hàng nhập với mã " + maMHN);
                            }
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Chỉ được cập nhật khi ngày nhập của phiếu nhập hàng là ngày hiện tại");
                }
            }
        }
    }

    private void table_PhieuNhapHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_PhieuNhapHangMouseClicked
        // TODO add your handling code here:
        int row = table_PhieuNhapHang.getSelectedRow();
        txt_MaMatHangNhap.setText(model.getValueAt(row, 0).toString());
        txt_MaMatHangNhap.setEditable(false);
        txt_MaSanPham.setText(model.getValueAt(row, 1).toString());
        cbo_MaNhaCungCap.setSelectedItem(model.getValueAt(row, 2).toString());
        txt_MaSanPham.setEditable(false);
        spinner_SoLuong.setValue(model.getValueAt(row, 3));
        LocalDate ngayNhap = (LocalDate) model.getValueAt(row, 4);
        Date chuyenDoi = Date.from(ngayNhap.atStartOfDay(ZoneId.systemDefault()).toInstant());
        jdc_NgayNhap.setDate(chuyenDoi);
//        cbo_MaNhaCungCap.setEnabled(false);
//        panel_ThaoTac.remove(cbo_MaNhaCungCap);
//        txt_An.setText(model.getValueAt(row, 2).toString());
//        txt_An.setEditable(false);
        btn_NhapHang.setEnabled(false);
    }//GEN-LAST:event_table_PhieuNhapHangMouseClicked

    private void btn_XuatExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XuatExcelActionPerformed
        // TODO add your handling code here:
        xuatExcel();
    }//GEN-LAST:event_btn_XuatExcelActionPerformed

    private void btn_NhapExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_NhapExcelActionPerformed
        // TODO add your handling code here:
        nhapExcel();
    }//GEN-LAST:event_btn_NhapExcelActionPerformed

    private void btn_LuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LuuActionPerformed
        // TODO add your handling code here:
        luu();
    }//GEN-LAST:event_btn_LuuActionPerformed
    //Hàm lưu dữ liệu từ table vào db
    private void luu() {
        for (int i = 0; i < model.getRowCount(); i++) {
            String maMHN = model.getValueAt(i, 0).toString();
            String maSP = model.getValueAt(i, 1).toString();
            String tenNCC = model.getValueAt(i, 2).toString();
            String maNCC = ncc_bus.layMaNhaCungCapTheoTen(tenNCC);
            NhaCungCapEntity ncc = new NhaCungCapEntity(maNCC);
            SanPhamEntity sp = new SanPhamEntity(maSP);
            int soLuongNhapMoi = Integer.parseInt(model.getValueAt(i, 3).toString());
            int soLuongNhapBanDau = laySoLuongNhapBanDau(maMHN);
            int soLuongHT = sp_bus.laySoLuongTonKhoTheoMaSP(maSP);
            int soLuongThayDoi = soLuongNhapBanDau - soLuongNhapMoi;
            int soLuongMoiCapNhat = soLuongHT - soLuongThayDoi;
            LocalDate ngayNhap = (LocalDate) model.getValueAt(i, 4);
            MatHangNhapEntity mhn = new MatHangNhapEntity(maMHN, ncc, sp, soLuongNhapMoi, ngayNhap);
            if (!mhn_bus.kiemTraMaMatHangNhapTonTai(maMHN)) {
                mhn_bus.nhapHang(mhn);
                int soLuongHienTai = sp_bus.laySoLuongTonKhoTheoMaSP(maSP);
                int soLuongMoi = soLuongHienTai + soLuongNhapMoi;
                sp_bus.capNhatSoLuong(maSP, soLuongMoi);
            } else {
                mhn_bus.capNhapMatHangNhap(mhn);
                sp_bus.capNhatSoLuong(maSP, soLuongMoiCapNhat);
            }
        }
        JOptionPane.showMessageDialog(null, "Lưu thành công");
    }

    //Hàm nhập file excel
    private void nhapExcel() {
        File excelFile;
        FileInputStream excelFIS = null;
        BufferedInputStream excelBIS = null;
        XSSFWorkbook excelImportToJTable = null;
        String defaultCurrentDirectoryPath = "C:\\Users\\MY PC\\OneDrive\\Máy tính";
        JFileChooser excelFileChooser = new JFileChooser(defaultCurrentDirectoryPath);
        excelFileChooser.setDialogTitle("Chọn file excel");
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILES", "xls", "xlsx", "xlsm");
        excelFileChooser.setFileFilter(fnef);
        int excelChooser = excelFileChooser.showOpenDialog(null);
        if (excelChooser == JFileChooser.APPROVE_OPTION) {
//            Set<Object> maMHNSet = new HashSet<>();
            try {
                excelFile = excelFileChooser.getSelectedFile();
                excelFIS = new FileInputStream(excelFile);
                excelBIS = new BufferedInputStream(excelFIS);
                excelImportToJTable = new XSSFWorkbook(excelBIS);
                XSSFSheet excelSheet = excelImportToJTable.getSheetAt(0);
                DateTimeFormatter formatterExcel = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                DateTimeFormatter formatterTable = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                for (int row = 1; row < excelSheet.getPhysicalNumberOfRows(); row++) {
                    XSSFRow excelRow = excelSheet.getRow(row);
                    XSSFCell excelMaMHN = excelRow.getCell(0);
                    // Kiểm tra xem mã mặt hàng nhập đã tồn tại trong tập hợp chưa
                    String maMHN = excelMaMHN.getStringCellValue().trim();
                    int existingRow = -1;
                    // Kiểm tra xem mã mặt hàng nhập đã tồn tại trong bảng chưa
                    for (int i = 0; i < model.getRowCount(); i++) {
                        if (maMHN.equals(model.getValueAt(i, 0).toString())) {
                            existingRow = i;
                            break;
                        }
                    }

                    XSSFCell excelTenNCC = excelRow.getCell(1);
                    XSSFCell excelMaSP = excelRow.getCell(2);
                    XSSFCell excelSoLuongNhap = excelRow.getCell(3);
                    XSSFCell excelNgayNhap = excelRow.getCell(4);
                    int soLuongNhap = (int) excelSoLuongNhap.getNumericCellValue();
                    String ngayNhapString = "";
                    if (excelNgayNhap.getCellType() == CellType.STRING) {
                        // Nếu kiểu dữ liệu của cell là String
                        ngayNhapString = excelNgayNhap.getStringCellValue();
                        LocalDate ngayNhap = LocalDate.parse(ngayNhapString, formatterExcel);
                        ngayNhapString = ngayNhap.format(formatterTable);
                    } else if (DateUtil.isCellDateFormatted(excelNgayNhap)) {
                        // Nếu kiểu dữ liệu của cell là ngày
                        Date ngayNhapDate = excelNgayNhap.getDateCellValue();
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        ngayNhapString = sdf.format(ngayNhapDate);
                    }
                    LocalDate ngayNhap = LocalDate.parse(ngayNhapString);

                    if (existingRow != -1) {
                        //Mã mặt hàng đã tồn tại, cập nhật các giá trị
                        model.setValueAt(excelMaSP.getStringCellValue(), existingRow, 1);
                        model.setValueAt(excelTenNCC.getStringCellValue(), existingRow, 2);
                        model.setValueAt(soLuongNhap, existingRow, 3);
                        model.setValueAt(ngayNhap, existingRow, 4);
                    } else {
                        //Mã mặt hàng chưa tồn tại, thêm vào table
//                        maMHNSet.add(maMHN);
                        model.addRow(new Object[]{maMHN, excelMaSP, excelTenNCC, soLuongNhap, ngayNhap});
                    }
                }
                JOptionPane.showMessageDialog(null, "Nhập thành công");
            } catch (IOException iOException) {
                JOptionPane.showMessageDialog(null, iOException.getMessage());
            } finally {
                try {
                    if (excelFIS != null) {
                        excelFIS.close();
                    }
                    if (excelBIS != null) {
                        excelBIS.close();
                    }
                    if (excelImportToJTable != null) {
                        excelImportToJTable.close();
                    }
                } catch (IOException iOException) {
                    JOptionPane.showMessageDialog(null, iOException.getMessage());
                }
            }
        }
    }
    //Hàm kiểm tra mã sản phẩm đã có trong table hay chưa

    private boolean kiemTraMaMHNTontaiTrongTable(DefaultTableModel model, String maMHN) {
        for (int row = 0; row < model.getRowCount(); row++) {
            if (model.getValueAt(row, 0).equals(maMHN)) {
                return true;
            }
        }
        return false;
    }

    //Hàm xuất excel
    private void xuatExcel() {
        try {
            JFileChooser fileChooser = new JFileChooser("C:\\Users\\MY PC\\OneDrive\\Máy tính");
            fileChooser.setDialogTitle("Chọn nơi lưu file");
            int chon = fileChooser.showSaveDialog(null);
            if (chon == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                String filePath = selectedFile.getAbsolutePath();
                if (!filePath.toLowerCase().endsWith(".xlsx")) {
                    filePath += ".xlsx";
                }
                XSSFWorkbook workbook = new XSSFWorkbook();
                XSSFSheet sheet = workbook.createSheet("Danh sách phiếu nhập hàng");

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                XSSFRow row = null;
                Cell cell = null;
                row = sheet.createRow(0);
                cell = row.createCell(0, CellType.STRING);
                cell.setCellValue("Mã mặt hàng nhập");
                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue("Nhà cung cấp");
                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue("Mã sản phẩm");
                cell = row.createCell(3, CellType.STRING);
                cell.setCellValue("Số lượng nhập");
                cell = row.createCell(4, CellType.STRING);
                cell.setCellValue("Ngày nhập");
                ArrayList<MatHangNhapEntity> listItem = mhn_bus.getAllMatHangNhap();
                for (int i = 0; i < listItem.size(); i++) {
                    MatHangNhapEntity mhn = listItem.get(i);
                    String tenNCC = ncc_bus.layTenNhaCungCapTheoMa(mhn.getNhaCungCap().getMaNCC());
                    row = sheet.createRow(1 + i);
                    row.createCell(0).setCellValue(mhn.getMaMHN());
                    row.createCell(1).setCellValue(tenNCC);
                    row.createCell(2).setCellValue(mhn.getSanPham().getMaSP());
                    row.createCell(3).setCellValue(mhn.getSoLuongNhap());
                    row.createCell(4).setCellValue(mhn.getNgayNhap().format(formatter));
                }
                File f = new File(filePath);
                try (FileOutputStream fos = new FileOutputStream(f)) {
                    workbook.write(fos);
                    JOptionPane.showMessageDialog(null, "Xuất file thành công");
                    openExcelFile(f);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //Hàm tự dộng mở file excel sau khi xuất
    private static void openExcelFile(File file) throws IOException {
        Desktop desktop = Desktop.getDesktop();
        if (desktop.isSupported(Desktop.Action.OPEN)) {
            desktop.open(file);
        } else {
            System.out.println("Không thể mở file.");
        }
    }

    //Hàm lấy số lượng tồn kho của sản phẩm nhập ban đầu
    public int laySoLuongNhapBanDau(String maMHN) {
        ArrayList<MatHangNhapEntity> dsMHN = mhn_bus.getAllMatHangNhap();
        for (MatHangNhapEntity mhn : dsMHN) {
            if (mhn.getMaMHN().equals(maMHN)) {
                return mhn.getSoLuongNhap();
            }
        }
        return -1;
    }

    //Hàm kiểm tra regex
    private boolean validata() {
        String maSP = txt_MaSanPham.getText().trim();
        ArrayList<SanPhamEntity> ketQuaTimKiem = sp_bus.timSanPham(maSP);
        if (maSP.isBlank()) {
            JOptionPane.showMessageDialog(null, "Mã sản phẩm không được để trống");
            txt_MaSanPham.requestFocus();
            txt_MaSanPham.selectAll();
            return false;
        }
        if (!maSP.matches("^SP\\d{12}$")) {
            JOptionPane.showMessageDialog(null, "Mã sản phẩm không đúng định dạng");
            txt_MaSanPham.requestFocus();
            txt_MaSanPham.selectAll();
            return false;
        }
        if (ketQuaTimKiem.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Mã sản phẩm không tồn tại");
            txt_MaSanPham.requestFocus();
            txt_MaSanPham.selectAll();
            return false;
        }
        int soLuongNhap = (int) spinner_SoLuong.getValue();
        if (soLuongNhap <= 0) {
            JOptionPane.showMessageDialog(null, "Số lượng nhập phải lớn hơn 0");
            spinner_SoLuong.requestFocus();
            return false;
        }
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_CapNhat;
    private javax.swing.JButton btn_LamMoi;
    private javax.swing.JButton btn_Luu;
    private javax.swing.JButton btn_NhapExcel;
    private javax.swing.JButton btn_NhapHang;
    private javax.swing.JButton btn_TimKiem;
    private javax.swing.JButton btn_XuatExcel;
    private javax.swing.JComboBox<String> cbo_MaNhaCungCap;
    private com.toedter.calendar.JDateChooser jdc_NgayNhap;
    private com.toedter.calendar.JDateChooser jdc_NgayNhap_Search;
    private javax.swing.JLabel lbl_MaMatHangNhap;
    private javax.swing.JLabel lbl_MaNhaCungCap;
    private javax.swing.JLabel lbl_MaSanPham;
    private javax.swing.JLabel lbl_NgayNhap;
    private javax.swing.JLabel lbl_NgayNhap_Search;
    private javax.swing.JLabel lbl_SoLuong;
    private javax.swing.JLabel lbl_TieuDe;
    private javax.swing.JPanel panel_DanhSachPhieuNhapHang;
    private javax.swing.JPanel panel_ThaoTac;
    private javax.swing.JPanel panel_ThongTin;
    private javax.swing.JScrollPane scroll_TablePhieuNhapHang;
    private javax.swing.JSpinner spinner_SoLuong;
    private javax.swing.JTable table_PhieuNhapHang;
    private DefaultTableModel model;
    private javax.swing.JTextField txt_An;
    private javax.swing.JTextField txt_MaMatHangNhap;
    private javax.swing.JTextField txt_MaSanPham;
    // End of variables declaration//GEN-END:variables
}
