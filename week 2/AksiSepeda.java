public class AksiSepeda {
    public static void main(String[] args) {
     //membuat objek
     Sepeda sepedaBalap = new Sepeda();
    
     //mengakses atribut dan method
     int gearSepeda = sepedaBalap.gear;
     System.out.println(gearSepeda);
     sepedaBalap.ngerem();
     }
}