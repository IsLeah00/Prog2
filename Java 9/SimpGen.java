//továbbfejlesztése
//több paramétert adunk a típusunkhoz
class TwoGen<T, V> {
	T ob1;
	V ob2;

	TwoGen(T o1, V o2) { 
		ob1 = o1; 
		ob2 = o2;
	}

	T getOb1() { return ob1; }
	
	V getOb2() { return ob2; }

	void showType() {
		System.out.println("Type of ob1 is " + ob1.getClass().getName());
		System.out.println("Type of ob2 is " + ob2.getClass().getName());
	}
}


class SimpGen {
	public static void main(String[] args) {
		TwoGen<Integer, String> complexOb = new TwoGen<Integer, String>(88, "string type");

		complexOb.showType();

		int i = complexOb.getOb1();
		String str = complexOb.getOb2();

		System.out.println("Value of i: " + i);
		System.out.println("Value of str: " + str);
	
	}
}