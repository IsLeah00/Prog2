//Gen-nek ősosztályt hozunk létre, ami nem generikus
class NonGen {
	int num;
	NonGen(int o) { num = o; }
	int getnum() { return num; }
}

class Gen<T> extends NonGen {
	T ob;

	Gen(int num, T o) { 
		super(num);
		ob = o; 
	}

	T getob() { return ob; }
}

class Gen2<T, V> extends Gen<T> {
	V ob2; //csak V kell, hiszen T jön ősosztályból

	Gen2(int num, T o, V o2) {
		super(num, o);
		ob2 = o2;
	}

	V getob2() { return ob2; }
}

class HierDemo2 {
	public static void main(String[] args) {
		
		Gen2<Integer, String> x =
			new Gen2<Integer, String>(1, 100, "Some value");

		System.out.println(x.getnum());
		System.out.println(x.getob());
		System.out.println(x.getob2());
	}
}