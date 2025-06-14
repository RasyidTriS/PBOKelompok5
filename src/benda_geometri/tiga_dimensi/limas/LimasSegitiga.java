package benda_geometri.tiga_dimensi.limas;

import benda_geometri.BentukTigaDimensi;
import benda_geometri.dua_dimensi.Segitiga;

// 1. Deklarasi diubah untuk mewarisi langsung dari Segitiga
public class LimasSegitiga extends Segitiga implements BentukTigaDimensi {
    
    // 2. Atribut 'alas' tidak diperlukan lagi, hanya butuh atribut unik 'tinggiLimas'
    private double tinggiLimas;

    public LimasSegitiga(double alasSegitiga, double tinggiAlas, double tinggiLimas) {
        // 3. Memanggil constructor dari kelas induk (Segitiga)
        super(alasSegitiga, tinggiAlas);
        this.tinggiLimas = tinggiLimas;
    }

    @Override
    public double hitungVolume() {
        // 4. Menggunakan hitungLuas() yang diwarisi dari Segitiga
        return (1.0 / 3.0) * super.hitungLuas() * this.tinggiLimas;
    }

    @Override
    public double hitungLuasPermukaan() {
        // 4. Menggunakan kembali metode dan properti dari kelas induk
        double luasAlas = super.hitungLuas();
        // Menggunakan getAlas() dari induk sebagai panjang sisi (asumsi sama sisi)
        double sisiAlas = super.getAlas(); 

        // Perhitungan ini mengasumsikan limas tegak dengan alas segitiga sama sisi
        double apotemaAlas = (sisiAlas * Math.sqrt(3)) / 6.0;
        double tinggiSegitigaTegak = Math.sqrt(Math.pow(this.tinggiLimas, 2) + Math.pow(apotemaAlas, 2));
        
        double luasSeluruhSisiTegak = 3 * (0.5 * sisiAlas * tinggiSegitigaTegak);

        return luasAlas + luasSeluruhSisiTegak;
    }

    // Getter dan Setter untuk properti unik kelas ini
    public double getTinggiLimas() {
        return tinggiLimas;
    }

    public void setTinggiLimas(double tinggiLimas) {
        this.tinggiLimas = tinggiLimas;
    }
}