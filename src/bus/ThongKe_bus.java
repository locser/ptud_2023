package bus;

import Interface.ThongKe_Interface;
import dao.ThongKe_dao;
import java.util.ArrayList;

public class ThongKe_bus implements ThongKe_Interface {

    ThongKe_dao tk_dao = new ThongKe_dao();

    @Override
    public ArrayList<Object[]> getListThongKeDoanhThu() {
        return tk_dao.getListThongKeDoanhThu();
    }

    @Override
    public ArrayList<Object[]> getListThongKeDoanhSo() {
        return tk_dao.getListThongKeDoanhSo();
    }

    @Override
    public ArrayList<Object[]> getListDoanhThuTheoThangvaNam(String thang, String nam) {
        return tk_dao.getListDoanhThuTheoThangvaNam(thang, nam);
    }

    @Override
    public ArrayList<Object[]> getListDoanhThuTrongNam(String nam) {
        return tk_dao.getListDoanhThuTrongNam(nam);
    }

    @Override
    public ArrayList<Object[]> getListThongKeDoanhSoTheoThangNam(String thangNam, String sort) {
        return tk_dao.getListThongKeDoanhSoTheoThangNam(thangNam, sort);
    }

    @Override
    public ArrayList<Object[]> getListTop5NhanVienDoanhThuCaoNhat(String thang, String nam) {
        return tk_dao.getListTop5NhanVienDoanhThuCaoNhat(thang, nam);
    }

    @Override
    public ArrayList<Object[]> getListTop5KhachHangMuaHangNhieuNhat(String thang, String nam) {
        return tk_dao.getListTop5KhachHangMuaHangNhieuNhat(thang, nam);
    }

    @Override
    public ArrayList<Object[]> getListThongKeDoanhSoTheoNam(String Nam, String sort) {
        return tk_dao.getListThongKeDoanhSoTheoNam(Nam, sort);
    }

    @Override
    public ArrayList<Object[]> getListDoanhThuBySort(String thang, String nam) {
        return tk_dao.getListDoanhThuBySort(thang, nam);
    }
}
