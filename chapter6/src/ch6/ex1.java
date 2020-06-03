package ch6;

class table implements Runnable{
	private int i=0;
    public synchronized void printtable() {
    	while(i<=10) {
    		this.notify();
    		System.out.println(Thread.currentThread());
    		System.out.println(i);
    		try {
      			i=i+2;
    			//this.yield();
		        Thread.sleep(1000);
				this.wait();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    		//this.notifyAll();
    	}
    }
	@Override
	public void run() {
		printtable();
	}
	
}
public class ex1 {
	public static void main(String[] args) throws InterruptedException {
		table ex=new table();
		Thread thread1=new Thread(ex);
		thread1.setName("thread1");
		Thread thread2=new Thread(ex);
		thread2.setName("thread2");
		thread1.join(0);
		thread1.start();
		thread2.start();
		//System.out.println("ok");
	}
}