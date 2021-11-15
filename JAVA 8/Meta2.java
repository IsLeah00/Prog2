import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno {
	String str();
	int val();
}


class Meta2 {

	@MyAnno(str = "Annotation example", val = 100)
	public static void myMethod(String s, int v) { //paramétert adunk meg

		Meta2 ob = new Meta2();


		try{

			Class<?> c = ob.getClass();

//itt már nem csak a nevet kell átadni, hanem a paramétereket is class literálként
			Method m = c.getMethod("myMethod", String.class, int.class);

			MyAnno anno = m.getAnnotation(MyAnno.class);
			System.out.println(anno.str() + " " + anno.val());
		} catch(NoSuchMethodException e) {
			System.out.println("Method not found.");
		}
	}

	public static void main(String[] args) {

		myMethod("test", 10);
	}
}