/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Interface.ThuongHieu_Interface;
import connectDB.ConnectDB;
import entity.ThuongHieuEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tran Hien Vinh
 */
public class ThuongHieu_dao implements ThuongHieu_Interface {

    @Override
    public ArrayList<ThuongHieuEntity> getAllTH() {
        ArrayList<ThuongHieuEntity> dsTH = new ArrayList<ThuongHieuEntity>();
        try {
            ConnectDB.getInstance().connect();
            Connection con = ConnectDB.getConnection();
            PreparedStatement ps = null;
            String sql = "select * from ThuongHieu";
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String maThuongHieu = rs.getString("maThuongHieu");
                String tenThuongHieu = rs.getString("tenThuongHieu");
                ThuongHieuEntity th = new ThuongHieuEntity(maThuongHieu, tenThuongHieu);
                dsTH.add(th);
            }
        } catch (Exception ex) {
            Logger.getLogger(ThuongHieu_dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsTH;
    }

    @Override
    public String layTenThuongHieuTheoMa(String maThuongHieu) {
        String tenThuongHieu = null;
        try {
            ConnectDB.getInstance().connect();
            Connection con = ConnectDB.getConnection();
            PreparedStatement ps = null;

            String sql = "SELECT tenThuongHieu FROM ThuongHieu WHERE maThuongHieu = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, maThuongHieu);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                tenThuongHieu = rs.getString("tenThuongHieu");
            }

            ps.close();
            rs.close();
            ConnectDB.getInstance().disconnect();
        } catch (Exception ex) {
            Logger.getLogger(ThuongHieu_dao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return tenThuongHieu;
    }

    @Override
    public String layMaThuongHieuTheoTen(String tenThuongHieu) {
        String maThuongHieu = null;
        try {
            ConnectDB.getInstance().connect();
            Connection con = ConnectDB.getConnection();
            PreparedStatement ps = null;
            String sql = "SELECT maThuongHieu FROM ThuongHieu WHERE tenThuongHieu = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, tenThuongHieu);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                maThuongHieu = rs.getString("maThuongHieu");
            }

            ps.close();
            rs.close();
            ConnectDB.getInstance().disconnect();
        } catch (Exception ex) {
            Logger.getLogger(ThuongHieu_dao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return maThuongHieu;
    }

}
