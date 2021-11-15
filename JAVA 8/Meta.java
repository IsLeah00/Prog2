//annotations:
import java.lang.annotation.*;
import java.lang.reflect.*; //ezzel nyerjük ki az annotációkat a programból

//meg kell adni egy retention policy-t, hogy mikor akarjuk használni az annotációt
//itt runtime, tehát az interface futási időben fog megjelenni és ott tudjuk használni
@Retention(RetentionPolicy.RUNTIME)
//annotáció készítés:
@interface MyAnno {
	String str();
	int val();
}

//main class:
class Meta {
//annótáljuk a metódust:
	@MyAnno(str = "Annotation example", val = 100) //értéket adunk az annotációnak (itt int és string)
	public static void myMethod() {

		Meta ob = new Meta();

		//elkéréshez try-catch blokkba kell tenni hibakezelés miatt
		try{
//elsőnek elkérjük a class-t, amibe az annotációt akarjuk tenni:
//getClass függvénnyel a futó osztályt kérjük el és eltároljuk a Class referenciában:
			Class<?> c = ob.getClass(); // 'c' a class

	//ezután elkérjük a metódust, amihez az annotáció van kapcsolva
			Method m = c.getMethod("myMethod"); //stringként beírva tudunk hivatkozni a névre
	//magát az annotációt kérjük el:
//getAnnotation-nak át kell adni egy class literált (itt MyAnno)
			MyAnno anno = m.getAnnotation(MyAnno.class);
			System.out.println(anno.str() + " " + anno.val());
		} catch(NoSuchMethodException e) { //ha elrontjuk a metódus nevet, akkor dobja fel
			System.out.println("Method not found.");
		}
	}

	public static void main(String[] args) {
		//itt hívjuk a metódust:
		myMethod();
	}
}