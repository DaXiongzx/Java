package ch1ex2;
import  java.lang.*;
public class ex2 {
	public static void initarray(int []a) {
		for(int i=0;i<20;i++) {
			a[i]=(int)(Math.random()*100);
		}
	}
	public static int findmax(int []a) {
		int max=0 ;
		for(int i=1;i<a.length;i++) {
			if(a[i]>a[max]) max=i;
		}
		return max;	
	}
	public static int findmin(int []a) {
		int min=0;
		for(int i=1;i<a.length;i++) {
			if(a[i]<a[min]) min=i;
		}
		return min;
	}
	public static void printarray(int []a) {
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+"   ");
		}
	}
	public static void main(String[] args) {
		int []a=new int[20];
		initarray(a);
		printarray(a);
		int max=findmax(a);
		int min=findmin(a);
		System.out.println("The max number is:"+a[max]+"the min number is:"+a[min]);
	}
}
