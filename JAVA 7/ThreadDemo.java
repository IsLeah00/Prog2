//thread, amiben már indítunk egy új szálat:
class NewThread implements Runnable {

	String name; //thread-ek neve
	Thread t;
//nevet itt adjuk át
	NewThread(String n) {
		name = n;
		t = new Thread(this, name); //this: erre az objectre mutasson
		System.out.println("Child thread " + t);
	}

//run metódus mondja meg, hogy mit csináljon a szál
	public void run() {
		try {
			for(int i = 5; i > 0; i--) {
				System.out.println(i);
				Thread.sleep(500);
			} 
		} catch (InterruptedException e) {
			System.out.println(name + " thread interrupted.");

		}
	//kiírjuk, hogy kilépünk ebből a szálból
		System.out.println(name + " thread exiting."); //így látjuk mikor fut le a szál
	}
}


//a NewDemo-t beletesszük egy main thread-be
class ThreadDemo {
	public static void main(String[] args) {
		//új szálat hozunk létre (3 példányt)
		NewThread nt1 = new NewThread("One");
		NewThread nt2 = new NewThread("Two");
		NewThread nt3 = new NewThread("Three");

		//nt osztályban a t-t el kell indítani:
		nt1.t.start(); //ez a run metódust hívja
		nt2.t.start();
		nt3.t.start();
//megjegyzés: a szálak indítása után a main thread-en folytatódik a vezérlés (elindul a try blokk)
	//isAlive() visszaad egy true-false választ
		System.out.println("Thread One is alive: " + nt1.t.isAlive());
		System.out.println("Thread Two is alive: " + nt2.t.isAlive());
		System.out.println("Thread Three is alive: " + nt3.t.isAlive());

		try { /*itt a main most nem számol, hanem vár 10mp-t
				Thread.sleep(10000); */

	//megvárhatjuk, hogy a szálak lefussanak:
		System.out.println("Waiting threads to finish...");
		//join-nal várunk
		nt1.t.join();
		nt2.t.join();
		nt3.t.join();
		} catch (InterruptedException e) {
			System.out.println("Main thread interrupted.");
		}

		System.out.println("Thread One is alive: " + nt1.t.isAlive());
		System.out.println("Thread Two is alive: " + nt2.t.isAlive());
		System.out.println("Thread Three is alive: " + nt3.t.isAlive());

		System.out.println("Main thread exiting.");
	}
}