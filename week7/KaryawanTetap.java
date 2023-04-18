import java.util.Scanner;

public class KaryawanTetap extends Karyawan{
    int GajiTetap;
    int Total;

    public void GajiTetap(){
        Scanner inputan = new Scanner(System.in);
        System.out.print("Input Gaji Tetap : ");
        this.GajiTetap = inputan.nextInt();
        tunjanganAnak();
        Total = (GajiTetap+tunjangan);
    }

    public void cetak(){
        System.out.println("///CETAK///");
        System.out.println("Gaji Tetap : "+GajiTetap);
        System.out.println("Gaji Total : "+Total);
        System.out.println("");
    }
}