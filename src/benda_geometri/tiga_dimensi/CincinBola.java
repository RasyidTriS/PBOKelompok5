package benda_geometri.tiga_dimensi;

// 1. CincinBola SEKARANG adalah turunan dari Bola (extends Bola).
//    Ini lebih logis karena Cincin Bola adalah bagian dari Bola.
public class CincinBola extends Bola {

    private double tinggiCincin;

    public CincinBola(double jariJariBola, double tinggiCincin) {
        // 2. Mengirim jariJariBola ke constructor kelas induknya, yaitu Bola.
        super(jariJariBola);
        this.tinggiCincin = tinggiCincin;
    }

    // 3. Overriding: Menyediakan implementasi Volume yang spesifik untuk CincinBola.
    @Override
    public double hitungVolume() {
        // 4. Menggunakan getJariJari() dan PI yang diwarisi dari kelas induk (Bola -> Lingkaran).
        return PI * Math.pow(this.tinggiCincin, 2) * (getJariJari() - this.tinggiCincin / 3.0);
    }

    // 5. Overriding: Menyediakan implementasi Luas Permukaan yang spesifik.
    @Override
    public double hitungLuasPermukaan() {
        return 2 * PI * getJariJari() * this.tinggiCincin;
    }
    
    // === Enkapsulasi: Getter dan Setter untuk properti unik kelas ini ===
    public double getTinggiCincin() {
        return tinggiCincin;
    }

    public void setTinggiCincin(double tinggiCincin) {
        this.tinggiCincin = tinggiCincin;
    }
}