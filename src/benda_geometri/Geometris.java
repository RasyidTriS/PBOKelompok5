package benda_geometri;

/**
 * Level 1: Interface Puncak untuk semua objek geometri.
 * Mendefinisikan kontrak paling dasar yang harus dimiliki oleh setiap bentuk.
 */
public interface Geometris {
    
    /**
     * Metode untuk menampilkan informasi detail dari sebuah bangun.
     * Setiap kelas konkrit harus menyediakan implementasinya sendiri.
     */
    void displayInfo();
    
}