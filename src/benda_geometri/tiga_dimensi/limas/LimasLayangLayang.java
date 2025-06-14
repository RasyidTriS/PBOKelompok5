package benda_geometri.tiga_dimensi.limas;

import benda_geometri.BentukTigaDimensi;
import benda_geometri.dua_dimensi.LayangLayang;

// 1. Deklarasi diubah untuk mewarisi langsung dari LayangLayang
public class LimasLayangLayang extends LayangLayang implements BentukTigaDimensi {

    // 2. Atribut 'alas' tidak diperlukan lagi, hanya butuh atribut unik 'tinggi'
    private double tinggi;

    public LimasLayangLayang(double diagonal1, double diagonal2, double sisiPendek, double sisiPanjang, double tinggi) {
        // 3. Memanggil constructor dari kelas induk (LayangLayang)
        super(diagonal1, diagonal2, sisiPendek, sisiPanjang);
        this.tinggi = tinggi;
    }

    @Override
    public double hitungVolume() {
        // 4. Menggunakan hitungLuas() yang diwarisi dari LayangLayang
        return (1.0 / 3.0) * super.hitungLuas() * this.tinggi;
    }

    @Override
    public double hitungLuasPermukaan() {
        // 4. Menggunakan kembali metode dan properti dari kelas induk
        double luasAlas = super.hitungLuas();
        double sisiPendek = super.getSisiPendek();
        double sisiPanjang = super.getSisiPanjang();

        // Perhitungan ini adalah penyederhanaan
        double tinggiSegitigaSisiPendek = Math.sqrt(Math.pow(this.tinggi, 2) + Math.pow(sisiPendek / 2, 2));
        double tinggiSegitigaSisiPanjang = Math.sqrt(Math.pow(this.tinggi, 2) + Math.pow(sisiPanjang / 2, 2));
        
        double luasSisiTegak = (sisiPendek * tinggiSegitigaSisiPendek) + (sisiPanjang * tinggiSegitigaSisiPanjang);
        
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