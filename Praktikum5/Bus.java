package Praktikum5;

class Bus extends Kendaraan implements TransportasiUmum{
	private String kelasBus;
	
	public Bus(String merk, String model, int tahunProduksi, String kelasBus) {
		super(merk, model, tahunProduksi);
		this.kelasBus = kelasBus;
	}
	
	@Override
	public void nyalakanMesin() {
		System.out.println("Menyalakan mesin Bus dengan menekan tombol start dan menunggu tekanan udara stabil.");
	}
	
	public String jenisBahanBakar() {
		return "Solar";
	}
	
	@Override
	public int kapasitasPenumpang() {
		return 45;
	}
	
	public void fiturBus() {
		System.out.println("Fitur bus: Dilengkapi kursi nyaman dan fasilitas hiburan");
	}
	
	//inner class
	class JadwalPerjalanan {
        private String rute;
        private String waktuBerangkat;

        public JadwalPerjalanan(String rute, String waktuBerangkat) {
            this.rute = rute;
            this.waktuBerangkat = waktuBerangkat;
        }

        public void tampilkanJadwal() {
            System.out.println("Rute: " + rute);
            System.out.println("Waktu Berangkat: " + waktuBerangkat);
        }
		
	}
		
	}