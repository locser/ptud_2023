package dao;

import Interface.NhanVienInterface;
import connectDB.ConnectDB;
import entity.*;
import util.EntityMapper;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NhanVien_dao implements NhanVienInterface {
    private Connection con;

    public NhanVien_dao() {
        con = ConnectDB.getInstance().getConnection();
    }
    public ResultSet getResultSet(String StoreName)throws Exception {
        ResultSet rs = null;
        try {
            String callStore;
            callStore = "{Call " + StoreName +"}";
            CallableStatement cs = this.con.prepareCall(callStore);
            cs.executeQuery();
            rs = cs.getResultSet();
        } catch (Exception e) {
            throw new Exception("Error get Store " + e.getMessage());
        }
        return rs;
    }

//    public NhanVienEntity dangNhap(String taiKhoan, String matKhau) throws Exception {
//        ConnectDB.getInstance().connect();
//        Connection con = ConnectDB.getConnection();
//        PreparedStatement statement = null;
//        try {
//            String sql = "SELECT * FROM nhan_vien WHERE taiKhoan = ? AND matKhau = ?";
//            statement = con.prepareStatement(sql);
//            statement.setString(1, taiKhoan);
//            statement.setString(2, matKhau);
//            ResultSet rs = statement.executeQuery();
//            NhanVienEntity nhanVien = null;
//            if (rs.next()) {
//                nhanVien = EntityMapper.mapRowToEntity(rs, NhanVienEntity.class);
//                System.out.println(nhanVien.toString());
//                return nhanVien;
//            } else {
//                System.out.println("Không tìm thấy kết quả.");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (statement != null) statement.close();
//        }
//        return null;
//    }

    @Override
    public Boolean checkNV(String email, String soDienThoai) {
        
        try (Connection con = ConnectDB.getConnection();
             PreparedStatement statement = con.prepareStatement("SELECT 1 FROM banve.dbo.nhan_vien WHERE email = ? AND soDienThoai = ?")) {
            
            statement.setString(1, email);
            statement.setString(2, soDienThoai);
            
            try (ResultSet rs = statement.executeQuery()) {
                return rs.next(); // Returns true if a record is found
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }


    @Override
    public NhanVienEntity getNV(String soDienThoai) {
        NhanVienEntity nv = null;
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement("SELECT * FROM nhan_vien WHERE soDienThoai = ?");
            statement.setString(1, soDienThoai);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                nv = new NhanVienEntity();
                nv.setMaNV(rs.getString("maNV"));
                nv.setTen(rs.getString("ten"));
                nv.setLoai(rs.getInt("loai"));
                nv.setGioiTinh(GioiTinhEnum.values()[rs.getInt("gioiTinh")]);
                nv.setEmail(rs.getString("email"));
                nv.setSoDienThoai(rs.getString("soDienThoai"));
                nv.setDiaChi(rs.getString("diaChi"));
                nv.setTrangThai(TinhTrangNVEnum.values()[rs.getInt("trangThai")]);
                nv.setNgayTao(rs.getDate("ngayTao"));
                nv.setNgayCapNhat(rs.getDate("ngayCapNhat"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) statement.close();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return nv;
    }

    @Override
    public NhanVienEntity findOne(String maNV) {
        NhanVienEntity nv = null;
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement("SELECT * FROM nhan_vien WHERE maNV = ?");
            statement.setString(1, maNV);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                nv = new NhanVienEntity();
                nv.setMaNV(rs.getString("maNV"));
                nv.setTen(rs.getString("ten"));
                nv.setLoai(rs.getInt("loai"));
                nv.setGioiTinh(GioiTinhEnum.values()[rs.getInt("gioiTinh")]);
                nv.setEmail(rs.getString("email"));
                nv.setSoDienThoai(rs.getString("soDienThoai"));
                nv.setDiaChi(rs.getString("diaChi"));
                nv.setTrangThai(TinhTrangNVEnum.values()[rs.getInt("trangThai")]);
                nv.setNgayTao(rs.getDate("ngayTao"));
                nv.setNgayCapNhat(rs.getDate("ngayCapNhat"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) statement.close();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return nv;
    }

    @Override
    public boolean update(NhanVienEntity newNV) {
        PreparedStatement statement = null;
        String sql = "UPDATE nhan_vien SET ten = ?, loai = ?, gioiTinh = ?, email = ?, soDienThoai = ?, diaChi = ?, trangThai = ?, ngayCapNhat = ? WHERE maNV = ?";
        
        try {
            // Sử dụng connection hiện có thay vì tạo mới
            statement = con.prepareStatement(sql);
            
            // Set các tham số
            statement.setString(1, newNV.getTen());
            statement.setInt(2, newNV.getLoai());
            statement.setInt(3, newNV.getGioiTinh().ordinal());
            statement.setString(4, newNV.getEmail());
            statement.setString(5, newNV.getSoDienThoai());
            statement.setString(6, newNV.getDiaChi());
            statement.setInt(7, newNV.getTrangThai().ordinal());
            statement.setDate(8, new java.sql.Date(newNV.getNgayCapNhat().getTime()));
            statement.setString(9, newNV.getMaNV());

            // Thực thi câu lệnh update
            int rowsAffected = statement.executeUpdate();
            
            return rowsAffected > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean insert(NhanVienEntity nv) {
        String sql = "INSERT INTO nhan_vien (maNV, ten, loai, gioiTinh, email, soDienThoai, diaChi, trangThai, ngayTao, ngayCapNhat) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, nv.getMaNV());
            statement.setString(2, nv.getTen());
            statement.setInt(3, nv.getLoai());
            statement.setInt(4, nv.getGioiTinh().ordinal()); // Chuyển enum thành số
            statement.setString(5, nv.getEmail());
            statement.setString(6, nv.getSoDienThoai());
            statement.setString(7, nv.getDiaChi());
            statement.setInt(8, nv.getTrangThai().ordinal()); // Chuyển enum thành số
            statement.setDate(9, new java.sql.Date(nv.getNgayTao().getTime()));
            statement.setDate(10, new java.sql.Date(nv.getNgayCapNhat().getTime()));
            
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    @Override
    public ArrayList<NhanVienEntity> findAll() {
        ArrayList<NhanVienEntity> listNV = new ArrayList<>();
        try {
            // Sử dụng PreparedStatement thay vì CallableStatement
            String sql = "SELECT * FROM nhan_vien";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                NhanVienEntity nv = new NhanVienEntity();
                nv.setMaNV(rs.getString("maNV"));
                nv.setTen(rs.getString("ten"));
                nv.setLoai(rs.getInt("loai"));
                
                // Chuyển đổi giới tính từ số sang enum
                int gioiTinh = rs.getInt("gioiTinh");
                nv.setGioiTinh(GioiTinhEnum.values()[gioiTinh]);
                
                nv.setEmail(rs.getString("email"));
                nv.setSoDienThoai(rs.getString("soDienThoai"));
                nv.setDiaChi(rs.getString("diaChi"));
                
                // Chuyển đổi trạng thái từ số sang enum
                int trangThai = rs.getInt("trangThai");
                nv.setTrangThai(TinhTrangNVEnum.values()[trangThai]);
                
                nv.setNgayTao(rs.getDate("ngayTao"));
                nv.setNgayCapNhat(rs.getDate("ngayCapNhat"));
                
                listNV.add(nv);
            }
            
            // Debug
            System.out.println("Số lượng nhân viên: " + listNV.size());
            for (NhanVienEntity nv : listNV) {
                System.out.println(nv.toString());
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listNV;
    }
}
