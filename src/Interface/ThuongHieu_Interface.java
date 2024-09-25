/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import entity.ThuongHieuEntity;
import java.util.ArrayList;

/**
 *
 * @author Tran Hien Vinh
 */
public interface ThuongHieu_Interface {
    public ArrayList<ThuongHieuEntity> getAllTH();
    public String layTenThuongHieuTheoMa(String maThuongHieu);
    public String layMaThuongHieuTheoTen(String tenThuongHieu);
}
