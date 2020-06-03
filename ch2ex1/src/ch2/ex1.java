package ch2;
import java.util.regex.*;
class ex1 {
	public static String url="https:a.co";
	public static boolean http() {
    String reghttp="https?\\:[a-z]\\.[a-z]{1,}";
	Pattern myPattern=Pattern.compile(reghttp);
	Matcher myMatcher=myPattern.matcher(url);
	return myMatcher.matches();
	}
	
}
