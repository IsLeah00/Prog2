//bounded wildcard működésére példa
//koordináta rendszerek reprezentálása 
//(1, 2, 3, 4 dimenziósok) és ezeket fogjuk egymásból örököltetni

//ősosztály:
class TwoD {
	int x, y;
//konstruktor, amivel elkészítjük:
	TwoD(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
//TwoD-ből öröklődik
class ThreeD extends TwoD {
	int z;

	ThreeD(int x, int y, int z) {
		super(x, y); //hívjuk az ősosztály konstruktorát x, y -ra
		this.z = z; //eltároljuk z-t
	}
}

class FourD extends ThreeD {
	int t;

	FourD(int x, int y, int z, int t) {
		super(x, y, z);
		this.t = t;
	}
}

//olyan paraméter típust vár, aminek az ősei a TwoD
class Coords<T extends TwoD> {
	T[] coords;

	Coords(T[] o) { coords = o; }
}


class BoundedWildCard {
	//függvények:
	//kiírja x, y koordinátát
	static void showXY(Coords<?> c) {
		System.out.println("X Y Coords: ");
		for(int i = 0; i < c.coords.length; i++)
			System.out.println(c.coords[i].x + " " + c.coords[i].y);
	}

	//kiírja x, y, z-t
	static void showXYZ(Coords<? extends ThreeD /*upper bound*/ > c) {
		System.out.println("X Y Z Coords: ");
		for(int i = 0; i < c.coords.length; i++)
			System.out.println(c.coords[i].x + " " + c.coords[i].y + " " + c.coords[i].z);
	}

	//kiírja x, y, z, t-t
	static void showXYZT(Coords<? extends FourD> c) {
		System.out.println("X Y Z T Coords: ");
		for(int i = 0; i < c.coords.length; i++)
			System.out.println(c.coords[i].x + " " + c.coords[i].y + " " + c.coords[i].z + " " + c.coords[i].t);
	}


	public static void main(String[] args) {
		//2D-re
		TwoD td[] = {
			new TwoD(0,0),
			new TwoD(5,9),
			new TwoD(10,10),
			new TwoD(7,1)
		};

		Coords<TwoD> tdCoords = new Coords<TwoD>(td);
		showXY(tdCoords);

		//4D-re
		FourD fd[] = {
			new FourD(0,0,0,0),
			new FourD(5,9,10,5),
			new FourD(10,10,6,7),
			new FourD(7,1,0,4)
		};

		Coords<FourD> fdCoords = new Coords<FourD>(fd);
		showXY(fdCoords);
		showXYZ(fdCoords);		
		showXYZT(fdCoords);

	}
}