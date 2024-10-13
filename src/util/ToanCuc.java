
package util;

public class ToanCuc {
    private static String ma = "";
    private static String ten = "";
    private static int loai = 0 ;
    private static String soDienThoai = "";

    private static int gioiTinh = 0;


    public  ToanCuc(){
    }

    public   String getSoDienThoai() {
        return soDienThoai;
    }

    public static void setSoDienThoai(String sdt) {
        soDienThoai = sdt;
    }

    public static String getTen() {
        return ten;
    }
    public static void setTen(String aName) {
        ten = aName;
    }

    public static String getMa() {
        return ma;
    }

    public static void setMa(String ma) {
        ToanCuc.ma = ma;
    }

    public static int getLoai() {
        return loai;
    }

    public static void setLoai(int loai) {
        ToanCuc.loai =  loai;
    }

    public static String getGioiTinh() {
            if(gioiTinh == 0) {
                return "Nam";
            }
            else return "Nữ";
    }

    public static void setGioiTinh(int gioiTinh) {
        gioiTinh = gioiTinh;
    }
}
