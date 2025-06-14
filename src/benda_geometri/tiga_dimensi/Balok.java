package benda_geometri.tiga_dimensi;

import benda_geometri.BentukTigaDimensi;
import benda_geometri.dua_dimensi.PersegiPanjang;

// Pewarisan: Balok ADALAH SEBUAH PersegiPanjang dalam 3D (extends)
// dan memenuhi kontrak bangun ruang (implements)
public class Balok extends PersegiPanjang implements BentukTigaDimensi {
    private double tinggi;

    public Balok(double panjang, double lebar, double tinggi) {
        // Mengirim 'panjang' dan 'lebar' ke constructor kelas induk (PersegiPanjang)
        super(panjang, lebar);
        this.tinggi = tinggi;
    }

    @Override
    public double hitungVolume() {
        // Menggunakan hitungLuas() yang diwarisi dari PersegiPanjang
        return super.hitungLuas() * this.tinggi;
    }

    @Override
    public double hitungLuasPermukaan() {
        // Menggunakan hitungLuas() dan hitungKeliling() dari PersegiPanjang
        return (2 * super.hitungLuas()) + (super.hitungKeliling() * this.tinggi);
    }
    
    // === Enkapsulasi: Getter dan Setter untuk properti unik kelas ini ===
    public double getTinggi() {
        return tinggi;
    }

    public void setTinggi(double tinggi) {
        this.tinggi = tinggi;
    }
}