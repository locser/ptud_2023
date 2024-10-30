
package Interface;

import entity.ChuongTrinhKhuyenMaiEntity;
import entity.LoaiKhuyenMaiEntity;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public interface ChuongTrinhKhuyenMai_Interface {
    public ArrayList<ChuongTrinhKhuyenMaiEntity > getallCTKM();
    public ArrayList<ChuongTrinhKhuyenMaiEntity> getCTKMTheoMaCTKM(String maCTKM, String maLoai);
    public boolean create (ChuongTrinhKhuyenMaiEntity ctkm);
    public boolean delete (ChuongTrinhKhuyenMaiEntity ctkm);
    public boolean update (ChuongTrinhKhuyenMaiEntity ctkm);
    public ArrayList<LoaiKhuyenMaiEntity> getallLoaiCTKM() ;
    public ArrayList<ChuongTrinhKhuyenMaiEntity> getallCTKMtheoLoaiKM(String ma);
    public ChuongTrinhKhuyenMaiEntity getKMTheoma(String ma);
    public ChuongTrinhKhuyenMaiEntity getKMTheomaHD(String maHD);
    
    // Nguyen Huy Hoang
    public ChuongTrinhKhuyenMaiEntity kiemTraKhuyenMai(double tongTien);
    public String layTenKhuyenMaiTheoMa(String maKhuyenMai);
    public String layMaKhuyenMaiTheoTen(String tenKhuyenMai);
    public ArrayList<ChuongTrinhKhuyenMaiEntity> getAllCTKMTheoLoaiKMVaTinhTrang(String loaiKM, String tinhTrang);
}
