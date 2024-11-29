package mainframe;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private JPanel mainPanel;
    private JButton pelangganButton, mobilButton, penjualanButton;

    public MainFrame() {
        setTitle("Sistem Penjualan Mobil");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        mainPanel = new JPanel();
        mainPanel.setLayout(null);

        // Tombol untuk membuka PelangganFrame
        pelangganButton = new JButton("Kelola Pelanggan");
        pelangganButton.setBounds(100, 50, 200, 40);
        pelangganButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PelangganFrame pelangganFrame = new PelangganFrame();
                pelangganFrame.setVisible(true);
            }
        });

        // Tombol untuk membuka MobilFrame
        mobilButton = new JButton("Kelola Mobil");
        mobilButton.setBounds(100, 110, 200, 40);
        mobilButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MobilFrame mobilFrame = new MobilFrame();
                mobilFrame.setVisible(true);
            }
        });

        // Tombol untuk membuka PenjualanFrame
        penjualanButton = new JButton("Kelola Penjualan");
        penjualanButton.setBounds(100, 170, 200, 40);
        penjualanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PenjualanFrame penjualanFrame = new PenjualanFrame();
                penjualanFrame.setVisible(true);
            }
        });

        // Menambahkan tombol ke panel utama
        mainPanel.add(pelangganButton);
        mainPanel.add(mobilButton);
        mainPanel.add(penjualanButton);

        // Menambahkan panel ke frame
        add(mainPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame mainFrame = new MainFrame();
            mainFrame.setVisible(true);
        });
    }
}
