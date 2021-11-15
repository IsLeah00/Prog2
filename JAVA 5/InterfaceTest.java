//interface-kkel megmondhatjuk milyen műveletet szeretnénk végezni (push/pop)
//nem mondja meg hogyan csak azt, hogy mit
//az osztályt interface-be tesszük:
interface IntStack{
	void push(int item); //függvény prototipusok, itt nem definiáljuk őket
	int pop();
}

//fix stack:
//implements-el implementálja az interface-t az osztály számára
//itt definiáljuk a függvényeket az interface-ből
class FixedStack implements IntStack{
	private int stck[];
	private int tos;

//ennek a konstruktornak adjuk át a méretet (mekkora stacket készítsen el)
	FixedStack(int size) {
		stck = new int[size];
		tos = -1;
	}

	public void push(int item) {
		//hibakezelés, ha tele van a stack
		if(tos == stck.length-1)
			System.out.println("Stack is full");
		else
			stck[++tos] = item;
	}

	public int pop() {
		//hibakezelés, ha üres a stack
		if(tos < 0){
			System.out.println("Stack is underflow");
			return 0;
		}
		else
			return stck[tos--];
	}
}

class InterfaceTest {
	public static void main(String[] args) {
		
		FixedStack fs1 = new FixedStack(5); //5 elemű stack
		//feltöltjük:
		for(int i = 0; i < 5; i++) fs1.push(i);

		for(int i = 0; i < 5; i++) 
			System.out.println(fs1.pop());

	}
}