package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import bus.ChatLieu_bus;
import bus.ChuongTrinhKhuyenMai_bus;
import bus.DanhMucSanPham_bus;
import entity.SanPhamEntity;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
import bus.SanPham_bus;
import bus.ThuongHieu_bus;
import entity.ChatLieuEntity;
import entity.ChuongTrinhKhuyenMaiEntity;
import entity.DanhMucSanPhamEntity;
import entity.KichThuocEnum;
import entity.MauSacEnum;
import entity.ThuongHieuEntity;
import entity.TinhTrangSPEnum;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Font;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.CodeSource;
import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jdesktop.layout.GroupLayout;
import org.jdesktop.layout.LayoutStyle;
import util.GenerateID;

/**
 *
 * @author 84335
 */
public class SanPham_JPanel extends javax.swing.JPanel {

    private String duongDanAnhMacDinh = "/pic/icon/labelAnh.png";
    private String duongDanAnh = null;
    private SanPham_bus sp_bus;
    private DanhMucSanPham_bus danhMucSanPham_bus;
    private ThuongHieu_bus thuongHieu_bus;
    private ChatLieu_bus chatLieu_bus;
    private ChuongTrinhKhuyenMai_bus ctkm_bus;
    
    DefaultTableModel model;

    /**
     * Creates new form SanPham_JPanel
     */
    public SanPham_JPanel() {
        initComponents();
        //Khởi tạo
        sp_bus = new SanPham_bus();
        danhMucSanPham_bus = new DanhMucSanPham_bus();
        thuongHieu_bus = new ThuongHieu_bus();
        chatLieu_bus = new ChatLieu_bus();
        ctkm_bus = new ChuongTrinhKhuyenMai_bus();
        //----------
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

        URL urlBtnThem = getClass().getResource("/pic/icon/buttonThem.png");
        ImageIcon img_btnThem = new ImageIcon(urlBtnThem);
        Image scaled_btnThem = img_btnThem.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        img_btnThem = new ImageIcon(scaled_btnThem);
        btn_Them.setIcon(img_btnThem);

        URL urlBtnCapNhat = getClass().getResource("/pic/icon/buttonCapNhat.png");
        ImageIcon img_btnCapNhat = new ImageIcon(urlBtnCapNhat);
        Image scaled_btnCapNhat = img_btnCapNhat.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        img_btnCapNhat = new ImageIcon(scaled_btnCapNhat);
        btn_CapNhat.setIcon(img_btnCapNhat);

        URL urlBtnKiemTraTonKho = getClass().getResource("/pic/icon/buttonKiemTraTonKho.png");
        ImageIcon img_btnKiemTraTonKho = new ImageIcon(urlBtnKiemTraTonKho);
        Image scaled_btnKiemTraTonKho = img_btnKiemTraTonKho.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        img_btnKiemTraTonKho = new ImageIcon(scaled_btnKiemTraTonKho);
        btn_KiemTraTonKho.setIcon(img_btnKiemTraTonKho);

        URL urlBtnChonAnh = getClass().getResource("/pic/icon/buttonChonAnh.png");
        ImageIcon img_btnChonAnh = new ImageIcon(urlBtnChonAnh);
        Image scaled_btnChonAnh = img_btnChonAnh.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        img_btnChonAnh = new ImageIcon(scaled_btnChonAnh);
        btn_ChonAnh.setIcon(img_btnChonAnh);

        URL urlAnhSanPham = getClass().getResource("/pic/icon/labelAnh.png");
        ImageIcon img_lblAnh = new ImageIcon(urlAnhSanPham);
        Image scaled_lblAnh = img_lblAnh.getImage().getScaledInstance(150, 140, Image.SCALE_SMOOTH);
        img_lblAnh = new ImageIcon(scaled_lblAnh);
        lbl_AnhSanPham.setIcon(img_lblAnh);

        URL urlBtnNhapExcel = getClass().getResource("/pic/icon/buttonNhapExcel.png");
        ImageIcon img_btnNhapExcel = new ImageIcon(urlBtnNhapExcel);
        Image scaled_btnNhapExcel = img_btnNhapExcel.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        img_btnNhapExcel = new ImageIcon(scaled_btnNhapExcel);
        btn_NhapExcel.setIcon(img_btnNhapExcel);

        URL urlBtnXuatExcel = getClass().getResource("/pic/icon/buttonXuatExcel.png");
        ImageIcon img_btnXuatExcel = new ImageIcon(urlBtnXuatExcel);
        Image scaled_btnXuatExcel = img_btnXuatExcel.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        img_btnXuatExcel = new ImageIcon(scaled_btnXuatExcel);
        btn_XuatExcel.setIcon(img_btnXuatExcel);

        URL urlBtnLuu = getClass().getResource("/pic/icon/buttonLuu.png");
        ImageIcon img_btnLuu = new ImageIcon(urlBtnLuu);
        Image scaled_btnLuu = img_btnLuu.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        img_btnLuu = new ImageIcon(scaled_btnLuu);
        btn_Luu.setIcon(img_btnLuu);

        loadDuLieuTuDataLenTable();
        duaDuLieuVaoComboBox(cbo_DanhMuc, danhMucSanPham_bus.getAllDMSP(), "TenDanhMuc");
        duaDuLieuVaoComboBox(cbo_ChatLieu, chatLieu_bus.getAllCL(), "TenChatLieu");
        duaDuLieuVaoComboBox(cbo_ThuongHieu, thuongHieu_bus.getAllTH(), "TenThuongHieu");
        duaDuLieuVaoComboBox(cbo_KhuyenMai, ctkm_bus.getAllCTKMTheoLoaiKMVaTinhTrang("GGSP", "Còn"), "TenCTKM");
        cbo_KhuyenMai.addItem("Không giảm giá");
        cbo_KhuyenMai.setSelectedItem("Không giảm giá");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_ThongTin = new javax.swing.JPanel();
        lbl_MaSanPham = new javax.swing.JLabel();
        lbl_TenSanPham = new javax.swing.JLabel();
        txt_MaSanPham = new javax.swing.JTextField();
        txt_TenSanPham = new javax.swing.JTextField();
        lbl_ThuongHieu = new javax.swing.JLabel();
        lbl_SoLuongTonKho = new javax.swing.JLabel();
        txt_SoLuongTonKho = new javax.swing.JTextField();
        lbl_DanhMuc = new javax.swing.JLabel();
        cbo_DanhMuc = new javax.swing.JComboBox<>();
        lbl_KichThuoc = new javax.swing.JLabel();
        cbo_KichThuoc = new javax.swing.JComboBox<>();
        lbl_ChatLieu = new javax.swing.JLabel();
        lbl_MauSac = new javax.swing.JLabel();
        cbo_MauSac = new javax.swing.JComboBox<>();
        lbl_TinhTrang = new javax.swing.JLabel();
        cbo_TinhTrang = new javax.swing.JComboBox<>();
        lbl_DonGia = new javax.swing.JLabel();
        txt_DonGia = new javax.swing.JTextField();
        lbl_AnhSanPham = new javax.swing.JLabel();
        btn_ChonAnh = new javax.swing.JButton();
        cbo_ChatLieu = new javax.swing.JComboBox<>();
        cbo_ThuongHieu = new javax.swing.JComboBox<>();
        lbl_KhuyenMai = new javax.swing.JLabel();
        cbo_KhuyenMai = new javax.swing.JComboBox<>();
        panel_ThaoTac = new javax.swing.JPanel();
        lbl_MaSanPham_Search = new javax.swing.JLabel();
        btn_TimKiem = new javax.swing.JButton();
        btn_LamMoi = new javax.swing.JButton();
        btn_Them = new javax.swing.JButton();
        btn_CapNhat = new javax.swing.JButton();
        txt_MaSanPham_Search = new javax.swing.JTextField();
        btn_XuatExcel = new javax.swing.JButton();
        btn_KiemTraTonKho = new javax.swing.JButton();
        btn_NhapExcel = new javax.swing.JButton();
        btn_Luu = new javax.swing.JButton();
        panel_DanhSachSanPham = new javax.swing.JPanel();
        scroll_TableSanPham = new javax.swing.JScrollPane();
        Object[][] data={};
        String[] columnNames={"Mã","Tên sản phẩm", "Kích thước", "Màu sắc", "Đơn giá", "Tình trạng", "Số lượng", "Chất liệu", "Thương hiệu", "Danh mục", "Khuyến mãi", "Ảnh"};
        model=new DefaultTableModel(data, columnNames){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        table_DanhSachSanPham = new javax.swing.JTable();
        lbl_TieuDe = new javax.swing.JLabel();

        setBackground(new java.awt.Color(187, 205, 197));
        setPreferredSize(new java.awt.Dimension(1186, 748));

        panel_ThongTin.setBackground(new java.awt.Color(187, 205, 197));
        panel_ThongTin.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Thông tin sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 12))); // NOI18N
        panel_ThongTin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_MaSanPham.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lbl_MaSanPham.setText("Mã sản phẩm");
        lbl_MaSanPham.setPreferredSize(new java.awt.Dimension(85, 15));
        panel_ThongTin.add(lbl_MaSanPham, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 22, 100, 25));

        lbl_TenSanPham.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lbl_TenSanPham.setText("Tên sản phẩm");
        lbl_TenSanPham.setPreferredSize(new java.awt.Dimension(85, 15));
        panel_ThongTin.add(lbl_TenSanPham, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 100, 25));

        txt_MaSanPham.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_MaSanPham.setEditable(false);
        panel_ThongTin.add(txt_MaSanPham, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 200, 30));

        txt_TenSanPham.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        panel_ThongTin.add(txt_TenSanPham, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 200, 30));

        lbl_ThuongHieu.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lbl_ThuongHieu.setText("Thương hiệu");
        lbl_ThuongHieu.setPreferredSize(new java.awt.Dimension(85, 15));
        panel_ThongTin.add(lbl_ThuongHieu, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 70, -1, 25));

        lbl_SoLuongTonKho.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lbl_SoLuongTonKho.setText("Số lượng tồn kho");
        lbl_SoLuongTonKho.setMaximumSize(new java.awt.Dimension(82, 15));
        lbl_SoLuongTonKho.setMinimumSize(new java.awt.Dimension(82, 15));
        lbl_SoLuongTonKho.setPreferredSize(new java.awt.Dimension(85, 15));
        panel_ThongTin.add(lbl_SoLuongTonKho, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, 117, 25));

        txt_SoLuongTonKho.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_SoLuongTonKho.setText("0");
        txt_SoLuongTonKho.setEditable(false);
        panel_ThongTin.add(txt_SoLuongTonKho, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, 200, 30));

        lbl_DanhMuc.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lbl_DanhMuc.setText("Danh mục");
        lbl_DanhMuc.setPreferredSize(new java.awt.Dimension(85, 15));
        panel_ThongTin.add(lbl_DanhMuc, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 70, 117, 25));

        cbo_DanhMuc.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        panel_ThongTin.add(cbo_DanhMuc, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 70, 200, 30));

        lbl_KichThuoc.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lbl_KichThuoc.setText("Kích thước");
        lbl_KichThuoc.setPreferredSize(new java.awt.Dimension(85, 15));
        panel_ThongTin.add(lbl_KichThuoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 90, 25));

        cbo_KichThuoc.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cbo_KichThuoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "XS", "S", "M", "L", "XL", "XXL", "FREESIZE" }));
        cbo_KichThuoc.setSelectedIndex(1);
        cbo_KichThuoc.setSelectedItem("S");
        panel_ThongTin.add(cbo_KichThuoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 200, 30));

        lbl_ChatLieu.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lbl_ChatLieu.setText("Chất liệu");
        lbl_ChatLieu.setPreferredSize(new java.awt.Dimension(85, 15));
        panel_ThongTin.add(lbl_ChatLieu, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 20, 68, 25));

        lbl_MauSac.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lbl_MauSac.setText("Màu sắc");
        lbl_MauSac.setPreferredSize(new java.awt.Dimension(85, 15));
        panel_ThongTin.add(lbl_MauSac, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 90, 25));

        cbo_MauSac.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cbo_MauSac.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Trắng", "Đen", "Xám" }));
        cbo_MauSac.setSelectedItem("Trắng");
        panel_ThongTin.add(cbo_MauSac, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 200, 30));

        lbl_TinhTrang.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lbl_TinhTrang.setText("Tình trạng");
        lbl_TinhTrang.setPreferredSize(new java.awt.Dimension(85, 15));
        panel_ThongTin.add(lbl_TinhTrang, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 120, 117, 25));

        cbo_TinhTrang.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cbo_TinhTrang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hết hàng", "Ngừng bán", "Đang bán" }));
        cbo_TinhTrang.setSelectedItem("Hết hàng");
        panel_ThongTin.add(cbo_TinhTrang, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 120, 200, 30));

        lbl_DonGia.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lbl_DonGia.setText("Đơn giá");
        lbl_DonGia.setMaximumSize(new java.awt.Dimension(82, 15));
        lbl_DonGia.setMinimumSize(new java.awt.Dimension(82, 15));
        lbl_DonGia.setPreferredSize(new java.awt.Dimension(85, 15));
        panel_ThongTin.add(lbl_DonGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 170, 69, 25));

        txt_DonGia.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        panel_ThongTin.add(txt_DonGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 170, 200, 30));

        lbl_AnhSanPham.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panel_ThongTin.add(lbl_AnhSanPham, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 20, 150, 140));

        btn_ChonAnh.setBackground(new java.awt.Color(0, 51, 51));
        btn_ChonAnh.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        btn_ChonAnh.setForeground(java.awt.Color.white);
        btn_ChonAnh.setText("Chọn ảnh");
        btn_ChonAnh.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btn_ChonAnh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ChonAnhActionPerformed(evt);
            }
        });
        panel_ThongTin.add(btn_ChonAnh, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 170, 120, 30));

        cbo_ChatLieu.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        panel_ThongTin.add(cbo_ChatLieu, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 20, 200, 30));

        cbo_ThuongHieu.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        panel_ThongTin.add(cbo_ThuongHieu, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 70, 200, 30));

        lbl_KhuyenMai.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lbl_KhuyenMai.setText("Khuyến mãi");
        panel_ThongTin.add(lbl_KhuyenMai, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 120, -1, 25));

        cbo_KhuyenMai.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        panel_ThongTin.add(cbo_KhuyenMai, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 120, 200, 30));

        panel_ThaoTac.setBackground(new java.awt.Color(187, 205, 197));
        panel_ThaoTac.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Các thao tác", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 12))); // NOI18N
        panel_ThaoTac.setPreferredSize(new java.awt.Dimension(932, 60));

        lbl_MaSanPham_Search.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lbl_MaSanPham_Search.setText("Điều kiện tìm");

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

        btn_Them.setBackground(new java.awt.Color(0, 51, 51));
        btn_Them.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        btn_Them.setForeground(java.awt.Color.white);
        btn_Them.setText("Thêm");
        btn_Them.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Them.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btn_Them.setPreferredSize(new java.awt.Dimension(90, 31));
        btn_Them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemActionPerformed(evt);
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

        txt_MaSanPham_Search.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        btn_XuatExcel.setBackground(new java.awt.Color(0, 51, 51));
        btn_XuatExcel.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        btn_XuatExcel.setForeground(java.awt.Color.white);
        btn_XuatExcel.setText("Xuất");
        btn_XuatExcel.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btn_XuatExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XuatExcelActionPerformed(evt);
            }
        });

        btn_KiemTraTonKho.setBackground(new java.awt.Color(0, 51, 51));
        btn_KiemTraTonKho.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        btn_KiemTraTonKho.setForeground(java.awt.Color.white);
        btn_KiemTraTonKho.setText("Check tồn kho");
        btn_KiemTraTonKho.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btn_KiemTraTonKho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_KiemTraTonKhoActionPerformed(evt);
            }
        });

        btn_NhapExcel.setBackground(new java.awt.Color(0, 51, 51));
        btn_NhapExcel.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        btn_NhapExcel.setForeground(java.awt.Color.white);
        btn_NhapExcel.setText("Nhập");
        btn_NhapExcel.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btn_NhapExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_NhapExcelActionPerformed(evt);
            }
        });

        btn_Luu.setBackground(new java.awt.Color(0, 51, 51));
        btn_Luu.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        btn_Luu.setForeground(java.awt.Color.white);
        btn_Luu.setText("Lưu");
        btn_Luu.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
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
                .addComponent(lbl_MaSanPham_Search)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txt_MaSanPham_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_LamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_Them, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_CapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_KiemTraTonKho)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_NhapExcel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_XuatExcel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_Luu)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_ThaoTacLayout.setVerticalGroup(
            panel_ThaoTacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_ThaoTacLayout.createSequentialGroup()
                .addGroup(panel_ThaoTacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_ThaoTacLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(lbl_MaSanPham_Search))
                    .addGroup(panel_ThaoTacLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(panel_ThaoTacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_NhapExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_XuatExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_KiemTraTonKho, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_CapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_Them, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_LamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_Luu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_MaSanPham_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(8, 8, 8))
        );

        panel_DanhSachSanPham.setBackground(new java.awt.Color(187, 205, 197));
        panel_DanhSachSanPham.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Bảng danh sách sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 12))); // NOI18N
        panel_DanhSachSanPham.setPreferredSize(new java.awt.Dimension(1008, 317));

        JTableHeader tableHeader=table_DanhSachSanPham.getTableHeader();
        tableHeader.setFont(new Font("Times New Roman", Font.BOLD, 13));
        table_DanhSachSanPham.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        table_DanhSachSanPham.setModel(model);
        table_DanhSachSanPham.getColumnModel().getColumn(0).setPreferredWidth(100);
        table_DanhSachSanPham.getColumnModel().getColumn(1).setPreferredWidth(200);
        table_DanhSachSanPham.getColumnModel().getColumn(2).setCellRenderer(new CenterRenderer());
        table_DanhSachSanPham.getColumnModel().getColumn(3).setCellRenderer(new CenterRenderer());
        table_DanhSachSanPham.getColumnModel().getColumn(11).setMinWidth(0);
        table_DanhSachSanPham.getColumnModel().getColumn(11).setMaxWidth(0);
        table_DanhSachSanPham.getColumnModel().getColumn(11).setWidth(0);
        table_DanhSachSanPham.getColumnModel().getColumn(11).setPreferredWidth(0);
        table_DanhSachSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_DanhSachSanPhamMouseClicked(evt);
            }
        });
        scroll_TableSanPham.setViewportView(table_DanhSachSanPham);

        javax.swing.GroupLayout panel_DanhSachSanPhamLayout = new javax.swing.GroupLayout(panel_DanhSachSanPham);
        panel_DanhSachSanPham.setLayout(panel_DanhSachSanPhamLayout);
        panel_DanhSachSanPhamLayout.setHorizontalGroup(
            panel_DanhSachSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scroll_TableSanPham)
        );
        panel_DanhSachSanPhamLayout.setVerticalGroup(
            panel_DanhSachSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scroll_TableSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
        );

        lbl_TieuDe.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lbl_TieuDe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_TieuDe.setText("QUẢN LÝ SẢN PHẨM");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_TieuDe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_ThaoTac, javax.swing.GroupLayout.DEFAULT_SIZE, 1176, Short.MAX_VALUE)
                    .addComponent(panel_ThongTin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1176, Short.MAX_VALUE)
                    .addComponent(panel_DanhSachSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, 1176, Short.MAX_VALUE))
                .addGap(5, 5, 5))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_TieuDe, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_ThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_ThaoTac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_DanhSachSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    //Hàm load dữ liệu từ db lên table
    private void loadDuLieuTuDataLenTable() {
        sp_bus.capNhatKhuyenMai();
        ArrayList<SanPhamEntity> dsSanPham = sp_bus.getAllSanPham();
        DecimalFormat decimalFormat = new DecimalFormat();
        for (SanPhamEntity sp : dsSanPham) {

            String formattedDonGia = decimalFormat.format(sp.getDonGia()) + " VNĐ";
            String tenChatLieu = chatLieu_bus.layTenChatLieuTheoMa(sp.getChatLieu().getMaChatLieu());
            String tenThuongHieu = thuongHieu_bus.layTenThuongHieuTheoMa(sp.getThuongHieu().getMaThuongHieu());
            String tenDanhMuc = danhMucSanPham_bus.layTenDanhMucTheoMa(sp.getDanhMucSanPham().getMaDanhMuc());
            String tenCTKM = ctkm_bus.layTenKhuyenMaiTheoMa(sp.getChuongTrinhKhuyenMai().getMaCTKM());
            String hienThiKM = null;
            if (tenCTKM != null) {
                hienThiKM = tenCTKM;
            } else {
                hienThiKM = "Không giảm giá";
            }

            model.addRow(new Object[]{sp.getMaSP(), sp.getTenSP(), sp.getKichThuoc(),
                sp.getMauSac().toString(), formattedDonGia, sp.getTinhTrang().toString(),
                sp.getSoLuongTonKho(), tenChatLieu, tenThuongHieu, tenDanhMuc,
                hienThiKM, sp.getImgUrl()});
        }
    }

    private ImageIcon ResizeImageIcon(String duongDanAnh) throws IOException {
        URL url = getClass().getResource(duongDanAnh);
        if (url == null) {
            throw new IOException("Resource not found: " + duongDanAnh);
        }
        Image img = ImageIO.read(url);
        Image scaledImg = img.getScaledInstance(lbl_AnhSanPham.getWidth(), lbl_AnhSanPham.getHeight(), Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImg);
    }

    private void btn_ChonAnhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ChonAnhActionPerformed
        JFileChooser fileChooser = new JFileChooser("src/pic/imageProduct");
        FileNameExtensionFilter imageFilter = new FileNameExtensionFilter("Image files", "jpg", "jpeg", "png", "gif");
        fileChooser.setFileFilter(imageFilter);
        fileChooser.setDialogTitle("Mở file");
        int kq = fileChooser.showOpenDialog(null);
        if (kq == JFileChooser.APPROVE_OPTION) {
            try {
                File tenAnh = fileChooser.getSelectedFile();
                String tenTepAnh = tenAnh.getName();
                duongDanAnh = "/pic/imageProduct/" + tenTepAnh;
                lbl_AnhSanPham.setIcon(ResizeImageIcon(duongDanAnh));
                lbl_AnhSanPham.setText(duongDanAnh);
            } catch (IOException ex) {
                Logger.getLogger(SanPham_JPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (kq == JFileChooser.CANCEL_OPTION) {

        } else {
            JOptionPane.showMessageDialog(null, "Lỗi chọn ảnh");
        }

    }//GEN-LAST:event_btn_ChonAnhActionPerformed

    private void btn_ThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemActionPerformed
        // TODO add your handling code here:
        themSanPham();
    }//GEN-LAST:event_btn_ThemActionPerformed

    //Hàm thêm sản phẩm
    private void themSanPham() {
        if (validata()) {
            String maSP = GenerateID.sinhMa("SP");
            String tenSanPham = txt_TenSanPham.getText();
            KichThuocEnum kichThuoc = null;
            if (cbo_KichThuoc.getSelectedItem().equals("XS")) {
                kichThuoc = KichThuocEnum.XS;
            } else if (cbo_KichThuoc.getSelectedItem().equals("S")) {
                kichThuoc = KichThuocEnum.S;
            } else if (cbo_KichThuoc.getSelectedItem().equals("M")) {
                kichThuoc = KichThuocEnum.M;
            } else if (cbo_KichThuoc.getSelectedItem().equals("L")) {
                kichThuoc = KichThuocEnum.L;
            } else if (cbo_KichThuoc.getSelectedItem().equals("XL")) {
                kichThuoc = KichThuocEnum.XL;
            } else if (cbo_KichThuoc.getSelectedItem().equals("XXL")) {
                kichThuoc = KichThuocEnum.XXL;
            } else if (cbo_KichThuoc.getSelectedItem().equals("FREESIZE")) {
                kichThuoc = KichThuocEnum.FREESIZE;
            }
            MauSacEnum mauSac = null;
            if (cbo_MauSac.getSelectedItem().equals("Trắng")) {
                mauSac = MauSacEnum.TRANG;
            } else if (cbo_MauSac.getSelectedItem().equals("Đen")) {
                mauSac = MauSacEnum.DEN;
            } else if (cbo_MauSac.getSelectedItem().equals("Xám")) {
                mauSac = MauSacEnum.XAM;
            }
            double donGia = Double.parseDouble(txt_DonGia.getText());
            int soLuongTonKho = Integer.parseInt(txt_SoLuongTonKho.getText());
            TinhTrangSPEnum tinhTrang = null;
            if (cbo_TinhTrang.getSelectedItem().equals("Đang bán")) {
                tinhTrang = TinhTrangSPEnum.DANGBAN;
            } else if (cbo_TinhTrang.getSelectedItem().equals("Ngừng bán")) {
                tinhTrang = TinhTrangSPEnum.NGUNGBAN;
            } else if (cbo_TinhTrang.getSelectedItem().equals("Hết hàng")) {
                tinhTrang = TinhTrangSPEnum.HETHANG;
            }
            if (soLuongTonKho > 0) {
                tinhTrang = TinhTrangSPEnum.DANGBAN;
            } else {
                tinhTrang = TinhTrangSPEnum.HETHANG;
            }
            String tenChatLieu = cbo_ChatLieu.getSelectedItem().toString();
            String maChatLieu = chatLieu_bus.layMaChatLieuTheoTen(tenChatLieu);
            ChatLieuEntity chatLieu = new ChatLieuEntity(maChatLieu);
            String tenThuongHieu = cbo_ThuongHieu.getSelectedItem().toString();
            String maThuongHieu = thuongHieu_bus.layMaThuongHieuTheoTen(tenThuongHieu);
            ThuongHieuEntity thuongHieu = new ThuongHieuEntity(maThuongHieu);
            String tenDanhMuc = cbo_DanhMuc.getSelectedItem().toString();
            String maDanhMuc = danhMucSanPham_bus.layMaDanhMucTheoTen(tenDanhMuc);
            DanhMucSanPhamEntity danhMuc = new DanhMucSanPhamEntity(maDanhMuc);
            String tenCTKM = cbo_KhuyenMai.getSelectedItem().toString();
            String maCTKM = ctkm_bus.layMaKhuyenMaiTheoTen(tenCTKM);
            ChuongTrinhKhuyenMaiEntity ctkm = new ChuongTrinhKhuyenMaiEntity(maCTKM);
            String anh = duongDanAnh;
            if (anh == null || anh.equals(duongDanAnhMacDinh)) {
                JOptionPane.showMessageDialog(null, "Vui lòng chọn ảnh");
            } else {
                SanPhamEntity sp = new SanPhamEntity(maSP, tenSanPham, kichThuoc, mauSac, donGia, soLuongTonKho, tinhTrang, chatLieu, thuongHieu, danhMuc, ctkm, anh);
                boolean kiemTra = sp_bus.themSP(sp);
                if (kiemTra) {
                    DecimalFormat decimalFormat = new DecimalFormat();
                    String formattedDonGia = decimalFormat.format(sp.getDonGia()) + " VNĐ";
                    String cl = chatLieu_bus.layTenChatLieuTheoMa(sp.getChatLieu().getMaChatLieu());
                    String th = thuongHieu_bus.layTenThuongHieuTheoMa(sp.getThuongHieu().getMaThuongHieu());
                    String dm = danhMucSanPham_bus.layTenDanhMucTheoMa(sp.getDanhMucSanPham().getMaDanhMuc());
                    String km = ctkm_bus.layTenKhuyenMaiTheoMa(sp.getChuongTrinhKhuyenMai().getMaCTKM());
                    String hienThiKM = null;
                    if (km != null) {
                        hienThiKM = km;
                    } else {
                        hienThiKM = "Không giảm giá";
                    }
                    model.addRow(new Object[]{sp.getMaSP(), sp.getTenSP(), sp.getKichThuoc(),
                        sp.getMauSac().toString(), formattedDonGia, sp.getTinhTrang().toString(),
                        sp.getSoLuongTonKho(), cl, th, dm,
                        hienThiKM, sp.getImgUrl()});
                    JOptionPane.showMessageDialog(null, "Thêm thành công");
                    lamMoi();
                } else {
                    JOptionPane.showMessageDialog(null, "Thêm không thành công");
                }
            }
        }
    }

    private void table_DanhSachSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_DanhSachSanPhamMouseClicked
        try {
            // TODO add your handling code here:
            int row = table_DanhSachSanPham.getSelectedRow();
            txt_MaSanPham.setText(model.getValueAt(row, 0).toString());
            txt_TenSanPham.setText(model.getValueAt(row, 1).toString());
            cbo_KichThuoc.setSelectedItem(model.getValueAt(row, 2).toString());
            cbo_MauSac.setSelectedItem(model.getValueAt(row, 3).toString());
            txt_DonGia.setText(model.getValueAt(row, 4).toString().replace(" VNĐ", "").replace(",", ""));
            cbo_TinhTrang.setSelectedItem(model.getValueAt(row, 5).toString());
            txt_SoLuongTonKho.setText(model.getValueAt(row, 6).toString());
            txt_SoLuongTonKho.setEditable(false);
            cbo_ChatLieu.setSelectedItem(model.getValueAt(row, 7).toString());
            cbo_ThuongHieu.setSelectedItem(model.getValueAt(row, 8).toString());
            cbo_DanhMuc.setSelectedItem(model.getValueAt(row, 9).toString());
            cbo_KhuyenMai.setSelectedItem(model.getValueAt(row, 10).toString());
            String img = model.getValueAt(row, 11).toString();
//        ImageIcon imageIcon = new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(lbl_AnhSanPham.getWidth(), lbl_AnhSanPham.getHeight(), Image.SCALE_SMOOTH));
            lbl_AnhSanPham.setIcon(ResizeImageIcon(img));
            lbl_AnhSanPham.setText(model.getValueAt(row, 11).toString());
            btn_Them.setEnabled(false);
        } catch (IOException ex) {
            Logger.getLogger(SanPham_JPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_table_DanhSachSanPhamMouseClicked

    private void btn_TimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TimKiemActionPerformed
        // TODO add your handling code here:
        String dieuKien = txt_MaSanPham_Search.getText().trim();
        timKiemSanPham(dieuKien);

    }//GEN-LAST:event_btn_TimKiemActionPerformed

    //Hàm tìm kiếm sản phẩm
    private void timKiemSanPham(String dieuKien) {
        String timKiem = txt_MaSanPham_Search.getText().trim();
        if (timKiem.isBlank()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập điều kiện tìm kiếm");
        } else {
            model.setRowCount(0);
            ArrayList<SanPhamEntity> dsSP = sp_bus.getAllSanPham();
            DecimalFormat decimalFormat = new DecimalFormat();
            boolean kt = false;
            for (SanPhamEntity sp : dsSP) {
                String formattedDonGia = decimalFormat.format(sp.getDonGia()) + " VNĐ";
                String tenChatLieu = chatLieu_bus.layTenChatLieuTheoMa(sp.getChatLieu().getMaChatLieu());
                String tenThuongHieu = thuongHieu_bus.layTenThuongHieuTheoMa(sp.getThuongHieu().getMaThuongHieu());
                String tenDanhMuc = danhMucSanPham_bus.layTenDanhMucTheoMa(sp.getDanhMucSanPham().getMaDanhMuc());
                String km = ctkm_bus.layTenKhuyenMaiTheoMa(sp.getChuongTrinhKhuyenMai().getMaCTKM());
                String hienThiKM = null;
                if (km != null) {
                    hienThiKM = km;
                } else {
                    hienThiKM = "Không giảm giá";
                }
                if (matchesSearchTerm(sp, dieuKien)) {
                    model.addRow(new Object[]{sp.getMaSP(), sp.getTenSP(), sp.getKichThuoc(),
                        sp.getMauSac().toString(), formattedDonGia, sp.getTinhTrang().toString(),
                        sp.getSoLuongTonKho(), tenChatLieu, tenThuongHieu, tenDanhMuc,
                        hienThiKM, sp.getImgUrl()});
                    kt = true;
                }
            }
            if (!kt) {
                JOptionPane.showMessageDialog(null, "Không tìm thấy sản phẩm");
                lamMoi();
            }
        }
    }

    private void btn_LamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LamMoiActionPerformed
        // TODO add your handling code here:
        lamMoi();
    }//GEN-LAST:event_btn_LamMoiActionPerformed

    //Hàm làm mới sản phẩm
    public void lamMoi() {
        try {
            txt_MaSanPham.setText("");
            txt_TenSanPham.setText("");
            cbo_ChatLieu.setSelectedIndex(0);
            txt_DonGia.setText("");
            txt_SoLuongTonKho.setText("0");
            cbo_ThuongHieu.setSelectedIndex(0);
            cbo_KichThuoc.setSelectedItem("S");
            cbo_MauSac.setSelectedItem("Trắng");
            cbo_DanhMuc.setSelectedIndex(0);
            cbo_TinhTrang.setSelectedItem("Hết hàng");
            txt_MaSanPham_Search.setText("");
            cbo_KhuyenMai.removeAllItems();
            duaDuLieuVaoComboBox(cbo_KhuyenMai, ctkm_bus.getAllCTKMTheoLoaiKMVaTinhTrang("GGSP", "Còn"), "TenCTKM");
            cbo_KhuyenMai.addItem("Không giảm giá");
            cbo_KhuyenMai.setSelectedItem("Không giảm giá");
            model.setRowCount(0);
//        ImageIcon anhMacDinh = new ImageIcon(duongDanAnhMacDinh);
//        ImageIcon imageIcon = new ImageIcon(anhMacDinh.getImage().getScaledInstance(lbl_AnhSanPham.getWidth(), lbl_AnhSanPham.getHeight(), Image.SCALE_SMOOTH));
            lbl_AnhSanPham.setIcon(ResizeImageIcon(duongDanAnhMacDinh));
            duongDanAnh = null;
            lbl_AnhSanPham.setText("");
            btn_Them.setEnabled(true);
            ArrayList<SanPhamEntity> dsSP = sp_bus.getAllSanPham();
            for (SanPhamEntity sp : dsSP) {
                if (sp.getSoLuongTonKho() > 0 && sp.getTinhTrang() == TinhTrangSPEnum.HETHANG) {
                    sp_bus.capNhatTinhTrang(sp.getMaSP(), TinhTrangSPEnum.DANGBAN);
                }
                if (sp.getSoLuongTonKho() == 0 && sp.getTinhTrang() == TinhTrangSPEnum.DANGBAN) {
                    {
                        sp_bus.capNhatTinhTrang(sp.getMaSP(), TinhTrangSPEnum.HETHANG);
                    }
                }
            }
            loadDuLieuTuDataLenTable();
        } catch (IOException ex) {
            Logger.getLogger(SanPham_JPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void btn_CapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CapNhatActionPerformed
        // TODO add your handling code here:
        capNhatSanPham();
    }//GEN-LAST:event_btn_CapNhatActionPerformed

    //Hàm cập nhật sản phẩm
    private void capNhatSanPham() {
        int row = table_DanhSachSanPham.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(null, "Chưa chọn sản phẩm để cập nhật");
        } else {
            if (table_DanhSachSanPham.getSelectedRowCount() == 1) {
                if (validata()) {
                    if (JOptionPane.showConfirmDialog(null, "Bạn có chắc chắc cập nhật sản phẩm có mã " + table_DanhSachSanPham.getValueAt(row, 0) + " này không?", "Cảnh báo cập nhật", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        String maSP = txt_MaSanPham.getText();
                        String tenSanPham = txt_TenSanPham.getText();
                        KichThuocEnum kichThuoc = null;
                        if (cbo_KichThuoc.getSelectedItem().equals("XS")) {
                            kichThuoc = KichThuocEnum.XS;
                        } else if (cbo_KichThuoc.getSelectedItem().equals("S")) {
                            kichThuoc = KichThuocEnum.S;
                        } else if (cbo_KichThuoc.getSelectedItem().equals("M")) {
                            kichThuoc = KichThuocEnum.M;
                        } else if (cbo_KichThuoc.getSelectedItem().equals("L")) {
                            kichThuoc = KichThuocEnum.L;
                        } else if (cbo_KichThuoc.getSelectedItem().equals("XL")) {
                            kichThuoc = KichThuocEnum.XL;
                        } else if (cbo_KichThuoc.getSelectedItem().equals("XXL")) {
                            kichThuoc = KichThuocEnum.XXL;
                        } else if (cbo_KichThuoc.getSelectedItem().equals("FREESIZE")) {
                            kichThuoc = KichThuocEnum.FREESIZE;
                        }
                        MauSacEnum mauSac = null;
                        if (cbo_MauSac.getSelectedItem().equals("Trắng")) {
                            mauSac = MauSacEnum.TRANG;
                        } else if (cbo_MauSac.getSelectedItem().equals("Đen")) {
                            mauSac = MauSacEnum.DEN;
                        } else if (cbo_MauSac.getSelectedItem().equals("Xám")) {
                            mauSac = MauSacEnum.XAM;
                        }
                        double donGia = Double.parseDouble(txt_DonGia.getText().replace(" VNĐ", "").replace(",", ""));
                        TinhTrangSPEnum tinhTrang = null;
                        if (cbo_TinhTrang.getSelectedItem().equals("Đang bán")) {
                            tinhTrang = TinhTrangSPEnum.DANGBAN;
                        } else if (cbo_TinhTrang.getSelectedItem().equals("Ngừng bán")) {
                            tinhTrang = TinhTrangSPEnum.NGUNGBAN;
                        } else if (cbo_TinhTrang.getSelectedItem().equals("Hết hàng")) {
                            tinhTrang = TinhTrangSPEnum.HETHANG;
                        }
                        int soLuongTonKho = Integer.parseInt(txt_SoLuongTonKho.getText());
                        String tenChatLieu = cbo_ChatLieu.getSelectedItem().toString();
                        String maChatLieu = chatLieu_bus.layMaChatLieuTheoTen(tenChatLieu);
                        ChatLieuEntity chatLieu = new ChatLieuEntity(maChatLieu);
                        String tenThuongHieu = cbo_ThuongHieu.getSelectedItem().toString();
                        String maThuongHieu = thuongHieu_bus.layMaThuongHieuTheoTen(tenThuongHieu);
                        ThuongHieuEntity thuongHieu = new ThuongHieuEntity(maThuongHieu);
                        String tenDanhMuc = cbo_DanhMuc.getSelectedItem().toString();
                        String maDanhMuc = danhMucSanPham_bus.layMaDanhMucTheoTen(tenDanhMuc);
                        DanhMucSanPhamEntity danhMuc = new DanhMucSanPhamEntity(maDanhMuc);
                        String tenCTKM = cbo_KhuyenMai.getSelectedItem().toString();
                        String maCTKM = ctkm_bus.layMaKhuyenMaiTheoTen(tenCTKM);
                        ChuongTrinhKhuyenMaiEntity ctkm = new ChuongTrinhKhuyenMaiEntity(maCTKM);
                        String anh = lbl_AnhSanPham.getText();
//                        System.out.println(anh);
                        SanPhamEntity sp = new SanPhamEntity(maSP, tenSanPham, kichThuoc, mauSac, donGia, soLuongTonKho, tinhTrang, chatLieu, thuongHieu, danhMuc, ctkm, anh);
                        boolean kq = sp_bus.capNhatSanPham(sp);
                        if (kq) {
                            JOptionPane.showMessageDialog(null, "Cập nhật thành công");
                            lamMoi();
                        } else {
                            JOptionPane.showMessageDialog(null, "Cập nhật không thành công");
                        }
                    }
                }
            }
        }
    }

    private void btn_XuatExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XuatExcelActionPerformed
        xuatExcel();
//          xuatExcelTable();
    }//GEN-LAST:event_btn_XuatExcelActionPerformed

    //Hàm xuất excel từ db
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
                XSSFSheet sheet = workbook.createSheet("Danh sách sản phẩm");
                XSSFRow row = null;
                Cell cell = null;
                row = sheet.createRow(0);
                cell = row.createCell(0, CellType.STRING);
                cell.setCellValue("Mã sản phẩm");
                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue("Tên sản phẩm");
                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue("Kích thước");
                cell = row.createCell(3, CellType.STRING);
                cell.setCellValue("Màu sắc");
                cell = row.createCell(4, CellType.STRING);
                cell.setCellValue("Đơn giá");
                cell = row.createCell(5, CellType.STRING);
                cell.setCellValue("Tình trạng");
                cell = row.createCell(6, CellType.STRING);
                cell.setCellValue("Số lượng tồn kho");
                cell = row.createCell(7, CellType.STRING);
                cell.setCellValue("Chất liệu");
                cell = row.createCell(8, CellType.STRING);
                cell.setCellValue("Thương hiệu");
                cell = row.createCell(9, CellType.STRING);
                cell.setCellValue("Danh mục");
                cell = row.createCell(10, CellType.STRING);
                cell.setCellValue("Ảnh");
                cell = row.createCell(11, CellType.STRING);
                cell.setCellValue("Khuyến mãi");
                ArrayList<SanPhamEntity> listItem = sp_bus.getAllSanPham();
                for (int i = 0; i < listItem.size(); i++) {
                    SanPhamEntity sp = listItem.get(i);
                    String tenChatLieu = chatLieu_bus.layTenChatLieuTheoMa(sp.getChatLieu().getMaChatLieu());
                    String tenThuongHieu = thuongHieu_bus.layTenThuongHieuTheoMa(sp.getThuongHieu().getMaThuongHieu());
                    String tenDanhMuc = danhMucSanPham_bus.layTenDanhMucTheoMa(sp.getDanhMucSanPham().getMaDanhMuc());
                    String tenCTKM = ctkm_bus.layTenKhuyenMaiTheoMa(sp.getChuongTrinhKhuyenMai().getMaCTKM());
                    row = sheet.createRow(1 + i);
                    row.createCell(0).setCellValue(sp.getMaSP());
                    row.createCell(1).setCellValue(sp.getTenSP());
                    row.createCell(2).setCellValue(sp.getKichThuoc().toString());
                    row.createCell(3).setCellValue(sp.getMauSac().toString());
                    row.createCell(4).setCellValue(sp.getDonGia());
                    row.createCell(5).setCellValue(sp.getTinhTrang().toString());
                    row.createCell(6).setCellValue(sp.getSoLuongTonKho());
                    row.createCell(7).setCellValue(tenChatLieu);
                    row.createCell(8).setCellValue(tenThuongHieu);
                    row.createCell(9).setCellValue(tenDanhMuc);
                    row.createCell(10).setCellValue(sp.getImgUrl());
                    row.createCell(11).setCellValue(tenCTKM);
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

    //Hàm xuất excel từ table
    private void xuatExcelTable() {
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
                Workbook wb = new XSSFWorkbook();
                Sheet sheet = wb.createSheet("Danh sách sản phẩm");
                Row rowCol = sheet.createRow(0);
                for (int i = 0; i < table_DanhSachSanPham.getColumnCount(); i++) {
                    Cell cell = rowCol.createCell(i);
                    cell.setCellValue(table_DanhSachSanPham.getColumnName(i));
                }
                for (int j = 0; j < table_DanhSachSanPham.getRowCount(); j++) {
                    Row row = sheet.createRow(j + 1);
                    for (int k = 0; k < table_DanhSachSanPham.getColumnCount(); k++) {
                        Cell cell = row.createCell(k);
                        if (table_DanhSachSanPham.getValueAt(j, k) != null) {
                            cell.setCellValue(table_DanhSachSanPham.getValueAt(j, k).toString());
                        }
                    }
                }
                File f = new File(filePath);
                try (FileOutputStream fos = new FileOutputStream(f)) {
                    wb.write(fos);
                    JOptionPane.showMessageDialog(null, "Xuất file thành công");
//                    System.out.println(f);
                    openExcelFile(f);

                }
                wb.close();
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

    private void btn_KiemTraTonKhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_KiemTraTonKhoActionPerformed
        // TODO add your handling code here:
        kiemTraTonKho();
    }//GEN-LAST:event_btn_KiemTraTonKhoActionPerformed

    //Hàm kiểm tra tồn kho
    private void kiemTraTonKho() {
        ArrayList<SanPhamEntity> dsSP = sp_bus.kiemTraTonKho();
        model.setRowCount(0);
        DecimalFormat decimalFormat = new DecimalFormat();
        for (SanPhamEntity sp : dsSP) {
            String formattedDonGia = decimalFormat.format(sp.getDonGia()) + " VNĐ";
            String tenChatLieu = chatLieu_bus.layTenChatLieuTheoMa(sp.getChatLieu().getMaChatLieu());
            String tenThuongHieu = thuongHieu_bus.layTenThuongHieuTheoMa(sp.getThuongHieu().getMaThuongHieu());
            String tenDanhMuc = danhMucSanPham_bus.layTenDanhMucTheoMa(sp.getDanhMucSanPham().getMaDanhMuc());
            String km = ctkm_bus.layTenKhuyenMaiTheoMa(sp.getChuongTrinhKhuyenMai().getMaCTKM());
            String hienThiKM = null;
            if (km != null) {
                hienThiKM = km;
            } else {
                hienThiKM = "Không giảm giá";
            }
            model.addRow(new Object[]{sp.getMaSP(), sp.getTenSP(), sp.getKichThuoc(),
                sp.getMauSac().toString(), formattedDonGia, sp.getTinhTrang().toString(),
                sp.getSoLuongTonKho(), tenChatLieu, tenThuongHieu, tenDanhMuc,
                hienThiKM, sp.getImgUrl()});
        }
    }

    private void btn_NhapExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_NhapExcelActionPerformed
        // TODO add your handling code here:
        nhapExcel();
    }//GEN-LAST:event_btn_NhapExcelActionPerformed

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
            Set<Object> maSanPhamSet = new HashSet<>();
            try {
                excelFile = excelFileChooser.getSelectedFile();
                excelFIS = new FileInputStream(excelFile);
                excelBIS = new BufferedInputStream(excelFIS);
                excelImportToJTable = new XSSFWorkbook(excelBIS);
                XSSFSheet excelSheet = excelImportToJTable.getSheetAt(0);
                for (int row = 1; row <= excelSheet.getLastRowNum(); row++) {
                    XSSFRow excelRow = excelSheet.getRow(row);
                    XSSFCell excelMaSP = excelRow.getCell(0);
                    // Kiểm tra xem mã sản phẩm đã tồn tại trong tập hợp chưa
                    String maSanPham = excelMaSP.getStringCellValue().trim();
                    int existingRow = -1;
                    // Kiểm tra xem mã sản phẩm nhập đã tồn tại trong bảng chưa
                    for (int i = 0; i < model.getRowCount(); i++) {
                        if (maSanPham.equals(model.getValueAt(i, 0).toString())) {
                            existingRow = i;
                            break;
                        }
                    }
                    XSSFCell excelTenSP = excelRow.getCell(1);
                    XSSFCell excelKichThuoc = excelRow.getCell(2);
                    XSSFCell excelMauSac = excelRow.getCell(3);
                    XSSFCell excelDonGia = excelRow.getCell(4);
                    XSSFCell excelTinhTrang = excelRow.getCell(5);
                    XSSFCell excelSoLuongTon = excelRow.getCell(6);
                    XSSFCell excelChatLieu = excelRow.getCell(7);
                    XSSFCell excelThuongHieu = excelRow.getCell(8);
                    XSSFCell excelDanhMuc = excelRow.getCell(9);
                    XSSFCell excelAnh = excelRow.getCell(10);
                    String duongDanAnh = excelAnh.getStringCellValue();
                    XSSFCell excelKhuyenMai = excelRow.getCell(11);
                    String khuyenMai = "";
                    if (excelKhuyenMai != null) {
                        khuyenMai = excelKhuyenMai.getStringCellValue().trim();
                    } else {
                        khuyenMai = "Không giảm giá";
                    }
                    int soLuongTonKho = (int) excelSoLuongTon.getNumericCellValue();
                    double donGia = excelDonGia.getNumericCellValue();
                    DecimalFormat decimalFormat = new DecimalFormat();
                    String formattedDonGia = decimalFormat.format(donGia) + " VNĐ";
                    String tinhTrang = excelTinhTrang.getStringCellValue().trim();
                    if (soLuongTonKho == 0 && "Đang bán".equals(tinhTrang)) {
                        tinhTrang = "Hết hàng";
                    }
                    if (existingRow != -1) {
                        model.setValueAt(excelTenSP.getStringCellValue(), existingRow, 1);
                        model.setValueAt(excelKichThuoc.getStringCellValue(), existingRow, 2);
                        model.setValueAt(excelMauSac, existingRow, 3);
                        model.setValueAt(formattedDonGia, existingRow, 4);
                        model.setValueAt(tinhTrang, existingRow, 5);
                        model.setValueAt(soLuongTonKho, existingRow, 6);
                        model.setValueAt(excelChatLieu, existingRow, 7);
                        model.setValueAt(excelThuongHieu, existingRow, 8);
                        model.setValueAt(excelDanhMuc, existingRow, 9);
                        model.setValueAt(khuyenMai, existingRow, 10);
                        model.setValueAt(duongDanAnh, existingRow, 11);
                    } else {
                        maSanPhamSet.add(maSanPham);
                        model.addRow(new Object[]{maSanPham, excelTenSP, excelKichThuoc, excelMauSac, formattedDonGia, tinhTrang, soLuongTonKho, excelChatLieu, excelThuongHieu, excelDanhMuc, khuyenMai, duongDanAnh});
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

    private void btn_LuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LuuActionPerformed
        // TODO add your handling code here:
        luu();
    }//GEN-LAST:event_btn_LuuActionPerformed

    //Hàm lưu dữ liệu từ table vào db
    private void luu() {
        for (int i = 0; i < model.getRowCount(); i++) {
            String maSP = model.getValueAt(i, 0).toString();
            String tenSP = model.getValueAt(i, 1).toString();
            KichThuocEnum kichThuoc = null;
            if (model.getValueAt(i, 2).toString().equals("XS")) {
                kichThuoc = KichThuocEnum.XS;
            } else if (model.getValueAt(i, 2).toString().equals("S")) {
                kichThuoc = KichThuocEnum.S;
            } else if (model.getValueAt(i, 2).toString().equals("M")) {
                kichThuoc = KichThuocEnum.M;
            } else if (model.getValueAt(i, 2).toString().equals("L")) {
                kichThuoc = KichThuocEnum.L;
            } else if (model.getValueAt(i, 2).toString().equals("XL")) {
                kichThuoc = KichThuocEnum.XL;
            } else if (model.getValueAt(i, 2).toString().equals("XXL")) {
                kichThuoc = KichThuocEnum.XXL;
            } else if (model.getValueAt(i, 2).toString().equals("FREESIZE")) {
                kichThuoc = KichThuocEnum.FREESIZE;
            }
            MauSacEnum mauSac = null;
            if (model.getValueAt(i, 3).toString().equals("Trắng")) {
                mauSac = MauSacEnum.TRANG;
            } else if (model.getValueAt(i, 3).toString().equals("Đen")) {
                mauSac = MauSacEnum.DEN;
            } else if (model.getValueAt(i, 3).toString().equals("Xám")) {
                mauSac = MauSacEnum.XAM;
            }
            double donGia = Double.parseDouble(model.getValueAt(i, 4).toString().replace(" VNĐ", "").replace(",", ""));
            TinhTrangSPEnum tinhTrang = null;
            if (model.getValueAt(i, 5).toString().equals("Đang bán")) {
                tinhTrang = TinhTrangSPEnum.DANGBAN;
            } else if (model.getValueAt(i, 5).toString().equals("Ngừng bán")) {
                tinhTrang = TinhTrangSPEnum.NGUNGBAN;
            } else if (model.getValueAt(i, 5).toString().equals("Hết hàng")) {
                tinhTrang = TinhTrangSPEnum.HETHANG;
            }
            int soLuongTonKho = Integer.parseInt(model.getValueAt(i, 6).toString());
            String tenChatLieu = model.getValueAt(i, 7).toString();
            String maChatLieu = chatLieu_bus.layMaChatLieuTheoTen(tenChatLieu);
            ChatLieuEntity chatLieu = new ChatLieuEntity(maChatLieu);
            String tenThuongHieu = model.getValueAt(i, 8).toString();
            String maThuongHieu = thuongHieu_bus.layMaThuongHieuTheoTen(tenThuongHieu);
            ThuongHieuEntity thuongHieu = new ThuongHieuEntity(maThuongHieu);
            String tenDanhMuc = model.getValueAt(i, 9).toString();
            String maDanhMuc = danhMucSanPham_bus.layMaDanhMucTheoTen(tenDanhMuc);
            DanhMucSanPhamEntity danhMuc = new DanhMucSanPhamEntity(maDanhMuc);
            String tenCTKM = model.getValueAt(i, 10).toString();
            String maCTKM = ctkm_bus.layMaKhuyenMaiTheoTen(tenCTKM);
            ChuongTrinhKhuyenMaiEntity ctkm = new ChuongTrinhKhuyenMaiEntity(maCTKM);
            String anh = model.getValueAt(i, 11).toString();
            SanPhamEntity sp = new SanPhamEntity(maSP, tenSP, kichThuoc, mauSac, donGia, soLuongTonKho, tinhTrang, chatLieu, thuongHieu, danhMuc, ctkm, anh);
            if (!sp_bus.kiemTraMaSanPhamTonTai(maSP)) {
                sp_bus.themSP(sp);
            } else {
                sp_bus.capNhatSanPham(sp);
            }
        }
        JOptionPane.showMessageDialog(null, "Lưu thành công");
    }

    //Hàm kiểm tra sản phẩm có chứa tiêu chí tìm kiếm không
    private boolean matchesSearchTerm(SanPhamEntity sanPham, String search) {
        String lowercaseSearch = search.toLowerCase(); // Chuyển chuỗi tìm kiếm về chữ thường

        if (sanPham.getMaSP().toLowerCase().contains(lowercaseSearch)
                || sanPham.getTenSP().toLowerCase().contains(lowercaseSearch)
                || (sanPham.getKichThuoc() != null && sanPham.getKichThuoc().toString().toLowerCase().contains(lowercaseSearch))
                || (sanPham.getMauSac() != null && sanPham.getMauSac().toString().toLowerCase().contains(lowercaseSearch))
                || Double.toString(sanPham.getDonGia()).toLowerCase().contains(lowercaseSearch)
                || sanPham.getTinhTrang().toString().toLowerCase().contains(lowercaseSearch)
                || Integer.toString(sanPham.getSoLuongTonKho()).toLowerCase().contains(lowercaseSearch)) {
            return true;
        }
        if (sanPham.getChatLieu() != null && sanPham.getChatLieu().getMaChatLieu() != null) {
            String tenChatLieu = chatLieu_bus.layTenChatLieuTheoMa(sanPham.getChatLieu().getMaChatLieu()).toLowerCase();
            if (tenChatLieu.contains(lowercaseSearch)) {
                return true;
            }
        }
        if (sanPham.getThuongHieu() != null && sanPham.getThuongHieu().getMaThuongHieu() != null) {
            String tenThuongHieu = thuongHieu_bus.layTenThuongHieuTheoMa(sanPham.getThuongHieu().getMaThuongHieu()).toLowerCase();
            if (tenThuongHieu.contains(lowercaseSearch)) {
                return true;
            }
        }
        if (sanPham.getDanhMucSanPham() != null && sanPham.getDanhMucSanPham().getMaDanhMuc() != null) {
            String tenDanhMuc = danhMucSanPham_bus.layTenDanhMucTheoMa(sanPham.getDanhMucSanPham().getMaDanhMuc()).toLowerCase();
            if (tenDanhMuc.contains(lowercaseSearch)) {
                return true;
            }
        }
        if (sanPham.getChuongTrinhKhuyenMai() != null && sanPham.getChuongTrinhKhuyenMai().getMaCTKM() != null) {
            String tenCTKM = ctkm_bus.layTenKhuyenMaiTheoMa(sanPham.getChuongTrinhKhuyenMai().getMaCTKM()).toLowerCase();
            if (tenCTKM.contains(lowercaseSearch)) {
                return true;
            }
        }
        if (sanPham.getChuongTrinhKhuyenMai() == null || sanPham.getChuongTrinhKhuyenMai().getMaCTKM() == null) {
            String km = "Không giảm giá".toLowerCase();
            if (km.contains(lowercaseSearch)) {
                return true;
            }
        }

        return false;
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

    //Hàm kiểm tra mã sản phẩm đã có trong table hay chưa
    private boolean kiemTraMaSanPhamTontaiTrongTable(DefaultTableModel model, String maSanPham) {
        for (int row = 0; row < model.getRowCount(); row++) {
            if (model.getValueAt(row, 0).equals(maSanPham)) {
                return true;
            }
        }
        return false;
    }

    //Hàm kiểm tra ảnh null 
//    private void kiemTraAnhNull(int row) {
//        String img = sp_bus.getAllSanPham().get(row).getImgUrl();
//        ImageIcon imageIcon;
//        if (img != null) {
//            imageIcon = new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(lbl_AnhSanPham.getWidth(), lbl_AnhSanPham.getHeight(), Image.SCALE_SMOOTH));
//        } else {
//            ImageIcon anhMacDinh = new ImageIcon("src//pic//icon//labelAnh.png");
//            imageIcon = new ImageIcon(anhMacDinh.getImage().getScaledInstance(lbl_AnhSanPham.getWidth(), lbl_AnhSanPham.getHeight(), Image.SCALE_SMOOTH));
//        }
//        lbl_AnhSanPham.setIcon(imageIcon);
//    }
    //Hàm kiểm tra regex
    private boolean validata() {
        String tenSP = txt_TenSanPham.getText().trim();
        String donGia = txt_DonGia.getText().trim();
        if (tenSP.isBlank() || donGia.isBlank()) {
            JOptionPane.showMessageDialog(null, "Không được để trống");
            return false;
        }
        if (!tenSP.matches("^(\\p{L}{1}\\p{L}*\\s)*(\\p{L}{1}\\p{L}*)$")) {
            JOptionPane.showMessageDialog(null, "Tên sản phẩm không được nhập số");
            txt_TenSanPham.requestFocus();
            txt_TenSanPham.selectAll();
            return false;
        }
        if (!donGia.matches("^[1-9]\\d*")) {
            JOptionPane.showMessageDialog(null, "Đơn giá phải lớn hơn 0, không được nhập chữ");
            txt_DonGia.requestFocus();
            txt_DonGia.selectAll();
            return false;
        }
        double dg = Double.parseDouble(donGia);
        if (dg < 0) {
            JOptionPane.showMessageDialog(null, "Đơn giá phải lớn hơn 0");
            txt_DonGia.requestFocus();
            txt_DonGia.selectAll();
            return false;
        }
        return true;

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_CapNhat;
    private javax.swing.JButton btn_ChonAnh;
    private javax.swing.JButton btn_KiemTraTonKho;
    private javax.swing.JButton btn_LamMoi;
    private javax.swing.JButton btn_Luu;
    private javax.swing.JButton btn_NhapExcel;
    private javax.swing.JButton btn_Them;
    private javax.swing.JButton btn_TimKiem;
    private javax.swing.JButton btn_XuatExcel;
    private javax.swing.JComboBox<String> cbo_ChatLieu;
    private javax.swing.JComboBox<String> cbo_DanhMuc;
    private javax.swing.JComboBox<String> cbo_KhuyenMai;
    private javax.swing.JComboBox<String> cbo_KichThuoc;
    private javax.swing.JComboBox<String> cbo_MauSac;
    private javax.swing.JComboBox<String> cbo_ThuongHieu;
    private javax.swing.JComboBox<String> cbo_TinhTrang;
    private javax.swing.JLabel lbl_AnhSanPham;
    private javax.swing.JLabel lbl_ChatLieu;
    private javax.swing.JLabel lbl_DanhMuc;
    private javax.swing.JLabel lbl_DonGia;
    private javax.swing.JLabel lbl_KhuyenMai;
    private javax.swing.JLabel lbl_KichThuoc;
    private javax.swing.JLabel lbl_MaSanPham;
    private javax.swing.JLabel lbl_MaSanPham_Search;
    private javax.swing.JLabel lbl_MauSac;
    private javax.swing.JLabel lbl_SoLuongTonKho;
    private javax.swing.JLabel lbl_TenSanPham;
    private javax.swing.JLabel lbl_ThuongHieu;
    private javax.swing.JLabel lbl_TieuDe;
    private javax.swing.JLabel lbl_TinhTrang;
    private javax.swing.JPanel panel_DanhSachSanPham;
    private javax.swing.JPanel panel_ThaoTac;
    private javax.swing.JPanel panel_ThongTin;
    private javax.swing.JScrollPane scroll_TableSanPham;
    private javax.swing.JTable table_DanhSachSanPham;
    private javax.swing.JTextField txt_DonGia;
    private javax.swing.JTextField txt_MaSanPham;
    private javax.swing.JTextField txt_MaSanPham_Search;
    private javax.swing.JTextField txt_SoLuongTonKho;
    private javax.swing.JTextField txt_TenSanPham;
    // End of variables declaration//GEN-END:variables
}

//Căn giữa cột trong table
class CenterRenderer extends DefaultTableCellRenderer {

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        ((JLabel) c).setHorizontalAlignment(SwingConstants.CENTER);
        return c;
    }
}
