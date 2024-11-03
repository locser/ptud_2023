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

    public NhanVienEntity dangNhap(String taiKhoan, String matKhau) throws Exception {
        Connection con = ConnectDB.getConnection();
        PreparedStatement statement = null;
        try {
            String sql = "SELECT * FROM nhan_vien WHERE taiKhoan = ? AND matKhau = ?";
            statement = con.prepareStatement(sql);
            statement.setString(1, taiKhoan);
            statement.setString(2, matKhau);
            ResultSet rs = statement.executeQuery();
            NhanVienEntity nhanVien = new NhanVienEntity()  ;
            if (rs.next()) {
//                nhanVien = EntityMapper.mapRowToEntity(rs, NhanVienEntity.class);
                nhanVien.setMaNV(rs.getString("maNV"));
                nhanVien.setTen(rs.getString("ten"));
                nhanVien.setLoai(rs.getInt("loai"));
                nhanVien.setGioiTinh(rs.getInt("gioiTinh") == 1 ? GioiTinhEnum.NAM : GioiTinhEnum.NU);
                nhanVien.setEmail(rs.getString("email"));
                nhanVien.setTrangThai(rs.getInt("trangThai"));
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
        NhanVienEntity nhanVien = new NhanVienEntity();
        Connection con = ConnectDB.getConnection();
        PreparedStatement statement = null;
        try {
            String sql = "SELECT * FROM nhan_vien WHERE dien_thoai = ?";
            statement = con.prepareStatement(sql);
            statement.setString(1, soDienThoai);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                
                nhanVien.setMaNV(rs.getString("maNV"));
                nhanVien.setTen(rs.getString("ten"));
                nhanVien.setLoai(rs.getInt("loai"));
                nhanVien.setGioiTinh(rs.getInt("gioiTinh") == 1 ? GioiTinhEnum.NAM : GioiTinhEnum.NU);
                nhanVien.setEmail(rs.getString("email"));
                nhanVien.setTrangThai(rs.getInt("trangThai"));
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
        return nhanVien;
    }

    @Override
    public NhanVienEntity findOne(String maNV) {
        NhanVienEntity nhanVien = null;
        ResultSet rs = null;
        try {
            PreparedStatement statement = ConnectDB.getConnection().prepareStatement("SELECT * FROM nhan_vien WHERE id = ?");
            statement.setString(1, maNV);
            rs = statement.executeQuery();
            if (rs.next()) {
                nhanVien.setMaNV(rs.getString("maNV"));
                nhanVien.setTen(rs.getString("ten"));
                nhanVien.setLoai(rs.getInt("loai"));
                nhanVien.setGioiTinh(rs.getInt("gioiTinh") == 1 ? GioiTinhEnum.NAM : GioiTinhEnum.NU);
                nhanVien.setEmail(rs.getString("email"));
                nhanVien.setTrangThai(rs.getInt("trangThai"));   
            }
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
            PreparedStatement statement = ConnectDB.getConnection().prepareStatement(sql);
            statement.setString(1, newNV.getTen());
            statement.setInt(2, newNV.getLoai());
//            statement.setDate(3, new java.sql.Date(newNV.getNgaySinh().getTime()));
            statement.setString(4, newNV.getEmail());
            statement.setString(5, newNV.getSoDienThoai());
            statement.setString(6, newNV.getDiaChi());
            statement.setInt(7, newNV.getTrangThai());
            statement.setString(8, newNV.getMaNV());
            n = statement.executeUpdate();
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
            PreparedStatement statement = ConnectDB.getConnection().prepareStatement(sql);
            
            // Kiểm tra số điện thoại đã tồn tại chưa
            String checkSql = "SELECT COUNT(*) FROM nhan_vien WHERE dien_thoai = ?";
            PreparedStatement checkStmt = ConnectDB.getConnection().prepareStatement(checkSql);
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
        } catch (Exception ex) {
            Logger.getLogger(NhanVien_dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n > 0;
    }
    @Override
    public ArrayList<NhanVienEntity> findAll() {
        ArrayList<NhanVienEntity> listNV = new ArrayList<>();
        try {
            PreparedStatement statement = ConnectDB.getConnection().prepareStatement("SELECT * FROM nhan_vien");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                NhanVienEntity nhanVien = new NhanVienEntity();
                nhanVien.setMaNV(rs.getString("maNV"));
                nhanVien.setTen(rs.getString("ten"));
                nhanVien.setLoai(rs.getInt("loai"));
                nhanVien.setGioiTinh(rs.getInt("gioiTinh") == 1 ? GioiTinhEnum.NAM : GioiTinhEnum.NU);
                nhanVien.setEmail(rs.getString("email"));
                nhanVien.setTrangThai(rs.getInt("trangThai"));                
                if (nhanVien != null) listNV.add(nhanVien);
            }
        } catch (Exception ex) {
            Logger.getLogger(NhanVien_dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listNV;
    }
}
