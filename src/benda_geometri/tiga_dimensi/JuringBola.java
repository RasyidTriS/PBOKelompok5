package benda_geometri.tiga_dimensi;

// JuringBola ADALAH SEBUAH Bola (extends Bola).
// Tidak perlu 'implements BentukTigaDimensi' lagi karena sudah diwarisi dari Bola.
public class JuringBola extends Bola {
    private double sudutDerajat;

    public JuringBola(double jariJari, double sudutDerajat) {
        // Mengirim jariJari ke constructor kelas induknya, yaitu Bola
        super(jariJari);
        this.sudutDerajat = sudutDerajat;
    }

    // Overriding: Mengubah implementasi volume dari kelas Bola
    @Override
    public double hitungVolume() {
        // Menggunakan kembali perhitungan volume dari kelas induk (Bola)
        return super.hitungVolume() * (this.sudutDerajat / 360.0);
    }

    // Overriding: Mengubah implementasi luas permukaan dari kelas Bola
    @Override
    public double hitungLuasPermukaan() {
        // Catatan: Ini adalah penyederhanaan.
        // Menggunakan kembali perhitungan dari kelas induk (Bola).
        return super.hitungLuasPermukaan() * (this.sudutDerajat / 360.0);
    }

    // Getter & Setter
    public double getSudutDerajat() {
        return sudutDerajat;
    }

    public void setSudutDerajat(double sudutDerajat) {
        this.sudutDerajat = sudutDerajat;
    }
}