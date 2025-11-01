package Praktikum5;

interface BahanBakar {
    String jenisBahanBakar();

    default void infoKonsumsi() {
        System.out.println("Info konsumsi: Konsumsi bahan bakar tergantung kapasitas mesin.");
    }
}