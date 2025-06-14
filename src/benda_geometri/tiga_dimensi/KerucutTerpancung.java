package benda_geometri.tiga_dimensi;

import benda_geometri.dua_dimensi.Lingkaran;

// 1. Deklarasi diubah untuk mewarisi dari Kerucut
// Tidak perlu 'implements BentukTigaDimensi' karena sudah diwarisi dari Kerucut -> Lingkaran
public class KerucutTerpancung extends Kerucut {

    // 2. Hanya butuh satu atribut tambahan untuk jari-jari atas.
    //    Jari-jari bawah dan tinggi sudah diwarisi dari Kerucut.
    private double jariJariAtas;

    public KerucutTerpancung(double jariJariAtas, double jariJariBawah, double tinggi) {
        // 3. Mengirim jari-jari bawah dan tinggi ke constructor Kerucut
        super(jariJariBawah, tinggi);
        this.jariJariAtas = jariJariAtas;
    }

    // 4. Override total diperlukan karena rumusnya sama sekali berbeda.
    @Override
    public double hitungVolume() {
        // Menggunakan getJariJari() untuk jari-jari bawah yang diwarisi
        return (1.0 / 3.0) * PI * getTinggi() * (Math.pow(getJariJari(), 2) + 
                Math.pow(this.jariJariAtas, 2) + 
                (getJariJari() * this.jariJariAtas));
    }

    @Override
    public double hitungLuasPermukaan() {
        // Menggunakan getJariJari() untuk jari-jari bawah yang diwarisi
        double luasAlasAtas = PI * Math.pow(this.jariJariAtas, 2);
        // super.hitungLuas() dari induk akan menghitung luas alas bawah
        double luasAlasBawah = super.hitungLuas();
        
        double garisPelukis = Math.sqrt(Math.pow(getJariJari() - this.jariJariAtas, 2) + Math.pow(getTinggi(), 2));
        double luasSelimut = PI * (this.jariJariAtas + getJariJari()) * garisPelukis;
        
        return luasAlasAtas + luasAlasBawah + luasSelimut;
    }

    // Getter & Setter untuk atribut unik
    public double getJariJariAtas() {
        return jariJariAtas;
    }

    public void setJariJariAtas(double jariJariAtas) {
        this.jariJariAtas = jariJariAtas;
    }
}