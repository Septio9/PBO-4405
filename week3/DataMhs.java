public class DataMhs{
    String nim,nama;
    float nilaitgs,nilaiuts,nilaiuas,nilaiakhir;
    public Object tampilData;

    public void Datanilai(String nim, String nama, float nilaitgs,float nilaiuts, float nilaiuas){
        this.nim=nim;
        this.nama=nama;
        this.nilaitgs=nilaitgs;
        this.nilaiuts=nilaiuts;
        this.nilaiuas=nilaiuas;
        this.nilaiakhir=nilaiakhir;
    }

    void tampilData(){
        float persenTgs= this.nilaitgs*30/100;
        float persenUts= this.nilaiuts*35/100;
        float persenUas= this.nilaiuas*35/100;
        nilaiakhir=persenTgs+persenUas+persenUts;
        System.out.println("NIM     : "+this.nim);
        System.out.println("Nama    : "+this.nama);
        System.out.println("N.Tugas : "+this.nilaitgs+" 30%   : "+persenTgs);
        System.out.println("N.UTS   : "+this.nilaiuts+" 35%   : "+persenUts);
        System.out.println("N.UAS   : "+this.nilaiuas+" 35%   : "+persenUas);
        System.out.println("N.Akhir : "+this.nilaiakhir);

        if(nilaiakhir>=75){
            System.out.println("Lulus");
        }else{
            System.out.println("Tidak Lulus");
        }
        
    }
}