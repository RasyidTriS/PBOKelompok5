package benda_geometri.dua_dimensi;

import benda_geometri.BentukDuaDimensi;

public class Segitiga extends BentukDuaDimensi {
    // Atribut dibuat private
    private double alas;
    private double tinggi;

    public Segitiga(double alas, double tinggi) {   
        this.alas = alas;
        this.tinggi = tinggi;
    }

    @Override
    public double hitungLuas() {
        return 0.5 * this.alas * this.tinggi; 
    }

    @Override
    public double hitungKeliling() {
        // CATATAN PENTING: Perhitungan ini mengasumsikan segitiga sama sisi
        // di mana panjang setiap sisinya sama dengan 'alas'.
        // Untuk segitiga umum, dibutuhkan panjang ketiga sisinya untuk perhitungan keliling yang akurat.
        return 3 * this.alas;   
    }

    // === Enkapsulasi: Getters dan Setters ===
    public double getAlas() {
        return alas;
    }

    public void setAlas(double alas) {
        this.alas = alas;
    }

    public double getTinggi() {
        return tinggi;
    }

    public void setTinggi(double tinggi) {
        this.tinggi = tinggi;
    }
}