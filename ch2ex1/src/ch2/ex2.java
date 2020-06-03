package ch2;
import java.util.*;
import java.text.DateFormat;
public class ex2 {
	static DateFormat df1=DateFormat.getDateInstance(DateFormat.LONG,new Locale("fr","FR"));
	static DateFormat df2=DateFormat.getDateInstance(DateFormat.LONG,new Locale("en","US"));
	static String date1=df1.format(new Date());
	static String date2=df2.format(new Date());
	public static void show() {
		System.out.println("input 1 means select FR   input 2 means select US");
		Scanner scan=new Scanner(System.in);
		int x;
		x=scan.nextInt();
		if(x==1) {
			System.out.println(date1);
		}
		else if(x==2) {
			System.out.println(date2);
		}
	}
}
	
