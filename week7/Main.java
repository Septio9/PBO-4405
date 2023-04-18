public class Main {
    public static void main(String[] args){
        KaryawanKontrak kontrak1 = new KaryawanKontrak();
        KaryawanTetap Tetap1 = new KaryawanTetap();
        
        System.out.println(" Inputan Karyawan Tidak Tetap ");
        kontrak1.GajiHarian();
        kontrak1.cetak();

        System.out.println(" Inputan Karyawan Tetap ");
        Tetap1.GajiTetap();
        Tetap1.cetak();
    }
}