//változó argumentum számú függvények
class VarArgs {
//változó argumentum számú függvény, ami integereket vár:
	static void vaTest(int ... v) {
//kiírjuk a tömb méretét és contents-et
		System.out.println("Number of args: " + v.length + ", contents:\n");
//mivel tömb, ezért készíthetünk for range ciklust:
		for(var i : v)
			System.out.println(i + " "); //itt egyenként kiírjuk a tagokat
	}

//metódus túlterhelés:
	static void vaTest(boolean ... v) {
		System.out.println("Number of args: " + v.length + ", contents:\n");

		for(var i : v)
			System.out.println(i + " ");
	}

	static void vaTest(String msg, boolean ... v) {
		System.out.println(msg);
		System.out.println("Number of args: " + v.length + ", contents:\n");

		for(var i : v)
			System.out.println(i + " ");
	}


//main, amiben használhatjuk a függvényt:
	public static void main(String[] args) {
		vaTest(10); //1 paraméterrel hívjuk meg
		vaTest(10,20,30,40,50); //több paraméterrel hívjuk meg
		
		vaTest(true);
		vaTest(false, true, true);

		vaTest("Üzenet", true);
		vaTest("Üzenet", false, true, true);

	}
}