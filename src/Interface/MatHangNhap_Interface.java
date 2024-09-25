/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import entity.MatHangNhapEntity;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Tran Hien Vinh
 */
public interface MatHangNhap_Interface {

    public ArrayList<MatHangNhapEntity> getAllMatHangNhap();

    public boolean nhapHang(MatHangNhapEntity mhn);

    public ArrayList<MatHangNhapEntity> timKiemMHN(LocalDate ngayNhap);

    public boolean capNhapMatHangNhap(MatHangNhapEntity mhn);

    public boolean kiemTraMaMatHangNhapTonTai(String maMHN);
}
