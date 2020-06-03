 package ch6;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



class table1 implements Runnable{
    public void printnumber() {
    	for(int i=0;i<11;i++) {
    		System.out.println(Thread.currentThread());
    		System.out.println(i);
    		try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	Thread.yield();
    }
	@Override
	public void run() {
		printnumber();
		
	}
	
}
class table2 implements Runnable{
	public void printnumber() {
		for(int i=11;i<=20;i++) {
			System.out.println(Thread.currentThread());
			System.out.println(i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Thread.yield();
	}
	@Override
	public void run() {
		printnumber();
		
	}
}
public class ex2 {
	public static void main(String[] args) {
		ExecutorService exec=Executors.newSingleThreadExecutor();
		table1 t1=new table1();
		table2 t2=new table2();
		Runnable []a=new Runnable[2];
		a[0]=t1;
		a[1]=t2;

		//exec.submit(t1);
		//exec.submit(t2);
    	for(int i=0;i<2;i++) {
    		exec.execute(a[i]);
    		//System.out.println(i);
    		//exec.execute(a[i]);
    		//System.out.println(i);
	    }
    	exec.shutdown();

   }
}
