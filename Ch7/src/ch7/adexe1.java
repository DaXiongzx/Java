package ch7;


import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class adexe1 {
    public static void main(String[] args) {
        String path;
        System.out.println("Enter the absolute path of the file:");  //  F:\JavaEE_WorkSpace\Ch7\book.txt
        Scanner scanner = new Scanner(System.in);
        path = scanner.nextLine();
        try(FileWriter f = new FileWriter(path)) {
            String s = "start";
            while(!s.equals("end")) {
                System.out.println("Enter the content, which you want to add in the file:");
                s = scanner.nextLine();
                f.write(s);
            }
        }
        catch (IOException io) {
            System.out.println("The path is illegal!");
        }
    }
}
