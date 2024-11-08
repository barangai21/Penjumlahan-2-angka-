package aplikasi.penjumlahan.pkg2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AplikasiPenjumlahan2 extends JFrame {

    // Deklarasi komponen GUI
    private JTextField tfAngka1, tfAngka2, tfHasil;
    private JButton btnTambah, btnHapus, btnKeluar;

    public AplikasiPenjumlahan2() {
        setTitle("Aplikasi Pertambahan Dua Angka");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Menggunakan GridLayout: 4 baris dan 2 kolom
        setLayout(new GridLayout(5, 2, 10, 10)); // 5 baris, 2 kolom, dengan gap horizontal dan vertikal 10 piksel
        
        // Menambahkan komponen dengan GridLayout
        add(new JLabel("Angka Pertama:"));
        tfAngka1 = new JTextField(15); // Menambahkan text field untuk input angka pertama
        add(tfAngka1);
        
        add(new JLabel("Angka Kedua:"));
        tfAngka2 = new JTextField(15); // Menambahkan text field untuk input angka kedua
        add(tfAngka2);
        
        add(new JLabel("Hasil:"));
        tfHasil = new JTextField(15); // Menambahkan text field untuk menampilkan hasil
        tfHasil.setEditable(false); // Tidak bisa di-edit oleh pengguna
        add(tfHasil);
        
        // Tombol aksi
        btnTambah = new JButton("Tambah");
        btnHapus = new JButton("Hapus");
        btnKeluar = new JButton("Keluar");
        
        // Menambahkan tombol ke dalam layout
        add(btnTambah);
        add(btnHapus);
        add(btnKeluar);
        
        // Menambahkan action listener untuk tombol
        btnTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double angka1 = Double.parseDouble(tfAngka1.getText());
                    double angka2 = Double.parseDouble(tfAngka2.getText());
                    double hasil = angka1 + angka2;
                    tfHasil.setText(String.valueOf(hasil)); // Menampilkan hasil penjumlahan
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(AplikasiPenjumlahan2.this, "Input harus berupa angka!", 
                        "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        btnHapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfAngka1.setText("");
                tfAngka2.setText("");
                tfHasil.setText("");
                tfAngka1.requestFocus(); // Fokuskan ke text field angka pertama
            }
        });
        
        btnKeluar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Menutup aplikasi
            }
        });
        
        // Membatasi input hanya angka
        tfAngka1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) && c != '.' && c != KeyEvent.VK_BACK_SPACE) {
                    e.consume(); // Membatasi input selain angka dan titik
                }
            }
        });
        
        tfAngka2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) && c != '.' && c != KeyEvent.VK_BACK_SPACE) {
                    e.consume(); // Membatasi input selain angka dan titik
                }
            }
        });
        
        // Menambahkan FocusListener untuk membersihkan JTextField saat mendapatkan fokus
        tfAngka1.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                tfAngka1.setText(""); // Menghapus teks ketika fokus ke tfAngka1
            }
        });
        
        tfAngka2.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                tfAngka2.setText(""); // Menghapus teks ketika fokus ke tfAngka2
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AplikasiPenjumlahan2().setVisible(true); // Menampilkan JFrame
            }
        });
    }
}
