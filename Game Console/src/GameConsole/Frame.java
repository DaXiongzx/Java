package GameConsole;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.SQLException;
import java.util.regex.Pattern;

class fruitimage{
	ImageIcon apple=new ImageIcon("F:\\Persional\\Desktop\\Game Console\\apple.jpg");
	ImageIcon banana=new ImageIcon("F:\\Persional\\Desktop\\Game Console\\banana.jpg");
	ImageIcon Hami=new ImageIcon("F:\\Persional\\Desktop\\Game Console\\Hami-melon.png");
	ImageIcon grape=new ImageIcon("F:\\Persional\\Desktop\\Game Console\\grape.jpg");
	ImageIcon peach=new ImageIcon("F:\\Persional\\Desktop\\Game Console\\peach.jpg");
	ImageIcon pear=new ImageIcon("F:\\Persional\\Desktop\\Game Console\\pear.jpg");
	ImageIcon straw=new ImageIcon("F:\\Persional\\Desktop\\Game Console\\strawberry.jpg");
	ImageIcon water=new ImageIcon("F:\\Persional\\Desktop\\Game Console\\watermelon.jpg");
	ImageIcon bac=new ImageIcon("F:\\Persional\\Desktop\\Game Console\\good.jpeg");
}

class Frame extends JFrame{
	/**
	 * 
	 */
	String namepattern="[a-zA-Z]+";
	Pattern rname=Pattern.compile(namepattern);
	String idpattern="\\d+";
	Pattern rid=Pattern.compile(idpattern);
	
	fruitimage fruit=new fruitimage();
	private static final long serialVersionUID = 1L;
	ConnectionManager man=new ConnectionManager();
	Font font=new Font("宋体",Font.PLAIN,25);//格式
	String[][] b={{"peach","banana","grape","apple"},{"pear","Hami","straw","water"},{"apple","peach","grape","banana"},{"water","straw","pear","Hami"}};
	public JButton start_button,end_button;
	public JLabel background,picturelabel2,picturelabel1,picturelabel,label1,label2,label3,label4,label5;
	public  JButton button1,button2,button3,button4,button5,button6,button7,button8,button9,button10,button11,button12,button13,button14,button15,button16;
	public JTextField namefield,recordfield,press,end,idfield;
	public String name1="";
	public String name2="";
	public String result="false";
	public String name;
	public int num=0;
	public String num1=Integer.toString(num);
	int presstime=0;
	String pressnum;
	int x;//reusult
	int count=0;
	int countre=0;  //来确认是否到8，到8就算过关；
	String [] test= {"yes","yes"};
	int t=0; //判断名字id对错能否进入数据库
	JFrame jf=this;
	
	public JButton [] button= {button1,button2};

	public  void show(String[][]b) {//将表格插入到界面中

		button1=new JButton(b[0][0]);
		button2=new JButton(b[0][1]);
		button3=new JButton(b[0][2]);
		button4=new JButton(b[0][3]);
		button5=new JButton(b[1][0]);
		button6=new JButton(b[1][1]);
		button7=new JButton(b[1][2]);
		button8=new JButton(b[1][3]);
		button9=new JButton(b[2][0]);
		button10=new JButton(b[2][1]);
		button11=new JButton(b[2][2]);
		button12=new JButton(b[2][3]);
		button13=new JButton(b[3][0]);
		button14=new JButton(b[3][1]);
		button15=new JButton(b[3][2]);
		button16=new JButton(b[3][3]);
		button1.setIcon(fruit.bac);
		button2.setIcon(fruit.bac);
		button3.setIcon(fruit.bac);
		button4.setIcon(fruit.bac);
		button5.setIcon(fruit.bac);
		button6.setIcon(fruit.bac);
		button7.setIcon(fruit.bac);
		button8.setIcon(fruit.bac);
		button9.setIcon(fruit.bac);
		button10.setIcon(fruit.bac);
		button11.setIcon(fruit.bac);
		button12.setIcon(fruit.bac);
		button13.setIcon(fruit.bac);
		button14.setIcon(fruit.bac);
		button15.setIcon(fruit.bac);
		button16.setIcon(fruit.bac);
		button1.setFont(font);
		button1.setBounds(165,326,140,113);
		button2.setFont(font);
		button2.setBounds(306,326,140,113);
		button3.setFont(font);
		button3.setBounds(446,326,140,115);
		button4.setFont(font);
		button4.setBounds(586,326,140,115);
		button5.setFont(font);
		button5.setBounds(165,441,140,113);
		button6.setFont(font);
		button6.setBounds(306,441,140,113);
		button7.setFont(font);
		button7.setBounds(446,441,140,113);
		button8.setFont(font);
		button8.setBounds(586,441,140,113);
		button9.setFont(font);
		button9.setBounds(165, 554,140,113);
		button10.setFont(font);
		button10.setBounds(306, 554,140,113);
		button11.setFont(font);
		button11.setBounds(446, 554,140,113);
		button12.setFont(font);
		button12.setBounds(586, 554,140,113);
		button13.setFont(font);
		button13.setBounds(165, 667,140,113);
		button14.setFont(font);
		button14.setBounds(306, 667,140,113);
		button15.setFont(font);
		button15.setBounds(446, 667,140,113);
		button16.setFont(font);
		button16.setBounds(586, 667,140,113);
		add(button1);
		add(button2);
		add(button3);
		add(button4);
		add(button5);
		add(button6);
		add(button7);
		add(button8);
		add(button9);
		add(button10);
		add(button11);
		add(button12);
		add(button13);
		add(button14);
		add(button15);
		add(button16);
	}
	
	class ButtonListener2 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String s=e.getActionCommand();
			if(s.equals("Start")) {
				System.out.println("this is start button");
				name1=namefield.getText();
				String id=idfield.getText();
				boolean isnameMatch=Pattern.matches(namepattern,name1);
				boolean isidMatch=Pattern.matches(idpattern, id);
				if(isnameMatch==false) {
					JOptionPane.showMessageDialog(jf,"The name should all be characters","warning", JOptionPane.INFORMATION_MESSAGE);
					t=0;
				}
				else if(isidMatch==false) {
					JOptionPane.showMessageDialog(jf,"The id should be all numbers","warning", JOptionPane.INFORMATION_MESSAGE);
					t=0;
				}
				else
					t=1;
				if(t==1) {
				try {
					System.out.println("yes");
					recordfield.setText(man.show());
					System.out.println("yes");
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			}
			
			if(s.equals("END")) {
				System.out.println("this is end");
				//name=namefield.getText();
				if(countre>=8) {
					result="Success ^_^";
					System.out.println(result);
					x=1;
					picturelabel1.setVisible(true);
					picturelabel2.setVisible(false);
					try {
						man.add(idfield.getText(),namefield.getText(), presstime,x);
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}	
				end.setText(result);
				
		}
				else {
					result="Fail ...";
					System.out.println(result);
					x=0;
					picturelabel1.setVisible(false);
					picturelabel2.setVisible(true);
					try {
						man.add(idfield.getText(),namefield.getText(), presstime,x);
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}			
				end.setText(result);
				//System.out.println(result);
				}
			
	}
		}
	}
	class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String s=e.getActionCommand();
			if(s.equals("peach")) {
				System.out.println("this is peach");
				test[count]="peach";
				((AbstractButton) e.getSource()).setIcon(fruit.peach);
				button[count]=(JButton) e.getSource();
				presstime++;
				count++;
				if(count==2) {
					String test1=test[0];
					String test2=test[1];
					if(test1.equals(test2)) {
						//System.out.println("they are the same");
						countre++;
						test[0]="yes";
						test[1]="yes";
						count=0;
					}
					else {
						for(JButton buttons:button) {
							buttons.setIcon(fruit.bac);
						}
						test[0]="yes";
						test[1]="yes";
						count=0;
					}
				}
				System.out.println(countre);
				pressnum=Integer.toString(presstime);
				press.setText(pressnum);
				//namefield.setText(" ");
				/*try {
					recordfield.setText(man.show());
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}*/
				picturelabel1.setVisible(false);
				picturelabel2.setVisible(false);
			}
			if(s.equals("banana")) {
				test[count]="banana";
				((AbstractButton) e.getSource()).setIcon(fruit.banana);
				button[count]=(JButton) e.getSource();
				presstime++;
				count++;
				if(count==2) {
					String test1=test[0];
					String test2=test[1];
					if(test1.equals(test2)) {
						//System.out.println("they are the same");
						countre++;
						test[0]="yes";
						test[1]="yes";
						count=0;
					}
					else {
						for(JButton buttons:button) {
							buttons.setIcon(fruit.bac);
						}
						test[0]="yes";
						test[1]="yes";
						count=0;
					}
				}
				System.out.println(countre);
				pressnum=Integer.toString(presstime);
				press.setText(pressnum);
				//namefield.setText(" ");
				/*try {
					recordfield.setText(man.show());
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}*/
				picturelabel1.setVisible(false);
				picturelabel2.setVisible(false);
			}
			if(s.equals("grape")) {
				test[count]="grape";
				((AbstractButton) e.getSource()).setIcon(fruit.grape);
				button[count]=(JButton) e.getSource();
				presstime++;
				count++;
				if(count==2) {
					String test1=test[0];
					String test2=test[1];
					if(test1.equals(test2)) {
						//System.out.println("they are the same");
						countre++;
						test[0]="yes";
						test[1]="yes";
						count=0;
					}
					else {
						for(JButton buttons:button) {
							buttons.setIcon(fruit.bac);
						}
						test[0]="yes";
						test[1]="yes";
						count=0;
					}
				}
				System.out.println(countre);
				pressnum=Integer.toString(presstime);
				press.setText(pressnum);
				//namefield.setText(" ");
				/*try {
					recordfield.setText(man.show());
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}*/
				picturelabel1.setVisible(false);
				picturelabel2.setVisible(false);
			}
			if(s.equals("apple")) {
				test[count]="apple";
				((AbstractButton) e.getSource()).setIcon(fruit.apple);
				button[count]=(JButton) e.getSource();
				presstime++;
				count++;
				if(count==2) {
					String test1=test[0];
					String test2=test[1];
					if(test1.equals(test2)) {
						//System.out.println("they are the same");
						countre++;
						test[0]="yes";
						test[1]="yes";
						count=0;
					}
					else {
						for(JButton buttons:button) {
							buttons.setIcon(fruit.bac);
						}
						test[0]="yes";
						test[1]="yes";
						count=0;
					}
				}
				pressnum=Integer.toString(presstime);
				press.setText(pressnum);
				//namefield.setText(" ");
				/*try {
					recordfield.setText(man.show());
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}*/
				System.out.println(countre);
				picturelabel1.setVisible(false);
				picturelabel2.setVisible(false);
			}
			if(s.equals("pear")) {
				test[count]="pear";
				((AbstractButton) e.getSource()).setIcon(fruit.pear);
				button[count]=(JButton) e.getSource();
				presstime++;
				count++;
				if(count==2) {
					String test1=test[0];
					String test2=test[1];
					if(test1.equals(test2)) {
						//System.out.println("they are the same");
						countre++;
						test[0]="yes";
						test[1]="yes";
						count=0;
					}
					else {
						for(JButton buttons:button) {
							buttons.setIcon(fruit.bac);
						}
						test[0]="yes";
						test[1]="yes";
						count=0;
					}
				}
				pressnum=Integer.toString(presstime);
				press.setText(pressnum);
				//namefield.setText(" ");
				/*try {
					recordfield.setText(man.show());
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}*/
				System.out.println(countre);
				picturelabel1.setVisible(false);
				picturelabel2.setVisible(false);
			}
			if(s.equals("Hami")) {
				test[count]="Hami";
				((AbstractButton) e.getSource()).setIcon(fruit.Hami);
				button[count]=(JButton) e.getSource();
				presstime++;
				count++;
				if(count==2) {
					String test1=test[0];
					String test2=test[1];
					if(test1.equals(test2)) {
						//System.out.println("they are the same");
						countre++;
						test[0]="yes";
						test[1]="yes";
						count=0;
					}
					else {
						for(JButton buttons:button) {
							buttons.setIcon(fruit.bac);
						}
						test[0]="yes";
						test[1]="yes";
						count=0;
					}
				}
				System.out.println(countre);
				pressnum=Integer.toString(presstime);
				press.setText(pressnum);
				//namefield.setText(" ");
				/*try {
					recordfield.setText(man.show());
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}*/
				picturelabel1.setVisible(false);
				picturelabel2.setVisible(false);
			}
			if(s.equals("straw")) {
				test[count]="straw";
				((AbstractButton) e.getSource()).setIcon(fruit.straw);
				button[count]=(JButton) e.getSource();
				presstime++;
				count++;
				if(count==2) {
					String test1=test[0];
					String test2=test[1];
					if(test1.equals(test2)) {
						//System.out.println("they are the same");
						countre++;
						test[0]="yes";
						test[1]="yes";
						count=0;
					}
					else {
						for(JButton buttons:button) {
							buttons.setIcon(fruit.bac);
						}
						test[0]="yes";
						test[1]="yes";
						count=0;
					}
				}
				System.out.println(countre);
				pressnum=Integer.toString(presstime);
				press.setText(pressnum);
				//namefield.setText(" ");
				/*try {
					recordfield.setText(man.show());
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}*/
				picturelabel1.setVisible(false);
				picturelabel2.setVisible(false);
			}
			if(s.equals("water")) {
				test[count]="water";
				((AbstractButton) e.getSource()).setIcon(fruit.water);
				button[count]=(JButton) e.getSource();
				presstime++;
				count++;
				if(count==2) {
					String test1=test[0];
					String test2=test[1];
					if(test1.equals(test2)) {
						//System.out.println("they are the same");
						countre++;
						test[0]="yes";
						test[1]="yes";
						count=0;
					}
					else {
						for(JButton buttons:button) {
							buttons.setIcon(fruit.bac);
						}
						test[0]="yes";
						test[1]="yes";
						count=0;
					}
				}
				System.out.println(countre);
				pressnum=Integer.toString(presstime);
				press.setText(pressnum);
				//namefield.setText(" ");
				/*try {
					recordfield.setText(man.show());
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}*/
				picturelabel1.setVisible(false);
				picturelabel2.setVisible(false);
			}
	}
	}
	
	public Frame() {
		setResizable(false);
		
		background=new JLabel(new ImageIcon("F:\\Persional\\Desktop\\Game Console\\background.jpg"));
		background.setFont(font);
		background.setBounds(-10,-110, 1000,1000);
		background.setOpaque(false);
		background.setOpaque(false);
		picturelabel1=new JLabel(new ImageIcon("F:\\Persional\\Desktop\\Game Console\\success.png"));
		picturelabel1.setFont(font);
		picturelabel1.setBounds(550,40, 280, 300);
		picturelabel1.setVisible(false);
		picturelabel2=new JLabel(new ImageIcon("F:\\Persional\\Desktop\\Game Console\\fail.png"));
		picturelabel2.setFont(font);
		picturelabel2.setBounds(550, 40, 280, 300);
		picturelabel2.setVisible(false);
		namefield=new JTextField(name1);
		namefield.setBounds(180, 88, 100, 30);
		namefield.setFont(font);
		label1=new JLabel("Name:");
		label1.setFont(font);
		label1.setBounds(100, 50, 100,100);//label位置
		label2=new JLabel("Record Holder:");
		label2.setBounds(100,100,300,100);
		label2.setFont(font);
		recordfield=new JTextField(name2);
		recordfield.setBounds(290, 138, 100, 30);
		recordfield.setFont(font);
		label3=new JLabel("Key Press:");
		label3.setFont(font);
		label3.setBounds(100, 150, 300, 100);
		label4=new JLabel("Result:");
		label4.setFont(font);
		label4.setBounds(100, 230, 100, 30);
		label5=new JLabel("ID");
		label5.setFont(font);
		label5.setBounds(100,10,100,100);
		idfield=new JTextField("");
		idfield.setBounds(150,50,100,30);
		idfield.setFont(font);
		end=new JTextField();
		end.setFont(font);
		end.setBounds(200, 230, 200, 30);
		press=new JTextField(num1);
		press.setFont(font);
		press.setBounds(240, 190, 100, 30);

		start_button=new JButton("Start");
		start_button.setFont(font);
		start_button.setBounds(450, 200, 100, 30);
		//start_button.setFont(font);
		end_button=new JButton("END");
		end_button.setFont(font);
		end_button.setBounds(450,250,100,30);

		show(b);
		button1.addActionListener(new ButtonListener());
		button2.addActionListener(new ButtonListener());
		button3.addActionListener(new ButtonListener());
		button4.addActionListener(new ButtonListener());
		button5.addActionListener(new ButtonListener());
		button6.addActionListener(new ButtonListener());
		button7.addActionListener(new ButtonListener());
		button8.addActionListener(new ButtonListener());
		button9.addActionListener(new ButtonListener());
		button10.addActionListener(new ButtonListener());
		button11.addActionListener(new ButtonListener());
		button12.addActionListener(new ButtonListener());
		button13.addActionListener(new ButtonListener());
		button14.addActionListener(new ButtonListener());
		button15.addActionListener(new ButtonListener());
		button16.addActionListener(new ButtonListener());
		start_button.addActionListener(new ButtonListener2());
		end_button.addActionListener(new ButtonListener2());
		add(label1);
		add(namefield);
		add(label2);
		add(recordfield);
		add(label3);
		add(press);
		add(label4);
		add(end);
		add(label5);
		System.out.println("start starts");
		add(start_button);
		add(end_button);
		System.out.println("this is starts ends");
		add(idfield);
		//add(picturelabel);
		add(picturelabel1);
		add(picturelabel2);
		add(background);
		setLayout(new BorderLayout());
		setSize(900, 900);
		setTitle("Game Console");
		setVisible(true);

	}
}

	



	

