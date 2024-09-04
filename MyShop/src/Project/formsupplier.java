/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS Notebook
 */
public class formsupplier extends javax.swing.JFrame {
    public long bayar;
    public long kembali;
    public long harga;
    public Statement st;
    Connection cn = koneksi.getKoneksi();
    private DefaultTableModel model;

    /**
     * Creates new form formsupplier
     */
   public formsupplier() {
        initComponents();
        model = new DefaultTableModel();

        supplier.setModel(model);

        model.addColumn("Kode");
        model.addColumn("Nama Barang");
        model.addColumn("Jumlah");
        model.addColumn("Harga");
        
        delete();
        loadData();
        
    }
   
   public void delete(){
        try {
            
            String sqla = "DELETE FROM tbl_supplier WHERE jumlah_barang = 0";
            
            Connection c = koneksi.getKoneksi();
            PreparedStatement p = c.prepareStatement(sqla);
            p.executeUpdate();
            
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
   
   public void add(){
               if(tkdbarang.getText().equals("")|| tnamabarang.getText().equals("")|| thargabarang.getText().equals("")|| tjumlah.getText().equals("")||thjual.getText().equals("")){
            JOptionPane.showMessageDialog(null, "LENGKAPI DATA !", "Artshop", JOptionPane.INFORMATION_MESSAGE);
        
        }else{
            String kdbarangg = tkdbarang.getText();
            String pilihbarangg = tnamabarang.getText();
            String hsatuann = thargabarang.getText();
            String tjumlahh = tjumlah.getText();
            String hjual = thjual.getText();

           
            try {
                long millis=System.currentTimeMillis();  
                java.sql.Date date=new java.sql.Date(millis);  
                System.out.println(date); 
                String tgl = date.toString();
                Connection c = koneksi.getKoneksi();
                
                String sql = "INSERT INTO tbl_barang VALUES (?, ?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE jumlah_barang = jumlah_barang + '"+ tjumlah.getText() + "'";
                
               
                PreparedStatement p = c.prepareStatement(sql);
                p.setString(1, kdbarangg);
                p.setString(2, pilihbarangg);
                p.setString(3, tjumlahh);
                p.setString(4, hsatuann);
                p.setString(5, hjual);
                p.setString(6, tgl);
                
                p.executeUpdate();
                p.close();
            } catch (SQLException e) {
                System.out.println("Terjadi Error");
            } finally {
                try{
                    String sqla ="UPDATE tbl_supplier SET jumlah_barang = jumlah_barang - '"+ tjumlah.getText() + "' where kd_barang ='" +tkdbarang.getText()+"'";
                    java.sql.Connection conn=(Connection)koneksi.getKoneksi();
                    java.sql.PreparedStatement pst=conn.prepareStatement(sqla);
                    pst.execute();
                    tkdbarang.setText("");
                    tnamabarang.setText("");
                    thargabarang.setText("");
                    tjumlah.setText("");
                    thjual.setText("");
                    JOptionPane.showMessageDialog(null, "Data berhasil disimpan", "Artshop", JOptionPane.INFORMATION_MESSAGE);
                    loadData();                  
                }catch (Exception a) {
            JOptionPane.showMessageDialog(this, a.getMessage());}
        }
        }
   }

    public void loadData() {
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();

        try {
            Connection c = koneksi.getKoneksi();
            Statement s = c.createStatement();

            String sql = "SELECT * FROM tbl_supplier";
            ResultSet r = s.executeQuery(sql);

            while (r.next()) {
                Object[] o = new Object[7];
                o[0] = r.getString("kd_barang");
                o[1] = r.getString("nama_barang");
                o[2] = r.getString("jumlah_barang");
                o[3] = r.getString("harga_beli");
                
                model.addRow(o);
            }
            r.close();
            s.close();
        } catch (SQLException e) {
            System.out.println("Terjadi Error");
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

        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        supplier = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        thargabarang = new javax.swing.JTextField();
        tnamabarang = new javax.swing.JTextField();
        tkdbarang = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        tjumlah = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        thjual = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(90, 154, 168));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Data Gudang");

        jButton6.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/back button long.png"))); // NOI18N
        jButton6.setBorder(null);
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.setIconTextGap(0);
        jButton6.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/back button long clicked.png"))); // NOI18N
        jButton6.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/back button long hover.png"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 374, Short.MAX_VALUE)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        supplier.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        supplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                supplierMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(supplier);

        jPanel3.setBackground(new java.awt.Color(76, 134, 147));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Kode Barang");

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nama Barang");

        jLabel6.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Harga Barang");

        thargabarang.setEditable(false);
        thargabarang.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        thargabarang.setForeground(new java.awt.Color(0, 153, 153));

        tnamabarang.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        tnamabarang.setForeground(new java.awt.Color(0, 153, 153));

        tkdbarang.setEditable(false);
        tkdbarang.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        tkdbarang.setForeground(new java.awt.Color(0, 153, 153));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/tambah toko button.png"))); // NOI18N
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/tambah toko button clicked.png"))); // NOI18N
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/tambah toko button hover.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tjumlah.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        tjumlah.setForeground(new java.awt.Color(0, 153, 153));

        jLabel9.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Jumlah");

        thjual.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        thjual.setForeground(new java.awt.Color(0, 153, 153));
        thjual.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                thjualKeyPressed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Harga Jual");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addComponent(jLabel10))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tjumlah, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(thjual, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(thargabarang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tnamabarang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tkdbarang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tkdbarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tnamabarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(thargabarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(tjumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(thjual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void supplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_supplierMouseClicked
        // TODO add your handling code here:    
        int i = supplier.getSelectedRow();
        if (i == -1) {
            return;
        }
        String kdbarang = (String) model.getValueAt(i, 0);
        tkdbarang.setText(kdbarang);
        
        String namabarang = (String) model.getValueAt(i, 1);
        tnamabarang.setText(namabarang);
        
        String jumlahbarang = (String) model.getValueAt(i, 2);
        tjumlah.setText(jumlahbarang);

        String hargabarang = (String) model.getValueAt(i, 3);
        thargabarang.setText(hargabarang);

        
    }//GEN-LAST:event_supplierMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        add();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void thjualKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_thjualKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
        add();
        }
    }//GEN-LAST:event_thjualKeyPressed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        formmenu1 au = new formmenu1();
        au.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton6ActionPerformed

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
            java.util.logging.Logger.getLogger(formsupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formsupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formsupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formsupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formsupplier().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable supplier;
    private javax.swing.JTextField thargabarang;
    private javax.swing.JTextField thjual;
    private javax.swing.JTextField tjumlah;
    private javax.swing.JTextField tkdbarang;
    private javax.swing.JTextField tnamabarang;
    // End of variables declaration//GEN-END:variables
}
