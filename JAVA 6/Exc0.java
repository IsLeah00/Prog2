//Nem kezelt kivételre példa:
class Exc0 {
	public static void main(String[] args) {
		int d = 0;
		int a = 42 / d;
	}
}
//aritmetikai exception-t dob, mert 0-val osztunk. Hasonló a hibaüzenet a c++-hoz
