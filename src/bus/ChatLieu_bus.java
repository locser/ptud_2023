/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bus;

import Interface.ChatLieu_Interface;
import dao.ChatLieu_dao;
import entity.ChatLieuEntity;
import java.util.ArrayList;

/**
 *
 * @author Tran Hien Vinh
 */
public class ChatLieu_bus implements ChatLieu_Interface{
    ChatLieu_dao cl_dao=new ChatLieu_dao();

    @Override
    public ArrayList<ChatLieuEntity> getAllCL() {
        return cl_dao.getAllCL();
    }

    @Override
    public String layTenChatLieuTheoMa(String maChatLieu) {
        return cl_dao.layTenChatLieuTheoMa(maChatLieu);
    }

    @Override
    public String layMaChatLieuTheoTen(String tenChatLieu) {
        return cl_dao.layMaChatLieuTheoTen(tenChatLieu);
    }
}
