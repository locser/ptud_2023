/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bus;

import Interface.ThuongHieu_Interface;
import dao.ThuongHieu_dao;
import entity.ThuongHieuEntity;
import java.util.ArrayList;

/**
 *
 * @author Tran Hien Vinh
 */
public class ThuongHieu_bus implements ThuongHieu_Interface{
    ThuongHieu_dao th_dao=new ThuongHieu_dao();
    @Override
    public ArrayList<ThuongHieuEntity> getAllTH() {
        return th_dao.getAllTH();
    }

    @Override
    public String layTenThuongHieuTheoMa(String maThuongHieu) {
        return th_dao.layTenThuongHieuTheoMa(maThuongHieu);
    }

    @Override
    public String layMaThuongHieuTheoTen(String tenThuongHieu) {
        return th_dao.layMaThuongHieuTheoTen(tenThuongHieu);
    }
    
}
