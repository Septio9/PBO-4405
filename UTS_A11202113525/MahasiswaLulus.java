package UTS_A11202113525;
public class MahasiswaLulus extends Mahasiswa {
	int tahunWisuda;
	float ipk;
	
	MahasiswaLulus(String nim, String nama, int semester, int usia,  String krs[], int tahunWisuda, float ipk) {
		super(nim, nama, semester, usia, krs);
		this.tahunWisuda = tahunWisuda;
		this.ipk = ipk;
	}
	
	boolean ikutWisuda() {
		boolean wisuda=true;
		
		return wisuda;
	}
	
	void infoMahasiswa() {
		super.infoMahasiswa();
		System.out.println("Tahun Wisuda: "+tahunWisuda);
		System.out.println("IPK: "+ipk);
	}
}
