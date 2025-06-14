package benda_geometri.dua_dimensi;

import benda_geometri.BentukDuaDimensi;

public class BelahKetupat extends BentukDuaDimensi {
    // 1. Atribut dibuat private untuk enkapsulasi
    private double sisi;
    private double diagonal1;
    private double diagonal2;

    public BelahKetupat(double diagonal1, double diagonal2, double sisi) {
        this.sisi = sisi;
        this.diagonal1 = diagonal1;
        this.diagonal2 = diagonal2;
    }

    @Override
    public double hitungKeliling() {
        return 4 * this.sisi;
    }

    @Override
    public double hitungLuas() {
        return (this.diagonal1 * this.diagonal2) / 2;
    }

    // === Enkapsulasi: Getters dan Setters diletakkan di bawah ===
    public double getSisi() {
        return sisi;
    }

    public void setSisi(double sisi) {
        this.sisi = sisi;
    }

    public double getDiagonal1() {
        return diagonal1;
    }

    public void setDiagonal1(double diagonal1) {
        this.diagonal1 = diagonal1;
    }

    public double getDiagonal2() {
        return diagonal2;
    }

    public void setDiagonal2(double diagonal2) {
        this.diagonal2 = diagonal2;
    }
}