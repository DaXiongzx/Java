package ch6;

public class ex3 {
	public static void main(String[] args) {
		System.out.println("Player 1 ready");
		System.out.println("Player 2 ready");
		new Thread(new teniness()).start();
		new Thread(new teniness()).start();
	}

}
class teniness implements Runnable{
	private static int player=1;
	public synchronized void action() {
		for(int t=0;t<10;t++) {
		while(player%2==0) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Ping->");
		player++;
		this.notifyAll();
		while(player%2==1) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("<-Pong");
		player++;
		this.notifyAll();
		
	}
	}
	@Override
	public void run() {
		action();
		
	}
	
}
