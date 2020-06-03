package ch5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class lifoff implements Runnable{
	int i=1;
    static int chr=65;
	@Override
	public void run() {
		System.out.println("Thread"+(char)(chr)+"starts");
		while(i<10) {
			System.out.println("thread"+" "+(char)(chr)+" "+"in for loop"+" "+i);
			i++;
		}
		System.out.println("Thread"+(char)(chr)+"exits");
		System.out.println("Thrad"+(char)(chr)+"sleeping for 5 seconds");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	chr++;	
	}
	
}
public class ex1 {
    public static void main(String[] args) {
    	//Thread current=Thread.currentThread();
    	ExecutorService exec=Executors.newSingleThreadExecutor();
    	for(int i=0;i<2;i++) {
    		exec.execute(new lifoff());
    		//Thread th=new Thread(new lifoff);
    		//Thread.join(th);
    	}
    	/*Thread a=new Thread(new lifoff());
    	a.start();
    	Thread b=new Thread(new lifoff());
    	b.start();*/
    	exec.shutdown();
    	while(true) {
    		if(exec.isTerminated()) {
    			System.out.println("Main");
    			break;
    		}
    	}
    	
    	
    }
}
