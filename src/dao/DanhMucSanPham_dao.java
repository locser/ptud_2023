/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import Interface.DanhMucSanPham_Interface;
import entity.DanhMucSanPhamEntity;
import java.util.ArrayList;
import connectDB.ConnectDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Tran Hien Vinh
 */
public class DanhMucSanPham_dao implements DanhMucSanPham_Interface{

    @Override
    public ArrayList<DanhMucSanPhamEntity> getAllDMSP() {
         ArrayList<DanhMucSanPhamEntity> dsDMSP=new ArrayList<DanhMucSanPhamEntity>();
        try {
            ConnectDB.getInstance().connect();
            Connection con=ConnectDB.getConnection();
            PreparedStatement ps=null;
            String sql="select * from DanhMucSanPham";
            ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {                
                String maDanhMuc=rs.getString("maDanhMuc");
                String tenDanhMuc=rs.getString("tenDanhMuc");
                DanhMucSanPhamEntity dmsp=new DanhMucSanPhamEntity(maDanhMuc, tenDanhMuc);
                dsDMSP.add(dmsp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucSanPham_dao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return dsDMSP;
    }

    @Override
    public String layTenDanhMucTheoMa(String maDanhMuc) {
        String tenDanhMuc = null;
        try {
            ConnectDB.getInstance().connect();
            Connection con = ConnectDB.getConnection();
            PreparedStatement ps = null;

            String sql = "SELECT tenDanhMuc FROM DanhMucSanPham WHERE maDanhMuc = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, maDanhMuc);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                tenDanhMuc = rs.getString("tenDanhMuc");
            }

            ps.close();
            rs.close();
            ConnectDB.getInstance().disconnect();
        } catch (Exception ex) {
            Logger.getLogger(DanhMucSanPham_dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tenDanhMuc;
    }

    @Override
    public String layMaDanhMucTheoTen(String tenDanhMuc) {
        String maDanhMuc = null;
        try {
            ConnectDB.getInstance().connect();
            Connection con = ConnectDB.getConnection();
            PreparedStatement ps = null;
            String sql = "SELECT maDanhMuc FROM DanhMucSanPham WHERE tenDanhMuc = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, tenDanhMuc);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                maDanhMuc = rs.getString("maDanhMuc");
            }

            ps.close();
            rs.close();
            ConnectDB.getInstance().disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucSanPham_dao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return maDanhMuc;
    }
    
}
