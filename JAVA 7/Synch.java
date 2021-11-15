//több szálon futó program, ami hibás
//üzenetküldő program egy másik szálnak, ami kiírja ezeket az üzeneteket:
//3 különböző szálon fogjuk traumatizálni azt a szálat, ami kiír
//osztály, ami kiír:
class Callme { //Java: monitoros megoldás (ameddig egy szál használja addig a többi nem léphet bele)
	void call(String msg) { //call függvénynek adjuk át az üzeneteket
		System.out.print("[" + msg);
		try {
			Thread.sleep(1000);
		} catch(InterruptedException e) {
			System.out.println("Callme thread interrupted");
		}
		System.out.println("]");
	}
}

//caller osztály készít egy szálat, ami hívni fogja a call függvényt
class Caller implements Runnable {
	String msg; //üzenet
	Callme target; //végzi a kiírást
	Thread t; //szál, amin fut a callme

	public Caller(Callme targ, String s) {
		target = targ;
		msg = s;
		t = new Thread(this);
	}

	//run metódusban hívjuk a target call függvényét az üzenetre
	//ez fogja külön szálon futtatni a kiírást
	public void run() {
		target.call(msg);
	}
}

//main class
class Synch {
	public static void main(String[] args) {
		
		Callme target = new Callme();
	//konkurensen futó szálak nem foglalkoznak egymással

		Caller c1 = new Caller(target, "Hello");
		Caller c2 = new Caller(target, "synchronized");
		Caller c3 = new Caller(target, "world");

		c1.t.start();
		c2.t.start();
		c3.t.start();
	
		try {

		c1.t.join();
		c2.t.join();
		c3.t.join();
		} catch(InterruptedException e) {
			System.out.println("Main interrupted.");
		}
	}
}
//a kimenetét hívjuk 'data race'-nek: 
//amikor valamilyen adathoz konkurensen akarunk elérni (ugyanahhoz az erőforráshoz akarunk elérni)
//a szálak versengenek, hogy ki tudja használni