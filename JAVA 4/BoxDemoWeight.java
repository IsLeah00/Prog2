//Box, aminek meg tudjuk adni a súlyát is:
class Box {
	double width;
	double height;
	double length;


	Box() {
		width = 0;
		height = 0;
		length = 0;
	}


	Box(Box ob) {
		this.length = ob.length;
		this.width = ob.width;
		this.height = ob.height;
	}


Box(double len) {
	length = width = height = len;
}

Box(double width, double length, double height) {
	this.width = width;
	this.length = length;
	this.height = height;
}


	double volume() {
		return width * height * length;
	}


	
	void setDim(double w, double h, double l) {
		width = w;
		height = h;
		length = l;
	}

	void setDim(double len) {
		width = length = height = len;
	}
}

//class, amiben benne van a súly is:
class BoxWeight extends Box {
	double weight; //súlya

//konstruktor, amiben 3 double-t adunk át
	BoxWeight(double w, double l, double h, double m) { //m a súly 
//a super() metódust használva láthatjuk el az ősosztály tagjait értékekkel, így nem kell külön-külön kiírni a tagokat
/* Tehát ezek helyett:
			width = w;
			length = l;
			height = h; 
Így adjuk meg:			*/
			super(w, l, h);
			weight = m;
	}
}

class BoxDemoWeight {

	public static void main(String[] args) {

		// 2 fajta dobozt készítünk:
		BoxWeight weightBox = new BoxWeight(10, 20, 30, 5.5);
	//	BoxWeight box2 = new BoxWeight(10.5, 5, 3.8, 5.5);
	// a fenti helyett egy nulla térfogatú dobozt hozunk létre:
		Box plainBox = new Box();


//doboz térfogatát kérdezzük le:
		double vol = weightBox.volume();
		System.out.println("weightBox vol: " + vol);
		System.out.println("weightBox weight: " + weightBox.weight);

		//plainBox-ra állítottuk át a weightBox referenciát:
		//ebben az esetben ha használni akarunk 1 objektumot, akkor nem az objektum típusa
		//számít, hanem a referencia típusa
		plainBox = weightBox;

		vol = plainBox.volume();
		System.out.println("plainBox vol: " + vol);
/*kommitoljuk, hisz nincs súlya:
		System.out.println("plainBox weight: " + plainBox.weight); */
		
	}
}