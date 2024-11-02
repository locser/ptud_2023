package entity;

import java.util.Objects;

public class GaTauEntity {
    private String maGa;
    private String tenGa;
    private String diaChi;
<<<<<<<<< Temporary merge branch 1
    private String soDienThoai;

    public GaTauEntity(String maGa, String tenGa, String diaChi, String soDienThoai) {
        this.maGa = maGa;
        this.tenGa = tenGa;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
=========
    private int trangThai;

    private NhanVienEntity nhanVien;

    public GaTauEntity(String maGa, String tenGa, String diaChi) {
        this.maGa = maGa;
        this.tenGa = tenGa;
        this.diaChi = diaChi;
    }

    public GaTauEntity(String maGa, String tenGa) {
        this.maGa = maGa;
        this.tenGa = tenGa;
    }

    public GaTauEntity(String maGa) {
        this.maGa = maGa;
    }
    public GaTauEntity(String maGa, String ten, NhanVienEntity nhanVien) {
        this.maGa = maGa;
        this.tenGa = ten;
        this.nhanVien = nhanVien;
    }

    public GaTauEntity(String maGa, String ten, int trangThai, NhanVienEntity nhanVien) {
        this.maGa = maGa;
        this.tenGa = ten;
        this.trangThai = trangThai;
        this.nhanVien = nhanVien;
    }

    public GaTauEntity(String maGa, String ten, int trangThai) {
        this.maGa = maGa;
        this.tenGa = ten;
        this.trangThai = trangThai;
>>>>>>>>> Temporary merge branch 2
    }

    public String getMaGa() {
        return maGa;
    }

    public void setMaGa(String maGa) {
        this.maGa = maGa;
    }

    public String getTenGa() {
        return tenGa;
    }

    public void setTenGa(String tenGa) {
        this.tenGa = tenGa;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

<<<<<<<<< Temporary merge branch 1
    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
=========
    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public NhanVienEntity getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVienEntity nhanVien) {
        this.nhanVien = nhanVien;
>>>>>>>>> Temporary merge branch 2
    }

    @Override
    public String toString() {
        return "GaTauEntity{" +
                "maGa='" + maGa + '\'' +
                ", tenGa='" + tenGa + '\'' +
                ", diaChi='" + diaChi + '\'' +
<<<<<<<<< Temporary merge branch 1
                ", soDienThoai='" + soDienThoai + '\'' +
=========
>>>>>>>>> Temporary merge branch 2
                '}';
    }

	@Override
	public int hashCode() {
		return Objects.hash(maGa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
		if (getClass() != obj.getClass())
		return Objects.equals(maGa, other.maGa);
	}
    
}
