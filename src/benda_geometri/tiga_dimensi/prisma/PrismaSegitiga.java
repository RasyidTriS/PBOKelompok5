package benda_geometri.tiga_dimensi.prisma;

import benda_geometri.BentukTigaDimensi;
import benda_geometri.dua_dimensi.Segitiga;

// 1. Deklarasi diubah untuk mewarisi langsung dari Segitiga
public class PrismaSegitiga extends Segitiga implements BentukTigaDimensi {

    // 2. Atribut 'alas' tidak diperlukan lagi, hanya butuh 'tinggiPrisma'
    private double tinggiPrisma;

    public PrismaSegitiga(double alasSegitiga, double tinggiAlas, double tinggiPrisma) {
        // 3. Memanggil constructor dari kelas induk (Segitiga)
        super(alasSegitiga, tinggiAlas);
        this.tinggiPrisma = tinggiPrisma;
    }

    @Override
    public double hitungVolume() {
        // 4. Menggunakan hitungLuas() yang diwarisi dari Segitiga
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