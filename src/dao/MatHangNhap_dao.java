/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Interface.MatHangNhap_Interface;
import connectDB.ConnectDB;
import entity.MatHangNhapEntity;
import entity.NhaCungCapEntity;
import entity.SanPhamEntity;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.time.LocalDate;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tran Hien Vinh
 */
public class MatHangNhap_dao implements MatHangNhap_Interface {

    @Override
    public ArrayList<MatHangNhapEntity> getAllMatHangNhap() {
        ArrayList<MatHangNhapEntity> dsMHN = new ArrayList<MatHangNhapEntity>();
        try {
            ConnectDB.getInstance().connect();
            Connection con = ConnectDB.getConnection();
            PreparedStatement ps = null;
            String sql = "select * from MatHangNhap";
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String maMHN = rs.getString("maMHN");
                String maNCC = rs.getString("maNCC");
                String maSP = rs.getString("maSP");
                int soLuongNhap = rs.getInt("soLuongNhap");
                LocalDate ngayNhap = LocalDate.parse(rs.getString("ngayNhap"));
                NhaCungCapEntity ncc = new NhaCungCapEntity(maNCC);
                SanPhamEntity sp = new SanPhamEntity(maSP);
                MatHangNhapEntity mhn = new MatHangNhapEntity(maMHN, ncc, sp, soLuongNhap, ngayNhap);
                dsMHN.add(mhn);
            }
            ps.close();
            rs.close();
            ConnectDB.getInstance().disconnect();
        } catch (Exception ex) {
            Logger.getLogger(NhaCungCap_dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsMHN;
    }

    @Override
    public boolean nhapHang(MatHangNhapEntity mhn) {
        try {
            ConnectDB.getInstance().connect();
            Connection con = ConnectDB.getConnection();
            PreparedStatement ps = null;
            String sql = "Insert into MatHangNhap(maMHN,maNCC,maSP,soLuongNhap,ngayNhap) values(?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, mhn.getMaMHN());
            ps.setString(2, mhn.getNhaCungCap().getMaNCC());
            ps.setString(3, mhn.getSanPham().getMaSP());
            ps.setInt(4, mhn.getSoLuongNhap());
            ps.setDate(5, Date.valueOf(mhn.getNgayNhap()));
            int check = ps.executeUpdate();
            ps.close();
            ConnectDB.getInstance().disconnect();
            return check > 0;
        } catch (Exception ex) {
            Logger.getLogger(NhaCungCap_dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public ArrayList<MatHangNhapEntity> timKiemMHN(LocalDate ngayNhap) {
        ArrayList<MatHangNhapEntity> dsMHN = new ArrayList<MatHangNhapEntity>();
        try {
            ConnectDB.getInstance().connect();
            Connection con = ConnectDB.getConnection();
            PreparedStatement ps = null;
            String sql = "select * from MatHangNhap where ngayNhap=?";
            try {
                ps = con.prepareStatement(sql);
                ps.setDate(1, Date.valueOf(ngayNhap));
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    String maMHN = rs.getString("maMHN");
                    NhaCungCapEntity ncc = new NhaCungCapEntity(rs.getString("maNCC"));
                    SanPhamEntity sp = new SanPhamEntity(rs.getString("maSP"));
                    int soLuongNhap = rs.getInt("soLuongNhap");
                    Date ngayNhap_Date = rs.getDate("ngayNhap");
                    LocalDate ngayNhap_LocalDate = ngayNhap_Date.toLocalDate();
                    MatHangNhapEntity mhn = new MatHangNhapEntity(maMHN, ncc, sp, soLuongNhap, ngayNhap);
                    dsMHN.add(mhn);
                }
                ps.close();
                rs.close();
                ConnectDB.getInstance().disconnect();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (Exception ex) {
            Logger.getLogger(NhaCungCap_dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsMHN;
    }

    @Override
    public boolean capNhapMatHangNhap(MatHangNhapEntity mhn) {
        try {
            ConnectDB.getInstance().connect();
            Connection con = ConnectDB.getConnection();
            PreparedStatement ps = null;
            String sql = "update MatHangNhap set maNCC=?, soLuongNhap=?, ngayNhap=? where maMHN=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, mhn.getNhaCungCap().getMaNCC());
            ps.setInt(2, mhn.getSoLuongNhap());
            ps.setDate(3, Date.valueOf(mhn.getNgayNhap()));
            ps.setString(4, mhn.getMaMHN());
            ps.executeUpdate();
            ps.close();
            ConnectDB.getInstance().disconnect();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(NhaCungCap_dao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean kiemTraMaMatHangNhapTonTai(String maMHN) {
        try {
            ConnectDB.getInstance().connect();
            Connection con = ConnectDB.getConnection();
            PreparedStatement ps = null;
            String sql = "SELECT COUNT(*) FROM MatHangNhap WHERE maMHN =?";
            ps = con.prepareStatement(sql);
            ps.setString(1, maMHN);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int sl = rs.getInt(1);
                return sl > 0;
            }
            ps.close();
            rs.close();
            ConnectDB.getInstance().disconnect();
        } catch (Exception ex) {
            Logger.getLogger(MatHangNhap_dao.class.getName()).log(Level.SEVERE, null, ex);

        }
        return false;
    }
}
