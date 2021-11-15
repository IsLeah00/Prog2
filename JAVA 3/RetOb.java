// return object, return value működése:

class Test {
	int a; // primitív tag

//1 paraméteres konstruktor, amivel értéket adunk a tagunknak
	Test(int i) {
		a = i;
	}

//új tagfüggvényt hozunk létre, ami megnöveli ezt az értéket 10-zel és visszaadja
	Test incByTen() {
//átmeneti test típusú objektum temp referenciával, amihez példányt hozunk létre
		Test temp = new Test(a + 10);
		return temp; //referencia átadás user-defined típusoknál
	}
}


class RetOb {
	public static void main(String[] args) {

	// példányt hoztunk létre '10' értékkel:
		Test ob1 = new Test(10);
		Test ob2; //referenciát készítünk
	
	// majd a referenciánknak adjuk meg azt az értéket, amit az ob1 visszaad
		ob2 = ob1.incByTen();

		System.out.println("ob1.a " + ob1.a); //ob1 tagját írjuk ki
		System.out.println("ob2.a " + ob2.a);

	}
}