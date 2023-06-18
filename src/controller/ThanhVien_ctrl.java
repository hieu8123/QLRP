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
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
//import model.ThanhVien;
import Model.ThanhVien;

/**
 *
 * @author PC
 */
public class ThanhVien_ctrl {

    public List<ThanhVien> getAllTV() {
        List<ThanhVien> tvs;
        tvs = new ArrayList<ThanhVien>();
        Connection con = JDBCConnection.getJDBCConnection();
        String sql = " select * from thanhvien";
        try {
            PreparedStatement pre = con.prepareStatement(sql);

            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                ThanhVien tv = new ThanhVien();
                tv.setMaTV(rs.getString("MATV"));
                tv.setTenTV(rs.getString("TENTV"));
                tv.setGioiTinh(rs.getString("GIOITINH"));
                tv.setNgaySinh(rs.getDate("NGAYSINH"));
                tv.setDiaChi(rs.getString("DIACHI"));
                tv.setSDT(rs.getString("SDT"));
                tv.setCMND(rs.getString("CMND"));
                tv.setNgayDK(rs.getDate("NGAYDANGKY"));
                tv.setDiemTichLuy(rs.getLong("DIEMTICHLUY"));
                tvs.add(tv);
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
        return tvs;
    }

    public boolean ThemThanhVien(ThanhVien t) {
        String query = " insert into ThanhVien(MATV,TENTV,GIOITINH,NGAYSINH,DIACHI,SDT,CMND,NGAYDANGKY,DIEMTICHLUY) values (?,?,?,?,?,?,?,?,?) ";
        Connection con = JDBCConnection.getJDBCConnection();
        try {
            PreparedStatement pre = con.prepareStatement(query);
            pre.setString(1, t.getMaTV());
            pre.setString(2, t.getTenTV());
            pre.setString(3, t.getGioiTinh());
            pre.setDate(4, t.getNgaySinh());
            pre.setString(5, t.getDiaChi());
            pre.setString(6, t.getSDT());
            pre.setString(7, t.getCMND());
            pre.setDate(8, t.getNgayDK());
            pre.setLong(9, t.getDiemTichLuy());
            return pre.executeUpdate() > 0;
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

    public boolean XoaTV(String matv) {
        String sql = "DELETE FROM THANHVIEN WHERE MATV =?";
        Connection con = JDBCConnection.getJDBCConnection();
        try {

            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, matv);
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

    public boolean CapNhatTV(ThanhVien tv) throws SQLException {
        String query = "UPDATE THANHVIEN SET TENTV =?,GIOITINH = ?, NGAYSINH= ?,DIACHI= ? "
                + ",SDT= ? ,CMND= ? ,NGAYDANGKY= ?, DIEMTICHLUY= ? WHERE MATV = ?";
        Connection con = JDBCConnection.getJDBCConnection();
        try {
            PreparedStatement pt = con.prepareStatement(query);
            pt.setString(1, tv.getTenTV());
            pt.setString(2, tv.getGioiTinh());
            pt.setDate(3, tv.getNgaySinh());
            pt.setString(4, tv.getDiaChi());
            pt.setString(5, tv.getSDT());
            pt.setString(6, tv.getCMND());
            pt.setDate(7, tv.getNgayDK());
            pt.setLong(8, tv.getDiemTichLuy());
            pt.setString(9, tv.getMaTV());
            int tmp = pt.executeUpdate();
            con.close();
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

    public boolean isThanhVien(String MaTV) {
        String query = "select *\n"
                + "from thanhvien\n"
                + "where matv ='" + MaTV + "'";
        Connection con = JDBCConnection.getJDBCConnection();

        try {
            Statement smt = con.createStatement();
            ResultSet rs = smt.executeQuery(query);
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

    public int getDiemTichLuy(String MaTV) {
        int DTL = 0;
        String query = "select DiemTichLuy\n"
                + "from thanhvien\n"
                + "where matv ='" + MaTV + "'";
        Connection con = JDBCConnection.getJDBCConnection();

        try {
            Statement smt = con.createStatement();
            ResultSet rs = smt.executeQuery(query);
            if (rs.next()) {
                DTL = rs.getInt(1);
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
        return DTL;
    }

    public static void updateDiemTichLuy(String MaTV) {
        Connection con = JDBCConnection.getJDBCConnection();
        try {
            String selectQuery = "SELECT SUM(DTL) AS tongdiem FROM HOADON WHERE MaTV = ?";
            PreparedStatement selectStatement = con.prepareStatement(selectQuery);
            selectStatement.setString(1, MaTV);
            ResultSet resultSet = selectStatement.executeQuery();
            int tongDiem = resultSet.getInt("tongdiem");
            String updateQuery = "UPDATE THANHVIEN SET DIEMTICHLUY = ? WHERE MATV = ?";
            PreparedStatement updateStatement = con.prepareStatement(updateQuery);
            updateStatement.setInt(1, tongDiem);
            updateStatement.setString(2, MaTV);
            updateStatement.executeUpdate();
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
}
