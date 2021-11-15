//main a package-k számára p1-ben:
//javac p1/Demo.java
package p1;

class Demo {
	public static void main(String[] args) {
	//mindegyikre csinálunk 1 példányt
		Protection ob1 = new Protection();
		Derived ob2 = new Derived();
		SamePackage ob3 = new SamePackage();
	}
}