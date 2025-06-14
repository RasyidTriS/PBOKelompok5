package benda_geometri.tiga_dimensi;

import benda_geometri.BentukTigaDimensi;
import benda_geometri.dua_dimensi.Persegi;

// Pewarisan: Kubus ADALAH SEBUAH Persegi dalam 3D (extends Persegi)
// dan memenuhi kontrak bangun ruang (implements BentukTigaDimensi)
public class Kubus extends Persegi implements BentukTigaDimensi {

    public Kubus(double panjangSisi) {
        // Mengirim nilai ke constructor kelas induknya, yaitu Persegi
        super(panjangSisi);
    }

    @Override
    public double hitungVolume() {
        // Menggunakan metode dan properti dari kelas induk (Persegi)
        return super.hitungLuas() * super.getSisi();
    }

    @Override
    public double hitungLuasPermukaan() {
        // Menggunakan kembali metode hitungLuas() dari induk
        return 6 * super.hitungLuas();
    }
}