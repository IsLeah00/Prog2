//itt object típus lesz, amire illeszkedik minden, ami nem elemi típus
class NonGen {
	
	Object ob;

	NonGen(Object o) { ob = o; }

	Object getOb() { return ob; }

	void showType() {
		System.out.println("Type of ob is: " + ob.getClass().getName());
	}
}


class NonGenDemo {
	public static void main(String[] args) {
		
		NonGen iOb = new NonGen(88);

		iOb.showType();
		//kérjük vissza az object-et cast-tal:
		int v = (Integer) iOb.getOb();
		System.out.println("Value of v is: " + v);

		NonGen sOb = new NonGen("NonGen string");
		sOb.showType();
		String str = (String) sOb.getOb();
		System.out.println("Value of v is: " + str);
	//itt működik, de nem szabadna (type safety miatt), ezért jobb a generikus programozás
		iOb = sOb;
	}
}