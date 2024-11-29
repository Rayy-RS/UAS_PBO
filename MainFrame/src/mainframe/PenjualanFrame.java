/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainframe;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PenjualanFrame extends JFrame {
    private JPanel penjualanPanel;
    private JTextField idPenjualanField, idPelangganField, idMobilField, totalBiayaField;
    private JButton addButton, updateButton, deleteButton, viewButton;
    private PenjualanCRUD penjualanCRUD;

    public PenjualanFrame() {
        setTitle("Kelola Data Penjualan");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        penjualanCRUD = new PenjualanCRUD(); // Inisialisasi CRUD penjualan

        penjualanPanel = new JPanel();
        penjualanPanel.setLayout(null);

        // Input dan Label
        JLabel idPenjualanLabel = new JLabel("ID Penjualan:");
        idPenjualanLabel.setBounds(20, 20, 100, 30);
        penjualanPanel.add(idPenjualanLabel);

        idPenjualanField = new JTextField();
        idPenjualanField.setBounds(140, 20, 300, 30);
        penjualanPanel.add(idPenjualanField);

        JLabel idPelangganLabel = new JLabel("ID Pelanggan:");
        idPelangganLabel.setBounds(20, 60, 100, 30);
        penjualanPanel.add(idPelangganLabel);

        idPelangganField = new JTextField();
        idPelangganField.setBounds(140, 60, 300, 30);
        penjualanPanel.add(idPelangganField);

        JLabel idMobilLabel = new JLabel("ID Mobil:");
        idMobilLabel.setBounds(20, 100, 100, 30);
        penjualanPanel.add(idMobilLabel);

        idMobilField = new JTextField();
        idMobilField.setBounds(140, 100, 300, 30);
        penjualanPanel.add(idMobilField);

        JLabel totalBiayaLabel = new JLabel("Total Biaya:");
        totalBiayaLabel.setBounds(20, 140, 100, 30);
        penjualanPanel.add(totalBiayaLabel);

        totalBiayaField = new JTextField();
        totalBiayaField.setBounds(140, 140, 300, 30);
        penjualanPanel.add(totalBiayaField);

        // Tombol Tambah
        addButton = new JButton("Tambah");
        addButton.setBounds(20, 200, 100, 30);
        addButton.addActionListener(e -> {
            try {
                int idPelanggan = Integer.parseInt(idPelangganField.getText());
                int idMobil = Integer.parseInt(idMobilField.getText());
                double totalBiaya = Double.parseDouble(totalBiayaField.getText());
                penjualanCRUD.tambahPenjualan(idPelanggan, idMobil, totalBiaya);
                JOptionPane.showMessageDialog(null, "Penjualan berhasil ditambahkan!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Masukkan data dengan benar!");
            }
        });

        // Tombol Update
        updateButton = new JButton("Update");
        updateButton.setBounds(140, 200, 100, 30);
        updateButton.addActionListener(e -> {
            try {
                int idPenjualan = Integer.parseInt(idPenjualanField.getText());
                int idPelanggan = Integer.parseInt(idPelangganField.getText());
                int idMobil = Integer.parseInt(idMobilField.getText());
                double totalBiaya = Double.parseDouble(totalBiayaField.getText());
                penjualanCRUD.updatePenjualan(idPenjualan, idPelanggan, idMobil, totalBiaya);
                JOptionPane.showMessageDialog(null, "Penjualan berhasil diperbarui!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Masukkan data dengan benar!");
            }
        });

        // Tombol Hapus
        deleteButton = new JButton("Hapus");
        deleteButton.setBounds(260, 200, 100, 30);
        deleteButton.addActionListener(e -> {
            try {
                int idPenjualan = Integer.parseInt(idPenjualanField.getText());
                penjualanCRUD.hapusPenjualan(idPenjualan);
                JOptionPane.showMessageDialog(null, "Penjualan berhasil dihapus!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Masukkan ID yang benar!");
            }
        });

        // Tombol Tampilkan
        viewButton = new JButton("Tampilkan");
        viewButton.setBounds(380, 200, 100, 30);
        viewButton.addActionListener(e -> {
            penjualanCRUD.tampilkanPenjualan(); // Menampilkan data di console
            JOptionPane.showMessageDialog(null, "Data penjualan ditampilkan di console!");
        });

        penjualanPanel.add(addButton);
        penjualanPanel.add(updateButton);
        penjualanPanel.add(deleteButton);
        penjualanPanel.add(viewButton);

        add(penjualanPanel);
    }
}
