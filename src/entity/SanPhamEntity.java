package entity;

import java.util.Objects;

public class SanPhamEntity {

    private String maSP;
    private String tenSP;
    private KichThuocEnum kichThuoc;
    private MauSacEnum mauSac;
    private double donGia;
    private int soLuongTonKho;
    private TinhTrangSPEnum tinhTrang;
    private ChatLieuEntity chatLieu;
    private ThuongHieuEntity thuongHieu;
    private DanhMucSanPhamEntity danhMucSanPham;
    private ChuongTrinhKhuyenMaiEntity chuongTrinhKhuyenMai;
    private String imgUrl;

    public SanPhamEntity() {
        super();
    }

    public SanPhamEntity(String maSP) {
        this.maSP = maSP;
    }

    public SanPhamEntity(String maSP, String tenSP, KichThuocEnum kichThuoc, MauSacEnum mauSac, double donGia, int soLuongTonKho, TinhTrangSPEnum tinhTrang, ChatLieuEntity chatLieu, ThuongHieuEntity thuongHieu, DanhMucSanPhamEntity danhMucSanPham, ChuongTrinhKhuyenMaiEntity chuongTrinhKhuyenMai, String imgUrl) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.kichThuoc = kichThuoc;
        this.mauSac = mauSac;
        this.donGia = donGia;
        this.soLuongTonKho = soLuongTonKho;
        this.tinhTrang = tinhTrang;
        this.chatLieu = chatLieu;
        this.thuongHieu = thuongHieu;
        this.danhMucSanPham = danhMucSanPham;
        this.chuongTrinhKhuyenMai = chuongTrinhKhuyenMai;
        this.imgUrl = imgUrl;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public KichThuocEnum getKichThuoc() {
        return kichThuoc;
    }

    public void setKichThuoc(KichThuocEnum kichThuoc) {
        this.kichThuoc = kichThuoc;
    }

    public MauSacEnum getMauSac() {
        return mauSac;
    }

    public void setMauSac(MauSacEnum mauSac) {
        this.mauSac = mauSac;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public int getSoLuongTonKho() {
        return soLuongTonKho;
    }

    public void setSoLuongTonKho(int soLuongTonKho) {
        this.soLuongTonKho = soLuongTonKho;
    }

    public TinhTrangSPEnum getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(TinhTrangSPEnum tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public ChatLieuEntity getChatLieu() {
        return chatLieu;
    }

    public void setChatLieu(ChatLieuEntity chatLieu) {
        this.chatLieu = chatLieu;
    }

    public ThuongHieuEntity getThuongHieu() {
        return thuongHieu;
    }

    public void setThuongHieu(ThuongHieuEntity thuongHieu) {
        this.thuongHieu = thuongHieu;
    }

    public DanhMucSanPhamEntity getDanhMucSanPham() {
        return danhMucSanPham;
    }

    public void setDanhMucSanPham(DanhMucSanPhamEntity danhMucSanPham) {
        this.danhMucSanPham = danhMucSanPham;
    }

    public ChuongTrinhKhuyenMaiEntity getChuongTrinhKhuyenMai() {
        return chuongTrinhKhuyenMai;
    }

    public void setChuongTrinhKhuyenMai(ChuongTrinhKhuyenMaiEntity chuongTrinhKhuyenMai) {
        this.chuongTrinhKhuyenMai = chuongTrinhKhuyenMai;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public double tinhGiaBan() {
        return this.donGia * 1.4;
    }

    @Override
    public String toString() {
        return "SanPhamEntity{" + "maSP=" + maSP + ", tenSP=" + tenSP + ", kichThuoc=" + kichThuoc + ", mauSac=" + mauSac + ", donGia=" + donGia + ", soLuongTonKho=" + soLuongTonKho + ", tinhTrang=" + tinhTrang + ", chatLieu=" + chatLieu + ", thuongHieu=" + thuongHieu + ", danhMucSanPham=" + danhMucSanPham + ", chuongTrinhKhuyenMai=" + chuongTrinhKhuyenMai + ", imgUrl=" + imgUrl + '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(maSP);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        SanPhamEntity other = (SanPhamEntity) obj;
        return Objects.equals(maSP, other.maSP);
    }
}
