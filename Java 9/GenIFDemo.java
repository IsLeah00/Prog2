//interface-ek generalizálása (generikus interface) példa
//min-max fv, ami megmondja az osztályban, hogy adott tömbnek mi a min és mi a max értéke
interface MinMax<T extends Comparable<T>> {
	T min();
	T max();
}

class MyClass<T extends Comparable<T>> implements MinMax<T> {

	T[] vals;

	MyClass(T[] o) { vals = o; }

	public T min() {
		T v = vals[0];

		for(int i = 1; i < vals.length; i++)
			if(vals[i].compareTo(v) < 0) v = vals[i];
		return v;
	}

	public T max() {
		T v = vals[0];

		for(int i = 1; i < vals.length; i++)
			if(vals[i].compareTo(v) > 0) v = vals[i];
		return v;
	}
}

class GenIFDemo {
	public static void main(String[] args) {
		Integer iNums[] = {4, 2, 0};
		Character chs[] = {'b', 'r', 'w', 'k'};

		MyClass<Integer> iob = new MyClass<Integer>(iNums);
		MyClass<Character> cob = new MyClass<Character>(chs);

		System.out.println("iob min: " + iob.min());
		System.out.println("iob max: " + iob.max());
		System.out.println("cob min: " + cob.min());
		System.out.println("cob max: " + cob.max());
	}
}