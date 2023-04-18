import java.util.Scanner;

class KaryawanKontrak extends Karyawan{
    int GajiHarian;
    int jmlhHadir;
    int Total;

    public void GajiHarian(){
        Scanner inputan = new Scanner(System.in);
        System.out.print("Input Gaji Harian : ");
        this.GajiHarian = inputan.nextInt();
        System.out.print("Input Jumlah Hadir : ");
        this.jmlhHadir = inputan.nextInt();
        tunjanganAnak();
        Total = ((GajiHarian * jmlhHadir)+tunjangan);
    }

    public void cetak(){
        System.out.println("///CETAK///");
        System.out.println("Gaji Harian : "+GajiHarian);
        System.out.println("Jumlah Hadir : "+jmlhHadir);
        System.out.println("Gaji Total : "+Total);
        System.out.println("");
    }
}