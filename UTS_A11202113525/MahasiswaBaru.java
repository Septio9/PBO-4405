package UTS_A11202113525;
public class MahasiswaBaru extends Mahasiswa {
	String asalSekolah;
	
	MahasiswaBaru(String nim, String nama, int semester, int usia,  String krs[], String asalSekolah) {
		super(nim, nama, semester, usia, krs);
		this.asalSekolah = asalSekolah;
	}

	boolean ikutOspek() {
		boolean ospek=true;
		
		return ospek;
	}
	
	void infoMahasiswa() {
		super.infoMahasiswa();
		System.out.println("Asal Sekolah: "+asalSekolah);
	}
}
