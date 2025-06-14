package benda_geometri.tiga_dimensi;

// 1. Deklarasi diubah untuk mewarisi dari Bola.
//    Tidak perlu 'implements BentukTigaDimensi' karena sudah diwarisi dari Bola.
public class TemberengBola extends Bola {

    private double tinggiTembereng;

    public TemberengBola(double jariJariBola, double tinggiTembereng) {
        // 2. Mengirim jari-jari ke constructor kelas induk (Bola)
        super(jariJariBola);
        this.tinggiTembereng = tinggiTembereng;
    }

    @Override
    public double hitungVolume() {
        // 3. Menggunakan getJariJari() dan PI yang diwarisi dari induk
        double r = getJariJari();
        double h = this.tinggiTembereng;
        return (1.0 / 3.0) * PI * Math.pow(h, 2) * (3 * r - h);
    }

    @Override
    public double hitungLuasPermukaan() {
        // Rumus Luas Permukaan (selimut) Tembereng Bola = 2 * pi * r * h
        // 3. Menggunakan getJariJari() dan PI yang diwarisi
        return 2 * PI * getJariJari() * this.tinggiTembereng;
    }

    // === Enkapsulasi: Getter dan Setter ===
    public double getTinggiTembereng() {
        return this.tinggiTembereng;
    }

    public void setTinggiTembereng(double tinggiTembereng) {
        this.tinggiTembereng = tinggiTembereng;
    }
}