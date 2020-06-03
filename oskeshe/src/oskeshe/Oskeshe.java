package oskeshe;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import oskeshe.Frame3;

class Frame2 extends JFrame{	
	Font font=new Font("宋体",Font.PLAIN,25);//格式
	public JButton returnbutton=new JButton("Return");
	public JLabel resultlabel1,resultlabel2;
	public JTextField resultfield1,resultfield2;
	public int str=1;
	public JLabel p1,p2,p3,p4;
	public JButton ensurebutton1,ensurebutton2;
	public int n;
	public JLabel labelmax,labelallocation,labelneed,labelavailable,labelrequest,labeln;
	public JTextField fieldn;
	public JTextField max00=null,max01=null,max02=null,max10=null,max11=null,max12=null,max20=null,max21=null,max22=null,max30=null,max31=null,max32=null,namefield;
	public int maxvalue[][]= {{str,str,str},{str,str,str},{str,str,str},{str,str,str}};
	//public String valuemax00,valuemax01,valuemax02,valuemax10,valuemax11,valuemax12,valuemax20,valuemax21,valuemax22,valuemax30,valuemax31,valuemax32;
	public JTextField max[][]= null;
	public JTextField allocation00,allocation01,allocation02,allocation10,allocation11,allocation12,allocation20,allocation21,allocation22,allocation30,allocation31,allocation32;
	public JTextField allocation[][]= null;
	public int allocationvalue[][]={{str,str,str},{str,str,str},{str,str,str},{str,str,str}};
	public JTextField need00,need01,need02,need10,need11,need12,need20,need21,need22,need30,need31,need32;
	public JTextField need[][]= null;
	public int needvalue[][]={{str,str,str},{str,str,str},{str,str,str},{str,str,str}};
	public JTextField request0,request1,request2;
	public JTextField request[]= null;
	public int requestvalue[]= {str,str,str};
	public JTextField available0,available1,available2;
	public JTextField available[]=null;
	public int availablevalue[]= {str,str,str};
	public JLabel ra1,rb1,rc1,ra2,rb2,rc2,ra3,rb3,rc3,ra4,rb4,rc4;
	public JFrame jf=this;
	
	public  void show(JFrame jf) {
		labelmax=new JLabel("maxresouce:");
		labelmax.setFont(font);
		labelmax.setBounds(20, 0, 200, 40);
		
		ra1=new JLabel("A");
		ra1.setFont(font);
		ra1.setBounds(80, 60, 50, 30);
		rb1=new JLabel("B");
		rb1.setFont(font);
		rb1.setBounds(155,60, 50, 30);
		rc1=new JLabel("C");
		rc1.setFont(font);
		rc1.setBounds(245, 60, 50, 30);

		
		p1=new JLabel("p1:");
		p1.setFont(font);
		p1.setBounds(0, 90, 50, 50);
		p2=new JLabel("p2:");
		p2.setFont(font);
		p2.setBounds(0, 140, 50, 50);
		p3=new JLabel("p3:");
		p3.setFont(font);
		p3.setBounds(0, 190, 50, 50);
		p4=new JLabel("p4:");
		p4.setFont(font);
		p4.setBounds(0, 235, 50, 50);
		max00=new JTextField(" ");
		max01=new JTextField(" ");
		max02=new JTextField(" ");
		max10=new JTextField(" ");
		max11=new JTextField(" ");
		max12=new JTextField(" ");
		max20=new JTextField(" ");
		max21=new JTextField(" ");
		max22=new JTextField(" ");
		max30=new JTextField(" ");
		max31=new JTextField(" ");
		max32=new JTextField(" ");
		max00.setFont(font);
		max00.setBounds(50,100,80,30);
		max01.setFont(font);
		max01.setBounds(130,100,80,30);
		max02.setFont(font);
		max02.setBounds(210,100,80,30);
		max10.setFont(font);
		max10.setBounds(50,150,80,30);
		max11.setFont(font);
		max11.setBounds(130,150,80,30);
		max12.setFont(font);
		max12.setBounds(210,150,80,30);
		max20.setFont(font);
		max20.setBounds(50,200,80,30);
		max21.setFont(font);
		max21.setBounds(130,200,80,30);
		max22.setFont(font);
		max22.setBounds(210,200,80,30);
		max30.setFont(font);
		max30.setBounds(50,250,80,30);
		max31.setFont(font);
		max31.setBounds(130,250,80,30);
		max32.setFont(font);
		max32.setBounds(210,250,80,30);
		JTextField max1[][]= {{max00,max01,max02},{max10,max11,max12},{max20,max21,max22},{max30,max31,max32}};
		max=max1;
		jf.add(max00);
		jf.add(max01);
		jf.add(max02);
		jf.add(max10);
		jf.add(max11);
		jf.add(max12);
		jf.add(max20);
		jf.add(max21);
		jf.add(max22);
		jf.add(max30);
		jf.add(max31);
		jf.add(max32);
		jf.add(labelmax);
		jf.add(p1);
		jf.add(p2);
		jf.add(p3);
		jf.add(p4);
		jf.add(ra1);
		jf.add(rb1);
		jf.add(rc1);

	}
	
	public void show2(JFrame jf) {
		labelallocation=new JLabel("allocationresouce:");
		labelallocation.setFont(font);
		labelallocation.setBounds(400, 0, 300, 40);
		
		ra2=new JLabel("A");
		ra2.setFont(font);
		ra2.setBounds(420, 60, 50, 30);
		rb2=new JLabel("B");
		rb2.setFont(font);
		rb2.setBounds(510,60, 50, 30);
		rc2=new JLabel("C");
		rc2.setFont(font);
		rc2.setBounds(600, 60, 50, 30);

		allocation00=new JTextField(" ");
		allocation01=new JTextField(" ");
		allocation02=new JTextField(" ");
		allocation10=new JTextField(" ");
		allocation11=new JTextField(" ");
		allocation12=new JTextField(" ");
		allocation20=new JTextField(" ");
		allocation21=new JTextField(" ");
		allocation22=new JTextField(" ");
		allocation30=new JTextField(" ");
		allocation31=new JTextField(" ");
		allocation32=new JTextField(" ");
		allocation00.setFont(font);
		allocation00.setBounds(400,100,80,30);
		allocation01.setFont(font);
		allocation01.setBounds(480,100,80,30);
		allocation02.setFont(font);
		allocation02.setBounds(560,100,80,30);
		allocation10.setFont(font);
		allocation10.setBounds(400,150,80,30);
		allocation11.setFont(font);
		allocation11.setBounds(480,150,80,30);
		allocation12.setFont(font);
		allocation12.setBounds(560,150,80,30);
		allocation20.setFont(font);
		allocation20.setBounds(400,200,80,30);
		allocation21.setFont(font);
		allocation21.setBounds(480,200,80,30);
		allocation22.setFont(font);
		allocation22.setBounds(560,200,80,30);
		allocation30.setFont(font);
		allocation30.setBounds(400,250,80,30);
		allocation31.setFont(font);
		allocation31.setBounds(480,250,80,30);
		allocation32.setFont(font);
		allocation32.setBounds(560,250,80,30);
		JTextField allocation1[][]={{allocation00,allocation01,allocation02},{allocation10,allocation11,allocation12},{allocation20,allocation21,allocation22},{allocation30,allocation31,allocation32}};
		allocation=allocation1;
		jf.add(allocation00);
		jf.add(allocation01);
		jf.add(allocation02);
		jf.add(allocation10);
		jf.add(allocation11);
		jf.add(allocation12);
		jf.add(allocation20);
		jf.add(allocation21);
		jf.add(allocation22);
		jf.add(allocation30);
		jf.add(allocation31);
		jf.add(allocation32);
		jf.add(labelallocation);
		jf.add(ra2);
		jf.add(rb2);
		jf.add(rc2);

	}
	
	public void show3(JFrame jf) {
		labelneed=new JLabel("needresouce:");
		labelneed.setFont(font);
		labelneed.setBounds(800, 0, 300, 40);
		
		ra3=new JLabel("A");
		ra3.setFont(font);
		ra3.setBounds(780, 60, 50, 30);
		rb3=new JLabel("B");
		rb3.setFont(font);
		rb3.setBounds(860,60, 50, 30);
		rc3=new JLabel("C");
		rc3.setFont(font);
		rc3.setBounds(940, 60, 50, 30);

		need00=new JTextField("");
		need01=new JTextField(" ");
		need02=new JTextField(" ");
		need10=new JTextField(" ");
		need11=new JTextField(" ");
		need12=new JTextField(" ");
		need20=new JTextField(" ");
		need21=new JTextField(" ");
		need22=new JTextField(" ");
		need30=new JTextField(" ");
		need31=new JTextField(" ");
		need32=new JTextField(" ");
		need00.setFont(font);
		need00.setBounds(750,100,80,30);
		need01.setFont(font);
		need01.setBounds(830,100,80,30);
		need02.setFont(font);
		need02.setBounds(910,100,80,30);
		need10.setFont(font);
		need10.setBounds(750,150,80,30);
		need11.setFont(font);
		need11.setBounds(830,150,80,30);
		need12.setFont(font);
		need12.setBounds(910,150,80,30);
		need20.setFont(font);
		need20.setBounds(750,200,80,30);
		need21.setFont(font);
		need21.setBounds(830,200,80,30);
		need22.setFont(font);
		need22.setBounds(910,200,80,30);
		need30.setFont(font);
		need30.setBounds(750,250,80,30);
		need31.setFont(font);
		need31.setBounds(830,250,80,30);
		need32.setFont(font);
		need32.setBounds(910,250,80,30);
		JTextField need1[][]={{need00,need01,need02},{need10,need11,need12},{need20,need21,need22},{need30,need31,need32}};
		need=need1;
		jf.add(need00);
		jf.add(need01);
		jf.add(need02);
		jf.add(need10);
		jf.add(need11);
		jf.add(need12);
		jf.add(need20);
		jf.add(need21);
		jf.add(need22);
		jf.add(need30);
		jf.add(need31);
		jf.add(need32);
		jf.add(labelneed);
		jf.add(ra3);
		jf.add(rb3);
		jf.add(rc3);
		
	}

	public void show4(JFrame jf) {
		labelneed=new JLabel("availableresouce:");
		labelneed.setFont(font);
		labelneed.setBounds(0, 400, 300, 40);
		
		ra4=new JLabel("A");
		ra4.setFont(font);
		ra4.setBounds(780, 60, 50, 30);
		rb4=new JLabel("B");
		rb4.setFont(font);
		rb4.setBounds(860,60, 50, 30);
		rc4=new JLabel("C");
		rc4.setFont(font);
		rc4.setBounds(940, 60, 50, 30);
		
		available0=new JTextField(" ");
		available0.setFont(font);
		available0.setBounds(50,450, 80, 30);
		available1=new JTextField(" ");
		available1.setFont(font);
		available1.setBounds(130,450, 80, 30);
		available2=new JTextField(" ");
		available2.setFont(font);
		available2.setBounds(210,450, 80, 30);
		
		need00=new JTextField(" ");

		need00.setFont(font);
		need00.setBounds(750,100,80,30);
		JTextField available3[]={available0,available1,available2};
		available=available3;
		jf.add(labelneed);
		jf.add(available0);
		jf.add(available1);
		jf.add(available2);
	}
	
	public void show5(JFrame jf) {
		labelneed=new JLabel("requestresouce:");
		labelneed.setFont(font);
		labelneed.setBounds(400, 400, 300, 40);
		
		labeln=new JLabel("which process");
		labeln.setFont(font);
		labeln.setBounds(650, 400, 200, 30);
		
		fieldn=new JTextField(" ");
		fieldn.setFont(font);
		fieldn.setBounds(730, 450, 50, 30);
		
		ra4=new JLabel("A");
		ra4.setFont(font);
		ra4.setBounds(780, 60, 50, 30);
		rb4=new JLabel("B");
		rb4.setFont(font);
		rb4.setBounds(860,60, 50, 30);
		rc4=new JLabel("C");
		rc4.setFont(font);
		rc4.setBounds(940, 60, 50, 30);
		
		request0=new JTextField(" ");
		request0.setFont(font);
		request0.setBounds(400,450, 80, 30);
		request1=new JTextField(" ");
		request1.setFont(font);
		request1.setBounds(480,450, 80, 30);
		request2=new JTextField(" ");
		request2.setFont(font);
		request2.setBounds(560,450, 80, 30);
		
		need00=new JTextField(" ");

		need00.setFont(font);
		need00.setBounds(750,100,80,30);
		
		JTextField request01[]={request0,request1,request2};
		request=request01;
		jf.add(labelneed);
		jf.add(request0);
		jf.add(request1);
		jf.add(request2);
		jf.add(fieldn);
		jf.add(labeln);
	}
	
	public void show6(JFrame jf) {
		ensurebutton1=new JButton("ensure1");
		ensurebutton1.setFont(font);
		ensurebutton1.setBounds(1030,600,150,60);
		add(ensurebutton1);
		resultlabel1=new JLabel("result1:");
		resultlabel1.setFont(font);
		resultlabel1.setBounds(20, 600, 120, 60);
		add(resultlabel1);
		resultfield1=new JTextField("");
		resultfield1.setFont(font);
		resultfield1.setBounds(120, 600, 900, 60);
		add(resultfield1);
		ensurebutton2=new JButton("ensure2");
		ensurebutton2.setFont(font);
		ensurebutton2.setBounds(1030,700,150,60);
		add(ensurebutton2);
		resultlabel2=new JLabel("result2:");
		resultlabel2.setFont(font);
		resultlabel2.setBounds(20, 700, 120, 60);
		add(resultlabel2);
		resultfield2=new JTextField("");
		resultfield2.setFont(font);
		resultfield2.setBounds(120, 700, 900, 60);
		add(resultfield2);
	}
	
	public void getinput(JTextField max[][],JTextField allocation[][],JTextField need[][]) {
		for(int i=0;i<4;i++) {
			for(int j=0;j<3;j++) {
				//int i = Integer.parseInt( s );
				String valuemax=max[i][j].getText();
				System.out.print(valuemax);
				maxvalue[i][j]=Integer.parseInt(valuemax.trim());
				String valueallocation=allocation[i][j].getText();
				System.out.print(valueallocation);
				allocationvalue[i][j]=Integer.parseInt(valueallocation.trim());
				String valueneed=need[i][j].getText();
				System.out.print(valueneed);
				needvalue[i][j]=Integer.parseInt(valueneed.trim());
			}
		}
		for(int i=0;i<3;i++) {
			String valueavailable=available[i].getText();
			System.out.print(valueavailable);
			availablevalue[i]=Integer.parseInt(valueavailable.trim());
		}
	}
	
	public boolean com(int m[],int n[]) {
		int i,flag=0;
		int p=4,r=3;
		for(i=0;i<r;i++) {
			if(m[i]<n[i]) {
				flag=1;
				break;
			}
		}
			if(flag==1) return false;
			else return true; 
		
	}
	
	public boolean stest(int b[][],int c[][],int d[]) {
		int i,j,k,l,flag=0,flag1=0;
		int p=4,r=3;
		int t[]= {0,0,0},finish[] = {0,0,0,0},dd[]= {0,0,0};
		//for(i=0;i<4;i++) finish[i]=0;
		for(i=0;i<r;i++)dd[i]=d[i];
		for(k=0;k<p;k++) {
			for(i=0;i<p;i++) {
				if(finish[i]==1) continue;
				else {
					//for(j=0;j<r;j++) t[j]=c[i][j];
					if(com(dd,t)) {
						finish[i]=1;
						flag=1;
						for(l=0;l<r;l++) dd[l]=dd[l]+b[i][l];
						break;
					}
				}
				if(flag==1) break;
			}
		}
		for(l=0;l<p;l++) {
			if(finish[i]==0) flag1=1;
		}
		if(flag1==0) return true;
		else return false;
	}
	
	public void rtest(int b[][],int c[][],int d[],int req[],int n) {
		int i,j,p=4,r=3;
		int t[] = {0,0,0};
		n=n-1;
		for(i=0;i<r;i++) t[i]=c[n][i];
		if(com(d,req)&&com(t,req)) {
			for(j=0;j<r;j++) {
				b[n][j]=b[n][j]+req[j];
				c[n][j]=c[n][j]-req[j];
				d[j]=d[j]-req[j];
			}
			if(stest(b,c,d)) resultfield2.setText("允许"+(n+1)+"个进程申请资源！");
			else {
				resultfield2.setText("不允许"+(n+1)+"个进程申请资源，要复原");
				for(j=0;j<r;j++) {
					b[n][j]=b[n][j]-req[j];
					c[n][j]=c[n][j]+req[j];
					d[j]=d[j]+req[j];
				}
			}
		}
		else resultfield2.setText("申请资源出错");
	}
	
	class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String s=e.getActionCommand();
			if(s.equals("ensure1")) {
				System.out.println("Starts ensure1");
				getinput(max,allocation,need);
				for(int i=0;i<4;i++) {
					for(int j=0;j<4;j++) {
						//System.out.println(max[i][j].getText());
					}
				}

					if(stest(allocationvalue,needvalue,availablevalue)) resultfield1.setText("初始状态安全");
					else {
						resultfield1.setText("初始状态不安全");
						resultfield2.setText("无法分配");
					}
				
			}
			if(s.equals("ensure2")) {
				String number=fieldn.getText();
				int n=Integer.parseInt(number.trim());
				requestvalue[0]=Integer.parseInt(request0.getText().trim());
				requestvalue[1]=Integer.parseInt(request1.getText().trim());
				requestvalue[2]=Integer.parseInt(request2.getText().trim());
				rtest(allocationvalue,needvalue,availablevalue,requestvalue,n);
			}
			if(s.equals("Return")) {
				mainframe d=new mainframe();
			}
		}
	}
	
	
	public Frame2() {
		setLayout(null);
		setResizable(false);
		show(jf);
		show2(jf);
		show3(jf);
		show4(jf);
		show5(jf);
		show6(jf);
		returnbutton.setFont(font);
		returnbutton.setBounds(950, 800, 200, 100);
		returnbutton.addActionListener(new ButtonListener());
		ensurebutton1.addActionListener(new ButtonListener());
		ensurebutton2.addActionListener(new ButtonListener());
		jf.add(returnbutton);
		setSize(1200, 1000);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}

class yinghang{
	public void input(int [][]a,int [][]b,int[][]c,int []d) {
		int p=4,r=3;
		Scanner sc = new Scanner(System.in);
		System.out.println("please input max data");
		for(int i=0;i<p;i++) {
			for(int j=0;j<r;j++) {
				String value= sc.nextLine(); 
				a[i][j]= Integer.parseInt(value);
			}
		}
		System.out.println("please input allocation data");
		for(int i=0;i<p;i++) {
			for(int j=0;j<r;j++) {
				String value= sc.nextLine(); 
				b[i][j]= Integer.parseInt(value);
			}
		}
		//System.out.println(x);
	}
}

class mainframe extends JFrame{
	Font font=new Font("宋体",Font.PLAIN,25);//格式
	JFrame jf=this;
	JButton button1=new JButton("1");
	JButton button2=new JButton("2");
	JButton button3=new JButton("3");
	class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String s=e.getActionCommand();
			if(s=="1") {
				Frame1 a=new Frame1();
			}
			if(s=="2") {
				Frame2 b=new Frame2();
			}
			if(s=="3") {
				Frame3 c=new Frame3();
			}
		
		
		}
		}
	public mainframe() {
		setLayout(null);
		setResizable(false);
		button1.setFont(font);
		button1.setBounds(200, 200, 100, 50);
		button2.setFont(font);
		button2.setBounds(200,400,100,50);
		button3.setFont(font);
		button3.setBounds(200, 600, 100, 50);
		button1.addActionListener(new ButtonListener());
		button2.addActionListener(new ButtonListener());
		button3.addActionListener(new ButtonListener());
		jf.add(button1);
		jf.add(button2);
		jf.add(button3);
		setSize(1200, 1000);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}

	public class Oskeshe {
	public static void main(String [] args) {
		mainframe d=new mainframe();
	}

}
