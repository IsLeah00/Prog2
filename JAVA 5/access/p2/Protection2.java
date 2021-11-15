//p1 package ősosztályát bővítjük vele
//másik package-ből származó osztálynak a leszármazott osztálya
package p2;

class Protection2 extends p1.Protection {
	Protection2() {
		//hibakezelés:
		System.out.println("protection2 constructor");

		//System.out.println("n==" + n);
		//System.out.println("n_priv==" + n_priv);
		//System.out.println("n_prot==" + n_prot);
		System.out.println("n_pub==" + n_pub);

	}
}