//metódus felülírás Java-ban
class A {
	int i, j;

	A(int i, int j) { //kontruktor, amivel ezeket inicializálhatjuk (értéket adhatunk)
		this.i = i;
		this.j = j;
	}

	//metódus, amivel ezeket kiírjuk
	void show() {
		System.out.println("i==" + i + " j==" + j);
	}
}

//B osztály, ami kiterjeszti A-t
class B extends A {
	int k;

	B(int i, int j, int k) {
		super(i, j); //nem fontos, mert i és j nem privát
		this.k = k;
	}

//itt felülírjuk a show függvényt, kiírjuk az értékeket:
//megjegyzés: virtual-t nem kell kiírnunk, mert itt ez az alapértelmezett
	void show() { //B show függvénye
		super.show(); //ősosztály show tagfüggvényét hívjuk (A osztály)
		System.out.println("k==" + k);
	}
}


class Override {
	public static void main(String[] args) {
		
		B subOb = new B(1, 2, 3);

		subOb.show();
	}
}