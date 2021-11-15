class LightSpeed {

	public static void main(String[] args) {

		int lightspeed = 299792;

		long days = 1000;
// 1000 napban hány mp van
		long second = 24 * 60 * 60 * days;
// 1000 nap alatt mennyit halad a fény
		long distance = second * lightspeed;

		System.out.println("In " + days + 
				" light travels " + distance + " km.");


				/*
				int, long, byte, short
				float, double
				char
				boolean
				*/
	}
}