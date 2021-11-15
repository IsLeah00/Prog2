import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@interface What {
	String description();
}

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno {
//default value-kat is adhatunk
	String str() default "Testing";
	int val() default 2021;
}



@What(description = "An annotation test class")
@MyAnno(/*str = "Meta4", val = 21*/) //ezért ezek elhagyhatók
class Meta5 {

	@What(description = "An annotation test method")
	@MyAnno(str = "Annotation example"/*, val = 100*/)
	public static void myMethod(String s, int v) {
		Meta5 ob = new Meta5();


		try{

		Annotation annos[] = ob.getClass().getAnnotations();
		System.out.println("Annotations for Meta5:");
		for(Annotation a : annos)
			System.out.println(a);


		Method m = ob.getClass().getMethod("myMethod", String.class, int.class);
		annos = m.getAnnotations();
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