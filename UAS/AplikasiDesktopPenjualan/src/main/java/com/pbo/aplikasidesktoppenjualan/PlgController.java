package com.pbo.aplikasidesktoppenjualan;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.sql.*;

public class PlgController {
    @FXML
    private TableView<Pelanggan> tablePelanggan;
    @FXML
    private TableColumn<Pelanggan, Integer> colId;
    @FXML
    private TableColumn<Pelanggan, String> colNama;
    @FXML
    private TableColumn<Pelanggan, String> colAlamat;
    @FXML
    private TextField txtNama;
    @FXML
    private TextField txtAlamat;
    @FXML
    private Button btnTambah;
    @FXML
    private Button btnUbah;
    @FXML
    private Button btnHapus;

    private Connection connection;

    @FXML
    private void initialize() {
        // Mengatur properti kolom
        colId.setCellValueFactory(cellData -> cellData.getValue().idPelangganProperty().asObject());
        colNama.setCellValueFactory(cellData -> cellData.getValue().namaProperty());
        colAlamat.setCellValueFactory(cellData -> cellData.getValue().alamatProperty());

        // Mendapatkan koneksi ke database
        connection = getConnection();
        // Event handler untuk pencarian realtime
        txtCari.textProperty().addListener((observable, oldValue, newValue) -> cariPelanggan(newValue));

        // Mendapatkan data pelanggan dari database
        loadPelanggan();
    }

    @FXML
    private void tambahPelanggan() {
        String idPelangganStr = txtIdPelanggan.getText();
        String nama = txtNama.getText();
        String alamat = txtAlamat.getText();

        // Konversi input ID Pelanggan ke tipe int
        int id = 0;
        try {
            id = Integer.parseInt(idPelangganStr);
        } catch (NumberFormatException e) {
            System.out.println("ID Pelanggan harus berupa angka");
            return;
        }

        // Memasukkan data pelanggan ke database
        int generatedId = insertPelanggan(id, nama, alamat);

        // Mengosongkan inputan
        txtIdPelanggan.clear();
        txtNama.clear();
        txtAlamat.clear();

        // Membuat objek Pelanggan dengan ID yang dihasilkan
        Pelanggan pelanggan = new Pelanggan(generatedId, nama, alamat);

        // Menambahkan pelanggan ke tabel
        tablePelanggan.getItems().add(pelanggan);
    }


    @FXML
    private void ubahPelanggan() {
        Pelanggan pelanggan = tablePelanggan.getSelectionModel().getSelectedItem();
        if (pelanggan != null) {
            int id = pelanggan.getIdPelanggan();
            String nama = txtNama.getText();
            String alamat = txtAlamat.getText();

            // Mengubah data pelanggan di database
            updatePelanggan(id, nama, alamat);

            // Mengosongkan inputan
            txtNama.clear();
            txtAlamat.clear();

            // Memuat kembali data pelanggan dari database
            loadPelanggan();
        }
    }
    @FXML
    private TextField txtIdPelanggan;

    private int insertPelanggan(int id, String nama, String alamat) {
        int generatedId = 0;

        try {
            // Mengeksekusi query untuk memasukkan data pelanggan
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO pelanggan (idpelanggan, nama, alamat) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, id);
            stmt.setString(2, nama);
            stmt.setString(3, alamat);
            stmt.executeUpdate();

            // Mendapatkan ID yang dihasilkan
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                generatedId = rs.getInt(1);
            }

            stmt.close();
            rs.close();

            System.out.println("Data pelanggan berhasil ditambahkan");
        } catch (SQLException e) {
            System.out.println("Error saat menambahkan data pelanggan: " + e.getMessage());
        }

        return generatedId;
    }


    @FXML
    private void hapusPelanggan() {
        Pelanggan pelanggan = tablePelanggan.getSelectionModel().getSelectedItem();
        if (pelanggan != null) {
            int id = pelanggan.getIdPelanggan();

            // Menghapus data pelanggan dari database
            deletePelanggan(id);

            // Menghapus pelanggan dari tabel
            tablePelanggan.getItems().remove(pelanggan);
        }
    }
    @FXML
    private TextField txtCari;
    @FXML
    private void cariPelanggan() {
        String keyword = txtCari.getText().trim();

        if (keyword.isEmpty()) {
            // Jika input pencarian kosong, tampilkan semua data pelanggan
            loadPelanggan();
        } else {
            // Jika ada input pencarian, cari data pelanggan berdasarkan keyword
            cariPelanggan(keyword);
        }
    }
    private void cariPelanggan(String keyword) {
        tablePelanggan.getItems().clear();

        try {
            // Mengeksekusi query untuk mencari data pelanggan berdasarkan keyword
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM pelanggan WHERE nama LIKE ?");
            stmt.setString(1, "%" + keyword + "%");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("idpelanggan");
                String nama = rs.getString("nama");
                String alamat = rs.getString("alamat");

                // Membuat objek Pelanggan dan menambahkannya ke dalam tabel
                Pelanggan pelanggan = new Pelanggan(id, nama, alamat);
                tablePelanggan.getItems().add(pelanggan);
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Error saat mencari data pelanggan: " + e.getMessage());
        }
    }


    private Connection getConnection() {
        // Konfigurasi koneksi ke database
        String url = "jdbc:mysql://localhost/javacrud";
        String username = "root";
        String password = "";

        Connection conn = null;
        try {
            // Membuat koneksi ke database
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Koneksi berhasil");
        } catch (SQLException e) {
            System.out.println("Koneksi gagal: " + e.getMessage());
        }

        return conn;
    }

    private void loadPelanggan() {
        tablePelanggan.getItems().clear();

        try {
            // Mengeksekusi query untuk mendapatkan data pelanggan
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM pelanggan");

            while (rs.next()) {
                int id = rs.getInt("idpelanggan");
                String nama = rs.getString("nama");
                String alamat = rs.getString("alamat");

                // Membuat objek Pelanggan dan menambahkannya ke dalam tabel
                Pelanggan pelanggan = new Pelanggan(id, nama, alamat);
                tablePelanggan.getItems().add(pelanggan);
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Error saat memuat data pelanggan: " + e.getMessage());
        }
    }

    private int insertPelanggan(String nama, String alamat) {
        int generatedId = 0;

        try {
            // Mengeksekusi query untuk memasukkan data pelanggan
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO pelanggan (nama, alamat) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, nama);
            stmt.setString(2, alamat);
            stmt.executeUpdate();

            // Mendapatkan ID yang dihasilkan
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                generatedId = rs.getInt(1);
            }

            stmt.close();
            rs.close();

            System.out.println("Data pelanggan berhasil ditambahkan");
        } catch (SQLException e) {
            System.out.println("Error saat menambahkan data pelanggan: " + e.getMessage());
        }

        return generatedId;
    }


    private void updatePelanggan(int id, String nama, String alamat) {
        try {
            // Mengeksekusi query untuk mengubah data pelanggan
            PreparedStatement stmt = connection.prepareStatement("UPDATE pelanggan SET nama = ?, alamat = ? WHERE idpelanggan = ?");
            stmt.setString(1, nama);
            stmt.setString(2, alamat);
            stmt.setInt(3, id);
            stmt.executeUpdate();
            stmt.close();

            System.out.println("Data pelanggan berhasil diubah");
        } catch (SQLException e) {
            System.out.println("Error saat mengubah data pelanggan: " + e.getMessage());
        }
    }

    private void deletePelanggan(int id) {
        try {
            // Mengeksekusi query untuk menghapus data pelanggan
            PreparedStatement stmt = connection.prepareStatement("DELETE FROM pelanggan WHERE idpelanggan = ?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt.close();

            System.out.println("Data pelanggan berhasil dihapus");
        } catch (SQLException e) {
            System.out.println("Error saat menghapus data pelanggan: " + e.getMessage());
        }
    }
}
