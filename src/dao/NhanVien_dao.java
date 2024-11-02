package dao;

import Interface.NhanVienInterface;
import connectDB.ConnectDB;
import entity.*;
import util.EntityMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NhanVien_dao implements NhanVienInterface {
    private ConnectDB connect = new ConnectDB();

    @Override
    public Boolean checkNV(String email, String soDienThoai) {
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            con = ConnectDB.getInstance().getConnection();
            String sql = "SELECT * FROM nhan_vien WHERE email = ? OR dien_thoai = ?";
            statement = con.prepareStatement(sql);
            statement.setString(1, email);
            statement.setString(2, soDienThoai);
            rs = statement.executeQuery();

            return rs.next();
        } catch (SQLException e) {
            Logger.getLogger(NhanVien_dao.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (rs != null) rs.close();
                if (statement != null) statement.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                Logger.getLogger(NhanVien_dao.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return false;
    }

    @Override
    public NhanVienEntity getNV(String sdt) throws SQLException {
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        NhanVienEntity nv = null;
        try {
            con = ConnectDB.getInstance().getConnection();
            String sql = "SELECT * FROM NhanVien WHERE soDienThoai = ?";
            statement = con.prepareStatement(sql);
            statement.setString(1, sdt);
            rs = statement.executeQuery();
            if (rs.next()) {
                GioiTinhEnum gt = GioiTinhEnum.valueOf(rs.getString("gioiTinh").toUpperCase());
                TinhTrangNVEnum tt = TinhTrangNVEnum.valueOf(rs.getString("trangThai").toUpperCase().replace(" ", "_"));
                nv = new NhanVienEntity(
                    rs.getString("maNV"), 
                    rs.getString("ten"), 
                    rs.getInt("loai"),
                    gt, 
                    rs.getString("email"), 
                    rs.getString("soDienThoai"), 
                    rs.getString("diaChi"), 
                    tt,
                    rs.getDate("ngayTao"), 
                    rs.getDate("ngayCapNhat"),
                    rs.getString("taiKhoan"),
                    rs.getString("matKhau")
                );
            }
        } catch (SQLException e) {
            Logger.getLogger(NhanVien_dao.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if (rs != null) rs.close();
            if (statement != null) statement.close();
            if (con != null) con.close();
        }
        return nv;
    }

    @Override
    public NhanVienEntity findOne(String maNV) {
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        NhanVienEntity nhanVien = null;
        try {
            con = connect.getConnection();
            String sql = "SELECT * FROM nhan_vien WHERE maNV = ?";
            statement = con.prepareStatement(sql);
            statement.setString(1, maNV);
            rs = statement.executeQuery();
            if (rs.next()) {
                GioiTinhEnum gt = GioiTinhEnum.valueOf(rs.getString("gioiTinh").toUpperCase());
                TinhTrangNVEnum tt = TinhTrangNVEnum.valueOf(rs.getString("trangThai").toUpperCase().replace(" ", "_"));
                nhanVien = new NhanVienEntity(
                    rs.getString("maNV"), 
                    rs.getString("ten"),
                    rs.getInt("loai"),
                    gt,
                    rs.getString("email"), 
                    rs.getString("soDienThoai"), 
                    rs.getString("diaChi"), 
                    tt, 
                    rs.getDate("ngayTao"),
                    rs.getDate("ngayCapNhat"),
                    rs.getString("taiKhoan"),
                    rs.getString("matKhau")
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVien_dao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connect.closeConnection(con, statement, rs);
        }
        return nhanVien;
    }

    @Override
    public boolean update(NhanVienEntity newNV) {
        Connection con = null;
        PreparedStatement statement = null;
        String sql = "UPDATE nhan_vien SET ten = ?, loai = ?, gioiTinh = ?, email = ?, soDienThoai = ?, diaChi = ?, trangThai = ?, ngayCapNhat = ? WHERE maNV = ?";
        int n = 0;
        try {
            con = connect.getConnection();
            statement = con.prepareStatement(sql);
            statement.setString(1, newNV.getTen());
            statement.setInt(2, newNV.getLoai());
            statement.setString(3, newNV.getGioiTinh().toString());
            statement.setString(4, newNV.getEmail());
            statement.setString(5, newNV.getSoDienThoai());
            statement.setString(6, newNV.getDiaChi());
            statement.setString(7, newNV.getTrangThai().toString());
            statement.setDate(8, new java.sql.Date(System.currentTimeMillis()));
            statement.setString(9, newNV.getMaNV());
            n = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVien_dao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connect.closeConnection(con, statement);
        }
        return n > 0;
    }

    @Override
    public boolean insert(NhanVienEntity NV) {
        Connection con = null;
        PreparedStatement statement = null;
        String sql = "INSERT INTO nhan_vien(maNV, ten, loai, gioiTinh, email, soDienThoai, diaChi, trangThai, ngayTao, ngayCapNhat, taiKhoan, matKhau) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        int n = 0;
        try {
            con = connect.getConnection();
            statement = con.prepareStatement(sql);
            statement.setString(1, NV.getMaNV());
            statement.setString(2, NV.getTen());
            statement.setInt(3, NV.getLoai());
            statement.setString(4, NV.getGioiTinh().toString());
            statement.setString(5, NV.getEmail());
            statement.setString(6, NV.getSoDienThoai());
            statement.setString(7, NV.getDiaChi());
            statement.setString(8, NV.getTrangThai().toString());
            statement.setDate(9, new java.sql.Date(System.currentTimeMillis()));
            statement.setDate(10, new java.sql.Date(System.currentTimeMillis()));
            statement.setString(11, NV.getTaiKhoan());
            statement.setString(12, NV.getMatKhau());
            n = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVien_dao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connect.closeConnection(con, statement);
        }
        return n > 0;
    }

    @Override
    public ArrayList<NhanVienEntity> findAll() {
        ArrayList<NhanVienEntity> listNV = new ArrayList<>();
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            con = connect.getConnection();
            statement = con.prepareStatement("SELECT * FROM NhanVien");
            rs = statement.executeQuery();
            while (rs.next()) {
                GioiTinhEnum gt = GioiTinhEnum.valueOf(rs.getString("gioiTinh").toUpperCase());
                TinhTrangNVEnum tt = TinhTrangNVEnum.valueOf(rs.getString("trangThai").toUpperCase().replace(" ", "_"));
                NhanVienEntity nhanVien = new NhanVienEntity(
                    rs.getString("maNV"), 
                    rs.getString("ten"),
                    rs.getInt("loai"),
                    gt,
                    rs.getString("email"), 
                    rs.getString("soDienThoai"), 
                    rs.getString("diaChi"), 
                    tt, 
                    rs.getDate("ngayTao"),
                    rs.getDate("ngayCapNhat"),
                    rs.getString("taiKhoan"),
                    rs.getString("matKhau")
                );
                if (!listNV.contains(nhanVien)) listNV.add(nhanVien);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVien_dao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connect.closeConnection(con, statement, rs);
        }
        return listNV;
    }
}