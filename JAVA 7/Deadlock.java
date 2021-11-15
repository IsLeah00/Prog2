class A {
// b referenciát adunk át az A-nak
	synchronized void foo(B b) {
	//elkérjük a szálnak a nevét	
		String name = Thread.currentThread().getName();
	//kiírjuk, hogy beléptünk A-ba
		System.out.println(name + " entered A.foo...");
	//altatjuk
		try {
			Thread.sleep(1000);
		} catch(InterruptedException e) {
			System.out.println("InterruptedException");
		}
	//meghívjuk B last()-jét
	System.out.println(name + " calling B.last()");
	b.last(); //utolsó fügvény, amit meghívunk
	}
	//megírjuk A last()-jét
	synchronized void last(){
		System.out.println("We are in A.last()");
	}
}


class B {
	synchronized void bar(A a){

		String name = Thread.currentThread().getName();
	
		System.out.println(name + " entered B.bar...");

		try {
			Thread.sleep(1000);
		} catch(InterruptedException e) {
			System.out.println("InterruptedException");
		}
	
	System.out.println(name + " calling A.last()");
	a.last();
	}

	synchronized void last(){
		System.out.println("We are in B.last()");
	}
}


//main class:
class Deadlock implements Runnable {
	A a = new A();
	B b = new B();
	Thread t;

	Deadlock() {
		Thread.currentThread().setName("Mainthread");
		t = new Thread(this, "RacingThread"); //erőforrásokért versengő szál
	}
	
//függvény, amiben ezt elindítjuk
	void deadlockStart() {
		t.start();
		a.foo(b); //elindítjuk az 'a' foo-ját 'b' referenciára
		System.out.println("Mainthread");
	}

//Runnable miatt kell run() metódus
	public void run() {
		b.bar(a);
		System.out.println("Otherthread");
	}

	public static void main(String[] args) {
		
		Deadlock dl = new Deadlock();
		dl.deadlockStart();
	}
}
//megjegyzés: egymás szinkronizált függvényeit hívtuk meg, ezért arra várnak, hogy
//mindketten kilépjenek abból az állapotból és belépjenek a monitorba.