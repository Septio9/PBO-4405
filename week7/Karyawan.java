import java.util.Scanner;

public class Karyawan {
    int tunjangan;

    void tunjanganAnak(){
        Scanner inputan = new Scanner(System.in);
        System.out.print("Input Jumlah Anak : ");
        this.tunjangan = inputan.nextInt();
        this.tunjangan = tunjangan*100000;
    }
}