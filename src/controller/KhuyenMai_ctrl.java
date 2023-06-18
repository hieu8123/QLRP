/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Util.JDBCConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Model.MaKhuyenMai;
import Model.MaKhuyenMai;
import Model.NhanVien;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class KhuyenMai_ctrl {

    public boolean isKhuyenMai(String MaKM) {
        String query = "SELECT * FROM khuyenmai WHERE makm = ?";
        Connection con = JDBCConnection.getJDBCConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, MaKM);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public int getTyleKM(String MaKM) {
        int TLKM = 0;
        String query = "SELECT TyleKM FROM khuyenmai WHERE makm = ?";
        Connection con = JDBCConnection.getJDBCConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, MaKM);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                TLKM = rs.getInt("TyleKM");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return TLKM;
    }

    public static ArrayList<MaKhuyenMai> getAllMaKhuyenMai() {
        ArrayList<MaKhuyenMai> kmList = new ArrayList<>();
        Connection con = JDBCConnection.getJDBCConnection();
        String sql = "SELECT * FROM KHUYENMAI";
        try (
            PreparedStatement pstmt = con.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                String makm = rs.getString("makm");
                String tenkm = rs.getString("tenkm");
                int tyle = rs.getInt("tyle");

                kmList.add(new MaKhuyenMai(makm, tenkm, tyle));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return kmList;
    }

    public boolean addMaKhuyenMai(MaKhuyenMai t) {
//        String  ngay = ""
        String query = "INSERT INTO KHUYENMAI VALUES(?,?,?)";
        //String q = "insert into thanhvien(hoten,masv,ngsinh) values(?,?,to_date(....))
        Connection con = JDBCConnection.getJDBCConnection();
        try {
            PreparedStatement pt = con.prepareStatement(query);
            pt.setString(1, t.getMaKM());

            pt.setString(2, t.getTenKM());
            pt.setInt(3, t.getTyLeKM());

            return pt.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;

    }

    public boolean XoaMaKhuyenMai(MaKhuyenMai tv) {
        String sql = "DELETE FROM KHUYENMAI WHERE MAKM = ?";
        Connection con = JDBCConnection.getJDBCConnection();
        try {
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, tv.getMaKM());
            int tmp = pre.executeUpdate();
            if (tmp > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void CapNhatKM(MaKhuyenMai tv) {
        String query = "UPDATE KHUYENMAI SET TENKM = ?,TYLEKM = ?  WHERE MAKM = ?";
        Connection con = JDBCConnection.getJDBCConnection();
        try {
            con.setAutoCommit(false);
            con.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            PreparedStatement pt = con.prepareStatement(query);
            pt.setString(1, tv.getTenKM());
            pt.setInt(2, tv.getTyLeKM());
            pt.setString(3, tv.getMaKM());

            int tmp = pt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public List<MaKhuyenMai> getAllLMaGG() {
        List<MaKhuyenMai> khuyenMais;
        khuyenMais = new ArrayList<MaKhuyenMai>();

        Connection con = JDBCConnection.getJDBCConnection();

        String sql = "SELECT * FROM KHUYENMAI";

        try {
            PreparedStatement prest = con.prepareStatement(sql);

            ResultSet rs = prest.executeQuery();
            while (rs.next()) {
                MaKhuyenMai km = new MaKhuyenMai();

                km.setMaKM(rs.getString("MaKm"));
                km.setTenKM(rs.getString("TenKM"));
                km.setTyLeKM(rs.getInt("TYLEKM"));
                khuyenMais.add(km);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LPhim_ctrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return khuyenMais;
    }

    //hàm thêm loại phim
    public void ThemKM(MaKhuyenMai khuyenMai) {
        Connection con = JDBCConnection.getJDBCConnection();

        String sql = "Insert into KHUYENMAI (MaKM,TENKM,TYLEKM) Values(?,?,?)";
        try {
            PreparedStatement prest = con.prepareStatement(sql);
            prest.setString(1, khuyenMai.getMaKM());
            prest.setString(2, khuyenMai.getTenKM());
            prest.setLong(3, khuyenMai.getTyLeKM());

            int rs = prest.executeUpdate();
            System.out.println(rs);
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(LPhim_ctrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    //hàm sửa loại phim
    public void SuaKM(MaKhuyenMai khuyenMai) {
        Connection con = JDBCConnection.getJDBCConnection();

        String sql = "Update KHUYENMAI Set TENKM = ? ,TYLEKM = ? where MaKM = ?";

        try {
            PreparedStatement prest = con.prepareStatement(sql);

            prest.setLong(2, khuyenMai.getTyLeKM());
            prest.setString(1, khuyenMai.getTenKM());
            prest.setString(3, khuyenMai.getMaKM());

            int rs = prest.executeUpdate();
            System.out.println(rs);

        } catch (SQLException ex) {
            Logger.getLogger(LPhim_ctrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //hàm xoá loại phim
    public void XoaKM(String MaKM) {
        Connection con = JDBCConnection.getJDBCConnection();

        String sql = "Delete from KHUYENMAI where MaKM = ?";
        try {
            PreparedStatement prest = con.prepareStatement(sql);
            prest.setString(1, MaKM);
            int rs = prest.executeUpdate();
            System.out.println(rs);
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(LPhim_ctrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public MaKhuyenMai getKM(String makm) {

        Connection con = JDBCConnection.getJDBCConnection();

        String sql = "SELECT * FROM KHUYENMAI WHERE MaKM = ?";

        try {
            PreparedStatement prest = con.prepareStatement(sql);
            prest.setString(1, makm);
            ResultSet rs = prest.executeQuery();
            while (rs.next()) {
                MaKhuyenMai km = new MaKhuyenMai();

                km.setMaKM(rs.getString("MaKm"));
                km.setTenKM(rs.getString("TenKM"));
                km.setTyLeKM(rs.getInt("TYLEKM"));

                return km;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LPhim_ctrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
