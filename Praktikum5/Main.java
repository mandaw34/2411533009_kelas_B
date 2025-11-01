package Praktikum5;

public class Main {
    public static void main(String[] args) {
        Mobil mobil1 = new Mobil("Toyota", "Avanza", 2021, "Automatic");
        mobil1.tampilkanInfo();
        mobil1.nyalakanMesin();
        System.out.println("Jenis Bahan Bakar: " + mobil1.jenisBahanBakar());
        mobil1.infoKonsumsi();
        mobil1.fiturMobil();

        System.out.println();

        Bus bus1 = new Bus("Mercedes-Benz", "Bus Pariwisata", 2018, "Eksekutif");
        bus1.tampilkanInfo();
        bus1.nyalakanMesin();
        System.out.println("Jenis Bahan Bakar: " + bus1.jenisBahanBakar());
        bus1.infoKonsumsi();
        System.out.println("Kapasitas Penumpang: " + bus1.kapasitasPenumpang() + " penumpang");
        bus1.fiturBus();

        Bus.JadwalPerjalanan jadwal = bus1.new JadwalPerjalanan("Jakarta – Bandung", "08:00");
        jadwal.tampilkanJadwal();
        
        Pesawat pesawat1 = new Pesawat("Garuda", "Boeing 737", 100, "Domestik", "Garuda Indonesia");
        pesawat1.tampilkanInfo();
        pesawat1.nyalakanMesin();
        System.out.println("Jenis Bahan Bakar: " + pesawat1.jenisBahanBakar());
   
    }
} 