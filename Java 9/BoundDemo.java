//Java-ban upper bound-okat tudunk adni, ami az osztályhierarchiával függ össze.
//Tehát megmondhatjuk, hogy egy adott T típusnak mi az upper bound-ja (= ősosztálya),
//aminek a leszármazottja kell legyen (ha nem adjuk meg, akkor az Object az ősosztály).

//statot számoló példa rá:
//T típus paraméternek az ősosztálya a Number kell legyen,
//ilyenkor egy numerikus type wrapper osztály lesz a T
class Stats<T extends Number> {

	T[] numb;

	Stats(T[] o) { numb = o; }
//átlag számolás
	double average() {
		double sum = 0.0;

		for(int i = 0; i < numb.length; i++)
//double value-ként kérjük el az i-edik elemet
			sum += numb[i].doubleValue();

		return sum / numb.length;
	}

//függvény, ami megmondja, hogy 2 számsorozat átlaga egyenlő-e
//wildcard argument (egy speciális típus argumentum): itt Stats<?> (valamire specializál a Stats típusú objektum)
	boolean sameAvg(Stats<?> ob) {
		if(average() == ob.average())
			return true;
		return false;
	}
}


class BoundDemo {
	public static void main(String[] args) {
		
		Integer inums[] = {1, 2, 3, 4, 5, 6};
		Stats<Integer> iStats = new Stats<Integer>(inums);
		//elkérjük az átlagot
		double iAvg = iStats.average();
		System.out.println("iAvg: " + iAvg);

		Integer inums2[] = {1, 2, 3, 4, 5, 6};
		Stats<Integer> iStats2 = new Stats<Integer>(inums2);
		//elkérjük az átlagot
		double iAvg2 = iStats2.average();
		System.out.println("iAvg2: " + iAvg2);



		//double-re:
		Double dnums[] = {1.5, 2.6, 3.2, 4.6, 5.9, 6.1};
		Stats<Double> dStats = new Stats<Double>(dnums);
		//elkérjük az átlagot
		double dAvg = dStats.average();
		System.out.println("dAvg: " + dAvg);

		//float-ra:
		Float fnums[] = {1.5F, 2.6F, 3.2F, 4.6F, 5.9F, 6.1F};
		Stats<Float> fStats = new Stats<Float>(fnums);
		//elkérjük az átlagot
		double fAvg = fStats.average();
		System.out.println("fAvg: " + fAvg);


		//átlag egyenlőség:
		if(fStats.sameAvg(dStats))
			System.out.println("Average are the same.");
		else
			System.out.println("Average are not the same.");


		if(iStats.sameAvg(iStats2))
			System.out.println("Average are the same.");
		else
			System.out.println("Average are not the same.");

	}
}