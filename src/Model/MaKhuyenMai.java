/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author PC
 */
public class MaKhuyenMai {
    private String maKM,tenKM;
    private int tyLeKM;

    public MaKhuyenMai() {
    }

    public MaKhuyenMai(String maKM, String tenKM, int tyLeKM) {
        this.maKM = maKM;
        this.tenKM = tenKM;
        this.tyLeKM = tyLeKM;
    }

    public String getMaKM() {
        return maKM;
    }

    public void setMaKM(String maKM) {
        this.maKM = maKM;
    }

    public String getTenKM() {
        return tenKM;
    }

    public void setTenKM(String tenKM) {
        this.tenKM = tenKM;
    }

    public int getTyLeKM() {
        return tyLeKM;
    }

    public void setTyLeKM(int tyLeKM) {
        this.tyLeKM = tyLeKM;
    }
    
    
}
