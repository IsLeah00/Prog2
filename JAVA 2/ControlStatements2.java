class ControlStatements2 {

	public static void main(String[] args) {

		int n = 10;
// while ciklus 10től visszafele
		while(n > 0) {
			System.out.println("n is " + n);
			n--;
		}
//do-while cilus
		do {
			System.out.println("n is " + n);
			n--;
		} while(n > 0);
//for ciklus
		for (n = 10; n > 0; n--) {
			System.out.println("n is " + n);
		}



// tömb feldolgozása ilyen módon:
		int nums[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		//bejárása:
		int sum = 0;
//for range loop: num ciklusváltozó felveszi a nums tömb elemeit
		for (int num : nums) {
			System.out.println("Number: " + num);
			sum += num;
		}

		System.out.println("Sum is: " + sum);
//mutatja, hogy tömbnek van tagváltozója
		System.out.println("Avg is " + (double)sum/nums.length);
//kiírja hány eleme van
		System.out.println("Nums length is " + nums.length);
//Tudni: a tömbök objektumokká képződnek le java-ban, így lehet tagváltozójuk
	}
}