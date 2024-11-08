
package util;

import javax.swing.JPanel;

import entity.GheEntity;
import entity.ToaTauEntity;
import entity.TauEntity;
import java.util.ArrayList;
import javax.swing.JLabel;

public class ToanCuc {
    private static String ma = "";
    private static String ten = "";
    private static int loai = 0;
    private static String soDienThoai = "";

    private static GheEntity gheHienTai = null;
    
    private static ArrayList<GheEntity> danhSachGheHienTai = new ArrayList<>();

    public static ArrayList<GheEntity> getDanhSachGheHienTai() {
        return danhSachGheHienTai;
    }

    public static void setDanhSachGheHienTai(ArrayList<GheEntity> danhSachGheHienTai) {
        ToanCuc.danhSachGheHienTai = danhSachGheHienTai;
    }
    
    public static void themGheDanhSachGheHienTai(GheEntity ghe) {
        ToanCuc.danhSachGheHienTai.add(ghe);
    }
    
    public static void xoaGheDanhSachGheHienTai(GheEntity ghe) {
        ToanCuc.danhSachGheHienTai.remove(ghe);
    }
    
    private static TauEntity tauHienTai = null;

    private static ToaTauEntity toaHienTai = null;

    private static JPanel panelGheHienTai;
    
    private static JLabel jLabelGheHienTai;

    public static JLabel getjLabelGheHienTai() {
        return jLabelGheHienTai;
    }

    public static void setjLabelGheHienTai(JLabel jLabelGheHienTai) {
        ToanCuc.jLabelGheHienTai = jLabelGheHienTai;
    }


    private static int gioiTinh = 0;

    public ToanCuc() {
    }

    public static TauEntity getTauHienTai() {
        return tauHienTai;
    }

    public static JPanel getPanelGheHienTai() {
        return panelGheHienTai;
    }

    public static void setPanelGheHienTai(JPanel panelGheHienTai) {
        ToanCuc.panelGheHienTai = panelGheHienTai;
    }


    public static void setTauHienTai(TauEntity tauHienTai) {
        ToanCuc.tauHienTai = tauHienTai;
    }

    public static ToaTauEntity getToaHienTai() {
        return toaHienTai;
    }

    public static void setToaHienTai(ToaTauEntity toaHienTai) {
        ToanCuc.toaHienTai = toaHienTai;
    }

    public static GheEntity getGheHienTai() {
        return gheHienTai;
    }

    public static void setGheHienTai(GheEntity gheHienTai) {
        ToanCuc.gheHienTai = gheHienTai;
    }

    public String getSoDienThoai() {
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
        ToanCuc.loai = loai;
    }

    public static String getGioiTinh() {
        if (gioiTinh == 0) {
            return "Nam";
        } else
            return "Nữ";
    }

    public static void setGioiTinh(int gioiTinh) {
        gioiTinh = gioiTinh;
    }
}
