package ch5;

import java.applet.Applet;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;


class frame implements Runnable{
	JFrame fr=new JFrame();
	JLabel jb=new JLabel();
	int x,y;
	class Mouse implements MouseMotionListener,MouseListener{
		//float x,y;
		@Override
		public void mouseMoved(MouseEvent e) {
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseClicked(MouseEvent e) {    //ok
			printovl();
			/*System.out.println("ok");
			x=createrand(100);
			y=createrand(200);
			System.out.println(x);
			System.out.println(y);
		    jb=new JLabel();
			jb.setSize(20,20);
			jb.setBackground(Color.yellow);
			jb.setBounds(x,y,20,20);
			jb.setText("ok");
			jb.setVisible(true);
			fr.add(jb);	
			System.out.println("nb");*/
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			/*System.out.println("ok");
			Point p=MouseInfo.getPointerInfo().getLocation();
			x=(float) p.getX();
			y=(float) p.getY();
			String x1=String.valueOf(x);
			String y1=String.valueOf(y);
			lbx.setText(x1);
			lby.setText(y1);*/
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	public int createrand(int x) {
		int num;
		Random rand=new Random();
		num=rand.nextInt(x);
		return num;
	}
	public void printovl() {
		int x=createrand(100);
		int y=createrand(100);
		Graphics g=fr.getGraphics();
		g.setColor(Color.blue);
		//g.fill
		g.drawArc(x, y, 20, 20, 0, 360);
		
	}
	public void buildGui() {
		fr.setVisible(true);
		fr.setSize(400, 200);
		fr.setLayout(new FlowLayout());
		/*JLabel jb=new JLabel();
		jb.setSize(20,20);
		jb.setBackground(Color.red);
		jb.setBounds(100,100,20,20);
		fr.add(jb);
		System.out.println("zxzx");*/
	}
	public void addlabel() {
		//System.out.println("ok1");
		fr.addMouseListener(new Mouse());
		//System.out.println("ok2");
	}
	@Override
	public void run() {
		addlabel();
	}
	public frame() {
		buildGui();
	}
	
}
public class Ex3{
	public static void main(String[] args) {
		/*JFrame fr=new JFrame();
		fr.setVisible(true);
		JLabel lb=new JLabel();
		lb.setBackground(bg);*/
		frame a=new frame();
		Thread th=new Thread(a);
		th.start();
	}
}
