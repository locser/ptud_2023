package entity;

import java.util.Objects;

public class DanhMucSanPhamEntity {
	private String maDanhMuc, tenDanhMuc;

	public DanhMucSanPhamEntity(String maDanhMuc, String tenDanhMuc) {
		super();
		this.maDanhMuc = maDanhMuc;
		this.tenDanhMuc = tenDanhMuc;
	}

	public DanhMucSanPhamEntity(String maDanhMuc) {
		super();
		this.maDanhMuc = maDanhMuc;
	}

	public DanhMucSanPhamEntity() {
		super();
	}

	public String getMaDanhMuc() {
		return maDanhMuc;
	}

	public void setMaDanhMuc(String maDanhMuc) {
		this.maDanhMuc = maDanhMuc;
	}

	public String getTenDanhMuc() {
		return tenDanhMuc;
	}

	public void setTenDanhMuc(String tenDanhMuc) {
		this.tenDanhMuc = tenDanhMuc;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maDanhMuc);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DanhMucSanPhamEntity other = (DanhMucSanPhamEntity) obj;
		return Objects.equals(maDanhMuc, other.maDanhMuc);
	}

	@Override
	public String toString() {
		return "DanhMucSanPhamEntity [maDanhMuc=" + maDanhMuc + ", tenDanhMuc=" + tenDanhMuc + "]";
	}
	
	
}	
