package benda_geometri.gui;

import benda_geometri.dua_dimensi.*;
import benda_geometri.tiga_dimensi.*;
import benda_geometri.tiga_dimensi.limas.*;
import benda_geometri.tiga_dimensi.prisma.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutionException;

public class GeometryCalculatorGUI extends JFrame implements ActionListener {

    // Komponen GUI
    private JComboBox<String> shapeComboBox;
    private JPanel inputPanel;
    private JLabel param1Label, param2Label, param3Label, param4Label, param5Label;
    private JTextField param1Field, param2Field, param3Field, param4Field, param5Field;
    private JButton calculateButton;
    private JTextArea resultArea;
    private JButton calculateAllButton;
    
    public GeometryCalculatorGUI() {
    setTitle("Kalkulator Geometri Objek");
    setSize(500, 600);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null); // Posisikan di tengah layar

    // Main Panel dengan BorderLayout
    JPanel mainPanel = new JPanel(new BorderLayout());
    add(mainPanel);

    // --- Top Panel (Shape Selection) ---
    JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    topPanel.setBorder(BorderFactory.createTitledBorder("Pilih Bentuk Geometri"));
    String[] shapes = {
        "Segitiga", "Persegi", "Persegi Panjang", "Jajar Genjang",
        "Belah Ketupat", "Layang-Layang", "Trapesium", "Lingkaran",
        "Juring Lingkaran", "Tembereng Lingkaran",
        // Tambahkan bentuk 3D di sini jika diinginkan
        "Kubus", "Balok", "Kerucut", "Tabung", "Bola",
        "Cincin Bola", "Juring Bola", "Tembereng Bola", "Kerucut Terpancung",
        "Limas Belah Ketupat", "Limas Jajar Genjang", "Limas Layang-Layang",
        "Limas Persegi", "Limas Persegi Panjang", "Limas Segitiga", "Limas Trapesium",
        "Prisma Belah Ketupat", "Prisma Jajar Genjang", "Prisma Layang-Layang",
        "Prisma Persegi", "Prisma Persegi Panjang", "Prisma Segitiga", "Prisma Trapesium"
    };

    shapeComboBox = new JComboBox<>(shapes);
    shapeComboBox.addActionListener(this); // Menangani perubahan pilihan combo box
    topPanel.add(new JLabel("Bentuk:"));
    topPanel.add(shapeComboBox);
    mainPanel.add(topPanel, BorderLayout.NORTH);

    // --- Input Panel (Dynamic based on selection) ---
    inputPanel = new JPanel(new GridLayout(5, 2, 10, 10)); // 5 rows, 2 cols, with gaps
    inputPanel.setBorder(BorderFactory.createTitledBorder("Input Parameter"));

    param1Label = new JLabel("Parameter 1:");
    param1Field = new JTextField(10);
    param2Label = new JLabel("Parameter 2:");
    param2Field = new JTextField(10);
    param3Label = new JLabel("Parameter 3:");
    param3Field = new JTextField(10);
    param4Label = new JLabel("Parameter 4:");
    param4Field = new JTextField(10);
    param5Label = new JLabel("Parameter 5:");
    param5Field = new JTextField(10);

    inputPanel.add(param1Label); inputPanel.add(param1Field);
    inputPanel.add(param2Label); inputPanel.add(param2Field);
    inputPanel.add(param3Label); inputPanel.add(param3Field);
    inputPanel.add(param4Label); inputPanel.add(param4Field);
    inputPanel.add(param5Label); inputPanel.add(param5Field);

    mainPanel.add(inputPanel, BorderLayout.CENTER);

    // --- Bottom Panel (Calculate Button and Result Area) ---
    JPanel bottomPanel = new JPanel(new BorderLayout());

    // Inisialisasi tombol sebelum menambahkannya ke panel
    calculateButton = new JButton("Hitung");
    calculateButton.addActionListener(this); // Menangani klik tombol Hitung

    // Inisialisasi tombol baru
    calculateAllButton = new JButton("Hitung Semua Bentuk (Multithreaded)");
    calculateAllButton.addActionListener(this);

    // Buat panel untuk menampung kedua tombol
    JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    buttonPanel.add(calculateButton);
    buttonPanel.add(calculateAllButton);

    // Tambahkan panel tombol ke bagian utara bottomPanel
    bottomPanel.add(buttonPanel, BorderLayout.NORTH);

    resultArea = new JTextArea(10, 40);
    resultArea.setEditable(false);
    JScrollPane scrollPane = new JScrollPane(resultArea);
    bottomPanel.add(scrollPane, BorderLayout.CENTER); // Menambahkan scrollPane ke bagian tengah bottomPanel

    mainPanel.add(bottomPanel, BorderLayout.SOUTH);

    // Inisialisasi tampilan input berdasarkan pilihan awal (Segitiga)
    updateInputFields();
    }
    
    // Metode baru untuk perhitungan multithreaded
    private void calculateAllShapesMultithreaded() {
        resultArea.setText(""); // Bersihkan area hasil
        resultArea.append("=== Memulai Perhitungan Keseluruhan (Multithreaded) ===\n");

        ExecutorService executor = Executors.newFixedThreadPool(10);
        List<Callable<String>> tasks = new ArrayList<>();

        // --- KUMPULKAN SEMUA TUGAS PERHITUNGAN (dari Main.java) ---

        // 1. Jajar Genjang
        tasks.add(() -> {
            JajarGenjang j = new JajarGenjang(10, 7, 5, 6);
            return String.format("\n-> Jajar Genjang\nalas = 10 & tinggi = 7 & sisi A = 5 & sisi B = 6\nLuas Jajar Genjang : %.1f\nKeliling Jajar Genjang : %.1f", j.hitungLuas(), j.hitungKeliling());
        });

        // 2. Belah Ketupat
        tasks.add(() -> {
            BelahKetupat bk = new BelahKetupat(6, 8, 5);
            return String.format("\n-> Belah Ketupat\ndiagonal1 = 6 & diagonal2 = 8 & sisi = 5\nLuas Belah Ketupat : %.1f\nKeliling Belah Ketupat : %.1f", bk.hitungLuas(), bk.hitungKeliling());
        });

        // 3. Layang-Layang
        tasks.add(() -> {
            LayangLayang ll = new LayangLayang(20, 10, 12, 22);
            return String.format("\n-> Layang-layang\ndiagonal1 = 20 & diagonal2 = 10 & sisi pendek = 12 & sisi panjang = 22\nLuas Layang-layang : %.1f\nKeliling Layang-layang : %.1f", ll.hitungLuas(), ll.hitungKeliling());
        });

        // 4. Persegi
        tasks.add(() -> {
            Persegi p = new Persegi(10);
            return String.format("\n-> Persegi\nsisi = 10\nLuas Persegi : %.1f\nKeliling Persegi: %.1f", p.hitungLuas(), p.hitungKeliling());
        });

        // 5. Persegi Panjang
        tasks.add(() -> {
            PersegiPanjang pp = new PersegiPanjang(12, 10);
            return String.format("\n-> Persegi Panjang\npanjang= 12 & lebar = 10\nLuas Persegi Panjang : %.1f\nKeliling Persegi Panjang: %.1f", pp.hitungLuas(), pp.hitungKeliling());
        });

        // 6. Segitiga
        tasks.add(() -> {
            Segitiga s = new Segitiga(12, 10);
            return String.format("\n-> Segitiga\nalas= 12 & tinggi= 10\nLuas Segitiga : %.1f\nKeliling Segitiga: %.1f", s.hitungLuas(), s.hitungKeliling());
        });

        // 7. Trapesium
        tasks.add(() -> {
            Trapesium t = new Trapesium(10, 14, 8, 6);
            return String.format("\n-> Trapesium\nalas atas = 10 & alas bawah = 14 & sisi miring = 8 & tinggi = 6\nLuas Trapesium : %.1f\nKeliling Trapesium : %.1f", t.hitungLuas(), t.hitungKeliling());
        });

        // 8. Lingkaran
        tasks.add(() -> {
            Lingkaran l = new Lingkaran(7);
            return String.format("\n-> Lingkaran\njari-jari = 7\nLuas Lingkaran : %.2f\nKeliling Lingkaran : %.2f", l.hitungLuas(), l.hitungKeliling());
        });

        // 9. Juring Lingkaran
        tasks.add(() -> {
            JuringLingkaran jl = new JuringLingkaran(7, 90);
            return String.format("\n-> JuringLingkaran\njari-jari = 7 & sudut 90 derajat\nLuas JuringLingkaran: %.3f\nKeliling JuringLingkaran: %.3f", jl.hitungLuas(), jl.hitungKeliling());
        });

        // 10. Tembereng Lingkaran
        tasks.add(() -> {
            TemberengLingkaran tl = new TemberengLingkaran(7, 90);
            // Menggunakan String.valueOf karena hitungLuas/Keliling Tembereng Lingkaran mengembalikan String di Main.java
            return String.format("\n-> Tembereng Lingkaran\njari-jari = 7 & sudut 90 derajat\nLuas Tembereng Lingkaran: %s\nKeliling Tembereng Lingkaran: %s", String.valueOf(tl.hitungLuas()), String.valueOf(tl.hitungKeliling()));
        });

        // 11. Kubus
        tasks.add(() -> {
            Kubus k = new Kubus(5);
            return String.format("\n-> Kubus\nsisi = 5\nLuas Permukaan Kubus : %.1f\nVolume Kubus : %.1f", k.hitungLuasPermukaan(), k.hitungVolume());
        });

        // 12. Limas Persegi
        tasks.add(() -> {
            LimasPersegi lp = new LimasPersegi(5, 10);
            return String.format("\n-> Limas Persegi\nsisi = 5 & tinggi = 10\nLuas Permukaan Limas Persegi : %.2f\nVolume Limas Persegi : %.2f", lp.hitungLuasPermukaan(), lp.hitungVolume());
        });

        // 13. Prisma Persegi
        tasks.add(() -> {
            PrismaPersegi pp = new PrismaPersegi(5, 10);
            return String.format("\n-> Prisma Persegi\nsisi = 5 & tinggi = 10\nLuas Permukaan Prisma Persegi : %.1f\nVolume Prisma Persegi : %.1f", pp.hitungLuasPermukaan(), pp.hitungVolume());
        });

        // 14. Limas Belah Ketupat
        tasks.add(() -> {
            LimasBelahKetupat lbk = new LimasBelahKetupat(6, 8, 5, 10);
            return String.format("\n-> Limas Belah Ketupat\ndiagonal1 = 6, diagonal2 = 8, sisi = 5 & tinggi = 10\nLuas Permukaan Limas Belah Ketupat : %.2f\nVolume Limas Belah Ketupat : %.2f", lbk.hitungLuasPermukaan(), lbk.hitungVolume());
        });

        // 15. Prisma Belah Ketupat
        tasks.add(() -> {
            PrismaBelahKetupat pbk = new PrismaBelahKetupat(6, 8, 5, 10);
            return String.format("\n-> Prisma Belah Ketupat\ndiagonal1 = 6, diagonal2 = 8, sisi = 5 & tinggi = 10\nLuas Permukaan Prisma Belah Ketupat : %.1f\nVolume Prisma Belah Ketupat : %.1f", pbk.hitungLuasPermukaan(), pbk.hitungVolume());
        });

        // 16. Limas Layang-Layang
        tasks.add(() -> {
            LimasLayangLayang lll = new LimasLayangLayang(5, 10, 6, 10, 10);
            return String.format("\n-> Limas Layang-Layang\ndiagonal1 = 5, d2 = 10, sisi pendek = 6, sisi panjang = 10 & tinggi = 10\nLuas Permukaan Limas Layang-Layang : %.2f\nVolume Limas Layang-Layang : %.2f", lll.hitungLuasPermukaan(), lll.hitungVolume());
        });

        // 17. Prisma Layang-Layang
        tasks.add(() -> {
            PrismaLayangLayang pll = new PrismaLayangLayang(5, 10, 6, 10, 10);
            return String.format("\n-> Prisma Layang-Layang\ndiagonal1 = 5, d2 = 10, sisi pendek = 6, sisi panjang = 10 & tinggi = 10\nLuas Permukaan Prisma Layang-Layang : %.1f\nVolume Prisma Layang-Layang : %.1f", pll.hitungLuasPermukaan(), pll.hitungVolume());
        });

        // 18. Limas Segitiga
        tasks.add(() -> {
            LimasSegitiga ls = new LimasSegitiga(5, 4.33, 10);
            return String.format("\n-> Limas Segitiga\nalas segitiga = 5, tinggi alas = 4.33 & tinggi limas = 10\nLuas Permukaan Limas Segitiga : %.2f\nVolume Limas Segitiga : %.2f", ls.hitungLuasPermukaan(), ls.hitungVolume());
        });

        // 19. Prisma Segitiga
        tasks.add(() -> {
            PrismaSegitiga ps = new PrismaSegitiga(5, 10, 10);
            return String.format("\n-> Prisma Segitiga\nalas = 5 & tinggi alas = 10 & tinggi prisma = 10\nLuas Permukaan Prisma Segitiga : %.1f\nVolume Prisma Segitiga : %.1f", ps.hitungLuasPermukaan(), ps.hitungVolume());
        });

        // 20. Limas Jajar Genjang
        tasks.add(() -> {
            LimasJajarGenjang ljg = new LimasJajarGenjang(6, 10, 5, 5, 10);
            return String.format("\n-> Limas Jajar Genjang\nalas = 6 & tinggi alas = 10 & sisiA = 5 & sisiB = 5 & tinggi limas = 10\nLuas Permukaan Limas Jajar Genjang : %.2f\nVolume Limas Jajar Genjang : %.1f", ljg.hitungLuasPermukaan(), ljg.hitungVolume());
        });

        // 21. Prisma Jajar Genjang
        tasks.add(() -> {
            PrismaJajarGenjang pjg = new PrismaJajarGenjang(6, 10, 5, 5, 10);
            return String.format("\n-> Prisma Jajar Genjang\nalas = 6 & tinggi alas = 10 & sisiA = 5 & sisiB = 5 & tinggi prisma = 10\nLuas Permukaan Prisma Jajar Genjang : %.1f\nVolume Prisma Jajar Genjang : %.1f", pjg.hitungLuasPermukaan(), pjg.hitungVolume());
        });

        // 22. Limas Trapesium
        tasks.add(() -> {
            LimasTrapesium lt = new LimasTrapesium(5, 10, 6, 10, 15);
            return String.format("\n-> Limas Trapesium\nalas atas = 5, alas bawah = 10, sisi miring = 6, tinggi alas = 10 & tinggi limas = 15\nLuas Permukaan Limas Trapesium : %.2f\nVolume Limas Trapesium : %.1f", lt.hitungLuasPermukaan(), lt.hitungVolume());
        });

        // 23. Prisma Trapesium
        tasks.add(() -> {
            PrismaTrapesium pt = new PrismaTrapesium(5, 10, 6, 10, 15);
            return String.format("\n-> Prisma Trapesium\nalas atas = 5, alas bawah = 10, sisi miring = 6, tinggi alas = 10 & tinggi prisma = 15\nLuas Permukaan Prisma Trapesium : %.1f\nVolume Prisma Trapesium : %.1f", pt.hitungLuasPermukaan(), pt.hitungVolume());
        });

        // 24. Balok
        tasks.add(() -> {
            Balok b = new Balok(5, 10, 15);
            return String.format("\n-> Balok\npanjang = 5 & lebar = 10 & tinggi = 15\nLuas Permukaan Balok : %.1f\nVolume Balok : %.1f", b.hitungLuasPermukaan(), b.hitungVolume());
        });

        // 25. Limas Persegi Panjang
        tasks.add(() -> {
            LimasPersegiPanjang lpp = new LimasPersegiPanjang(5, 10, 15);
            return String.format("\n-> Limas Persegi Panjang\npanjang = 5 & lebar = 10 & tinggi = 15\nLuas Permukaan Limas Persegi Panjang : %.2f\nVolume Limas Persegi Panjang : %.1f", lpp.hitungLuasPermukaan(), lpp.hitungVolume());
        });

        // 26. Prisma Persegi Panjang
        tasks.add(() -> {
            PrismaPersegiPanjang ppp = new PrismaPersegiPanjang(5, 10, 15);
            return String.format("\n-> Prisma Persegi Panjang\npanjang = 5 & lebar = 10 & tinggi = 15\nLuas Permukaan Prisma Persegi Panjang : %.1f\nVolume Prisma Persegi Panjang : %.1f", ppp.hitungLuasPermukaan(), ppp.hitungVolume());
        });

        // 27. Bola
        tasks.add(() -> {
            Bola bola = new Bola(7);
            return String.format("\n-> Bola\njari-jari = 7\nLuas Permukaan Bola : %.2f\nVolume Bola : %.2f", bola.hitungLuasPermukaan(), bola.hitungVolume());
        });

        // 28. Cincin Bola
        tasks.add(() -> {
            CincinBola cb = new CincinBola(10, 5);
            return String.format("\n-> Cincin Bola\njari-jari bola = 10 & tinggi cincin = 5\nLuas Permukaan Cincin Bola : %.1f\nVolume Cincin Bola : %.2f", cb.hitungLuasPermukaan(), cb.hitungVolume());
        });

        // 29. Juring Bola
        tasks.add(() -> {
            JuringBola jb = new JuringBola(7, 90);
            return String.format("\n-> Juring Bola\njari-jari = 7 & sudut = 90 derajat\nLuas Permukaan Juring Bola : %.2f\nVolume Juring Bola : %.2f", jb.hitungLuasPermukaan(), jb.hitungVolume());
        });

        // 30. Tembereng Bola
        tasks.add(() -> {
            TemberengBola tb = new TemberengBola(7, 5);
            return String.format("\n-> Tembereng Bola\njari-jari bola = 7 & tinggi tembereng = 5\nLuas Permukaan Tembereng Bola : %.1f\nVolume Tembereng Bola : %.2f", tb.hitungLuasPermukaan(), tb.hitungVolume());
        });

        // 31. Kerucut
        tasks.add(() -> {
            Kerucut k = new Kerucut(7, 10);
            return String.format("\n-> Kerucut\njari-jari = 7 & tinggi = 10\nLuas Permukaan Kerucut : %.2f\nVolume Kerucut : %.2f", k.hitungLuasPermukaan(), k.hitungVolume());
        });

        // 32. Kerucut Terpancung
        tasks.add(() -> {
            KerucutTerpancung kt = new KerucutTerpancung(10, 5, 15);
            return String.format("\n-> Kerucut Terpancung\njari-jari bawah = 10, jari-jari atas = 5 & tinggi = 15\nLuas Permukaan Kerucut Terpancung : %.2f\nVolume Kerucut Terpancung : %.1f", kt.hitungLuasPermukaan(), kt.hitungVolume());
        });

        // 33. Tabung
        tasks.add(() -> {
            Tabung t = new Tabung(7, 10);
            return String.format("\n-> Tabung\njari-jari = 7 & tinggi = 10\nLuas Permukaan Tabung : %.2f\nVolume Tabung : %.1f", t.hitungLuasPermukaan(), t.hitungVolume());
        });

        // --- EKSEKUSI SEMUA TUGAS & TAMPILKAN HASIL SECARA BERURUTAN ---
        try {
            List<Future<String>> results = executor.invokeAll(tasks);
            executor.shutdown(); // Penting untuk mematikan executor

            resultArea.append("\n--- Hasil Perhitungan Keseluruhan ---\n");
            for (Future<String> result : results) {
                try {
                    resultArea.append(result.get() + "\n");
                } catch (InterruptedException | ExecutionException ex) {
                    resultArea.append("Error mengambil hasil: " + ex.getMessage() + "\n");
                    ex.printStackTrace();
                }
            }
            resultArea.append("\n=== Perhitungan Selesai ===\n");

        } catch (InterruptedException ex) {
            resultArea.append("Perhitungan dibatalkan: " + ex.getMessage() + "\n");
            Thread.currentThread().interrupt(); // Set the interrupt flag
        } catch (Exception ex) {
            resultArea.append("Terjadi kesalahan saat menjalankan tugas: " + ex.getMessage() + "\n");
            ex.printStackTrace();
        }
    }

    private void updateInputFields() {
        String selectedShape = (String) shapeComboBox.getSelectedItem();
        // Sembunyikan semua field terlebih dahulu
        param1Label.setVisible(false); param1Field.setVisible(false); param1Field.setText("");
        param2Label.setVisible(false); param2Field.setVisible(false); param2Field.setText("");
        param3Label.setVisible(false); param3Field.setVisible(false); param3Field.setText("");
        param4Label.setVisible(false); param4Field.setVisible(false); param4Field.setText("");
        param5Label.setVisible(false); param5Field.setVisible(false); param5Field.setText("");

        switch (selectedShape) {
            case "Segitiga":
                param1Label.setText("Alas:");
                param1Label.setVisible(true); param1Field.setVisible(true);
                param2Label.setText("Tinggi:");
                param2Label.setVisible(true); param2Field.setVisible(true);
                break;
            case "Persegi":
                param1Label.setText("Sisi:");
                param1Label.setVisible(true); param1Field.setVisible(true);
                break;
            case "Persegi Panjang":
                param1Label.setText("Panjang:");
                param1Label.setVisible(true); param1Field.setVisible(true);
                param2Label.setText("Lebar:");
                param2Label.setVisible(true); param2Field.setVisible(true);
                break;
            case "Jajar Genjang":
                param1Label.setText("Alas:");
                param1Label.setVisible(true); param1Field.setVisible(true);
                param2Label.setText("Tinggi:");
                param2Label.setVisible(true); param2Field.setVisible(true);
                param3Label.setText("Sisi A:");
                param3Label.setVisible(true); param3Field.setVisible(true);
                param4Label.setText("Sisi B:");
                param4Label.setVisible(true); param4Field.setVisible(true);
                break;
            case "Belah Ketupat":
                param1Label.setText("Diagonal 1:");
                param1Label.setVisible(true); param1Field.setVisible(true);
                param2Label.setText("Diagonal 2:");
                param2Label.setVisible(true); param2Field.setVisible(true);
                param3Label.setText("Sisi:");
                param3Label.setVisible(true); param3Field.setVisible(true);
                break;
            case "Layang-Layang":
                param1Label.setText("Diagonal 1:");
                param1Label.setVisible(true); param1Field.setVisible(true);
                param2Label.setText("Diagonal 2:");
                param2Label.setVisible(true); param2Field.setVisible(true);
                param3Label.setText("Sisi Pendek:");
                param3Label.setVisible(true); param3Field.setVisible(true);
                param4Label.setText("Sisi Panjang:");
                param4Label.setVisible(true); param4Field.setVisible(true);
                break;
            case "Trapesium":
                param1Label.setText("Alas Atas:");
                param1Label.setVisible(true); param1Field.setVisible(true);
                param2Label.setText("Alas Bawah:");
                param2Label.setVisible(true); param2Field.setVisible(true);
                param3Label.setText("Sisi Miring:");
                param3Label.setVisible(true); param3Field.setVisible(true);
                param4Label.setText("Tinggi:");
                param4Label.setVisible(true); param4Field.setVisible(true);
                break;
            case "Lingkaran":
                param1Label.setText("Jari-Jari:");
                param1Label.setVisible(true); param1Field.setVisible(true);
                break;
            case "Juring Lingkaran":
                param1Label.setText("Jari-Jari:");
                param1Label.setVisible(true); param1Field.setVisible(true);
                param2Label.setText("Sudut (derajat):");
                param2Label.setVisible(true); param2Field.setVisible(true);
                break;
            case "Tembereng Lingkaran":
                param1Label.setText("Jari-Jari:");
                param1Label.setVisible(true); param1Field.setVisible(true);
                param2Label.setText("Sudut (derajat):");
                param2Label.setVisible(true); param2Field.setVisible(true);
                break;
            // --- BENTUK 3D ---
            case "Kubus":
                param1Label.setText("Sisi:");
                param1Label.setVisible(true); param1Field.setVisible(true);
                break;
            case "Balok":
                param1Label.setText("Panjang:");
                param1Label.setVisible(true); param1Field.setVisible(true);
                param2Label.setText("Lebar:");
                param2Label.setVisible(true); param2Field.setVisible(true);
                param3Label.setText("Tinggi:");
                param3Label.setVisible(true); param3Field.setVisible(true);
                break;
            case "Kerucut":
                param1Label.setText("Jari-Jari:");
                param1Label.setVisible(true); param1Field.setVisible(true);
                param2Label.setText("Tinggi:");
                param2Label.setVisible(true); param2Field.setVisible(true);
                break;
            case "Tabung":
                param1Label.setText("Jari-Jari:");
                param1Label.setVisible(true); param1Field.setVisible(true);
                param2Label.setText("Tinggi:");
                param2Label.setVisible(true); param2Field.setVisible(true);
                break;
            case "Bola":
                param1Label.setText("Jari-Jari:");
                param1Label.setVisible(true); param1Field.setVisible(true);
                break;
            case "Cincin Bola":
                param1Label.setText("Jari-Jari Bola:");
                param1Label.setVisible(true); param1Field.setVisible(true);
                param2Label.setText("Tinggi Cincin:");
                param2Label.setVisible(true); param2Field.setVisible(true);
                break;
            case "Juring Bola":
                param1Label.setText("Jari-Jari Bola:");
                param1Label.setVisible(true); param1Field.setVisible(true);
                param2Label.setText("Sudut (derajat):");
                param2Label.setVisible(true); param2Field.setVisible(true);
                break;
            case "Tembereng Bola":
                param1Label.setText("Jari-Jari Bola:");
                param1Label.setVisible(true); param1Field.setVisible(true);
                param2Label.setText("Tinggi Tembereng:");
                param2Label.setVisible(true); param2Field.setVisible(true);
                break;
            case "Kerucut Terpancung":
                param1Label.setText("Jari-Jari Atas:");
                param1Label.setVisible(true); param1Field.setVisible(true);
                param2Label.setText("Jari-Jari Bawah:");
                param2Label.setVisible(true); param2Field.setVisible(true);
                param3Label.setText("Tinggi:");
                param3Label.setVisible(true); param3Field.setVisible(true);
                break;
            case "Limas Belah Ketupat":
            case "Prisma Belah Ketupat":
                param1Label.setText("Diagonal 1:");
                param1Label.setVisible(true); param1Field.setVisible(true);
                param2Label.setText("Diagonal 2:");
                param2Label.setVisible(true); param2Field.setVisible(true);
                param3Label.setText("Sisi:");
                param3Label.setVisible(true); param3Field.setVisible(true);
                if (selectedShape.startsWith("Limas")) {
                    param4Label.setText("Tinggi Limas:");
                } else {
                    param4Label.setText("Tinggi Prisma:");
                }
                param4Label.setVisible(true); param4Field.setVisible(true);
                break;
            case "Limas Jajar Genjang":
            case "Prisma Jajar Genjang":
                param1Label.setText("Alas:");
                param1Label.setVisible(true); param1Field.setVisible(true);
                param2Label.setText("Tinggi Alas:");
                param2Label.setVisible(true); param2Field.setVisible(true);
                param3Label.setText("Sisi A:");
                param3Label.setVisible(true); param3Field.setVisible(true);
                param4Label.setText("Sisi B:");
                param4Label.setVisible(true); param4Field.setVisible(true);
                 if (selectedShape.startsWith("Limas")) {
                    param5Label.setText("Tinggi Limas:");
                } else {
                    param5Label.setText("Tinggi Prisma:");
                }
                param5Label.setVisible(true); param5Field.setVisible(true);
                break;
            case "Limas Layang-Layang":
            case "Prisma Layang-Layang":
                param1Label.setText("Diagonal 1:");
                param1Label.setVisible(true); param1Field.setVisible(true);
                param2Label.setText("Diagonal 2:");
                param2Label.setVisible(true); param2Field.setVisible(true);
                param3Label.setText("Sisi Pendek:");
                param3Label.setVisible(true); param3Field.setVisible(true);
                param4Label.setText("Sisi Panjang:");
                param4Label.setVisible(true); param4Field.setVisible(true);
                if (selectedShape.startsWith("Limas")) {
                    param5Label.setText("Tinggi Limas:");
                } else {
                    param5Label.setText("Tinggi Prisma:");
                }
                param5Label.setVisible(true); param5Field.setVisible(true);
                break;
            case "Limas Persegi":
            case "Prisma Persegi":
                param1Label.setText("Sisi Alas:");
                param1Label.setVisible(true); param1Field.setVisible(true);
                if (selectedShape.startsWith("Limas")) {
                    param2Label.setText("Tinggi Limas:");
                } else {
                    param2Label.setText("Tinggi Prisma:");
                }
                param2Label.setVisible(true); param2Field.setVisible(true);
                break;
            case "Limas Persegi Panjang":
            case "Prisma Persegi Panjang":
                param1Label.setText("Panjang Alas:");
                param1Label.setVisible(true); param1Field.setVisible(true);
                param2Label.setText("Lebar Alas:");
                param2Label.setVisible(true); param2Field.setVisible(true);
                if (selectedShape.startsWith("Limas")) {
                    param3Label.setText("Tinggi Limas:");
                } else {
                    param3Label.setText("Tinggi Prisma:");
                }
                param3Label.setVisible(true); param3Field.setVisible(true);
                break;
            case "Limas Segitiga":
            case "Prisma Segitiga":
                param1Label.setText("Alas Segitiga:");
                param1Label.setVisible(true); param1Field.setVisible(true);
                param2Label.setText("Tinggi Alas:");
                param2Label.setVisible(true); param2Field.setVisible(true);
                if (selectedShape.startsWith("Limas")) {
                    param3Label.setText("Tinggi Limas:");
                } else {
                    param3Label.setText("Tinggi Prisma:");
                }
                param3Label.setVisible(true); param3Field.setVisible(true);
                break;
            case "Limas Trapesium":
            case "Prisma Trapesium":
                param1Label.setText("Alas Atas:");
                param1Label.setVisible(true); param1Field.setVisible(true);
                param2Label.setText("Alas Bawah:");
                param2Label.setVisible(true); param2Field.setVisible(true);
                param3Label.setText("Sisi Miring:");
                param3Label.setVisible(true); param3Field.setVisible(true);
                param4Label.setText("Tinggi Alas:");
                param4Label.setVisible(true); param4Field.setVisible(true);
                if (selectedShape.startsWith("Limas")) {
                    param5Label.setText("Tinggi Limas:");
                } else {
                    param5Label.setText("Tinggi Prisma:");
                }
                param5Label.setVisible(true); param5Field.setVisible(true);
                break;
        }
        revalidate();
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == shapeComboBox) {
            updateInputFields();
        } else if (e.getSource() == calculateButton) {
            calculateShape();
        } else if (e.getSource() == calculateAllButton) { // Tangani klik tombol baru
            calculateAllShapesMultithreaded();
        }
    }

    private void calculateShape() {
        String selectedShape = (String) shapeComboBox.getSelectedItem();
        resultArea.setText(""); // Bersihkan area hasil

        try {
            switch (selectedShape) {
                case "Segitiga":
                    double alas = Double.parseDouble(param1Field.getText());
                    double tinggi = Double.parseDouble(param2Field.getText());
                    Segitiga segitiga = new Segitiga(alas, tinggi);
                    resultArea.append(String.format("Luas Segitiga: %.2f\n", segitiga.hitungLuas()));
                    resultArea.append(String.format("Keliling Segitiga: %.2f\n", segitiga.hitungKeliling()));
                    break;
                case "Persegi":
                    double sisiPersegi = Double.parseDouble(param1Field.getText());
                    Persegi persegi = new Persegi(sisiPersegi);
                    resultArea.append(String.format("Luas Persegi: %.2f\n", persegi.hitungLuas()));
                    resultArea.append(String.format("Keliling Persegi: %.2f\n", persegi.hitungKeliling()));
                    break;
                case "Persegi Panjang":
                    double panjangPP = Double.parseDouble(param1Field.getText());
                    double lebarPP = Double.parseDouble(param2Field.getText());
                    PersegiPanjang persegiPanjang = new PersegiPanjang(panjangPP, lebarPP);
                    resultArea.append(String.format("Luas Persegi Panjang: %.2f\n", persegiPanjang.hitungLuas()));
                    resultArea.append(String.format("Keliling Persegi Panjang: %.2f\n", persegiPanjang.hitungKeliling()));
                    break;
                case "Jajar Genjang":
                    double alasJG = Double.parseDouble(param1Field.getText());
                    double tinggiJG = Double.parseDouble(param2Field.getText());
                    double sisiAJG = Double.parseDouble(param3Field.getText());
                    double sisiBJG = Double.parseDouble(param4Field.getText());
                    JajarGenjang jajarGenjang = new JajarGenjang(alasJG, tinggiJG, sisiAJG, sisiBJG);
                    resultArea.append(String.format("Luas Jajar Genjang: %.2f\n", jajarGenjang.hitungLuas()));
                    resultArea.append(String.format("Keliling Jajar Genjang: %.2f\n", jajarGenjang.hitungKeliling()));
                    break;
                case "Belah Ketupat":
                    double d1BK = Double.parseDouble(param1Field.getText());
                    double d2BK = Double.parseDouble(param2Field.getText());
                    double sisiBK = Double.parseDouble(param3Field.getText());
                    BelahKetupat belahKetupat = new BelahKetupat(d1BK, d2BK, sisiBK);
                    resultArea.append(String.format("Luas Belah Ketupat: %.2f\n", belahKetupat.hitungLuas()));
                    resultArea.append(String.format("Keliling Belah Ketupat: %.2f\n", belahKetupat.hitungKeliling()));
                    break;
                case "Layang-Layang":
                    double d1LL = Double.parseDouble(param1Field.getText());
                    double d2LL = Double.parseDouble(param2Field.getText());
                    double sisiPendekLL = Double.parseDouble(param3Field.getText());
                    double sisiPanjangLL = Double.parseDouble(param4Field.getText());
                    LayangLayang layangLayang = new LayangLayang(d1LL, d2LL, sisiPendekLL, sisiPanjangLL);
                    resultArea.append(String.format("Luas Layang-Layang: %.2f\n", layangLayang.hitungLuas()));
                    resultArea.append(String.format("Keliling Layang-Layang: %.2f\n", layangLayang.hitungKeliling()));
                    break;
                case "Trapesium":
                    double alasAtasT = Double.parseDouble(param1Field.getText());
                    double alasBawahT = Double.parseDouble(param2Field.getText());
                    double sisiMiringT = Double.parseDouble(param3Field.getText());
                    double tinggiT = Double.parseDouble(param4Field.getText());
                    Trapesium trapesium = new Trapesium(alasAtasT, alasBawahT, sisiMiringT, tinggiT);
                    resultArea.append(String.format("Luas Trapesium: %.2f\n", trapesium.hitungLuas()));
                    resultArea.append(String.format("Keliling Trapesium: %.2f\n", trapesium.hitungKeliling()));
                    break;
                case "Lingkaran":
                    double jariJariL = Double.parseDouble(param1Field.getText());
                    Lingkaran lingkaran = new Lingkaran(jariJariL);
                    resultArea.append(String.format("Luas Lingkaran: %.2f\n", lingkaran.hitungLuas()));
                    resultArea.append(String.format("Keliling Lingkaran: %.2f\n", lingkaran.hitungKeliling()));
                    break;
                case "Juring Lingkaran":
                    double jariJariJL = Double.parseDouble(param1Field.getText());
                    double sudutJL = Double.parseDouble(param2Field.getText());
                    JuringLingkaran juringLingkaran = new JuringLingkaran(jariJariJL, sudutJL);
                    resultArea.append(String.format("Luas Juring Lingkaran: %.2f\n", juringLingkaran.hitungLuas()));
                    resultArea.append(String.format("Keliling Juring Lingkaran: %.2f\n", juringLingkaran.hitungKeliling()));
                    break;
                case "Tembereng Lingkaran":
                    double jariJariTL = Double.parseDouble(param1Field.getText());
                    double sudutTL = Double.parseDouble(param2Field.getText());
                    TemberengLingkaran temberengLingkaran = new TemberengLingkaran(jariJariTL, sudutTL);
                    resultArea.append(String.format("Luas Tembereng Lingkaran: %.2f\n", temberengLingkaran.hitungLuas()));
                    resultArea.append(String.format("Keliling Tembereng Lingkaran: %.2f\n", temberengLingkaran.hitungKeliling()));
                    break;
                // --- BENTUK 3D ---
                case "Kubus":
                    double sisiKubus = Double.parseDouble(param1Field.getText());
                    Kubus kubus = new Kubus(sisiKubus);
                    resultArea.append(String.format("Volume Kubus: %.2f\n", kubus.hitungVolume()));
                    resultArea.append(String.format("Luas Permukaan Kubus: %.2f\n", kubus.hitungLuasPermukaan()));
                    break;
                case "Balok":
                    double panjangB = Double.parseDouble(param1Field.getText());
                    double lebarB = Double.parseDouble(param2Field.getText());
                    double tinggiB = Double.parseDouble(param3Field.getText());
                    Balok balok = new Balok(panjangB, lebarB, tinggiB);
                    resultArea.append(String.format("Volume Balok: %.2f\n", balok.hitungVolume()));
                    resultArea.append(String.format("Luas Permukaan Balok: %.2f\n", balok.hitungLuasPermukaan()));
                    break;
                case "Kerucut":
                    double jariJariK = Double.parseDouble(param1Field.getText());
                    double tinggiK = Double.parseDouble(param2Field.getText());
                    Kerucut kerucut = new Kerucut(jariJariK, tinggiK);
                    resultArea.append(String.format("Volume Kerucut: %.2f\n", kerucut.hitungVolume()));
                    resultArea.append(String.format("Luas Permukaan Kerucut: %.2f\n", kerucut.hitungLuasPermukaan()));
                    break;
                case "Tabung":
                    double jariJariTabung = Double.parseDouble(param1Field.getText());
                    double tinggiTabung = Double.parseDouble(param2Field.getText());
                    Tabung tabung = new Tabung(jariJariTabung, tinggiTabung);
                    resultArea.append(String.format("Volume Tabung: %.2f\n", tabung.hitungVolume()));
                    resultArea.append(String.format("Luas Permukaan Tabung: %.2f\n", tabung.hitungLuasPermukaan()));
                    break;
                case "Bola":
                    double jariJariBola = Double.parseDouble(param1Field.getText());
                    Bola bola = new Bola(jariJariBola);
                    resultArea.append(String.format("Volume Bola: %.2f\n", bola.hitungVolume()));
                    resultArea.append(String.format("Luas Permukaan Bola: %.2f\n", bola.hitungLuasPermukaan()));
                    break;
                case "Cincin Bola":
                    double jariJariCincin = Double.parseDouble(param1Field.getText());
                    double tinggiCincin = Double.parseDouble(param2Field.getText());
                    CincinBola cincinBola = new CincinBola(jariJariCincin, tinggiCincin);
                    resultArea.append(String.format("Volume Cincin Bola: %.2f\n", cincinBola.hitungVolume()));
                    resultArea.append(String.format("Luas Permukaan Cincin Bola: %.2f\n", cincinBola.hitungLuasPermukaan()));
                    break;
                case "Juring Bola":
                    double jariJariJB = Double.parseDouble(param1Field.getText());
                    double sudutJB = Double.parseDouble(param2Field.getText());
                    JuringBola juringBola = new JuringBola(jariJariJB, sudutJB);
                    resultArea.append(String.format("Volume Juring Bola: %.2f\n", juringBola.hitungVolume()));
                    resultArea.append(String.format("Luas Permukaan Juring Bola: %.2f\n", juringBola.hitungLuasPermukaan()));
                    break;
                case "Tembereng Bola":
                    double jariJariTB = Double.parseDouble(param1Field.getText());
                    double tinggiTB = Double.parseDouble(param2Field.getText());
                    TemberengBola temberengBola = new TemberengBola(jariJariTB, tinggiTB);
                    resultArea.append(String.format("Volume Tembereng Bola: %.2f\n", temberengBola.hitungVolume()));
                    resultArea.append(String.format("Luas Permukaan Tembereng Bola: %.2f\n", temberengBola.hitungLuasPermukaan()));
                    break;
                case "Kerucut Terpancung":
                    double jariAtasKT = Double.parseDouble(param1Field.getText());
                    double jariBawahKT = Double.parseDouble(param2Field.getText());
                    double tinggiKT = Double.parseDouble(param3Field.getText());
                    KerucutTerpancung kerucutTerpancung = new KerucutTerpancung(jariAtasKT, jariBawahKT, tinggiKT);
                    resultArea.append(String.format("Volume Kerucut Terpancung: %.2f\n", kerucutTerpancung.hitungVolume()));
                    resultArea.append(String.format("Luas Permukaan Kerucut Terpancung: %.2f\n", kerucutTerpancung.hitungLuasPermukaan()));
                    break;
                case "Limas Belah Ketupat":
                    double d1LBK = Double.parseDouble(param1Field.getText());
                    double d2LBK = Double.parseDouble(param2Field.getText());
                    double sisiLBK = Double.parseDouble(param3Field.getText());
                    double tinggiLBK = Double.parseDouble(param4Field.getText());
                    LimasBelahKetupat limasBelahKetupat = new LimasBelahKetupat(d1LBK, d2LBK, sisiLBK, tinggiLBK);
                    resultArea.append(String.format("Volume Limas Belah Ketupat: %.2f\n", limasBelahKetupat.hitungVolume()));
                    resultArea.append(String.format("Luas Permukaan Limas Belah Ketupat: %.2f\n", limasBelahKetupat.hitungLuasPermukaan()));
                    break;
                case "Prisma Belah Ketupat":
                    double d1PBK = Double.parseDouble(param1Field.getText());
                    double d2PBK = Double.parseDouble(param2Field.getText());
                    double sisiPBK = Double.parseDouble(param3Field.getText());
                    double tinggiPBK = Double.parseDouble(param4Field.getText());
                    PrismaBelahKetupat prismaBelahKetupat = new PrismaBelahKetupat(d1PBK, d2PBK, sisiPBK, tinggiPBK);
                    resultArea.append(String.format("Volume Prisma Belah Ketupat: %.2f\n", prismaBelahKetupat.hitungVolume()));
                    resultArea.append(String.format("Luas Permukaan Prisma Belah Ketupat: %.2f\n", prismaBelahKetupat.hitungLuasPermukaan()));
                    break;
                case "Limas Jajar Genjang":
                    double alasLJG = Double.parseDouble(param1Field.getText());
                    double tinggiAlasLJG = Double.parseDouble(param2Field.getText());
                    double sisiALJG = Double.parseDouble(param3Field.getText());
                    double sisiBLJG = Double.parseDouble(param4Field.getText());
                    double tinggiLimasLJG = Double.parseDouble(param5Field.getText());
                    LimasJajarGenjang limasJajarGenjang = new LimasJajarGenjang(alasLJG, tinggiAlasLJG, sisiALJG, sisiBLJG, tinggiLimasLJG);
                    resultArea.append(String.format("Volume Limas Jajar Genjang: %.2f\n", limasJajarGenjang.hitungVolume()));
                    resultArea.append(String.format("Luas Permukaan Limas Jajar Genjang: %.2f\n", limasJajarGenjang.hitungLuasPermukaan()));
                    break;
                case "Prisma Jajar Genjang":
                    double alasPJG = Double.parseDouble(param1Field.getText());
                    double tinggiAlasPJG = Double.parseDouble(param2Field.getText());
                    double sisiAPJG = Double.parseDouble(param3Field.getText());
                    double sisiBPJG = Double.parseDouble(param4Field.getText());
                    double tinggiPrismaPJG = Double.parseDouble(param5Field.getText());
                    PrismaJajarGenjang prismaJajarGenjang = new PrismaJajarGenjang(alasPJG, tinggiAlasPJG, sisiAPJG, sisiBPJG, tinggiPrismaPJG);
                    resultArea.append(String.format("Volume Prisma Jajar Genjang: %.2f\n", prismaJajarGenjang.hitungVolume()));
                    resultArea.append(String.format("Luas Permukaan Prisma Jajar Genjang: %.2f\n", prismaJajarGenjang.hitungLuasPermukaan()));
                    break;
                case "Limas Layang-Layang":
                    double d1LLL = Double.parseDouble(param1Field.getText());
                    double d2LLL = Double.parseDouble(param2Field.getText());
                    double sisiPendekLLL = Double.parseDouble(param3Field.getText());
                    double sisiPanjangLLL = Double.parseDouble(param4Field.getText());
                    double tinggiLLL = Double.parseDouble(param5Field.getText());
                    LimasLayangLayang limasLayangLayang = new LimasLayangLayang(d1LLL, d2LLL, sisiPendekLLL, sisiPanjangLLL, tinggiLLL);
                    resultArea.append(String.format("Volume Limas Layang-Layang: %.2f\n", limasLayangLayang.hitungVolume()));
                    resultArea.append(String.format("Luas Permukaan Limas Layang-Layang: %.2f\n", limasLayangLayang.hitungLuasPermukaan()));
                    break;
                case "Prisma Layang-Layang":
                    double d1PLL = Double.parseDouble(param1Field.getText());
                    double d2PLL = Double.parseDouble(param2Field.getText());
                    double sisiPendekPLL = Double.parseDouble(param3Field.getText());
                    double sisiPanjangPLL = Double.parseDouble(param4Field.getText());
                    double tinggiPLL = Double.parseDouble(param5Field.getText());
                    PrismaLayangLayang prismaLayangLayang = new PrismaLayangLayang(d1PLL, d2PLL, sisiPendekPLL, sisiPanjangPLL, tinggiPLL);
                    resultArea.append(String.format("Volume Prisma Layang-Layang: %.2f\n", prismaLayangLayang.hitungVolume()));
                    resultArea.append(String.format("Luas Permukaan Prisma Layang-Layang: %.2f\n", prismaLayangLayang.hitungLuasPermukaan()));
                    break;
                case "Limas Persegi":
                    double sisiLP = Double.parseDouble(param1Field.getText());
                    double tinggiLP = Double.parseDouble(param2Field.getText());
                    LimasPersegi limasPersegi = new LimasPersegi(sisiLP, tinggiLP);
                    resultArea.append(String.format("Volume Limas Persegi: %.2f\n", limasPersegi.hitungVolume()));
                    resultArea.append(String.format("Luas Permukaan Limas Persegi: %.2f\n", limasPersegi.hitungLuasPermukaan()));
                    break;
                case "Prisma Persegi":
                    double sisiPP = Double.parseDouble(param1Field.getText());
                    double tinggiPP = Double.parseDouble(param2Field.getText());
                    PrismaPersegi prismaPersegi = new PrismaPersegi(sisiPP, tinggiPP);
                    resultArea.append(String.format("Volume Prisma Persegi: %.2f\n", prismaPersegi.hitungVolume()));
                    resultArea.append(String.format("Luas Permukaan Prisma Persegi: %.2f\n", prismaPersegi.hitungLuasPermukaan()));
                    break;
                case "Limas Persegi Panjang":
                    double panjangLPP = Double.parseDouble(param1Field.getText());
                    double lebarLPP = Double.parseDouble(param2Field.getText());
                    double tinggiLimasLPP = Double.parseDouble(param3Field.getText());
                    LimasPersegiPanjang limasPersegiPanjang = new LimasPersegiPanjang(panjangLPP, lebarLPP, tinggiLimasLPP);
                    resultArea.append(String.format("Volume Limas Persegi Panjang: %.2f\n", limasPersegiPanjang.hitungVolume()));
                    resultArea.append(String.format("Luas Permukaan Limas Persegi Panjang: %.2f\n", limasPersegiPanjang.hitungLuasPermukaan()));
                    break;
                case "Prisma Persegi Panjang":
                    double panjangPPP = Double.parseDouble(param1Field.getText());
                    double lebarPPP = Double.parseDouble(param2Field.getText());
                    double tinggiPrismaPPP = Double.parseDouble(param3Field.getText());
                    PrismaPersegiPanjang prismaPersegiPanjang = new PrismaPersegiPanjang(panjangPPP, lebarPPP, tinggiPrismaPPP);
                    resultArea.append(String.format("Volume Prisma Persegi Panjang: %.2f\n", prismaPersegiPanjang.hitungVolume()));
                    resultArea.append(String.format("Luas Permukaan Prisma Persegi Panjang: %.2f\n", prismaPersegiPanjang.hitungLuasPermukaan()));
                    break;
                case "Limas Segitiga":
                    double alasLS = Double.parseDouble(param1Field.getText());
                    double tinggiAlasLS = Double.parseDouble(param2Field.getText());
                    double tinggiLimasLS = Double.parseDouble(param3Field.getText());
                    LimasSegitiga limasSegitiga = new LimasSegitiga(alasLS, tinggiAlasLS, tinggiLimasLS);
                    resultArea.append(String.format("Volume Limas Segitiga: %.2f\n", limasSegitiga.hitungVolume()));
                    resultArea.append(String.format("Luas Permukaan Limas Segitiga: %.2f\n", limasSegitiga.hitungLuasPermukaan()));
                    break;
                case "Prisma Segitiga":
                    double alasPS = Double.parseDouble(param1Field.getText());
                    double tinggiAlasPS = Double.parseDouble(param2Field.getText());
                    double tinggiPrismaPS = Double.parseDouble(param3Field.getText());
                    PrismaSegitiga prismaSegitiga = new PrismaSegitiga(alasPS, tinggiAlasPS, tinggiPrismaPS);
                    resultArea.append(String.format("Volume Prisma Segitiga: %.2f\n", prismaSegitiga.hitungVolume()));
                    resultArea.append(String.format("Luas Permukaan Prisma Segitiga: %.2f\n", prismaSegitiga.hitungLuasPermukaan()));
                    break;
                case "Limas Trapesium":
                    double alasAtasLT = Double.parseDouble(param1Field.getText());
                    double alasBawahLT = Double.parseDouble(param2Field.getText());
                    double sisiMiringLT = Double.parseDouble(param3Field.getText());
                    double tinggiAlasLT = Double.parseDouble(param4Field.getText());
                    double tinggiLimasLT = Double.parseDouble(param5Field.getText());
                    LimasTrapesium limasTrapesium = new LimasTrapesium(alasAtasLT, alasBawahLT, sisiMiringLT, tinggiAlasLT, tinggiLimasLT);
                    resultArea.append(String.format("Volume Limas Trapesium: %.2f\n", limasTrapesium.hitungVolume()));
                    resultArea.append(String.format("Luas Permukaan Limas Trapesium: %.2f\n", limasTrapesium.hitungLuasPermukaan()));
                    break;
                case "Prisma Trapesium":
                    double alasAtasPT = Double.parseDouble(param1Field.getText());
                    double alasBawahPT = Double.parseDouble(param2Field.getText());
                    double sisiMiringPT = Double.parseDouble(param3Field.getText());
                    double tinggiAlasPT = Double.parseDouble(param4Field.getText());
                    double tinggiPrismaPT = Double.parseDouble(param5Field.getText());
                    PrismaTrapesium prismaTrapesium = new PrismaTrapesium(alasAtasPT, alasBawahPT, sisiMiringPT, tinggiAlasPT, tinggiPrismaPT);
                    resultArea.append(String.format("Volume Prisma Trapesium: %.2f\n", prismaTrapesium.hitungVolume()));
                    resultArea.append(String.format("Luas Permukaan Prisma Trapesium: %.2f\n", prismaTrapesium.hitungLuasPermukaan()));
                    break;
                default:
                    resultArea.append("Perhitungan untuk bentuk ini belum diimplementasikan.\n");
                    break;
            }
        } catch (NumberFormatException ex) {
            resultArea.setText("Input tidak valid. Harap masukkan angka untuk parameter.");
        } catch (InputMismatchException ex) {
            resultArea.setText("Input tidak valid. Harap masukkan angka yang sesuai.");
        } catch (Exception ex) {
            resultArea.setText("Terjadi kesalahan: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new GeometryCalculatorGUI().setVisible(true);
        });
    }
}