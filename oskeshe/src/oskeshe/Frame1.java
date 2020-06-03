package oskeshe;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import oskeshe.Frame2.ButtonListener;

class SJF{
	int cost;
	int number;
	public SJF(int num) {
		number=num;
	}
}

class HRRF{
	int arrive,cost=0,wait=0;
	double wait1=wait;
	double cost1=cost;
	double percent=0.0;
	boolean visited=false;
	public void setperent() {
		double wait1=wait;
		double cost1=cost;
	    percent=wait1/cost1;
	}
	public void setpercent0() {
		percent=0.0;
	}
}

public class Frame1 extends JFrame{
	public JButton returnbutton=new JButton("Return");
	public JButton sjfbutton;
	public JTextField sjffield;
	public JLabel sjflabel;
	public String results="";
	public SJF sjf1,sjf2,sjf3,sjf4;
	public JTextField cost1,cost2,cost3,cost4;
	//public JLabel sjflabel;
	public String result="";
	public JButton hrrfbutton;
	public JTextField hrrfresult;
	public JLabel resultlabel;
	public JLabel labelp1,labelp2,labelp3,labelp4;
	public JLabel arrivetime,costtime;
	public HRRF HRRF0=new HRRF(),HRRF1=new HRRF(),HRRF2=new HRRF(),HRRF3=new HRRF();
	public JTextField arrive00,cost01,arrive10,cost11,arrive20,cost21,arrive30,cost31;
	public HRRF array[] = new HRRF[4];
	Font font=new Font("ÀŒÃÂ",Font.PLAIN,25);//∏Ò Ω
	public JFrame jf=this;
	
	public void show5(JFrame jf) {
		sjflabel=new JLabel("SJF");
		sjflabel.setFont(font);
		sjflabel.setBounds(800, 50, 100, 50);
		cost1=new JTextField("");
		cost1.setFont(font);
		cost1.setBounds(800, 120, 50, 50);
		cost2=new JTextField("");
		cost2.setFont(font);
		cost2.setBounds(800, 190, 50, 50);
		cost3=new JTextField("");
		cost3.setFont(font);
		cost3.setBounds(800, 260, 50, 50);
		cost4=new JTextField("");
		cost4.setFont(font);
		cost4.setBounds(800, 330, 50, 50);
		sjfbutton=new JButton("SJF");
		sjfbutton.setFont(font);
		sjfbutton.setBounds(1000, 720, 100, 50);
		sjffield=new JTextField(" ");
		sjffield.setFont(font);
		sjffield.setBounds(120, 720, 850, 50);
		sjflabel=new JLabel("Result:");
		sjflabel.setFont(font);
		sjflabel.setBounds(20, 720, 120, 50);
		jf.add(sjflabel);
		jf.add(cost1);
		jf.add(cost2);
		jf.add(cost3);
		jf.add(cost4);
		jf.add(sjfbutton);
		jf.add(sjffield);
		jf.add(sjflabel);
	}
	
	public void show1(JFrame jf) {
		arrivetime=new JLabel("Arrive");
		arrivetime.setFont(font);
		arrivetime.setBounds(180, 50, 100, 50);
		costtime=new JLabel("Cost");
		costtime.setFont(font);
		costtime.setBounds(350, 50, 100, 50);
		labelp1=new JLabel("p1:");
		labelp1.setFont(font);
		labelp1.setBounds(60, 120, 50, 50);
		labelp2=new JLabel("p2:");
		labelp2.setFont(font);
		labelp2.setBounds(60, 190, 50, 50);
		labelp3=new JLabel("p3:");
		labelp3.setFont(font);
		labelp3.setBounds(60, 260, 50, 50);
		labelp4=new JLabel("p4:");
		labelp4.setFont(font);
		labelp4.setBounds(60, 330, 50, 50);
		jf.add(labelp1);
		jf.add(labelp2);
		jf.add(labelp3);
		jf.add(labelp4);
		jf.add(arrivetime);
		jf.add(costtime);
	}
	
	public void show2(JFrame jf) {
		arrive00=new JTextField(" ");
		arrive00.setFont(font);
		arrive00.setBounds(180, 120, 100, 50);
		cost01=new JTextField(" ");
		cost01.setFont(font);
		cost01.setBounds(350, 120, 100, 50);
		arrive10=new JTextField(" ");
		arrive10.setFont(font);
		arrive10.setBounds(180, 190, 100, 50);
		cost11=new JTextField(" ");
		cost11.setFont(font);
		cost11.setBounds(350, 190, 100, 50);
		arrive20=new JTextField(" ");
		arrive20.setFont(font);
		arrive20.setBounds(180, 260, 100, 50);
		cost21=new JTextField(" ");
		cost21.setFont(font);
		cost21.setBounds(350, 260, 100, 50);
		arrive30=new JTextField(" ");
		arrive30.setFont(font);
		arrive30.setBounds(180, 330, 100, 50);
		cost31=new JTextField(" ");
		cost31.setFont(font);
		cost31.setBounds(350, 330, 100, 50);
		jf.add(arrive00);
		jf.add(cost01);
		jf.add(arrive10);
		jf.add(cost11);
		jf.add(arrive30);
		jf.add(arrive20);
		jf.add(cost21);
		jf.add(cost31);
	}
	
	public void show3(JFrame jf) {
		hrrfbutton=new JButton("HRRF");
		hrrfbutton.setFont(font);
		hrrfbutton.setBounds(1000, 600, 100, 50);
		hrrfresult=new JTextField(" ");
		hrrfresult.setFont(font);
		hrrfresult.setBounds(120, 600, 850, 50);
		resultlabel=new JLabel("Result:");
		resultlabel.setFont(font);
		resultlabel.setBounds(20, 600, 120, 50);
		jf.add(hrrfbutton);
		jf.add(hrrfresult);
		jf.add(resultlabel);
	}

	public void getinput() {
		String arrive00value="";
		arrive00value=arrive00.getText();
		HRRF0.arrive=Integer.parseInt(arrive00value.trim());
		String cost01value=cost01.getText();
		HRRF0.cost=Integer.parseInt(cost01value.trim());
		String arrive10value=arrive10.getText();
		HRRF1.arrive=Integer.parseInt(arrive10value.trim());
		String cost11value=cost11.getText();
		HRRF1.cost=Integer.parseInt(cost11value.trim());
		String arrive20value=arrive20.getText();
		HRRF2.arrive=Integer.parseInt(arrive20value.trim());
		String cost21value=cost21.getText();
		HRRF2.cost=Integer.parseInt(cost21value.trim());
		String arrive30value=arrive30.getText();
		HRRF3.arrive=Integer.parseInt(arrive30value.trim());
		String cost31value=cost31.getText();
		HRRF3.cost=Integer.parseInt(cost31value.trim());
		HRRF array1[]= {HRRF0,HRRF1,HRRF2,HRRF3};

		array=array1;

	}
	
	public void dosjf() {
		String value1=cost1.getText();
		value1=value1.trim();
		int value11=Integer.parseInt(value1);
		sjf1=new SJF(1);
		sjf1.cost=value11;
		String value2=cost2.getText();
		value2=value2.trim();
		int value12=Integer.parseInt(value2);
		sjf2=new SJF(2);
		sjf2.cost=value12;
		String value3=cost3.getText();
		value3=value3.trim();
		int value13=Integer.parseInt(value3);
		sjf3=new SJF(3);
		sjf3.cost=value13;
		String value4=cost4.getText();
		sjf4=new SJF(4);
		value4=value4.trim();
		int value14=Integer.parseInt(value4);
		sjf4.cost=value14;
		SJF arr[]= {sjf1,sjf2,sjf3,sjf4};
		//int min=arr[0];
		int index=0;
		SJF min=new SJF(6);
		for(int i=0;i<4;i++) {
			for(int j=i+1;j<4;j++) {
				if(arr[i].cost>arr[j].cost) {
					min=arr[j];
					
					arr[j]=arr[i];
					arr[i]=min;
					
				}
			}
			//results=results++" ";
			
		}
		for(int i=0;i<4;i++) {
			int number1=arr[i].number+1;
			results=results+arr[i].number+" ";
		}
	}
	
	public int findmin(HRRF array[]) {
		int min=100;
		int index=0;
		for(int i=0;i<4;i++) {
			if(array[i].arrive<min) {
				min=array[i].arrive;
				index=i;
			}
		}
		return index;
	}

	public int findmax(HRRF array[]) {
		int index=0;
		double max=-1.0;
		/*double []percentar= {0.0,0.0,0.0,0.0};
		for(int i=0;i<4;i++) {
			percentar[i]=array[i].wait
		}*/
		for(int i=0;i<4;i++) {
			System.out.println(array[i].wait);
			if(array[i].percent>max) {
				max=array[i].percent;
				index=i;
				//System.out.println("this is hanshu "+index);
			}
			//System.out.print("i:"+i);
		}
		System.out.println("this is return index "+index);
		return index;
	}
	
	public void dohrrf() {
		int p=4;
		int count=0;
		getinput();

		int endtime=0;
		int index=findmin(array);
		int index1=index+1;
		result=result+index1+" ";
		array[index].visited=true;
		endtime=array[index].arrive+array[index].cost;
		System.out.println("this is the first endtime"+endtime);
		count=count+1;
		while (true) {
			//System.out.println("this is endtime "+endtime);
			System.out.println(count);
			if(count==3) 
				break;
			for(int i=0;i<p;i++) {
				if(array[i].visited==false)
					{
						array[i].wait=endtime-array[i].arrive;
						System.out.print(array[i].wait+"  ");
					}
				
			}
			for(int i=0;i<4;i++) {
				if(array[i].visited) array[i].percent=0.0;
				else
					array[i].setperent();

			}
			for(int i=0;i<4;i++) {
				System.out.print(array[i].percent+"     ");
			}
			System.out.println("start find max");
			int maxindex=findmax(array);
			System.out.println("end find max");
			count++;
			System.out.println("this is max index"+maxindex);
			int maxindex1=maxindex+1;
			result=result+maxindex1+" ";
			
			endtime=array[maxindex].cost+endtime;
			System.out.println("this is endtime "+endtime);
			System.out.println("this is cost "+array[maxindex].cost);
			System.out.println("this is index "+index);
			array[maxindex].visited=true;
	}
		for(int i=0;i<4;i++) {
			if(array[i].visited) continue;
			else {
				System.out.print("this is the last "+i);
				int num=i+1;
				result=result+num+" ";
				break;
			}
		}
	}
	
	class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String s=e.getActionCommand();
			if(s=="HRRF") {
				dohrrf();
				hrrfresult.setText(result);
			}
			if(s=="SJF") {
				dosjf();
				sjffield.setText(results);
			}
			if(s.equals("Return")) {
				mainframe d=new mainframe();
			}
		
		}
	}
	
	public Frame1() {
		setLayout(null);
		setResizable(false);
		show1(jf);
		show2(jf);
		show3(jf);
		show5(jf);
		returnbutton.setFont(font);
		returnbutton.setBounds(950, 800, 200, 100);
		returnbutton.addActionListener(new ButtonListener());
		hrrfbutton.addActionListener(new ButtonListener());
		sjfbutton.addActionListener(new ButtonListener());
		jf.add(returnbutton);
		setSize(1200, 1000);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	
	public static void main(String [] args) {
		Frame1 a=new Frame1();
	}

}
