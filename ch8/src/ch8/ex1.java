package ch8;


import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchEvent;
import java.nio.file.WatchEvent.Kind;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.text.SimpleDateFormat;

import static java.nio.file.StandardWatchEventKinds.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class ex1 {
	
	private Path path=null;
	WatchService ws;
	Date d=new Date();
	SimpleDateFormat ft,ft1;
	String s1,s2;
	FileWriter f1;
	BufferedWriter b1;
	Scanner in=new Scanner(System.in);
	@SuppressWarnings({ })
	private void initialize()
	{
		ft = new SimpleDateFormat ("yyyy.MM.dd");
		ft1 = new SimpleDateFormat ("hh.mm.ss");
		s2="DirectoryLog "+ft.format(d)+" "+ft1.format(d)+".txt";
		System.out.println("Enter the directory: ");
		path=Paths.get(in.nextLine());
		try
		{
			ws=FileSystems.getDefault().newWatchService();
			path.register(ws, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);
	    }
		catch(IOException e)
		{
			System.out.println("IOException"+e.getMessage());
		}
	}
	@SuppressWarnings({ "unused", "rawtypes" })
	private void monitor() 
	{	
		try {
			f1 = new FileWriter(s2);
			b1 =new BufferedWriter(f1);
		} catch (IOException e1) {
			e1.printStackTrace();
		}	    
		WatchKey key=null;
		while(true)
		{
			try {
				key=ws.take(); //F:\Persional\Desktop
				for(WatchEvent event:key.pollEvents())
				{
					Kind kind=event.kind();
					System.out.println("The event that occurred on "+event.context().toString()+" is "+kind);
					b1.write("The event that occurred on "+event.context().toString()+" is "+kind);
					b1.newLine();
					b1.flush();
				}
			} catch (InterruptedException | IOException e) {
				e.printStackTrace();
			}
			boolean reset=key.reset();
			if(!reset)
			break;
		}
		try {
			b1.close();
			f1.close();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	public static void main(String[] args)
	{
		ex1 wsd=new ex1();
		wsd.initialize();
		wsd.monitor();
	}
}
