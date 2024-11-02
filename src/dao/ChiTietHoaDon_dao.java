package dao;

import Interface.ChiTietHoaDon_Interface;
import connectDB.ConnectDB;
import entity.ChiTietHoaDonEntity;
import entity.HoaDonEntity;
import entity.VeEntity;
import entity.TauEntity;
import entity.ToaTauEntity;
import entity.GheEntity;
import java.util.ArrayList;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.ConvertStringToEnum;

public class ChiTietHoaDon_dao {

    public ChiTietHoaDon_dao() {
    }

    public ArrayList<ChiTietHoaDonEntity> getallCTHD() {
        ArrayList<ChiTietHoaDonEntity> dscthd = new ArrayList<>();
        try (Connection con = ConnectDB.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM ChiTietHoaDon")) {
            
//            while (rs.next()) {
//                VeEntity ve = new VeEntity(rs.getString("maSP"), rs.getInt("loai"), rs.getInt("trangThai"), rs.getDouble("gia"), rs.getDate("ngayTao"), rs.getDate("ngayCapNhat"), new TauEntity(rs.getString("maTau")), new ToaTauEntity(rs.getString("maToa")), new GheEntity(rs.getString("maGhe")));
//                HoaDonEntity hd = new HoaDonEntity(rs.getString("maHD"));
//                int sl = rs.getInt("soLuong");
//                double giaBan = rs.getDouble("giaBan");
//                double thanhTien = rs.getDouble("thanhTien");
//                double giaGoc = rs.getDouble("giaGoc");
//                
//                ChiTietHoaDonEntity cthd = new ChiTietHoaDonEntity(ve, hd, sl, giaGoc, giaBan, thanhTien);
//                dscthd.add(cthd);
//            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dscthd;
    }

    public ArrayList<VeEntity> getSanPhamTheoMaVe(String maVe) {
        ArrayList<VeEntity> dsVe = new ArrayList<>();
        String sql = "SELECT * FROM SanPham WHERE maSP = ?";
        
        try (Connection con = ConnectDB.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            
            stmt.setString(1, maVe);
            try (ResultSet rs = stmt.executeQuery()) {
//                while (rs.next()) {
//                    VeEntity ve = new VeEntity(
//                        rs.getString("maSP"),
//                        rs.getInt("loai"),
//                        rs.getInt("trangThai"),
//                        rs.getDouble("gia"),
//                        rs.getDate("ngayTao"),
//                        rs.getDate("ngayCapNhat"),
//                        new TauEntity(rs.getString("maTau")),
//                        new ToaTauEntity(rs.getString("maToa")),
//                        new GheEntity(rs.getString("maGhe"))
//                    );
//                    dsVe.add(ve);
//                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsVe;
    }

    public ArrayList<VeEntity> getSanPhamTheoMaHD(String maHD) {
        ArrayList<VeEntity> dsVe = new ArrayList<>();
        String sql = "SELECT * FROM SanPham WHERE maSP IN (SELECT maSP FROM ChiTietHoaDon WHERE maHD = ?)";
        
        try (Connection con = ConnectDB.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            
            stmt.setString(1, maHD);
            try (ResultSet rs = stmt.executeQuery()) {
//                while (rs.next()) {
//                    VeEntity ve = new VeEntity(
//                        rs.getString("maSP"),
//                        rs.getInt("loai"),
//                        rs.getInt("trangThai"),
//                        rs.getDouble("gia"),
//                        rs.getDate("ngayTao"),
//                        rs.getDate("ngayCapNhat"),
//                        new TauEntity(rs.getString("maTau")),
//                        new ToaTauEntity(rs.getString("maToa")),
//                        new GheEntity(rs.getString("maGhe"))
//                    );
//                    dsVe.add(ve);
//                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsVe;
    }

    public boolean themChiTietHoaDon(ChiTietHoaDonEntity cthd) {
        String sql = "INSERT INTO ChiTietHoaDon(maSP, maHD, soLuong, giaGoc, giaBan, thanhTien) VALUES (?, ?, ?, ?, ?, ?)";
        
        try (Connection con = ConnectDB.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            
//            stmt.setString(1, cthd.getSanPham().getMaVe());
            stmt.setString(2, cthd.getHoaDon().getMaHD());
            stmt.setInt(3, cthd.getSoLuong());
            stmt.setDouble(4, cthd.getGiaGoc());
            stmt.setDouble(5, cthd.getGiaBan());
            stmt.setDouble(6, cthd.getThanhTien());

            int ketQua = stmt.executeUpdate();
            return ketQua > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean xoaCTHDTheoMaHoaDon(String maHD) {
        String sql = "DELETE FROM ChiTietHoaDon WHERE maHD=?";
        
        try (Connection con = ConnectDB.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            
            stmt.setString(1, maHD);
            int ketQua = stmt.executeUpdate();
            return ketQua > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<ChiTietHoaDonEntity> getAllCTHDTheoMaHD(String maHD) {
        ArrayList<ChiTietHoaDonEntity> cthdList = new ArrayList<>();
        String sql = "SELECT cthd.*, sp.loai, sp.trangThai, sp.gia, sp.ngayTao, sp.ngayCapNhat, sp.maTau, sp.maToa, sp.maGhe FROM ChiTietHoaDon AS cthd INNER JOIN SanPham AS sp ON cthd.maSP=sp.maSP WHERE maHD=?";
        
        try (Connection con = ConnectDB.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            
            stmt.setString(1, maHD);
            try (ResultSet rs = stmt.executeQuery()) {
//                while (rs.next()) {
//                    HoaDonEntity hd = new HoaDonEntity(rs.getString("maHD"));
//                    VeEntity ve = new VeEntity(
//                        rs.getString("maSP"),
//                        rs.getInt("loai"),
//                        rs.getInt("trangThai"),
//                        rs.getDouble("gia"),
//                        rs.getDate("ngayTao"),
//                        rs.getDate("ngayCapNhat"),
//                        new TauEntity(rs.getString("maTau")),
//                        new ToaTauEntity(rs.getString("maToa")),
//                        new GheEntity(rs.getString("maGhe"))
//                    );
//                    
//                    ChiTietHoaDonEntity cthd = new ChiTietHoaDonEntity(
//                        ve, hd, rs.getInt("soLuong"), rs.getDouble("giaGoc"),
//                        rs.getDouble("giaBan"), rs.getDouble("thanhTien")
//                    );
//                    cthdList.add(cthd);
//                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cthdList;
    }
    
    public int getSoLuongCTHD(String maSP) {
        String sql = "SELECT SUM(cthd.soLuong) AS tongSoLuong FROM ChiTietHoaDon AS cthd INNER JOIN HoaDon AS hd ON cthd.maHD=hd.maHD WHERE cthd.maSP=? AND hd.tinhTrang=N'Chưa thanh toán'";
        
        try (Connection con = ConnectDB.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            
            stmt.setString(1, maSP);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("tongSoLuong");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int soluongSP(String maHD, String maSP) {
        String sql = "SELECT soLuong FROM ChiTietHoaDon WHERE maHD = ? AND maSP = ?";
        
        try (Connection con = ConnectDB.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            
            stmt.setString(1, maHD);
            stmt.setString(2, maSP);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("soLuong");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public ArrayList<ChiTietHoaDonEntity> getCTHDTheoMaHDvaMaSP(String maHD, String maSP) {
        ArrayList<ChiTietHoaDonEntity> dscthd = new ArrayList<>();
        String sql = "SELECT cthd.*, sp.loai, sp.trangThai, sp.gia, sp.ngayTao, sp.ngayCapNhat, sp.maTau, sp.maToa, sp.maGhe FROM ChiTietHoaDon AS cthd INNER JOIN SanPham AS sp ON cthd.maSP=sp.maSP WHERE cthd.maHD = ? AND cthd.maSP = ?";
        
        try (Connection con = ConnectDB.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            
            stmt.setString(1, maHD);
            stmt.setString(2, maSP);
            try (ResultSet rs = stmt.executeQuery()) {
//                while (rs.next()) {
//                    VeEntity ve = new VeEntity(
//                        rs.getString("maSP"),
//                        rs.getInt("loai"),
//                        rs.getInt("trangThai"),
//                        rs.getDouble("gia"),
//                        rs.getDate("ngayTao"),
//                        rs.getDate("ngayCapNhat"),
//                        new TauEntity(rs.getString("maTau")),
//                        new ToaTauEntity(rs.getString("maToa")),
//                        new GheEntity(rs.getString("maGhe"))
//                    );
//                    HoaDonEntity hd = new HoaDonEntity(rs.getString("maHD"));
//                    ChiTietHoaDonEntity cthd = new ChiTietHoaDonEntity(
//                        ve, hd, rs.getInt("soLuong"), rs.getDouble("giaGoc"),
//                        rs.getDouble("giaBan"), rs.getDouble("thanhTien")
//                    );
//                    dscthd.add(cthd);
//                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dscthd;
    }
}
