//kliens része:
import java.net.*;
import java.io.*;

class DemoClient {
	public static void main(String[] args) throws Exception {
	
		Socket socket = new Socket("localhost", 10009);
	
//		DataInputStream dis = new DataInputStream(socket.getInputStream());
		DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
//mivel konzolról olvasunk, ezért kell buffered reader is
//ennek átadunk egy input stream-et, aminek megmondjuk honnan olvasson
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//megjegyzés: buffered reader helyett lehet használni scanner-t is
		String str = "";

		while(!str.equals("stop")) {
			str = br.readLine();
			dout.writeUTF(str);
		}
	dout.close();
	socket.close();
	}
}