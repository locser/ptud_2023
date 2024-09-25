/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Objects;

/**
 *
 * @author HUY
 */
public class KhachHangEntity {
    private String maKH;
    private String hoTen;
    private GioiTinhEnum gioiTinh;
    private String soDienThoai;
    private String diaChi;
	public KhachHangEntity(String maKH, String hoTen, GioiTinhEnum gioiTinh, String soDienThoai, String diaChi) {
		super();
		this.maKH = maKH;
		this.hoTen = hoTen;
		this.gioiTinh = gioiTinh;
		this.soDienThoai = soDienThoai;
		this.diaChi = diaChi;
	}
	public KhachHangEntity(String maKH) {
		super();
		this.maKH = maKH;
	}
	public KhachHangEntity() {
		super();
	}
	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public GioiTinhEnum getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(GioiTinhEnum gioiTinh) {
		this.gioiTinh = gioiTinh;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.maKH);
        hash = 29 * hash + Objects.hashCode(this.soDienThoai);
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
        final KhachHangEntity other = (KhachHangEntity) obj;
        
        return Objects.equals(this.soDienThoai, other.soDienThoai);
    }
	
}
