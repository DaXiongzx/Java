package game2;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.*;
import java.sql.SQLException;
import java.util.Timer;
import java.util.regex.Pattern;



class gameimage{
	ImageIcon p1p1=new ImageIcon("F:\\JavaEE_WorkSpace\\game2\\p1\\images\\p1p1.gif");
	ImageIcon p1p2=new ImageIcon("F:\\JavaEE_WorkSpace\\game2\\p1\\images\\p1p2.gif");
	ImageIcon p1p3=new ImageIcon("F:\\JavaEE_WorkSpace\\game2\\p1\\images\\p1p3.gif");
	ImageIcon p1p4=new ImageIcon("F:\\JavaEE_WorkSpace\\game2\\p1\\images\\p1p4.gif");
	ImageIcon p3p1=new ImageIcon("F:\\JavaEE_WorkSpace\\game2\\p3\\images\\good_01.gif");
	ImageIcon p3p2=new ImageIcon("F:\\JavaEE_WorkSpace\\game2\\p3\\images\\good_02.gif");
	ImageIcon p3p3=new ImageIcon("F:\\JavaEE_WorkSpace\\game2\\p3\\images\\good_03.gif");
	ImageIcon p3p4=new ImageIcon("F:\\JavaEE_WorkSpace\\game2\\p3\\images\\good_04.gif");
	ImageIcon p2p1=new ImageIcon("F:\\JavaEE_WorkSpace\\game2\\p4\\images\\p4p1.gif");
	ImageIcon p2p2=new ImageIcon("F:\\JavaEE_WorkSpace\\game2\\p4\\images\\p4p2.gif");
	ImageIcon p2p3=new ImageIcon("F:\\JavaEE_WorkSpace\\game2\\p4\\images\\p4p3.gif");
	ImageIcon p2p4=new ImageIcon("F:\\JavaEE_WorkSpace\\game2\\p4\\images\\p4p4.gif");
	ImageIcon p4p1=new ImageIcon("F:\\JavaEE_WorkSpace\\game2\\p7\\images\\p7p1.gif");
	ImageIcon p4p2=new ImageIcon("F:\\JavaEE_WorkSpace\\game2\\p7\\images\\p7p2.gif");
	ImageIcon p4p3=new ImageIcon("F:\\JavaEE_WorkSpace\\game2\\p7\\images\\p7p3.gif");
	ImageIcon p4p4=new ImageIcon("F:\\JavaEE_WorkSpace\\game2\\p7\\images\\p7p4.gif");
	ImageIcon p5p1=new ImageIcon("F:\\JavaEE_WorkSpace\\game2\\p8\\images\\apple_01.gif");
	ImageIcon p5p2=new ImageIcon("F:\\JavaEE_WorkSpace\\game2\\p8\\images\\apple_02.gif");
	ImageIcon p5p3=new ImageIcon("F:\\JavaEE_WorkSpace\\game2\\p8\\images\\apple_03.gif");
	ImageIcon p5p4=new ImageIcon("F:\\JavaEE_WorkSpace\\game2\\p8\\images\\apple_04.gif");
	
}

public class frame extends JFrame{
	public void inttostring(int[][]a,String[][]intstring) {
		for(int i=0;i<2;i++) {
			for(int j=0;j<2;j++) {
				intstring[i][j]=String.valueOf(a[i][j]);
			}
		}
		
	}
	
	public void stringtoint(int [][]a,String[][]intstring) {
		for(int i=0;i<2;i++) {
			for(int j=0;j<2;j++) {
				a[i][j]=Integer.parseInt(intstring[i][j]);
			}
		}
	}
	
	int [][]a1= {{3,2},{1,4}};
	int [][]a2= {{2,3},{1,4}};
	int [][]a3= {{3,4},{1,2}};
	int [][]a4= {{1,3},{2,4}};
	int [][]a5= {{1,4},{2,3}};

	public boolean judge(int [][]a) {
		int [][]b= {{1,2},{3,4}};
		for(int i=0;i<2;i++) {
			for(int j=0;j<2;j++) {
				if(a[i][j]==b[i][j]) continue;
				else return false;
			}
		}
		return true;
	}
	
	String [][] intstring= {{"a","b"},{"c","d"}};
	int [][]stringint= {{1,2},{3,4}};
	FileOutputStream fos=null;
	String pattern="[a-zA-Z]+";
	Pattern r=Pattern.compile(pattern);
	gameimage game=new gameimage();
	private static final long serialVersionUID = 1L;
	//ConnectionManager man=new ConnectionManager();
	Font font=new Font("宋体",Font.PLAIN,25);//格式
	//public array arr=new array();
	public JButton p1button1,p2button2,p3button3,p4button4;
	public JButton start_button,end_button;
	public JTextField namefield,scorefield,timefield;
	public JLabel namelabel,scorelabel,background,timelabel,gridlabel;
	public JDialog dialog;
	public String name;
	public int score=0;
	JButton judgebutton;
	JButton buttonl1,buttonl2,buttonl3,buttonl4,buttonl5;
	JButton [] buttons= {p1button1,p2button2};
	int count=0;//分数
	int time=0;
	boolean result=false;
	int count1=0;//用来记录点了几个按钮 点了两个的时候交换
	JFrame jf=this;
	class TimerTaskTest extends java.util.TimerTask{

		@Override
		public void run() {
			time++;
			String strtime=String.valueOf(time);
			timefield.setText(strtime);
			if(time==60) {
				String message="Times up,Your score is:"+score;
				JOptionPane.showMessageDialog(jf,message,"games over", JOptionPane.INFORMATION_MESSAGE);
				System.gc();
				cancel();
			}
			
		}
		
	}
	
	Timer timer=new Timer();
	
	public void exchangebutton(JButton button1,JButton button2) {
		ImageIcon p1p1=(ImageIcon) button1.getIcon();
		ImageIcon p1p2=(ImageIcon) button2.getIcon();
		button1.setIcon(p1p2);
		button2.setIcon(p1p1);
		String text1=button1.getText();
		String text2=button2.getText();
		button1.setText(text2);
		button2.setText(text1);
		
	}
	
	public void show1(String[][]b) {//将表格插入到界面中 //3 2 1 4

		p1button1=new JButton(b[0][0]);
		p2button2=new JButton(b[0][1]);
		p3button3=new JButton(b[1][0]);
		p4button4=new JButton(b[1][1]);

		p1button1.setIcon(game.p1p3);
		System.out.println("add p2");
		p2button2.setIcon(game.p1p2);
		System.out.println("end add p2");
		p3button3.setIcon(game.p1p1);
		p4button4.setIcon(game.p1p4);

		p1button1.setFont(font);
		p1button1.setBounds(120,255,240,174);
		p2button2.setFont(font);
		p2button2.setBounds(360,255,240,174);
		p3button3.setFont(font);
		p3button3.setBounds(120,430,240,174);
		p4button4.setFont(font);
		p4button4.setBounds(360,430,240,174);
		System.out.println("ok");
		for(int i=0;i<2;i++) {
			for(int j=0;j<2;j++) {
				System.out.println(b[i][j]);
			}
		}

		add(p1button1);
		add(p2button2);
		add(p3button3);
		add(p4button4);

	}
	
	public void show2(String[][]b) {//将表格插入到界面中 //2,3 1,4
		
		p1button1.setText(b[0][0]);
		p2button2.setText(b[0][1]);
		p3button3.setText(b[1][0]);
		p4button4.setText(b[1][1]);


		p1button1.setIcon(game.p2p2);
		p2button2.setIcon(game.p2p3);

		p3button3.setIcon(game.p2p1);
		p4button4.setIcon(game.p2p4);

		/*p1button1.setFont(font);
		p1button1.setBounds(120,255,240,174);
		p2button2.setFont(font);
		p2button2.setBounds(360,255,240,174);
		p3button3.setFont(font);
		p3button3.setBounds(120,430,240,174);
		p4button4.setFont(font);
		p4button4.setBounds(360,430,240,174);*/
		System.out.println("ok");
		for(int i=0;i<2;i++) {
			for(int j=0;j<2;j++) {
				System.out.println(b[i][j]);
			}
		}

		//add(p1button1);
		//add(p2button2);
		//add(p3button3);
		//add(p4button4);

	}
	
	public void show3(String[][]b) {//将表格插入到界面中 //3,4,1,2
		
		p1button1.setText(b[0][0]);
		p2button2.setText(b[0][1]);
		p3button3.setText(b[1][0]);
		p4button4.setText(b[1][1]);


		p1button1.setIcon(game.p3p3);

		p2button2.setIcon(game.p3p4);

		p3button3.setIcon(game.p3p1);
		p4button4.setIcon(game.p3p2);

		System.out.println("ok");
		for(int i=0;i<2;i++) {
			for(int j=0;j<2;j++) {
				System.out.println(b[i][j]);
			}
		}

	}
	
	public void show4(String[][]b) {//将表格插入到界面中 //{{1,3},{2,4}};
		
		p1button1.setText(b[0][0]);
		p2button2.setText(b[0][1]);
		p3button3.setText(b[1][0]);
		p4button4.setText(b[1][1]);


		p1button1.setIcon(game.p4p1);
		System.out.println("add p2");
		p2button2.setIcon(game.p4p3);

		p3button3.setIcon(game.p4p2);
		p4button4.setIcon(game.p4p4);

		System.out.println("ok");
		for(int i=0;i<2;i++) {
			for(int j=0;j<2;j++) {
				System.out.println(b[i][j]);
			}
		}

	}
	
	public void show5(String[][]b) {//将表格插入到界面中 //{{1,4},{2,3}};
		
		p1button1.setText(b[0][0]);
		p2button2.setText(b[0][1]);
		p3button3.setText(b[1][0]);
		p4button4.setText(b[1][1]);


		p1button1.setIcon(game.p5p1);

		p2button2.setIcon(game.p5p4);

		p3button3.setIcon(game.p5p2);
		p4button4.setIcon(game.p5p3);

		System.out.println("ok");
		for(int i=0;i<2;i++) {
			for(int j=0;j<2;j++) {
				System.out.println(b[i][j]);
			}
		}

	}
	
	class ButtonListener2 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String s=e.getActionCommand();
			if(s.equals("l2")) {
				inttostring(a2,intstring);
				show2(intstring);
				
			}
			if(s.equals("l3")) {
				inttostring(a3,intstring);
				show3(intstring);
				
			}
			if(s.equals("l4")) {
				inttostring(a4,intstring);
				show4(intstring);
				
			}
			if(s.equals("l5")) {
				inttostring(a5,intstring);
				show5(intstring);
				
			}
		}
	}
	
	
	
	class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String s=e.getActionCommand();
			if(s.equals("1")) {
				buttons[count1]=(JButton) e.getSource();
				count1++;
				if (count1==2) {
					JButton button1=buttons[0];
					JButton button2=buttons[1];
					exchangebutton(button1,button2);
					count1=0;
				}
				String text1=p1button1.getText();
				String text2=p2button2.getText();
				String text3=p3button3.getText();
				String text4=p4button4.getText();
				String [][]a1= {{text1,text2},{text3,text4}};
				for(int i=0;i<2;i++) {
					for (int j=0;j<2;j++) {
						System.out.println(a1[i][j]);
					}
				}
			}
			if(s.equals("2")) {
				buttons[count1]=(JButton) e.getSource();
				count1++;
				if (count1==2) {
					JButton button1=buttons[0];
					JButton button2=buttons[1];
					exchangebutton(button1,button2);
					count1=0;
				}
				String text1=p1button1.getText();
				String text2=p2button2.getText();
				String text3=p3button3.getText();
				String text4=p4button4.getText();
				String [][]a1= {{text1,text2},{text3,text4}};
				for(int i=0;i<2;i++) {
					for (int j=0;j<2;j++) {
						System.out.println(a1[i][j]);
					}
				}
			}
			if(s.equals("3")) {
				buttons[count1]=(JButton) e.getSource();
				count1++;
				if (count1==2) {
					JButton button1=buttons[0];
					JButton button2=buttons[1];
					exchangebutton(button1,button2);
					count1=0;
				}
				String text1=p1button1.getText();
				String text2=p2button2.getText();
				String text3=p3button3.getText();
				String text4=p4button4.getText();
				String [][]a1= {{text1,text2},{text3,text4}};
				for(int i=0;i<2;i++) {
					for (int j=0;j<2;j++) {
						System.out.println(a1[i][j]);
					}
				}
			}
			if(s.equals("4")) {
				buttons[count1]=(JButton) e.getSource();
				count1++;
				if (count1==2) {
					JButton button1=buttons[0];
					JButton button2=buttons[1];
					exchangebutton(button1,button2);
					count1=0;
				}
				String text1=p1button1.getText();
				String text2=p2button2.getText();
				String text3=p3button3.getText();
				String text4=p4button4.getText();
				String [][]a1= {{text1,text2},{text3,text4}};
				for(int i=0;i<2;i++) {
					for (int j=0;j<2;j++) {
						System.out.println(a1[i][j]);
					}
				}
			}
			if(s.equals("Judge")) {
				String text1=p1button1.getText();
				String text2=p2button2.getText();
				String text3=p3button3.getText();
				String text4=p4button4.getText();
				String [][]a1= {{text1,text2},{text3,text4}};
				for(int i=0;i<2;i++) {
					for (int j=0;j<2;j++) {
						System.out.print(a1[i][j]);
					}
				}
				stringtoint(stringint,a1);
				result=judge(stringint);
				if(result) {
					score+=10;

					String counts=String.valueOf(count);
					String scores=String.valueOf(score);
					String names=namefield.getText();
					try {
						fos=new FileOutputStream("F:\\Persional\\Desktop\\result.txt");
						byte bytes1[] = scores.getBytes();
						fos.write(bytes1);
						byte bytes2[]=names.getBytes();
						fos.write(bytes2);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					scorefield.setText(scores);
					JOptionPane.showMessageDialog(jf,"Congratulations","You have break in to a guarded point", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(jf,"Sorry","You have failed...", JOptionPane.INFORMATION_MESSAGE);
				}
				
				
			}
			if(s.equals("Start")) {
				String name=namefield.getText();
				boolean isMatch=Pattern.matches(pattern,name);
				if(isMatch) {
					timer.schedule(new TimerTaskTest(),0,1000);
				}
				//timer.schedule(new TimerTaskTest(),0,1000);
				else {
					JOptionPane.showMessageDialog(jf,"The name should be all characters","warning", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
	}
	
	
	public frame() {
		System.out.println("starts");
		setResizable(false);
		background=new JLabel(new ImageIcon("F:\\Persional\\Desktop\\Game Console\\background.jpg"));
		background.setFont(font);
		background.setBounds(-10,-110, 1000,1000);
		background.setOpaque(false);
		background.setOpaque(false);
		gridlabel=new JLabel(new ImageIcon("F:\\JavaEE_WorkSpace\\game2\\p1\\images\\grid.png"));
		gridlabel.setFont(font);
		gridlabel.setBounds(60, 130, 600,600);
		namelabel=new JLabel("Name:");
		namelabel.setFont(font);
		namelabel.setBounds(100, 100, 100,30);//label位置
		namefield=new JTextField("name");
		namefield.setBounds(180, 100, 100, 30);
		namefield.setFont(font);
		scorelabel=new JLabel("Score:");
		scorelabel.setBounds(100,150,100,30);
		scorelabel.setFont(font);
		scorefield=new JTextField("score");
		scorefield.setBounds(190, 150, 100,30);
		scorefield.setFont(font);
		timelabel=new JLabel("time");
		timelabel.setFont(font);
		timelabel.setBounds(100,200,100,30);
		timefield=new JTextField("0");
		timefield.setBounds(200,200,100,30);
		timefield.setFont(font);
		buttonl2=new JButton("l2");
		buttonl2.setFont(font);
		buttonl2.setBounds(700,100,100,30);
		buttonl3=new JButton("l3");
		buttonl3.setFont(font);
		buttonl3.setBounds(700,150,100,30);
		buttonl4=new JButton("l4");
		buttonl4.setFont(font);
		buttonl4.setBounds(700,200,100,30);
		buttonl5=new JButton("l5");
		buttonl5.setFont(font);
		buttonl5.setBounds(700,250,100,30);

		
		start_button=new JButton("Start");
		start_button.setFont(font);
		start_button.setBounds(450, 100, 100, 30);
		/*start_button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				timer.schedule(new TimerTaskTest(),0,1000);
			}
		});*/
		start_button.addActionListener(new ButtonListener());
		judgebutton=new JButton("Judge");
		judgebutton.setFont(font);
		judgebutton.setBounds(450,200,100,30);
		judgebutton.addActionListener(new ButtonListener());
		//Timer timer=new Timer();
		//timer.schedule(new TimerTaskTest(),1000,2000);
		/*for(int i=0;i<2;i++) {
			for(int j=0;j<2;j++)
				System.out.print(a1[i][j]);
		}*/
		
		inttostring(a1,intstring);
		/*for(int i=0;i<2;i++) {
			for(int j=0;j<2;j++)
				System.out.print(intstring[i][j]);
		}*/
		add(buttonl2);
		add(buttonl3);
		add(buttonl4);
		add(buttonl5);
		
		show1(intstring);
		add(namelabel);
		add(namefield);
		add(scorelabel);
		add(scorefield);
		add(timefield);
		add(timelabel);
		add(start_button);
		add(gridlabel);
		add(background);
		add(judgebutton);
		p1button1.addActionListener(new ButtonListener());
		p2button2.addActionListener(new ButtonListener());
		p3button3.addActionListener(new ButtonListener());
		p4button4.addActionListener(new ButtonListener());
		buttonl2.addActionListener(new ButtonListener2());
		buttonl3.addActionListener(new ButtonListener2());
		buttonl4.addActionListener(new ButtonListener2());
		buttonl5.addActionListener(new ButtonListener2());
		
		System.out.println("ends");
		setLayout(new BorderLayout());
		setSize(900, 900);
		setTitle("game2");
		setVisible(true);
	}

}
