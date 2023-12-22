/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import koneksi.Koneksi;

/**
 *
 * @author wandy
 */
public class Model_Transaksi {

    private int id;
    private String nama;
    private int jumlah;
    private int subTotal;

    public Model_Transaksi(int id, String nama, int jumlah, int subTotal) {
        this.id = id;
        this.nama = nama;
        this.jumlah = jumlah;
        this.subTotal = subTotal;
    }

    public Model_Transaksi() {
    }

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public int getJumlah() {
        return jumlah;
    }

    public int getSubTotal() {
        return subTotal;
    }

    public void addTransaksi(int noMeja, int totalBayar, ArrayList<Model_Transaksi> list) {
        Date currentDate = new Date();
        java.sql.Date sqlDate = new java.sql.Date(currentDate.getTime());
        try {
            Connection conn = Koneksi.getConnection();
            String sql = "INSERT INTO transaksi (tgl_transaksi, mejaId, totalBayar, status, userId) VALUES (?, ?, ?, ?, ?)";
            
            // Menggunakan Statement.RETURN_GENERATED_KEYS untuk mendapatkan kunci yang dihasilkan
            PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setDate(1, sqlDate);
            stmt.setInt(2, noMeja);
            stmt.setInt(3, totalBayar);
            stmt.setString(4, "Diproses");
            stmt.setInt(5, User.getId());

            int affectedRows = stmt.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int newIdTransaksi = generatedKeys.getInt(1);

                        String sqlDetailTransaksi = "INSERT INTO detail_transaksi (transaksiId, menuId, jumlah, subtotal) VALUES (?, ?, ?, ?)";
                        PreparedStatement stmtDetailTransaksi = conn.prepareStatement(sqlDetailTransaksi);

                        for (Model_Transaksi detail : list) {
                            stmtDetailTransaksi.setInt(1, newIdTransaksi);
                            stmtDetailTransaksi.setInt(2, detail.getId());
                            stmtDetailTransaksi.setInt(3, detail.getJumlah());
                            stmtDetailTransaksi.setInt(4, detail.getSubTotal());

                            stmtDetailTransaksi.executeUpdate();
                            kurangiStokMenu(detail.getId(), detail.getJumlah());
                            setMeja(noMeja);
                        }
                        JOptionPane.showMessageDialog(null, "Transaksi selesai!", "Info", JOptionPane.INFORMATION_MESSAGE);
                        stmtDetailTransaksi.close();
                    }
                }
            }
            stmt.close();
            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
    
    private void kurangiStokMenu(int idMenu, int jumlah) throws Exception {
        Connection conn = Koneksi.getConnection();
        String sqlUpdateStok = "UPDATE menu SET stok = stok - ? WHERE id = ?";
        try (PreparedStatement stmtUpdateStok = conn.prepareStatement(sqlUpdateStok)) {
            stmtUpdateStok.setInt(1, jumlah);
            stmtUpdateStok.setInt(2, idMenu);

            stmtUpdateStok.executeUpdate();
        }
    }
    
    private void setMeja(int id) throws Exception{
        Connection conn = Koneksi.getConnection();
        String sqlSetMeja = "UPDATE meja SET status = 'Penuh' WHERE id = ?";
        try (PreparedStatement stmtUpdateStok = conn.prepareStatement(sqlSetMeja)) {
            stmtUpdateStok.setInt(1, id);

            stmtUpdateStok.executeUpdate();
        }
    }
    
    public int getStokMenu(int id){
        int stok = 0;

        try {
            Connection conn = Koneksi.getConnection();
            String sql = "SELECT stok FROM menu WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                stok = rs.getInt("stok");
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }

        return stok;
    }

    public Vector<String> loadDataToComboBox(JComboBox comboBox) {
        Vector<String> data = new Vector<>();
        try {
            Connection conn = Koneksi.getConnection();
            String sql = "SELECT * FROM meja WHERE status = 'Kosong'";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String value = rs.getString("id");
                data.add(value);
            }

            comboBox.setModel(new DefaultComboBoxModel<>(data));

            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
        return data;
    }

    public void loadMenu(DefaultTableModel table) {
        try {
            Connection conn = Koneksi.getConnection();
            String sql = "SELECT * FROM menu";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nama = rs.getString("nama");
                int harga = rs.getInt("harga");
                int stok = rs.getInt("stok");
                String kategori = rs.getString("kategori");

                Object display[] = {id, nama, kategori, stok, harga};
                table.addRow(display);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
}
