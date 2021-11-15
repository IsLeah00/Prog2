package p1;

//ez lesz a base class:
public class Protection {
	int n = 1; //default látható
	private int n_priv = 2; //csak az osztályon belül látható
	protected int n_prot = 3; //leszármazott osztályban látszódik
	public int n_pub = 4; //mindenhol látszódik

	public Protection() {
		System.out.println("base constructor");

		System.out.println("n==" + n); 	//package-n kívülről nem érhető el
										//ezt nevezzük package private-nak
		System.out.println("n_priv==" + n_priv); //csak ez az osztály fér hozzá
		System.out.println("n_prot==" + n_prot);
		System.out.println("n_pub==" + n_pub);
	}
}