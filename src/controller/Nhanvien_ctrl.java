/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Util.JDBCConnection;
import Model.NhanVien;
import Model.NhanVien;
import static Util.DateConverter.convertDateFormat;
import controller.*;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Admin
 */
public class Nhanvien_ctrl {

    public static ArrayList<NhanVien> hienThiNhanVien() {
        ArrayList<NhanVien> dsnhanvien = new ArrayList<>();
        Connection con = JDBCConnection.getJDBCConnection();
        try {

            //Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orclpdb","DOAN","Benten2001");
            String sql = "select * from nhanvien";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setMaNV(rs.getString("manv"));
                nv.setMaNQL(rs.getString("manql"));
                nv.setMaTK(rs.getString("matk"));
                nv.setHoTenNV(rs.getString("hotennv"));
                nv.setGioiTinh(rs.getString("gioitinh"));
                String ngaysinhString = convertDateFormat(rs.getString("ngaysinh"), "yyyy-MM-dd", "dd-MM-yyyy");
                nv.setNgaySinh(ngaysinhString);
                nv.setSDT(rs.getString("sdt"));
                nv.setDiaChi(rs.getString("diachi"));
                String ngayvaolamString = convertDateFormat(rs.getString("ngayvaolam"), "yyyy-MM-dd", "dd-MM-yyyy");
                nv.setNgayVL(ngayvaolamString);
                nv.setChucVu(rs.getString("chucvu"));
                nv.setLuong(rs.getInt("luong"));
                dsnhanvien.add(nv);
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
        return dsnhanvien;
    }

    public static boolean themNhanvien(NhanVien nv) {
        Connection con = JDBCConnection.getJDBCConnection();
        try {
            //Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orclpdb","DOAN","Benten2001");
            String ngaysinhString = convertDateFormat(nv.getNgaySinh(), "dd-MM-yyyy", "yyyy-MM-dd");
            String ngayvaolamString = convertDateFormat(nv.getNgayVL(), "dd-MM-yyyy", "yyyy-MM-dd");
            String sql = "INSERT INTO NHANVIEN VALUES(?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, nv.getMaNV());
            pst.setString(2, nv.getMaNQL());
            pst.setString(3, nv.getMaTK());
            pst.setString(4, nv.getHoTenNV());
            pst.setString(5, nv.getGioiTinh());
            pst.setString(6, ngaysinhString);
            pst.setString(7, nv.getDiaChi());
            pst.setString(8, nv.getSDT());
            pst.setLong(9, nv.getLuong());
            pst.setString(10, ngayvaolamString);
            pst.setString(11, nv.getChucVu());
            return pst.executeUpdate() > 0;
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

    public static boolean xoaNhanVien(NhanVien nv) {
        Connection con = JDBCConnection.getJDBCConnection();
        try {
            //Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orclpdb","DOAN","Benten2001");
            String sql = "delete from nhanvien where manv=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, nv.getMaNV());
            return pst.executeUpdate() > 0;
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

    public static boolean capNhatNhanVien(NhanVien nv) {
        Connection con = JDBCConnection.getJDBCConnection();
        try {
            //Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orclpdb","DOAN","Benten2001");
            String ngaysinhString = convertDateFormat(nv.getNgaySinh(), "dd-MM-yyyy", "yyyy-MM-dd");
            String ngayvaolamString = convertDateFormat(nv.getNgayVL(), "dd-MM-yyyy", "yyyy-MM-dd");
            String sql = "UPDATE NHANVIEN SET MANQL = ?,MATK = ? ,HOTENNV =?,GIOITINH = ?, NGAYSINH = ?,DIACHI= ? "
                    + ",SDT= ? ,LUONG= ? ,NGAYVAOLAM = ?, CHUCVU= ? WHERE MANV = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, nv.getMaNQL());
            pst.setString(2, nv.getMaTK());
            pst.setString(3, nv.getHoTenNV());
            pst.setString(4, nv.getGioiTinh());
            pst.setString(5, ngaysinhString);
            pst.setString(6, nv.getDiaChi());
            pst.setString(7, nv.getSDT());
            pst.setLong(8, nv.getLuong());
            pst.setString(9, ngayvaolamString);
            pst.setString(10, nv.getChucVu());
            pst.setString(11, nv.getMaNV());
            return pst.executeUpdate() > 0;
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

    public ArrayList<NhanVien> searchdanhsach(String giatri) {
        ArrayList<NhanVien> dsnhanvien = new ArrayList<NhanVien>();
        Connection con = JDBCConnection.getJDBCConnection();
        try {
            //Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orclpdb","DOAN","Benten2001");    
            String sql = "SELECT * FROM nhanvien WHERE manql || manv || matk || hotennv || gioitinh || ngaysinh || diachi || sdt || luong || ngayvaolam|| chucvu LIKE '%" + giatri + "%'";
            PreparedStatement pst = con.prepareCall(sql);
            ResultSet rs = pst.executeQuery(sql);
            while (rs.next()) {
                String ngaysinhString = convertDateFormat(rs.getString("ngaysinh"), "yyyy-MM-dd", "dd-MM-yyyy");
                String ngayvaolamString = convertDateFormat(rs.getString("ngaysinh"), "yyyy-MM-dd", "dd-MM-yyyy");
                NhanVien nv = new NhanVien();
                nv.setMaNV(rs.getString("manv"));
                nv.setMaNQL(rs.getString("manql"));
                nv.setMaTK(rs.getString("matk"));
                nv.setHoTenNV(rs.getString("hotennv"));
                nv.setGioiTinh(rs.getString("gioitinh"));
                nv.setNgaySinh(ngaysinhString);
                nv.setSDT(rs.getString("sdt"));
                nv.setDiaChi(rs.getString("diachi"));
                nv.setNgayVL(ngayvaolamString);
                nv.setChucVu(rs.getString("chucvu"));
                nv.setLuong(rs.getInt("luong"));
                dsnhanvien.add(nv);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return dsnhanvien;
    }
}
