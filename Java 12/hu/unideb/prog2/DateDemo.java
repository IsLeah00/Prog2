//reverse domain neves package megadás:
//mkdir hu | mkdir hu/unideb | mkdir hu/unideb/prog2
//Date típus létrehozása példa:
package hu.unideb.prog2;

class Date implements Comparable<Date>{ //compareTo használata miatt implementáljuk

	private int year;
	private int month;
	private int day;

	Date() {
		year = 2000;
		month = 1;
		day = 1;
	}
	//átadjuk neki kézzel a dátumot
	Date(int y, int m, int d) {
		year = y;
		month = m;
		day = d;
	}

	int getYear() { return year; }
	int getMonth() { return month; }
	int getDay() { return day; }

	void setYear(int y) { year = y; }
	void setMonth(int m) { month = m; }
	void setDay(int d) { day = d; }

//felülírjuk annotációt használva a kiiratást: (explicit módon)
	@Override
	public String toString() {
		return year + ". " + month + ". " + day + ".";
	}
//definiáljuk az equals függvényt annotációval:
	@Override
	public boolean equals(Object obj) {
//megnézzük, hogy az átadott referencia megegyezik-e önmagunkkal
	//(object referencia megegyezik-e a self referenciával)
		if(obj == this) return true;
		//megnézzük, hogy az object, amit átadunk date típusú instance-e
	//erre az 'instance of' operátort használjuk
		if(!(obj instanceof Date)) return false; //ha az object date típus false-t ad vissza
//mivel nincs az object-nek date tagja, ezért létrehozunk egy lokális date referenciát
	Date dd = (Date) obj;
//visszaadjuk a logikai kifejezés eredményét:
//(eszerint, akkor lesz egyenlő 2 dátum, ha az év, hónap, nap is megegyezik)
	return dd.year == year && dd.month == month && dd.day == day;
	}

//hash felüldefiniálása:
	@Override
	public int hashCode() {
		return year + month + day;
	}

//definiáljuk a compareTo-t
	@Override
	public int compareTo(Date o){
		//ha nem egyezik az év,
		if(year != o.year) return this.year - o.year;
		//a hónap,
		if(month != o.month) return this.month - o.month;
		//a nap
		if(day != o.day) return this.day - o.day;
		//ha egyezik minden:
		return 0;
	}
}

//main class
public class DateDemo {
	public static void main(String[] args) {
		
		Date today = new Date(2021,11,9);
		Date def = new Date();
//holnapi dátumot adunk hozzá
		Date tomorrow = new Date(2021,11,10);

/* rosszul néz ki, ezért nem ezt a kiírást használjuk
		System.out.println("Today's date: " + today.getYear() + ". " +
			today.getMonth() + ". " + today.getDay() + ".");
*/
			//fenti helyett a println-nek átadjuk a dátum referenciát:
		System.out.println(today);
		System.out.println(tomorrow);
	//így nézzük meg, hogy egyenlő-e a 2 dátum
		if(today.equals(tomorrow))
			System.out.println("Equals.");
		else
			System.out.println("Not equals.");
//megnézzük az arraylist működését:
	//java.util az importáláshoz kell
		java.util.ArrayList<Date> dates = new java.util.ArrayList<>();
		dates.add(today);
		dates.add(tomorrow);
		dates.add(new Date(22000, 3, 1));
		dates.add(new Date(14700, 10, 8));

		System.out.println("Print dates unsorted:");
		//bejárjuk a tömböt (forEach ciklussal)
		for(var date : dates)
			System.out.println(date);

//a collections osztálynak van statikus sort függvénye, ezt használjuk rendezéshez
		java.util.Collections.sort(dates);
		System.out.println("Print dates sorted:");
		for(var date : dates)
			System.out.println(date);

//dates arraylist-re iteratort kérünk
		java.util.Iterator<Date> it = dates.iterator();
		System.out.println("Print dates sorted with Iterator:");
		//while ciklussal bejárjuk
		while(it.hasNext()) //ameddig az aktuális elemre van rákövetkező
			System.out.println(it.next()); //addig kérjük el a referenciát rá
	

		java.util.HashSet<Date> dateSet = new java.util.HashSet<>();
//ha nem írjuk felül a hash függvényt és a today-tomorrow megegyezik, akkor 2-szer írja ki ugyanazt a dátumot
		dateSet.add(today);
		dateSet.add(tomorrow);
		System.out.println("Print dates for Set:");		
		for(var date : dateSet)
			System.out.println(date);
	}
}
//használata: javac hu/unideb/prog2/DateDemo.java
//			  java hu.unideb.prog2.DateDemo