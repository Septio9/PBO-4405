package UTS_A11202113525;
import java.util.Scanner;

public class Mahasiswa {
	String nim, nama, krs[];
	int semester, usia;
	
	Mahasiswa (String nim, String nama, int semester, int usia, String krs[]){
		this.nim = nim;
		this.nama = nama;
		this.semester = semester;
		this.usia = usia;
		this.krs = krs;
	}
	
	float hitungRataNilai(int nilai[]) {
		float hasil;
		int total=0;
		
		for (int i = 0; i < nilai.length; i++) {
            total += nilai[i];
        }
        
        hasil = (float) total / nilai.length;
		
		return hasil;
	}
	
	void infoMahasiswa() {
		System.out.println("NIM: "+nim);
		System.out.println("Nama: "+nama);
		System.out.println("Semester: "+semester);
		System.out.println("Usia: "+usia);
	}
	
	void infoKrsMahasiwa() {
		int krsLength = krs.length;
		
		for (int i=0;i < krsLength;i++) {
			System.out.println((i+1) + ". "+krs[i]);
		}
	}
}
