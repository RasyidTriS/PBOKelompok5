package benda_geometri.tiga_dimensi;

import benda_geometri.BentukTigaDimensi;
import benda_geometri.dua_dimensi.Lingkaran;

// 1. Deklarasi diubah untuk mewarisi dari Lingkaran
public class Tabung extends Lingkaran implements BentukTigaDimensi {

    // 2. Atribut 'jariJari' dan 'PI' dihapus karena sudah diwarisi
    private double tinggi;

    public Tabung(double jariJari, double tinggi) {
        // 3. Memanggil constructor dari kelas induk (Lingkaran)
        super(jariJari);
        this.tinggi = tinggi;
    }

    @Override
    public double hitungVolume() {
        // 4. Menggunakan kembali metode hitungLuas() dari induk sebagai luas alas
        return super.hitungLuas() * this.tinggi;
    }

    @Override
    public double hitungLuasPermukaan() {
        // 4. Menggunakan kembali metode dari induk untuk perhitungan
        double luasAlas = super.hitungLuas();
        // Keliling alas digunakan untuk menghitung luas selimut
        double luasSelimut = super.hitungKeliling() * this.tinggi;
        return (2 * luasAlas) + luasSelimut;
    }

    // getJariJari() dan setJariJari() sudah diwarisi dari Lingkaran
    
    // Getter dan Setter untuk properti unik kelas ini
    public double getTinggi() {
        return tinggi;
    }

    public void setTinggi(double tinggi) {
        this.tinggi = tinggi;
    }
}