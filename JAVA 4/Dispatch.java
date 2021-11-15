//futás idejű polimorfizmus Java-ban: futási időben 
//dől el az, hogy melyik objektumnak a függvényét fogja hívni
//dynamic method dispatch
class A {
	void callme() {
		System.out.println("This is A's callme()");
	}
}

class B extends A {
	void callme() {
		System.out.println("This is B's callme()");
	}
}

class C extends B {
	void callme() {
		System.out.println("This is C's callme()");
	}
}

class Dispatch {
	public static void main(String[] args) {
		
		A a = new A();
		B b = new B();
		C c = new C();

		//ősreferenciát készítünk:
		A r;
		//majd ráállítjuk minden egyes objektumunkat:
		r = a;
		r.callme(); // az ősreferencián keresztül hívjuk a callme függvényt típusonként (a, b és c)

		r = b;
		r.callme();

		r = c;
		r.callme();
	}
}