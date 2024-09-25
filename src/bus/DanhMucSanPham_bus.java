/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bus;

import Interface.DanhMucSanPham_Interface;
import dao.DanhMucSanPham_dao;
import entity.DanhMucSanPhamEntity;
import java.util.ArrayList;

/**
 *
 * @author Tran Hien Vinh
 */
public class DanhMucSanPham_bus implements DanhMucSanPham_Interface{
    DanhMucSanPham_dao dmsp_dao=new DanhMucSanPham_dao();
    @Override
    public ArrayList<DanhMucSanPhamEntity> getAllDMSP() {
        return dmsp_dao.getAllDMSP();
    }

    @Override
    public String layTenDanhMucTheoMa(String maDanhMuc) {
        return dmsp_dao.layTenDanhMucTheoMa(maDanhMuc);
    }

    @Override
    public String layMaDanhMucTheoTen(String tenDanhMuc) {
        return dmsp_dao.layMaDanhMucTheoTen(tenDanhMuc);
    }
    
}
