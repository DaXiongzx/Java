package oskeshe2;
import java.awt.Font;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


class Frame extends JFrame{
	Font font=new Font("ÀŒÃÂ",Font.PLAIN,25);//∏Ò Ω
	public JLabel labelmax,labelallocation,labelneed,labelavailable;
	public JTextField max00,max01,max02,max10,max11,max12,max20,max21,max22,max30,max31,max32,namefield;
	public JTextField allocation00,allocation01,allocation02,allocation10,allocation11,allocation12,allocation20,allocation21,allocation22,allocation30,allocation31,allocation32;
	public JTextField need00,need01,need02,need10,need11,need12,need20,need21,need22,need30,need31,need32;
	public JTextField available0,available1,available2;
	public JFrame jf=this;
	public  void show(JFrame jf) {
		max00=new JTextField("name1");
		max01=new JTextField("name2");
		max02=new JTextField("name3");
		max10=new JTextField("name4");
		max00.setFont(font);
		max00.setBounds(20,50,80,30);
		max01.setFont(font);
		max01.setBounds(100,50,80,30);
		max02.setFont(font);
		max02.setBounds(180,50,80,30);
		max10.setFont(font);
		max10.setBounds(1000,1000,80,30);

		jf.add(max00);
		jf.add(max01);
		jf.add(max02);
		jf.add(max10);

	}
	public Frame() {
		setResizable(false);
		show(jf);
		setSize(1200, 900);
		
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

public class Oskeshe2 {
	public static void main(String [] args) {
		Frame a=new Frame();
	}

}
