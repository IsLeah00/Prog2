// előtte elkészítjük a megfelelő mappa szerkezetet:
//mkdir mymodapp | cd mymodapp/ | mkdir appsrc | cd appsrc | mkdir appstart | mkdir appfuncs | mkdir appsupport
//packageket is el kell készítenünk:
// cd appstart | ls | mkdir appstart | cd appstart/ | mkdir mymodappdemo
// cd appfuncs/ | mkdir appfunc | cd appfunc/ | mkdir simplefunc
// cd appsupport/ | mkdir appsupport | cd appsupport/ | mkdir supportfuncs
// cd | tree (leellenőrizzük)

package appstart.mymodappdemo;

import appfuncs.simplefuncs.SimpleMathFuncs;
import appsupport.supportfuncs.SupportFuncs;

public class MyModAppDemo {
	public static void main(String[] args) {
		
		if(SupportFuncs.isFactor(2,10))
			System.out.println("2 is a factor 10");

		System.out.println(
			"Smaller factor common to both 35 and 105" +
			SimpleMathFuncs.lcf(35,105));

		System.out.println(
			"Largest factor common to both 35 and 105" +
			SimpleMathFuncs.gcf(35,105));

	}
}
//Ahhoz, hogy modulként funkcionáljanak a mappában szereplő fájljainkat, modul infót kell mellékelnünk mindegyikhez
//Használata: 
//javac -d appmodules --module-source-path appsrc/ appsrc/appstart/appstart/mymodappdemo/MyModAppDemo.java
//java --module-path appmodules -m appstart/appstart.mymodappdemo.MyModAppDemo