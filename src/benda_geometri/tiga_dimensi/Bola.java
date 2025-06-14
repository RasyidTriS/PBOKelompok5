package benda_geometri.tiga_dimensi;

import benda_geometri.BentukTigaDimensi;
import benda_geometri.dua_dimensi.Lingkaran;

// Bola ADALAH SEBUAH Lingkaran dalam 3D (extends Lingkaran)
// dan memenuhi kontrak BentukTigaDimensi (implements BentukTigaDimensi)
public class Bola extends Lingkaran implements BentukTigaDimensi {

    public Bola(double jariJari) {
        // Mengirim jariJari ke constructor kelas induknya, yaitu Lingkaran
        super(jariJari);
    }

    @Override
    public double hitungVolume() {
        // Menggunakan getJariJari() yang diwarisi dari Lingkaran
        return (4.0 / 3.0) * PI * Math.pow(getJariJari(), 3);
    }

    @Override
    public double hitungLuasPermukaan() {
        // Reuse code! Luas permukaan bola adalah 4x luas lingkaran induknya.
        // Memanggil metode hitungLuas() yang diwarisi dari Lingkaran.
        return 4 * super.hitungLuas();
    }
}