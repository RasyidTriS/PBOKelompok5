package benda_geometri.tiga_dimensi.prisma;

import benda_geometri.BentukTigaDimensi;
import benda_geometri.dua_dimensi.Trapesium;

// 1. Deklarasi diubah untuk mewarisi langsung dari Trapesium
public class PrismaTrapesium extends Trapesium implements BentukTigaDimensi {

    // 2. Atribut 'alas' tidak diperlukan lagi, hanya butuh 'tinggiPrisma'
    private double tinggiPrisma;

    public PrismaTrapesium(double alasAtas, double alasBawah, double sisiMiring, double tinggiAlas, double tinggiPrisma) {
        // 3. Memanggil constructor dari kelas induk (Trapesium)
        super(alasAtas, alasBawah, sisiMiring, tinggiAlas);
        this.tinggiPrisma = tinggiPrisma;
    }

    @Override
    public double hitungVolume() {
        // 4. Menggunakan hitungLuas() yang diwarisi dari Trapesium
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