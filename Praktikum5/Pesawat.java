package Praktikum5;

class Pesawat extends Kendaraan implements TransportasiUdara, Maskapai {
    private String jenisPenerbangan;
    private String namaMaskapai;

    public Pesawat(String merk, String model, int tahunProduksi, String jenisPenerbangan, String namaMaskapai) {
        super(merk, model, tahunProduksi);
        this.jenisPenerbangan = jenisPenerbangan;
        this.namaMaskapai = namaMaskapai;
    }

    @Override
    public void nyalakanMesin() {
        System.out.println("Nyalakan Mesin: Bersiap lepas landas");
    }

    @Override
    public String jenisBahanBakar() {
        return "Avtur";
    }

    @Override
    public void jenisPenerbangan() {
        System.out.println("Jenis Penerbangan: " + jenisPenerbangan);
    }

    @Override
    public String namaMaskapai() {
        return namaMaskapai;
    }
}
