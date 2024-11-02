/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import entity.SanPhamEntity;
import entity.TinhTrangSPEnum;
import java.util.ArrayList;

/**
 *
 * @author Tran Hien Vinh
 */
public interface SanPham_Interface {

    public ArrayList<SanPhamEntity> getAllSanPham();

    public boolean themSP(SanPhamEntity sp);

    public ArrayList<SanPhamEntity> timSanPham(String ma);

    public boolean capNhatSanPham(SanPhamEntity sp);

    public ArrayList<SanPhamEntity> kiemTraTonKho();

    public int laySoLuongTonKhoTheoMaSP(String maSP);

    public boolean capNhatSoLuong(String maSP, int soLuongNhap);
    
    public boolean kiemTraMaSanPhamTonTai(String maSP);
    
    public void capNhatKhuyenMai();
    
    public void capNhatTinhTrang(String maSP, TinhTrangSPEnum tinhTrangDangBan);
    
    // Nguyen Huy Hoang
    public SanPhamEntity timKiemSanPham(String ma);
    public boolean capNhatSoLuongTonSauKhiTaoHD(String maSP, int soLuong);
}
