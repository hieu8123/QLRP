/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Util.JDBCConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Phi Long
 */
public class DatVe_ctrl {

    //Hàm lấy vị trí ghế đã đặt
    public ArrayList<String> ListGheDaDat(String MaSuatChieu) {

        ArrayList<String> ListGhe = new ArrayList<>();
        Connection con = JDBCConnection.getJDBCConnection();
        String sql = "Select Vitri from DatVe inner join Ghe on DatVe.maghe = Ghe.maghe Where masc ='" + MaSuatChieu + "'";
        try {
            PreparedStatement prest = con.prepareStatement(sql);
            ResultSet rs = prest.executeQuery();
            while (rs.next()) {
                ListGhe.add(rs.getString(1)); //truyền vào listghe vị trí ghế đã đặt
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatVe_ctrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return ListGhe;
    }

    public boolean DatVe(String MAGHE, String MASC, int SOHD) {
        String sp_datve = "INSERT INTO datve (maghe, masc, sohd) VALUES (?, ?, ?)";
        Connection con = JDBCConnection.getJDBCConnection();
        try (
            PreparedStatement smt = con.prepareStatement(sp_datve)) {
            smt.setString(1, MAGHE);
            smt.setString(2, MASC);
            smt.setInt(3, SOHD);
            int rowsInserted = smt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
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

    public int KiemTraGhe(String MAGHE, String MASC) {
        String f_check_seat = "SELECT COUNT(*) AS RowCount "
                + "FROM DATVE "
                + "WHERE MASC = ? AND MAGHE = ?";
        Connection con = JDBCConnection.getJDBCConnection();
        try {
            PreparedStatement smt = con.prepareStatement(f_check_seat);
            smt.setString(1, MASC);
            smt.setString(2, MAGHE);
            ResultSet rs = smt.executeQuery();
            return rs.getInt("RowCount");
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
