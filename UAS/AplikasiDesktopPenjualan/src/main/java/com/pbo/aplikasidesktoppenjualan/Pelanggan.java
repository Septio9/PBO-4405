package com.pbo.aplikasidesktoppenjualan;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Pelanggan {
    private SimpleIntegerProperty idPelanggan;
    private SimpleStringProperty nama;
    private SimpleStringProperty alamat;

    public Pelanggan(int idPelanggan, String nama, String alamat) {
        this.idPelanggan = new SimpleIntegerProperty(idPelanggan);
        this.nama = new SimpleStringProperty(nama);
        this.alamat = new SimpleStringProperty(alamat);
    }

    public int getIdPelanggan() {
        return idPelanggan.get();
    }

    public SimpleIntegerProperty idPelangganProperty() {
        return idPelanggan;
    }

    public void setIdPelanggan(int idPelanggan) {
        this.idPelanggan.set(idPelanggan);
    }

    public String getNama() {
        return nama.get();
    }

    public SimpleStringProperty namaProperty() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama.set(nama);
    }

    public String getAlamat() {
        return alamat.get();
    }

    public SimpleStringProperty alamatProperty() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat.set(alamat);
    }
}
