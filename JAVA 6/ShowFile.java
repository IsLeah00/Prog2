//Jellegzetes Java fájlkezelő példa hibakezeléssel
//Megnyit egy fájlt és kiírja a tartalmát
import java.io.*; //input-output eszköz beimportálás

class ShowFile {
	public static void main(String[] args) {
		
		int i; //ebbe olvasunk karaktereket

	// a fájlnevet parancs reargumentummal adjuk át
		if(args.length != 1) {	//ha nem adunk meg argumentum length-et, akkor adjon hibaüzenetet
			System.out.println("Usage: ShowFile filename");
			return;
		}

		try {
			//a file input stream konstruktorának adjuk át a fájlnevet, amit parancs reargumentumként megadtunk
			FileInputStream fin = new FileInputStream(args[0]);
		//fájl beolvasása:
			do {
				i = fin.read(); //read fügvénnyel
			//ha a fájl végére értünk, akkor írjuk ki:
				if (i != -1) System.out.print((char)i);
			} while(i != -1);
		} catch (FileNotFoundException e) {
			System.out.println("File not found: " + e);
		} catch (IOException e) { //olvasási hiba
			System.out.println("IOException: " + e);
		}
	}
}
//használata: java ShowFile (utána a fájl, amit ki akarunk iratni pl.:) Exc2.java