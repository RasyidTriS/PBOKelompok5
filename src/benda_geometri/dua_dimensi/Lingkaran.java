package benda_geometri.dua_dimensi;

import benda_geometri.BentukDuaDimensi;

public class Lingkaran extends BentukDuaDimensi {
    private double jariJari;
    protected final double PI = 3.14;

    public Lingkaran(double jariJari) {
        this.jariJari = jariJari;
    }

    // Overloading (sudah sesuai permintaan sebelumnya)
    public double hitungLuas() {
        return this.PI * this.jariJari * this.jariJari;
    }

    public double hitungLuas(double jariJariBaru) {
        return this.PI * jariJariBaru * jariJariBaru;
    }

    @Override
    public double hitungKeliling() {
        return 2 * this.PI * this.jariJari;
    }

    // Getter & Setter
    public double getJariJari() {
        return jariJari;
    }

    public void setJariJari(double jariJari) {
        this.jariJari = jariJari;
    }
}