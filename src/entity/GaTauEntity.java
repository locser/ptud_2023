package entity;

import java.util.Objects;

public class GaTauEntity {
    private String maGa;
    private String tenGa;
    private String diaChi;
    private String soDienThoai;

    public GaTauEntity(String maGa, String tenGa, String diaChi, String soDienThoai) {
        this.maGa = maGa;
        this.tenGa = tenGa;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
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

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    @Override
    public String toString() {
        return "GaTauEntity{" +
                "maGa='" + maGa + '\'' +
                ", tenGa='" + tenGa + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", soDienThoai='" + soDienThoai + '\'' +
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
