package benda_geometri.tiga_dimensi.prisma;

import benda_geometri.BentukTigaDimensi;
import benda_geometri.dua_dimensi.JajarGenjang;

// 1. Deklarasi diubah untuk mewarisi langsung dari JajarGenjang
public class PrismaJajarGenjang extends JajarGenjang implements BentukTigaDimensi {

    // 2. Atribut 'alas' tidak diperlukan lagi, hanya butuh 'tinggiPrisma'
    private double tinggiPrisma;

    public PrismaJajarGenjang(double alasJajarGenjang, double tinggiAlas, double sisiA, double sisiB, double tinggiPrisma) {
        // 3. Memanggil constructor dari kelas induk (JajarGenjang)
        super(alasJajarGenjang, tinggiAlas, sisiA, sisiB);
        this.tinggiPrisma = tinggiPrisma;
    }

    @Override
    public double hitungVolume() {
        // 4. Menggunakan hitungLuas() yang diwarisi dari JajarGenjang
        return super.hitungLuas() * this.tinggiPrisma;
    }

    @Override
    public double hitungLuasPermukaan() {
        // 4. Menggunakan kembali metode dari kelas induk
        double luasAlas = super.hitungLuas();
        double kelilingAlas = super.hitungKeliling();
        return (2 * luasAlas) + (kelilingAlas * this.tinggiPrisma);
    }
    
    // Getter dan Setter untuk properti unik kelas ini
    public double getTinggiPrisma() {
        return tinggiPrisma;
    }

    public void setTinggiPrisma(double tinggiPrisma) {
        this.tinggiPrisma = tinggiPrisma;
    }
}