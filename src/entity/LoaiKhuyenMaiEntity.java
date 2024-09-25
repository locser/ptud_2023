/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author DELL
 */
public class LoaiKhuyenMaiEntity {
    private String maLoaiKM, moTa;

    public LoaiKhuyenMaiEntity(String maLoaiKM, String moTa) {
        this.maLoaiKM = maLoaiKM;
        this.moTa = moTa;
    }

    public LoaiKhuyenMaiEntity() {
    }

    public LoaiKhuyenMaiEntity(String maLoaiKM) {
        this.maLoaiKM = maLoaiKM;
    }
    
    
    public String getMaLoaiKM() {
        return maLoaiKM;
    }

    public void setMaLoaiKM(String maLoaiKM) {
        this.maLoaiKM = maLoaiKM;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
    
    
}
