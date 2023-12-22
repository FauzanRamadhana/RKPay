/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import koneksi.Koneksi;

/**
 *
 * @author wandy
 */
public class User {
    private static int id;
    private static String role;

    public static String getRole() {
        return role;
    }

    public static void setRole(String role) {
        User.role = role;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        User.id = id;
    }
    
    public static boolean login(String nama, String password){
        boolean result = false; 
        try {
            Connection conn = Koneksi.getConnection();
            String sql = "SELECT * FROM users WHERE nama = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nama);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int userId = rs.getInt("id");
                String userRole = rs.getString("role");
                setId(userId);
                setRole(userRole);
                result = true;
            } 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
        return result;
    }
    
    public static int register(String nama, String phone, String password, String cPassword){
        int i = 0;
        if (password.equals(cPassword)) {
            try {
                Connection conn = Koneksi.getConnection();
                String sql = "INSERT INTO users (nama, telepon, password, role) VALUES (?, ?, ?,?)";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, nama);
                stmt.setString(2, phone);
                stmt.setString(3, password);
                stmt.setString(4, "Kasir");

                i = stmt.executeUpdate();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Konfirmasi password tidak sesuai!");
        }
        return i;
    }
}
