//paraméter átadások:

//érték szerinti p.átadás:
class ValueTest {
	//2 integert vár
	void method(int i, int j) {
// az elemi típusok, mint ezek érték szerint másolódnak
		i *= 2; //i-t dublázzuk
		j /= 2; //j-t felezzük
	}
}

//referencia szerinti értékátadás:
class ReferenceTest {
// a user-defined típusok, mint ezek pedig referencia szerint másolódnak
	int a, b; //2 tagváltozó
//konstruktor:
	ReferenceTest(int i, int j) {
		a = i;
		b = j;
	}
//metódus, ami ReferenceTest objektumot vár és ennek az objektumnak a tagjait megváltoztatja
	void method(ReferenceTest obj) {
		obj.a *= 2;
		obj.b /= 2;
	}

}

class ArgPassDemo {
	public static void main(String[] args) {

		ValueTest valOb = new ValueTest(); //létrehozunk valuetest objektumot

		int a = 25, b = 40; // 2 lokális integer létrehozása
		System.out.println("a==" + a + " b==" + b);

		//függvény meghívása:
		valOb.method(a, b); //érték szerinti objektum átadás
		System.out.println("a==" + a + " b==" + b);

		//hívás előtt a tagfüggvény:
		ReferenceTest refOb = new ReferenceTest(25, 40);
		System.out.println("Before call: " + refOb.a + " " + refOb.b);
		//hívjuk a tagfüggvényt önmagára, majd utána is kiírjuk:
		refOb.method(refOb); //itt olyan érték adódik át, ami objektum referencia
		System.out.println("After call: " + refOb.a + " " + refOb.b);

	}
}