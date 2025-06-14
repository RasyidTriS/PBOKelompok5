package benda_geometri.tiga_dimensi.limas;

import benda_geometri.BentukTigaDimensi;
import benda_geometri.dua_dimensi.BelahKetupat;

// 1. Deklarasi diubah untuk mewarisi langsung dari BelahKetupat
public class LimasBelahKetupat extends BelahKetupat implements BentukTigaDimensi {

    // 2. Atribut 'alas' tidak diperlukan lagi, hanya butuh atribut unik 'tinggi'
    private double tinggi;

    public LimasBelahKetupat(double diagonal1, double diagonal2, double sisi, double tinggi) {
        // 3. Memanggil constructor dari kelas induk (BelahKetupat)
        super(diagonal1, diagonal2, sisi);
        this.tinggi = tinggi;
    }

    @Override
    public double hitungVolume() {
        // 4. Menggunakan hitungLuas() yang diwarisi dari BelahKetupat
        return (1.0 / 3.0) * super.hitungLuas() * this.tinggi;
    }

    @Override
    public double hitungLuasPermukaan() {
        // 4. Menggunakan kembali metode dan properti dari kelas induk
        double luasAlas = super.hitungLuas();
        
        // Penyederhanaan rumus seperti di kode asli Anda
        double setengahD1 = super.getDiagonal1() / 2.0;
        double tinggiSegitigaTegak = Math.sqrt(Math.pow(this.tinggi, 2) + Math.pow(setengahD1, 2));
        
        double luasSisiTegak = 4 * (0.5 * super.getSisi() * tinggiSegitigaTegak);

        return luasAlas + luasSisiTegak;
    }

    // Getter dan Setter untuk properti unik kelas ini
    public double getTinggi() {
        return tinggi;
    }

    public void setTinggi(double tinggi) {
        this.tinggi = tinggi;
    }
}