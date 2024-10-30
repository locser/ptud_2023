package entity;

public class TauEntity {
	private String maTau;
	private String tenTau;
	private int soToa;
	private int soChoNgoi;
	private String trangThai;

	public TauEntity() {
	}

	public TauEntity(String maTau, String tenTau, int soToa, int soChoNgoi, String trangThai) {
		this.maTau = maTau;
		this.tenTau = tenTau;
		this.soToa = soToa;
		this.soChoNgoi = soChoNgoi;
		this.trangThai = trangThai;
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

	public int getSoToa() {
		return soToa;
	}

	public void setSoToa(int soToa) {
		this.soToa = soToa;
	}

	public int getSoChoNgoi() {
		return soChoNgoi;
	}

	public void setSoChoNgoi(int soChoNgoi) {
		this.soChoNgoi = soChoNgoi;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	@Override
	public String toString() {
		return "TauEntity{" + "maTau=" + maTau + ", tenTau=" + tenTau + 
			   ", soToa=" + soToa + ", soChoNgoi=" + soChoNgoi + 
			   ", trangThai=" + trangThai + '}';
	}
}
