package gui;

import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import dao.LichTrinh_dao;
import dao.Tau_dao;
import entity.LichTrinhEntity;
import entity.TauEntity;
import entity.TauEnum;
import java.awt.Font;
import java.net.URL;
import java.sql.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.JTableHeader;

/**
 *
 * @author ploc2
 */
public class LichTrinh_JPanel extends javax.swing.JPanel {

    private LichTrinh_dao lichTrinh_dao;   
    private Tau_dao tau_dao;

    /**
     * Creates new form LichTrinh_JPanel
     */
    public LichTrinh_JPanel() {
        initComponents();
        
        //Khởi tạo
        dateNgayDi.setLocale(new Locale("vi", "VN"));
        dateNgayDen.setLocale(new Locale("vi", "VN"));

        tau_dao = new Tau_dao();
        lichTrinh_dao = new LichTrinh_dao();
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

        model = new DefaultTableModel(new String[]{"Mã", "Mã tàu", "Ngày đi",  "Giờ đi",  "Giờ đi",  "Giờ đến", "Trạng thái", "Loại"}, 0);

       loadDuLieuTuDataLenTable();
       duaDuLieuVaoComboBox(cbo_MaTau, tau_dao.getAllTauDangHoatDong() , "MaTau");

    }
    
    private LichTrinhEntity validData() {
        LichTrinhEntity lt =new LichTrinhEntity();

        String maTau = cbo_MaTau.getSelectedItem().toString();
        int trangThai = cbo_TinhTrang.getSelectedIndex();
        int loai = cbo_Loai.getSelectedIndex();

        Date ngayDen = dateNgayDen.getDate() != null ? new Date(dateNgayDen.getDate().getTime()) : null;
        Date ngayDi = dateNgayDi.getDate() != null ? new Date(dateNgayDi.getDate().getTime()) : null;

        // check dateNgayDi < dateNgayDen
        if (ngayDi != null && ngayDen != null && ngayDi.after(ngayDen)) {
            JOptionPane.showMessageDialog(null, "Ngày đến phải sau ngày đi");
            dateNgayDi.requestFocus();
            return null;
        }

        String gioDi = txt_GioDi.getText().trim();
        String gioDen = txt_GioDen.getText().trim();

        if (gioDi.isBlank() || gioDen.isBlank()) {
            JOptionPane.showMessageDialog(null, "Không được để trống");
            txt_GioDi.requestFocus();
            return null;
        }

        // check String gioDi gioDen > 00:00 and < 24:00
        if (!gioDi.matches("\\d{2}:\\d{2}") ||!gioDen.matches("\\d{2}:\\d{2}")) {
            JOptionPane.showMessageDialog(null, "Giờ phải có định dạng HH:MM");
            txt_GioDi.requestFocus();
            return null;
        }

        kiemTraGio(gioDi, gioDen);

        TauEntity tau = new TauEntity(maTau);

        lt.setTau(tau);
        lt.setTrangThai(trangThai);
        lt.setLoai(loai);
        lt.setGioDi(gioDi);
        lt.setGioDen(gioDen);
        lt.setNgayDi(ngayDi);
        lt.setNgayDen(ngayDen);

        return lt;
    
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
        txt_MaLichTrinh = new javax.swing.JTextField();
        lbl_SoLuongTonKho = new javax.swing.JLabel();
        lbl_DanhMuc = new javax.swing.JLabel();
        cbo_Loai = new javax.swing.JComboBox<>();
        lbl_KichThuoc = new javax.swing.JLabel();
        lbl_MauSac = new javax.swing.JLabel();
        lbl_TinhTrang = new javax.swing.JLabel();
        cbo_TinhTrang = new javax.swing.JComboBox<>();
        lbl_DonGia = new javax.swing.JLabel();
        txt_GioDi = new javax.swing.JTextField();
        cbo_MaTau = new javax.swing.JComboBox<>();
        dateNgayDen = new com.toedter.calendar.JDateChooser();
        dateNgayDi = new com.toedter.calendar.JDateChooser();
        lbl_DonGia1 = new javax.swing.JLabel();
        txt_GioDen = new javax.swing.JTextField();
        panel_ThaoTac = new javax.swing.JPanel();
        lbl_MaSanPham_Search = new javax.swing.JLabel();
        btn_TimKiem = new javax.swing.JButton();
        btn_LamMoi = new javax.swing.JButton();
        btn_Them = new javax.swing.JButton();
        btn_CapNhat = new javax.swing.JButton();
        txt_MaHanhTrinh_Search = new javax.swing.JTextField();
        panel_DanhSachSanPham = new javax.swing.JPanel();
        scroll_TableSanPham = new javax.swing.JScrollPane();
        table_DanhSachLichTrinh = new javax.swing.JTable();
        lbl_TieuDe = new javax.swing.JLabel();

        setBackground(new java.awt.Color(187, 205, 197));
        setPreferredSize(new java.awt.Dimension(1186, 748));

        panel_ThongTin.setBackground(new java.awt.Color(187, 205, 197));
        panel_ThongTin.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Thông tin hành trình", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 12))); // NOI18N
        panel_ThongTin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_MaSanPham.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lbl_MaSanPham.setText("Mã HT");
        lbl_MaSanPham.setPreferredSize(new java.awt.Dimension(85, 15));
        panel_ThongTin.add(lbl_MaSanPham, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 22, 100, 25));

        txt_MaLichTrinh.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_MaLichTrinh.setEditable(false);
        panel_ThongTin.add(txt_MaLichTrinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 200, 30));

        lbl_SoLuongTonKho.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lbl_SoLuongTonKho.setText("Mã tàu");
        lbl_SoLuongTonKho.setMaximumSize(new java.awt.Dimension(82, 15));
        lbl_SoLuongTonKho.setMinimumSize(new java.awt.Dimension(82, 15));
        lbl_SoLuongTonKho.setPreferredSize(new java.awt.Dimension(85, 15));
        panel_ThongTin.add(lbl_SoLuongTonKho, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, 117, 25));

        lbl_DanhMuc.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lbl_DanhMuc.setText("Loại");
        lbl_DanhMuc.setPreferredSize(new java.awt.Dimension(85, 15));
        panel_ThongTin.add(lbl_DanhMuc, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 70, 117, 25));

        cbo_Loai.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cbo_Loai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Một chiều", "Khứ hồi" }));
        panel_ThongTin.add(cbo_Loai, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 70, 200, 30));

        lbl_KichThuoc.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lbl_KichThuoc.setText("Ngày đi");
        lbl_KichThuoc.setPreferredSize(new java.awt.Dimension(85, 15));
        panel_ThongTin.add(lbl_KichThuoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 90, 25));

        lbl_MauSac.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lbl_MauSac.setText("Ngày đến");
        lbl_MauSac.setPreferredSize(new java.awt.Dimension(85, 15));
        panel_ThongTin.add(lbl_MauSac, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 90, 25));

        lbl_TinhTrang.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lbl_TinhTrang.setText("Tình trạng");
        lbl_TinhTrang.setPreferredSize(new java.awt.Dimension(85, 15));
        panel_ThongTin.add(lbl_TinhTrang, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 90, 25));

        cbo_TinhTrang.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cbo_TinhTrang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tạm ngưng", "Đang sử dụng" }));
        cbo_TinhTrang.setSelectedItem("Hết hàng");
        panel_ThongTin.add(cbo_TinhTrang, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 200, 30));

        lbl_DonGia.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lbl_DonGia.setText("Giờ đi");
        lbl_DonGia.setMaximumSize(new java.awt.Dimension(82, 15));
        lbl_DonGia.setMinimumSize(new java.awt.Dimension(82, 15));
        lbl_DonGia.setPreferredSize(new java.awt.Dimension(85, 15));
        panel_ThongTin.add(lbl_DonGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 120, 69, 25));

        txt_GioDi.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        panel_ThongTin.add(txt_GioDi, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 120, 200, 30));

        cbo_MaTau.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        panel_ThongTin.add(cbo_MaTau, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, 200, 30));

        dateNgayDen.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dateNgayDenPropertyChange(evt);
            }
        });
        panel_ThongTin.add(dateNgayDen, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 200, 25));

        dateNgayDi.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dateNgayDiPropertyChange(evt);
            }
        });
        panel_ThongTin.add(dateNgayDi, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 200, 25));

        lbl_DonGia1.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lbl_DonGia1.setText("Giờ đến");
        lbl_DonGia1.setMaximumSize(new java.awt.Dimension(82, 15));
        lbl_DonGia1.setMinimumSize(new java.awt.Dimension(82, 15));
        lbl_DonGia1.setPreferredSize(new java.awt.Dimension(85, 15));
        panel_ThongTin.add(lbl_DonGia1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 170, 69, 25));

        txt_GioDen.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        panel_ThongTin.add(txt_GioDen, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 170, 200, 30));

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

        txt_MaHanhTrinh_Search.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        javax.swing.GroupLayout panel_ThaoTacLayout = new javax.swing.GroupLayout(panel_ThaoTac);
        panel_ThaoTac.setLayout(panel_ThaoTacLayout);
        panel_ThaoTacLayout.setHorizontalGroup(
            panel_ThaoTacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_ThaoTacLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(lbl_MaSanPham_Search)
                .addGap(18, 18, 18)
                .addComponent(txt_MaHanhTrinh_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_LamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_Them, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_CapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_ThaoTacLayout.setVerticalGroup(
            panel_ThaoTacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_ThaoTacLayout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(panel_ThaoTacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_ThaoTacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_CapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_Them, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_LamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_MaHanhTrinh_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbl_MaSanPham_Search))
                .addGap(8, 8, 8))
        );

        panel_DanhSachSanPham.setBackground(new java.awt.Color(187, 205, 197));
        panel_DanhSachSanPham.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Bảng danh sách hành trình", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 12))); // NOI18N
        panel_DanhSachSanPham.setPreferredSize(new java.awt.Dimension(1008, 317));

        JTableHeader tableHeader=table_DanhSachLichTrinh.getTableHeader();
        tableHeader.setFont(new Font("Times New Roman", Font.BOLD, 13));
        table_DanhSachLichTrinh.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        table_DanhSachLichTrinh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã", "Mã tàu", "Ngày đi", "Giờ đi", "Ngày đến", "Giờ đến", "Trạng thái", "Loại"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_DanhSachLichTrinh.getColumnModel().getColumn(0).setPreferredWidth(100);
        table_DanhSachLichTrinh.getColumnModel().getColumn(1).setPreferredWidth(200);
        table_DanhSachLichTrinh.getColumnModel().getColumn(2).setCellRenderer(new CenterRenderer());
        table_DanhSachLichTrinh.getColumnModel().getColumn(3).setCellRenderer(new CenterRenderer());
        table_DanhSachLichTrinh.getColumnModel().getColumn(4).setCellRenderer(new CenterRenderer());
        table_DanhSachLichTrinh.getColumnModel().getColumn(5).setCellRenderer(new CenterRenderer());
        table_DanhSachLichTrinh.getColumnModel().getColumn(6).setCellRenderer(new CenterRenderer());
        table_DanhSachLichTrinh.getColumnModel().getColumn(7).setCellRenderer(new CenterRenderer());
        table_DanhSachLichTrinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_DanhSachLichTrinhMouseClicked(evt);
            }
        });
        scroll_TableSanPham.setViewportView(table_DanhSachLichTrinh);

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
        lbl_TieuDe.setText("QUẢN LÝ HÀNH TRÌNH");

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
        ArrayList<TauEntity> dsTau = tau_dao.getAllTauDangHoatDong();
                ArrayList<LichTrinhEntity> dsLichTrinh = lichTrinh_dao.getAllLichTrinh();

                model.setRowCount(0);
        for (LichTrinhEntity lt : dsLichTrinh) {
            String trangThai = TauEnum.TrangThaiLichTrinh.convertTrangThaiToString(lt.getTrangThai())  ;
            String loai = TauEnum.LoaiLichTrinh.convertLoaiLichTrinhToString(lt.getLoai());
            
            model.addRow(new Object[]{lt.getMaHT(), lt.getTau().getMaTau(), lt.getNgayDi(),
                lt.getGioDi().toString(), lt.getNgayDen(),
                lt.getGioDen().toString(), trangThai, loai
                });
        }
        table_DanhSachLichTrinh.setModel(model);
    }

    //Hàm thêm sản phẩm
    private void them() {
        LichTrinhEntity lt = validData();

        if (lt != null) {
            
            boolean kiemTra = lichTrinh_dao.them(lt);
            if (kiemTra) {
                JOptionPane.showMessageDialog(null, "Thêm thành công");
                lamMoi();
            } else {
                JOptionPane.showMessageDialog(null, "Thêm không thành công");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Thêm không thành công");
        }

    }

    private void table_DanhSachLichTrinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_DanhSachLichTrinhMouseClicked
        try {
           int row = table_DanhSachLichTrinh.getSelectedRow();

           txt_MaLichTrinh.setText(model.getValueAt(row, 0).toString());
           cbo_MaTau.setSelectedItem(model.getValueAt(row, 1).toString());
           cbo_TinhTrang.setSelectedIndex(model.getValueAt(row, 6) == "Tạm ngưng" ? 0 : 1);
           cbo_Loai.setSelectedIndex(model.getValueAt(row, 7) == "Một chiều" ? 0 : 1);
           dateNgayDen.setDate(model.getValueAt(row, 4) != null ? (Date) model.getValueAt(row, 5) : null);
           dateNgayDi.setDate(model.getValueAt(row, 2) != null ? (Date) model.getValueAt(row, 4) : null);
           txt_GioDi.setText(model.getValueAt(row, 3).toString());
           txt_GioDen.setText(model.getValueAt(row, 5).toString());

           btn_CapNhat.setEnabled(true);
           btn_Them.setEnabled(false);
        } catch (Exception ex) {
            Logger.getLogger(LichTrinh_JPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_table_DanhSachLichTrinhMouseClicked

    //Hàm tìm kiếm sản phẩm
    private void timKiemSanPham(String dieuKien) {
        
    }

    //Hàm làm mới sản phẩm
    public void lamMoi() {
        try {
            txt_MaLichTrinh.setText("");
            cbo_MaTau.setSelectedIndex(0);
            cbo_TinhTrang.setSelectedItem(0);
            cbo_Loai.setSelectedItem(0);

            dateNgayDen.setDate(null);
            dateNgayDi.setDate(null);
            txt_GioDi.setText("");
            txt_GioDen.setText("");

            txt_MaHanhTrinh_Search.setText("");
          
            loadDuLieuTuDataLenTable();
            btn_Them.setEnabled(true);
        } catch (Exception ex) {
            Logger.getLogger(LichTrinh_JPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Hàm cập nhật sản phẩm
    private void capNhat() {
       int maHT = Integer.parseInt(txt_MaLichTrinh.getText().trim());

       if(!(maHT > 0)) {
            JOptionPane.showMessageDialog(null, "Không được để trống");
            return;
       }
       
       LichTrinhEntity lt = validData();

       if(lt == null) {
        // JOptionPane.showMessageDialog(null, "Không được để trống");
        return;
       }

       lt.setMaHT(maHT);

       boolean kiemTra = lichTrinh_dao.capNhat(lt);
       if (kiemTra) {
           JOptionPane.showMessageDialog(null, "Cập nhật thành công");
           lamMoi();
       }
       else {
           JOptionPane.showMessageDialog(null, "Cập nhật không thành công");
       }

    }

 
    private void btn_CapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CapNhatActionPerformed
        capNhat();
    }//GEN-LAST:event_btn_CapNhatActionPerformed

    private void btn_ThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemActionPerformed
        them();
    }//GEN-LAST:event_btn_ThemActionPerformed

    private void btn_LamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LamMoiActionPerformed
        lamMoi();
    }//GEN-LAST:event_btn_LamMoiActionPerformed

    private void btn_TimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TimKiemActionPerformed
        String dieuKien = txt_MaHanhTrinh_Search.getText().trim();
//        timKiemSanPham(dieuKien);
    }//GEN-LAST:event_btn_TimKiemActionPerformed

    private void dateNgayDenPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dateNgayDenPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_dateNgayDenPropertyChange

    private void dateNgayDiPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dateNgayDiPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_dateNgayDiPropertyChange

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

    boolean kiemTraGio(String gioDi, String gioDen) {
        // Parse the hours and minutes
        String[] startParts = gioDi.split(":");
        String[] endParts = gioDen.split(":");

        int gioDiHours = Integer.parseInt(startParts[0]);
        int gioDiMinutes = Integer.parseInt(startParts[1]);
        int gioDenHours = Integer.parseInt(endParts[0]);
        int gioDenMinutes = Integer.parseInt(endParts[1]);

        // Check if time values are within valid range
        if ((gioDiHours < 0 || gioDiHours > 23) || (gioDiMinutes < 0 || gioDiMinutes > 59)) {
            JOptionPane.showMessageDialog(null, "Giờ đi không hợp lệ.");
            txt_GioDi.requestFocus();
            return false;
        }

        if ((gioDenHours < 0 || gioDenHours > 23) || (gioDenMinutes < 0 || gioDenMinutes > 59)) {
            JOptionPane.showMessageDialog(null, "Giờ đến không hợp lệ.");
            txt_GioDen.requestFocus();
            return false;
        }
        
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_CapNhat;
    private javax.swing.JButton btn_LamMoi;
    private javax.swing.JButton btn_Them;
    private javax.swing.JButton btn_TimKiem;
    private javax.swing.JComboBox<String> cbo_Loai;
    private javax.swing.JComboBox<String> cbo_MaTau;
    private javax.swing.JComboBox<String> cbo_TinhTrang;
    private com.toedter.calendar.JDateChooser dateNgayDen;
    private com.toedter.calendar.JDateChooser dateNgayDi;
    private javax.swing.JLabel lbl_DanhMuc;
    private javax.swing.JLabel lbl_DonGia;
    private javax.swing.JLabel lbl_DonGia1;
    private javax.swing.JLabel lbl_KichThuoc;
    private javax.swing.JLabel lbl_MaSanPham;
    private javax.swing.JLabel lbl_MaSanPham_Search;
    private javax.swing.JLabel lbl_MauSac;
    private javax.swing.JLabel lbl_SoLuongTonKho;
    private javax.swing.JLabel lbl_TieuDe;
    private javax.swing.JLabel lbl_TinhTrang;
    private javax.swing.JPanel panel_DanhSachSanPham;
    private javax.swing.JPanel panel_ThaoTac;
    private javax.swing.JPanel panel_ThongTin;
    private javax.swing.JScrollPane scroll_TableSanPham;
    private javax.swing.JTable table_DanhSachLichTrinh;
    private DefaultTableModel model;
    private javax.swing.JTextField txt_GioDen;
    private javax.swing.JTextField txt_GioDi;
    private javax.swing.JTextField txt_MaHanhTrinh_Search;
    private javax.swing.JTextField txt_MaLichTrinh;
    // End of variables declaration//GEN-END:variables
}

//Căn giữa cột trong table
//class CenterRenderer extends DefaultTableCellRenderer {
//
//    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
//        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
//        ((JLabel) c).setHorizontalAlignment(SwingConstants.CENTER);
//        return c;
//    }
//}
