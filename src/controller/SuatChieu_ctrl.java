/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author ASUS
 */
import Util.JDBCConnection;
import Util.DateConverter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import Model.SuatChieu;
import static Util.DateConverter.convertDateFormat;
import Model.SuatChieu;
import java.util.List;

/**
 *
 * @author PC
 */
public class SuatChieu_ctrl {

    public List<SuatChieu> getAllLSuatChieu() {
        List<SuatChieu> suatChieus;
        suatChieus = new ArrayList<SuatChieu>();
        Connection con = JDBCConnection.getJDBCConnection();
        String sql = "SELECT * FROM SuatChieu order by MaSC asc ";
        try {
            PreparedStatement prest = con.prepareStatement(sql);
            //prest.setString(1, sc.getMaSC());
            ResultSet rs = prest.executeQuery();
            while (rs.next()) {
                SuatChieu sc = new SuatChieu();

                sc.setMaPhim(rs.getString("MaPhim"));
                sc.setMaRap(rs.getString("MaRap"));
                sc.setMaSC(rs.getString("MaSC"));
                String date = DateConverter.convertDateFormat(rs.getString("NGAYCHIEU"), "yyyy-MM-dd", "dd-MM-yyyy");
                sc.setNgayChieu(date);
                sc.setThoiGianChieu(rs.getString("THOIGIANCHIEU"));
                suatChieus.add(sc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SuatChieu_ctrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return suatChieus;
    }

    public boolean ThemSC(SuatChieu sc) {
        Connection con = JDBCConnection.getJDBCConnection();
        String sql = "insert into SUATCHIEU(MASC,MARAP,MAPHIM,NGAYCHIEU,THOIGIANCHIEU) values(?,?,?,?,?) ";
        try {
            PreparedStatement prest = con.prepareStatement(sql);
            prest.setString(1, sc.getMaSC());
            prest.setString(2, sc.getMaRap());
            prest.setString(3, sc.getMaPhim());
            String date = DateConverter.convertDateFormat(sc.getNgayChieu(), "dd-MM-yyyy", "yyyy-MM-dd");
            prest.setString(4, date);
            prest.setString(5, sc.getThoiGianChieu());
            int rs = prest.executeUpdate();

            System.out.println("Suat chieu id" + rs);
            // con.close();
            return rs > 0;
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

    //hàm sửa loại phim
    public boolean SuaSC(SuatChieu sc) {
        Connection con = JDBCConnection.getJDBCConnection();
        String sql = "Update SuatChieu Set  MARAP= ? ,MAPHIM    = ?,NGAYCHIEU = ?,THOIGIANCHIEU = ? where MASC = ?";
        try {
            PreparedStatement prest = con.prepareStatement(sql);

            prest.setString(1, sc.getMaRap());
            prest.setString(2, sc.getMaPhim());
            String date = DateConverter.convertDateFormat(sc.getNgayChieu(), "dd-MM-yyyy", "yyyy-MM-dd");
            prest.setString(3, date);
            prest.setString(4, sc.getThoiGianChieu());
            prest.setString(5, sc.getMaSC());

            int rs = prest.executeUpdate();
            System.out.println(rs);
            if (rs > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SuatChieu_ctrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    //hàm xoá loại phim
    public void XoaSC(String MaSC) {
        Connection con = JDBCConnection.getJDBCConnection();
        String sql = "Delete from SuatChieu where MaSC = ?";
        try {
            PreparedStatement prest = con.prepareStatement(sql);
            prest.setString(1, MaSC);
            int rs = prest.executeUpdate();
            System.out.println(rs);
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(SuatChieu_ctrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public SuatChieu getSC(String masc) {
        Connection con = JDBCConnection.getJDBCConnection();
        String sql = "SELECT * FROM SuatChieu WHERE MaSC = ?";
        try {
            PreparedStatement prest = con.prepareStatement(sql);
            prest.setString(1, masc);
            ResultSet rs = prest.executeQuery();
            while (rs.next()) {
                SuatChieu sc = new SuatChieu();

                sc.setMaSC(rs.getString("MASC"));
                sc.setMaRap(rs.getString("MARAP"));
                sc.setMaPhim(rs.getString("MAPHIM"));
                String date = DateConverter.convertDateFormat(sc.getNgayChieu(), "yyyy-MM-dd", "dd-MM-yyyy");
                sc.setNgayChieu(date);
                sc.setThoiGianChieu(rs.getString("THOIGIANCHIEU"));

                return sc;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SuatChieu_ctrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public Vector<String> ListNgayChieu() {
        Connection con = JDBCConnection.getJDBCConnection();
        Vector<String> listNgayChieu = new Vector<String>();
        String sql = "SELECT NGAYCHIEU FROM SUATCHIEU GROUP BY NGAYCHIEU HAVING NGAYCHIEU >= strftime('%Y-%m-%d','now')";
        try {
            PreparedStatement prest = con.prepareStatement(sql);
            ResultSet rs = prest.executeQuery();
            while (rs.next()) {
                String date_after_convert = rs.getString(1);
                listNgayChieu.add(date_after_convert);
                System.out.println(date_after_convert);
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
        return listNgayChieu;
    }

    public Vector<String> ListLoaiPhim(String NgayChieu) {
        Connection con = JDBCConnection.getJDBCConnection();

        Vector<String> ListLoaiPhim = new Vector<String>();
        try {
            // Chuyển đổi ngày vào định dạng SQLite (yyyy-MM-dd)
            String date = convertDateFormat(NgayChieu, "dd-MM-yyyy", "yyyy-MM-dd");
            String query = "SELECT tenlp "
                    + "FROM loaiphim lp "
                    + "INNER JOIN phim p ON lp.malp = p.malp "
                    + "INNER JOIN suatchieu sc ON sc.maphim = p.maphim "
                    + "WHERE sc.ngaychieu = ? "
                    + "GROUP BY tenlp";
            PreparedStatement prest = con.prepareStatement(query);
            prest.setString(1, date);
            ResultSet rs = prest.executeQuery();

            while (rs.next()) {
                ListLoaiPhim.add(rs.getString(1));
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

        return ListLoaiPhim;
    }

    public Vector<String> ListPhim(String NgayChieu, String LoaiPhim) {
        Vector<String> ListPhim = new Vector<String>();
        Connection con = JDBCConnection.getJDBCConnection();

        try {
            // Chuyển đổi ngày vào định dạng SQLite (yyyy-MM-dd)
            String date = convertDateFormat(NgayChieu, "dd-MM-yyyy", "yyyy-MM-dd");
            String query = "SELECT tenphim "
                    + "FROM loaiphim lp "
                    + "INNER JOIN phim p ON lp.malp = p.malp "
                    + "INNER JOIN suatchieu sc ON sc.maphim = p.maphim "
                    + "WHERE lp.tenlp = ? "
                    + "AND sc.ngaychieu = ? "
                    + "GROUP BY tenphim";
            PreparedStatement prest = con.prepareStatement(query);
            prest.setString(1, LoaiPhim);
            prest.setString(2, date);
            ResultSet rs = prest.executeQuery();
            while (rs.next()) {
                ListPhim.add(rs.getString(1));
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
        return ListPhim;
    }

    public Vector<String> ListThoiGianChieu(String NgayChieu, String LoaiPhim, String TenPhim) {
        Vector<String> ListThoiGianChieu = new Vector<String>();
        Connection con = JDBCConnection.getJDBCConnection();
        try {
            // Chuyển đổi ngày vào định dạng SQLite (yyyy-MM-dd)
            String date = convertDateFormat(NgayChieu, "dd-MM-yyyy", "yyyy-MM-dd");
            String query = "SELECT thoigianchieu "
                    + "FROM loaiphim lp "
                    + "INNER JOIN phim p ON lp.malp = p.malp "
                    + "INNER JOIN suatchieu sc ON sc.maphim = p.maphim "
                    + "WHERE lp.tenlp = ? "
                    + "AND p.tenphim = ? "
                    + "AND sc.ngaychieu = ? "
                    + "GROUP BY thoigianchieu";
            PreparedStatement prest = con.prepareStatement(query);
            prest.setString(1, LoaiPhim);
            prest.setString(2, TenPhim);
            prest.setString(3, date);
            ResultSet rs = prest.executeQuery();
            while (rs.next()) {
                ListThoiGianChieu.add(rs.getString(1));
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
        return ListThoiGianChieu;
    }

    public String SuatChieuDaChon(String NgayChieu, String ThoiGianChieu, String TenPhim) {
        String MaSuatChieu = "";
        Connection con = JDBCConnection.getJDBCConnection();
        try {
            String date = convertDateFormat(NgayChieu, "dd-MM-yyyy", "yyyy-MM-dd");
            String query = "SELECT masc "
                    + "FROM suatchieu sc JOIN phim p ON sc.maphim = p.maphim "
                    + "WHERE thoigianchieu = ?"
                    + "AND ngaychieu = ?"
                    + "AND tenphim = ?";
            PreparedStatement prest = con.prepareStatement(query);
            prest.setString(1, ThoiGianChieu);
            prest.setString(2, date);
            prest.setString(3, TenPhim);
            ResultSet rs = prest.executeQuery();

            if (rs.next()) {
                MaSuatChieu = rs.getString(1);
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
        return MaSuatChieu;
    }

    public static void HienThiSuatChieu(String ngay, String maphim, SuatChieu sc, JComboBox cb) {
        Connection con = JDBCConnection.getJDBCConnection();
        try {
            String date = convertDateFormat(ngay, "dd-MM-yyyy", "yyyy-MM-dd");
            String query = "WHERE ngaychieu = ?"
                    + "SELECT DISTINCT thoigianchieu"
                    + "FROM suatchieu"
                    + "AND maphim = ?";
            PreparedStatement prest = con.prepareStatement(query);
            prest.setString(1, date);
            prest.setString(2, maphim);
            ResultSet rs = prest.executeQuery();
            while (rs.next()) {
                sc.setThoiGianChieu(rs.getString(1));
                cb.addItem(sc.getThoiGianChieu());
            }
        } catch (SQLException ex) {
            Logger.getLogger(SuatChieu_ctrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void HienThiSlot(String ngay, String thoigian, String maphim, JLabel lb) {
        Connection con = JDBCConnection.getJDBCConnection();
        try {
            String date = convertDateFormat(ngay, "dd-MM-yyyy", "yyyy-MM-dd");
            String query = "SELECT COUNT(masc)"
                    + "FROM datve WHERE masc = ("
                    + "SELECT masc FROM suatchieu WHERE ngaychieu = ? "
                    + "AND thoigianchieu = ? "
                    + "AND maphim = ?)"
                    + "GROUP BY masc";
            PreparedStatement prest = con.prepareStatement(query);
            prest.setString(1, date);
            prest.setString(2, thoigian);
            prest.setString(3, maphim);
            ResultSet rs = prest.executeQuery();
            while (rs.next()) {
                int slot = 30 - rs.getInt(1);
                lb.setText(String.valueOf(slot));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SuatChieu_ctrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static ArrayList<SuatChieu> getAllsc() {
        ArrayList<SuatChieu> emList = new ArrayList<>();
        Connection con = JDBCConnection.getJDBCConnection();
        try {
            String query = "SELECT * FROM SUATCHIEU";
            PreparedStatement prest = con.prepareStatement(query);
            ResultSet rs = prest.executeQuery();

            while (rs.next()) {

                String masc = rs.getString(1);
                String marap = rs.getString(2);
                String maphim = rs.getString(3);
                String ngaychieu = convertDateFormat(rs.getString(4), "yyyy-MM-dd", "dd-MM-yyyy");
                String thoigian = rs.getString(5);
                emList.add(new SuatChieu(masc, marap, maphim, ngaychieu, thoigian));
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
        return emList;
    }

    public static void CapNhatsc(SuatChieu tv) {
        Connection con = JDBCConnection.getJDBCConnection();
        try {
            String query = "UPDATE suatchieu SET marap= ?,maphim =?, thoigianchieu=?  WHERE masc = ?";
            con.setAutoCommit(false);
            con.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            PreparedStatement prest = con.prepareStatement(query);
            prest.setString(1, tv.getMaRap());
            prest.setString(2, tv.getMaPhim());
            prest.setString(3, tv.getThoiGianChieu());
            prest.setString(4, tv.getMaSC());
            int tmp = prest.executeUpdate();
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
