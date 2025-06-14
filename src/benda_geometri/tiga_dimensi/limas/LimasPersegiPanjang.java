package benda_geometri.tiga_dimensi.limas;

import benda_geometri.BentukTigaDimensi;
import benda_geometri.dua_dimensi.PersegiPanjang;

// 1. Deklarasi diubah untuk mewarisi langsung dari PersegiPanjang
public class LimasPersegiPanjang extends PersegiPanjang implements BentukTigaDimensi {

    // 2. Atribut 'alas' tidak diperlukan lagi, hanya butuh atribut unik 'tinggi'
    private double tinggi;

    public LimasPersegiPanjang(double panjangAlas, double lebarAlas, double tinggi) {
        // 3. Memanggil constructor dari kelas induk (PersegiPanjang)
        super(panjangAlas, lebarAlas);
        this.tinggi = tinggi;
    }

    @Override
    public double hitungVolume() {
        // 4. Menggunakan hitungLuas() yang diwarisi dari PersegiPanjang
        return (1.0 / 3.0) * super.hitungLuas() * this.tinggi;
    }

    @Override
    public double hitungLuasPermukaan() {
        // 4. Menggunakan kembali metode dan properti dari kelas induk
        double luasAlas = super.hitungLuas();
        double panjang = super.getPanjang();
        double lebar = super.getLebar();

        // Menghitung tinggi dari masing-masing segitiga di sisi tegak
        double tinggiSegitigaSisiPanjang = Math.sqrt(Math.pow(this.tinggi, 2) + Math.pow(lebar / 2, 2));
        double tinggiSegitigaSisiLebar = Math.sqrt(Math.pow(this.tinggi, 2) + Math.pow(panjang / 2, 2));
        
        double luasSisiTegak = (panjang * tinggiSegitigaSisiPanjang) + (lebar * tinggiSegitigaSisiLebar);
        
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