package Praktikum5;

final class Mobil  extends Kendaraan implements BahanBakar{
	private String jenisTransmisi;
	
	public Mobil(String merk, String model, int tahunProduksi, String jenisTransmisi) {
		super(merk, model, tahunProduksi);
		this.jenisTransmisi = jenisTransmisi;
	}
	
	@Override
	public void nyalakanMesin() {
		System.out.println("Menyalakan mesin mobil dengan menekan tombol start/putar kunci kontak ");
	}
	
	@Override
	public String jenisBahanBakar() {
		return "Bensin";
	}
	public void fiturMobil() {
		System.out.println("Fitur mobil: AC otomatis dan audio premium");
	}
	
	}


