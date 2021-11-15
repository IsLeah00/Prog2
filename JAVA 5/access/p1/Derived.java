//gyerekosztálya a Protection-nak
package p1;

class Derived extends Protection {
	Derived() {
		System.out.println("derived constructor");

		System.out.println("n==" + n);
		//System.out.println("n_priv==" + n_priv);
		System.out.println("n_prot==" + n_prot);
		System.out.println("n_pub==" + n_pub);

	}
}
