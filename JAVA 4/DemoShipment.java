class Box {
	private double width;
	private double height;
	private double depth;



	Box(Box ob) {
		depth = ob.depth;
		width = ob.width;
		height = ob.height;
	}

Box(double w, double d, double h) {
	width = w;
	depth = d;
	height = h;
	System.out.println("Box constructor");
}

	Box() {
		width = -1;
		height = -1;
		depth = -1;
		System.out.println("Box() constructor");
	}


Box(double len) {
	depth = width = height = len;
}


	double volume() {
		return width * height * depth;
	}
}


// final: amikor egy osztályt már nem lehet kiterjeszteni.
//pl: ha 'final class BoxWeight' lenne, akkor a Shipment-et már nem tudnánk kiterjeszteni belőle
class BoxWeight extends Box {
	
	double weight;

	BoxWeight(BoxWeight ob) {
		super(ob);
		weight = ob.weight;
	}

	BoxWeight(double w, double d, double h, double m) {
			super(w, d, h);
			weight = m;
			System.out.println("BoxWeight constructor");
	}

	BoxWeight() {
		weight = -1;
		System.out.println("BoxWeight() constructor");
	}

	BoxWeight(double len, double m) {
		super(len);
		weight = m;
	}
}


class Shipment extends BoxWeight {

	double cost; //az ára

//másoló konstruktor
	Shipment(Shipment ob) {
		super(ob);
		cost = ob.cost; //cost-ot elkérjük a másolandó objektumból
	}

//alapértelmezett konstruktor
	Shipment() {
		cost = -1;
		System.out.println("Shipment() constructor");
	}

//4 paraméteres konstruktor
	Shipment(double w, double d, double h, double m, double c) {
		super(w, d, h, m);
		cost = c;
		System.out.println("Shipment constructor");
	}
}


class DemoShipment {

	public static void main(String[] args) {

		Shipment ship1 = new Shipment(10, 20, 15, 10, 3.41);
		Shipment ship2 = new Shipment(10, 20, 30, 40, 42);

//érték kiiratás
		double vol;

		vol = ship1.volume(); //térfogat elkérése
		//kiírások:
		System.out.println("Ship1 vol: " + vol);
		System.out.println("Ship1 weight: " + ship1.weight);
		System.out.println("Ship1 cost: " + ship1.cost);


		vol = ship2.volume();

		System.out.println("Ship2 vol: " + vol);
		System.out.println("Ship2 weight: " + ship2.weight);
		System.out.println("Ship2 cost: " + ship2.cost);


		//default konstruktorral példányosítunk:
		Shipment ship3 = new Shipment();
		//másoló konstruktorral:
		Shipment ship4 = new Shipment(ship2);

		vol = ship4.volume();

		System.out.println("Ship4 vol: " + vol);
		System.out.println("Ship4 weight: " + ship4.weight);
		System.out.println("Ship4 cost: " + ship4.cost);
	}
}