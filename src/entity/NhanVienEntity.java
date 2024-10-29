package entity;

import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class NhanVienEntity {

    private String maNV;
    private String ten;
    private int loai;
    private Date ngaySinh;
    private String email;
    private String soDienThoai;
    private String diaChi;
    private int trangThai;
    private Date ngayTao;
    private Date ngayCapNhat;

    private String taiKhoan;
    private String matKhau;

    public NhanVienEntity(String maNV, String ten, int loai, Date ngaySinh, String email, String soDienThoai, String diaChi, int trangThai, Date ngayTao, Date ngayCapNhat, String taiKhoan,String matKhau) {
        this.maNV = maNV;
        this.ten = ten;
        this.loai = loai;
        this.ngaySinh = ngaySinh;
        this.email = email;
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;
        this.trangThai = trangThai;
        this.ngayTao = ngayTao;
        this.ngayCapNhat = ngayCapNhat;
        this.matKhau = matKhau;
    }

    public NhanVienEntity(String maNV) {
        super();
        this.maNV = maNV;
    }

    public NhanVienEntity() {
        super();
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
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

    
    public String getTaiKhoan() {
		return taiKhoan;
	}

	public void setTaiKhoan(String taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

	public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.maNV);
        hash = 79 * hash + Objects.hashCode(this.soDienThoai);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final NhanVienEntity other = (NhanVienEntity) obj;

        return Objects.equals(this.soDienThoai, other.soDienThoai);
    }

    public static int getAge(Date currentDate, Date birthDate) {
        Calendar calendarCurrent = Calendar.getInstance();
        calendarCurrent.setTime(currentDate);

        Calendar calendarBirth = Calendar.getInstance();
        calendarBirth.setTime(birthDate);

        int years = calendarCurrent.get(Calendar.YEAR) - calendarBirth.get(Calendar.YEAR);

        // Check if the birthdate has occurred this year
        if (calendarBirth.get(Calendar.MONTH) > calendarCurrent.get(Calendar.MONTH)
                || (calendarBirth.get(Calendar.MONTH) == calendarCurrent.get(Calendar.MONTH)
                && calendarBirth.get(Calendar.DAY_OF_MONTH) > calendarCurrent.get(Calendar.DAY_OF_MONTH))) {
            years--;
        }

        return years;
    }

    @Override
    public String toString() {
        return "NhanVienEntity{" +
                "maNV='" + maNV + '\'' +
                ", ten='" + ten + '\'' +
                ", loai=" + loai +
                ", ngaySinh=" + ngaySinh +
                ", email='" + email + '\'' +
                ", soDienThoai='" + soDienThoai + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", trangThai=" + trangThai +
                ", ngayTao=" + ngayTao +
                ", ngayCapNhat=" + ngayCapNhat +
                ", taiKhoan='" + taiKhoan + '\'' +
                ", matKhau='" + matKhau + '\'' +
                '}';
    }
}
