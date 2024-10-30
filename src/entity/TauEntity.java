package entity;

import java.util.Date;
import java.util.Objects;

public class TauEntity {
	private String maTau;
	private String tenTau;
	private String gaDi;
	private String gaDen;
	private Date thoiGianChay;
	private int soToa;
	private String loai;
	private int trangThai;
	private Date ngayTao;
	private Date ngayCapNhat;
	private NhanVienEntity maNV;

	public TauEntity(String maTau, String tenTau, String gaDi, String gaDen, Date thoiGianChay, int soToa, String loai,
			int trangThai, Date ngayTao, Date ngayCapNhat) {
		this.maTau = maTau;
		this.tenTau = tenTau;
		this.gaDi = gaDi;
		this.gaDen = gaDen;
		this.thoiGianChay = thoiGianChay;
		this.soToa = soToa;
		this.loai = loai;
		this.trangThai = trangThai;
		this.ngayTao = ngayTao;
		this.ngayCapNhat = ngayCapNhat;
	}

	public String getMaTau() {
		return maTau;
	}

	public void setMaTau(String maTau) {
		this.maTau = maTau;
	}

	public String getTenTau() {
		return tenTau;
	}

	public void setTenTau(String tenTau) {
		this.tenTau = tenTau;
	}

	public String getGaDi() {
		return gaDi;
	}

	public void setGaDi(String gaDi) {
		this.gaDi = gaDi;
	}

	public String getGaDen() {
		return gaDen;
	}

	public void setGaDen(String gaDen) {
		this.gaDen = gaDen;
	}

	public Date getThoiGianChay() {
		return thoiGianChay;
	}

	public void setThoiGianChay(Date thoiGianChay) {
		this.thoiGianChay = thoiGianChay;
	}

	public int getSoToa() {
		return soToa;
	}

	public void setSoToa(int soToa) {
		this.soToa = soToa;
	}

	public String getLoai() {
		return loai;
	}

	public void setLoai(String loai) {
		this.loai = loai;
	}

	public int getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
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

	@Override
	public String toString() {
		return "TauEntity{" + "maTau='" + maTau + '\'' + ", tenTau='" + tenTau + '\'' + ", gaDi='" + gaDi + '\''
				+ ", gaDen='" + gaDen + '\'' + ", thoiGianChay=" + thoiGianChay + ", soToa=" + soToa + ", loai='" + loai
				+ '\'' + ", trangThai=" + trangThai + ", ngayTao=" + ngayTao + ", ngayCapNhat=" + ngayCapNhat + '}';
	}

	@Override
	public int hashCode() {
		return Objects.hash(maTau);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TauEntity other = (TauEntity) obj;
		return Objects.equals(maTau, other.maTau);
	}

}
