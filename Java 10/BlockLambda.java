//block lambda: változó deklarálás, scope, blokkszerű
interface NumericFunc { //numerikus funkcionális interface
	int func(int n);
}
//interface, ami string-et kiír
interface StringFunc {
	String func(String str);
}


 //faktoriálist számolunk blokk lambdában
class BlockLambda {
	public static void main(String[] args) {
		
		NumericFunc factorial = (int n) -> {

			int result = 1;
			for(int i = 1; i <= n; i++)
				result = result * i;

			return result;
		};

		System.out.println("The factorial of 7 is: " + factorial.func(7));
		System.out.println("The factorial of 10 is: " + factorial.func(10));


	//visszafele írja ki a string-eket
		StringFunc reverse = (str) -> {
			String result = "";
			int i;

			for(i = str.length()-1; i >= 0; i--)
				result += str.charAt(i);

			return result;
		};

		System.out.println("Lambda reversed is " + reverse.func("Lambda"));
	}
}