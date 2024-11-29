/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainframe;
import java.sql.*;

public class MobilCRUD {
    private static final String URL = "jdbc:mysql://localhost:3306/penjualan_mobil"; // Ubah sesuai nama database Anda
    private static final String USERNAME = "root"; // Ubah sesuai username database Anda
    private static final String PASSWORD = ""; // Ubah sesuai password database Anda

    private Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    // CREATE: Tambah data mobil
    public void tambahMobil(String merk, int tahun, double harga) {
        String query = "INSERT INTO mobil (merk, tahun, harga) VALUES (?, ?, ?)";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, merk);
            pstmt.setInt(2, tahun);
            pstmt.setDouble(3, harga);
            pstmt.executeUpdate();
            System.out.println("Data mobil berhasil ditambahkan!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // READ: Tampilkan semua data mobil
    public void tampilkanMobil() {
        String query = "SELECT * FROM mobil";
        try (Connection conn = connect(); Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.println("ID Mobil: " + rs.getInt("idmobil"));
                System.out.println("Merk: " + rs.getString("merk"));
                System.out.println("Tahun: " + rs.getInt("tahun"));
                System.out.println("Harga: " + rs.getDouble("harga"));
                System.out.println("---------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // UPDATE: Perbarui data mobil berdasarkan ID
    public void updateMobil(int id, String merk, int tahun, double harga) {
        String query = "UPDATE mobil SET merk = ?, tahun = ?, harga = ? WHERE idmobil = ?";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, merk);
            pstmt.setInt(2, tahun);
            pstmt.setDouble(3, harga);
            pstmt.setInt(4, id);
            pstmt.executeUpdate();
            System.out.println("Data mobil berhasil diperbarui!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE: Hapus data mobil berdasarkan ID
    public void hapusMobil(int id) {
        String query = "DELETE FROM mobil WHERE idmobil = ?";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Data mobil berhasil dihapus!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

