import benda_geometri.dua_dimensi.*;
import benda_geometri.tiga_dimensi.*;
import benda_geometri.tiga_dimensi.limas.*;
import benda_geometri.tiga_dimensi.prisma.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int pilihan;
            do {
                System.out.println("\n+==================================+");
                System.out.println("|      KALKULATOR GEOMETRI OBJEK   |");
                System.out.println("+==================================+");
                System.out.println("| 1. Kalkulasi Bentuk Dua Dimensi  |");
                System.out.println("| 2. Kalkulasi Bentuk Tiga Dimensi |");
                System.out.println("| 3. Tampilkan Laporan Semua Bentuk|");
                System.out.println("| 4. Keluar dari Program           |");
                System.out.println("+----------------------------------+");
                System.out.print("Pilih Opsi [1-4] -> ");

                try {
                    pilihan = input.nextInt();

                    switch (pilihan) {
                        case 1:
                            System.out.println("\n.-----------------------------------.");
                            System.out.println("|          PILIH BENTUK 2D          |");
                            System.out.println("|-----------------------------------|");
                            System.out.println("| 1. Segitiga         7. Trapesium  |");
                            System.out.println("| 2. Persegi          8. Lingkaran  |");
                            System.out.println("| 3. Persegi Panjang  9. Juring     |");
                            System.out.println("| 4. Jajar Genjang   10. Tembereng  |");
                            System.out.println("| 5. Belah Ketupat                  |");
                            System.out.println("| 6. Layang-Layang                  |");
                            System.out.println("'------------------------------------'");
                            System.out.print("Input Pilihan 2D: ");
                            int pilihanBangunDatar = input.nextInt();

                            switch (pilihanBangunDatar) {
                                case 1:
                                    System.out.println("\n--- Menghitung Segitiga ---");

                                    System.out.print("Masukkan nilai alas segitiga : ");
                                    double alas = input.nextDouble();

                                    System.out.print("Masukkan nilai tinggi segitiga : ");
                                    double tinggi = input.nextDouble();

                                    Segitiga segitiga = new Segitiga(alas,tinggi);
                                    System.out.println("Luas Segitiga = " + segitiga.hitungLuas());
                                    System.out.println("Keliling Segitiga = " + segitiga.hitungKeliling());
                                    break;
                                case 2:
                                    System.out.println("\n--- Menghitung JajarGenjang ---");

                                    System.out.print("Masukkan nilai alas JajarGenjang : ");
                                    double alasJajarGenjang = input.nextDouble();

                                    System.out.print("Masukkan nilai tinggi JajarGenjang : ");
                                    double tinggiJajarGenjang = input.nextDouble();

                                    System.out.print("Masukkan nilai sisi A JajarGenjang : ");
                                    double sisiAJajarGenjang = input.nextDouble();

                                    System.out.print("Masukkan nilai sisi B JajarGenjang : ");
                                    double sisiBJajarGenjang = input.nextDouble();

                                    JajarGenjang jajarGenjang = new JajarGenjang(alasJajarGenjang,tinggiJajarGenjang,sisiAJajarGenjang,sisiBJajarGenjang);
                                    System.out.println("Luas JajarGenjang = " + jajarGenjang.hitungLuas());
                                    System.out.println("Keliling JajarGenjang = " + jajarGenjang.hitungKeliling());
                                case 3:
                                    System.out.println("\n--- Menghitung BelahKetupat ---");

                                    System.out.print("Masukkan nilai alas BelahKetupat : ");
                                    double diagonal1BelahKetupat = input.nextDouble();

                                    System.out.print("Masukkan nilai tinggi BelahKetupat : ");
                                    double diagonal2BelahKetupat = input.nextDouble();

                                    System.out.print("Masukkan nilai sisi BelahKetupat : ");
                                    double sisiBelahKetupat = input.nextDouble();

                                    BelahKetupat belahKetupat = new BelahKetupat(diagonal1BelahKetupat,diagonal2BelahKetupat,sisiBelahKetupat);
                                    System.out.println("Luas BelahKetupat = " + belahKetupat.hitungLuas());
                                    System.out.println("Keliling BelahKetupat = " + belahKetupat.hitungKeliling());
                                case 4:
                                    System.out.println("\n--- Menghitung PersegiPanjang ---");

                                    System.out.print("Masukkan nilai panjang PersegiPanjang : ");
                                    double panjangPersegiPanjang = input.nextDouble();

                                    System.out.print("Masukkan nilai lebar PersegiPanjang : ");
                                    double lebarPersegiPanjang = input.nextDouble();

                                    PersegiPanjang persegiPanjang = new PersegiPanjang(panjangPersegiPanjang,lebarPersegiPanjang);
                                    System.out.println("Luas PersegiPanjang = " + persegiPanjang.hitungLuas());
                                    System.out.println("Keliling PersegiPanjang = " + persegiPanjang.hitungKeliling());
                                case 5:
                                    System.out.println("\n--- Menghitung LayangLayang ---");

                                    System.out.print("Masukkan nilai alas LayangLayang : ");
                                    double diagonal1LayangLayang = input.nextDouble();

                                    System.out.print("Masukkan nilai tinggi LayangLayang : ");
                                    double diagonal2LayangLayang = input.nextDouble();

                                    System.out.print("Masukkan nilai sisi A LayangLayang : ");
                                    double sisiALayangLayang = input.nextDouble();

                                    System.out.print("Masukkan nilai sisi B LayangLayang : ");
                                    double sisiBLayangLayang = input.nextDouble();

                                    LayangLayang layangLayang = new LayangLayang(diagonal1LayangLayang,diagonal2LayangLayang,sisiALayangLayang, sisiBLayangLayang);
                                    System.out.println("Luas LayangLayang = " + layangLayang.hitungLuas());
                                    System.out.println("Keliling LayangLayang = " + layangLayang.hitungKeliling());
                                case 6:
                                    System.out.println("\n--- Menghitung Persegi ---");
                                    System.out.print("Masukkan nilai sisi persegi : ");
                                    double sisi = input.nextDouble();
                                    Persegi persegi = new Persegi(sisi);
                                    System.out.println("Luas Persegi = " + persegi.hitungLuas());
                                    System.out.println("Keliling Persegi = " + persegi.hitungKeliling());
                                    break;
                                case 7:
                                    System.out.println("\n--- Menghitung Trapesium ---");
                                    System.out.print("Masukkan nilai alas atas trapesium : ");
                                    double alasAtasTrapesium = input.nextDouble();
                                    System.out.print("Masukkan nilai alas bawah trapesium : ");
                                    double alasBawahTrapesium = input.nextDouble();
                                    System.out.print("Masukkan nilai sisi miring  trapesium : ");
                                    double sisiMiringTrapesium = input.nextDouble();
                                    System.out.print("Masukkan nilai tinggi trapesium : ");
                                    double tinggiTrapesium = input.nextDouble();
                                    Trapesium trapesium = new Trapesium(alasAtasTrapesium, alasBawahTrapesium, sisiMiringTrapesium, tinggiTrapesium);
                                    System.out.println("Luas Trapesium = " + trapesium.hitungLuas());
                                    System.out.println("Keliling Trapesium = " + trapesium.hitungKeliling());
                                    break;
                                case 8:
                                    System.out.println("\n--- Menghitung Lingkaran ---");
                                    System.out.print("Masukkan nilai jari-jari Lingkaran : ");
                                    double jariJariLingkaran = input.nextDouble();
                                    
                                    Lingkaran lingkaran = new Lingkaran(jariJariLingkaran);
                                    System.out.println("Luas Lingkaran = " + lingkaran.hitungLuas());
                                    System.out.println("Keliling Lingkaran = " + lingkaran.hitungKeliling());
                                    break;
                                case 9:
                                    System.out.println("\n--- Menghitung Juring Lingkaran ---");
                                    System.out.print("Masukkan nilai jari-jari Lingkaran : ");
                                    double jariJariLingkaran_juring = input.nextDouble();
                                    
                                    System.out.print("Masukkan nilai sudut Juring Lingkaran : ");
                                    double sudutJuring = input.nextDouble();
                                    
                                    JuringLingkaran juringLingkaran = new JuringLingkaran(jariJariLingkaran_juring, sudutJuring);
                                    System.out.println("Luas Juring Lingkaran = " + juringLingkaran.hitungLuas());
                                    System.out.println("Keliling Juring Lingkaran = " + juringLingkaran.hitungKeliling());
                                    break;
                                case 10:
                                    System.out.println("\n--- Menghitung Tembereng Lingkaran ---");
                                    System.out.print("Masukkan nilai jari-jari Lingkaran : ");
                                    double jariJariLingkaran_tembereng = input.nextDouble();
                                    
                                    System.out.print("Masukkan nilai sudut Tembereng Lingkaran : ");
                                    double sudutTembereng = input.nextDouble();
                                    
                                    TemberengLingkaran temberengLingkaran = new TemberengLingkaran(jariJariLingkaran_tembereng, sudutTembereng);
                                    System.out.println("Luas Tembereng Lingkaran = " + temberengLingkaran.hitungLuas());
                                    System.out.println("Keliling Tembereng Lingkaran = " + temberengLingkaran.hitungKeliling());
                                    break;
                                default:
                                    System.out.println("Pilihan bangun datar tidak valid.");
                            }
                            break; 
                        case 2:
                            System.out.println("\n.-------------------------------------------------------------.");
                            System.out.println("|                       MENU BENTUK 3D                        |");
                            System.out.println("|-------------------------------------------------------------|");
                            System.out.println("| 1. Kubus            9. Prisma Segitiga      17. Bola        |");
                            System.out.println("| 2. Balok            10. Limas Jajar Genjang 18. Cincin Bola |");
                            System.out.println("| 3. Limas Persegi    11. Prisma Jajar G.     19. Juring Bola |");
                            System.out.println("| 4. Prisma Persegi   12. Limas Trapesium     20. Tembereng B.|");
                            System.out.println("| 5. Limas Belah K.   13. Prisma Trapesium    21. Kerucut     |");
                            System.out.println("| 6. Prisma Belah K.  14. Limas P. Panjang    22. Kerucut T.  |");
                            System.out.println("| 7. Limas Layang L.  15. Prisma P. Panjang   23. Tabung      |");
                            System.out.println("| 8. Limas Segitiga   16. (Kosong)                            |");
                            System.out.println("'-------------------------------------------------------------'");
                            System.out.print("Input Pilihan 3D -> ");
                            int pilihanBangunRuang = input.nextInt();

                            switch (pilihanBangunRuang) {
                                case 1:
                                    System.out.println("\n--- Menghitung Kubus ---");

                                    System.out.print("Masukkan nilai sisi kubus : ");
                                    double sisiKubus = input.nextDouble();

                                    Kubus kubus = new Kubus(sisiKubus);
                                    System.out.println("Volume Kubus = " + kubus.hitungVolume());
                                    System.out.println("Luas Permukaan Kubus = " + kubus.hitungLuasPermukaan());
                                    break;
                                case 2:
                                    System.out.println("\n--- Menghitung Limas Persegi ---");

                                    System.out.print("Masukkan nilai sisi limas persegi : ");
                                    double sisiLimasPersegi = input.nextDouble();

                                    System.out.print("Masukkan nilai tinggi limas persegi: ");
                                    double tinggiLimasPersegi = input.nextDouble();

                                    LimasPersegi limasPersegi = new LimasPersegi(sisiLimasPersegi,tinggiLimasPersegi);
                                    System.out.println("Volume LimasPersegi = " + limasPersegi.hitungVolume());
                                    System.out.println("Luas Permukaan LimasPersegi = " + limasPersegi.hitungLuasPermukaan());
                                    break;
                                case 3:
                                    System.out.println("\n--- Menghitung Prisma Persegi ---");

                                    System.out.print("Masukkan nilai sisi prisma persegi : ");
                                    double sisiPrismaPersegi = input.nextDouble();

                                    System.out.print("Masukkan nilai tinggi prisma persegi: ");
                                    double tinggiPrismaPersegi = input.nextDouble();

                                    PrismaPersegi prismaPersegi = new PrismaPersegi(sisiPrismaPersegi,tinggiPrismaPersegi);
                                    System.out.println("Volume PrismaPersegi = " + prismaPersegi.hitungVolume());
                                    System.out.println("Luas Permukaan PrismaPersegi = " + prismaPersegi.hitungLuasPermukaan());
                                    break;
                                case 4:
                                    System.out.println("\n--- Menghitung Limas Belah Ketupat ---");

                                    System.out.print("Masukkan nilai diagonal 1 limas belah ketupat : ");
                                    double diagonal1BelahKetupat = input.nextDouble();

                                    System.out.print("Masukkan nilai diagonal 2 limas belah ketupat : ");
                                    double diagonal2BelahKetupat = input.nextDouble();

                                    System.out.print("Masukkan nilai sisi limas belah ketupat : ");
                                    double sisiBelahKetupat = input.nextDouble();

                                    System.out.print("Masukkan nilai tinggi limas belah ketupat : ");
                                    double tinggiBelahKetupat = input.nextDouble();

                                    LimasBelahKetupat limasBelahKetupat = new LimasBelahKetupat(diagonal1BelahKetupat, diagonal2BelahKetupat, sisiBelahKetupat, tinggiBelahKetupat);
                                    System.out.println("Volume LimasBelahKetupat = " + limasBelahKetupat.hitungVolume());
                                    System.out.println("Luas Permukaan LimasBelahKetupat = " + limasBelahKetupat.hitungLuasPermukaan());
                                    break;
                                case 5:
                                    System.out.println("\n--- Menghitung Prisma  Belah Ketupat ---");

                                    System.out.print("Masukkan nilai diagonal 1 prisma belah ketupat : ");
                                    double diagonal1BelahKetupatP = input.nextDouble();

                                    System.out.print("Masukkan nilai diagonal 2 prisma belah ketupat : ");
                                    double diagonal2BelahKetupatP = input.nextDouble();

                                    System.out.print("Masukkan nilai sisi prisma belah ketupat : ");
                                    double sisiBelahKetupatP = input.nextDouble();

                                    System.out.print("Masukkan nilai tinggi prisma belah ketupat : ");
                                    double tinggiBelahKetupatP = input.nextDouble();

                                    PrismaBelahKetupat prismaBelahKetupat = new PrismaBelahKetupat(diagonal1BelahKetupatP, diagonal2BelahKetupatP, sisiBelahKetupatP, tinggiBelahKetupatP);
                                    System.out.println("Volume PrismaBelahKetupat = " + prismaBelahKetupat.hitungVolume());
                                    System.out.println("Luas Permukaan PrismaBelahKetupat = " + prismaBelahKetupat.hitungLuasPermukaan());
                                    break;
                                case 6:
                                    System.out.println("\n--- Menghitung Limas Layang Layang ---");

                                    System.out.print("Masukkan nilai diagonal 1 Limas Layang Layang : ");
                                    double diagonal1LayangLayangL = input.nextDouble();

                                    System.out.print("Masukkan nilai diagonal 2 Limas Layang Layang : ");
                                    double diagonal2LayangLayangL = input.nextDouble();

                                    System.out.print("Masukkan nilai sisi panjang Limas Layang Layang : ");
                                    double sisiPanjangLayangLayangL = input.nextDouble();

                                    System.out.print("Masukkan nilai sisi pendek Limas Layang Layang : ");
                                    double sisiPendekLayangLayangL = input.nextDouble();

                                    System.out.print("Masukkan nilai tinggi Limas Layang Layang : ");
                                    double tinggiLayangLayangL = input.nextDouble();

                                    LimasLayangLayang limasLayangLayang = new LimasLayangLayang(diagonal1LayangLayangL, diagonal2LayangLayangL, sisiPanjangLayangLayangL, sisiPendekLayangLayangL, tinggiLayangLayangL);
                                    System.out.println("Volume LimasLayangLayang = " + limasLayangLayang.hitungVolume());
                                    System.out.println("Luas Permukaan LimasLayangLayang = " + limasLayangLayang.hitungLuasPermukaan());
                                    break;
                                case 7:
                                    System.out.println("\n--- Menghitung Prisma Layang Layang ---");

                                    System.out.print("Masukkan nilai diagonal 1 Prisma Layang Layang : ");
                                    double diagonal1LayangLayangP = input.nextDouble();

                                    System.out.print("Masukkan nilai diagonal 2 Prisma Layang Layang : ");
                                    double diagonal2LayangLayangP = input.nextDouble();

                                    System.out.print("Masukkan nilai sisi panjang Prisma Layang Layang : ");
                                    double sisiPanjangLayangLayangP = input.nextDouble();

                                    System.out.print("Masukkan nilai sisi pendek Prisma Layang Layang : ");
                                    double sisiPendekLayangLayangP = input.nextDouble();

                                    System.out.print("Masukkan nilai tinggi Prisma Layang Layang : ");
                                    double tinggiLayangLayangP = input.nextDouble();

                                    PrismaLayangLayang prismaLayangLayang = new PrismaLayangLayang(diagonal1LayangLayangP, diagonal2LayangLayangP, sisiPanjangLayangLayangP, sisiPendekLayangLayangP, tinggiLayangLayangP);
                                    System.out.println("Volume PrismaLayangLayang = " + prismaLayangLayang.hitungVolume());
                                    System.out.println("Luas Permukaan PrismaLayangLayang = " + prismaLayangLayang.hitungLuasPermukaan());
                                    break;
                                case 8:
                                    System.out.println("\n--- Menghitung Limas Segitiga  ---");

                                    System.out.print("Masukkan nilai alas Segitiga : ");
                                    double alasSegitigaL = input.nextDouble();

                                    System.out.print("Masukkan nilai tinggi Segitiga : ");
                                    double tinggiSegitigaL = input.nextDouble();

                                    System.out.print("Masukkan nilai tinggi Limas Segitiga : ");
                                    double tinggiLimasSegitiga = input.nextDouble();

                                    LimasSegitiga limasSegitiga = new LimasSegitiga(alasSegitigaL, tinggiSegitigaL, tinggiLimasSegitiga);
                                    System.out.println("Volume Limas Segitiga = " + limasSegitiga.hitungVolume());
                                    System.out.println("Luas Permukaan Limas Segitiga = " + limasSegitiga.hitungLuasPermukaan());
                                    break;
                                case 9:
                                    System.out.println("\n--- Menghitung Prisma Segitiga  ---");

                                    System.out.print("Masukkan nilai alas Segitiga : ");
                                    double alasSegitigaP = input.nextDouble();

                                    System.out.print("Masukkan nilai tinggi Segitiga : ");
                                    double tinggiSegitigaP = input.nextDouble();

                                    System.out.print("Masukkan nilai tinggi Prisma Segitiga : ");
                                    double tinggiPrismaSegitiga = input.nextDouble();

                                    PrismaSegitiga prismaSegitiga = new PrismaSegitiga(alasSegitigaP, tinggiSegitigaP, tinggiPrismaSegitiga);
                                    System.out.println("Volume Prisma Segitiga = " + prismaSegitiga.hitungVolume());
                                    System.out.println("Luas Permukaan Prisma Segitiga = " + prismaSegitiga.hitungLuasPermukaan());
                                    break;
                                case 10:
                                    System.out.println("\n--- Menghitung Limas Jajar Genjang  ---");

                                    System.out.print("Masukkan nilai alas JajarGenjang : ");
                                    double alasJajarGenjangL = input.nextDouble();

                                    System.out.print("Masukkan nilai tinggi Jajar Genjang : ");
                                    double tinggiJajarGenjangL = input.nextDouble();

                                    System.out.print("Masukkan nilai sisi A Jajar Genjang : ");
                                    double sisiAJajarGenjangL = input.nextDouble();

                                    System.out.print("Masukkan nilai sisi B Jajar Genjang : ");
                                    double sisiBJajarGenjangL = input.nextDouble();

                                    System.out.print("Masukkan nilai tinggi Limas Jajar Genjang : ");
                                    double tinggiLimasJajarGenjang = input.nextDouble();

                                    LimasJajarGenjang limasJajarGenjang = new LimasJajarGenjang(alasJajarGenjangL, tinggiJajarGenjangL, sisiAJajarGenjangL, sisiBJajarGenjangL, tinggiLimasJajarGenjang);
                                    System.out.println("Volume Limas Jajar Genjang = " + limasJajarGenjang.hitungVolume());
                                    System.out.println("Luas Permukaan Limas Jajar Genjang = " + limasJajarGenjang.hitungLuasPermukaan());
                                    break;
                                case 11:
                                    System.out.println("\n--- Menghitung Prisma Jajar Genjang  ---");

                                    System.out.print("Masukkan nilai alas JajarGenjang : ");
                                    double alasJajarGenjangP = input.nextDouble();

                                    System.out.print("Masukkan nilai tinggi Jajar Genjang : ");
                                    double tinggiJajarGenjangP = input.nextDouble();

                                    System.out.print("Masukkan nilai sisi A Jajar Genjang : ");
                                    double sisiAJajarGenjangP = input.nextDouble();

                                    System.out.print("Masukkan nilai sisi B Jajar Genjang : ");
                                    double sisiBJajarGenjangP = input.nextDouble();

                                    System.out.print("Masukkan nilai tinggi Prisma Jajar Genjang : ");
                                    double tinggiPrismaJajarGenjang = input.nextDouble();

                                    PrismaJajarGenjang prismaJajarGenjang = new PrismaJajarGenjang(alasJajarGenjangP, tinggiJajarGenjangP, sisiAJajarGenjangP, sisiBJajarGenjangP, tinggiPrismaJajarGenjang);
                                    System.out.println("Volume Prisma Jajar Genjang = " + prismaJajarGenjang.hitungVolume());
                                    System.out.println("Luas Permukaan Prisma Jajar Genjang = " + prismaJajarGenjang.hitungLuasPermukaan());
                                    break;
                                case 12:
                                    System.out.println("\n--- Menghitung Limas Trapesium  ---");

                                    System.out.print("Masukkan nilai alas atas Trapesium : ");
                                    double alasAtasTrapesiumL = input.nextDouble();

                                    System.out.print("Masukkan nilai alas bawah Trapesium : ");
                                    double alasBawahTrapesiumL = input.nextDouble();

                                    System.out.print("Masukkan nilai sisi miring Trapesium : ");
                                    double sisiMiringTrapesiumL = input.nextDouble();

                                    System.out.print("Masukkan nilai tinggi Trapesium : ");
                                    double tinggiTrapesiumL = input.nextDouble();

                                    System.out.print("Masukkan nilai tinggi Limas Trapesium : ");
                                    double tinggiLimasTrapesium = input.nextDouble();

                                    LimasTrapesium limasTrapesium = new LimasTrapesium(alasAtasTrapesiumL, alasBawahTrapesiumL, sisiMiringTrapesiumL, tinggiTrapesiumL, tinggiLimasTrapesium);
                                    System.out.println("Volume Limas Trapesium = " + limasTrapesium.hitungVolume());
                                    System.out.println("Luas Permukaan Limas Trapesium = " + limasTrapesium.hitungLuasPermukaan());
                                    break;
                                case 13:
                                    System.out.println("\n--- Menghitung Prisma Trapesium  ---");

                                    System.out.print("Masukkan nilai alas atas Trapesium : ");
                                    double alasAtasTrapesiumP = input.nextDouble();

                                    System.out.print("Masukkan nilai alas bawah Trapesium : ");
                                    double alasBawahTrapesiumP = input.nextDouble();

                                    System.out.print("Masukkan nilai sisi miring Trapesium : ");
                                    double sisiMiringTrapesiumP = input.nextDouble();

                                    System.out.print("Masukkan nilai tinggi Trapesium : ");
                                    double tinggiTrapesiumP = input.nextDouble();

                                    System.out.print("Masukkan nilai tinggi Prisma Trapesium : ");
                                    double tinggiPrismaTrapesium = input.nextDouble();

                                    PrismaTrapesium prismaTrapesium = new PrismaTrapesium(alasAtasTrapesiumP, alasBawahTrapesiumP, sisiMiringTrapesiumP, tinggiTrapesiumP, tinggiPrismaTrapesium);
                                    System.out.println("Volume Prisma Trapesium = " + prismaTrapesium.hitungVolume());
                                    System.out.println("Luas Permukaan Prisma Trapesium = " + prismaTrapesium.hitungLuasPermukaan());
                                    break;
                                case 14:
                                    System.out.println("\n--- Menghitung Balok ---");

                                    System.out.print("Masukkan nilai panjang balok : ");
                                    double panjangBalok = input.nextDouble();

                                    System.out.print("Masukkan nilai lebar balok : ");
                                    double lebarBalok = input.nextDouble();

                                    System.out.print("Masukkan nilai tinggi balok : ");
                                    double tinggiBalok = input.nextDouble();

                                    Balok balok = new Balok(panjangBalok, lebarBalok, tinggiBalok);
                                    System.out.println("Volume Balok = " + balok.hitungVolume());
                                    System.out.println("Luas Permukaan Balok = " + balok.hitungLuasPermukaan());
                                    break;
                                case 15:
                                    System.out.println("\n--- Menghitung Limas Persegi Panjang ---");

                                    System.out.print("Masukkan nilai panjang Limas Persegi Panjang : ");
                                    double panjangLimasPersegiPanjang = input.nextDouble();

                                    System.out.print("Masukkan nilai lebar Limas Persegi Panjang : ");
                                    double lebarLimasPersegiPanjang = input.nextDouble();

                                    System.out.print("Masukkan nilai tinggi Limas Persegi Panjang : ");
                                    double tinggiLimasPersegiPanjang = input.nextDouble();

                                    LimasPersegiPanjang limasPersegiPanjang = new LimasPersegiPanjang(panjangLimasPersegiPanjang, lebarLimasPersegiPanjang, tinggiLimasPersegiPanjang);
                                    System.out.println("Volume Limas Persegi Panjang = " + limasPersegiPanjang.hitungVolume());
                                    System.out.println("Luas Permukaan Limas Persegi Panjang = " + limasPersegiPanjang.hitungLuasPermukaan());
                                    break;
                                case 16:
                                    System.out.println("\n--- Menghitung Prisma Persegi Panjang ---");

                                    System.out.print("Masukkan nilai panjang Prisma Persegi Panjang : ");
                                    double panjangPrismaPersegiPanjang = input.nextDouble();

                                    System.out.print("Masukkan nilai lebar Prisma Persegi Panjang : ");
                                    double lebarPrismaPersegiPanjang = input.nextDouble();

                                    System.out.print("Masukkan nilai tinggi Prisma Persegi Panjang : ");
                                    double tinggiPrismaPersegiPanjang = input.nextDouble();

                                    PrismaPersegiPanjang prismaPersegiPanjang = new PrismaPersegiPanjang(panjangPrismaPersegiPanjang, lebarPrismaPersegiPanjang, tinggiPrismaPersegiPanjang);
                                    System.out.println("Volume Prisma Persegi Panjang = " + prismaPersegiPanjang.hitungVolume());
                                    System.out.println("Luas Permukaan Prisma Persegi Panjang = " + prismaPersegiPanjang.hitungLuasPermukaan());
                                    break;
                                case 17:
                                    System.out.println("\n--- Menghitung Bola ---");

                                    System.out.print("Masukkan nilai jari-jari bola : ");
                                    double jariJariBola = input.nextDouble();

                                    Bola bola = new Bola(jariJariBola);
                                    System.out.println("Volume Bola = " + bola.hitungVolume());
                                    System.out.println("Luas Permukaan Bola = " + bola.hitungLuasPermukaan());
                                    break;
                                case 18:
                                   System.out.println("\n--- Menghitung Cincin Bola ---");

                                   System.out.print("Masukkan nilai jari-jari luar cincin bola : ");
                                   double jariJariLuarCincin = input.nextDouble();

                                   System.out.print("Masukkan nilai tinggi cincin bola : ");
                                   double tinggiCincin = input.nextDouble();

                                   CincinBola cincinBola = new CincinBola(jariJariLuarCincin, tinggiCincin);
                                   System.out.println("Volume Cincin Bola = " + cincinBola.hitungVolume());
                                   System.out.println("Luas Permukaan Cincin Bola = " + cincinBola.hitungLuasPermukaan());
                                    break;
                                case 19:
                                   System.out.println("\n--- Menghitung Juring Bola ---");

                                   System.out.print("Masukkan nilai jari-jari juring bola : ");
                                   double jariJariJuring = input.nextDouble();

                                   System.out.print("Masukkan nilai sudut juring bola (dalam derajat): ");
                                   double sudutJuring = input.nextDouble();

                                   JuringBola
                                    juringBola = new JuringBola(jariJariJuring, sudutJuring);
                                   System.out.println("Volume Juring Bola = " + juringBola.hitungVolume());
                                   System.out.println("Luas Permukaan Juring Bola = " + juringBola.hitungLuasPermukaan());
                                    break;
                                case 20:
                                    System.out.println("\n--- Menghitung Tembereng Bola ---");

                                    System.out.print("Masukkan nilai jari-jari tembereng bola : ");
                                    double jariJariTembereng = input.nextDouble();

                                    System.out.print("Masukkan nilai tinggi tembereng bola : ");
                                    double tinggiTembereng = input.nextDouble();

                                    TemberengBola temberengBola = new TemberengBola(jariJariTembereng, tinggiTembereng);
                                    System.out.println("Volume Tembereng Bola = " + temberengBola.hitungVolume());
                                    System.out.println("Luas Permukaan Tembereng Bola = " + temberengBola.hitungLuasPermukaan());
                                    break;
                                case 21:
                                    System.out.println("\n--- Menghitung Kerucut ---");

                                    System.out.print("Masukkan nilai jari-jari kerucut : ");
                                    double jariJariKerucut = input.nextDouble();

                                    System.out.print("Masukkan nilai tinggi kerucut : ");
                                    double tinggiKerucut = input.nextDouble();

                                    Kerucut kerucut = new Kerucut(jariJariKerucut, tinggiKerucut);
                                    System.out.println("Volume Kerucut = " + kerucut.hitungVolume());
                                    System.out.println("Luas Permukaan Kerucut = " + kerucut.hitungLuasPermukaan());
                                    break;
                                case 22:
                                    System.out.println("\n--- Menghitung Kerucut Terpancung ---");

                                    System.out.print("Masukkan nilai jari-jari atas kerucut terpancung : ");
                                    double jariJariAtasKerucut = input.nextDouble();

                                    System.out.print("Masukkan nilai jari-jari bawah kerucut terpancung : ");
                                    double jariJariBawahKerucut = input.nextDouble();

                                    System.out.print("Masukkan nilai tinggi kerucut terpancung : ");
                                    double tinggiKerucutTerpancung = input.nextDouble();

                                    KerucutTerpancung kerucutTerpancung = new KerucutTerpancung(jariJariAtasKerucut, jariJariBawahKerucut, tinggiKerucutTerpancung);
                                    System.out.println("Volume Kerucut Terpancung = " + kerucutTerpancung.hitungVolume());
                                    System.out.println("Luas Permukaan Kerucut Terpancung = " + kerucutTerpancung.hitungLuasPermukaan());
                                    break;
                                case 23:
                                    System.out.println("\n--- Menghitung Tabung ---");

                                    System.out.print("Masukkan nilai jari-jari tabung : ");
                                    double jariJariTabung = input.nextDouble();

                                    System.out.print("Masukkan nilai tinggi tabung : ");
                                    double tinggiTabung = input.nextDouble();

                                    Tabung tabung = new Tabung(jariJariTabung, tinggiTabung);
                                    System.out.println("Volume Tabung = " + tabung.hitungVolume());
                                    System.out.println("Luas Permukaan Tabung = " + tabung.hitungLuasPermukaan());
                                    break;
                                default:
                                    System.out.println("Pilihan bangun ruang tidak valid.");
                            }
                            break;
                        case 3:
                            System.out.println("\n=== Hitung Keseluruhan (Multithreaded & Ordered Output) ===");
                            ExecutorService executor = Executors.newFixedThreadPool(10);
                            List<Callable<String>> tasks = new ArrayList<>();

                            // --- KUMPULKAN SEMUA TUGAS PERHITUNGAN ---

                            // 1. Jajar Genjang
                            tasks.add(() -> {
                                JajarGenjang j = new JajarGenjang(10, 7, 5, 6);
                                return String.format("\n-> Jajar Genjang\nalas = 10 & tinggi = 7 & sisi A = 5 & sisi B = 6\nLuas Jajar Genjang : %.1f\nKeliling Jajar Genjang : %.1f", j.hitungLuas(), j.hitungKeliling());
                            });

                            // 2. Belah Ketupat
                            tasks.add(() -> {
                                BelahKetupat bk = new BelahKetupat(6, 8, 5);
                                return String.format("\n-> Belah Ketupat\ndiagonal1 = 6 & diagonal2 = 8 & sisi = 5\nLuas Belah Ketupat : %.1f\nKeliling Belah Ketupat : %.1f", bk.hitungLuas(), bk.hitungKeliling());
                            });

                            // 3. Layang-Layang
                            tasks.add(() -> {
                                LayangLayang ll = new LayangLayang(20, 10, 12, 22);
                                return String.format("\n-> Layang-layang\ndiagonal1 = 20 & diagonal2 = 10 & sisi pendek = 12 & sisi panjang = 22\nLuas Layang-layang : %.1f\nKeliling Layang-layang : %.1f", ll.hitungLuas(), ll.hitungKeliling());
                            });

                            // 4. Persegi
                            tasks.add(() -> {
                                Persegi p = new Persegi(10);
                                return String.format("\n-> Persegi\nsisi = 10\nLuas Persegi : %.1f\nKeliling Persegi: %.1f", p.hitungLuas(), p.hitungKeliling());
                            });

                            // 5. Persegi Panjang
                            tasks.add(() -> {
                                PersegiPanjang pp = new PersegiPanjang(12, 10);
                                return String.format("\n-> Persegi Panjang\npanjang= 12 & lebar = 10\nLuas Persegi Panjang : %.1f\nKeliling Persegi Panjang: %.1f", pp.hitungLuas(), pp.hitungKeliling());
                            });
                            
                            // 6. Segitiga
                            tasks.add(() -> {
                                Segitiga s = new Segitiga(12, 10);
                                return String.format("\n-> Segitiga\nalas= 12 & tinggi= 10\nLuas Segitiga : %.1f\nKeliling Segitiga: %.1f", s.hitungLuas(), s.hitungKeliling());
                            });

                            // 7. Trapesium
                            tasks.add(() -> {
                                Trapesium t = new Trapesium(10, 14, 8, 6);
                                return String.format("\n-> Trapesium\nalas atas = 10 & alas bawah = 14 & sisi miring = 8 & tinggi = 6\nLuas Trapesium : %.1f\nKeliling Trapesium : %.1f", t.hitungLuas(), t.hitungKeliling());
                            });

                            // 8. Lingkaran
                            tasks.add(() -> {
                                Lingkaran l = new Lingkaran(7);
                                return String.format("\n-> Lingkaran\njari-jari = 7\nLuas Lingkaran : %.2f\nKeliling Lingkaran : %.2f", l.hitungLuas(), l.hitungKeliling());
                            });

                            // 9. Juring Lingkaran
                            tasks.add(() -> {
                                JuringLingkaran jl = new JuringLingkaran(7, 90);
                                return String.format("\n-> JuringLingkaran\njari-jari = 7 & sudut 90 derajat\nLuas JuringLingkaran: %.3f\nKeliling JuringLingkaran: %.3f", jl.hitungLuas(), jl.hitungKeliling());
                            });

                            // 10. Tembereng Lingkaran
                            tasks.add(() -> {
                                TemberengLingkaran tl = new TemberengLingkaran(7, 90);
                                return String.format("\n-> Tembereng Lingkaran\njari-jari = 7 & sudut 90 derajat\nLuas Tembereng Lingkaran: %s\nKeliling Tembereng Lingkaran: %s", tl.hitungLuas(), tl.hitungKeliling());
                            });
                            
                            // 11. Kubus
                            tasks.add(() -> {
                                Kubus k = new Kubus(5);
                                return String.format("\n-> Kubus\nsisi = 5\nLuas Permukaan Kubus : %.1f\nVolume Kubus : %.1f", k.hitungLuasPermukaan(), k.hitungVolume());
                            });

                            // 12. Limas Persegi
                            tasks.add(() -> {
                                LimasPersegi lp = new LimasPersegi(5, 10);
                                return String.format("\n-> Limas Persegi\nsisi = 5 & tinggi = 10\nLuas Permukaan Limas Persegi : %.2f\nVolume Limas Persegi : %.2f", lp.hitungLuasPermukaan(), lp.hitungVolume());
                            });

                            // 13. Prisma Persegi
                            tasks.add(() -> {
                                PrismaPersegi pp = new PrismaPersegi(5, 10);
                                return String.format("\n-> Prisma Persegi\nsisi = 5 & tinggi = 10\nLuas Permukaan Prisma Persegi : %.1f\nVolume Prisma Persegi : %.1f", pp.hitungLuasPermukaan(), pp.hitungVolume());
                            });

                            // 14. Limas Belah Ketupat
                            tasks.add(() -> {
                                LimasBelahKetupat lbk = new LimasBelahKetupat(6, 8, 5, 10);
                                return String.format("\n-> Limas Belah Ketupat\ndiagonal1 = 6, diagonal2 = 8, sisi = 5 & tinggi = 10\nLuas Permukaan Limas Belah Ketupat : %.2f\nVolume Limas Belah Ketupat : %.2f", lbk.hitungLuasPermukaan(), lbk.hitungVolume());
                            });

                            // 15. Prisma Belah Ketupat
                            tasks.add(() -> {
                                PrismaBelahKetupat pbk = new PrismaBelahKetupat(6, 8, 5, 10);
                                return String.format("\n-> Prisma Belah Ketupat\ndiagonal1 = 6, diagonal2 = 8, sisi = 5 & tinggi = 10\nLuas Permukaan Prisma Belah Ketupat : %.1f\nVolume Prisma Belah Ketupat : %.1f", pbk.hitungLuasPermukaan(), pbk.hitungVolume());
                            });
                            
                            // 16. Limas Layang-Layang
                            tasks.add(() -> {
                                LimasLayangLayang lll = new LimasLayangLayang(5, 10, 6, 10, 10);
                                return String.format("\n-> Limas Layang-Layang\ndiagonal1 = 5, d2 = 10, sisi pendek = 6, sisi panjang = 10 & tinggi = 10\nLuas Permukaan Limas Layang-Layang : %.2f\nVolume Limas Layang-Layang : %.2f", lll.hitungLuasPermukaan(), lll.hitungVolume());
                            });

                            // 17. Prisma Layang-Layang
                            tasks.add(() -> {
                                PrismaLayangLayang pll = new PrismaLayangLayang(5, 10, 6, 10, 10);
                                return String.format("\n-> Prisma Layang-Layang\ndiagonal1 = 5, d2 = 10, sisi pendek = 6, sisi panjang = 10 & tinggi = 10\nLuas Permukaan Prisma Layang-Layang : %.1f\nVolume Prisma Layang-Layang : %.1f", pll.hitungLuasPermukaan(), pll.hitungVolume());
                            });

                            // 18. Limas Segitiga
                            tasks.add(() -> {
                                LimasSegitiga ls = new LimasSegitiga(5, 4.33, 10); // tinggi alas segitiga sama sisi dengan sisi 5 adalah ~4.33
                                return String.format("\n-> Limas Segitiga\nalas segitiga = 5, tinggi alas = 4.33 & tinggi limas = 10\nLuas Permukaan Limas Segitiga : %.2f\nVolume Limas Segitiga : %.2f", ls.hitungLuasPermukaan(), ls.hitungVolume());
                            });

                            // 19. Prisma Segitiga
                            tasks.add(() -> {
                                PrismaSegitiga ps = new PrismaSegitiga(5, 10, 10);
                                return String.format("\n-> Prisma Segitiga\nalas = 5 & tinggi alas = 10 & tinggi prisma = 10\nLuas Permukaan Prisma Segitiga : %.1f\nVolume Prisma Segitiga : %.1f", ps.hitungLuasPermukaan(), ps.hitungVolume());
                            });
                            
                            // 20. Limas Jajar Genjang
                             tasks.add(() -> {
                                LimasJajarGenjang ljg = new LimasJajarGenjang(6, 10, 5, 5, 10);
                                return String.format("\n-> Limas Jajar Genjang\nalas = 6 & tinggi alas = 10 & sisiA = 5 & sisiB = 5 & tinggi limas = 10\nLuas Permukaan Limas Jajar Genjang : %.2f\nVolume Limas Jajar Genjang : %.1f", ljg.hitungLuasPermukaan(), ljg.hitungVolume());
                            });
                            
                            // 21. Prisma Jajar Genjang
                            tasks.add(() -> {
                                PrismaJajarGenjang pjg = new PrismaJajarGenjang(6, 10, 5, 5, 10);
                                return String.format("\n-> Prisma Jajar Genjang\nalas = 6 & tinggi alas = 10 & sisiA = 5 & sisiB = 5 & tinggi prisma = 10\nLuas Permukaan Prisma Jajar Genjang : %.1f\nVolume Prisma Jajar Genjang : %.1f", pjg.hitungLuasPermukaan(), pjg.hitungVolume());
                            });

                            // 22. Limas Trapesium
                            tasks.add(() -> {
                                LimasTrapesium lt = new LimasTrapesium(5, 10, 6, 10, 15);
                                return String.format("\n-> Limas Trapesium\nalas atas = 5, alas bawah = 10, sisi miring = 6, tinggi alas = 10 & tinggi limas = 15\nLuas Permukaan Limas Trapesium : %.2f\nVolume Limas Trapesium : %.1f", lt.hitungLuasPermukaan(), lt.hitungVolume());
                            });
                            
                            // 23. Prisma Trapesium
                            tasks.add(() -> {
                                PrismaTrapesium pt = new PrismaTrapesium(5, 10, 6, 10, 15);
                                return String.format("\n-> Prisma Trapesium\nalas atas = 5, alas bawah = 10, sisi miring = 6, tinggi alas = 10 & tinggi prisma = 15\nLuas Permukaan Prisma Trapesium : %.1f\nVolume Prisma Trapesium : %.1f", pt.hitungLuasPermukaan(), pt.hitungVolume());
                            });

                            // 24. Balok
                            tasks.add(() -> {
                                Balok b = new Balok(5, 10, 15);
                                return String.format("\n-> Balok\npanjang = 5 & lebar = 10 & tinggi = 15\nLuas Permukaan Balok : %.1f\nVolume Balok : %.1f", b.hitungLuasPermukaan(), b.hitungVolume());
                            });
                            
                            // 25. Limas Persegi Panjang
                            tasks.add(() -> {
                                LimasPersegiPanjang lpp = new LimasPersegiPanjang(5, 10, 15);
                                return String.format("\n-> Limas Persegi Panjang\npanjang = 5 & lebar = 10 & tinggi = 15\nLuas Permukaan Limas Persegi Panjang : %.2f\nVolume Limas Persegi Panjang : %.1f", lpp.hitungLuasPermukaan(), lpp.hitungVolume());
                            });
                            
                            // 26. Prisma Persegi Panjang
                            tasks.add(() -> {
                                PrismaPersegiPanjang ppp = new PrismaPersegiPanjang(5, 10, 15);
                                return String.format("\n-> Prisma Persegi Panjang\npanjang = 5 & lebar = 10 & tinggi = 15\nLuas Permukaan Prisma Persegi Panjang : %.1f\nVolume Prisma Persegi Panjang : %.1f", ppp.hitungLuasPermukaan(), ppp.hitungVolume());
                            });

                            // 27. Bola
                            tasks.add(() -> {
                                Bola bola = new Bola(7);
                                return String.format("\n-> Bola\njari-jari = 7\nLuas Permukaan Bola : %.2f\nVolume Bola : %.2f", bola.hitungLuasPermukaan(), bola.hitungVolume());
                            });
                            
                            // 28. Cincin Bola
                            tasks.add(() -> {
                                CincinBola cb = new CincinBola(10, 5);
                                return String.format("\n-> Cincin Bola\njari-jari bola = 10 & tinggi cincin = 5\nLuas Permukaan Cincin Bola : %.1f\nVolume Cincin Bola : %.2f", cb.hitungLuasPermukaan(), cb.hitungVolume());
                            });

                            // 29. Juring Bola
                            tasks.add(() -> {
                                JuringBola jb = new JuringBola(7, 90);
                                return String.format("\n-> Juring Bola\njari-jari = 7 & sudut = 90 derajat\nLuas Permukaan Juring Bola : %.2f\nVolume Juring Bola : %.2f", jb.hitungLuasPermukaan(), jb.hitungVolume());
                            });
                            
                            // 30. Tembereng Bola
                            tasks.add(() -> {
                                TemberengBola tb = new TemberengBola(7, 5);
                                return String.format("\n-> Tembereng Bola\njari-jari bola = 7 & tinggi tembereng = 5\nLuas Permukaan Tembereng Bola : %.1f\nVolume Tembereng Bola : %.2f", tb.hitungLuasPermukaan(), tb.hitungVolume());
                            });
                            
                            // 31. Kerucut
                            tasks.add(() -> {
                                Kerucut k = new Kerucut(7, 10);
                                return String.format("\n-> Kerucut\njari-jari = 7 & tinggi = 10\nLuas Permukaan Kerucut : %.2f\nVolume Kerucut : %.2f", k.hitungLuasPermukaan(), k.hitungVolume());
                            });
                            
                            // 32. Kerucut Terpancung
                            tasks.add(() -> {
                                KerucutTerpancung kt = new KerucutTerpancung(10, 5, 15);
                                return String.format("\n-> Kerucut Terpancung\njari-jari bawah = 10, jari-jari atas = 5 & tinggi = 15\nLuas Permukaan Kerucut Terpancung : %.2f\nVolume Kerucut Terpancung : %.1f", kt.hitungLuasPermukaan(), kt.hitungVolume());
                            });

                            // 33. Tabung
                            tasks.add(() -> {
                                Tabung t = new Tabung(7, 10);
                                return String.format("\n-> Tabung\njari-jari = 7 & tinggi = 10\nLuas Permukaan Tabung : %.2f\nVolume Tabung : %.1f", t.hitungLuasPermukaan(), t.hitungVolume());
                            });


                            // --- EKSEKUSI SEMUA TUGAS & TAMPILKAN HASIL SECARA BERURUTAN ---
                            try {
                                List<Future<String>> results = executor.invokeAll(tasks);
                                executor.shutdown();

                                System.out.println("\n--- Hasil Perhitungan ---");
                                for (Future<String> result : results) {
                                    System.out.println(result.get());
                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;
                        case 4:
                            System.out.println("Keluar dari program. Terima kasih!");
                            break;
                        default:
                            System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Input tidak valid. Harap masukkan angka sesuai pilihan.");
                    input.nextLine();
                    pilihan = 0;
                }
            } while (pilihan != 4);
        }
        System.out.println("Program telah berakhir.");
    }
}