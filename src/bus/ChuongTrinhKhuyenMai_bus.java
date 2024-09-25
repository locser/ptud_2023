/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bus;

import Interface.ChuongTrinhKhuyenMai_Interface;
import dao.ChuongTrinhKhuyenMai_dao;
import entity.ChuongTrinhKhuyenMaiEntity;
import entity.LoaiKhuyenMaiEntity;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class ChuongTrinhKhuyenMai_bus implements ChuongTrinhKhuyenMai_Interface{
    ChuongTrinhKhuyenMai_dao ctkm_dao = new ChuongTrinhKhuyenMai_dao();
    @Override
    public ArrayList<ChuongTrinhKhuyenMaiEntity> getallCTKM() {
       return ctkm_dao.getallCTKM();
    }

    @Override
    public ArrayList<ChuongTrinhKhuyenMaiEntity> getCTKMTheoMaCTKM(String maCTKM, String maLoai) {
       return ctkm_dao.getCTKMTheoMaCTKM(maCTKM,maLoai);
    }

    @Override
    public boolean create(ChuongTrinhKhuyenMaiEntity ctkm) {
        return ctkm_dao.create(ctkm);
    }

    @Override
    public boolean delete(ChuongTrinhKhuyenMaiEntity ctkm) {
       return ctkm_dao.delete(ctkm);
    }

    @Override
    public boolean update(ChuongTrinhKhuyenMaiEntity ctkm) {
       return ctkm_dao.update(ctkm);
    }

    @Override
    public ChuongTrinhKhuyenMaiEntity kiemTraKhuyenMai(double tongTien) {
       return ctkm_dao.kiemTraKhuyenMai(tongTien);
    }

    @Override
    public ArrayList<LoaiKhuyenMaiEntity> getallLoaiCTKM() {
        return ctkm_dao.getallLoaiCTKM();

 
    }

    @Override
    public ArrayList<ChuongTrinhKhuyenMaiEntity> getallCTKMtheoLoaiKM(String ma) {
       return ctkm_dao.getallCTKMtheoLoaiKM(ma);
    }

    @Override
    public String layTenKhuyenMaiTheoMa(String maKhuyenMai) {
        return ctkm_dao.layTenKhuyenMaiTheoMa(maKhuyenMai);
    }

    @Override
    public String layMaKhuyenMaiTheoTen(String tenKhuyenMai) {
        return ctkm_dao.layMaKhuyenMaiTheoTen(tenKhuyenMai);
    }

    @Override
    public ChuongTrinhKhuyenMaiEntity getKMTheoma(String ma) {
        return ctkm_dao.getKMTheoma(ma);
    }

    @Override
    public ArrayList<ChuongTrinhKhuyenMaiEntity> getAllCTKMTheoLoaiKMVaTinhTrang(String loaiKM, String tinhTrang) {
        return ctkm_dao.getAllCTKMTheoLoaiKMVaTinhTrang(loaiKM, tinhTrang);
    }

    @Override
    public ChuongTrinhKhuyenMaiEntity getKMTheomaHD(String maHD) {
       return ctkm_dao.getKMTheomaHD(maHD);
    }
}
