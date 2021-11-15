import java.io.*;

class ShowFile3 {
	public static void main(String[] args) {
		
		int i;

		if(args.length != 2) {
			System.out.println("Usage: ShowFile inputFilename outputFilename");
			return;
		}

		try (FileInputStream fin = new FileInputStream(args[0]);
			FileOutputStream fout = new FileOutputStream(args[1])) {

			do {
				i = fin.read();
				if (i != -1) fout.write(i);
			} while(i != -1);
		

		} catch (FileNotFoundException e) {
			System.out.println("File not found: " + e);
		} catch (IOException e) {
			System.out.println("IOException: " + e);
		}
	}
}
//használata pl: Jegyzet.txt-re: java ShowFile3 Jegyzet.txt output.txt
							//   more output.txt