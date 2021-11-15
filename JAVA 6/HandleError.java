//Kivételkezelés:
//random számokat generálunk, majd abból fogunk hiabkezelni (aritmetikai kivételkezelés)
import java.util.Random;

class HandleError {
	public static void main(String[] args) {
		
		int a = 0, b = 0, c = 0;
	//random osztály, aminek a segítségével fogunk számokat generálni
		Random r = new Random();
	//for ciklussal generáljuk őket:
		for(int i = 0; i < 32000; ++i) {
			try {
				//generálunk b-re random számot:
				b = r.nextInt();
				//majd c-re
				c = r.nextInt();
				//random számolást végzünk
				a = 12345 / (b/c);
			} catch (ArithmeticException e) {	//kivételkezelés
				System.out.println("Exception: " + e);
				a = 0; //ha hibát talál az 'a'-t 0-ra állítja
			}
			//ha nem talál hibát:
			System.out.println("a==" + a);
		}
	}
}