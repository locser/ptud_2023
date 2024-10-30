/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import entity.DanhMucSanPhamEntity;
import java.util.ArrayList;

/**
 *
 * @author Tran Hien Vinh
 */
public interface DanhMucSanPham_Interface {
    public ArrayList<DanhMucSanPhamEntity> getAllDMSP();
    public String layTenDanhMucTheoMa(String maDanhMuc);
    public String layMaDanhMucTheoTen(String tenDanhMuc);
}
