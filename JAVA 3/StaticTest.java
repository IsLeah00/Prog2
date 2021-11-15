class StaticDemo { //tagokat írunk
// ha a CallMe függvény statikus, akkor a változóknak (a,b) is statikusnak kell lennie
//különben nem lesznek benne a memóriában	
	static int a = 7;
	static int b = 8;

	//metódus, ami visszaad 1 integert és vár 1 paramétert
	static int callMe(int param) {
		return a * b * param;
	}

}

class UseClass { //main osztály, ebben használjuk a StaticDemo osztályt
//static: olyan függvény, ami akkor is benne van a memóriában, ha az objektumot
//nem példányosítjuk. Main-nél fontos, mert a class példányosulása előtt futtatja
//a futtató környezet.
//A class és main közé is kerülhetnek static tagok, amelyeket a class betöltődése előtt futtat a környezet.
	static int a = 10;
	static int b;

	static void method(int x) {
		System.out.println("a==" + a);
		System.out.println("b==" + b);
		System.out.println("x==" + x);
	}

	static {
		System.out.println("Static block init");
		b = a * 10;
	}


	public static void main(String[] args) {
//változó, amit átadunk majd paraméterül a callMe függvénynek
		int theAnswer = 42;
//hívjuk a callMe függvényt, majd írjuk ki az eredményt
		System.out.println(StaticDemo.callMe(theAnswer));

		method(42); //a statikus metódusnak adtunk át értéket
	}
}