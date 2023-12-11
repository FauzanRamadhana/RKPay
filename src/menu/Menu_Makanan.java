package menu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.html.parser.DTDConstants;
import koneksi.Koneksi;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
/**
 *
 * @author wandy
 */
public class Menu_Makanan extends javax.swing.JPanel {
    
    private DefaultTableModel table;
    /**
     * Creates new form Menu_Makanan
     */
    public Menu_Makanan() {
        initComponents();
        table = new DefaultTableModel();
        dataMakanan.setModel(table);
        
        table.addColumn("Nama");
        table.addColumn("Kategori");
        table.addColumn("Stok");
        table.addColumn("Harga");
        loadData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainPanel = new javax.swing.JPanel();
        DataMenuMakanan = new javax.swing.JPanel();
        btnTambah = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        dataMakanan = new javax.swing.JTable();
        TambahMenu = new javax.swing.JPanel();
        btnSimpan = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tvStok = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tvNama = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tvHarga = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tvKategori = new javax.swing.JTextField();

        setMaximumSize(new java.awt.Dimension(32767, 32767));
        setLayout(new java.awt.CardLayout());

        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(dataMakanan);

        javax.swing.GroupLayout DataMenuMakananLayout = new javax.swing.GroupLayout(DataMenuMakanan);
        DataMenuMakanan.setLayout(DataMenuMakananLayout);
        DataMenuMakananLayout.setHorizontalGroup(
            DataMenuMakananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DataMenuMakananLayout.createSequentialGroup()
                .addGroup(DataMenuMakananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DataMenuMakananLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 894, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(DataMenuMakananLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(btnTambah)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        DataMenuMakananLayout.setVerticalGroup(
            DataMenuMakananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DataMenuMakananLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(btnTambah)
                .addGap(48, 48, 48)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
                .addGap(78, 78, 78))
        );

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnBatal.setText("Batal");
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });

        jLabel1.setText("Nama Makanan");

        tvStok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tvStokActionPerformed(evt);
            }
        });

        jLabel2.setText("Stok");

        jLabel3.setText("Harga");

        jLabel4.setText("Kategori");

        tvKategori.setText("Makanan");

        javax.swing.GroupLayout TambahMenuLayout = new javax.swing.GroupLayout(TambahMenu);
        TambahMenu.setLayout(TambahMenuLayout);
        TambahMenuLayout.setHorizontalGroup(
            TambahMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TambahMenuLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(TambahMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4)
                    .addComponent(tvHarga, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                    .addComponent(jLabel3)
                    .addComponent(tvNama, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addGroup(TambahMenuLayout.createSequentialGroup()
                        .addComponent(btnSimpan)
                        .addGap(42, 42, 42)
                        .addComponent(btnBatal))
                    .addComponent(tvStok)
                    .addComponent(tvKategori, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE))
                .addContainerGap(625, Short.MAX_VALUE))
        );
        TambahMenuLayout.setVerticalGroup(
            TambahMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TambahMenuLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(TambahMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan)
                    .addComponent(btnBatal))
                .addGap(41, 41, 41)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(tvNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(tvStok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(tvHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(tvKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(267, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1006, Short.MAX_VALUE)
            .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(MainPanelLayout.createSequentialGroup()
                    .addGap(0, 34, Short.MAX_VALUE)
                    .addComponent(DataMenuMakanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 34, Short.MAX_VALUE)))
            .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(MainPanelLayout.createSequentialGroup()
                    .addGap(0, 34, Short.MAX_VALUE)
                    .addComponent(TambahMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 34, Short.MAX_VALUE)))
        );
        MainPanelLayout.setVerticalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 665, Short.MAX_VALUE)
            .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(MainPanelLayout.createSequentialGroup()
                    .addGap(0, 2, Short.MAX_VALUE)
                    .addComponent(DataMenuMakanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 2, Short.MAX_VALUE)))
            .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(MainPanelLayout.createSequentialGroup()
                    .addGap(0, 2, Short.MAX_VALUE)
                    .addComponent(TambahMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 2, Short.MAX_VALUE)))
        );

        add(MainPanel, "card4");
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        MainPanel.removeAll();
        MainPanel.repaint();
        MainPanel.revalidate();
        MainPanel.add(TambahMenu);
        MainPanel.repaint();
        MainPanel.revalidate();
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
       String nama = tvNama.getText();
       int stok = Integer.parseInt(tvStok.getText());
       int harga = Integer.parseInt(tvHarga.getText());
       String kategori = tvKategori.getText();
       
       try {
                Connection conn = Koneksi.getConnection();
                String sql = "INSERT INTO menu (nama, stok, harga,kategori) VALUES (?, ?, ?,?)";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, nama);
                stmt.setInt(2, stok);
                stmt.setInt(3, harga);
                stmt.setString(4, kategori);

                int i = stmt.executeUpdate();
                if (i > 0) {
                    JOptionPane.showMessageDialog(null, "Data berhasil dikirim!");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        MainPanel.removeAll();
        MainPanel.repaint();
        MainPanel.revalidate();
        MainPanel.add(DataMenuMakanan);
        MainPanel.repaint();
        MainPanel.revalidate();
        loadData();
    }//GEN-LAST:event_btnBatalActionPerformed

    private void tvStokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tvStokActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tvStokActionPerformed
    
    public void  loadData(){
        table.getDataVector().removeAllElements();
        table.fireTableDataChanged();
        
        try {
            Connection conn = Koneksi.getConnection();
            String sql = "SELECT * FROM menu WHERE kategori = 'Makanan'";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String nama = rs.getString("nama");
                int harga = rs.getInt("harga");
                int stok = rs.getInt("stok");
                String kategori = rs.getString("kategori");
                
                Object display[] = {nama, kategori, stok, harga};
                table.addRow(display);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DataMenuMakanan;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JPanel TambahMenu;
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnTambah;
    private javax.swing.JTable dataMakanan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField tvHarga;
    private javax.swing.JTextField tvKategori;
    private javax.swing.JTextField tvNama;
    private javax.swing.JTextField tvStok;
    // End of variables declaration//GEN-END:variables
}
