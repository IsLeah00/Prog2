//megpróbálja elérni ugyanannak a package-nek az osztályát (példányosítani próbálja)
package p1;

class SamePackage {
	//konstruktorban csinál 1 példányt az ősosztályból
	SamePackage() {
		Protection p = new Protection();

	//hibakezelés:
		System.out.println("SamePackage constructor");


		System.out.println("n==" + p.n); //p. megmondja, hogy n p-nek a tagja
		//System.out.println("n_priv==" + p.n_priv);
		System.out.println("n_prot==" + p.n_prot);
		System.out.println("n_pub==" + p.n_pub);

	}
}