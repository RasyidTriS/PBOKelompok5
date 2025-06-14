// File: PBOKelompok5/src/benda_geometri/BentukDuaDimensi.java
package benda_geometri;

public abstract class BentukDuaDimensi implements Geometris {
    
    // Metode abstrak yang HARUS diimplementasikan oleh kelas anak
    public abstract double hitungLuas();
    public abstract double hitungKeliling();

    /**
     * Implementasi default untuk menampilkan informasi.
     * Kelas turunan bisa meng-override ini untuk menambahkan detail lebih spesifik.
     */
    @Override
    public void displayInfo() {
        System.out.println("Luas: " + hitungLuas());
        System.out.println("Keliling: " + hitungKeliling());
    }
}