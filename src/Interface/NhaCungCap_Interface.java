/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import entity.NhaCungCapEntity;
import java.util.ArrayList;

/**
 *
 * @author Tran Hien Vinh
 */
public interface NhaCungCap_Interface {
    public ArrayList<NhaCungCapEntity> getAllNhaCungCap();
    public boolean themNCC(NhaCungCapEntity ncc);
    public ArrayList<NhaCungCapEntity> timKiemNCC(String ma);
    public boolean capNhatNhaCungCap(NhaCungCapEntity maNCC);
    public ArrayList<NhaCungCapEntity> layDSNCCDangNhap();
    public String layTenNhaCungCapTheoMa(String maNhaCungCap);
    public String layMaNhaCungCapTheoTen(String tenNhaCungCap);
}
