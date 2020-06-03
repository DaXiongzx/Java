package ch2;
import java.text.NumberFormat;
import java.util.*;
public class ex3 {

	static NumberFormat nft1=NumberFormat.getCurrencyInstance(new Locale("fr","FR"));
	static NumberFormat nft2=NumberFormat.getCurrencyInstance(new Locale("en","US"));
	static String formatted1=nft1.format(100000);
	static String Formatted2=nft2.format(100000);
	static void show() {
		System.out.println("input 1 means select FR   input 2 means select US");
		Scanner scan=new Scanner(System.in);
		int x;
		x=scan.nextInt();
		if(x==1) {
			System.out.println(formatted1);
		}
		else if(x==2) {
			System.out.println(Formatted2);
		}
	}
	}
	

