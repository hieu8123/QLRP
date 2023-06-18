/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Util.JDBCConnection;
import java.sql.Connection;
import java.util.HashMap;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
 

/**
 *
 * @author PC
 */
public class BaoCao extends javax.swing.JFrame {

    /**
     * Creates new form BaoCaoDoanhThu
     */
    public BaoCao() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_baocao = new javax.swing.JPanel();
        box_thongkenam = new javax.swing.JComboBox<>();
        box_thongkethang = new javax.swing.JComboBox<>();
        jPanel10 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        doanhthungay = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        topphim = new javax.swing.JPanel();
        jLabel55 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panel_baocao.setBackground(new java.awt.Color(153, 153, 153));

        box_thongkenam.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        box_thongkenam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040", "2041", "2042", "2043", "2044", "2045", "2046", "2047", "2048", "2049", "2050", "2051", "2052", "2053", "2054", "2055", "2056", "2057", "2058", "2059", "2060", "2061", "2062", "2063", "2064", "2065", "2066", "2067", "2068", "2069", "2070", "2071", "2072", "2073", "2074", "2075", "2076", "2077", "2078", "2079", "2080", "2081", "2082", "2083", "2084", "2085", "2086", "2087", "2088", "2089", "2090", "2091", "2092", "2093", "2094", "2095", "2096", "2097", "2098", "2099", "2100" }));
        box_thongkenam.setSelectedIndex(12);

        box_thongkethang.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        box_thongkethang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));

        jPanel10.setBackground(new java.awt.Color(51, 51, 51));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(204, 204, 204));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("THỐNG KÊ");
        jLabel19.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jLabel19)
                .addGap(19, 19, 19))
        );

        doanhthungay.setBackground(new java.awt.Color(51, 51, 51));
        doanhthungay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                doanhthungayMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                doanhthungayMouseEntered(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(204, 204, 204));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Thống kê doanh thu ");
        jLabel20.setPreferredSize(new java.awt.Dimension(320, 60));

        javax.swing.GroupLayout doanhthungayLayout = new javax.swing.GroupLayout(doanhthungay);
        doanhthungay.setLayout(doanhthungayLayout);
        doanhthungayLayout.setHorizontalGroup(
            doanhthungayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, doanhthungayLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        doanhthungayLayout.setVerticalGroup(
            doanhthungayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
        );

        topphim.setBackground(new java.awt.Color(51, 51, 51));
        topphim.setPreferredSize(new java.awt.Dimension(320, 60));
        topphim.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                topphimMouseClicked(evt);
            }
        });

        jLabel55.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(204, 204, 204));
        jLabel55.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel55.setText(" Top phim được xem nhiều nhất");

        javax.swing.GroupLayout topphimLayout = new javax.swing.GroupLayout(topphim);
        topphim.setLayout(topphimLayout);
        topphimLayout.setHorizontalGroup(
            topphimLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topphimLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        topphimLayout.setVerticalGroup(
            topphimLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel55, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel62.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(255, 255, 255));
        jLabel62.setText("Tháng:");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Năm:");

        javax.swing.GroupLayout panel_baocaoLayout = new javax.swing.GroupLayout(panel_baocao);
        panel_baocao.setLayout(panel_baocaoLayout);
        panel_baocaoLayout.setHorizontalGroup(
            panel_baocaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panel_baocaoLayout.createSequentialGroup()
                .addGroup(panel_baocaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panel_baocaoLayout.createSequentialGroup()
                        .addComponent(jLabel62)
                        .addGap(28, 28, 28)
                        .addComponent(box_thongkethang, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(topphim, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addGroup(panel_baocaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_baocaoLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(box_thongkenam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(doanhthungay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        panel_baocaoLayout.setVerticalGroup(
            panel_baocaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_baocaoLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87)
                .addGroup(panel_baocaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel62)
                    .addComponent(box_thongkethang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(box_thongkenam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(90, 90, 90)
                .addGroup(panel_baocaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(topphim, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                    .addComponent(doanhthungay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_baocao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_baocao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void doanhthungayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_doanhthungayMouseClicked
        String thang = box_thongkethang.getSelectedItem().toString();
        String nam = box_thongkenam.getSelectedItem().toString();
        HashMap<String, Object> hashmap = new HashMap<>();
        hashmap.put("Thang", thang);
        hashmap.put("Nam", nam);
        try {
            Connection con = JDBCConnection.getJDBCConnection();
            String dir = "src\\report\\ThongKeDoanhThu.jrxml";
            JasperReport jr = JasperCompileManager.compileReport(dir);
            JasperPrint jp = JasperFillManager.fillReport(jr, hashmap, con);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_doanhthungayMouseClicked

    private void doanhthungayMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_doanhthungayMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_doanhthungayMouseEntered

    private void topphimMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_topphimMouseClicked
        String thang = box_thongkethang.getSelectedItem().toString();
        String nam = box_thongkenam.getSelectedItem().toString();
        HashMap<String, Object> hashmap = new HashMap<>();
        hashmap.put("Thang", thang);
        hashmap.put("Nam", nam);
        try {
            Connection con = JDBCConnection.getJDBCConnection();
            String dir = "src\\report\\TopPhimTheoThang.jrxml";
            JasperReport jr = JasperCompileManager.compileReport(dir);
            JasperPrint jp = JasperFillManager.fillReport(jr, hashmap, con);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_topphimMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BaoCao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BaoCao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BaoCao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BaoCao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BaoCao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> box_thongkenam;
    private javax.swing.JComboBox<String> box_thongkethang;
    private javax.swing.JPanel doanhthungay;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel panel_baocao;
    private javax.swing.JPanel topphim;
    // End of variables declaration//GEN-END:variables
}
