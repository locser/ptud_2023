package dao;

import connectDB.ConnectDB;
import entity.GioiTinhEnum;
import entity.KhachHangEntity;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Interface.KhachHang_Interface;
import util.ConvertStringToEnum;


public class KhachHang_dao implements KhachHang_Interface {
    ConnectDB connect = new ConnectDB();

    @Override
    public KhachHangEntity findOne(String id) {
        KhachHangEntity khachHang = null;
        ResultSet rs = null;
        try {
            connect.connect();
            PreparedStatement statement = connect.getConnection().prepareStatement("SELECT * FROM KhachHang WHERE maKH = ?");
            statement.setString(1, id);
            rs = statement.executeQuery();
            if (rs.next()) {
//                GioiTinhEnum gt = ConvertStringToEnum.GioiTinhtoEnum(rs.getString("gioiTinh"));
//                khachHang = new KhachHangEntity(
//                    rs.getString("maKH"),
//                    rs.getString("hoTen"),
//                    "",
//                    rs.getString("soDienThoai"),
//                    rs.getString("diaChi"),
//                    rs.getString("soCCCD"),
//                    rs.getDate("ngayTao"),
//                    rs.getDate("ngayCapNhat")
//                );
            }
            connect.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(KhachHang_dao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return khachHang;
    }

    @Override
    public boolean update(KhachHangEntity NewKH) {
        String sql = "UPDATE KhachHang SET hoTen = ?, gioiTinh = ?, soDienThoai = ?, diaChi = ?, soCCCD = ?, ngayCapNhat = ? WHERE maKH = ?";
        int n = 0;
        try {
            connect.connect();
            PreparedStatement statement = connect.getConnection().prepareStatement(sql);
            statement.setString(1, NewKH.getHoTen());
            statement.setString(2, NewKH.getGioiTinh().toString());
            statement.setString(3, NewKH.getSoDienThoai());
            statement.setString(4, NewKH.getDiaChi());
            statement.setString(5, NewKH.getSoCCCD());
            statement.setDate(6, new java.sql.Date(System.currentTimeMillis())); // Cập nhật ngày hiện tại
            statement.setString(7, NewKH.getMaKH());
            n = statement.executeUpdate();
            connect.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(KhachHang_dao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return n > 0;
    }

    @Override
    public boolean insert(KhachHangEntity KH) {
        int n = 0;
        String sql = "INSERT INTO KhachHang(maKH, hoTen, gioiTinh, soDienThoai, diaChi, soCCCD, ngayTao, ngayCapNhat) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            connect.connect();
            PreparedStatement statement = connect.getConnection().prepareStatement(sql);
            statement.setString(1, KH.getMaKH());
            statement.setString(2, KH.getHoTen());
            statement.setString(3, KH.getGioiTinh().toString());
            statement.setString(4, KH.getSoDienThoai());
            statement.setString(5, KH.getDiaChi());
            statement.setString(6, KH.getSoCCCD());
            statement.setDate(7, new java.sql.Date(System.currentTimeMillis())); // Ngày tạo là ngày hiện tại
            statement.setDate(8, new java.sql.Date(System.currentTimeMillis())); // Ngày cập nhật là ngày hiện tại
            n = statement.executeUpdate();
            connect.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(KhachHang_dao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return n > 0;
    }

    @Override
    public ArrayList<KhachHangEntity> findAll() {
        ArrayList<KhachHangEntity> listKH = new ArrayList<>();
        try {
            connect.connect();
            PreparedStatement statement = connect.getConnection().prepareStatement("SELECT * FROM KhachHang");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
//                GioiTinhEnum gt = ConvertStringToEnum.GioiTinhtoEnum(rs.getString("gioiTinh"));
//                KhachHangEntity khachHang = new KhachHangEntity(
//                    rs.getString("maKH"),
//                    rs.getString("hoTen"),
//                    gt,
//                    rs.getString("soDienThoai"),
//                    rs.getString("diaChi"),
//                    rs.getString("soCCCD"),
//                    rs.getDate("ngayTao"),
//                    rs.getDate("ngayCapNhat")
//                );
//                listKH.add(khachHang);
            }
            connect.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(KhachHang_dao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return listKH;
    }

    @Override
    public KhachHangEntity timKiemTheoSDT(String sdt) {
        KhachHangEntity khachHang = null;
        try {
            connect.connect();
            PreparedStatement statement = connect.getConnection().prepareStatement("SELECT * FROM KhachHang WHERE soDienThoai = ?");
            statement.setString(1, sdt);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
//                GioiTinhEnum gt = ConvertStringToEnum.GioiTinhtoEnum(rs.getString("gioiTinh"));
//                khachHang = new KhachHangEntity(
//                    rs.getString("maKH"),
//                    rs.getString("hoTen"),
//                    gt,
//                    rs.getString("soDienThoai"),
//                    rs.getString("diaChi"),
//                    rs.getString("soCCCD"),
//                    rs.getDate("ngayTao"),
//                    rs.getDate("ngayCapNhat")
//                );
            }
            connect.disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return khachHang;
    }

    @Override
    public KhachHangEntity getKHTheoMa(String ma) {
        KhachHangEntity khachHang = null;
        try {
            connect.connect();
            PreparedStatement statement = connect.getConnection().prepareStatement("SELECT * FROM KhachHang WHERE maKH = ?");
            statement.setString(1, ma);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
//                GioiTinhEnum gt = ConvertStringToEnum.GioiTinhtoEnum(rs.getString("gioiTinh"));
//                khachHang = new KhachHangEntity(
//                    rs.getString("maKH"),
//                    rs.getString("hoTen"),
//                    gt,
//                    rs.getString("soDienThoai"),
//                    rs.getString("diaChi"),
//                    rs.getString("soCCCD"),
//                    rs.getDate("ngayTao"),
//                    rs.getDate("ngayCapNhat")
//                );
            }
            connect.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(KhachHang_dao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return khachHang;
    }

    @Override
    public KhachHangEntity getKhachHang(String maKH) {
        return getKHTheoMa(maKH);
    }
}
