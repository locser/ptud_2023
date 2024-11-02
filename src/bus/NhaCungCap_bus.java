/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bus;

import Interface.NhaCungCap_Interface;
import dao.NhaCungCap_dao;
import entity.NhaCungCapEntity;
import java.util.ArrayList;

/**
 *
 * @author Tran Hien Vinh
 */
public class NhaCungCap_bus implements NhaCungCap_Interface{
    NhaCungCap_dao ncc_dao=new NhaCungCap_dao();
    @Override
    public ArrayList<NhaCungCapEntity> getAllNhaCungCap() {
        return ncc_dao.getAllNhaCungCap();
    }

    @Override
    public boolean themNCC(NhaCungCapEntity ncc) {
        return ncc_dao.themNCC(ncc);
    }

    @Override
    public ArrayList<NhaCungCapEntity> timKiemNCC(String ma) {
        return ncc_dao.timKiemNCC(ma);
    }

    @Override
    public boolean capNhatNhaCungCap(NhaCungCapEntity maNCC) {
        return ncc_dao.capNhatNhaCungCap(maNCC);
    }

    @Override
    public ArrayList<NhaCungCapEntity> layDSNCCDangNhap() {
        return ncc_dao.layDSNCCDangNhap();
    }

    @Override
    public String layTenNhaCungCapTheoMa(String maNhaCungCap) {
        return ncc_dao.layTenNhaCungCapTheoMa(maNhaCungCap);
    }

    @Override
    public String layMaNhaCungCapTheoTen(String tenNhaCungCap) {
        return ncc_dao.layMaNhaCungCapTheoTen(tenNhaCungCap);
    }
    
}
