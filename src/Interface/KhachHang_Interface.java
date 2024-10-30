/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import entity.KhachHangEntity;
import java.util.ArrayList;


public interface KhachHang_Interface {
    KhachHangEntity findOne(String id   );
    boolean update(KhachHangEntity updateKH);
    boolean insert(KhachHangEntity insertKH);
    ArrayList<KhachHangEntity> findAll();
//    int count(String id);
    
    // Nguyen Huy Hoang
    public KhachHangEntity timKiemTheoSDT(String sdt);
    // Đinh Nguyên Chung
    public KhachHangEntity getKHTheoMa(String ma);
	KhachHangEntity getKhachHang(String maKH);
}
