package dao;

import connectDB.ConnectDB;
import entity.TauEntity;
import entity.NhanVienEntity;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tau_DAO {
    ConnectDB connect = new ConnectDB();

    public TauEntity findOne(String id) {
        TauEntity tau = null;
        try {
            connect.connect();
            PreparedStatement statement = connect.getConnection().prepareStatement("SELECT * FROM Tau WHERE MaTau = ?");
            statement.setString(1, id);
            ResultSet rs = statement.executeQuery();
            
            if(rs.next()) {
                tau = new TauEntity(
                    rs.getString("MaTau"),
                    rs.getString("TenTau"),
                    rs.getString("GaDi"),
                    rs.getString("GaDen"),
                    rs.getDate("ThoiGianChay"),
                    rs.getInt("SoToa"),
                    rs.getString("Loai"),
                    rs.getInt("TrangThai"),
                    rs.getDate("NgayTao"),
                    rs.getDate("NgayCapNhat")
                );
            }
            
            connect.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(Tau_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return tau;
    }

    public boolean update(TauEntity tau) {
        String sql = "UPDATE Tau SET TenTau=?, GaDi=?, GaDen=?, ThoiGianChay=?, SoToa=?, Loai=?, TrangThai=?, NgayCapNhat=? WHERE MaTau=?";
        int n = 0;
        try {
            connect.connect();
            PreparedStatement statement = connect.getConnection().prepareStatement(sql);
            statement.setString(1, tau.getTenTau());
            statement.setString(2, tau.getGaDi());
            statement.setString(3, tau.getGaDen());
            statement.setDate(4, new java.sql.Date(tau.getThoiGianChay().getTime()));
            statement.setInt(5, tau.getSoToa());
            statement.setString(6, tau.getLoai());
            statement.setInt(7, tau.getTrangThai());
            statement.setDate(8, new java.sql.Date(System.currentTimeMillis()));
            statement.setString(9, tau.getMaTau());
            
            n = statement.executeUpdate();
            connect.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(Tau_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return n > 0;
    }

    public boolean insert(TauEntity tau) {
        String sql = "INSERT INTO Tau (MaTau, TenTau, GaDi, GaDen, ThoiGianChay, SoToa, Loai, TrangThai, NgayTao, NgayCapNhat) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        int n = 0;
        try {
            connect.connect();
            PreparedStatement statement = connect.getConnection().prepareStatement(sql);
            statement.setString(1, tau.getMaTau());
            statement.setString(2, tau.getTenTau());
            statement.setString(3, tau.getGaDi());
            statement.setString(4, tau.getGaDen());
            statement.setDate(5, new java.sql.Date(tau.getThoiGianChay().getTime()));
            statement.setInt(6, tau.getSoToa());
            statement.setString(7, tau.getLoai());
            statement.setInt(8, tau.getTrangThai());
            statement.setDate(9, new java.sql.Date(System.currentTimeMillis()));
            statement.setDate(10, new java.sql.Date(System.currentTimeMillis()));
            
            n = statement.executeUpdate();
            connect.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(Tau_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return n > 0;
    }

    public ArrayList<TauEntity> findAll() {
        ArrayList<TauEntity> listTau = new ArrayList<>();
        try {
            connect.connect();
            PreparedStatement statement = connect.getConnection().prepareStatement("SELECT * FROM Tau");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                TauEntity tau = new TauEntity(
                    rs.getString("MaTau"),
                    rs.getString("TenTau"),
                    rs.getString("GaDi"),
                    rs.getString("GaDen"),
                    rs.getDate("ThoiGianChay"),
                    rs.getInt("SoToa"),
                    rs.getString("Loai"),
                    rs.getInt("TrangThai"),
                    rs.getDate("NgayTao"),
                    rs.getDate("NgayCapNhat")
                );
                listTau.add(tau);
            }
            connect.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(Tau_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return listTau;
    }

    public boolean delete(String id) {
        String sql = "DELETE FROM Tau WHERE MaTau=?";
        int n = 0;
        try {
            connect.connect();
            PreparedStatement statement = connect.getConnection().prepareStatement(sql);
            statement.setString(1, id);
            
            n = statement.executeUpdate();
            connect.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(Tau_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return n > 0;
    }
}