//öröklődés demonstrálása Java-ban
class A {
	int i, j;

	void showij() { //metódus, ami kiírja i és j értékét
		System.out.println("i==" + i + " j==" + j);
	}
}

class B extends A { //az A osztályt terjeszti ki
	int k;

	void showk() {
		System.out.println("k==" + k);
	}
//sum függvény kiírja az összegüket
	void sum() {
		System.out.println("i+j+k==" + (i+j+k));
	}

}


class Simpleinheritence {
	public static void main(String[] args) {
		//az ősosztály 1 példányát hozzuk létre
		A superOb = new A();
		//alosztály példányát hozzuk létre
		B subOb = new B();

		//superosztály változóinak adunk értéket kívülről
		superOb.i = 10;
		superOb.j = 20;
		//kiírjuk a szuperosztály tartalmát:
		System.out.println("Contents of superOb: ");
		superOb.showij();


		//subosztály változójának adunk értéket kívülről:
		subOb.k = 30;
//a sum használatakor a szuperosztály változóinak kezdőértéket kell adnunk a subosztályban
		subOb.i = 25;
		subOb.j = 20;
		//kiírjuk a subosztály tartalmát:
		System.out.println("Contents of subOb: ");
		subOb.showij();
		subOb.showk();

		System.out.println("Sum: ");
		subOb.sum();
	}
}