/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import koneksi.Koneksi;

/**
 *
 * @author wandy
 */
public class Model_Laporan {

    public Model_Laporan() {
    }

    public void loadDataTransaksi(DefaultTableModel table) {
        table.getDataVector().removeAllElements();
        table.fireTableDataChanged();
        try {
            Connection conn = Koneksi.getConnection();
            String sql = "SELECT * FROM transaksi";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                Date tgl = rs.getDate("tgl_transaksi");
                String status = rs.getString("status");
                int meja = rs.getInt("mejaId");
                int total = rs.getInt("totalBayar");

                Object display[] = {id, tgl, status, meja, total};
                table.addRow(display);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    public void loadDataDetail(DefaultTableModel table, int id) {
        table.getDataVector().removeAllElements();
        table.fireTableDataChanged();
        try {
            Connection conn = Koneksi.getConnection();
            String sql = "SELECT m.id, m.nama, m.kategori, m.harga, dt.jumlah, dt.subTotal\n"
                    + "FROM detail_transaksi AS dt\n"
                    + "JOIN menu AS m ON m.id = dt.menuId\n"
                    + "WHERE transaksiId = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int menuId = rs.getInt("id");
                String nama = rs.getString("nama");
                String kategori = rs.getString("kategori");
                int harga = rs.getInt("harga");
                int jumlah = rs.getInt("jumlah");
                int subTotal = rs.getInt("subTotal");

                Object display[] = {menuId, nama, kategori, harga, jumlah, subTotal};
                table.addRow(display);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    public void updateMejaStatus(int meja) {
        try {
            Connection conn = Koneksi.getConnection();
            String sql = "UPDATE meja SET status = 'Kosong' WHERE id = ?";

            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, meja);

                int affectedRows = stmt.executeUpdate();

                if (affectedRows > 0) {
                    JOptionPane.showMessageDialog(null, "Transaksi telah selesai!", "Info", JOptionPane.INFORMATION_MESSAGE);
                } 
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
    
    public void updateTransaksiStatus(int id){
        try {
            Connection conn = Koneksi.getConnection();
            String sql = "UPDATE transaksi SET status = 'Selesai' WHERE id = ?";

            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, id);

                stmt.executeUpdate();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
}
