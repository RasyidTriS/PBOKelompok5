package benda_geometri.dua_dimensi;

import benda_geometri.BentukDuaDimensi;

public class PersegiPanjang extends BentukDuaDimensi {
    // Atribut dibuat private
    private double panjang;
    private double lebar;

    public PersegiPanjang(double panjang, double lebar) {   
        this.panjang = panjang;
        this.lebar = lebar;
    }

    @Override
    public double hitungLuas() {
        return this.panjang * this.lebar;
    }

    @Override
    public double hitungKeliling() {
        return 2 * (this.panjang + this.lebar);   
    }

    // === Enkapsulasi: Getters dan Setters ===
    public double getPanjang() {
        return panjang;
    }

    public void setPanjang(double panjang) {
        this.panjang = panjang;
    }

    public double getLebar() {
        return lebar;
    }

    public void setLebar(double lebar) {
        this.lebar = lebar;
    }
}