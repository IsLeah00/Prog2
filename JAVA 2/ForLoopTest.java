class ForLoopTest {

	public static void main(String[] args) {
//for ciklus 0-9ig, x a ciklusváltozó

		int x; //külső deklarálása a változónak, lokális változó

		for(x = 0; x < 10; x++)	//belső deklarálás, így lesz ciklusváltozó
			System.out.println("Value of x is " + x);

		int y = 20;

//így az y értékét is növelhetjük
		for(x = 0; x < 10; x++, y++) {
			System.out.println("This is x " + x);
			System.out.println("This is y " + y);
		}
	}
}