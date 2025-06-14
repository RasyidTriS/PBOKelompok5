package benda_geometri;

public interface BentukTigaDimensi extends Geometris {

    double hitungVolume();
    double hitungLuasPermukaan();

    @Override
    default void displayInfo() {
        System.out.println("Volume: " + String.format("%.2f", hitungVolume()));
        System.out.println("Luas Permukaan: " + String.format("%.2f", hitungLuasPermukaan()));
    }
}