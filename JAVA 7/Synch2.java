//megoldása a Synch-nek: 
//ami a monitorba be fog menni, arra tudjuk azt írni, hogy legyen szinkronizált
class Callme {
//a függvényt is szikronizálttá tehetjük:
	/*synchronized*/ void call(String msg) { //ameddig 1 szál TELJESEN le nem fut addig a többi vár rá
		System.out.print("[" + msg);
		try {
			Thread.sleep(1000);
		} catch(InterruptedException e) {
			System.out.println("Callme thread interrupted");
		}
		System.out.println("]");
	}
}

class Caller implements Runnable {
	String msg;
	Callme target;
	Thread t;

	public Caller(Callme targ, String s) {
		target = targ;
		msg = s;
		t = new Thread(this);
	}
//vagy magát a blokkot is szinkronizálttá tehetjük:
	public void run() {
		synchronized(target) {
		target.call(msg);
		}
	}
}

class Synch2 {
	public static void main(String[] args) {
		
		Callme target = new Callme();

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