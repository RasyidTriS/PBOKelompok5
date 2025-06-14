package benda_geometri.tiga_dimensi.prisma;

import benda_geometri.BentukTigaDimensi;
import benda_geometri.dua_dimensi.BelahKetupat;

// 1. Deklarasi diubah untuk mewarisi langsung dari BelahKetupat
public class PrismaBelahKetupat extends BelahKetupat implements BentukTigaDimensi {

    // 2. Atribut 'alas' tidak diperlukan lagi, hanya butuh 'tinggi'
    private double tinggi;

    public PrismaBelahKetupat(double diagonal1, double diagonal2, double sisi, double tinggi) {
        // 3. Memanggil constructor dari kelas induk (BelahKetupat)
        super(diagonal1, diagonal2, sisi);
        this.tinggi = tinggi;
    }

    @Override
    public double hitungVolume() {
        // 4. Menggunakan hitungLuas() yang diwarisi dari BelahKetupat
        return super.hitungLuas() * this.tinggi;
    }

    @Override
    public double hitungLuasPermukaan() {
        // 4. Menggunakan kembali metode dari kelas induk
        double luasAlas = super.hitungLuas();
        double kelilingAlas = super.hitungKeliling();
        return (2 * luasAlas) + (kelilingAlas * this.tinggi);
    }
    
    // Getter dan Setter untuk properti unik kelas ini
    public double getTinggi() {
        return tinggi;
    }

    public void setTinggi(double tinggi) {
        this.tinggi = tinggi;
    }
}