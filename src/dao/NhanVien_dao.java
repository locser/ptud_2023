package dao;

import Interface.NhanVienInterface;
import connectDB.ConnectDB;
import entity.*;
import util.EntityMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NhanVien_dao implements NhanVienInterface {
    ConnectDB connect = new ConnectDB();

    public NhanVienEntity dangNhap(String taiKhoan, String matKhau) throws Exception {
        ConnectDB.getInstance().connect();
        Connection con = ConnectDB.getConnection();
        PreparedStatement statement = null;
        try {
            String sql = "SELECT * FROM nhan_vien WHERE taiKhoan = ? AND matKhau = ?";
            statement = con.prepareStatement(sql);
            statement.setString(1, taiKhoan);
            statement.setString(2, matKhau);
            ResultSet rs = statement.executeQuery();
            NhanVienEntity nhanVien = null;
            if (rs.next()) {
                nhanVien = EntityMapper.mapRowToEntity(rs, NhanVienEntity.class);
                System.out.println(nhanVien.toString());
                return nhanVien;
            } else {
                System.out.println("Không tìm thấy kết quả.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (statement != null) statement.close();
        }
        return null;
    }

    @Override
    public Boolean checkNV(String email, String soDienThoai) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement statement = null;
        try {
            String sql = "SELECT * FROM nhan_vien WHERE email = ? AND dien_thoai = ?";
            statement = con.prepareStatement(sql);
            statement.setString(1, email);
            statement.setString(2, soDienThoai);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                System.out.println("Nhân viên đã tồn tại.");
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) statement.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public NhanVienEntity getNV(String soDienThoai) {
        NhanVienEntity nv = new NhanVienEntity();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement statement = null;
        try {
            String sql = "SELECT * FROM nhan_vien WHERE dien_thoai = ?";
            statement = con.prepareStatement(sql);
            statement.setString(1, soDienThoai);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                nv = EntityMapper.mapRowToEntity(rs, NhanVienEntity.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) statement.close();
            } catch (Exception e2) {	
                e2.printStackTrace();
            }
        }
        return nv;
    }

    @Override
    public NhanVienEntity findOne(String maNV) {
        NhanVienEntity nhanVien = null;
        ResultSet rs = null;
        try {
            connect.connect();
            PreparedStatement statement = connect.getConnection().prepareStatement("SELECT * FROM nhan_vien WHERE id = ?");
            statement.setString(1, maNV);
            rs = statement.executeQuery();
            if (rs.next()) {
                nhanVien = EntityMapper.mapRowToEntity(rs, NhanVienEntity.class);
            }
            connect.disconnect();
        } catch (Exception ex) {
            Logger.getLogger(NhanVien_dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nhanVien;
    }

    @Override
    public boolean update(NhanVienEntity newNV) {
        String sql = "UPDATE nhan_vien SET ten = ?, loai = ?, gioi_tinh = ?, email = ?, dien_thoai = ?, dia_chi = ?, trang_thai = ? WHERE maNV = ?";
        int n = 0;
        try {
            connect.connect();
            PreparedStatement statement = connect.getConnection().prepareStatement(sql);
            statement.setString(1, newNV.getTen());
            statement.setInt(2, newNV.getLoai());
            statement.setString(2, newNV.getGioiTinh().toString());
            statement.setString(4, newNV.getEmail());
            statement.setString(5, newNV.getSoDienThoai());
            statement.setString(6, newNV.getDiaChi());
            statement.setInt(7, newNV.getTrangThai());
            statement.setString(8, newNV.getMaNV());
            n = statement.executeUpdate();
            connect.disconnect();
        } catch (Exception ex) {
            Logger.getLogger(NhanVien_dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n > 0;
    }

    @Override
    public boolean insert(NhanVienEntity NV) {
        int n = 0;
        String sql = "INSERT INTO nhan_vien(ten, loai, gioi_tinh, email, dien_thoai, dia_chi, trang_thai, ngay_tao, ngay_cap_nhat) " +
                     "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            connect.connect();
            PreparedStatement statement = connect.getConnection().prepareStatement(sql);
            
            // Kiểm tra số điện thoại đã tồn tại chưa
            String checkSql = "SELECT COUNT(*) FROM nhan_vien WHERE dien_thoai = ?";
            PreparedStatement checkStmt = connect.getConnection().prepareStatement(checkSql);
            checkStmt.setString(1, NV.getSoDienThoai());
            ResultSet rs = checkStmt.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                return false; // Số điện thoại đã tồn tại
            }
            
            // Nếu số điện thoại chưa tồn tại, thực hiện insert
            statement.setString(1, NV.getTen());
            statement.setInt(2, NV.getLoai());
            statement.setString(3, NV.getGioiTinh().toString());
            statement.setString(4, NV.getEmail());
            statement.setString(5, NV.getSoDienThoai());
            statement.setString(6, NV.getDiaChi());
            statement.setInt(7, NV.getTrangThai());
            statement.setDate(8, new java.sql.Date(NV.getNgayTao().getTime()));
            statement.setDate(9, new java.sql.Date(NV.getNgayCapNhat().getTime()));
            
            n = statement.executeUpdate();
            connect.disconnect();
        } catch (Exception ex) {
            Logger.getLogger(NhanVien_dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n > 0;
    }
    @Override
    public ArrayList<NhanVienEntity> findAll() {
        ArrayList<NhanVienEntity> listNV = new ArrayList<>();
        try {
            connect.connect();
            PreparedStatement statement = ConnectDB.getConnection().prepareStatement("SELECT * FROM nhan_vien");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                NhanVienEntity nhanVien = EntityMapper.mapRowToEntity(rs, NhanVienEntity.class);
                if (nhanVien != null) listNV.add(nhanVien);
            }
            connect.disconnect();
        } catch (Exception ex) {
            Logger.getLogger(NhanVien_dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listNV;
    }
}
