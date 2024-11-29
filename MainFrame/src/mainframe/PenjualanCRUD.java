/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainframe;
import java.sql.*;

public class PenjualanCRUD {
    private static final String URL = "jdbc:mysql://localhost:3306/penjualan_mobil"; // Ubah sesuai nama database Anda
    private static final String USERNAME = "root"; // Ubah sesuai username database Anda
    private static final String PASSWORD = ""; // Ubah sesuai password database Anda

    private Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    // CREATE: Tambah data penjualan
    public void tambahPenjualan(int idPelanggan, int idMobil, double totalBiaya) {
        String query = "INSERT INTO penjualan (idpelanggan, idmobil, totalbiaya) VALUES (?, ?, ?)";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, idPelanggan);
            pstmt.setInt(2, idMobil);
            pstmt.setDouble(3, totalBiaya);
            pstmt.executeUpdate();
            System.out.println("Data penjualan berhasil ditambahkan!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // READ: Tampilkan semua data penjualan
    public void tampilkanPenjualan() {
        String query = """
            SELECT p.idpenjualan, pel.nama AS nama_pelanggan, m.merk AS merk_mobil, p.totalbiaya
            FROM penjualan p
            JOIN pelanggan pel ON p.idpelanggan = pel.idpelanggan
            JOIN mobil m ON p.idmobil = m.idmobil
        """;
        try (Connection conn = connect(); Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.println("ID Penjualan: " + rs.getInt("idpenjualan"));
                System.out.println("Nama Pelanggan: " + rs.getString("nama_pelanggan"));
                System.out.println("Merk Mobil: " + rs.getString("merk_mobil"));
                System.out.println("Total Biaya: " + rs.getDouble("totalbiaya"));
                System.out.println("---------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // UPDATE: Perbarui data penjualan berdasarkan ID
    public void updatePenjualan(int idPenjualan, int idPelanggan, int idMobil, double totalBiaya) {
        String query = "UPDATE penjualan SET idpelanggan = ?, idmobil = ?, totalbiaya = ? WHERE idpenjualan = ?";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, idPelanggan);
            pstmt.setInt(2, idMobil);
            pstmt.setDouble(3, totalBiaya);
            pstmt.setInt(4, idPenjualan);
            pstmt.executeUpdate();
            System.out.println("Data penjualan berhasil diperbarui!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE: Hapus data penjualan berdasarkan ID
    public void hapusPenjualan(int idPenjualan) {
        String query = "DELETE FROM penjualan WHERE idpenjualan = ?";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, idPenjualan);
            pstmt.executeUpdate();
            System.out.println("Data penjualan berhasil dihapus!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

