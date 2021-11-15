//hogyan importálhatunk package-ket
import mypack.*;

class AccountBalance {
	public static void main(String[] args) {
		

		Balance current[] = new Balance[3];

		current[0] = new Balance("Attila", 100.32);
		current[1] = new Balance("János", 45.01);
		current[2] = new Balance("István", 13.06);


		for(int i = 0; i < 3; i++) current[i].show();
	}
}