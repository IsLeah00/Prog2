class Exc1 {
//statikus függvény:
	public static void subrutine() {
		int d = 0;
		int a = 42 / d;
	}
}
class Exc0 {
	public static void main(String[] args) {
		Exc1.subrutine();
	}
}
//stackként listázza ki a hibát
//stack trace: leírja a hívásláncot, ahol gond volt