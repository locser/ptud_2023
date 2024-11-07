package dao;

import connectDB.ConnectDB;
import entity.NhanVienEntity;
import entity.VeEntity;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ThongKe_dao {
    
    // Thống kê số vé đã bán theo tháng và năm
    public Map<String, Integer> thongKeVeDaBan(int nam) {
        Map<String, Integer> thongKeMap = new HashMap<>();
        String sql = "SELECT MONTH(ngayTao) as Thang, COUNT(*) as SoLuong " +
                    "FROM ve " +
                    "WHERE YEAR(ngayTao) = ? AND trangThai = 1 " +
                    "GROUP BY MONTH(ngayTao) " +
                    "ORDER BY Thang";
                    
        try (Connection con = ConnectDB.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            
            stmt.setInt(1, nam);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                String thang = "Tháng " + rs.getInt("Thang");
                int soLuong = rs.getInt("SoLuong");
                thongKeMap.put(thang, soLuong);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return thongKeMap;
    }
    
    // Thống kê doanh thu theo tháng và năm
    public Map<String, Double> thongKeDoanhThu(int nam) {
        Map<String, Double> doanhThuMap = new HashMap<>();
        String sql = "SELECT MONTH(ngayTao) as Thang, SUM(gia) as DoanhThu " +
                    "FROM ve " +
                    "WHERE YEAR(ngayTao) = ? AND trangThai = 1 " +
                    "GROUP BY MONTH(ngayTao) " +
                    "ORDER BY Thang";
                    
        try (Connection con = ConnectDB.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            
            stmt.setInt(1, nam);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                String thang = "Tháng " + rs.getInt("Thang");
                double doanhThu = rs.getDouble("DoanhThu");
                doanhThuMap.put(thang, doanhThu);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return doanhThuMap;
    }
    
    // Thống kê nhân viên theo trạng thái
    public Map<String, Integer> thongKeNhanVien() {
        Map<String, Integer> nhanVienMap = new HashMap<>();
        String sql = "SELECT trangThai, COUNT(*) as SoLuong " +
                    "FROM nhan_vien " +
                    "GROUP BY trangThai";
                    
        try (Connection con = ConnectDB.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                String trangThai = rs.getInt("trangThai") == 1 ? "Đang làm việc" : "Đã nghỉ việc";
                int soLuong = rs.getInt("SoLuong");
                nhanVienMap.put(trangThai, soLuong);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nhanVienMap;
    }
    
    // Thống kê top 5 nhân viên bán nhiều vé nhất theo năm
    public ArrayList<Map<String, Object>> thongKeTop5NhanVien(int nam) {
        ArrayList<Map<String, Object>> topNhanVien = new ArrayList<>();
        String sql = "SELECT nv.maNV, nv.ten, COUNT(v.maVe) as SoVeDaBan " +
                    "FROM nhan_vien nv " +
                    "JOIN hoa_don hd ON nv.maNV = hd.maNV " +
                    "JOIN chi_tiet_hoa_don cthd ON hd.maHD = cthd.maHD " +
                    "JOIN ve v ON cthd.maVe = v.maVe " +
                    "WHERE YEAR(hd.ngayTao) = ? " +
                    "GROUP BY nv.maNV, nv.ten " +
                    "ORDER BY SoVeDaBan DESC " +
                    "LIMIT 5";
                    
        try (Connection con = ConnectDB.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            
            stmt.setInt(1, nam);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Map<String, Object> nhanVien = new HashMap<>();
                nhanVien.put("maNV", rs.getString("maNV"));
                nhanVien.put("tenNV", rs.getString("ten"));
                nhanVien.put("soVeDaBan", rs.getInt("SoVeDaBan"));
                topNhanVien.add(nhanVien);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return topNhanVien;
    }
}