import java.util.*;
import java.util.stream.*;

class StreamDemo {
	public static void main(String[] args) {
		
		ArrayList<Integer> myList = new ArrayList<>();
		myList.add(7);
		myList.add(10);
		myList.add(3);
		myList.add(24);
		myList.add(30);
		myList.add(2);

		System.out.println("Original list: " + myList);
		//erre elkérünk egy stream-et, amiben megadjuk, hogy integer-ekkel dolgozunk
		Stream<Integer> myStream = myList.stream();

		//integer compare predikátumot adunk át
		//min értéket adja vissza
		Optional<Integer> minVal = myStream.min(Integer::compare); 
//OPtional: 1 értéket tárol, ha nem tárol semmit, akkor üres (lekérdezhetjük)
//min: terminális művelet, felemészti a stream-ünket
		if(minVal.isPresent()) System.out.println("Minval: " + minVal.get());

		myStream = myList.stream();
		Optional<Integer> maxVal = myStream.max(Integer::compare); 
		if(maxVal.isPresent()) System.out.println("Maxval: " + maxVal.get());


//sorted stream
		Stream<Integer> sortedStream = myList.stream().sorted();
		System.out.println("Sorted stream: ");
		//ennek a stream osztálynak a for each függvényes kiíratása
		sortedStream.forEach((n) -> System.out.print(n + " "));
		System.out.println();

//páros értékek
		Stream<Integer> oddVals = myList.stream().sorted().filter((n) -> (n % 2) == 1);
		oddVals.forEach((n) -> System.out.print(n + " "));
		System.out.println();

//sorted nélkül kérjünk el egy újabb stream-et
		oddVals = myList.stream()
		//szűrjük a párosakra és azokra, amik nagyobb, mint 5
			.filter((n) -> (n % 2) == 0)
			.filter((n) -> (n > 5));
		oddVals.forEach((n) -> System.out.print(n + " "));
		System.out.println();

	}
}