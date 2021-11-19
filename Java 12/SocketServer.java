//socket szerver-kliens példa: (android miatt)
//server része:
import java.net.*;
import java.io.*;

class SocketServer {
	public static void main(String[] args) throws Exception {
// 1000-nél nagyobbnak kell lennie (azalatt a well-known port-ok vannak)
		ServerSocket serverSocket = new ServerSocket(10009);
//ha kliens akar csatlakozni, akkor server accept függvényét hívjuk és azzal
//tudjuk fogadni, majd ahhoz hozzáadunk egy hálózati végpontot, hogy a server
//azon keresztül tudjon kommunikálni a klienssel
		Socket clientSocket = serverSocket.accept();
//stream: ha érkezik a socket-eken üzenet azt tudja fogadni és kiírni
		DataInputStream dis = new DataInputStream(clientSocket.getInputStream());
//stream: üzenet küldéshez
//		DataOutputStream dout = new DataOutputStream(clientSocket.getOutputStream());
		
		String str = "";
//kiírjuk a kliens üzeneteket ameddig egy stop-ot nem küldünk
		while(!str.equals("stop")) {
//eltároljuk a data input stream függvényét, ami unicode formátumú string-et olvas
			str = dis.readUTF();
		//kiírjuk
			System.out.println("Client says: " + str);
		}
		
		dis.close();
	//lezárjuk a socket-eket is
		clientSocket.close();
		serverSocket.close();
	}
}