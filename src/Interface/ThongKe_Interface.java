
package Interface;

import java.util.ArrayList;

public interface ThongKe_Interface {
    //Đinh Nguyên Chung
    public ArrayList<Object[]> getListThongKeDoanhThu();
    public ArrayList<Object[]> getListThongKeDoanhSo();
    public ArrayList<Object[]> getListDoanhThuTheoThangvaNam(String thang,String nam);
    public ArrayList<Object[]> getListDoanhThuTrongNam(String nam);
    public ArrayList<Object[]> getListThongKeDoanhSoTheoThangNam(String thangNam,String sort);
    public ArrayList<Object[]> getListTop5NhanVienDoanhThuCaoNhat(String thang, String nam);
    public ArrayList<Object[]> getListTop5KhachHangMuaHangNhieuNhat(String thang, String nam);
    public ArrayList<Object[]> getListThongKeDoanhSoTheoNam(String Nam,String sort) ;
    // Đinh Nguyên Chung
    public ArrayList<Object[]> getListDoanhThuBySort(String  thang, String nam);
}
