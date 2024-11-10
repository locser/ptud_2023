package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import connectDB.ConnectDB;
import Interface.ThongKe_Interface;

public class ThongKe_dao implements ThongKe_Interface {
    private Connection con;

    public ThongKe_dao() {
        con = ConnectDB.getInstance().getConnection();
    }

    @Override
    public ArrayList<Object[]> thongKeVeTheoNhanVien(String nam) {
        ArrayList<Object[]> dsVeNhanVien = new ArrayList<>();
        String sql = "SELECT nv.maNV, nv.ten, COUNT(ctdh.maVe) as SoVeDaBan " +
                "FROM nhan_vien nv " +
                "LEFT JOIN don_hang dh ON nv.maNV = dh.maNV " +
                "LEFT JOIN chi_tiet_don_hang ctdh ON dh.maDH = ctdh.maDH " +
                "WHERE YEAR(dh.ngayTao) = 2024 AND dh.trangThai = 1 " +
                "GROUP BY nv.maNV, nv.ten " +
                "ORDER BY SoVeDaBan DESC;";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, Integer.parseInt(nam));
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Object[] row = {
                        rs.getString("MaNV"),
                        rs.getString("TenNV"),
                        rs.getInt("SoVeDaBan")
                };
                dsVeNhanVien.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsVeNhanVien;
    }

    @Override
    public int thongKeTongVeDaBan(String nam) {
        int tongVe = 0;
        String sql = "SELECT COUNT(ctdh.maVe) as TongVe " +
                "FROM don_hang dh " +
                "JOIN chi_tiet_don_hang ctdh ON dh.maDH = ctdh.maDH " +
                "WHERE YEAR(dh.ngayTao) = 2024 AND dh.trangThai = 1;";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, Integer.parseInt(nam));
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                tongVe = rs.getInt("TongVe");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tongVe;
    }

    @Override
    public ArrayList<Object[]> thongKeNhanVien() {
        ArrayList<Object[]> dsNhanVien = new ArrayList<>();
        String sql = "SELECT " +
                "    CASE WHEN trangThai = 1 THEN N'Đang làm việc' ELSE N'Đã nghỉ việc' END as TrangThai, " +
                "    COUNT(*) as SoLuong " +
                "FROM nhan_vien " +
                "GROUP BY trangThai;";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Object[] row = {
                        rs.getString("TrangThai"),
                        rs.getInt("SoLuong")
                };
                dsNhanVien.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsNhanVien;
    }

    @Override
    public ArrayList<Object[]> thongKeVeTheoTau(String nam) {
        ArrayList<Object[]> dsVeTau = new ArrayList<>();
        String sql = "SELECT t.maTau, t.ten, COUNT(ctdh.maVe) as SoVeDaBan " +
                "FROM tau t " +
                "LEFT JOIN ve v ON t.maTau = v.maTau " +
                "LEFT JOIN chi_tiet_don_hang ctdh ON v.maVe = ctdh.maVe " +
                "LEFT JOIN don_hang dh ON ctdh.maDH = dh.maDH " +
                "WHERE YEAR(dh.ngayTao) = 2024 AND dh.trangThai = 1 " +
                "GROUP BY t.maTau, t.ten " +
                "ORDER BY SoVeDaBan DESC;";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, Integer.parseInt(nam));
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Object[] row = {
                        rs.getInt("MaTau"),
                        rs.getString("TenTau"),
                        rs.getInt("SoVeDaBan")
                };
                dsVeTau.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsVeTau;
    }

    @Override
    public ArrayList<Object[]> thongKeTop5NhanVien(String thang, String nam) {
        ArrayList<Object[]> dsTop5NhanVien = new ArrayList<>();
        String sql = "SELECT TOP 5 nv.maNV, nv.ten, COUNT(ctdh.maVe) as SoVeDaBan " +
                "FROM nhan_vien nv " +
                "LEFT JOIN don_hang dh ON nv.maNV = dh.maNV " +
                "LEFT JOIN chi_tiet_don_hang ctdh ON dh.maDH = ctdh.maDH " +
                "WHERE YEAR(dh.ngayTao) = ? AND dh.trangThai = 1 " +
                "GROUP BY nv.maNV, nv.ten " +
                "ORDER BY SoVeDaBan DESC;";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, Integer.parseInt(nam));
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Object[] row = {
                        rs.getString("MaNV"),
                        rs.getString("TenNV"),
                        rs.getInt("SoVeDaBan")
                };
                dsTop5NhanVien.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsTop5NhanVien;
    }
}
