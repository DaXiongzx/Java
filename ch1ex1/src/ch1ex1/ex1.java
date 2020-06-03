package ch1ex1;

import java.awt.FlowLayout;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.TextField;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

class frame extends JFrame{
	float x;
	float y;
	TextField lbx=new TextField();
	TextField lby=new TextField();
	class Mouse implements MouseMotionListener,MouseListener{
		//float x,y;
		@Override
		public void mouseMoved(MouseEvent e) {
			System.out.println("ok");
			Point p=MouseInfo.getPointerInfo().getLocation();
			x=(float) p.getX();
			y=(float) p.getY();
			String x1=String.valueOf(x);
			String y1=String.valueOf(y);
			lbx.setText(x1);
			lby.setText(y1);
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
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
			System.out.println("ok");
			Point p=MouseInfo.getPointerInfo().getLocation();
			x=(float) p.getX();
			y=(float) p.getY();
			String x1=String.valueOf(x);
			String y1=String.valueOf(y);
			lbx.setText(x1);
			lby.setText(y1);
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	public frame() {
		this.setBounds(400,200,400,300);
	    this.setLayout(new FlowLayout());
		this.setVisible(true);
		lbx.setBounds(100, 100, 20, 20);
		lby.setBounds(50, 100, 20, 30);
		this.add(lbx);
		this.add(lby);
		this.addMouseListener(new Mouse());
	}
}
public class ex1 {
	public static void main(String[] args) {
		frame a=new frame();
	}

}
