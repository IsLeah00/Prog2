//terület számolás
//alakzat ősosztályból leszármaztatunk egy téglalapot és háromszöget
abstract class Figure {

	double dim1, dim2; //hosszúság, szélesség

	Figure(double a, double b) {
		dim1 = a;
		dim2 = b;
	}

//megjegyzés: ősosztályt nem szabad példányosítani, ha grafikus, ezért
//absztrakttá kell tenni az ősosztályt és az ősfüggvényt is
//ez C++-ban pure virtual függvény, Java-ban abstract függvény.
//abstract osztályt NEM LEHET példányosítani
	abstract double area(); //ezt a leszármaztatott osztályban felül kell írni
}


class Rectangle extends Figure {

	Rectangle(double a, double b) {
		super(a, b); //ősosztályból hívjuk őket
	}

//felüldefiniáljuk a terület függvényünket
	double area() { //definiáljuk a téglalap területét
		System.out.println("Inside Rectangle's area()");
		return dim1 * dim2;
	}
}


class Triangle extends Figure {

	Triangle(double a, double b) {
		super(a, b);
	}

//ismét felüldefiniáljuk a terület függvényünket
	double area() {
		System.out.println("Inside Triangle's area()");
		return dim1 * dim2 / 2;
	}
}


class FindAreas {
	public static void main(String[] args) {
		 
	// 2 példányt hozunk létre:
		 Rectangle rect = new Rectangle(5.5, 10.2);
		 Triangle triangle = new Triangle(2.5, 8.5);

	//ősosztály referencia:
		 Figure figref;

	//ősosztály referencián keresztül hívjuk a négyzetet és téglalapot
		 figref = rect;
		 System.out.println("Rect area: " + figref.area());

		 figref = triangle;
		 System.out.println("Triangle area: " + figref.area());
	}
}