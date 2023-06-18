/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

//import static Controller.Oracle.con;
import Util.JDBCConnection;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import Model.HoaDon;
import java.sql.*;
import Util.DateConverter;
import Model.MaKhuyenMai;
import static Util.DateConverter.convertDateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class HoaDon_ctrl {

    public int TaoHoaDon(String MANV, String MATV, float TONGTIEN, String MAKM, long DTL) {
        String query = "INSERT INTO HOADON (MANV, MATV, TONGTIEN, MAKM, DTL, NGAYHD) VALUES (?, ?, ?, ?, ?, ?)";
        Connection con = JDBCConnection.getJDBCConnection();
        int hoaDonID = 0; // ID của hóa đơn mới được thêm vào

        try {
            PreparedStatement smt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            smt.setString(1, MANV);
            smt.setString(2, MATV);
            smt.setFloat(3, TONGTIEN);
            smt.setString(4, MAKM);
            smt.setLong(5, DTL);
            LocalDate ngayHienTai = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String ngayHienTaiStr = ngayHienTai.format(formatter);
            smt.setString(6, ngayHienTaiStr);
            int rowsAffected = smt.executeUpdate();

            if (rowsAffected > 0) {
                // Lấy ID của hóa đơn mới được thêm vào
                ResultSet generatedKeys = smt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    hoaDonID = generatedKeys.getInt(1);
                }
            }
            ThanhVien_ctrl.updateDiemTichLuy(MATV);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return hoaDonID;
    }

    public static ArrayList<HoaDon> getAllHoaDon() {
        ArrayList<HoaDon> kmList = new ArrayList<>();
        String sql = "SELECT * FROM HOADON";
        Connection con = JDBCConnection.getJDBCConnection();
        try {

            PreparedStatement pt = con.prepareStatement(sql);
            ResultSet rss = pt.executeQuery();

            while (rss.next()) {

                int sohd = rss.getInt(1);
                String manv = rss.getString(2);
                String matv = rss.getString(3);
                String ngayhd = rss.getString(4);
                long tongtien = rss.getLong(5);
                String makm = rss.getString(6);
                int dtl = rss.getInt(7);
                kmList.add(new HoaDon(manv, matv, ngayhd, sohd, tongtien, dtl, makm));
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
    //thêm hàm này

    public static HoaDon getHoaDon(int sohd) {
        Connection con = JDBCConnection.getJDBCConnection();
        String sql = "SELECT * FROM HOADON WHERE SOHD = ?";
        try {
            PreparedStatement prest = con.prepareStatement(sql);
            prest.setInt(1, sohd);
            ResultSet rs = prest.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setSoHD(rs.getInt("SOHD"));
                hd.setMaNV(rs.getString("MaNV"));
                hd.setMaTV(rs.getString("MaTV"));
                hd.setMaKM(rs.getString("MaKM"));
                hd.setTongTien(rs.getLong("TongTien"));
                hd.setNgayHD(rs.getString("NgayHD"));
                hd.setDtl(rs.getInt("DTL"));
                return hd;
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
        return null;
    }

    public boolean Tao_CTHD(String MASP, int SOHD, int SOLUONG, float THANHTIEN) {
        String query = "INSERT INTO CTHD VALUES (?,?,?,?)";
        Connection con = JDBCConnection.getJDBCConnection();
        try {
            PreparedStatement pre = con.prepareStatement(query);
            pre.setString(1, MASP);
            pre.setInt(2, SOHD);
            pre.setInt(3, SOLUONG);
            pre.setFloat(4, THANHTIEN);
            int i = pre.executeUpdate();
            if (i == 1) {
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

    public void hoadontheothang() throws SQLException {

    }

    public static ArrayList<HoaDon> timKiemHoaDon(String param) {
        ArrayList<HoaDon> danhSachHoaDon = new ArrayList<>();
        String sql = "SELECT * FROM HOADON WHERE MANV LIKE ? OR MATV LIKE ? OR MAKM LIKE ?";
        Connection con = JDBCConnection.getJDBCConnection();
        try {
            PreparedStatement smt = con.prepareStatement(sql);
            smt.setString(1, "%" + param + "%");
            smt.setString(2, "%" + param + "%");
            smt.setString(3, "%" + param + "%");
            ResultSet rs = smt.executeQuery();
            while (rs.next()) {
                int sohd = rs.getInt(1);
                String manv = rs.getString(2);
                String matv = rs.getString(3);
                String ngayhd = convertDateFormat(rs.getString(4), "yyyy-MM-dd", "dd-MM-yyyy");
                long tongtien = rs.getLong(5);
                String makm = rs.getString(6);
                int dtl = rs.getInt(7);
                danhSachHoaDon.add(new HoaDon(manv, matv, ngayhd, sohd, tongtien, dtl, makm));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return danhSachHoaDon;
    }

    public static void xoaHoaDon(int sohd) {
        String queryXoaHoaDon = "DELETE FROM HOADON WHERE SOHD = ?";
        String queryXoaCTHD = "DELETE FROM CTHD WHERE SOHD = ?";
        String queryXoaDatVe = "DELETE FROM DATVE WHERE SOHD = ?";
        Connection con = JDBCConnection.getJDBCConnection();
        try {
            ThanhVien_ctrl.updateDiemTichLuy(getHoaDon(sohd).getMaTV());
            PreparedStatement prest_XoaCTHD = con.prepareStatement(queryXoaCTHD);
            PreparedStatement prest_XoaDatVe = con.prepareStatement(queryXoaDatVe);
            PreparedStatement prest_XoaHoaDon = con.prepareStatement(queryXoaHoaDon);
            prest_XoaCTHD.setInt(1, sohd);
            prest_XoaDatVe.setInt(1, sohd);
            prest_XoaHoaDon.setInt(1, sohd);
            prest_XoaCTHD.executeUpdate();
            prest_XoaDatVe.executeUpdate();
            prest_XoaHoaDon.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
