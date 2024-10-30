/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Interface.TaiKhoanInterface;
import connectDB.ConnectDB;
import entity.TaiKhoanEntity;
import entity.TinhTrangTKEnum;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author HUY
 */
public class TaiKhoan_dao implements TaiKhoanInterface{
     ConnectDB connect = new ConnectDB();
     NhanVien_dao nhanVienDAO = new NhanVien_dao();

    public entity.TaiKhoanEntity getTaiKhoan(String taiKhoan, String matKhau) throws Exception {

        ConnectDB.getInstance().connect();
        Connection con = ConnectDB.getConnection();
        PreparedStatement statement = null;
        try {

            String sql = "SELECT * FROM taikhoan WHERE tenTaiKhoan = ? AND matKhau = ?";
            statement = con.prepareStatement(sql);
            statement.setString(1, taiKhoan);
            statement.setString(2, matKhau);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String tk = rs.getString("tenTaiKhoan");
                String mk = rs.getString("matKhau");
               
                entity.TaiKhoanEntity taikhoan = new TaiKhoanEntity(tk, mk, null, rs.getString("tinhTrang").equals("Đang hoạt động") == true ? TinhTrangTKEnum.DANG_HOAT_DONG : TinhTrangTKEnum.NGUNG_HOAT_DONG);
                return taikhoan;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (Exception e2) {
                // TODO: handle exception
                e2.printStackTrace();
            }
        }
        return null;
      
    }
    public boolean thoiGianDNGN(TaiKhoanEntity tk) {
        LocalDateTime currentTime = LocalDateTime.now();
        try {
            ConnectDB.getInstance().connect();
        } catch (Exception ex) {
            Logger.getLogger(TaiKhoan_dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        Connection con = ConnectDB.getConnection();
        PreparedStatement statement = null;
        int n = 0;
        try {

            statement = con.prepareStatement("update TaiKhoan set thoiGianDNGN = ? where tenTaiKhoan= ?");
            statement.setTimestamp(1, Timestamp.valueOf(currentTime));
            statement.setString(2, tk.getTenTaiKhoan());
            n = statement.executeUpdate();

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
           
        

        } finally {
            try {
                statement.close();
            } catch (Exception e2) {
                // TODO: handle exception
                e2.printStackTrace();
            }
        }

        return n > 0;
    }
    
     public boolean lamMoiMatKhau(TaiKhoanEntity tk) {

        try {
            ConnectDB.getInstance().connect();
        } catch (Exception ex) {
            Logger.getLogger(TaiKhoan_dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        Connection con = ConnectDB.getConnection();
        PreparedStatement statement = null;
        int n = 0;
        try {

            statement = con.prepareStatement("update TaiKhoan set matKhau = ? where tenTaiKhoan= ?");
            statement.setString(1, tk.getMatKhau());
            statement.setString(2, tk.getTenTaiKhoan());
            n = statement.executeUpdate();

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
           
        

        } finally {
            try {
                statement.close();
            } catch (Exception e2) {
                // TODO: handle exception
                e2.printStackTrace();
            }
        }

        return n > 0;
    }

    @Override
    public boolean insert(TaiKhoanEntity tk) {
        int n = 0;

        try {
            ConnectDB.getInstance().connect();
        } catch (Exception ex) {
            Logger.getLogger(TaiKhoan_dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        Connection con = ConnectDB.getConnection();
        PreparedStatement statement = null;
        Timestamp timestamp = new Timestamp(new Date().getTime());
        try {
            statement = con.prepareStatement("INSERT INTO TaiKhoan(tenTaiKhoan, matKhau, thoiGianDNGN, tinhTrang) "
                    + " values(?,?,?,?)");
            statement.setString(1, tk.getTenTaiKhoan());
            statement.setString(2, util.MD5Encode.md5Encode(tk.getMatKhau()));
            statement.setTimestamp(3, timestamp);
            statement.setString(4, tk.getTinhTrang().toString());
            n = statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return n > 0;
    }

    @Override
    public boolean update(TaiKhoanEntity tk) {
        int n = 0;
        try {
                 ConnectDB.getInstance().connect();
             } catch (Exception ex) {
                 Logger.getLogger(TaiKhoan_dao.class.getName()).log(Level.SEVERE, null, ex);
             }
         try {
             Connection connection = ConnectDB.getConnection();
             PreparedStatement statement = null;
             statement = connection.prepareStatement("UPDATE TaiKhoan SET tinhTrang = ? WHERE tenTaiKhoan = ?");
             statement.setString(1, tk.getTinhTrang().toString());
             statement.setString(2, tk.getTenTaiKhoan());
             n = statement.executeUpdate();
         } catch (Exception ex) {
             Logger.getLogger(TaiKhoan_dao.class.getName()).log(Level.SEVERE, null, ex);
         }
         return n > 0;
        
    }

    @Override
    public boolean delete(TaiKhoanEntity tk) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public TaiKhoanEntity findOne(String tenTK) {
        TaiKhoanEntity taiKhoan = null;
        try {
            ConnectDB.getInstance().connect();
            Connection con = ConnectDB.getConnection();
            PreparedStatement statement = null;
            try {
                
                String sql = "SELECT * FROM taikhoan WHERE tenTaiKhoan = ?";
                statement = con.prepareStatement(sql);
                statement.setString(1, tenTK);
                ResultSet rs = statement.executeQuery();
                while (rs.next()) {
                    String tk = rs.getString("tenTaiKhoan");
                    String mk = rs.getString("matKhau");
                    
                    taiKhoan = new TaiKhoanEntity();
                    taiKhoan.setMatKhau(mk);
                    taiKhoan.setTenTaiKhoan(tenTK);
                    taiKhoan.setThoiGianDNGN(rs.getTimestamp("thoiGianDNGN").toLocalDateTime());
                    taiKhoan.setTinhTrang(rs.getString("tinhTrang").equals("Đang hoạt động") == true ? TinhTrangTKEnum.DANG_HOAT_DONG : TinhTrangTKEnum.NGUNG_HOAT_DONG);
                    taiKhoan.setNhanVien(nhanVienDAO.findOne(tk));
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    statement.close();
                } catch (Exception e2) {
                    // TODO: handle exception
                    e2.printStackTrace();
                }
            }
            
            
        } catch (Exception ex) {
             Logger.getLogger(TaiKhoan_dao.class.getName()).log(Level.SEVERE, null, ex);
        }
         return taiKhoan;
    }

    @Override
    public ArrayList<TaiKhoanEntity> findAll() {
        ArrayList<TaiKhoanEntity> listTK = new ArrayList<>();
        try {
            connect.connect();
            PreparedStatement statement = connect.getConnection().prepareStatement("SELECT * FROM TaiKhoan");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                TaiKhoanEntity taiKhoan = null;
                String tenTaiKhoan = rs.getString("tenTaiKhoan");
                taiKhoan = new TaiKhoanEntity(tenTaiKhoan, rs.getString("matKhau"), rs.getTimestamp("thoiGianDNGN").toLocalDateTime(), rs.getString("tinhTrang").equals("Đang hoạt động") == true ? TinhTrangTKEnum.DANG_HOAT_DONG : TinhTrangTKEnum.NGUNG_HOAT_DONG);
                taiKhoan.setNhanVien(nhanVienDAO.findOne(tenTaiKhoan));
                if (!listTK.contains(taiKhoan)) listTK.add(taiKhoan);
            }
            connect.disconnect();
        }
        catch (Exception ex) {
            Logger.getLogger(KhachHang_dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listTK;
    }
    
}
