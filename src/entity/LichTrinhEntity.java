package entity;

import java.util.Date;
import java.util.Objects;

public class LichTrinhEntity {
    private String maLichTrinh;
    private TauEntity maTau;
    private String gaDi;
    private String gaDen;
    private Date ngayDi;
    private Date ngayDen;
    private String trangThai;

    public LichTrinhEntity(String maLichTrinh, TauEntity maTau, String gaDi, String gaDen, Date ngayDi, Date ngayDen, String trangThai) {
        this.maLichTrinh = maLichTrinh;
        this.maTau = maTau;
        this.gaDi = gaDi;
        this.gaDen = gaDen;
        this.ngayDi = ngayDi;
        this.ngayDen = ngayDen;
        this.trangThai = trangThai;
    }

    public String getMaLichTrinh() {
        return maLichTrinh;
    }

    public void setMaLichTrinh(String maLichTrinh) {
        this.maLichTrinh = maLichTrinh;
    }

    public TauEntity getMaTau() {
        return maTau;
    }

    public void setMaTau(TauEntity maTau) {
        this.maTau = maTau;
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

    public Date getNgayDi() {
        return ngayDi;
    }

    public void setNgayDi(Date ngayDi) {
        this.ngayDi = ngayDi;
    }

    public Date getNgayDen() {
        return ngayDen;
    }

    public void setNgayDen(Date ngayDen) {
        this.ngayDen = ngayDen;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "LichTrinhEntity{" +
                "maLichTrinh='" + maLichTrinh + '\'' +
                ", maTau='" + maTau + '\'' +
                ", gaDi='" + gaDi + '\'' +
                ", gaDen='" + gaDen + '\'' +
                ", ngayDi=" + ngayDi +
                ", ngayDen=" + ngayDen +
                ", trangThai='" + trangThai + '\'' +
                '}';
    }

	@Override
	public int hashCode() {
		return Objects.hash(maLichTrinh);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LichTrinhEntity other = (LichTrinhEntity) obj;
		return Objects.equals(maLichTrinh, other.maLichTrinh);
	}
    
}
