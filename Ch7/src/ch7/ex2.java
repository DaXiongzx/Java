package ch7;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.regex.*;

public class ex2 {
	public static void main(String[] args) {
		findword fd=new findword("sd");
		if(fd.find(fd.aimword)) System.out.println("find it");
		else System.out.println("not find it");
	}

}
class findword{
    String aimword;
	Boolean rs=null;
	public findword(String str) {
		this.aimword=str;
	}
	public Boolean find(String aim) {
		String str=read();
		String findstr=aim;
		System.out.println(aim);
		Pattern myPattern=Pattern.compile(findstr);
		System.out.println(myPattern);
		Matcher myMatcher=myPattern.matcher(aim);
		return myMatcher.matches();
	}
	public String read() {
		BufferedInputStream in = null;
		String str=null;
		try {
			in=new BufferedInputStream(new FileInputStream("book.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte bytes[]=new byte[2048];
		int n=-1;
		try {
			while((n=in.read(bytes))!=-1) {
				 str=new String(bytes);
				 System.out.println(str);
				//rs=find(aimword,str);
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}
}
