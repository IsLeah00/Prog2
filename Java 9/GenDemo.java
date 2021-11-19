//class notáciü:
//class kulcsszó, osztálynév, angled bracket-ek között megadjuk, hogy T típussal szeretnénk ezt a típust paraméterezni
class Gen<T> {
	//osztályon belüli referencia
	T ob;

	Gen(T o) { ob = o; }

	T getOb() { return ob; }

	void showType() {
		System.out.println("Type of ob is " + ob.getClass().getName());
	}
}


class GenDemo {
	public static void main(String[] args) {
		//megadjuk azt a típust, amire használjuk
		Gen<Integer> iOb;

		iOb = new Gen<Integer>(88);

		iOb.showType();

		int i = iOb.getOb();
		System.out.println("Value of i: " + i);
	
	//másik típusra is:
		Gen<String> sOb = new Gen<String>("string type");

		sOb.showType();

		String str = sOb.getOb();
		System.out.println("Value of str is: " + str);
	}
}