/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bus;

import Interface.SanPham_Interface;
import dao.SanPham_dao;
import entity.SanPhamEntity;
import entity.TinhTrangSPEnum;
import java.util.ArrayList;

/**
 *
 * @author Tran Hien Vinh
 */
public class SanPham_bus implements SanPham_Interface{
    SanPham_dao sp_dao =new SanPham_dao();
    @Override
    public ArrayList<SanPhamEntity> getAllSanPham() {
        return sp_dao.getAllSanPham();
    }

    @Override
    public boolean themSP(SanPhamEntity sp) {
        return sp_dao.themSP(sp);
    }

    @Override
    public ArrayList<SanPhamEntity> timSanPham(String ma) {
        return sp_dao.timSanPham(ma);
    }

    @Override
    public boolean capNhatSanPham(SanPhamEntity sp) {
        return sp_dao.capNhatSanPham(sp);
    }

    @Override
    public ArrayList<SanPhamEntity> kiemTraTonKho() {
        return sp_dao.kiemTraTonKho();
    }

    @Override
    public SanPhamEntity timKiemSanPham(String ma) {
        return sp_dao.timKiemSanPham(ma);
    }
    @Override
    public int laySoLuongTonKhoTheoMaSP(String maSP) {
        return sp_dao.laySoLuongTonKhoTheoMaSP(maSP);
    }

    @Override
    public boolean capNhatSoLuong(String maSP, int soLuongNhap) {
        return sp_dao.capNhatSoLuong(maSP, soLuongNhap);
    }

    @Override
    public boolean kiemTraMaSanPhamTonTai(String maSP) {
        return sp_dao.kiemTraMaSanPhamTonTai(maSP);
    }

    @Override
    public boolean capNhatSoLuongTonSauKhiTaoHD(String maSP, int soLuong) {
        return sp_dao.capNhatSoLuongTonSauKhiTaoHD(maSP, soLuong);
    }

    @Override
    public void capNhatKhuyenMai() {
        sp_dao.capNhatKhuyenMai();
    }

    @Override
    public void capNhatTinhTrang(String maSP, TinhTrangSPEnum tinhTrangDangBan) {
        sp_dao.capNhatTinhTrang(maSP, tinhTrangDangBan);
    }
    
}
