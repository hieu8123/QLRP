/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;



//import Controller.Oracle;

import controller.ThanhVien_ctrl;
import java.awt.Color;
import java.sql.Date;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import Model.ThanhVien;

/**
 *
 * @author Phon
 */
public class QLThanhVien extends javax.swing.JFrame {
    ThanhVien_ctrl qltv_ctrl = new ThanhVien_ctrl();
    DefaultTableModel defaultTableModel;
//    private static void setModel(DefaultTableModel model) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
      
    
    /**
     * Creates new form QLThanhVien
     */
    public QLThanhVien() {
        initComponents();
        
        this.setLocationRelativeTo(null);//hiển thị giữa màn hình
 
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);//thoát chương trình khi bấm exit
        this.setVisible(true);//chạy chương trình
       //set màu cho table
        JTableHeader table = table_thanhvien.getTableHeader();
        table.setBackground(new Color(0,153,153));
        table.setForeground(Color.black);
        showThanhVien(qltv_ctrl.getAllTV());
       
    }
   
    public void showThanhVien(List<ThanhVien> tvs){
        //DefaultTableModel defaultTableModel;
        DefaultTableModel model = (DefaultTableModel) table_thanhvien.getModel();
       for(ThanhVien tv : tvs){
            model.addRow(new Object[]{tv.getMaTV(), tv.getTenTV(), tv.getGioiTinh()
            ,tv.getNgaySinh(),tv.getDiaChi(),tv.getSDT(),tv.getCMND(),
            tv.getNgayDK(),tv.getDiemTichLuy()});
        }
        
    }
    
 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_tracuu = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_thanhvien = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        panel_exit = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        panel_dong = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_diem1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_matv1 = new javax.swing.JTextField();
        txt_tentv2 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txt_ngaysinh1 = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_diachi1 = new javax.swing.JTextArea();
        txt_gioitinh1 = new javax.swing.JTextField();
        txt_ngaydangky1 = new com.toedter.calendar.JDateChooser();
        txt_sdt1 = new javax.swing.JTextField();
        txt_cmnd1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        button_tracuu1 = new javax.swing.JButton();
        button_xoa = new javax.swing.JButton();
        butt_capnhat = new javax.swing.JButton();
        Button_TaiLai = new javax.swing.JButton();
        button_them = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUẢN LÝ THÔNG TIN THÀNH VIÊN");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(280, 10, 660, 40);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 30, 1120, 60);

        txt_tracuu.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txt_tracuu.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_tracuu.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_tracuuFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_tracuuFocusLost(evt);
            }
        });
        txt_tracuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tracuuActionPerformed(evt);
            }
        });
        txt_tracuu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_tracuuKeyReleased(evt);
            }
        });
        jPanel1.add(txt_tracuu);
        txt_tracuu.setBounds(440, 100, 430, 30);

        table_thanhvien.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        table_thanhvien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MaTV", "Tên", "Giới tính", "Ngày sinh", "Địa chỉ", "SDT", "CMND", "Ngày ĐK", "Điểm "
            }
        ));
        table_thanhvien.setOpaque(false);
        table_thanhvien.setSelectionBackground(new java.awt.Color(0, 204, 204));
        table_thanhvien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_thanhvienMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                table_thanhvienMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(table_thanhvien);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(440, 150, 670, 520);

        jLabel2.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nhập các thông tin tra cứu");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(120, 100, 300, 25);

        panel_exit.setBackground(new java.awt.Color(51, 51, 51));
        panel_exit.setForeground(new java.awt.Color(51, 51, 51));
        panel_exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel_exitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel_exitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panel_exitMouseExited(evt);
            }
        });
        panel_exit.setLayout(null);

        jLabel7.setFont(new java.awt.Font("Dubai Medium", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("X");
        panel_exit.add(jLabel7);
        jLabel7.setBounds(0, 10, 30, 20);

        jPanel1.add(panel_exit);
        panel_exit.setBounds(1090, 0, 30, 30);

        panel_dong.setBackground(new java.awt.Color(51, 51, 51));
        panel_dong.setForeground(new java.awt.Color(51, 51, 51));
        panel_dong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel_dongMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel_dongMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panel_dongMouseExited(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("_");
        jLabel13.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout panel_dongLayout = new javax.swing.GroupLayout(panel_dong);
        panel_dong.setLayout(panel_dongLayout);
        panel_dongLayout.setHorizontalGroup(
            panel_dongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_dongLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(42, 42, 42))
        );
        panel_dongLayout.setVerticalGroup(
            panel_dongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_dongLayout.createSequentialGroup()
                .addComponent(jLabel13)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        jPanel1.add(panel_dong);
        panel_dong.setBounds(1060, 0, 30, 30);

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));

        jLabel3.setBackground(new java.awt.Color(234, 234, 227));
        jLabel3.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Thông tin thành viên");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(0, 150, 440, 20);

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Mã thành viên: ");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(10, 180, 110, 30);
        jPanel1.add(txt_diem1);
        txt_diem1.setBounds(130, 600, 290, 30);

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Tên thành viên: ");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(10, 230, 120, 20);

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Giới tính: ");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(10, 280, 70, 16);
        jPanel1.add(txt_matv1);
        txt_matv1.setBounds(130, 180, 290, 30);
        jPanel1.add(txt_tentv2);
        txt_tentv2.setBounds(130, 230, 290, 30);

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Ngày sinh: ");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(10, 330, 80, 19);

        txt_ngaysinh1.setDateFormatString("dd-MM-yyyy");
        txt_ngaysinh1.setMaxSelectableDate(new java.util.Date(253370743279000L));
        txt_ngaysinh1.setMinSelectableDate(new java.util.Date(-62135791121000L));
        jPanel1.add(txt_ngaysinh1);
        txt_ngaysinh1.setBounds(130, 330, 290, 30);

        txt_diachi1.setColumns(20);
        txt_diachi1.setRows(5);
        jScrollPane1.setViewportView(txt_diachi1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(130, 380, 290, 50);
        jPanel1.add(txt_gioitinh1);
        txt_gioitinh1.setBounds(130, 280, 290, 30);

        txt_ngaydangky1.setDateFormatString("dd-MM-yyyy");
        jPanel1.add(txt_ngaydangky1);
        txt_ngaydangky1.setBounds(130, 550, 290, 30);
        jPanel1.add(txt_sdt1);
        txt_sdt1.setBounds(130, 450, 290, 30);
        jPanel1.add(txt_cmnd1);
        txt_cmnd1.setBounds(130, 500, 290, 30);

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Địa chỉ:");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(10, 390, 60, 20);

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("SDT:");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(10, 450, 40, 20);

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("CMND: ");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(10, 500, 60, 19);

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Ngày đăng ký: ");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(10, 550, 110, 20);

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Điểm tích luỹ: ");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(10, 600, 110, 30);

        button_tracuu1.setBackground(new java.awt.Color(153, 153, 153));
        button_tracuu1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        button_tracuu1.setForeground(new java.awt.Color(255, 255, 255));
        button_tracuu1.setText("Huỷ");
        button_tracuu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_tracuu1MouseClicked(evt);
            }
        });
        button_tracuu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_tracuu1ActionPerformed(evt);
            }
        });
        jPanel1.add(button_tracuu1);
        button_tracuu1.setBounds(350, 640, 80, 30);

        button_xoa.setBackground(new java.awt.Color(153, 153, 153));
        button_xoa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        button_xoa.setForeground(new java.awt.Color(255, 255, 255));
        button_xoa.setText("Xoá");
        button_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_xoaActionPerformed(evt);
            }
        });
        jPanel1.add(button_xoa);
        button_xoa.setBounds(130, 640, 80, 30);

        butt_capnhat.setBackground(new java.awt.Color(153, 153, 153));
        butt_capnhat.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        butt_capnhat.setForeground(new java.awt.Color(255, 255, 255));
        butt_capnhat.setText("Cập nhật");
        butt_capnhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butt_capnhatActionPerformed(evt);
            }
        });
        jPanel1.add(butt_capnhat);
        butt_capnhat.setBounds(230, 640, 100, 30);

        Button_TaiLai.setBackground(new java.awt.Color(153, 153, 153));
        Button_TaiLai.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Button_TaiLai.setForeground(new java.awt.Color(255, 255, 255));
        Button_TaiLai.setText("Tải lại");
        Button_TaiLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_TaiLaiActionPerformed(evt);
            }
        });
        jPanel1.add(Button_TaiLai);
        Button_TaiLai.setBounds(920, 103, 100, 30);

        button_them.setBackground(new java.awt.Color(153, 153, 153));
        button_them.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        button_them.setForeground(new java.awt.Color(255, 255, 255));
        button_them.setText("Thêm");
        button_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_themActionPerformed(evt);
            }
        });
        jPanel1.add(button_them);
        button_them.setBounds(30, 640, 80, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1122, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 684, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_tracuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tracuuActionPerformed
       
    }//GEN-LAST:event_txt_tracuuActionPerformed

    private void txt_tracuuFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_tracuuFocusGained
          
    }//GEN-LAST:event_txt_tracuuFocusGained

    private void txt_tracuuFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_tracuuFocusLost
         
    }//GEN-LAST:event_txt_tracuuFocusLost

    private void panel_exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_exitMouseClicked
        this.dispose(); //tắt tab
        
    }//GEN-LAST:event_panel_exitMouseClicked

    private void panel_exitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_exitMouseEntered
        panel_exit.setBackground(new Color(162, 222, 208));
    }//GEN-LAST:event_panel_exitMouseEntered

    private void panel_exitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_exitMouseExited
        panel_exit.setBackground(new Color(244,249,248));
    }//GEN-LAST:event_panel_exitMouseExited

    private void panel_dongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_dongMouseClicked
        this.setState(QLThanhVien.ICONIFIED);//đóng
    }//GEN-LAST:event_panel_dongMouseClicked

    private void panel_dongMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_dongMouseEntered
        panel_dong.setBackground(new Color(162, 222, 208));
    }//GEN-LAST:event_panel_dongMouseEntered

    private void panel_dongMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_dongMouseExited
        panel_dong.setBackground(new Color(244,249,248));
    }//GEN-LAST:event_panel_dongMouseExited

    private void txt_tracuuKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_tracuuKeyReleased
        DefaultTableModel table = (DefaultTableModel)table_thanhvien.getModel();
        String search = txt_tracuu.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table);
        table_thanhvien.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));
       
    }//GEN-LAST:event_txt_tracuuKeyReleased

    private void table_thanhvienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_thanhvienMouseClicked
       
       
        int i = table_thanhvien.getSelectedRow();
        TableModel model = table_thanhvien.getModel();
        txt_matv1.setText(model.getValueAt(i, 0).toString());
        txt_tentv2.setText(model.getValueAt(i, 1).toString());
        txt_gioitinh1.setText(model.getValueAt(i, 2).toString());
        txt_diachi1.setText(model.getValueAt(i, 4).toString());
        txt_sdt1.setText(model.getValueAt(i, 5).toString());
        txt_cmnd1.setText(model.getValueAt(i, 6).toString());
//     
         txt_diem1.setText(model.getValueAt(i,8).toString());
         txt_ngaysinh1.setDate((Date)(model.getValueAt(i, 3)));
         txt_ngaydangky1.setDate((Date)(model.getValueAt(i, 7)));
    }//GEN-LAST:event_table_thanhvienMouseClicked

    private void button_tracuu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_tracuu1ActionPerformed
         txt_tentv2.setText("");
        txt_gioitinh1.setText("");
        txt_ngaysinh1.setDate(null);
        txt_ngaydangky1.setDate(null);
        txt_diachi1.setText("");
        txt_sdt1.setText("");
        txt_cmnd1.setText("");
        txt_diem1.setText("0"); 
         txt_matv1.setText("");
    }//GEN-LAST:event_button_tracuu1ActionPerformed

    private void button_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_xoaActionPerformed
         int xacnhanxoa = JOptionPane.showConfirmDialog(this, "Bạn có muốn xoá thành viên này không?", "Xác nhận cậpt nhật",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(xacnhanxoa == JOptionPane.YES_OPTION)
        {
            System.out.println("UI.QLThanhVien.button_xoaActionPerformed()");
            try {
//             Connection con =  JDBCConnection.getJDBCConnection();
//            PreparedStatement pre = con.prepareStatement(sql);
//            pre.setString(1, txt_matv1.getText());
//           int ps= pre.executeUpdate();
//              System.out.println("UI.QLThanhVien.button_xoaActionPerformed("+ps );
            qltv_ctrl.XoaTV(txt_matv1.getText());
            JOptionPane.showMessageDialog(null, "Xoá Thành công !");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Xoá không thành công !");
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_button_xoaActionPerformed

    private void butt_capnhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butt_capnhatActionPerformed
        
        int xacnhan = JOptionPane.showConfirmDialog(this, "Bạn có muốn cập nhật thành viên này không?", "Xác nhận cậpt nhật",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(xacnhan == JOptionPane.YES_OPTION)
        {
           
        try {
            ThanhVien tv = new ThanhVien();
           
           
            tv.setMaTV(txt_matv1.getText());
            tv.setTenTV(txt_tentv2.getText());
            tv.setGioiTinh(txt_gioitinh1.getText());
            tv.setDiaChi(txt_diachi1.getText());
            tv.setCMND(txt_cmnd1.getText());
            tv.setSDT(txt_sdt1.getText());
            tv.setDiemTichLuy(Long.parseLong(txt_diem1.getText()));
            //tv.setNgaySinh((Date)txt_ngaysinh1.getDate());
               if(txt_ngaysinh1.getDate() != null ){
        java.util.Date utilStartDate = txt_ngaysinh1.getDate();
        java.sql.Date sqlStartDate = new java.sql.Date(utilStartDate.getTime());
        tv.setNgaySinh(sqlStartDate);
    }
          //  tv.setNgayDK((Date)txt_ngaydangky1.getDate());
            if(txt_ngaydangky1.getDate() != null ){
        java.util.Date utilStartDate = txt_ngaydangky1.getDate();
        java.sql.Date sqlStartDate = new java.sql.Date(utilStartDate.getTime());
        tv.setNgayDK(sqlStartDate);
    }

            if (qltv_ctrl.CapNhatTV(tv)) {
                JOptionPane.showMessageDialog(null, "Cập nhật Thành viên thành công");
            } else {
                JOptionPane.showMessageDialog(null, "Cập nhật không thành công");
            }

        } catch (Exception ex) {
            ex.printStackTrace();

        }
           
        }
        
     
         
    }//GEN-LAST:event_butt_capnhatActionPerformed

    private void button_tracuu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_tracuu1MouseClicked
      
        
                
    }//GEN-LAST:event_button_tracuu1MouseClicked

    private void table_thanhvienMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_thanhvienMouseReleased
         
    }//GEN-LAST:event_table_thanhvienMouseReleased

    private void Button_TaiLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_TaiLaiActionPerformed
         DefaultTableModel model = (DefaultTableModel) table_thanhvien.getModel();
         model.setRowCount(0);
        //table_thanhvien.setModel(new DefaultTableModel(null,new String[]{"MaTV","Tên","Giới Tính", "Ngày sinh", "Địa chỉ","SDT","CMND","Ngày DK","Điểm"}));
       //DefaultTableModel.addRow(new Object[]{lPhim.getMaLP(),lPhim.getTenLP(),lPhim.getHinhThuc()});
         showThanhVien(qltv_ctrl.getAllTV());
       
    }//GEN-LAST:event_Button_TaiLaiActionPerformed

    private void button_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_themActionPerformed
  try {
            ThanhVien tv = new ThanhVien();
           
           
            tv.setMaTV(txt_matv1.getText());
            tv.setTenTV(txt_tentv2.getText());
            tv.setGioiTinh(txt_gioitinh1.getText());
            tv.setDiaChi(txt_diachi1.getText());
            tv.setCMND(txt_cmnd1.getText());
            tv.setSDT(txt_sdt1.getText());
            tv.setDiemTichLuy(Long.parseLong(txt_diem1.getText()));
               if(txt_ngaydangky1.getDate() != null ){
        java.util.Date utilStartDate = txt_ngaydangky1.getDate();
        java.sql.Date sqlStartDate = new java.sql.Date(utilStartDate.getTime());
        tv.setNgayDK(sqlStartDate);
    }
          //  tv.setNgayDK((Date)txt_ngaydangky1.getDate());
        //    tv.setNgaySinh((Date)txt_ngaysinh1.getDate());
                if(txt_ngaysinh1.getDate() != null ){
        java.util.Date utilStartDate = txt_ngaysinh1.getDate();
        java.sql.Date sqlStartDate = new java.sql.Date(utilStartDate.getTime());
        tv.setNgaySinh(sqlStartDate);
    }
//            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
//            try {
////               
//                String ngsinh = sdf.format(txt_ngaysinh1.getDate());
//                tv.setNgaySinh(ngsinh);
//                String ngdk = sdf.format(txt_ngaydangky1.getDate());
//                tv.setNgayDangKy(ngdk);
//            } catch (Exception e) {
//                JOptionPane.showMessageDialog(null, "Lỗi ngày tháng năm");
//                e.printStackTrace();
//            }

            if (new ThanhVien_ctrl().ThemThanhVien(tv)) {
                JOptionPane.showMessageDialog(null, "Thêm Thành viên thành công");
            } else {
                JOptionPane.showMessageDialog(null, "Thêm không thành công");
            }

        } catch (Exception ex) {
            ex.printStackTrace();

        }
       
    }//GEN-LAST:event_button_themActionPerformed

//   public boolean UpdateTV(ThanhVien t){
//
//        String query = "UPDATE THANHVIEN SET TENTV =?,GIOITINH = ?, NGAYSINH= to_date(?,'dd-mm-yyyy'),DIACHI= ? "
//                 +     ",SDT= ? ,CMND= ? ,NGAYDANGKY= to_date(?,'dd-mm-yyyy'), DIEMTICHLUY= ? WHERE MATV = ?";
//        //String q = "insert into thanhvien(hoten,masv,ngsinh) values(?,?,to_date(....))
//        try {
//            PreparedStatement pt = Oracle.getConnection().prepareStatement(query);
//            pt.setString(1,t.getTenTV());
//            
//            pt.setString(2,t.getGioiTinh());
//            pt.setString(3,t.getNgaySinh());
//            pt.setString(4,  t.getDiaChi());
//            pt.setString(5,t.getSDT());
//            pt.setString(6,t.getCMND());
//            pt.setString(7,t.getNgayDangKy());
//            pt.setInt(8,  t.getDiemTichLuy());
//            pt.setString(9, t.getMaTV());
//            
//            return pt.executeUpdate() >0;
//           
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return false;
//
//    } 
    public static void main(String args[]) {
       
        QLThanhVien traCuuTV = new QLThanhVien();
          
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_TaiLai;
    private javax.swing.JButton butt_capnhat;
    private javax.swing.JButton button_them;
    private javax.swing.JButton button_tracuu1;
    private javax.swing.JButton button_xoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panel_dong;
    private javax.swing.JPanel panel_exit;
    private javax.swing.JTable table_thanhvien;
    private javax.swing.JTextField txt_cmnd1;
    private javax.swing.JTextArea txt_diachi1;
    private javax.swing.JTextField txt_diem1;
    private javax.swing.JTextField txt_gioitinh1;
    private javax.swing.JTextField txt_matv1;
    private com.toedter.calendar.JDateChooser txt_ngaydangky1;
    private com.toedter.calendar.JDateChooser txt_ngaysinh1;
    private javax.swing.JTextField txt_sdt1;
    private javax.swing.JTextField txt_tentv2;
    private javax.swing.JTextField txt_tracuu;
    // End of variables declaration//GEN-END:variables
}

