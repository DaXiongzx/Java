package oskeshe;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import oskeshe.clock;
import oskeshe.FIFO;
import oskeshe.LRU;

public class Frame3 extends JFrame{
	  Font font=new Font("ÀŒÃÂ",Font.PLAIN,25);//∏Ò Ω
	  int data[]= {1,2,3,4,5,6};
	  public JFrame jf=this;
      public JButton returnbutton=new JButton("Return"); 
      public JTextField p1=new JTextField(""),p2=new JTextField(""),p3=new JTextField(""),p4=new JTextField(""),p5=new JTextField(""),p6=new JTextField("");
      public JButton buttonfifo=new JButton("FIFO"),buttonlru=new JButton("LRU"),buttonclock=new JButton("Clock");
      public JTextField fiforesult=new JTextField(""),lruresult=new JTextField(""),clockresult=new JTextField(""); 
  
      class ButtonListener implements ActionListener{
  		public void actionPerformed(ActionEvent e) {
  			String s=e.getActionCommand();
  			if(s=="Clock") {
  				getinput();
  				System.out.println("stars clock");
  				clock gg = new clock();
  				System.out.println("please input the sequence:");
  				gg.sequence=data;
  				//gg.huoqu();
  				gg.clock();
  				clockresult.setText(gg.clockresult1);
  				System.out.println("ends clock");
  			}
  			if(s=="FIFO") {
  				getinput();
				FIFO gg = new FIFO();
				gg.input=data;
  				gg.fifo();
  				fiforesult.setText(gg.FIFOresult1);
  			}
  			if(s=="LRU") {
  				getinput();
  				LRU lru=new LRU();
  				lru.queue(data);
  				lruresult.setText(lru.LRUresult1);
  			}
  			if(s=="Return") {
  				mainframe d=new mainframe();
  			}
  			
  		}
    	}
      
      public void show(JFrame jf) {
    	  returnbutton.setFont(font);
    	  returnbutton.setBounds(950, 800, 200, 100);
    	  returnbutton.addActionListener(new ButtonListener());
    	  p1.setFont(font);
    	  p1.setBounds(200, 30, 80, 50);
    	  p2.setFont(font);
    	  p2.setBounds(300, 30, 80, 50);
    	  p3.setFont(font);
    	  p3.setBounds(400, 30, 80, 50);
    	  p4.setFont(font);
    	  p4.setBounds(500, 30, 80, 50);
    	  p5.setFont(font);
    	  p5.setBounds(600, 30, 80, 50);
    	  p6.setFont(font);
    	  p6.setBounds(700, 30, 80, 50);
    	  jf.add(returnbutton);
    	  jf.add(p1);
    	  jf.add(p2);
    	  jf.add(p3);
    	  jf.add(p4);
    	  jf.add(p5);
    	  jf.add(p6);
      }
      
      public void show1(JFrame jf) {
    	  buttonfifo.setFont(font);
    	  buttonfifo.setBounds(950, 400, 100, 100);
    	  buttonfifo.addActionListener(new ButtonListener());
    	  buttonlru.setFont(font);
    	  buttonlru.setBounds(950, 520, 100, 100);
    	  buttonlru.addActionListener(new ButtonListener());
    	  buttonclock.setFont(font);
    	  buttonclock.setBounds(950, 640, 100, 100);
    	  buttonclock.addActionListener(new ButtonListener());
    	  jf.add(buttonclock);
    	  jf.add(buttonfifo);
    	  jf.add(buttonlru);
      }
      
      public void show2(JFrame jf) {
    	  fiforesult.setFont(font);
    	  fiforesult.setBounds(50,100,800,250);
    	  lruresult.setFont(font);
    	  lruresult.setBounds(50,400,800,250);
    	  clockresult.setFont(font);
    	  clockresult.setBounds(50,700,800,250);
    	  jf.add(fiforesult);
    	  jf.add(lruresult);
    	  jf.add(clockresult);
      }
      
      public void getinput() {
    	int data1[]= {1,2,3,4,5,6};
    	String arrive00value="";
  		arrive00value=p1.getText();
  		data1[0]=Integer.parseInt(arrive00value.trim());
  		String cost01value=p2.getText();
  		data1[1]=Integer.parseInt(cost01value.trim());
  		String arrive10value=p3.getText();
  		data1[2]=Integer.parseInt(arrive10value.trim());
  		String cost11value=p4.getText();
  		data1[3]=Integer.parseInt(cost11value.trim());
  		String arrive20value=p5.getText();
  		data1[4]=Integer.parseInt(arrive20value.trim());
  		String cost21value=p6.getText();
  		data1[5]=Integer.parseInt(cost21value.trim());
  		data=data1;
  		
      }


      
      public Frame3() {
  		setLayout(null);
  		setResizable(false);
    	show(jf);
    	show1(jf);
    	show2(jf);
    	System.out.println("ok");
    	buttonclock.addActionListener(new ButtonListener());
		setSize(1200, 1000);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
      }
      
  	
      
      public static void main(String [] args) {
    	  Frame3 c=new Frame3();
      }
      
}
