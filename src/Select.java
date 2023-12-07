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
import java.sql.ResultSet;

public class Select {

    public static void main(String[] args) {
        try {
            Connection conn = Koneksi.getConnection();

            String kueriInsert = "SELECT * from users";
            PreparedStatement ps = conn.prepareStatement(kueriInsert);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String nama = rs.getString("nama");
                String password = rs.getString("password");
                String role = rs.getString("role");
                System.out.println("Nama: " + nama + "\npassword: " + password + "\nrole: " + role + "\n");
            }
            rs.close();
            ps.close();
            conn.close();

        } catch (SQLException ex) {
            System.out.println("Eksepsi akses data: " + ex.getMessage());
        }
    }

}
