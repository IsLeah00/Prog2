//van mérete, ha teszünk bele valamit az a tetejére kerül, a többi sorban egymás alá
//ha kiveszünk belőle valamit, azt mindig a tetejéről tudjuk kivenni
class Stack {
	private int stck[] = new int[10];
	private int tos; // segédérték, ami megmondja éppen hol tartunk a stack-ben

//konstruktor beállítja a segédváltozót -1-re, így jelezve, hogy a stack üres
	Stack() {
		tos = -1;
	}

//értéket rakunk a stackbe
	public void push(int val) {
//hibakezelés: ha a stack pointer 9, akkor tele van a stack
		if(tos==9)
			System.out.println("Stack is full.");
//különben adjuk hozzá
		else
			stck[++tos] = val;
	}

//értéket veszünk el a stackből
	public int pop() {
//hibakezelés: ha kisebb, mint 0 a stack, akkor nem tudunk kivenni belőle
		if(tos < 0){
			System.out.println("Stack is underflow.");
//ha a függvényünk nem void, vagyis értéket ad vissza (itt--> int pop(), akkor kötelező return-t adni)
			return 0;
		}
//különben adjuk vissza és csökkentsük
		else
			return stck[tos--];
	}
}


class StackDemo {
	public static void main(String[] args) {

		Stack st1 = new Stack();
//tegyünk bele elemet:
		for(int i = 0; i < 10; ++i) st1.push(i);
//kiírjuk, amit beletettünk:
		for(int i = 0; i < 10; ++i)
			System.out.println(st1.pop());
	}
}