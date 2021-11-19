class Gen<T> {
	T ob;

	Gen(T o) { ob = o; }

	T getob() { 
		System.out.println("Gen<T> getob()");
		return ob; 
	}
}

class Gen2<T> extends Gen<T> {

	Gen2(T o) {
		super(o);
	}

	T getob() {  // ezt a függvényt override-oljuk
	System.out.println("Gen2<T> getob()");
	return ob; 
	}
}

class OverrideDemo {
	public static void main(String[] args) {
		
		Gen<Integer> x1 = new Gen<Integer>(100);
		Gen2<Integer> x2 = new Gen2<Integer>(100);
		Gen2<String> xStr = new Gen2<String>("Some text");

		System.out.println(x1.getob());
		System.out.println(x2.getob());
		System.out.println(xStr.getob());
	}
}