/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainframe;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MobilFrame extends JFrame {
    private JPanel mobilPanel;
    private JTextField idField, merkField, tahunField, hargaField;
    private JButton addButton, updateButton, deleteButton, viewButton;
    private MobilCRUD mobilCRUD;

    public MobilFrame() {
        setTitle("Kelola Data Mobil");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        mobilCRUD = new MobilCRUD(); // Inisialisasi CRUD mobil

        mobilPanel = new JPanel();
        mobilPanel.setLayout(null);

        // Input dan Label
        JLabel idLabel = new JLabel("ID Mobil:");
        idLabel.setBounds(20, 20, 100, 30);
        mobilPanel.add(idLabel);

        idField = new JTextField();
        idField.setBounds(140, 20, 300, 30);
        mobilPanel.add(idField);

        JLabel merkLabel = new JLabel("Merk:");
        merkLabel.setBounds(20, 60, 100, 30);
        mobilPanel.add(merkLabel);

        merkField = new JTextField();
        merkField.setBounds(140, 60, 300, 30);
        mobilPanel.add(merkField);

        JLabel tahunLabel = new JLabel("Tahun:");
        tahunLabel.setBounds(20, 100, 100, 30);
        mobilPanel.add(tahunLabel);

        tahunField = new JTextField();
        tahunField.setBounds(140, 100, 300, 30);
        mobilPanel.add(tahunField);

        JLabel hargaLabel = new JLabel("Harga:");
        hargaLabel.setBounds(20, 140, 100, 30);
        mobilPanel.add(hargaLabel);

        hargaField = new JTextField();
        hargaField.setBounds(140, 140, 300, 30);
        mobilPanel.add(hargaField);

        // Tombol Tambah
        addButton = new JButton("Tambah");
        addButton.setBounds(20, 200, 100, 30);
        addButton.addActionListener(e -> {
            try {
                String merk = merkField.getText();
                int tahun = Integer.parseInt(tahunField.getText());
                double harga = Double.parseDouble(hargaField.getText());
                mobilCRUD.tambahMobil(merk, tahun, harga);
                JOptionPane.showMessageDialog(null, "Mobil berhasil ditambahkan!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Masukkan data dengan benar!");
            }
        });

        // Tombol Update
        updateButton = new JButton("Update");
        updateButton.setBounds(140, 200, 100, 30);
        updateButton.addActionListener(e -> {
            try {
                int id = Integer.parseInt(idField.getText());
                String merk = merkField.getText();
                int tahun = Integer.parseInt(tahunField.getText());
                double harga = Double.parseDouble(hargaField.getText());
                mobilCRUD.updateMobil(id, merk, tahun, harga);
                JOptionPane.showMessageDialog(null, "Mobil berhasil diperbarui!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Masukkan data dengan benar!");
            }
        });

        // Tombol Hapus
        deleteButton = new JButton("Hapus");
        deleteButton.setBounds(260, 200, 100, 30);
        deleteButton.addActionListener(e -> {
            try {
                int id = Integer.parseInt(idField.getText());
                mobilCRUD.hapusMobil(id);
                JOptionPane.showMessageDialog(null, "Mobil berhasil dihapus!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Masukkan ID yang benar!");
            }
        });

        // Tombol Tampilkan
        viewButton = new JButton("Tampilkan");
        viewButton.setBounds(380, 200, 100, 30);
        viewButton.addActionListener(e -> {
            mobilCRUD.tampilkanMobil(); // Menampilkan data di console
            JOptionPane.showMessageDialog(null, "Data mobil ditampilkan di console!");
        });

        mobilPanel.add(addButton);
        mobilPanel.add(updateButton);
        mobilPanel.add(deleteButton);
        mobilPanel.add(viewButton);

        add(mobilPanel);
    }
}
