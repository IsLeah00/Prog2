enum Grades {
	FAIL, PASS, SATISFACTORY, GOOD, EXCELLENT
}

class Grading {
	java.util.Random rand = new java.util.Random();
	//tag, ami a jegyet adja
	Grades giveGrade() {
		//a random szám generátor alapján adja vissza a jegyet
		//1-100 között random szám generálás:
		int prob = (int) (100*rand.nextDouble());

		if(prob < 30)
			return Grades.FAIL;
		else if(prob < 50)
			return Grades.PASS;
		else if(prob < 80)
			return Grades.SATISFACTORY;
		else if(prob < 90)
			return Grades.GOOD;
		else
			return Grades.EXCELLENT;
	}
}

//main class
class Exam {
	static void commit(Grades result) {
//switch-el kiiratjuk az értéket
		switch(result) {
			case FAIL:
				System.out.println("Fail");
				break;
			case PASS:
				System.out.println("Pass");
				break;
			case SATISFACTORY:
				System.out.println("Satisfactory");
				break;
			case GOOD:
				System.out.println("Good");
				break;
			case EXCELLENT:
				System.out.println("Excellent");
				break;
		}
	}

	public static void main(String[] args) {
		//garding objektumot készítünk, ami generálja a jegyeket
		Grading g = new Grading();
		//hívjuk a commitot a giveGrade metódussal párszor
		commit(g.giveGrade());
		commit(g.giveGrade());
		commit(g.giveGrade());
		commit(g.giveGrade());
		commit(g.giveGrade());
		commit(g.giveGrade());						
	}
}