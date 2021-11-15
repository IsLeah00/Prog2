//Java multithread
//thread elérésére példa:
class CurrentThreadDemo {
	public static void main(String[] args) {
//amin a main fut az a főszál (mainthread):
//ez az a szál, amin létrehozunk új szálakat és ezek fognak párhuzamosan futni
		//szál eléréséhez thread objektumot készítünk:
		Thread t = Thread.currentThread(); //currentThread() static fügvénnyel kérjük el

		System.out.println("Current thread: " + t);
	//nevet állítunk be neki
		t.setName("My first thread");
		System.out.println("After change: " + t);

		//várakoztatjuk ezt a szálat:
		//for ciklusban visszaszámolunk 5-0-ig
		try {
			for(int i = 5; i > 0; i--) {
				System.out.println(i);
				Thread.sleep(1000); //milisec-ben adjuk meg mennyit várakozzon a szál
			} //sleep miatt kell catch blokk
		} catch(InterruptedException e) { //akkor dob, ha valami miatt megállítjuk ezt a szálat
			System.out.println("Main thread interrupted.");
		}
	}
}
