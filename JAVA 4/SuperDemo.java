//Box láthatóságának kezelése:
class Box {
	private double width;
	private double height;
	private double length;

//alap konstruktor
	Box() {
		width = 0;
		height = 0;
		length = 0;
	}

//másoló konstruktor
	Box(Box ob) {
		this.length = ob.length;
		this.width = ob.width;
		this.height = ob.height;
	}

//egyenlő oldalú doboz (konstruktor)
Box(double len) {
	length = width = height = len;
}

//3 paraméteres
Box(double width, double length, double height) {
	this.width = width;
	this.length = length;
	this.height = height;
}

//get függvény
	double volume() {
		return width * height * length;
	}

// függvény, amiben be tudjuk állítani ezt a 3at
	void setDim(double w, double h, double l) {
		width = w;
		height = h;
		length = l;
	}

	void setDim(double len) {
		width = length = height = len;
	}
}

class BoxWeight extends Box {
	double weight;
//alapértelmezett konstruktor:
	BoxWeight() {
		super(); //ez hívja a default konstruktorát az ősosztálynak
		weight = 0;
	}

//konstruktor BoxWeight objektummal = 1 paraméteres konstruktor
	BoxWeight(BoxWeight ob) {
		//mivel az ősosztályban a length privát ilyet nem csinálhatunk:
		//length = ob.length; helyette:
		super(ob);
//megjegyzés: ősosztály referencia hivatkozhat származtatott osztályból is
		weight = ob.weight;
	}

	BoxWeight(double w, double l, double h, double m) {

			super(w, l, h);
			weight = m;
	}

	BoxWeight(double len, double m) {
		super(len);
		weight = m;
	}
}

class SuperDemo {

	public static void main(String[] args) {

		BoxWeight weightBox1 = new BoxWeight(10, 20, 30, 5.5);

		double vol = weightBox1.volume();
		System.out.println("weightBox1 vol: " + vol);
		System.out.println("weightBox1 weight: " + weightBox1.weight);


//default konstruktort hívjuk, ami paraméter nélküli, így
//az ősosztály default konstruktorát hívja ( Box() ) az beállítja a 3 értéket
//0-ra. Az lefut, majd a súlyt is beállítja 0-ra.
		BoxWeight weightBox2 = new BoxWeight();

		vol = weightBox2.volume();
		System.out.println("weightBox2 vol: " + vol);
		System.out.println("weightBox2 weight: " + weightBox2.weight);

//1 paraméteres konstruktorral
		BoxWeight weightBox3 = new BoxWeight(10, 3.5);

		vol = weightBox3.volume();
		System.out.println("weightBox3 vol: " + vol);
		System.out.println("weightBox3 weight: " + weightBox3.weight);
		
//másoló konstruktorral (box átadás)
//megjegyzés: az ősreferencián keresztül csak az őstagjai érhetők el
		BoxWeight weightBox4 = new BoxWeight(weightBox1);

		vol = weightBox4.volume();
		System.out.println("weightBox4 vol: " + vol);
		System.out.println("weightBox4 weight: " + weightBox4.weight);
	}
}