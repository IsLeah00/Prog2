//enum alapműködése:
enum Apple {
	Jonathan(10), GoldenDel(9), RedDel, Winesap(15), Cortland(8);
//az enum class Java-ban tartalmazhat más elemeket is
	private int price; //field-eknek adhatunk értéket
//konstruktoron keresztül hajthatjuk végre az értékadás
	Apple(int p) { price = p;}
//default konstruktor, ha az értéket nem ismerjük
	Apple() { price = -1;}
//default miatt hasznos a getPrice()
	int getPrice() { return price; } //visszaadja az értéket

}

class EnumDemo {
	public static void main(String[] args) {

		Apple ap; //apple referencia

		//referenciának adunk értéket
		ap = Apple.Winesap;
		//kiiratjuk
		System.out.println("Value of ap: " + ap);


		ap = Apple.GoldenDel;
		System.out.println("Value of ap: " + ap);

//megmutatja: apple referencia milyen értéket hordoz
		if(ap == Apple.GoldenDel)
			System.out.println("ap contains GoldenDel");
	//az fut le, amelyik az if-ben van
		switch (ap) {
			case Jonathan:
				System.out.println("Jonathan is red.");
				break;
			case GoldenDel:
				System.out.println("GoldenDel is yellow.");
				break;
			case RedDel:
				System.out.println("RedDel is red.");
				break;
			case Winesap:
				System.out.println("Winesap is red.");
				break;
			case Cortland:
				System.out.println("Cortland is red.");
				break;

		}
	//elkérhetjük az összes almát egy tömbben a values taggal
		Apple allApples[] = Apple.values();
		//for ciklussal végig megyünk rajta
		for(var a : allApples)
			System.out.println(a);
										
//érték lekérdezése:
	System.out.println("Price of Winesap: " + Apple.Winesap.getPrice());

//összes lekérdezése:
	for(var a : Apple.values())
		System.out.println(a + " costs " + a.getPrice() + " cents.");

	}
}