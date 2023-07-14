module com.pbo.aplikasidesktoppenjualan {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.pbo.aplikasidesktoppenjualan to javafx.fxml;
    exports com.pbo.aplikasidesktoppenjualan;
}