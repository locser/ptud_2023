package entity;

import java.util.Objects;

public class ChiTietHoaDonEntity {
	
	private SanPhamEntity sanPham;
	private HoaDonEntity hoaDon;
	private int soLuong;
        private double giaGoc;
        private double giaBan;
        private double thanhTien;

        public ChiTietHoaDonEntity(SanPhamEntity sanPham, HoaDonEntity hoaDon, int soLuong, double giaGoc, double giaBan, double thanhTien) {
            this.sanPham = sanPham;
            this.hoaDon = hoaDon;
            this.soLuong = soLuong;
            this.giaGoc = giaGoc;
            this.giaBan = giaBan;
            this.thanhTien = thanhTien;
        }

	public ChiTietHoaDonEntity() {
	}

	public SanPhamEntity getSanPham() {
		return sanPham;
	}
	public void setSanPham(SanPhamEntity sanPham) {
		this.sanPham = sanPham;
	}
	public HoaDonEntity getHoaDon() {
		return hoaDon;
	}
	public void setHoaDon(HoaDonEntity hoaDon) {
		this.hoaDon = hoaDon;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
        
        public double getGiaGoc() {
            return giaGoc;
        }

        public void setGiaGoc() {
            this.giaGoc = sanPham.getDonGia() * 1.4;
        }

        public double getGiaBan() {
            return giaBan;
        }

        public void setGiaBan() {
            if(sanPham.getChuongTrinhKhuyenMai() != null) {
                this.giaBan = this.giaGoc * (1 - (sanPham.getChuongTrinhKhuyenMai().getGiamGia() * 0.01));
            } else {
                this.giaBan = this.giaGoc;
            }
        }

        public double getThanhTien() {
            return thanhTien;
        }

        public void setThanhTien() {
            this.thanhTien = giaBan * soLuong;
        }

        @Override
        public String toString() {
            return "ChiTietHoaDonEntity{" + "sanPham=" + sanPham + ", hoaDon=" + hoaDon + ", soLuong=" + soLuong + ", giaGoc=" + giaGoc + ", giaBan=" + giaBan + ", thanhTien=" + thanhTien + '}';
        }
 
}
