package gui;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import connectDB.ConnectDB;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;
import org.jdesktop.layout.GroupLayout;
import util.ToanCuc;

public class TrangChu_GUI extends javax.swing.JFrame {
        
    public TrangChu_GUI() {

        initComponents();
        ToanCuc tc = new ToanCuc();
        System.out.println(tc);
//        jlb_name.setText(tc.getName());
//        lbl_ChucVu.setText(tc.getChucvu());
        
//        if (tc.getGioitnh().equals("Nữ")) {
//            URL image_User_nu = TrangChu_GUI.class.getResource("/pic/icon/user_nu.png");
//            ImageIcon img_User_nu = new ImageIcon(image_User_nu);
//            Image scaled_Users_nu = img_User_nu.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
//            img_User_nu = new ImageIcon(scaled_Users_nu);
//
//            lbl_Users.setIcon(img_User_nu);
//        } else {
//            URL image_User_nam = TrangChu_GUI.class.getResource("/pic/icon/user_nam.png");
//            ImageIcon img_User = new ImageIcon("image_User_nam");
//            Image scaled_Users = img_User.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
//            img_User = new ImageIcon(scaled_Users);
//            lbl_Users.setIcon(img_User);
//        }
//
//        if (tc.getChucvu().equals("Nhân viên")) {
//            Jpanel_NhanVien.setVisible(false);
//            Jpanel_NhaCungCap.setVisible(false);
//            Jpanel_KhuyenMai.setVisible(false);
//            Jpanel_TaiKhoan.setVisible(false);
//            Jpanel_PhieuNhap.setVisible(false);
//        }
        setSize(1366, 768);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        getContentPane().setLayout(null);

//        TrangChu_Panel = new TrangChu_JPanel();
        BanHang_Panel = new BanHang_JPanel();
        SanPham_Panel = new SanPham_JPanel();
        HoaDon_Panel = new HoaDon_JPanel();
        DoiTra_Panel = new DoiTra_JPanel();
        ThongKe_Panel = new ThongKe_JPanel();
        KhachHang_Panel = new KhachHang_JPanel();
        NhanVien_Panel = new NhanVien_JPanel();
        KhuyenMai_Panel = new KhuyenMai_JPanel();
        PhieuNhap_Panel = new PhieuNhap_JPanel();
        TaiKhoan_Panel = new TaiKhoan_JPanel();
        NhaCungCap_Panel = new NhaCungCap_JPanel();
        
        URL image_home = TrangChu_GUI.class.getResource("/pic/icon/home.png");   
        ImageIcon img_home = new ImageIcon(image_home);
        Image scaled_home = img_home.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        img_home = new ImageIcon(scaled_home);
        lbl_IconTrangChu.setIcon(img_home);
        
        URL image_SanPham = TrangChu_GUI.class.getResource("/pic/icon/productbox.png");   
        ImageIcon img_SanPham = new ImageIcon(image_SanPham);
        Image scaled_SanPham = img_SanPham.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        img_SanPham = new ImageIcon(scaled_SanPham);
        lbl_IconSanPham.setIcon(img_SanPham);
        
        URL image_BanHang = TrangChu_GUI.class.getResource("/pic/icon/clothers.png");
        ImageIcon img_BanHang = new ImageIcon(image_BanHang);
        Image scaled_BanHang = img_BanHang.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        img_BanHang = new ImageIcon(scaled_BanHang);
        lbl_IconBanHang.setIcon(img_BanHang);

        URL image_User = TrangChu_GUI.class.getResource("/pic/icon/user_nam.png");
        ImageIcon img_User = new ImageIcon(image_User);
        Image scaled_Users = img_User.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        img_User = new ImageIcon(scaled_Users);
        lbl_Users.setIcon(img_User);

        URL image_HoaDon = TrangChu_GUI.class.getResource("/pic/icon/hoadon.png");
        ImageIcon img_HoaDon = new ImageIcon(image_HoaDon);
        Image scaled_HoaDon = img_HoaDon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        img_HoaDon = new ImageIcon(scaled_HoaDon);
        lbl_IconHoaDon.setIcon(img_HoaDon);

        URL image_DoiTra = TrangChu_GUI.class.getResource("/pic/icon/return.png");
        ImageIcon img_DoiTra = new ImageIcon(image_DoiTra);
        Image scaled_DoiTra = img_DoiTra.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        img_DoiTra = new ImageIcon(scaled_DoiTra);
        lbl_IconDoiTra.setIcon(img_DoiTra);

        URL image_KhachHang = TrangChu_GUI.class.getResource("/pic/icon/customer.png");
        ImageIcon img_KhachHang = new ImageIcon(image_KhachHang);
        Image scaled_KhachHang = img_KhachHang.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        img_KhachHang = new ImageIcon(scaled_KhachHang);
        lbl_IconKhachHang.setIcon(img_KhachHang);

        URL image_NhanVien = TrangChu_GUI.class.getResource("/pic/icon/nhanvien.png");
        ImageIcon img_NhanVien = new ImageIcon(image_NhanVien);
        Image scaled_NhanVien = img_NhanVien.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        img_NhanVien = new ImageIcon(scaled_NhanVien);
        lbl_IconNhanVien.setIcon(img_NhanVien);

        URL image_ThongKe = TrangChu_GUI.class.getResource("/pic/icon/thongke.png");
        ImageIcon img_ThongKe = new ImageIcon(image_ThongKe);
        Image scaled_ThongKe = img_ThongKe.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        img_ThongKe = new ImageIcon(scaled_ThongKe);
        lbl_IconThongKe.setIcon(img_ThongKe);

        URL image_NhaCungCap = TrangChu_GUI.class.getResource("/pic/icon/nhacungcap.png");
        ImageIcon img_NhaCungCap = new ImageIcon(image_NhaCungCap);
        Image scaled_NhaCungCap = img_NhaCungCap.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        img_NhaCungCap = new ImageIcon(scaled_NhaCungCap);
        lbl_IconNhaCungCap.setIcon(img_NhaCungCap);

        URL image_PhieuNhap = TrangChu_GUI.class.getResource("/pic/icon/phieunhap.png");
        ImageIcon img_PhieuNhap = new ImageIcon(image_PhieuNhap);
        Image scaled_PhieuNhap = img_PhieuNhap.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        img_PhieuNhap = new ImageIcon(scaled_PhieuNhap);
        lbl_IconPhieuNhap.setIcon(img_PhieuNhap);

        URL image_KhuyenMai = TrangChu_GUI.class.getResource("/pic/icon/discount.png");
        ImageIcon img_KhuyenMai = new ImageIcon(image_KhuyenMai);
        Image scaled_KhuyenMai = img_KhuyenMai.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        img_KhuyenMai = new ImageIcon(scaled_KhuyenMai);
        lbl_IconKhuyenMai.setIcon(img_KhuyenMai);

        URL image_TaiKhoan = TrangChu_GUI.class.getResource("/pic/icon/taikhoan.png");
        ImageIcon img_TaiKhoan = new ImageIcon(image_TaiKhoan);
        Image scaled_TaiKhoan = img_TaiKhoan.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        img_TaiKhoan = new ImageIcon(scaled_TaiKhoan);
        lbl_IconTaiKhoan.setIcon(img_TaiKhoan);

        URL image_DangXuat = TrangChu_GUI.class.getResource("/pic/icon/logout.png");
        ImageIcon img_DangXuat = new ImageIcon(image_DangXuat);
        Image scaled_DangXuat = img_DangXuat.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        img_DangXuat = new ImageIcon(scaled_DangXuat);
        JMenu_DangXuat.setIcon(img_DangXuat);

        URL image_ThayMatKhau = TrangChu_GUI.class.getResource("/pic/icon/key.png");
        ImageIcon img_ThayMatKhau = new ImageIcon(image_ThayMatKhau);
        Image scaled_ThayMatKhau = img_ThayMatKhau.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        img_ThayMatKhau = new ImageIcon(scaled_ThayMatKhau);
        JMenu_ThayMatKhau.setIcon(img_ThayMatKhau);

        URL image_GioiThieu = TrangChu_GUI.class.getResource("/pic/icon/gioithieu.png");
        ImageIcon img_GioiThieu = new ImageIcon(image_GioiThieu);
        Image scaled_GioiThieu = img_GioiThieu.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        img_GioiThieu = new ImageIcon(scaled_GioiThieu);
        JMenu_GioiThieu.setIcon(img_GioiThieu);

        URL image_TroGiup = TrangChu_GUI.class.getResource("/pic/icon/trogiup.png");
        ImageIcon img_TroGiup = new ImageIcon(image_TroGiup);
        Image scaled_TroGiup = img_TroGiup.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        img_TroGiup = new ImageIcon(scaled_TroGiup);
        JMenu_TroGiup.setIcon(img_TroGiup);

        // Thêm Panel và Main
//        Jpanel_Main.add(TrangChu_Panel);
        Jpanel_Main.add(BanHang_Panel);
        Jpanel_Main.add(SanPham_Panel);
        Jpanel_Main.add(HoaDon_Panel);
        Jpanel_Main.add(DoiTra_Panel);
        Jpanel_Main.add(ThongKe_Panel);
        Jpanel_Main.add(KhachHang_Panel);
        Jpanel_Main.add(NhanVien_Panel);
        Jpanel_Main.add(NhaCungCap_Panel);
        Jpanel_Main.add(PhieuNhap_Panel);
        Jpanel_Main.add(KhuyenMai_Panel);
        Jpanel_Main.add(TaiKhoan_Panel);
        // Gán panleTrangChu background
        Jpanel_TrangChu.setBackground(new Color(112, 128, 144));
        // Gán sự kiện click Jpanel
        Jpanel_TrangChu.addMouseListener(new PanelButtonMouseAdapter(Jpanel_TrangChu) {
            @Override
            public void mouseClicked(MouseEvent e) {
                Jpanel_BanHang.setBackground(new Color(0, 51, 51));
                Jpanel_DoiTra.setBackground(new Color(0, 51, 51));
                Jpanel_KhachHang.setBackground(new Color(0, 51, 51));
                Jpanel_KhuyenMai.setBackground(new Color(0, 51, 51));
                Jpanel_NhaCungCap.setBackground(new Color(0, 51, 51));
                Jpanel_NhanVien.setBackground(new Color(0, 51, 51));
                Jpanel_PhieuNhap.setBackground(new Color(0, 51, 51));
                Jpanel_SanPham.setBackground(new Color(0, 51, 51));
                Jpanel_TaiKhoan.setBackground(new Color(0, 51, 51));
                Jpanel_ThongKe.setBackground(new Color(0, 51, 51));
                Jpanel_HoaDon.setBackground(new Color(0, 51, 51));
                Jpanel_TrangChu.setBackground(new Color(112, 128, 144));
//                menuClicked(TrangChu_Panel);

            }
        });

        Jpanel_BanHang.addMouseListener(new PanelButtonMouseAdapter(Jpanel_BanHang) {
            @Override
            public void mouseClicked(MouseEvent e) {
                Jpanel_BanHang.setBackground(new Color(112, 128, 144));
                Jpanel_DoiTra.setBackground(new Color(0, 51, 51));
                Jpanel_KhachHang.setBackground(new Color(0, 51, 51));
                Jpanel_KhuyenMai.setBackground(new Color(0, 51, 51));
                Jpanel_NhaCungCap.setBackground(new Color(0, 51, 51));
                Jpanel_NhanVien.setBackground(new Color(0, 51, 51));
                Jpanel_PhieuNhap.setBackground(new Color(0, 51, 51));
                Jpanel_SanPham.setBackground(new Color(0, 51, 51));
                Jpanel_TaiKhoan.setBackground(new Color(0, 51, 51));
                Jpanel_ThongKe.setBackground(new Color(0, 51, 51));
                Jpanel_HoaDon.setBackground(new Color(0, 51, 51));
                Jpanel_TrangChu.setBackground(new Color(0, 51, 51));
                menuClicked(BanHang_Panel);
            }
        });
        Jpanel_DoiTra.addMouseListener(new PanelButtonMouseAdapter(Jpanel_DoiTra) {
            @Override
            public void mouseClicked(MouseEvent e) {
                Jpanel_BanHang.setBackground(new Color(0, 51, 51));
                Jpanel_DoiTra.setBackground(new Color(112, 128, 144));
                Jpanel_KhachHang.setBackground(new Color(0, 51, 51));
                Jpanel_KhuyenMai.setBackground(new Color(0, 51, 51));
                Jpanel_NhaCungCap.setBackground(new Color(0, 51, 51));
                Jpanel_NhanVien.setBackground(new Color(0, 51, 51));
                Jpanel_PhieuNhap.setBackground(new Color(0, 51, 51));
                Jpanel_SanPham.setBackground(new Color(0, 51, 51));
                Jpanel_TaiKhoan.setBackground(new Color(0, 51, 51));
                Jpanel_ThongKe.setBackground(new Color(0, 51, 51));
                Jpanel_HoaDon.setBackground(new Color(0, 51, 51));
                Jpanel_TrangChu.setBackground(new Color(0, 51, 51));
                menuClicked(DoiTra_Panel);
            }
        });

        Jpanel_KhachHang.addMouseListener(new PanelButtonMouseAdapter(Jpanel_KhachHang) {
            @Override
            public void mouseClicked(MouseEvent e) {
                Jpanel_BanHang.setBackground(new Color(0, 51, 51));
                Jpanel_DoiTra.setBackground(new Color(0, 51, 51));
                Jpanel_KhachHang.setBackground(new Color(112, 128, 144));
                Jpanel_KhuyenMai.setBackground(new Color(0, 51, 51));
                Jpanel_NhaCungCap.setBackground(new Color(0, 51, 51));
                Jpanel_NhanVien.setBackground(new Color(0, 51, 51));
                Jpanel_PhieuNhap.setBackground(new Color(0, 51, 51));
                Jpanel_SanPham.setBackground(new Color(0, 51, 51));
                Jpanel_TaiKhoan.setBackground(new Color(0, 51, 51));
                Jpanel_ThongKe.setBackground(new Color(0, 51, 51));
                Jpanel_HoaDon.setBackground(new Color(0, 51, 51));
                Jpanel_TrangChu.setBackground(new Color(0, 51, 51));
                menuClicked(KhachHang_Panel);
            }
        });
        Jpanel_KhuyenMai.addMouseListener(new PanelButtonMouseAdapter(Jpanel_KhuyenMai) {
            @Override
            public void mouseClicked(MouseEvent e) {
                Jpanel_BanHang.setBackground(new Color(0, 51, 51));
                Jpanel_DoiTra.setBackground(new Color(0, 51, 51));
                Jpanel_KhachHang.setBackground(new Color(0, 51, 51));
                Jpanel_KhuyenMai.setBackground(new Color(112, 128, 144));
                Jpanel_NhaCungCap.setBackground(new Color(0, 51, 51));
                Jpanel_NhanVien.setBackground(new Color(0, 51, 51));
                Jpanel_PhieuNhap.setBackground(new Color(0, 51, 51));
                Jpanel_SanPham.setBackground(new Color(0, 51, 51));
                Jpanel_TaiKhoan.setBackground(new Color(0, 51, 51));
                Jpanel_ThongKe.setBackground(new Color(0, 51, 51));
                Jpanel_HoaDon.setBackground(new Color(0, 51, 51));
                Jpanel_TrangChu.setBackground(new Color(0, 51, 51));
                menuClicked(KhuyenMai_Panel);
            }
        });
        Jpanel_NhaCungCap.addMouseListener(new PanelButtonMouseAdapter(Jpanel_NhaCungCap) {
            @Override
            public void mouseClicked(MouseEvent e) {
                Jpanel_BanHang.setBackground(new Color(0, 51, 51));
                Jpanel_DoiTra.setBackground(new Color(0, 51, 51));
                Jpanel_KhachHang.setBackground(new Color(0, 51, 51));
                Jpanel_KhuyenMai.setBackground(new Color(0, 51, 51));
                Jpanel_NhaCungCap.setBackground(new Color(112, 128, 144));
                Jpanel_NhanVien.setBackground(new Color(0, 51, 51));
                Jpanel_PhieuNhap.setBackground(new Color(0, 51, 51));
                Jpanel_SanPham.setBackground(new Color(0, 51, 51));
                Jpanel_TaiKhoan.setBackground(new Color(0, 51, 51));
                Jpanel_ThongKe.setBackground(new Color(0, 51, 51));
                Jpanel_HoaDon.setBackground(new Color(0, 51, 51));
                Jpanel_TrangChu.setBackground(new Color(0, 51, 51));
                menuClicked(NhaCungCap_Panel);
            }
        });
        Jpanel_NhanVien.addMouseListener(new PanelButtonMouseAdapter(Jpanel_NhanVien) {
            @Override
            public void mouseClicked(MouseEvent e) {
                Jpanel_BanHang.setBackground(new Color(0, 51, 51));
                Jpanel_DoiTra.setBackground(new Color(0, 51, 51));
                Jpanel_KhachHang.setBackground(new Color(0, 51, 51));
                Jpanel_KhuyenMai.setBackground(new Color(0, 51, 51));
                Jpanel_NhaCungCap.setBackground(new Color(0, 51, 51));
                Jpanel_NhanVien.setBackground(new Color(112, 128, 144));
                Jpanel_PhieuNhap.setBackground(new Color(0, 51, 51));
                Jpanel_SanPham.setBackground(new Color(0, 51, 51));
                Jpanel_TaiKhoan.setBackground(new Color(0, 51, 51));
                Jpanel_ThongKe.setBackground(new Color(0, 51, 51));
                Jpanel_HoaDon.setBackground(new Color(0, 51, 51));
                Jpanel_TrangChu.setBackground(new Color(0, 51, 51));
                menuClicked(NhanVien_Panel);
            }
        });
        Jpanel_PhieuNhap.addMouseListener(new PanelButtonMouseAdapter(Jpanel_PhieuNhap) {
            @Override
            public void mouseClicked(MouseEvent e) {
                Jpanel_BanHang.setBackground(new Color(0, 51, 51));
                Jpanel_DoiTra.setBackground(new Color(0, 51, 51));
                Jpanel_KhachHang.setBackground(new Color(0, 51, 51));
                Jpanel_KhuyenMai.setBackground(new Color(0, 51, 51));
                Jpanel_NhaCungCap.setBackground(new Color(0, 51, 51));
                Jpanel_NhanVien.setBackground(new Color(0, 51, 51));
                Jpanel_PhieuNhap.setBackground(new Color(112, 128, 144));
                Jpanel_SanPham.setBackground(new Color(0, 51, 51));
                Jpanel_TaiKhoan.setBackground(new Color(0, 51, 51));
                Jpanel_ThongKe.setBackground(new Color(0, 51, 51));
                Jpanel_HoaDon.setBackground(new Color(0, 51, 51));
                Jpanel_TrangChu.setBackground(new Color(0, 51, 51));
                menuClicked(PhieuNhap_Panel);
            }
        });
        Jpanel_SanPham.addMouseListener(new PanelButtonMouseAdapter(Jpanel_SanPham) {
            @Override
            public void mouseClicked(MouseEvent e) {
                Jpanel_BanHang.setBackground(new Color(0, 51, 51));
                Jpanel_DoiTra.setBackground(new Color(0, 51, 51));
                Jpanel_KhachHang.setBackground(new Color(0, 51, 51));
                Jpanel_KhuyenMai.setBackground(new Color(0, 51, 51));
                Jpanel_NhaCungCap.setBackground(new Color(0, 51, 51));
                Jpanel_NhanVien.setBackground(new Color(0, 51, 51));
                Jpanel_PhieuNhap.setBackground(new Color(0, 51, 51));
                Jpanel_SanPham.setBackground(new Color(112, 128, 144));
                Jpanel_TaiKhoan.setBackground(new Color(0, 51, 51));
                Jpanel_ThongKe.setBackground(new Color(0, 51, 51));
                Jpanel_HoaDon.setBackground(new Color(0, 51, 51));
                Jpanel_TrangChu.setBackground(new Color(0, 51, 51));
                menuClicked(SanPham_Panel);
            }
        });
        Jpanel_TaiKhoan.addMouseListener(new PanelButtonMouseAdapter(Jpanel_TaiKhoan) {
            @Override
            public void mouseClicked(MouseEvent e) {
                Jpanel_BanHang.setBackground(new Color(0, 51, 51));
                Jpanel_DoiTra.setBackground(new Color(0, 51, 51));
                Jpanel_KhachHang.setBackground(new Color(0, 51, 51));
                Jpanel_KhuyenMai.setBackground(new Color(0, 51, 51));
                Jpanel_NhaCungCap.setBackground(new Color(0, 51, 51));
                Jpanel_NhanVien.setBackground(new Color(0, 51, 51));
                Jpanel_PhieuNhap.setBackground(new Color(0, 51, 51));
                Jpanel_SanPham.setBackground(new Color(0, 51, 51));
                Jpanel_TaiKhoan.setBackground(new Color(112, 128, 144));
                Jpanel_ThongKe.setBackground(new Color(0, 51, 51));
                Jpanel_HoaDon.setBackground(new Color(0, 51, 51));
                Jpanel_TrangChu.setBackground(new Color(0, 51, 51));
                menuClicked(TaiKhoan_Panel);
            }
        });
        Jpanel_ThongKe.addMouseListener(new PanelButtonMouseAdapter(Jpanel_ThongKe) {
            @Override
            public void mouseClicked(MouseEvent e) {
                Jpanel_BanHang.setBackground(new Color(0, 51, 51));
                Jpanel_DoiTra.setBackground(new Color(0, 51, 51));
                Jpanel_KhachHang.setBackground(new Color(0, 51, 51));
                Jpanel_KhuyenMai.setBackground(new Color(0, 51, 51));
                Jpanel_NhaCungCap.setBackground(new Color(0, 51, 51));
                Jpanel_NhanVien.setBackground(new Color(0, 51, 51));
                Jpanel_PhieuNhap.setBackground(new Color(0, 51, 51));
                Jpanel_SanPham.setBackground(new Color(0, 51, 51));
                Jpanel_TaiKhoan.setBackground(new Color(0, 51, 51));
                Jpanel_ThongKe.setBackground(new Color(112, 128, 144));
                Jpanel_HoaDon.setBackground(new Color(0, 51, 51));
                Jpanel_TrangChu.setBackground(new Color(0, 51, 51));
                menuClicked(ThongKe_Panel);
            }
        });
        Jpanel_HoaDon.addMouseListener(new PanelButtonMouseAdapter(Jpanel_HoaDon) {
            @Override
            public void mouseClicked(MouseEvent e) {
                Jpanel_BanHang.setBackground(new Color(0, 51, 51));
                Jpanel_DoiTra.setBackground(new Color(0, 51, 51));
                Jpanel_KhachHang.setBackground(new Color(0, 51, 51));
                Jpanel_KhuyenMai.setBackground(new Color(0, 51, 51));
                Jpanel_NhaCungCap.setBackground(new Color(0, 51, 51));
                Jpanel_NhanVien.setBackground(new Color(0, 51, 51));
                Jpanel_PhieuNhap.setBackground(new Color(0, 51, 51));
                Jpanel_SanPham.setBackground(new Color(0, 51, 51));
                Jpanel_TaiKhoan.setBackground(new Color(0, 51, 51));
                Jpanel_ThongKe.setBackground(new Color(0, 51, 51));
                Jpanel_HoaDon.setBackground(new Color(112, 128, 144));
                Jpanel_TrangChu.setBackground(new Color(0, 51, 51));
                menuClicked(HoaDon_Panel);
            }
        });

        // MenuBar
        jMenuBar1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        // Tạo AcTion để xử lý sự kiện cho phím O
        Action dangXuatAction = new AbstractAction("Đăng Xuất") {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        };

        // Gán Phím Crtl + O cho action này
        dangXuatAction.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_MASK));
        JMenuItem_An.setAction(dangXuatAction);
        JMenuItem_An.setPreferredSize(new java.awt.Dimension(0, 0));
        JMenu_DangXuat.setToolTipText("Ctrl+0");
        JMenu_DangXuat.setAccelerator(null);

        // Tạo và cấu hình timer
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lấy thời gian hiện tại
                Date now = new Date();

                // Định dạng thời gian
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                String formattedDate = dateFormat.format(now);

                // Đặt thời gian đã định dạng vào JLabel
                JMenu_Time.setText(formattedDate);
            }
        });
        timer.start();

//        menuClicked(TrangChu_Panel);

    }

    public void menuClicked(JPanel panel) {

//        TrangChu_Panel.setVisible(false);
        BanHang_Panel.setVisible(false);
        SanPham_Panel.setVisible(false);
        HoaDon_Panel.setVisible(false);
        KhachHang_Panel.setVisible(false);
        DoiTra_Panel.setVisible(false);
        ThongKe_Panel.setVisible(false);
        NhanVien_Panel.setVisible(false);
        NhaCungCap_Panel.setVisible(false);
        PhieuNhap_Panel.setVisible(false);
        KhuyenMai_Panel.setVisible(false);
        TaiKhoan_Panel.setVisible(false);

        panel.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
	// Generated using JFormDesigner Evaluation license - locser
	private void initComponents() {
		jMenuBar1 = new JMenuBar();
		jMenu1 = new JMenu();
		JMenu_ThayMatKhau = new JMenuItem();
		JMenu_DangXuat = new JMenuItem();
		JMenuItem_An = new JMenuItem();
		jMenu2 = new JMenu();
		JMenu_GioiThieu = new JMenuItem();
		JMenu_TroGiup = new JMenuItem();
		JMenu_Time = new JMenu();
		Jpanel_Menu = new JPanel();
		Jpanel_Users = new JPanel();
		jlb_name = new JLabel();
		lbl_Users = new JLabel();
		lbl_ChucVu = new JLabel();
		Jpanel_TaiKhoan = new JPanel();
		lbl_TaiKhoan = new JLabel();
		lbl_IconTaiKhoan = new JLabel();
		Jpanel_KhuyenMai = new JPanel();
		lbl_KhuyenMai = new JLabel();
		lbl_IconKhuyenMai = new JLabel();
		Jpanel_PhieuNhap = new JPanel();
		lbl_PhieuNhap = new JLabel();
		lbl_IconPhieuNhap = new JLabel();
		Jpanel_NhaCungCap = new JPanel();
		lbl_NhaCungCap = new JLabel();
		lbl_IconNhaCungCap = new JLabel();
		Jpanel_NhanVien = new JPanel();
		lbl_NhanVien = new JLabel();
		lbl_IconNhanVien = new JLabel();
		Jpanel_ThongKe = new JPanel();
		lbl_ThongKe = new JLabel();
		lbl_IconThongKe = new JLabel();
		Jpanel_DoiTra = new JPanel();
		lbl_DoiTra = new JLabel();
		lbl_IconDoiTra = new JLabel();
		Jpanel_SanPham = new JPanel();
		lbl_SanPham = new JLabel();
		lbl_IconSanPham = new JLabel();
		Jpanel_BanHang = new JPanel();
		lbl_BanHang = new JLabel();
		lbl_IconBanHang = new JLabel();
		Jpanel_TrangChu = new JPanel();
		lbl_TrangChu = new JLabel();
		lbl_IconTrangChu = new JLabel();
		Jpanel_HoaDon = new JPanel();
		lbl_IconHoaDon = new JLabel();
		jLabel3 = new JLabel();
		Jpanel_KhachHang = new JPanel();
		lbl_IconKhachHang = new JLabel();
		lbl_KhachHang = new JLabel();
		Jpanel_Time = new JPanel();
		Jpanel_Main = new JPanel();

		//======== this ========
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(1200, 720));
		setUndecorated(true);
		Container contentPane = getContentPane();
		contentPane.setLayout(null);

		//======== jMenuBar1 ========
		{

			//======== jMenu1 ========
			{
				jMenu1.setText("H\u1ec7 Th\u1ed1ng");

				//---- JMenu_ThayMatKhau ----
				JMenu_ThayMatKhau.setText("Thay M\u1eadt Kh\u1ea9u");
				JMenu_ThayMatKhau.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						JMenu_ThayMatKhauMouseClicked(e);
					}
				});
				JMenu_ThayMatKhau.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JMenu_ThayMatKhauActionPerformed(e);
					}
				});
				jMenu1.add(JMenu_ThayMatKhau);

				//---- JMenu_DangXuat ----
				JMenu_DangXuat.setText("\u0110\u0103ng Xu\u1ea5t");
				JMenu_DangXuat.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						JMenu_DangXuatMouseClicked(e);
					}
				});
				JMenu_DangXuat.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JMenu_DangXuatActionPerformed(e);
					}
				});
				jMenu1.add(JMenu_DangXuat);

				//---- JMenuItem_An ----
				JMenuItem_An.setText("keyDangXuat");
				jMenu1.add(JMenuItem_An);
			}
			jMenuBar1.add(jMenu1);

			//======== jMenu2 ========
			{
				jMenu2.setText("Tr\u1ee3 Gi\u00fap");
				jMenu2.setMargin(new Insets(3, 6, 3, 8));

				//---- JMenu_GioiThieu ----
				JMenu_GioiThieu.setText("Gi\u1edbi Thi\u1ec7u");
				JMenu_GioiThieu.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JMenu_GioiThieuActionPerformed(e);
					}
				});
				jMenu2.add(JMenu_GioiThieu);

				//---- JMenu_TroGiup ----
				JMenu_TroGiup.setText("Tr\u1ee3 Gi\u00fap");
				JMenu_TroGiup.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JMenu_TroGiupActionPerformed(e);
					}
				});
				jMenu2.add(JMenu_TroGiup);
			}
			jMenuBar1.add(jMenu2);

			//======== JMenu_Time ========
			{
				JMenu_Time.setText("Time");
			}
			jMenuBar1.add(JMenu_Time);
		}
		setJMenuBar(jMenuBar1);

		//======== Jpanel_Menu ========
		{
			Jpanel_Menu.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new
			javax.swing.border.EmptyBorder(0,0,0,0), "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn",javax
			.swing.border.TitledBorder.CENTER,javax.swing.border.TitledBorder.BOTTOM,new java
			.awt.Font("Dia\u006cog",java.awt.Font.BOLD,12),java.awt
			.Color.red),Jpanel_Menu. getBorder()));Jpanel_Menu. addPropertyChangeListener(new java.beans.
			PropertyChangeListener(){ public void propertyChange(java.beans.PropertyChangeEvent e){if("b\u006frde\u0072".
			equals(e.getPropertyName()))throw new RuntimeException();}});
			Jpanel_Menu.setLayout(null);

			//======== Jpanel_Users ========
			{
				Jpanel_Users.setBorder(new MatteBorder(0, 0, 2, 0, Color.white));
				Jpanel_Users.setLayout(null);

				//---- jlb_name ----
				jlb_name.setHorizontalAlignment(SwingConstants.CENTER);
				jlb_name.setText("\u0110inh Nguy\u00ean Chung");
				Jpanel_Users.add(jlb_name);
				jlb_name.setBounds(0, 40, 180, 30);
				Jpanel_Users.add(lbl_Users);
				lbl_Users.setBounds(10, 10, 30, 30);

				//---- lbl_ChucVu ----
				lbl_ChucVu.setText("Qu\u1ea3n L\u00fd");
				Jpanel_Users.add(lbl_ChucVu);
				lbl_ChucVu.setBounds(60, 10, 110, 30);

				{
					// compute preferred size
					Dimension preferredSize = new Dimension();
					for(int i = 0; i < Jpanel_Users.getComponentCount(); i++) {
						Rectangle bounds = Jpanel_Users.getComponent(i).getBounds();
						preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
						preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
					}
					Insets insets = Jpanel_Users.getInsets();
					preferredSize.width += insets.right;
					preferredSize.height += insets.bottom;
					Jpanel_Users.setMinimumSize(preferredSize);
					Jpanel_Users.setPreferredSize(preferredSize);
				}
			}
			Jpanel_Menu.add(Jpanel_Users);
			Jpanel_Users.setBounds(0, 0, 180, 80);

			//======== Jpanel_TaiKhoan ========
			{
				Jpanel_TaiKhoan.setLayout(null);

				//---- lbl_TaiKhoan ----
				lbl_TaiKhoan.setText("T\u00e0i Kho\u1ea3n");
				Jpanel_TaiKhoan.add(lbl_TaiKhoan);
				lbl_TaiKhoan.setBounds(70, 10, 100, 29);
				Jpanel_TaiKhoan.add(lbl_IconTaiKhoan);
				lbl_IconTaiKhoan.setBounds(20, 10, 30, 30);

				{
					// compute preferred size
					Dimension preferredSize = new Dimension();
					for(int i = 0; i < Jpanel_TaiKhoan.getComponentCount(); i++) {
						Rectangle bounds = Jpanel_TaiKhoan.getComponent(i).getBounds();
						preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
						preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
					}
					Insets insets = Jpanel_TaiKhoan.getInsets();
					preferredSize.width += insets.right;
					preferredSize.height += insets.bottom;
					Jpanel_TaiKhoan.setMinimumSize(preferredSize);
					Jpanel_TaiKhoan.setPreferredSize(preferredSize);
				}
			}
			Jpanel_Menu.add(Jpanel_TaiKhoan);
			Jpanel_TaiKhoan.setBounds(0, 630, 180, 50);

			//======== Jpanel_KhuyenMai ========
			{
				Jpanel_KhuyenMai.setLayout(null);

				//---- lbl_KhuyenMai ----
				lbl_KhuyenMai.setText("Khuy\u1ebfn M\u00e3i");
				Jpanel_KhuyenMai.add(lbl_KhuyenMai);
				lbl_KhuyenMai.setBounds(70, 10, 100, 29);
				Jpanel_KhuyenMai.add(lbl_IconKhuyenMai);
				lbl_IconKhuyenMai.setBounds(20, 10, 30, 30);

				{
					// compute preferred size
					Dimension preferredSize = new Dimension();
					for(int i = 0; i < Jpanel_KhuyenMai.getComponentCount(); i++) {
						Rectangle bounds = Jpanel_KhuyenMai.getComponent(i).getBounds();
						preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
						preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
					}
					Insets insets = Jpanel_KhuyenMai.getInsets();
					preferredSize.width += insets.right;
					preferredSize.height += insets.bottom;
					Jpanel_KhuyenMai.setMinimumSize(preferredSize);
					Jpanel_KhuyenMai.setPreferredSize(preferredSize);
				}
			}
			Jpanel_Menu.add(Jpanel_KhuyenMai);
			Jpanel_KhuyenMai.setBounds(0, 580, 180, 50);

			//======== Jpanel_PhieuNhap ========
			{
				Jpanel_PhieuNhap.setLayout(null);

				//---- lbl_PhieuNhap ----
				lbl_PhieuNhap.setText("Phi\u1ebfu Nh\u1eadp");
				Jpanel_PhieuNhap.add(lbl_PhieuNhap);
				lbl_PhieuNhap.setBounds(70, 10, 100, 29);
				Jpanel_PhieuNhap.add(lbl_IconPhieuNhap);
				lbl_IconPhieuNhap.setBounds(20, 10, 30, 30);

				{
					// compute preferred size
					Dimension preferredSize = new Dimension();
					for(int i = 0; i < Jpanel_PhieuNhap.getComponentCount(); i++) {
						Rectangle bounds = Jpanel_PhieuNhap.getComponent(i).getBounds();
						preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
						preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
					}
					Insets insets = Jpanel_PhieuNhap.getInsets();
					preferredSize.width += insets.right;
					preferredSize.height += insets.bottom;
					Jpanel_PhieuNhap.setMinimumSize(preferredSize);
					Jpanel_PhieuNhap.setPreferredSize(preferredSize);
				}
			}
			Jpanel_Menu.add(Jpanel_PhieuNhap);
			Jpanel_PhieuNhap.setBounds(0, 530, 180, 50);

			//======== Jpanel_NhaCungCap ========
			{
				Jpanel_NhaCungCap.setLayout(null);

				//---- lbl_NhaCungCap ----
				lbl_NhaCungCap.setText("Nh\u00e0 Cung C\u1ea5p");
				Jpanel_NhaCungCap.add(lbl_NhaCungCap);
				lbl_NhaCungCap.setBounds(70, 10, 100, 29);
				Jpanel_NhaCungCap.add(lbl_IconNhaCungCap);
				lbl_IconNhaCungCap.setBounds(20, 10, 30, 30);

				{
					// compute preferred size
					Dimension preferredSize = new Dimension();
					for(int i = 0; i < Jpanel_NhaCungCap.getComponentCount(); i++) {
						Rectangle bounds = Jpanel_NhaCungCap.getComponent(i).getBounds();
						preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
						preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
					}
					Insets insets = Jpanel_NhaCungCap.getInsets();
					preferredSize.width += insets.right;
					preferredSize.height += insets.bottom;
					Jpanel_NhaCungCap.setMinimumSize(preferredSize);
					Jpanel_NhaCungCap.setPreferredSize(preferredSize);
				}
			}
			Jpanel_Menu.add(Jpanel_NhaCungCap);
			Jpanel_NhaCungCap.setBounds(0, 480, 180, 50);

			//======== Jpanel_NhanVien ========
			{
				Jpanel_NhanVien.setLayout(null);

				//---- lbl_NhanVien ----
				lbl_NhanVien.setText("Nh\u00e2n Vi\u00ean");
				Jpanel_NhanVien.add(lbl_NhanVien);
				lbl_NhanVien.setBounds(70, 10, 100, 29);
				Jpanel_NhanVien.add(lbl_IconNhanVien);
				lbl_IconNhanVien.setBounds(20, 10, 30, 30);

				{
					// compute preferred size
					Dimension preferredSize = new Dimension();
					for(int i = 0; i < Jpanel_NhanVien.getComponentCount(); i++) {
						Rectangle bounds = Jpanel_NhanVien.getComponent(i).getBounds();
						preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
						preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
					}
					Insets insets = Jpanel_NhanVien.getInsets();
					preferredSize.width += insets.right;
					preferredSize.height += insets.bottom;
					Jpanel_NhanVien.setMinimumSize(preferredSize);
					Jpanel_NhanVien.setPreferredSize(preferredSize);
				}
			}
			Jpanel_Menu.add(Jpanel_NhanVien);
			Jpanel_NhanVien.setBounds(0, 430, 180, 50);

			//======== Jpanel_ThongKe ========
			{
				Jpanel_ThongKe.setLayout(null);

				//---- lbl_ThongKe ----
				lbl_ThongKe.setText("Th\u1ed1ng K\u00ea");
				Jpanel_ThongKe.add(lbl_ThongKe);
				lbl_ThongKe.setBounds(70, 10, 100, 29);
				Jpanel_ThongKe.add(lbl_IconThongKe);
				lbl_IconThongKe.setBounds(20, 10, 30, 30);

				{
					// compute preferred size
					Dimension preferredSize = new Dimension();
					for(int i = 0; i < Jpanel_ThongKe.getComponentCount(); i++) {
						Rectangle bounds = Jpanel_ThongKe.getComponent(i).getBounds();
						preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
						preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
					}
					Insets insets = Jpanel_ThongKe.getInsets();
					preferredSize.width += insets.right;
					preferredSize.height += insets.bottom;
					Jpanel_ThongKe.setMinimumSize(preferredSize);
					Jpanel_ThongKe.setPreferredSize(preferredSize);
				}
			}
			Jpanel_Menu.add(Jpanel_ThongKe);
			Jpanel_ThongKe.setBounds(0, 380, 180, 50);

			//======== Jpanel_DoiTra ========
			{
				Jpanel_DoiTra.setLayout(null);

				//---- lbl_DoiTra ----
				lbl_DoiTra.setText("\u0110\u1ed5i Tr\u1ea3");
				Jpanel_DoiTra.add(lbl_DoiTra);
				lbl_DoiTra.setBounds(70, 10, 100, 29);
				Jpanel_DoiTra.add(lbl_IconDoiTra);
				lbl_IconDoiTra.setBounds(20, 10, 30, 30);

				{
					// compute preferred size
					Dimension preferredSize = new Dimension();
					for(int i = 0; i < Jpanel_DoiTra.getComponentCount(); i++) {
						Rectangle bounds = Jpanel_DoiTra.getComponent(i).getBounds();
						preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
						preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
					}
					Insets insets = Jpanel_DoiTra.getInsets();
					preferredSize.width += insets.right;
					preferredSize.height += insets.bottom;
					Jpanel_DoiTra.setMinimumSize(preferredSize);
					Jpanel_DoiTra.setPreferredSize(preferredSize);
				}
			}
			Jpanel_Menu.add(Jpanel_DoiTra);
			Jpanel_DoiTra.setBounds(0, 330, 180, 50);

			//======== Jpanel_SanPham ========
			{
				Jpanel_SanPham.setLayout(null);

				//---- lbl_SanPham ----
				lbl_SanPham.setText("S\u1ea3n Ph\u1ea9m");
				Jpanel_SanPham.add(lbl_SanPham);
				lbl_SanPham.setBounds(70, 10, 100, 29);
				Jpanel_SanPham.add(lbl_IconSanPham);
				lbl_IconSanPham.setBounds(20, 10, 30, 30);

				{
					// compute preferred size
					Dimension preferredSize = new Dimension();
					for(int i = 0; i < Jpanel_SanPham.getComponentCount(); i++) {
						Rectangle bounds = Jpanel_SanPham.getComponent(i).getBounds();
						preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
						preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
					}
					Insets insets = Jpanel_SanPham.getInsets();
					preferredSize.width += insets.right;
					preferredSize.height += insets.bottom;
					Jpanel_SanPham.setMinimumSize(preferredSize);
					Jpanel_SanPham.setPreferredSize(preferredSize);
				}
			}
			Jpanel_Menu.add(Jpanel_SanPham);
			Jpanel_SanPham.setBounds(0, 180, 180, 50);

			//======== Jpanel_BanHang ========
			{
				Jpanel_BanHang.setLayout(null);

				//---- lbl_BanHang ----
				lbl_BanHang.setText("B\u00e1n H\u00e0ng");
				Jpanel_BanHang.add(lbl_BanHang);
				lbl_BanHang.setBounds(70, 10, 100, 29);
				Jpanel_BanHang.add(lbl_IconBanHang);
				lbl_IconBanHang.setBounds(20, 10, 30, 30);

				{
					// compute preferred size
					Dimension preferredSize = new Dimension();
					for(int i = 0; i < Jpanel_BanHang.getComponentCount(); i++) {
						Rectangle bounds = Jpanel_BanHang.getComponent(i).getBounds();
						preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
						preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
					}
					Insets insets = Jpanel_BanHang.getInsets();
					preferredSize.width += insets.right;
					preferredSize.height += insets.bottom;
					Jpanel_BanHang.setMinimumSize(preferredSize);
					Jpanel_BanHang.setPreferredSize(preferredSize);
				}
			}
			Jpanel_Menu.add(Jpanel_BanHang);
			Jpanel_BanHang.setBounds(0, 130, 180, 50);

			//======== Jpanel_TrangChu ========
			{
				Jpanel_TrangChu.setLayout(null);

				//---- lbl_TrangChu ----
				lbl_TrangChu.setText("Trang Ch\u1ee7");
				Jpanel_TrangChu.add(lbl_TrangChu);
				lbl_TrangChu.setBounds(70, 10, 100, 29);
				Jpanel_TrangChu.add(lbl_IconTrangChu);
				lbl_IconTrangChu.setBounds(20, 10, 30, 30);

				{
					// compute preferred size
					Dimension preferredSize = new Dimension();
					for(int i = 0; i < Jpanel_TrangChu.getComponentCount(); i++) {
						Rectangle bounds = Jpanel_TrangChu.getComponent(i).getBounds();
						preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
						preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
					}
					Insets insets = Jpanel_TrangChu.getInsets();
					preferredSize.width += insets.right;
					preferredSize.height += insets.bottom;
					Jpanel_TrangChu.setMinimumSize(preferredSize);
					Jpanel_TrangChu.setPreferredSize(preferredSize);
				}
			}
			Jpanel_Menu.add(Jpanel_TrangChu);
			Jpanel_TrangChu.setBounds(0, 80, 180, 50);

			//======== Jpanel_HoaDon ========
			{
				Jpanel_HoaDon.setLayout(null);
				Jpanel_HoaDon.add(lbl_IconHoaDon);
				lbl_IconHoaDon.setBounds(20, 10, 30, 30);

				//---- jLabel3 ----
				jLabel3.setText("H\u00f3a \u0110\u01a1n");
				Jpanel_HoaDon.add(jLabel3);
				jLabel3.setBounds(70, 10, 100, 29);

				{
					// compute preferred size
					Dimension preferredSize = new Dimension();
					for(int i = 0; i < Jpanel_HoaDon.getComponentCount(); i++) {
						Rectangle bounds = Jpanel_HoaDon.getComponent(i).getBounds();
						preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
						preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
					}
					Insets insets = Jpanel_HoaDon.getInsets();
					preferredSize.width += insets.right;
					preferredSize.height += insets.bottom;
					Jpanel_HoaDon.setMinimumSize(preferredSize);
					Jpanel_HoaDon.setPreferredSize(preferredSize);
				}
			}
			Jpanel_Menu.add(Jpanel_HoaDon);
			Jpanel_HoaDon.setBounds(0, 230, 180, 50);

			//======== Jpanel_KhachHang ========
			{
				Jpanel_KhachHang.setLayout(null);
				Jpanel_KhachHang.add(lbl_IconKhachHang);
				lbl_IconKhachHang.setBounds(20, 10, 30, 30);

				//---- lbl_KhachHang ----
				lbl_KhachHang.setText("Kh\u00e1ch H\u00e0ng");
				Jpanel_KhachHang.add(lbl_KhachHang);
				lbl_KhachHang.setBounds(70, 10, 100, 29);

				{
					// compute preferred size
					Dimension preferredSize = new Dimension();
					for(int i = 0; i < Jpanel_KhachHang.getComponentCount(); i++) {
						Rectangle bounds = Jpanel_KhachHang.getComponent(i).getBounds();
						preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
						preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
					}
					Insets insets = Jpanel_KhachHang.getInsets();
					preferredSize.width += insets.right;
					preferredSize.height += insets.bottom;
					Jpanel_KhachHang.setMinimumSize(preferredSize);
					Jpanel_KhachHang.setPreferredSize(preferredSize);
				}
			}
			Jpanel_Menu.add(Jpanel_KhachHang);
			Jpanel_KhachHang.setBounds(0, 280, 180, 50);

			//======== Jpanel_Time ========
			{

				GroupLayout Jpanel_TimeLayout = new GroupLayout(Jpanel_Time);
				Jpanel_Time.setLayout(Jpanel_TimeLayout);
				Jpanel_TimeLayout.setHorizontalGroup(
					Jpanel_TimeLayout.createParallelGroup()
						.add(0, 180, Short.MAX_VALUE)
				);
				Jpanel_TimeLayout.setVerticalGroup(
					Jpanel_TimeLayout.createParallelGroup()
						.add(0, 18, Short.MAX_VALUE)
				);
			}
			Jpanel_Menu.add(Jpanel_Time);
			Jpanel_Time.setBounds(0, 680, 180, 18);

			{
				// compute preferred size
				Dimension preferredSize = new Dimension();
				for(int i = 0; i < Jpanel_Menu.getComponentCount(); i++) {
					Rectangle bounds = Jpanel_Menu.getComponent(i).getBounds();
					preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
					preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
				}
				Insets insets = Jpanel_Menu.getInsets();
				preferredSize.width += insets.right;
				preferredSize.height += insets.bottom;
				Jpanel_Menu.setMinimumSize(preferredSize);
				Jpanel_Menu.setPreferredSize(preferredSize);
			}
		}
		contentPane.add(Jpanel_Menu);
		Jpanel_Menu.setBounds(0, 0, 180, 750);

		//======== Jpanel_Main ========
		{

			GroupLayout Jpanel_MainLayout = new GroupLayout(Jpanel_Main);
			Jpanel_Main.setLayout(Jpanel_MainLayout);
			Jpanel_MainLayout.setHorizontalGroup(
				Jpanel_MainLayout.createParallelGroup()
					.add(0, 0, Short.MAX_VALUE)
			);
			Jpanel_MainLayout.setVerticalGroup(
				Jpanel_MainLayout.createParallelGroup()
					.add(0, 750, Short.MAX_VALUE)
			);
		}
		contentPane.add(Jpanel_Main);
		Jpanel_Main.setBounds(180, 0, 1186, 750);

		{
			// compute preferred size
			Dimension preferredSize = new Dimension();
			for(int i = 0; i < contentPane.getComponentCount(); i++) {
				Rectangle bounds = contentPane.getComponent(i).getBounds();
				preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
				preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
			}
			Insets insets = contentPane.getInsets();
			preferredSize.width += insets.right;
			preferredSize.height += insets.bottom;
			((JComponent)contentPane).setMinimumSize(preferredSize);
			((JComponent)contentPane).setPreferredSize(preferredSize);
		}
		pack();
		setLocationRelativeTo(getOwner());
    }// </editor-fold>//GEN-END:initComponents

    private void JMenu_DangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMenu_DangXuatActionPerformed
        // TODO add your handling code here:
//        DangNhap_GUI dangnhap = new DangNhap_GUI();
        int hoi = JOptionPane.showConfirmDialog(null, "Bạn có chắn muốn đăng xuất ?", "Chú ý !", JOptionPane.YES_NO_OPTION);
        if (hoi == JOptionPane.YES_OPTION) {
//            dangnhap.setVisible(true);
            dispose();
        }

    }//GEN-LAST:event_JMenu_DangXuatActionPerformed

    private void JMenu_DangXuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JMenu_DangXuatMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_JMenu_DangXuatMouseClicked

    private void JMenu_GioiThieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMenu_GioiThieuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JMenu_GioiThieuActionPerformed

    private void JMenu_ThayMatKhauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JMenu_ThayMatKhauMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_JMenu_ThayMatKhauMouseClicked

    private void JMenu_ThayMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMenu_ThayMatKhauActionPerformed
        ThayDoiMatKhau_GUI thayDoiMatKhay_Gui = new ThayDoiMatKhau_GUI();
        thayDoiMatKhay_Gui.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_JMenu_ThayMatKhauActionPerformed

    private void JMenu_TroGiupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMenu_TroGiupActionPerformed

        try {
            System.out.println("Start..");
            File file = new java.io.File("src/HTMLFile/HELPPAGE/main.html").getAbsoluteFile();
            Desktop.getDesktop().open(file);
            System.out.println("End..");
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_JMenu_TroGiupActionPerformed



    private class PanelButtonMouseAdapter extends MouseAdapter {

        JPanel panel;

        public PanelButtonMouseAdapter(JPanel panel) {
            this.panel = panel;
        }

        @Override
        public void mouseEntered(MouseEvent e) {
//			panel.setBackground(new Color(112,128,144));
        }

        @Override
        public void mouseExited(MouseEvent e) {
//            panel.setBackground(new Color(0, 51, 51));
        }

        @Override
        public void mousePressed(MouseEvent e) {
//            panel.setBackground(new Color(60, 179, 113));
        }

        @Override
        public void mouseReleased(MouseEvent e) {
//            panel.setBackground(new Color(112, 128, 144));
//               panel.setBackground(new Color(60, 179, 113));
        }
    }
    //

//    private TrangChu_JPanel TrangChu_Panel;
    private BanHang_JPanel BanHang_Panel;
    private SanPham_JPanel SanPham_Panel;
    private HoaDon_JPanel HoaDon_Panel;
    private DoiTra_JPanel DoiTra_Panel;
    private KhachHang_JPanel KhachHang_Panel;
    private ThongKe_JPanel ThongKe_Panel;
    private NhanVien_JPanel NhanVien_Panel;
    private NhaCungCap_JPanel NhaCungCap_Panel;
    private KhuyenMai_JPanel KhuyenMai_Panel;
    private PhieuNhap_JPanel PhieuNhap_Panel;
    private TaiKhoan_JPanel TaiKhoan_Panel;

    // Variables declaration - do not modify//GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - locser
	private JMenuBar jMenuBar1;
	private JMenu jMenu1;
	private JMenuItem JMenu_ThayMatKhau;
	private JMenuItem JMenu_DangXuat;
	private JMenuItem JMenuItem_An;
	private JMenu jMenu2;
	private JMenuItem JMenu_GioiThieu;
	private JMenuItem JMenu_TroGiup;
	private JMenu JMenu_Time;
	private JPanel Jpanel_Menu;
	private JPanel Jpanel_Users;
	private JLabel jlb_name;
	private JLabel lbl_Users;
	private JLabel lbl_ChucVu;
	private JPanel Jpanel_TaiKhoan;
	private JLabel lbl_TaiKhoan;
	private JLabel lbl_IconTaiKhoan;
	private JPanel Jpanel_KhuyenMai;
	private JLabel lbl_KhuyenMai;
	private JLabel lbl_IconKhuyenMai;
	private JPanel Jpanel_PhieuNhap;
	private JLabel lbl_PhieuNhap;
	private JLabel lbl_IconPhieuNhap;
	private JPanel Jpanel_NhaCungCap;
	private JLabel lbl_NhaCungCap;
	private JLabel lbl_IconNhaCungCap;
	private JPanel Jpanel_NhanVien;
	private JLabel lbl_NhanVien;
	private JLabel lbl_IconNhanVien;
	private JPanel Jpanel_ThongKe;
	private JLabel lbl_ThongKe;
	private JLabel lbl_IconThongKe;
	private JPanel Jpanel_DoiTra;
	private JLabel lbl_DoiTra;
	private JLabel lbl_IconDoiTra;
	private JPanel Jpanel_SanPham;
	private JLabel lbl_SanPham;
	private JLabel lbl_IconSanPham;
	private JPanel Jpanel_BanHang;
	private JLabel lbl_BanHang;
	private JLabel lbl_IconBanHang;
	private JPanel Jpanel_TrangChu;
	private JLabel lbl_TrangChu;
	private JLabel lbl_IconTrangChu;
	private JPanel Jpanel_HoaDon;
	private JLabel lbl_IconHoaDon;
	private JLabel jLabel3;
	private JPanel Jpanel_KhachHang;
	private JLabel lbl_IconKhachHang;
	private JLabel lbl_KhachHang;
	private JPanel Jpanel_Time;
	private JPanel Jpanel_Main;
    // End of variables declaration//GEN-END:variables
}
