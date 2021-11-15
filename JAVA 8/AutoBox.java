//autoboxing:
class AutoBox {
//függvény, ami int-et ad vissza és Integer-t vár
	//ez csinálja meg az autoboxing-ot és az autounboxing-ot is
	static int m(Integer v) {
		return v; //amikor visszaadjuk, akkor kicsomaguljuk (autounboxing), így hívás helyen sima int lesz
	}

	public static void main(String[] args) {
		
		int a = 6;
		double s = 1.5;

		double sa = s*a;

//int wrapper osztályának az elkészítése:
		Integer iOb1 = Integer.valueOf(a); //'a' változót becsomagolja az Integer osztályba
//egyszerűbben:
		Integer iOb2 = Integer.valueOf(100);
//még egyszerűbben:
		Integer iOb3 = 100;

		System.out.println(sa);
		System.out.println(iOb1.intValue()); //elkérjük az iOb1 értékét
		System.out.println(iOb2); //iOb2-vel ugyanúgy csak egyszerűbben
		System.out.println(iOb3);
//mindez működik automatikusan is, ezért hívják autoboxingnak

		//ezt a függvényt hívva lesz automatikus az autoboxing
		System.out.println(m(420)); 

	}
}
//megjegyzés: ugyanezek működnek az összes másik elemi típusra