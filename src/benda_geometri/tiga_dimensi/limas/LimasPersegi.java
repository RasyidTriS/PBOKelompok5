package benda_geometri.tiga_dimensi.limas;

import benda_geometri.BentukTigaDimensi;
import benda_geometri.dua_dimensi.Persegi;

// 1. Deklarasi diubah untuk mewarisi langsung dari Persegi
public class LimasPersegi extends Persegi implements BentukTigaDimensi {

    // 2. Atribut 'alas' tidak diperlukan lagi, hanya butuh atribut unik 'tinggi'
    private double tinggi;

    public LimasPersegi(double sisiAlas, double tinggi) {
        // 3. Memanggil constructor dari kelas induk (Persegi)
        super(sisiAlas);
        this.tinggi = tinggi;
    }

    @Override
    public double hitungVolume() {
        // 4. Menggunakan hitungLuas() yang diwarisi dari Persegi
        return (1.0 / 3.0) * super.hitungLuas() * this.tinggi;
    }

    @Override
    public double hitungLuasPermukaan() {
        // 4. Menggunakan kembali metode dan properti dari kelas induk
        double luasAlas = super.hitungLuas();
        double sisiAlas = super.getSisi();
        
        // Menghitung tinggi segitiga pada sisi tegak
        double tinggiSegitigaTegak = Math.sqrt(Math.pow(sisiAlas / 2, 2) + Math.pow(this.tinggi, 2));
        double luasSisiTegak = 4 * (0.5 * sisiAlas * tinggiSegitigaTegak);

        return luasAlas + luasSisiTegak;
    }

    // Getter dan Setter untuk properti unik kelas ini
    public double getTinggi() {
        return tinggi;
    }

    public void setTinggi(double tinggi) {
        this.tinggi = tinggi;
    }
}