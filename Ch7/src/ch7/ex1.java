package ch7;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class ex1 {
	private static int option;
	//private static book newbook;
	public static void main(String[] args) {
		display();
	}
	public static void display() {
		System.out.println("1 means input 2 means output");
		Scanner in =new Scanner(System.in);
		option=in.nextInt();
		if(option==1) {
				System.out.println("book name:");
				String bookname=in.nextLine();
				//newbook.bk_name=bookname;
				System.out.println("Auther name:");
				String Authername=in.nextLine();
				//newbook.au_name=Authername;
				System.out.println("price:");
				double price=in.nextDouble();
				//newbook.price=price;1
				String message=bookname+Authername+price;
				write(message);
			}
		
		else {
			try {
				read();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void read() throws UnsupportedEncodingException, IOException {
		BufferedInputStream in=new BufferedInputStream(new FileInputStream("book.txt"));
		byte bytes[]=new byte[2048];
		int n=-1;
		System.out.println(in);
		if((n=in.read(bytes))!=-1) {
			String str=new String(bytes);//,0,n,"GBK");
			System.out.println(n);
			System.out.println(str);
			System.out.println("ok");
	//System.out.println(((Scanner) in).nextInt());
		}
		in.close();
	}
	public static void write(String message) {
		byte bytes[]=message.getBytes();
		FileOutputStream fio=null;
		try {
			fio=new FileOutputStream("book.txt",true);
			try {
				fio.write(bytes);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fio.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
class book{
	String bk_name;
	String au_name;
	Double price;
	
}
