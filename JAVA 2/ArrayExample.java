class ArrayExample {

	public static void main(String[] args) {

// egy tömb, ami tárolja hány napja van az adott hónapnak:
// 1 módja:
		int monthDays[]; //üresen deklarált tömb

		monthDays = new int[12]; //megadjuk, hogy a tömb int és 12 eleme van

		monthDays[0] = 31;
		monthDays[1] = 28;
		monthDays[2] = 31;
   		monthDays[3] = 30;
   		monthDays[4] = 31;
   		monthDays[5] = 30;
   		monthDays[6] = 31;
   		monthDays[7] = 31;
   		monthDays[8] = 30;
   		monthDays[9] = 31;	
		monthDays[10] = 30;
		monthDays[11] = 31;

		System.out.println("April has " + monthDays[3] + " days.");


// 2 módja:
		//egyből allokáljuk az elemeit, így nem kell külön-külön
		int monthDays2[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }; 

		System.out.println("April has " + monthDays[3] + " days.");


// lehet többdimenziós tömböket is készíteni
		int twoD[][] = new int[4][5];

		int k = 10;

		for (int i = 0; i < 4; i++)
			for(int j = 0; j < 5; j++)
				twoD[i][j] = k;

		for (int i = 0; i < 4; i++) {
			for(int j = 0; j < 5; j++) {
				System.out.print(twoD[i][j] + " ");
			}
			System.out.println();
		}
	}
}