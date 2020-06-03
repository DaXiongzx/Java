package ch2;
import java.util.Scanner;
import java.util.regex.*;
class ex4 {
	String regname="[a-z]{1,}";
	String regcontact_number="[a-zA-Z0-9]{3}-[a-zA-Z0-9]{4}-[a-zA-Z0-9]{4}";
    String name="";
	String contact_number="";
	public void getinput() {
		System.out.println("please input the name:");
		Scanner scan1=new Scanner(System.in);
		name=scan1.nextLine();
		System.out.print("please input the contact number");
		Scanner scan2=new Scanner(System.in);
		contact_number=scan2.nextLine();
	}

	public  void comp() {
		Pattern namepattern=Pattern.compile(regname);
		Matcher nameMatcher=namepattern.matcher(name);
		System.out.println("The output of the reg of name is :"+nameMatcher.matches());
		System.out.println(namepattern.pattern());
		Pattern conpattern=Pattern.compile(regcontact_number);
		Matcher conMatcher=conpattern.matcher(contact_number);
		System.out.println(conpattern.pattern());
		//conpattern.pattern();
		System.out.println("The output of the reg of name is :"+conMatcher.matches());
	}
}
