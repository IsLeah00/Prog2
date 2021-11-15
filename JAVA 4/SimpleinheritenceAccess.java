//öröklődésben láthatósági szintek
class A {
	int i;
// j változó privát lesz
	private int j;

//set és get-et használva kerüljük ki, hogy j privát
	void setij(int a, int b) {
		i = a;
		j = b;
	}

	int getj() {
		return j;
	}



	void showij() {
		System.out.println("i==" + i + " j==" + j);
	}
}

class B extends A {
	int k;

	void showk() {
		System.out.println("k==" + k);
	}

	void sum() {
		//i+j+k helyett i+getj()+k kell
		System.out.println("i+j+k==" + (i+getj()+k));
	}

}


class SimpleinheritenceAccess {
	public static void main(String[] args) {

		A superOb = new A();
		B subOb = new B();

	/*  superOb.i = 10;
		superOb.j = 20; ezek helyett kell ez: 
	*/
		superOb.setij(10, 20);

		System.out.println("Contents of superOb: ");
		superOb.showij();


		subOb.k = 30;
	/*
		subOb.i = 25;
		subOb.j = 20; helyett kell:
	*/
		subOb.setij(20, 25);


		System.out.println("Contents of subOb: ");
		subOb.showij();
		subOb.showk();

		System.out.println("Sum: ");
		subOb.sum();
	}
}