import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@interface What {
	String description();
}

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno {
	String str();
	int val();
}



@What(description = "An annotation test class")
@MyAnno(str = "Meta4", val = 21)
class Meta4 {

	@What(description = "An annotation test method")
	@MyAnno(str = "Annotation example", val = 100)
	public static void myMethod(String s, int v) {
		Meta4 ob = new Meta4();


		try{

		Annotation annos[] = ob.getClass().getAnnotations();
		System.out.println("Annotations for Meta4:");
		for(Annotation a : annos)
			System.out.println(a);

	//kibővítjük, hogy a metódust is elkérje
		Method m = ob.getClass().getMethod("myMethod", String.class, int.class);
		annos = m.getAnnotations(); //elkérjük az összes annotációt és bemásoljuk a tömbbe
	//kiírjuk:
		System.out.println("Annotations for myMethod:");
		for(Annotation a : annos)
			System.out.println(a);

		} catch(NoSuchMethodException e) {
			System.out.println("Method not found.");
		}
	}


	public static void main(String[] args) {
		myMethod("test", 10);
	}
}