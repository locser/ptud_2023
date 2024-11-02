/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import entity.ChatLieuEntity;
import java.util.ArrayList;

/**
 *
 * @author Tran Hien Vinh
 */
public interface ChatLieu_Interface {
    public ArrayList<ChatLieuEntity> getAllCL();
    public String layTenChatLieuTheoMa(String maChatLieu);
    public String layMaChatLieuTheoTen(String tenChatLieu);
}
