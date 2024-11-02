/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bus;

import dao.KhachHang_dao;
import entity.KhachHangEntity;
import java.util.ArrayList;
import util.GenerateID;
import Interface.KhachHang_Interface;

/**
 *
 * @author HUY
 */
public class KhachHang_bus implements KhachHang_Interface {
    KhachHang_dao khachHangDAO = new KhachHang_dao();
    
    @Override
    public KhachHangEntity findOne(String id) {
        return khachHangDAO.findOne(id);
    }

    @Override
    public boolean update(KhachHangEntity updateKH) {
        return khachHangDAO.update(updateKH);
    }

    @Override
    public boolean insert(KhachHangEntity insertKH) {
//        insertKH.setMaKH(generateID.sinhMa(khachHangDAO.count(GenerateID.dateFormat()), "KH"));
        return khachHangDAO.insert(insertKH);
    }

    @Override
    public ArrayList<KhachHangEntity> findAll() {
        return khachHangDAO.findAll();
    }

//    @Override
//    public int count(String id) {
//        return khachHangDAO.count(id);
//    }
    
    // Nguyen Huy Hoang
    @Override
    public KhachHangEntity timKiemTheoSDT(String sdt) {
        return khachHangDAO.timKiemTheoSDT(sdt);
    }

    @Override
    public KhachHangEntity getKHTheoMa(String ma) {
       return khachHangDAO.getKHTheoMa(ma);
    }
    
}
