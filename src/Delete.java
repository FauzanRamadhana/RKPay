
import koneksi.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author fauzanramadhana
 */
public class Delete {

    public static void main(String[] args) {
        try {
            try (Connection conn = Koneksi.getConnection()) {

                String kueriInsert = "DELETE FROM users WHERE id = ?";
                PreparedStatement ps = conn.prepareStatement(kueriInsert);

                ps.setInt(1, 11);
                int rowAffected = ps.executeUpdate();
                if (rowAffected > 0) {
                    System.out.println("Delete data berhasil");
                }
                ps.close();
            }
        } catch (SQLException ex) {
            System.out.println("Eksepsi akses data: " + ex.getMessage());
        }
    }
}
