public class NilaiMhs {
    String nim;
    String name;
    Float nilaiUts;
    Float nilaiTgs;
    Float nilaiUas;
    Float pNUts = 0.20f;
    Float pNUas = 0.45f;
    Float pNTgs = 0.35f;
    Float nilaiAkhir;

    Float hitungNilaiAkhir(){
        nilaiAkhir= nilaiUas*pNUas + pNTgs*nilaiTgs + pNUts*nilaiUts;
        return nilaiAkhir;
    }
    void cetakData(){
        System.out.println("|"+nim+" \t|"+name+" \t\t|"+nilaiTgs+" \t|"+nilaiUts+" \t|"+nilaiUas+" \t|"+hitungNilaiAkhir()+" \t|");
        System.out.println("+-----------------------------------------------------------------------+");
    }
}