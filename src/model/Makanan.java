/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import koneksi.Koneksi;
import service.ServiceMenu;

/**
 *
 * @author wandy
 */
public class Makanan implements ServiceMenu {
    
    public Makanan() {
    }

    @Override
    public int updateData(String nama, int stok, int harga, int id) {
        int i = 0;
        try {
            Connection conn = Koneksi.getConnection();
            String sql = "UPDATE menu SET nama = ?, stok = ?, harga = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nama);
            stmt.setInt(2, stok);
            stmt.setInt(3, harga);
            stmt.setInt(4, id);

            i = stmt.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
        return i;
    }

    @Override
    public void loadData(DefaultTableModel table) {
        try {
            Connection conn = Koneksi.getConnection();
            String sql = "SELECT * FROM menu WHERE kategori = 'Makanan' AND showMenu = 1";
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

    @Override
    public int addData(String nama, int stok, int harga, String kategori) {
        int i = 0;
        try {
            Connection conn = Koneksi.getConnection();
            String sql = "INSERT INTO menu (nama, stok, harga, kategori, showMenu) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nama);
            stmt.setInt(2, stok);
            stmt.setInt(3, harga);
            stmt.setString(4, kategori);
            stmt.setInt(5, 1);

            i = stmt.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
        return i;
    }

    @Override
    public void deleteData(int index) {
        try {
            Connection conn = Koneksi.getConnection();
            String sql = "UPDATE menu SET showMenu = 0 WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, index);
            stmt.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    
}
