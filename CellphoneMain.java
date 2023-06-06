package week10;

public class CellphoneMain {
    public static void main(String[] args){
        Cellphone cp = new Cellphone("Nokia", "3310");
        cp.volumeUp();
		cp.powerOn();
		System.out.println("Volume : "+cp.getVolume());
		cp.volumeUp();
		cp.volumeUp();
		cp.volumeUp();
		cp.volumeDown();
		System.out.println("Volume : "+cp.getVolume());
		System.out.println("Battery : "+cp.batteryLevel);
		cp.topUpPulsa(25000);
		System.out.println("Pulsa : "+cp.getPulsa());
		cp.addContact("Septio","081234567");
		cp.addContact("ivo","0892313345");
		cp.addContact("Nico","082347283");
		cp.showContact();
		cp.findContact("Nico");
        cp.powerOff();
    }
}