import java.util.*;
import java.util.stream.*;

class NamePhoneEmail {
	String name, phone, email;

	NamePhoneEmail(String n, String p, String e) {
		name = n;
		phone = p;
		email = e;
	}
}

class NamePhone {
	String name, phone;

	NamePhone(String n, String p) {
		name = n;
		phone = p;
	}
}

class StreamDemo2 {
	public static void main(String[] args) {
		
		ArrayList<NamePhoneEmail> myList = new ArrayList<>();
		myList.add(new NamePhoneEmail("Jeff", "555-5555", "a@b.c"));
		myList.add(new NamePhoneEmail("Bob", "555-444", "a@b.c"));
		myList.add(new NamePhoneEmail("Lawrence", "0690-343379", "a@b.c"));
		
		System.out.println("Original values of myList");
		myList.stream().forEach((a) -> {
			System.out.println(a.name + " " + a.phone + " " + a.email);
		});
//innestől áttérünk másik típusra, ez a mapping
	//stream-nak van map függvénye
		Stream<NamePhone> namePhoneStream = myList
		.stream()
		.map((a) -> new NamePhone(a.name, a.phone));
		//listába tesszük a fenti elemeket
		List<NamePhone> npList = namePhoneStream.collect(Collectors.toList());
		System.out.println("List of names and phones:");
		for(var np : npList)
			System.out.println(np.name + " " + np.phone);
	}
}