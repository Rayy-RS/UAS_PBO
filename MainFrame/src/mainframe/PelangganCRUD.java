/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainframe;
import java.sql.*;

public class PelangganCRUD {
    private static final String URL = "jdbc:mysql://localhost:3306/penjualan_mobil"; // Ganti nama database sesuai kebutuhan
    private static final String USERNAME = "root"; // Ganti dengan username MySQL Anda
    private static final String PASSWORD = ""; // Ganti dengan password MySQL Anda

    private Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    // Tambah pelanggan
    public void tambahPelanggan(String nama, String nik, String telp, String alamat) {
        String query = "INSERT INTO pelanggan (nama, nik, notelp, alamat) VALUES (?, ?, ?, ?)";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, nama);
            pstmt.setString(2, nik);
            pstmt.setString(3, telp);
            pstmt.setString(4, alamat);
            pstmt.executeUpdate();
            System.out.println("Pelanggan berhasil ditambahkan.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Tampilkan semua pelanggan
    public void tampilkanPelanggan() {
        String query = "SELECT * FROM pelanggan";
        try (Connection conn = connect(); Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.println("ID Pelanggan: " + rs.getInt("idpelanggan"));
                System.out.println("Nama: " + rs.getString("nama"));
                System.out.println("NIK: " + rs.getString("nik"));
                System.out.println("No Telp: " + rs.getString("notelp"));
                System.out.println("Alamat: " + rs.getString("alamat"));
                System.out.println("---------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Update pelanggan
    public void updatePelanggan(int id, String nama, String nik, String telp, String alamat) {
        String query = "UPDATE pelanggan SET nama = ?, nik = ?, notelp = ?, alamat = ? WHERE idpelanggan = ?";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, nama);
            pstmt.setString(2, nik);
            pstmt.setString(3, telp);
            pstmt.setString(4, alamat);
            pstmt.setInt(5, id);
            pstmt.executeUpdate();
            System.out.println("Pelanggan berhasil diperbarui.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Hapus pelanggan
    public void hapusPelanggan(int id) {
        String query = "DELETE FROM pelanggan WHERE idpelanggan = ?";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Pelanggan berhasil dihapus.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

