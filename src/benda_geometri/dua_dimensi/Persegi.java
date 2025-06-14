package benda_geometri.dua_dimensi;

import benda_geometri.BentukDuaDimensi;

public class Persegi extends BentukDuaDimensi {
    // Atribut dibuat private untuk enkapsulasi
    private double sisi;

    public Persegi(double sisi) {
        this.sisi = sisi;
    }
 
    @Override
    public double hitungLuas() {
        return this.sisi * this.sisi;
    }

    @Override
    public double hitungKeliling() {
        return 4 * this.sisi;
    }

    // === Enkapsulasi: Getters dan Setters ===
    public double getSisi() {
        return sisi;
    }

    public void setSisi(double sisi) {
        this.sisi = sisi;
    }
}