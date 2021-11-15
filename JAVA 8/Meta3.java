//típusokhoz is tudunk annotációt, nem csak metódusokhoz:
import java.lang.annotation.*;
import java.lang.reflect.*;

//hozzáadunk még egy annotációt
@Retention(RetentionPolicy.RUNTIME)
@interface What {
	String description(); //leírás készítés
}

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno {
	String str();
	int val();
}



//class-t is tudunk annotálni:
@What(description = "An annotation test class")
@MyAnno(str = "Meta3", val = 21)
class Meta3 {

//kibővítjük még egy annotációval
	@What(description = "An annotation test method")
	@MyAnno(str = "Annotation example", val = 100)
	public static void myMethod(String s, int v) {
		Meta3 ob = new Meta3();


/*		try{
			Class<?> c = ob.getClass();
			Method m = c.getMethod("myMethod", String.class, int.class);
			MyAnno anno = m.getAnnotation(MyAnno.class);
			System.out.println(anno.str() + " " + anno.val()); 

		} catch(NoSuchMethodException e) {
			System.out.println("Method not found.");
		}
	   nem használjuk, hiszen nem metódussal dolgozunk					*/


//az összes annotációt beletesszük egy annotáció tömbbe:
	//elsőnek elkérjük az object-től a class-t, majd attól az annotációkat
			Annotation annos[] = ob.getClass().getAnnotations();
			System.out.println("Annotations for Meta3:");
	// for range loop-pal végig megyünk rajtuk
		for(Annotation a : annos)
			System.out.println(a);
	}


	public static void main(String[] args) {
		myMethod("test", 10);
	}
}