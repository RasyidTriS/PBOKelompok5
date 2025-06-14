package benda_geometri.tiga_dimensi.limas;

import benda_geometri.BentukTigaDimensi;
import benda_geometri.dua_dimensi.JajarGenjang;

// 1. Deklarasi diubah untuk mewarisi langsung dari JajarGenjang
public class LimasJajarGenjang extends JajarGenjang implements BentukTigaDimensi {

    // 2. Atribut 'alas' tidak diperlukan lagi, hanya butuh atribut unik 'tinggiLimas'
    private double tinggiLimas;

    public LimasJajarGenjang(double alasJajarGenjang, double tinggiAlas, double sisiA, double sisiB, double tinggiLimas) {
        // 3. Memanggil constructor dari kelas induk (JajarGenjang)
        super(alasJajarGenjang, tinggiAlas, sisiA, sisiB);
        this.tinggiLimas = tinggiLimas;
    }

    @Override
    public double hitungVolume() {
        // 4. Menggunakan hitungLuas() yang diwarisi dari JajarGenjang
        return (1.0 / 3.0) * super.hitungLuas() * this.tinggiLimas;
    }

    @Override
    public double hitungLuasPermukaan() {
        // 4. Menggunakan kembali metode dan properti dari kelas induk
        double luasAlas = super.hitungLuas();
        double sisiA = super.getSisiA();
        double sisiB = super.getSisiB();
        
        // Perhitungan ini adalah penyederhanaan
        double tinggiSegitigaDiSisiA = Math.sqrt(Math.pow(tinggiLimas, 2) + Math.pow(sisiB / 2, 2));
        double tinggiSegitigaDiSisiB = Math.sqrt(Math.pow(tinggiLimas, 2) + Math.pow(sisiA / 2, 2));

        double luasSisiTegak = (sisiA * tinggiSegitigaDiSisiA) + (sisiB * tinggiSegitigaDiSisiB);

        return luasAlas + luasSisiTegak;
    }

    // Getter dan Setter untuk properti unik kelas ini
    public double getTinggiLimas() {
        return tinggiLimas;
    }

    public void setTinggiLimas(double tinggiLimas) {
        this.tinggiLimas = tinggiLimas;
    }
}