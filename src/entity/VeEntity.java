package entity;

import java.util.Date;
import java.util.Objects;

public class VeEntity {
    private String maVe;
    private int loai;
    private int trangThai;
    private double gia;
    private Date ngayTao;
    private Date ngayCapNhat;
    private TauEntity maTau;
    private ToaTauEntity maToa;
    private GheEntity maGhe;

    public VeEntity(String maVe, int loai, int trangThai, double gia, Date ngayTao, Date ngayCapNhat, TauEntity maTau, ToaTauEntity maToa, GheEntity maGhe) {
        this.maVe = maVe;
        this.loai = loai;
        this.trangThai = trangThai;
        this.gia = gia;
        this.ngayTao = ngayTao;
        this.ngayCapNhat = ngayCapNhat;
        this.maTau = maTau;
        this.maToa = maToa;
        this.maGhe = maGhe;
    }

    public String getMaVe() {
        return maVe;
    }

    public void setMaVe(String maVe) {
        this.maVe = maVe;
    }

    public int getLoai() {
        return loai;
    }

    public void setLoai(int loai) {
        this.loai = loai;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgayCapNhat() {
        return ngayCapNhat;
    }

    public void setNgayCapNhat(Date ngayCapNhat) {
        this.ngayCapNhat = ngayCapNhat;
    }

    public TauEntity getMaTau() {
        return maTau;
    }

    public void setMaTau(TauEntity maTau) {
        this.maTau = maTau;
    }

    public ToaTauEntity getMaToa() {
        return maToa;
    }

    public void setMaToa(ToaTauEntity maToa) {
        this.maToa = maToa;
    }

    public GheEntity getMaGhe() {
        return maGhe;
    }

    public void setMaGhe(GheEntity maGhe) {
        this.maGhe = maGhe;
    }

    @Override
    public String toString() {
        return "VeEntity{" +
                "maVe='" + maVe + '\'' +
                ", loai=" + loai +
                ", trangThai=" + trangThai +
                ", gia=" + gia +
                ", ngayTao=" + ngayTao +
                ", ngayCapNhat=" + ngayCapNhat +
                ", maTau='" + maTau + '\'' +
                ", maToa='" + maToa + '\'' +
                ", maGhe='" + maGhe + '\'' +
                '}';
    }

	@Override
	public int hashCode() {
		return Objects.hash(maVe);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VeEntity other = (VeEntity) obj;
		return Objects.equals(maVe, other.maVe);
	}
    
}
