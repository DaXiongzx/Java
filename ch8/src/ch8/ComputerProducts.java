package ch8;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class ComputerProducts {
    String pname,prid,name,address,sid;
    int price;
    String sprid;
    Integer iprice,iid;
    String sprice;
    Path file=Paths.get("D:/Details/ProductDetails.txt");
    Path target=Paths.get("D:/Backup/BackupProductDetails.txt");
    
    public void createDirectory() throws IOException{
        Path dir=Paths.get("D:/Details");
        Path copydir=Paths.get("D:/Backup");
        enterProductDetails();
    }
    
    public void enterProductDetails() throws IOException {
        Scanner input=new Scanner(System.in);
        System.out.println("Enter the product ID: ");
        prid=input.nextLine();
        System.out.println("Enter the product name: ");
        pname=input.nextLine();
        System.out.println("Enter the product price: ");
        price=input.nextInt();
        sprid=prid;
        iprice=price;
        sprice=iprice.toString();
        printprodDetails();
        enterShopDetails();
    }
    
    public void enterShopDetails() throws IOException{
        
        Scanner inputs=new Scanner(System.in);
        System.out.println("Enter the shop ID: ");
        int id=inputs.nextInt();
        System.out.println("Enter the shop name: ");
        name=inputs.next();
        System.out.println("Enter the address: ");
        address=inputs.next();
        iid=id;
        sid=iid.toString();
        System.out.println("Do you want to add more shop details: (Y/N) ");
        Scanner shopchoice=new Scanner(System.in);
        String sch;
        sch=shopchoice.next();
        
        switch(sch.toUpperCase()){
            case "Y":
                printshopDetails();
                enterShopDetails();
                break;
            case "N":
                printshopDetails();
                //printDetails();
                System.out.println("Do you want to continue to add product details: (Y/N) ");
                Scanner choice=new Scanner(System.in);
                String ch;
                ch=choice.next();
                switch(ch.toUpperCase()){
                    case "Y":
                        enterProductDetails();
                        break;
                        
                    case "N":
                        System.exit(0);
                        break;
                        
                    default:
                        System.out.println("Invalid entry");
                        break;
                }
            break;
            default:
                System.out.println("Invalid entry!");
                break;
        }
    }
    
    public void printprodDetails() throws IOException{
        Charset charset=Charset.forName("US-ASCII");
        try(BufferedWriter writer=Files.newBufferedWriter(file, charset, StandardOpenOption.CREATE, StandardOpenOption.APPEND)){
            writer.write("==========");
            writer.newLine();
            writer.append("Product ID: "+sprid+"\n");
            writer.newLine();
            writer.append("Product Name: "+pname+"\n");
            writer.newLine();
            writer.append("Product price: "+sprice+"\n");
            writer.newLine();
            writer.newLine();
        }
    }
    
    public void printshopDetails() throws IOException{
        Charset charset=Charset.forName("US-ASCII");
        try(BufferedWriter swriter=Files.newBufferedWriter(file, charset, StandardOpenOption.CREATE, StandardOpenOption.APPEND)){
            swriter.newLine();
            swriter.append("Shop ID: "+sid+"\n");
            swriter.newLine();
            swriter.append("Shop Name: "+name+"\n");
            swriter.newLine();
            swriter.append("Address: "+address+"\n");
            swriter.newLine();
            swriter.close();
        }
        
        Path copyfile=Paths.get("D:/Backup/BackupProductDetails.txt");
        if(Files.exists(copyfile)){
            Files.delete(copyfile);
            Files.copy(file,target);
        }else{
            Files.copy(file,target);
            //enterProductDetails();
        }
    }
    
    ////ENter shop details
    public static void main(String[] args) throws IOException{
        ComputerProducts obj=new ComputerProducts();
        obj.createDirectory();
    }
}