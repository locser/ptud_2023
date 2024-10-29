package entity;

import java.util.Objects;

public class ToaTauEntity {
    private String maToa;
    private String tenToa;
    private int soLuongGhe;
    private String loai;
    private int trangThai;
    private TauEntity maTau;

    public ToaTauEntity(String maToa, String tenToa, int soLuongGhe, String loai, int trangThai, TauEntity maTau) {
        this.maToa = maToa;
        this.tenToa = tenToa;
        this.soLuongGhe = soLuongGhe;
        this.loai = loai;
        this.trangThai = trangThai;
        this.maTau = maTau;
    }

    public String getMaToa() {
        return maToa;
    }

    public void setMaToa(String maToa) {
        this.maToa = maToa;
    }

    public String getTenToa() {
        return tenToa;
    }

    public void setTenToa(String tenToa) {
        this.tenToa = tenToa;
    }

    public int getSoLuongGhe() {
        return soLuongGhe;
    }

    public void setSoLuongGhe(int soLuongGhe) {
        this.soLuongGhe = soLuongGhe;
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

    public TauEntity getMaTau() {
        return maTau;
    }

    public void setMaTau(TauEntity maTau) {
        this.maTau = maTau;
    }

    @Override
    public String toString() {
        return "ToaTauEntity{" +
                "maToa='" + maToa + '\'' +
                ", tenToa='" + tenToa + '\'' +
                ", soLuongGhe=" + soLuongGhe +
                ", loai='" + loai + '\'' +
                ", trangThai=" + trangThai +
                ", maTau='" + maTau + '\'' +
                '}';
    }

	@Override
	public int hashCode() {
		return Objects.hash(maToa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ToaTauEntity other = (ToaTauEntity) obj;
		return Objects.equals(maToa, other.maToa);
	}
    
}
