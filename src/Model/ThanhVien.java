/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;

/**
 *
 * @author PC
 */
public class ThanhVien {
    private String MaTV,TenTV,GioiTinh,DiaChi,SDT,CMND;
    private String NgaySinh,NgayDK;
    private Long DiemTichLuy;

    public ThanhVien() {
    }

    public ThanhVien(String MaTV, String TenTV, String GioiTinh, String DiaChi, String SDT, String CMND, String NgaySinh, String NgayDK, Long DiemTichLuy) {
        this.MaTV = MaTV;
        this.TenTV = TenTV;
        this.GioiTinh = GioiTinh;
        this.DiaChi = DiaChi;
        this.SDT = SDT;
        this.CMND = CMND;
        this.NgaySinh = NgaySinh;
        this.NgayDK = NgayDK;
        this.DiemTichLuy = DiemTichLuy;
    }

    public String getMaTV() {
        return MaTV;
    }

    public void setMaTV(String MaTV) {
        this.MaTV = MaTV;
    }

    public String getTenTV() {
        return TenTV;
    }

    public void setTenTV(String TenTV) {
        this.TenTV = TenTV;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public String getNgayDK() {
        return NgayDK;
    }

    public void setNgayDK(String NgayDK) {
        this.NgayDK = NgayDK;
    }

    public Long getDiemTichLuy() {
        return DiemTichLuy;
    }

    public void setDiemTichLuy(Long DiemTichLuy) {
        this.DiemTichLuy = DiemTichLuy;
    }
    
    
}
