package dao;

import connectDB.ConnectDB;
import entity.LichTrinhEntity;
import entity.TauEntity;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LichTrinh_dao {
    ConnectDB connect = new ConnectDB();

    public LichTrinhEntity findOne(String id) {
        LichTrinhEntity lichTrinh = null;
        ResultSet rs = null;
        try {
            connect.connect();
            PreparedStatement statement = connect.getConnection().prepareStatement("SELECT * FROM LichTrinh WHERE maLichTrinh = ?");
            statement.setString(1, id);
            rs = statement.executeQuery();
//            if (rs.next()) {
//                TauEntity tau = new Tau_dao().findOne(rs.getString("maTau"));
//                lichTrinh = new LichTrinhEntity(
//                    rs.getString("maLichTrinh"),
//                    tau,
//                    rs.getString("gaDi"),
//                    rs.getString("gaDen"),
//                    rs.getDate("ngayDi"),
//                    rs.getDate("ngayDen"),
//                    rs.getString("trangThai")
//                );
//            }
            connect.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(LichTrinh_dao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return lichTrinh;
    }

    public boolean update(LichTrinhEntity newLichTrinh) {
        String sql = "UPDATE LichTrinh SET maTau = ?, gaDi = ?, gaDen = ?, ngayDi = ?, ngayDen = ?, trangThai = ? WHERE maLichTrinh = ?";
        int n = 0;
        try {
            connect.connect();
            PreparedStatement statement = connect.getConnection().prepareStatement(sql);
            statement.setString(1, newLichTrinh.getMaTau().getMaTau());
            statement.setString(2, newLichTrinh.getGaDi());
            statement.setString(3, newLichTrinh.getGaDen());
            statement.setDate(4, new java.sql.Date(newLichTrinh.getNgayDi().getTime()));
            statement.setDate(5, new java.sql.Date(newLichTrinh.getNgayDen().getTime()));
            statement.setString(6, newLichTrinh.getTrangThai());
            statement.setString(7, newLichTrinh.getMaLichTrinh());
            n = statement.executeUpdate();
            connect.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(LichTrinh_dao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return n > 0;
    }

    public boolean insert(LichTrinhEntity lichTrinh) {
        int n = 0;
        String sql = "INSERT INTO LichTrinh(maLichTrinh, maTau, gaDi, gaDen, ngayDi, ngayDen, trangThai) VALUES(?, ?, ?, ?, ?, ?, ?)";
        try {
            connect.connect();
            PreparedStatement statement = connect.getConnection().prepareStatement(sql);
            statement.setString(1, lichTrinh.getMaLichTrinh());
            statement.setString(2, lichTrinh.getMaTau().getMaTau());
            statement.setString(3, lichTrinh.getGaDi());
            statement.setString(4, lichTrinh.getGaDen());
            statement.setDate(5, new java.sql.Date(lichTrinh.getNgayDi().getTime()));
            statement.setDate(6, new java.sql.Date(lichTrinh.getNgayDen().getTime()));
            statement.setString(7, lichTrinh.getTrangThai());
            n = statement.executeUpdate();
            connect.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(LichTrinh_dao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return n > 0;
    }

    public ArrayList<LichTrinhEntity> findAll() {
        ArrayList<LichTrinhEntity> dsLichTrinh = new ArrayList<>();
        try {
            connect.connect();
            PreparedStatement statement = connect.getConnection().prepareStatement("SELECT * FROM LichTrinh");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
//                TauEntity tau = new Tau_dao().findOne(rs.getString("maTau"));
//                LichTrinhEntity lichTrinh = new LichTrinhEntity(
//                    rs.getString("maLichTrinh"),
//                    tau,
//                    rs.getString("gaDi"),
//                    rs.getString("gaDen"),
//                    rs.getDate("ngayDi"),
//                    rs.getDate("ngayDen"),
//                    rs.getString("trangThai")
//                );
//                dsLichTrinh.add(lichTrinh);
            }
            connect.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(LichTrinh_dao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return dsLichTrinh;
    }

    public ArrayList<LichTrinhEntity> timLichTrinhTheoTuyenDuong(String gaDi, String gaDen) {
        ArrayList<LichTrinhEntity> dsLichTrinh = new ArrayList<>();
        try {
            connect.connect();
            PreparedStatement statement = connect.getConnection().prepareStatement("SELECT * FROM LichTrinh WHERE gaDi = ? AND gaDen = ?");
            statement.setString(1, gaDi);
            statement.setString(2, gaDen);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
//                TauEntity tau = new Tau_dao().findOne(rs.getString("maTau"));
//                LichTrinhEntity lichTrinh = new LichTrinhEntity(
//                    rs.getString("maLichTrinh"),
//                    tau,
//                    rs.getString("gaDi"),
//                    rs.getString("gaDen"),
//                    rs.getDate("ngayDi"),
//                    rs.getDate("ngayDen"),
//                    rs.getString("trangThai")
//                );
//                dsLichTrinh.add(lichTrinh);
            }
            connect.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(LichTrinh_dao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return dsLichTrinh;
    }

    public ArrayList<LichTrinhEntity> timLichTrinhTheoNgay(Date ngay) {
        ArrayList<LichTrinhEntity> dsLichTrinh = new ArrayList<>();
        try {
            connect.connect();
            PreparedStatement statement = connect.getConnection().prepareStatement("SELECT * FROM LichTrinh WHERE ngayDi = ?");
            statement.setDate(1, new java.sql.Date(ngay.getTime()));
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
//                TauEntity tau = new Tau_dao().findOne(rs.getString("maTau"));
//                LichTrinhEntity lichTrinh = new LichTrinhEntity(
//                    rs.getString("maLichTrinh"),
//                    tau,
//                    rs.getString("gaDi"),
//                    rs.getString("gaDen"),
//                    rs.getDate("ngayDi"),
//                    rs.getDate("ngayDen"),
//                    rs.getString("trangThai")
//                );
//                dsLichTrinh.add(lichTrinh);
            }
            connect.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(LichTrinh_dao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return dsLichTrinh;
    }
}