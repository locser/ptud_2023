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

/**
 *
 * @author HUY
 */
public class KhachHang_dao implements KhachHang_Interface{
    ConnectDB connect = new ConnectDB();
    
    @Override
    public KhachHangEntity findOne(String id) {
        KhachHangEntity khachHang = null;
        ResultSet rs = null;
        try {
            connect.connect();
            PreparedStatement statement = connect.getConnection().prepareStatement("SELECT * FROM KhachHang WHERE soDienThoai = ?");
//            statement = ConnectDB.getConnection().prepareStatement("SELECT * FROM KhachHang WHERE maKH = ?");
            statement.setString(1, id);
            rs = statement.executeQuery();
            while (rs.next()) {
                GioiTinhEnum gt = null;
                if (rs.getString("gioiTinh").equals("Nam")) {
                    gt = GioiTinhEnum.NAM;
                }
                else if (rs.getString("gioiTinh").equals("Nữ")) {
                    gt = GioiTinhEnum.NU;
                } else gt = GioiTinhEnum.KHAC;
                khachHang = new KhachHangEntity(
                       rs.getString("maKH"), 
                       rs.getString("hoTen"), 
                       gt, 
                       rs.getString("soDienThoai"), 
                       rs.getString("diaChi"));
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
        StringBuilder sql = new StringBuilder("UPDATE KhachHang SET hoTen = ?, gioiTinh = ?,");
        sql.append(" soDienThoai = ?, diaChi = ? WHERE maKH = ?");
        int n = 0;
        try {
            connect.connect();
            PreparedStatement statement = connect.getConnection().prepareStatement(sql.toString());
            statement.setString(1, NewKH.getHoTen());
            statement.setString(2, NewKH.getGioiTinh().toString());
            statement.setString(3, NewKH.getSoDienThoai());
            statement.setString(4, NewKH.getDiaChi());
            statement.setString(5, NewKH.getMaKH());
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
        StringBuilder sql = new StringBuilder("INSERT INTO KhachHang(maKH, hoTen, gioiTinh, soDienThoai, diaChi)");
        sql.append(" VALUES(?, ?, ?, ?, ?)");
        try {
            connect.connect();
            PreparedStatement statement = connect.getConnection().prepareStatement(sql.toString());
            statement.setString(1, KH.getMaKH());
            statement.setString(2, KH.getHoTen());
            statement.setString(3, KH.getGioiTinh().toString());
            statement.setString(4, KH.getSoDienThoai());
            statement.setString(5, KH.getDiaChi());
            n = statement.executeUpdate();
            connect.disconnect();
        } catch (Exception ex) {
            Logger.getLogger(KhachHang_dao.class.getName()).log(Level.SEVERE, null, ex);
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
                KhachHangEntity khachHang = null;
                GioiTinhEnum gt = null;
                if (rs.getString("gioiTinh").equals("Nam")) {
                    gt = GioiTinhEnum.NAM;
                }
                else if (rs.getString("gioiTinh").equals("Nữ")) {
                    gt = GioiTinhEnum.NU;
                }
                else gt = GioiTinhEnum.KHAC;
                khachHang = new KhachHangEntity(
                rs.getString("maKH"), 
                rs.getString("hoTen"), 
                gt, 
                rs.getString("soDienThoai"), 
                rs.getString("diaChi"));
                if (!listKH.contains(khachHang)) listKH.add(khachHang);
            }
            connect.disconnect();
        }
        catch (SQLException ex) {
            Logger.getLogger(KhachHang_dao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return listKH;
    }

//    @Override
//    public int count(String id) {
//        int count = 0;
//        StringBuilder sql = new StringBuilder("SELECT COUNT(*) AS TotalCount ");
//            sql.append("FROM KhachHang WHERE maKH LIKE ?");
//        try {
//            connect.connect();
//            PreparedStatement statement = connect.getConnection().prepareStatement(sql.toString());
//            statement.setString(1, "%" + id + "%");
//            ResultSet rs = statement.executeQuery();
//            while (rs.next()) {
//                count = rs.getInt("TotalCount");
//            }
//            connect.disconnect();
//        } catch (SQLException ex) {
//            Logger.getLogger(KhachHang_dao.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return count;
//    }
    
    
    // Nguyen Huy Hoang
    @Override
    public KhachHangEntity timKiemTheoSDT(String sdt) {
        PreparedStatement statement = null;
        try {
            ConnectDB.getInstance().connect();
            Connection con = ConnectDB.getConnection();
            
            String sql = "Select * from KhachHang where soDienThoai=?";
            statement = con.prepareStatement(sql);
            statement.setString(1, sdt);
            
            ResultSet rs = statement.executeQuery();
            
            KhachHangEntity khachHang = null;
            while(rs.next()) {
                String maKH = rs.getString("maKH");
                String hoTen = rs.getString("hoTen");
                String gioiTinh = rs.getString("gioiTinh");
                String soDienThoai = rs.getString("soDienThoai");
                String diaChi = rs.getString("diaChi");
                
                ConvertStringToEnum convertToEnum = new ConvertStringToEnum();
                
                khachHang = new KhachHangEntity(maKH, hoTen, convertToEnum.GioiTinhtoEnum(gioiTinh), soDienThoai, diaChi);
            }
            return khachHang;
        } catch(SQLException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                statement.close();
                ConnectDB.getInstance().disconnect();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public KhachHangEntity getKHTheoMa(String ma) {
          KhachHangEntity khachHang = null;
        ResultSet rs = null;
        try {
            connect.connect();
            PreparedStatement statement = connect.getConnection().prepareStatement("SELECT * FROM KhachHang WHERE maKH = ?");
//            statement = ConnectDB.getConnection().prepareStatement("SELECT * FROM KhachHang WHERE maKH = ?");
            statement.setString(1, ma);
            rs = statement.executeQuery();
            while (rs.next()) {
                GioiTinhEnum gt = null;
                if (rs.getString("gioiTinh").equals("Nam")) {
                    gt = GioiTinhEnum.NAM;
                }
                else if (rs.getString("gioiTinh").equals("Nữ")) {
                    gt = GioiTinhEnum.NU;
                } else gt = GioiTinhEnum.KHAC;
                khachHang = new KhachHangEntity(
                       rs.getString("maKH"), 
                       rs.getString("hoTen"), 
                       gt, 
                       rs.getString("soDienThoai"), 
                       rs.getString("diaChi"));
            }
            
            connect.disconnect();
            
        } catch (Exception ex) {
            Logger.getLogger(KhachHang_dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return khachHang;
    }
}
