/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bus;

import Interface.MatHangNhap_Interface;
import dao.MatHangNhap_dao;
import entity.MatHangNhapEntity;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Tran Hien Vinh
 */
public class MatHangNhap_bus implements MatHangNhap_Interface{
    MatHangNhap_dao mhn_dao=new MatHangNhap_dao();
    @Override
    public ArrayList<MatHangNhapEntity> getAllMatHangNhap() {
        return mhn_dao.getAllMatHangNhap();
    }

    @Override
    public boolean nhapHang(MatHangNhapEntity mhn) {
        return mhn_dao.nhapHang(mhn);
    }

    @Override
    public ArrayList<MatHangNhapEntity> timKiemMHN(LocalDate ngayNhap) {
        return mhn_dao.timKiemMHN(ngayNhap);
    }

    @Override
    public boolean capNhapMatHangNhap(MatHangNhapEntity mhm) {
        return mhn_dao.capNhapMatHangNhap(mhm);
    }  

    @Override
    public boolean kiemTraMaMatHangNhapTonTai(String maMHN) {
        return mhn_dao.kiemTraMaMatHangNhapTonTai(maMHN);
    }
    
}
