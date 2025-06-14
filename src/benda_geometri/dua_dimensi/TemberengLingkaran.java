package benda_geometri.dua_dimensi;

// 1. TemberengLingkaran ADALAH SEBUAH Lingkaran (extends Lingkaran)
public class TemberengLingkaran extends Lingkaran {
    // 2. Atribut unik untuk TemberengLingkaran dibuat private
    private double sudut; 

    public TemberengLingkaran(double jariJari, double sudut) {
        // 3. Mengirim 'jariJari' ke constructor kelas induknya, yaitu Lingkaran
        super(jariJari);
        this.sudut = sudut;
    }

    @Override
    public double hitungLuas() {
        // Rumus: Luas Tembereng = Luas Juring - Luas Segitiga
        double sudutRadian = Math.toRadians(this.sudut);
        
        // Menggunakan kembali metode hitungLuas() dari induk (Lingkaran) untuk menghitung luas juring
        double luasJuring = (this.sudut / 360.0) * super.hitungLuas();
        
        // Menghitung luas segitiga di dalamnya menggunakan jari-jari dari induk
        double luasSegitiga = 0.5 * getJariJari() * getJariJari() * Math.sin(sudutRadian);
        
        return luasJuring - luasSegitiga;
    }

    @Override
    public double hitungKeliling() {
        // Rumus: Keliling Tembereng = Panjang Busur + Panjang Tali Busur
        double sudutRadian = Math.toRadians(this.sudut);
        
        // Menggunakan kembali metode hitungKeliling() dari induk untuk menghitung panjang busur
        double panjangBusur = (this.sudut / 360.0) * super.hitungKeliling();
        
        // Menghitung panjang tali busur
        double taliBusur = 2 * getJariJari() * Math.sin(sudutRadian / 2);
        
        return panjangBusur + taliBusur;
    }

    // === Enkapsulasi: Getters dan Setters ===
    public double getSudut() {
        return sudut;
    }

    public void setSudut(double sudut) {
        this.sudut = sudut;
    }
}