package model;

public class Order {
    String id;
    String idCostumer;
    String idService;
    String idUser;
    double total;
    String tanggal;
    String tanggalSelesai;
    String status;
    String statusPembayaran;

    // Getter & Setter
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getIdCostumer() {
        return idCostumer;
    }
    public void setIdCostumer(String idCostumer) {
        this.idCostumer = idCostumer;
    }

    public String getIdService() {
        return idService;
    }
    public void setIdService(String idService) {
        this.idService = idService;
    }

    public String getIdUser() {
        return idUser;
    }
    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public double getTotal() {
        return total;
    }
    public void setTotal(double total) {
        this.total = total;
    }

    public String getTanggal() {
        return tanggal;
    }
    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getTanggalSelesai() {
        return tanggalSelesai;
    }
    public void setTanggalSelesai(String tanggalSelesai) {
        this.tanggalSelesai = tanggalSelesai;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusPembayaran() {
        return statusPembayaran;
    }
    public void setStatusPembayaran(String statusPembayaran) {
        this.statusPembayaran = statusPembayaran;
    }
}
