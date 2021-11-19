package appfuncs.simplefuncs;
//melyik package-ből melyik osztályt importáljuk:
import appsupport.supportfuncs.SupportFuncs;

public class SimpleMathFuncs {
	//lcf (least common factor) = legkisebb közös többszörös
	public static int lcf(int a, int b) {
		//abszolútérték vizsgálat
		a = Math.abs(a);
		b = Math.abs(b);
		//melyik a kisebb
		int min = a < b ? a : b;
		//az i, ahol éppen vagyunk osztója-e a-nak vagy b-nek
		for(int i = 2; i <= min/2; i++)
			if(SupportFuncs.isFactor(i, a)
				&& SupportFuncs.isFactor(i, b))
				return i;

		return 1;
	}

//legnagyobb...
	public static int gcf(int a, int b) {
		a = Math.abs(a);
		b = Math.abs(b);
		
		int min = a < b ? a : b;

		for(int i = min/2; i >= 2; i--)
			if(SupportFuncs.isFactor(i, a)
				&& SupportFuncs.isFactor(i, b))
				return i;

		return 1;			
	}
}