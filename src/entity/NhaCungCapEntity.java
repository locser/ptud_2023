package entity;

import java.util.Objects;

public class NhaCungCapEntity {
	private String maNCC, tenNCC, diaChi, soDienThoai;
	private TinhTrangNCCEnum tinhTrang;
	public NhaCungCapEntity(String maNCC, String tenNCC, String diaChi, String soDienThoai, TinhTrangNCCEnum tinhTrang) {
		super();
		this.maNCC = maNCC;
		this.tenNCC = tenNCC;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
		this.tinhTrang = tinhTrang;
	}
	public NhaCungCapEntity(String maNCC) {
		super();
		this.maNCC = maNCC;
	}
	public NhaCungCapEntity() {
		super();
	}
	public String getMaNCC() {
		return maNCC;
	}
	public void setMaNCC(String maNCC) {
		this.maNCC = maNCC;
	}
	public String getTenNCC() {
		return tenNCC;
	}
	public void setTenNCC(String tenNCC) {
		this.tenNCC = tenNCC;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public TinhTrangNCCEnum getTinhTrang() {
		return tinhTrang;
	}
	public void setTinhTrang(TinhTrangNCCEnum tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
	@Override
	public String toString() {
		return "NhaCungCapEntity [maNCC=" + maNCC + ", tenNCC=" + tenNCC + ", diaChi=" + diaChi + ", soDienThoai="
				+ soDienThoai + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(maNCC);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhaCungCapEntity other = (NhaCungCapEntity) obj;
		return Objects.equals(maNCC, other.maNCC);
	}
	
	// Kiểm tra xem nhà cung cấp có chứa tiêu chí tìm kiếm không
        public boolean matchesSearchTerm(String search) {
            return maNCC.contains(search) || tenNCC.contains(search) || soDienThoai.contains(search) || diaChi.contains(search)||tinhTrang.toString().contains(search);
        }
}
