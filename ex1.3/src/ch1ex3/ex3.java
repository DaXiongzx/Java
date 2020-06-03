package ch1ex3;
import java.awt.FlowLayout;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.TextField;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JLabel;



class frame extends JFrame{
	float x;
	float y;
	TextField lbx=new TextField();
	TextField lby=new TextField();
	class Window implements WindowListener {

		@Override
		public void windowOpened(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowClosing(WindowEvent e) {
			System.out.println("您关闭了窗口");
			
		}

		@Override
		public void windowClosed(WindowEvent e) {
			System.out.println("您关闭了窗口");
			
		}

		@Override
		public void windowIconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeiconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowActivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeactivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

	}
	public frame() {
		this.setBounds(400,200,400,300);
	    this.setLayout(new FlowLayout());
		this.setVisible(true);
		lbx.setBounds(100, 100, 20, 20);
		lby.setBounds(50, 100, 20, 30);
		//this.add(lbx);
		//this.add(lby);
		this.addWindowListener(new Window());
	}
}
public class ex3 {
	
	public static void main(String[] args) {
		frame a=new frame();
	}
}
