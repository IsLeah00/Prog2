//parancsok a fájlra:	mkdir mypack
					//  mv AccountTest.java mypack/
//lefordítjuk: javac mypack/AccountTest.java és futtatjuk: java mypack.AccountTest
//ezután újranyitjuk a fájlt a mypack mappából, mivel idekerült
//package-k célja, hogy a névütközéseket elkerüljük.
//Használatára példa:
package mypack;

class Balance { //banki egyenlegeket fog kiírni
	String name;
	double bal;

//default konstruktor:
	Balance(String name, double bal) {
		this.name = name;
		this.bal = bal;
	}

//kiiratáshoz:
	void show() {
		if(bal < 0)
			System.out.println("-->");
		System.out.println(name + ": $" + bal);
	}
}


class AccountTest {
	public static void main(String[] args) {
		
	//saját típusból készítünk tömböt:
		Balance current[] = new Balance[3];

		current[0] = new Balance("Attila", 100.32);
		current[1] = new Balance("János", 45.01);
		current[2] = new Balance("István", 13.06);

	//for ciklussal végig megyünk a tömb elemein
		for(int i = 0; i < 3; i++) current[i].show();
	}
}