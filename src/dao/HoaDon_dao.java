
package dao;

import entity.HoaDonEntity;
import java.util.ArrayList;
import connectDB.ConnectDB;
import entity.ChiTietHoaDonEntity;
import entity.KhachHangEntity;
import entity.NhanVienEntity;
import java.sql.Date;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.ConvertStringToEnum;


public class HoaDon_dao implements  Interface.HoaDon_Interface{
    
    private ConvertStringToEnum toEnum = new ConvertStringToEnum();
    
    public HoaDon_dao(){
    
    }
    
    @Override
    public ArrayList<HoaDonEntity> getallHoaDon() {
        ArrayList<HoaDonEntity> dshd = new ArrayList<HoaDonEntity>();
        try {
            ConnectDB.getInstance().connect();
            Connection con =ConnectDB.getConnection();
            String sql = "Select * from HoaDon";
             Statement statement = con.createStatement();
             ResultSet rs = statement.executeQuery(sql);
             while(rs.next()){
                 String maHD = rs.getString("maHD");
//                 KhachHangEntity maKH = new KhachHangEntity(rs.getString("maKH"));
                 double tongTien = rs.getDouble("tongTien");
                 int phuongThucThanhToan = rs.getInt("phuongThucThanhToan");
                 String trangThai = rs.getString("trangThai");
                 Date ngayTao = rs.getDate("ngayTao");
                 Date NgayCapNhat = rs.getDate("NgayCapNhat");
                 
                 ConvertStringToEnum toEnum = new ConvertStringToEnum();
                 
//                 HoaDonEntity hd = new HoaDonEntity(maHD, maKH, tongTien, phuongThucThanhToan, toEnum.trangThaiHoaDontoEnum(trangThai),ngayTao,NgayCapNhat);
//                 dshd.add(hd);
             }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dshd;
       
    }

    @Override
    public double getTotalMoney(String maHD) {
        double total = 0;
        String sql = "select tongTien from HoaDon where maHD = ? ";
        try {
            ConnectDB.getInstance().connect();
            Connection con = ConnectDB.getConnection();
            PreparedStatement sta = null;
            sta =  con.prepareStatement(sql);
            sta.setString(1, maHD);
            ResultSet rs = sta.executeQuery();
            while (rs.next()){
                total = rs.getInt("tongTien");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return total;
    }
    
    @Override
    public boolean themHoaDon(HoaDonEntity hoaDon, ArrayList<ChiTietHoaDonEntity> danhSachCTHD) {
        PreparedStatement statement = null;
        try {
            ConnectDB.getInstance().connect();
            Connection con = ConnectDB.getConnection();
            
            String sql = "Insert into HoaDon(maHD, maKH, tongTien, phuongThucThanhToan, trangThai, ngayTao, NgayCapNhat) values (?, ?, ?, ?, ?, ?, ?)";
            statement = con.prepareStatement(sql);
            
            statement.setString(1, hoaDon.getMaHD());
//            statement.setString(2, hoaDon.getKhachHang().getMaKH());
//            statement.setDouble(3, hoaDon.getTongTien());
//            statement.setInt(4, hoaDon.getPhuongThucThanhToan());
//            statement.setString(5, hoaDon.getTrangThai().toString());
            statement.setDate(6, new java.sql.Date(hoaDon.getNgayTao().getTime()));
            statement.setDate(7, new java.sql.Date(hoaDon.getNgayCapNhat().getTime()));
            
            int ketQua = statement.executeUpdate();
            if(ketQua < 1) {
                return false;
            }
            
            ChiTietHoaDon_dao cthd_dao = new ChiTietHoaDon_dao();
            for (ChiTietHoaDonEntity cthd : danhSachCTHD) {
                if(!cthd_dao.themChiTietHoaDon(cthd)) {
                    return false;
                }
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                statement.close();
                ConnectDB.getInstance().disconnect();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    @Override
    public boolean luuTamHoaDon(HoaDonEntity hoaDon, ArrayList<ChiTietHoaDonEntity> danhSachCTHD) {
        PreparedStatement statement = null;
        try {
            ConnectDB.getInstance().connect();
            Connection con = ConnectDB.getConnection();
            
            String sql = "Insert into HoaDon(maHD, maKH, tongTien, phuongThucThanhToan, trangThai, ngayTao, NgayCapNhat) values (?, ?, ?, ?, ?, ?, ?)";
            statement = con.prepareStatement(sql);
            
            statement.setString(1, hoaDon.getMaHD());
//            statement.setString(2, hoaDon.getKhachHang().getMaKH());
            statement.setDouble(3, hoaDon.getTongTien());
//            statement.setInt(4, hoaDon.getPhuongThucThanhToan());
            statement.setString(5, "Chưa thanh toán");
            statement.setDate(6, new java.sql.Date(hoaDon.getNgayTao().getTime()));
            statement.setDate(7, new java.sql.Date(hoaDon.getNgayCapNhat().getTime()));
            
            int ketQua = statement.executeUpdate();
            if(ketQua < 1) {
                return false;
            }
            
            ChiTietHoaDon_dao cthd_dao = new ChiTietHoaDon_dao();
            for (ChiTietHoaDonEntity cthd : danhSachCTHD) {
                if(!cthd_dao.themChiTietHoaDon(cthd)) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                statement.close();
                ConnectDB.getInstance().disconnect();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    @Override
    public boolean capNhatHoaDonLuuTam(HoaDonEntity hoaDon, ArrayList<ChiTietHoaDonEntity> danhSachCTHD) {
        PreparedStatement statement = null;
        try {
            ConnectDB.getInstance().connect();
            Connection con = ConnectDB.getConnection();
            
            String sql = "Update HoaDon set tongTien=?, phuongThucThanhToan=?, trangThai=?, NgayCapNhat=? where maHD=? and maKH=?";
            statement = con.prepareStatement(sql);
            
            statement.setDouble(1, hoaDon.getTongTien());
//            statement.setInt(2, hoaDon.getPhuongThucThanhToan());
            statement.setString(3, "Chưa thanh toán");
            statement.setDate(4, new java.sql.Date(hoaDon.getNgayCapNhat().getTime()));
            statement.setString(5, hoaDon.getMaHD());
//            statement.setString(6, hoaDon.getKhachHang().getMaKH());
            
            int ketQua = statement.executeUpdate();
            if(ketQua < 1) {
                return false;
            }
            
            ChiTietHoaDon_dao cthd_dao = new ChiTietHoaDon_dao();
            boolean kq = cthd_dao.xoaCTHDTheoMaHoaDon(hoaDon.getMaHD());
            
            if(kq) {
                for (ChiTietHoaDonEntity cthd : danhSachCTHD) {
                    if(!cthd_dao.themChiTietHoaDon(cthd)) {
                        return false;
                    }
                }
            } else {
                return false;
            }
            
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                statement.close();
                ConnectDB.getInstance().disconnect();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    @Override
    public boolean themHoaDonLuuTam(HoaDonEntity hoaDon, ArrayList<ChiTietHoaDonEntity> danhSachCTHD) {
        PreparedStatement statement = null;
        try {
            ConnectDB.getInstance().connect();
            Connection con = ConnectDB.getConnection();
            
            String sql = "Update HoaDon set tongTien=?, phuongThucThanhToan=?, trangThai=?, NgayCapNhat=? where maHD=? and maKH=?";
            statement = con.prepareStatement(sql);
            
            statement.setDouble(1, hoaDon.getTongTien());
//            statement.setInt(2, hoaDon.getPhuongThucThanhToan());
            statement.setString(3, "Đã thanh toán");
            statement.setDate(4, new java.sql.Date(hoaDon.getNgayCapNhat().getTime()));
            statement.setString(5, hoaDon.getMaHD());
//            statement.setString(6, hoaDon.getKhachHang().getMaKH());
            
            int ketQua = statement.executeUpdate();
            if(ketQua < 1) {
                return false;
            }
            
            ChiTietHoaDon_dao cthd_dao = new ChiTietHoaDon_dao();
            boolean kq = cthd_dao.xoaCTHDTheoMaHoaDon(hoaDon.getMaHD());
            
            if(kq) {
                for (ChiTietHoaDonEntity cthd : danhSachCTHD) {
                    if(!cthd_dao.themChiTietHoaDon(cthd)) {
                        return false;
                    }
                }
            } else {
                return false;
            }
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                statement.close();
                ConnectDB.getInstance().disconnect();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public ArrayList<HoaDonEntity> timKiemHoaDonChuaThanhToan(String sdt) {
        try {
            ConnectDB.getInstance().connect();
        } catch (Exception ex) {
            Logger.getLogger(HoaDon_dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        Connection con = ConnectDB.getConnection();
        PreparedStatement statement = null;
        
        try {
            String sql = "Select hd.*, kh.hoTen, kh.gioiTinh, kh.soDienThoai, kh.diaChi from HoaDon as hd inner join KhachHang as kh on hd.maKH=kh.maKH " +
            "where kh.soDienThoai=? and hd.trangThai=N'Chưa thanh toán' ";
            statement = con.prepareStatement(sql);
            statement.setString(1, sdt);
            
            ResultSet rs = statement.executeQuery();
            ArrayList<HoaDonEntity> hdList = new ArrayList<>();
            while(rs.next()) {
                String mahd = rs.getString("maHD");
                String makh = rs.getString("maKH");
                String hoTen = rs.getString("hoTen");
                String gioiTinh = rs.getString("gioiTinh");
                String soDienThoai = rs.getString("soDienThoai");
                String diaChi = rs.getString("diaChi");
//                KhachHangEntity kh = new KhachHangEntity();
//                kh.setMaKH(makh);
//                kh.setHoTen(hoTen);
//                kh.setGioiTinh(toEnum.GioiTinhtoEnum(gioiTinh));
//                kh.setSoDienThoai(soDienThoai);
//                kh.setDiaChi(diaChi);
                
                double tongTien = rs.getDouble("tongTien");
                int phuongThucThanhToan = rs.getInt("phuongThucThanhToan");
                Date ngayTao = rs.getDate("ngayTao");
                Date ngayCapNhat = rs.getDate("NgayCapNhat");
                
//                HoaDonEntity hd = new HoaDonEntity(mahd, kh, tongTien, phuongThucThanhToan, toEnum.TinhTrangHDToEnum("Chưa thanh toán"), ngayTao, ngayCapNhat);
//                hdList.add(hd);
            }
            return hdList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if(con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HoaDon_dao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    @Override
    public HoaDonEntity timKiemHoaDonTheoMa(String maHD) {
        try {
            ConnectDB.getInstance().connect();
        } catch (Exception ex) {
            Logger.getLogger(HoaDon_dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        Connection con = ConnectDB.getConnection();
        PreparedStatement statement = null;
        
        try {
            String sql = "Select * from HoaDon where maHD=? and trangThai=N'Đã thanh toán' ";
            statement = con.prepareStatement(sql);
            statement.setString(1, maHD);
            
            ResultSet rs = statement.executeQuery();
            HoaDonEntity hd = null;
            if(rs.next()) {
                String mahd = rs.getString("maHD");
                String makh = rs.getString("maKH");
                double tongTien = rs.getDouble("tongTien");
                int phuongThucThanhToan = rs.getInt("phuongThucThanhToan");
                String trangThai = rs.getString("trangThai");
                Date ngayTao = rs.getDate("ngayTao");
                Date ngayCapNhat = rs.getDate("NgayCapNhat");
//                KhachHangEntity kh = new KhachHangEntity();
                
                if(makh != null) {
//                    kh.setMaKH(makh);
                    String sql_kh = "Select hoTen, soDienThoai from KhachHang where maKH=?";
                    statement = con.prepareStatement(sql_kh);
                    statement.setString(1, makh);
                    
                    rs = statement.executeQuery();
                    if(rs.next()) {
                        String hoTen = rs.getString("hoTen");
                        String soDienThoai = rs.getString("soDienThoai");
//                        kh.setHoTen(hoTen);
//                        kh.setSoDienThoai(soDienThoai);
                    }
                }

//                hd = new HoaDonEntity(mahd, kh, tongTien, phuongThucThanhToan, toEnum.TinhTrangHDToEnum(trangThai), ngayTao, ngayCapNhat);
            }
            return hd;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if(con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HoaDon_dao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    @Override
    public int getSoLuongTonTheoMa(String maSP) {
        try {
            ConnectDB.getInstance().connect();
        } catch (Exception ex) {
            Logger.getLogger(HoaDon_dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        Connection con = ConnectDB.getConnection();
        PreparedStatement statement = null;
        
        try {
            String sql = "Select soLuongTonKho from SanPham where maSP=?";
            statement = con.prepareStatement(sql);
            statement.setString(1, maSP);
            
            ResultSet rs = statement.executeQuery();
            int soLuong=-1;
            if(rs.next()) {
                soLuong = rs.getInt("soLuongTonKho");
                
            }
            return soLuong;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        } finally {
            if(con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HoaDon_dao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    @Override
    public ArrayList<HoaDonEntity> getAllHDChuaThanhToan() {
        try {
            ConnectDB.getInstance().connect();
        } catch (Exception ex) {
            Logger.getLogger(HoaDon_dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        Connection con = ConnectDB.getConnection();
        PreparedStatement statement = null;
        
        try {
            String sql_del = "Delete from HoaDon where year(ngayTao) = year(getdate()) and month(ngayTao) = month(getdate()) and day(ngayTao)<day(getdate()) and trangThai=N'Chưa thanh toán' ";
            statement = con.prepareStatement(sql_del);
            
            statement.executeUpdate();
            
            String sql_sel = "Select hd.*, kh.hoTen, kh.gioiTinh, kh.soDienThoai, kh.diaChi from HoaDon as hd inner join KhachHang as kh on hd.maKH=kh.maKH " +
            "where hd.trangThai=N'Chưa thanh toán' ";
            statement = con.prepareStatement(sql_sel);
            
            ResultSet rs = statement.executeQuery();
            ArrayList<HoaDonEntity> hdList = new ArrayList<>();
            while(rs.next()) {
                String mahd = rs.getString("maHD");
                String makh = rs.getString("maKH");
                String hoTen = rs.getString("hoTen");
                String gioiTinh = rs.getString("gioiTinh");
                String soDienThoai = rs.getString("soDienThoai");
                String diaChi = rs.getString("diaChi");
//                KhachHangEntity kh = new KhachHangEntity();
//                kh.setMaKH(makh);
//                kh.setHoTen(hoTen);
//                kh.setGioiTinh(toEnum.GioiTinhtoEnum(gioiTinh));
//                kh.setSoDienThoai(soDienThoai);
//                kh.setDiaChi(diaChi);
                
                double tongTien = rs.getDouble("tongTien");
                int phuongThucThanhToan = rs.getInt("phuongThucThanhToan");
                Date ngayTao = rs.getDate("ngayTao");
                Date ngayCapNhat = rs.getDate("NgayCapNhat");
                
//                HoaDonEntity hd = new HoaDonEntity(mahd, kh, tongTien, phuongThucThanhToan, toEnum.TinhTrangHDToEnum("Chưa thanh toán"), ngayTao, ngayCapNhat);
//                hdList.add(hd);
            }
            return hdList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if(con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HoaDon_dao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }


    @Override
    public HoaDonEntity getHoaDonTheoMaHD(String maHD) {
            HoaDonEntity hd = null;
            try {
            ConnectDB.getInstance().connect();
            Connection con = ConnectDB.getConnection();
            PreparedStatement stmt = con.prepareCall("select * from HoaDon where maHD = ?");
            stmt.setString(1, maHD);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                String mahd = rs.getString("maHD");
                String makh = rs.getString("maKH");
//                KhachHangEntity kh = new KhachHangEntity(makh);
                double tongTien = rs.getDouble("tongTien");
                int phuongThucThanhToan = rs.getInt("phuongThucThanhToan");
                String trangThai = rs.getString("trangThai");
                Date ngayTao = rs.getDate("ngayTao");
                Date ngayCapNhat = rs.getDate("NgayCapNhat");
                
//                hd = new HoaDonEntity(mahd, kh, tongTien, phuongThucThanhToan, toEnum.TinhTrangHDToEnum(trangThai), ngayTao, ngayCapNhat);
                
            }
                    
        } catch (Exception e) {
            e.printStackTrace();
        }
            return hd;
    }

    @Override
    public ArrayList<HoaDonEntity> getHoaDonTheoNgayLap(Date ngayLap) {
         ArrayList<HoaDonEntity> dshd = new ArrayList<HoaDonEntity>();
            try {
            ConnectDB.getInstance().connect();
            Connection con = ConnectDB.getConnection();
            PreparedStatement stmt = con.prepareCall("select * from HoaDon where ngayTao = ?");
            stmt.setDate(1,ngayLap);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                String mahd = rs.getString("maHD");
                String makh = rs.getString("maKH");
//                KhachHangEntity kh = new KhachHangEntity(makh);
                double tongTien = rs.getDouble("tongTien");
                int phuongThucThanhToan = rs.getInt("phuongThucThanhToan");
                String trangThai = rs.getString("trangThai");
                Date ngayTao = rs.getDate("ngayTao");
                Date ngayCapNhat = rs.getDate("NgayCapNhat");
                
//                HoaDonEntity hd = new HoaDonEntity(mahd, kh, tongTien, phuongThucThanhToan, toEnum.TinhTrangHDToEnum(trangThai), ngayTao, ngayCapNhat);
//                dshd.add(hd);
            }
                    
        } catch (Exception e) {
            e.printStackTrace();
        }
            return dshd;
    }

    @Override
    public ArrayList<HoaDonEntity> getHoaDonTheoMaHDvaNgayLap(String maHD, java.util.Date ngayLap) {
        try {
            ConnectDB.getInstance().connect();
        } catch (Exception ex) {
            Logger.getLogger(HoaDon_dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        Connection con = ConnectDB.getConnection();
        PreparedStatement statement = null;
        
        try {
            String sql = "Select * from HoaDon where maHD=? and ngayTao=? ";
            statement = con.prepareStatement(sql);
            statement.setString(1, maHD);
            statement.setDate(2, new java.sql.Date(ngayLap.getTime()));
            ResultSet rs = statement.executeQuery();
            ArrayList<HoaDonEntity> dshd = new ArrayList<>();
            if(rs.next()) {
                String mahd = rs.getString("maHD");
                String makh = rs.getString("maKH");
                double tongTien = rs.getDouble("tongTien");
                int phuongThucThanhToan = rs.getInt("phuongThucThanhToan");
                String trangThai = rs.getString("trangThai");
                Date ngayTao = rs.getDate("ngayTao");
                Date ngayCapNhat = rs.getDate("NgayCapNhat");
//                KhachHangEntity kh = new KhachHangEntity();
                
                if(makh != null) {
//                    kh.setMaKH(makh);
                    String sql_kh = "Select hoTen, soDienThoai from KhachHang where maKH=?";
                    statement = con.prepareStatement(sql_kh);
                    statement.setString(1, makh);
                    
                    rs = statement.executeQuery();
                    if(rs.next()) {
                        String hoTen = rs.getString("hoTen");
                        String soDienThoai = rs.getString("soDienThoai");
//                        kh.setHoTen(hoTen);
//                        kh.setSoDienThoai(soDienThoai);
                    }
                }

//                HoaDonEntity hd = new HoaDonEntity(mahd, kh, tongTien, phuongThucThanhToan, toEnum.TinhTrangHDToEnum(trangThai), ngayTao, ngayCapNhat);
//                dshd.add(hd);
            }
            return dshd;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if(con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HoaDon_dao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public boolean xoaHoaDon(String maHD) {
        try {
            ConnectDB.getInstance().connect();
        } catch (Exception ex) {
            Logger.getLogger(HoaDon_dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        Connection con = ConnectDB.getConnection();
        PreparedStatement statement = null;
        
        try {
            String sql = "Delete from HoaDon where maHD=?";
            statement = con.prepareStatement(sql);
            statement.setString(1, maHD);
            
            int rs = statement.executeUpdate();
            if(rs > 0) {
                return true;
            }
            
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if(con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HoaDon_dao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
