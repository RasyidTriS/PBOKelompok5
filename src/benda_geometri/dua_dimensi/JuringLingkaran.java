package benda_geometri.dua_dimensi;

// JuringLingkaran tetap extends Lingkaran.
// Pastikan file Lingkaran.java sudah Anda perbaiki agar extends BentukDuaDimensi.
public class JuringLingkaran extends Lingkaran {
    private double sudutJuring; 

    public JuringLingkaran(double jariJari, double sudutJuring) {
        super(jariJari);
        this.sudutJuring = sudutJuring;
    }

    @Override
    public double hitungLuas() {
        // Luas Juring = (sudut/360) * Luas Lingkaran Penuh
        // Memanfaatkan metode hitungLuas() dari kelas induknya (Lingkaran)
        return (this.sudutJuring / 360.0) * super.hitungLuas();
    }

    @Override
    public double hitungKeliling() {
        // Keliling Juring = (Panjang Busur) + (2 * Jari-jari)
        // Panjang Busur = (sudut/360) * Keliling Lingkaran Penuh
        double panjangBusur = (this.sudutJuring / 360.0) * super.hitungKeliling();
        return panjangBusur + (2 * super.getJariJari());
    }
}