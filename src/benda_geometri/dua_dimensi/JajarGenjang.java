package benda_geometri.dua_dimensi;

import benda_geometri.BentukDuaDimensi;

public class JajarGenjang extends BentukDuaDimensi {
    private double alas;
    private double tinggi;
    private double sisiA;
    private double sisiB;

    public JajarGenjang(double alas, double tinggi, double sisiA, double sisiB) {
        this.alas = alas;
        this.tinggi = tinggi;
        this.sisiA = sisiA;
        this.sisiB = sisiB;
    }

    @Override
    public double hitungKeliling() {
        return 2 * (this.sisiA + this.sisiB);
    }

    @Override
    public double hitungLuas() {
        return this.alas * this.tinggi;
    } 

    public double getSisiA(){
        return sisiA;
    }

    public double getSisiB(){
        return sisiB;
    }
}