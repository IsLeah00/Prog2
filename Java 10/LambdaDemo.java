//functional interface: 1 absztrakt függvényt tartalmazhat
interface MyNumber {
	double getValue();
}

//változót tesztelünk, hogy az megfelel-e egy adott értéknek
interface NumericTest {
	boolean test(int n);
}


class LambdaDemo {
	public static void main(String[] args) {
		//funkcionális interface referencia
		MyNumber mynumb;
		//interface referenciának lambda kifejezés értéket adunk
// ... = paraméter lista, lambda operátor, jobb oldalon valamilyen kifejezés
		mynumb = () -> 123.45;
		System.out.println("A fixed value: " + mynumb.getValue());

		//a referenciának másik lambda adás:
		mynumb = () -> Math.random() * 100;
		System.out.println("A random value: " + mynumb.getValue());
		System.out.println("A random value: " + mynumb.getValue());

//szám páros-e
			//n a paraméter, ami ha maradék nélkül osztható, akkor páros
		NumericTest isEven = (int n) -> (n % 2) == 0;
		if(isEven.test(6)) System.out.println("6 is even");
		if(!isEven.test(9)) System.out.println("9 is not even");
//szám nem negatív
		NumericTest isNonNegative = (int n) -> n >= 0;
		if(isNonNegative.test(6)) System.out.println("6 is positive");
		if(!isNonNegative.test(-9)) System.out.println("-9 is negative");

	}
}