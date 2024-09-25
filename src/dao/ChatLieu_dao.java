/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Interface.ChatLieu_Interface;
import connectDB.ConnectDB;
import entity.ChatLieuEntity;
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
public class ChatLieu_dao implements ChatLieu_Interface{

    @Override
    public ArrayList<ChatLieuEntity> getAllCL() {
        ArrayList<ChatLieuEntity> dsCL=new ArrayList<ChatLieuEntity>();
        try {
            ConnectDB.getInstance().connect();
            Connection con=ConnectDB.getConnection();
            PreparedStatement ps=null;
            String sql="select * from ChatLieu";
            ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {                
                String maChatLieu=rs.getString("maChatLieu");
                String tenChatLieu=rs.getString("tenChatLieu");
                String xuatXu=rs.getString("xuatXu");
                ChatLieuEntity cl=new ChatLieuEntity(maChatLieu, tenChatLieu, xuatXu);
                dsCL.add(cl);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucSanPham_dao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return dsCL;
    }

    @Override
    public String layTenChatLieuTheoMa(String maChatLieu) {
        String tenChatLieu = null;
        try {
            ConnectDB.getInstance().connect();
            Connection con = ConnectDB.getConnection();
            PreparedStatement ps = null;

            String sql = "SELECT tenChatLieu FROM ChatLieu WHERE maChatLieu = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, maChatLieu);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                tenChatLieu = rs.getString("tenChatLieu");
            }

            ps.close();
            rs.close();
            ConnectDB.getInstance().disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(ChatLieu_dao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return tenChatLieu;
    }

    @Override
    public String layMaChatLieuTheoTen(String tenChatLieu) {
        String maChatLieu = null;
        try {
            ConnectDB.getInstance().connect();
            Connection con = ConnectDB.getConnection();
            PreparedStatement ps = null;
            String sql = "SELECT maChatLieu FROM ChatLieu WHERE tenChatLieu = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, tenChatLieu);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                maChatLieu = rs.getString("maChatLieu");
            }

            ps.close();
            rs.close();
            ConnectDB.getInstance().disconnect();
        } catch (Exception ex) {
            Logger.getLogger(ChatLieu_dao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return maChatLieu;
    }
    
}
