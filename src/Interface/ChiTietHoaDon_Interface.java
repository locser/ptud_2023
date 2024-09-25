
package Interface;

import entity.ChiTietHoaDonEntity;
import entity.SanPhamEntity;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public interface ChiTietHoaDon_Interface {
    public ArrayList<ChiTietHoaDonEntity> getallCTHD();
    public ArrayList<SanPhamEntity> getSanPhamTheoMaSP(String maSP); 
    public ArrayList<SanPhamEntity> getSanPhamTheoMaHD(String maHD);
    public int soluongSP(String maHD,String maSP);
    public ArrayList<ChiTietHoaDonEntity> getCTHDTheoMaHDvaMaSP(String maHD,String maSP);
    
    // Nguyen Huy Hoang
    public boolean themChiTietHoaDon(ChiTietHoaDonEntity cthd);
    public ArrayList<ChiTietHoaDonEntity> getAllCTHDTheoMaHD(String maHD);
    public boolean xoaCTHDTheoMaHoaDon(String maHD);
    public int getSoLuongCTHD(String maSP);
}
