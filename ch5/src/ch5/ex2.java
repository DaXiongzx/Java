package ch5;

import java.awt.Color;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


class Conmess implements Runnable{
		JLabel l1,l2;
		JFrame fr;
	public void buildGui() {
		fr=new JFrame();
		fr.setVisible(true);
		fr.setSize(400, 200);
		fr.setLayout(null);
		l1=new JLabel();
		l1.setSize(20,20);
		l1.setBackground(Color.red);
		l1.setBounds(10,40,20,20);
		l1.setText("message");
		fr.add(l1);
		l2=new JLabel();
		l2.setSize(20,20);
		l2.setBackground(Color.yellow);
		l2.setBounds(10,80,20,20);
		l2.setText("Congratulations");
		fr.add(l2);
	}
	public Conmess() {
		buildGui();
	}
	public void runmessage() {
		Random ran=new Random();
		int s=ran.nextInt(180);
		for(int i=-10;i<400;i++) {
			l1.setBounds(i,s,100,20);
			try {
				Thread.sleep( 5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for(int i=420;i>0;i--) {
			l1.setBounds(i,s,100,20);
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		runcon();
	}
	public void runcon() {
		Random ran=new Random();
		int s=ran.nextInt(180);
		for(int i=-10;i<400;i++) {
			l2.setBounds(i,s,100,20);
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for(int i=420;i>0;i--) {
			l2.setBounds(i,s,100,20);
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		runmessage();
	}
	@Override
	public void run() {
		if(Thread.currentThread().getName().equals("message")) {
			runmessage();
		}
		else if(Thread.currentThread().getName().equals("Congratulations")) {
			runcon();
		}
		
	}
	
}
public class ex2 {
	public static void main(String[] args) {
		Conmess obj=new Conmess();
		Thread mess=new Thread(obj);
		Thread con=new Thread(obj);
		mess.setName("message");
		con.setName("Congratulations");
		mess.start();
		con.start();
	}

}
