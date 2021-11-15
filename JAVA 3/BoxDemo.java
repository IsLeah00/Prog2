class Box {
	double width;
	double height;
	double length;

//default konstruktor:
	//itt általában kinullázzuk
	Box() {
		width = 0;
		height = 0;
		length = 0;
	}

//paraméterezve átadunk neki box típusú objektumot: ez a másoló konstruktor
	Box(Box ob) {
		this.length = ob.length; //this = self (saját) referencia
		this.width = ob.width;
		this.height = ob.height;
	}

// hosszúság értéket adunk meg, ami az összesnek értéket ad (--> kocka)
// double paraméteres konstruktor:
Box(double len) {
	length = width = height = len;
}

//3 paraméteres konstruktor:
Box(double width, double length, double height) {
	this.width = width;
	this.length = length;
	this.height = height;
}


//függvényhíváshoz kell:
	double volume() {
		return width * height * length;
	}

//tagok értékeinek változtatása:

	//függvény túlterhelés
	//függvény szignatúrája a név és a paraméter lista, ez azonosítja egyedileg a függvényt Java-ban
	void setDim(double w, double h, double l) {
		width = w;
		height = h;
		length = l;
	}
// ugyanez csak egyparaméteressel:
	void setDim(double len) {
		width = length = height = len;
	}
}


class BoxDemo {

	public static void main(String[] args) {

		// szétbontjuk a Box myBox1 = new Box(); -t :
		Box myBox1; //létrehozzuk a példányt
		//myBox1 az egy referencia amit ráállítunk a new objektumra
		myBox1 = new Box(); //fizikai memóriát foglalunk neki a new-val (default konstruktor teszi meg)
// mivel a new Box()-ra nincs másik referencia, ezért a scoop végén magától felszabadul
// Java virtual garbage collectora szabadítja fel

		myBox1.width = 10;
		myBox1.height = 20;
		myBox1.length = 30;

		/* double vol = myBox1.width * myBox1.height * myBox1.length; -->
		ha nem függvényhívással számolnánk*/
//függvényhívás:
		double vol = myBox1.volume();

		System.out.println("myBox1 volume is " + vol);
	
		Box myBox2 = new Box(myBox1); //másol 1 box-ot
		System.out.println("myBox2 volume is " + myBox2.volume());

		Box myBox3 = new Box(10.0);
		System.out.println("myBox3 volume is " + myBox3.volume());

		Box myBox4 = new Box(10.0, 20.0, 30.0);
		System.out.println("myBox4 volume is " + myBox4.volume());

		myBox4.setDim(10.0);
		System.out.println("myBox5 volume is " + myBox4.volume());

		myBox4.setDim(10.0, 15.0, 20.0);
		System.out.println("myBox6 volume is " + myBox4.volume());
	}
}