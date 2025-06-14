package benda_geometri.tiga_dimensi.limas;

import benda_geometri.BentukTigaDimensi;
import benda_geometri.dua_dimensi.Trapesium;

// 1. Deklarasi diubah untuk mewarisi langsung dari Trapesium
public class LimasTrapesium extends Trapesium implements BentukTigaDimensi {

    // 2. Atribut 'alas' tidak diperlukan lagi, hanya butuh atribut unik 'tinggiLimas'
    private double tinggiLimas;

    public LimasTrapesium(double alasAtas, double alasBawah, double sisiMiring, double tinggiAlas, double tinggiLimas) {
        // 3. Memanggil constructor dari kelas induk (Trapesium)
        super(alasAtas, alasBawah, sisiMiring, tinggiAlas);
        this.tinggiLimas = tinggiLimas;
    }

    @Override
    public double hitungVolume() {
        // 4. Menggunakan hitungLuas() yang diwarisi dari Trapesium
        return (1.0 / 3.0) * super.hitungLuas() * this.tinggiLimas;
    }

    @Override
    public double hitungLuasPermukaan() {
        // 4. Menggunakan kembali metode dan properti dari kelas induk
        double luasAlas = super.hitungLuas();
        
        // Perhitungan ini adalah penyederhanaan berdasarkan kode asli
        double apotemaAlas = (super.getAlasBawah() - super.getAlasAtas()) / 2.0;
        double tinggiSisiTegakMiring = Math.sqrt(Math.pow(this.tinggiLimas, 2) + Math.pow(apotemaAlas, 2));

        double luasSisiTegakAtas = 0.5 * super.getAlasAtas() * tinggiSisiTegakMiring;
        double luasSisiTegakBawah = 0.5 * super.getAlasBawah() * tinggiSisiTegakMiring;
        double luasSisiTegakSamping = 2 * (0.5 * super.getSisiMiring() * tinggiSisiTegakMiring);

        return luasAlas + luasSisiTegakAtas + luasSisiTegakBawah + luasSisiTegakSamping;
    }

    // Getter dan Setter untuk properti unik kelas ini
    public double getTinggiLimas() {
        return tinggiLimas;
    }

    public void setTinggiLimas(double tinggiLimas) {
        this.tinggiLimas = tinggiLimas;
    }
}