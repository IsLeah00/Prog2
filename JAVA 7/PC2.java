//segédváltozó bevezetése, amivel megmondhatjuk be van-e állítva az érték vagy sem
class Q {
	int n;
	boolean valueSet = false;

	synchronized int get() {
//ameddig nem végeztünk, addig várjunk:
		while(!valueSet) {
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println("InterruptedException");
			}
		}
//ha a value be van állítva, akkor kiírjuk
		System.out.println("Get: " + n);
		valueSet = false; //ezzel jelezve a másik szálnak, hogy betehet értéket
		notify(); //jelzi a másik szálnak, hogy beírhat
		return n;
	}

	synchronized void put(int n) {
		while(valueSet) {
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println("InterruptedException");
			}
		}
		this.n = n;
		valueSet = true; //jelezve, hogy foglalt az érték
		System.out.println("Put: " + n);
		notify();
	}
}

class Producer implements Runnable {
	Q q;
	Thread t;

	Producer(Q q) {
		this.q = q;
		t = new Thread(this, "Producer thread");
	}

	public void run() {
		int i = 0;
		while(true)
			q.put(i++);
	}
}

class Consumer implements Runnable {
	Q q;
	Thread t;

	Consumer(Q q) {
		this.q = q;
		t = new Thread(this, "Consumer thread");
	}

	public void run() {
		while(true)
			q.get();
	}
}

class PC2 {
	public static void main(String[] args) {
		
		Q q = new Q();

		Producer p = new Producer(q);
		Consumer c = new Consumer(q);

		p.t.start();
		c.t.start();

		System.out.println("Ctrl+C to stop");

	}
}