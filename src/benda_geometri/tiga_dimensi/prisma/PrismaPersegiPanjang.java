package benda_geometri.tiga_dimensi.prisma;

import benda_geometri.BentukTigaDimensi;
import benda_geometri.dua_dimensi.PersegiPanjang;

// 1. Deklarasi diubah untuk mewarisi langsung dari PersegiPanjang
public class PrismaPersegiPanjang extends PersegiPanjang implements BentukTigaDimensi {

    // 2. Atribut 'alas' tidak diperlukan lagi, hanya butuh atribut unik 'tinggi'
    private double tinggi;

    public PrismaPersegiPanjang(double panjangAlas, double lebarAlas, double tinggi) {
        // 3. Memanggil constructor dari kelas induk (PersegiPanjang)
        super(panjangAlas, lebarAlas);
        this.tinggi = tinggi;
    }

    @Override
    public double hitungVolume() {
        // 4. Menggunakan hitungLuas() yang diwarisi dari PersegiPanjang
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