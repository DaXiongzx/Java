package ch3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class ToDolist {
     public void showMenu() 
    {
        int option;
		Scanner sc = new Scanner(System.in);

        System.out.println("---------Menu---------");
        System.out.println("1. Event");
        System.out.println("2. Meeting");
        System.out.println("3. Exit");
        System.out.print("\nChoose the option (1/2/3): ");

        option = sc.nextInt();

        switch (option) 
        {
            case 1: createEvent();
                    break;
            case 2: createMeeting();
                    break;
            case 3: System.exit(0);
                    break;
            default: showMenu();
                    break;
        }
    }
     public void createEvent()
   {
	Scanner sc=new Scanner(System.in);
	   String name,time,location,content;
       System.out.println("===============================================");
	   System.out.print("Enter the name:");
	   name=sc.nextLine();
	   System.out.print("\nEnter the time:");
	   SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd",Locale.CHINA);
 	   time=sc.nextLine();
 	   Date nowDate=new Date();
 	   Date pastDate;
	try {
		pastDate = sdf.parse(time);
 	    boolean flag=pastDate.before(nowDate);
 	    if(flag)
 	    {
 	    	System.out.println("The date is worry");
 	    	System.exit(0);
 	    }
	  } catch (ParseException e) {
		e.printStackTrace();
	}
       System.out.print("\nEnter the location:");
	   location=sc.nextLine();
	   System.out.print("\nEnter the content:");
	   content=sc.nextLine();
	   Event sObj=new Event(name,time,location,content);
	   TaskProcessor<Event>message1=new TaskProcessor<>(sObj);
	   message1.printResult();
   }
    
    public void createMeeting()
    {
		Scanner sc=new Scanner(System.in);
    	String topic,name,time,location;
    	System.out.println("==============================================");
    	System.out.print("Enter the name:");
 	   name=sc.nextLine();
 	   System.out.print("\nEnter the time:");
 	   SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd",Locale.CHINA);
 	   time=sc.nextLine();
 	   Date nowDate=new Date();
 	   Date pastDate;
	try {
		pastDate = sdf.parse(time);
 	    boolean flag=pastDate.before(nowDate);
 	    if(flag)
 	    {
 	    	System.out.println("The date is worry");
 	    	System.exit(0);
 	    }
	  } catch (ParseException e) {
		e.printStackTrace();
	}
       System.out.print("\nEnter the location:");
 	   location=sc.nextLine();
 	   System.out.print("\nEnter the topic:");
 	   topic=sc.nextLine();
 	   Meeting eObj=new Meeting(name,time,location,topic);
       TaskProcessor<Meeting> message2=new TaskProcessor<>(eObj);    	
       message2.printResult();
    }
      
    public static void main(String[] args)
    {
        ToDolist tdl = new ToDolist();
        tdl.showMenu();
    }
}