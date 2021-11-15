//1 példányt készítünk a másik package osztályából
package p2;

class OtherPackage {
	OtherPackage() {
		//protection példány a package névre hivatkozva
		p1.Protection p = new p1.Protection();

		System.out.println("otherpackage constructor");

		//System.out.println("n==" + p.n);
		//System.out.println("n_priv==" + p.n_priv);
		//System.out.println("n_prot==" + p.n_prot);
		System.out.println("n_pub==" + p.n_pub);

	}
}