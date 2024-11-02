package entity;

import java.util.Objects;

public class GheEntity {
    private String maGhe;
    private String maToa;
    private String loai;
    private int trangThai;
    private TauEntity maTau;

    public GheEntity(String maGhe, String maToa, String loai, int trangThai, TauEntity maTau) {
        this.maGhe = maGhe;
        this.maToa = maToa;
        this.loai = loai;
        this.trangThai = trangThai;
        this.maTau = maTau;
    }

    public String getMaGhe() {
        return maGhe;
    }

    public void setMaGhe(String maGhe) {
        this.maGhe = maGhe;
    }

    public String getMaToa() {
        return maToa;
    }

    public void setMaToa(String maToa) {
        this.maToa = maToa;
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
        return "GheEntity{" +
                "maGhe='" + maGhe + '\'' +
                ", maToa='" + maToa + '\'' +
                ", loai='" + loai + '\'' +
                ", trangThai=" + trangThai +
                ", maTau='" + maTau + '\'' +
                '}';
    }

	@Override
	public int hashCode() {
		return Objects.hash(maGhe);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GheEntity other = (GheEntity) obj;
		return Objects.equals(maGhe, other.maGhe);
	}
    
}
