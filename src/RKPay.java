/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author fauzanramadhana
 */
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class RKPay {

    public static void main(String[] args) {
        String nama = "Ihsan Muhamad Ikbal";
        String password = "Ihsan123";
        String role = "Admin";
        try {
            Connection conn = Koneksi.getConnection();
            System.out.println("Koneksi berhasil");

            String kueriInsert = "INSERT INTO users (nama, password ,role) VALUES (?,?,?)";
            PreparedStatement ps = conn.prepareStatement(kueriInsert);
            ps.setString(1, nama);
            ps.setString(2, password);
            ps.setString(3, role);
            int rowAffected = ps.executeUpdate();
            if (rowAffected > 0) {
                System.out.println("Insert data berhasil");
            }
            ps.close();
            conn.close();

            conn.close();
        } catch (SQLException ex) {
            System.out.println("Eksepsi akses data: " + ex.getMessage());
        }
    }

}
