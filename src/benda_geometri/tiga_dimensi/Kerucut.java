package benda_geometri.tiga_dimensi;

import benda_geometri.BentukTigaDimensi;
import benda_geometri.dua_dimensi.Lingkaran;

// 1. Deklarasi diubah untuk mewarisi dari Lingkaran
public class Kerucut extends Lingkaran implements BentukTigaDimensi {
    
    // 2. Atribut 'jariJari' dan 'PI' dihapus karena diwarisi dari Lingkaran
    private double tinggi;

    public Kerucut(double jariJari, double tinggi) {
        // 3. Memanggil constructor dari kelas induk (Lingkaran) untuk mengatur jari-jari
        super(jariJari);
        this.tinggi = tinggi;
    }

    @Override
    public double hitungVolume() {
        // 4. Menggunakan kembali metode hitungLuas() dari induk sebagai luas alas
        return (1.0 / 3.0) * super.hitungLuas() * this.tinggi;
    }

    @Override
    public double hitungLuasPermukaan() {
        // Rumus: pi * r * (r + s), dimana s adalah garis pelukis
        // Menggunakan getJariJari() dan PI yang diwarisi
        double s = Math.sqrt(Math.pow(getJariJari(), 2) + Math.pow(this.tinggi, 2));
        return PI * getJariJari() * (getJariJari() + s);
    }
    
    // === Enkapsulasi: Getter dan Setter ===
    
    // getJariJari() dan setJariJari() sudah diwarisi dari Lingkaran
    
    public double getTinggi() {
        return this.tinggi;
    }

    public void setTinggi(double tinggi) {
        this.tinggi = tinggi;
    }
}