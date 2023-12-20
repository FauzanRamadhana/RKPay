/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import koneksi.Koneksi;

/**
 *
 * @author wandy
 */
public class Model_Meja {

    public Model_Meja() {
    }
    
    public void loadData(DefaultTableModel table) {
        try {
            Connection conn = Koneksi.getConnection();
            String sql = "SELECT * FROM meja";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String status = rs.getString("status");

                Object display[] = {id, status};
                table.addRow(display);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
    
    public int addMeja(){
        int i = 0;
        try {
            Connection conn = Koneksi.getConnection();
            String sql = "INSERT INTO meja (status) VALUES (?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, "Kosong");

            i = stmt.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
        return i;
    }
}
