class NewThread implements Runnable {

	Thread t;

	NewThread() {
		t = new Thread(this, "Demo thread");
		System.out.println("Child thread " + t);
	}

//static függvény, ami NewThread referenciát ad vissza
	public static NewThread createAndStart() { 
	//elkészít egy NewThread objektumot
		NewThread myNewThr = new NewThread();
	//elindítja
		myNewThr.t.start();
	//visszaadja a refernciát a NewThread objektumra
		return myNewThr;
	}


	public void run() {
		try {
			for(int i = 5; i > 0; i--) {
				System.out.println(i);
				Thread.sleep(500);
			} 
		} catch (InterruptedException e) {
			System.out.println("Child thread interrupted.");
		}
	System.out.println("Child thread exiting.");
	}
}


class ThreadFactoryDemo {
	public static void main(String[] args) {

/*ezek helyett vektori függvényt használunk:
		NewThread nt1 = new NewThread("One");
		NewThread nt2 = new NewThread("Two");
		NewThread nt3 = new NewThread("Three");

		nt1.t.start();
		nt2.t.start();
		nt3.t.start();	vagyis: */

		NewThread nt = NewThread.createAndStart();

/* nem kell elindítani, mert a creatAndStart indítja
		System.out.println("Thread One is alive: " + nt1.t.isAlive());
		System.out.println("Thread Two is alive: " + nt2.t.isAlive());
		System.out.println("Thread Three is alive: " + nt3.t.isAlive());

		try {

		System.out.println("Waiting threads to finish...");

		nt1.t.join();
		nt2.t.join();
		nt3.t.join();
		} catch (InterruptedException e) {
			System.out.println("Main thread interrupted.");
		}

	System.out.println("Thread One is alive: " + nt1.t.isAlive());
		System.out.println("Thread Two is alive: " + nt2.t.isAlive());
		System.out.println("Thread Three is alive: " + nt3.t.isAlive()); 
*/

		try {
			for(int i = 5; i > 0; i--) {
				System.out.println(i);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			System.out.println("Main thread interrupted.");
		}
		System.out.println("Main thread exiting.");
	}
}