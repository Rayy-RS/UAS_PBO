
package mainframe;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PelangganFrame extends JFrame {
    private JPanel pelangganPanel;
    private JTextField idField, namaField, nikField, telpField, alamatField;
    private JButton addButton, updateButton, deleteButton, viewButton;
    private PelangganCRUD pelangganCRUD;

    public PelangganFrame() {
        setTitle("Kelola Pelanggan");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        pelangganCRUD = new PelangganCRUD(); // Inisialisasi CRUD pelanggan

        pelangganPanel = new JPanel();
        pelangganPanel.setLayout(null);

        // Komponen input dan label
        JLabel idLabel = new JLabel("ID Pelanggan:");
        idLabel.setBounds(20, 20, 100, 30);
        pelangganPanel.add(idLabel);

        idField = new JTextField();
        idField.setBounds(140, 20, 300, 30);
        pelangganPanel.add(idField);

        JLabel namaLabel = new JLabel("Nama:");
        namaLabel.setBounds(20, 60, 100, 30);
        pelangganPanel.add(namaLabel);

        namaField = new JTextField();
        namaField.setBounds(140, 60, 300, 30);
        pelangganPanel.add(namaField);

        JLabel nikLabel = new JLabel("NIK:");
        nikLabel.setBounds(20, 100, 100, 30);
        pelangganPanel.add(nikLabel);

        nikField = new JTextField();
        nikField.setBounds(140, 100, 300, 30);
        pelangganPanel.add(nikField);

        JLabel telpLabel = new JLabel("No Telp:");
        telpLabel.setBounds(20, 140, 100, 30);
        pelangganPanel.add(telpLabel);

        telpField = new JTextField();
        telpField.setBounds(140, 140, 300, 30);
        pelangganPanel.add(telpField);

        JLabel alamatLabel = new JLabel("Alamat:");
        alamatLabel.setBounds(20, 180, 100, 30);
        pelangganPanel.add(alamatLabel);

        alamatField = new JTextField();
        alamatField.setBounds(140, 180, 300, 30);
        pelangganPanel.add(alamatField);

        // Tombol Tambah
        addButton = new JButton("Tambah");
        addButton.setBounds(20, 240, 100, 30);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nama = namaField.getText();
                    String nik = nikField.getText();
                    String telp = telpField.getText();
                    String alamat = alamatField.getText();

                    if (nama.isEmpty() || nik.isEmpty() || telp.isEmpty() || alamat.isEmpty()) {
                        throw new Exception("Semua field harus diisi!");
                    }

                    pelangganCRUD.tambahPelanggan(nama, nik, telp, alamat);
                    JOptionPane.showMessageDialog(null, "Pelanggan berhasil ditambahkan!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Gagal menambahkan pelanggan: " + ex.getMessage());
                }
            }
        });

        // Tombol Update
        updateButton = new JButton("Update");
        updateButton.setBounds(140, 240, 100, 30);
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(idField.getText());
                    String nama = namaField.getText();
                    String nik = nikField.getText();
                    String telp = telpField.getText();
                    String alamat = alamatField.getText();

                    if (nama.isEmpty() || nik.isEmpty() || telp.isEmpty() || alamat.isEmpty()) {
                        throw new Exception("Semua field harus diisi!");
                    }

                    pelangganCRUD.updatePelanggan(id, nama, nik, telp, alamat);
                    JOptionPane.showMessageDialog(null, "Pelanggan berhasil diperbarui!");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "ID harus berupa angka!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Gagal memperbarui pelanggan: " + ex.getMessage());
                }
            }
        });

        // Tombol Hapus
        deleteButton = new JButton("Hapus");
        deleteButton.setBounds(260, 240, 100, 30);
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(idField.getText());
                    pelangganCRUD.hapusPelanggan(id);
                    JOptionPane.showMessageDialog(null, "Pelanggan berhasil dihapus!");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "ID harus berupa angka!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Gagal menghapus pelanggan: " + ex.getMessage());
                }
            }
        });

        // Tombol Tampilkan
        viewButton = new JButton("Tampilkan");
        viewButton.setBounds(380, 240, 100, 30);
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pelangganCRUD.tampilkanPelanggan(); // Menampilkan data di console
                JOptionPane.showMessageDialog(null, "Data pelanggan ditampilkan di console!");
            }
        });

        pelangganPanel.add(addButton);
        pelangganPanel.add(updateButton);
        pelangganPanel.add(deleteButton);
        pelangganPanel.add(viewButton);

        add(pelangganPanel);
    }
}
