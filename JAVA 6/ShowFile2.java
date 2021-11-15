import java.io.*;

class ShowFile2 {
	public static void main(String[] args) {
		
		int i;

		if(args.length != 1) {
			System.out.println("Usage: ShowFile filename");
			return;
		}

//Java try with resources: zárójelek közé írható az a resource, amire megnyitjuk
//ha hibával lép ki a program, akkor felszabadítja ezeket a 'forrásokat'
		try (FileInputStream fin = new FileInputStream(args[0])) {

			do {
				i = fin.read();
				if (i != -1) System.out.print((char)i);
			} while(i != -1);
		
			fin.close();

		} catch (FileNotFoundException e) {
			System.out.println("File not found: " + e);
		} catch (IOException e) {
			System.out.println("IOException: " + e);
		}
	}
}