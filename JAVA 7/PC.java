//Producer Consumer = PC
//adatot tartalmazó osztály, olvasás-írás függvénnyel
class Q {
	int n; //adat

	//írás-olvasás 2 külön szálon fog futni
	synchronized int get() {
		System.out.println("Get: " + n);
		return n; //mivel még használni fogjuk
	}

	synchronized void put(int n) {
		this.n = n; //értékül adjuk a lokális változónknak
		System.out.println("Put: " + n);
	}
}

class Producer implements Runnable {
	Q q; //Q referencia
	Thread t;

	Producer(Q q) { //termelő megkapja a q referenciát
		this.q = q;
		t = new Thread(this, "Producer thread");
	}

//Producer mindig növeli q értékét eggyel
	public void run() {
		int i = 0;
		while(true)
			q.put(i++);
	}
}

//megkapja a q referenciát, lesz saját szála
class Consumer implements Runnable {
	Q q;
	Thread t;

	Consumer(Q q) {
		this.q = q;
		t = new Thread(this, "Consumer thread");
	}

//Consumer olvassa a q-t
	public void run() {
		while(true)
			q.get();
	}
}

//main class:
class PC {
	public static void main(String[] args) {
		
		Q q = new Q();
//Producer-nek és a Consumer-nek is átadjuk a q referenciát
		Producer p = new Producer(q);
		Consumer c = new Consumer(q);

		p.t.start();
		c.t.start();

		System.out.println("Ctrl+C to stop");

	}
}