package chapter04;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.TreeSet;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Menu extends JFrame implements ActionListener
{
	 JFrame jf_choose, jf_viewinstruction,jf_add,jf_great,jf_instruction;
	 JCheckBox jc_countries,jc_fruits,jc_animals;
     JButton btn_play, btn_view, btn_quit,btn_ok,btn_guess;
     JLabel jl_word,jl_guess,jl_great,jl_instruction;
     JTextField jt_guess;
     Random ra =new Random();
     Random ra1 =new Random();
     String fin,fin1;
     char[] tran=new char[20];
     @SuppressWarnings("rawtypes")
	ArrayList al=new ArrayList();
     Countries countries=new Countries();
     Fruits fruits=new Fruits();
     Animals animals=new Animals();

    public Menu()
    {
        setSize(280,280);
        setVisible(true);
        setTitle("Blanks");
        setLocationRelativeTo(null);
        btn_play = new JButton("Play");
        btn_play.addActionListener(this);
        btn_play.setSize(100, 25);
        btn_view = new JButton("View Instructions");
        btn_view.addActionListener(this);
        btn_view.setSize(100, 25);
        btn_quit = new JButton("Quit");
        btn_quit.addActionListener(this);
        btn_quit.setSize(100, 25); 
        btn_ok = new JButton("OK");
        btn_ok.addActionListener(this);
        btn_ok.setSize(50, 25);      
    }    
    public void addComponent()
    {
        setLayout(null);
        
        btn_play.setBounds(40, 40, 200, 40);
        add(btn_play);
        
        btn_view.setBounds(40,100,200,40);
        add(btn_view);
        
        btn_quit.setBounds(40,160,200,40);
        add(btn_quit);
        
        setResizable(false);
        
    }
    
    public void actionPerformed(ActionEvent e)
    {
    	  if(e.getSource()==btn_play)
          {
    		jf_choose = new JFrame("Choose Categories");
    	        jf_choose.setLayout(null);
    	        jf_choose.setSize(400, 300);
    	        jf_choose.setVisible(true);
    	        jf_choose.setLocationRelativeTo(null);
                jc_countries=new JCheckBox("Countries");
                jc_countries.setFont(new Font("",10,20));
                jc_countries.setBounds(150, 30, 160, 20);                       	 
    	        jf_choose.add(jc_countries);
    	        jc_fruits=new JCheckBox("Fruit");
    	        jc_fruits.setFont(new Font("",10,20));
    	        jc_fruits.setBounds(150, 90, 160, 20);
    	    	jf_choose.add(jc_fruits);
    	    	jc_animals=new JCheckBox("Animals");
    	    	jc_animals.setFont(new Font("",10,20));
    	        jc_animals.setBounds(150, 150, 160, 20);
    	    	jf_choose.add(jc_animals);
                btn_ok.setBounds(160, 210, 60, 26);
                jf_choose.add(btn_ok);   	       
    	        jf_choose.setResizable(false);
    	        btn_ok.addActionListener(new ActionListener() {

					@SuppressWarnings("unchecked")
					public void actionPerformed(ActionEvent a) {
						if(jc_countries.isSelected())
						{
							al.add(countries);							
						}
						if(jc_fruits.isSelected())
						{
							al.add(fruits);
						}
						if(jc_animals.isSelected())
						{
							al.add(animals);
						}
						jf_add=new JFrame("Fight!");
						jf_add.setLayout(null);
		    	        jf_add.setSize(400, 300);
		    	        jf_add.setVisible(true);
		    	        jf_add.setLocationRelativeTo(null);
		    	        int r=ra.nextInt(al.size());
		    	        if(al.indexOf(countries)==r)
		    	        {
		    	        	fin=countries.c[ra1.nextInt(10)];
		    	        }
		    	        else if(al.indexOf(fruits)==r)
		    	        {
		    	        	fin=fruits.f[ra1.nextInt(10)];
		    	        }
		    	        else if(al.indexOf(animals)==r)
		    	        {
		    	        	fin=animals.a[ra1.nextInt(10)];
		    	        }
		    	        int len=fin.length();
		    	    	int empty=len/2+1;
		    	    	
		    	    	tran=fin.toCharArray();	
		    	    	Random ran = new Random(empty);
		    		    for (int i = 0; i < empty; i++) 
		    		    {
		    		        tran[ran.nextInt(len)] ='#';
		    		    }
		    		    fin1=String.valueOf(tran);
		    	        jl_word=new JLabel(fin1);
		    	        jl_word.setFont(new Font("",10,25));
		    	        jl_word.setBounds(160, 40, 160, 25);
		    	        jf_add.add(jl_word);
		    	        jl_word=new JLabel("Guess: ");
		    	        jl_word.setFont(new Font("",10,20));
		    	        jl_word.setBounds(90, 110, 160, 20);
		    	        jf_add.add(jl_word);
		    	        jt_guess=new JTextField();
		    	        jt_guess.setBounds(160, 105, 100, 30);
		    	        jf_add.add(jt_guess);
		    	        btn_guess=new JButton("Confirm");
		    	        btn_guess.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent b) {
								 String guess=jt_guess.getText();
					    	        if(guess.equalsIgnoreCase(fin)==true)
					    	        {
					    	        	jf_great=new JFrame("Good!");
										jf_great.setLayout(null);
						    	        jf_great.setSize(400, 300);
						    	        jf_great.setVisible(true);
						    	        jf_great.setLocationRelativeTo(null);
						    	        jl_great=new JLabel("Great!");
						    	        jl_great.setFont(new Font("",10,40));
						    	        jl_great.setBounds(140, 90, 160, 40);
						    	        jf_great.add(jl_great);
					    	        }
							}
		    	        	
		    	        });
		    	        btn_guess.setSize(50, 25);
		    	        btn_guess.setBounds(155, 170, 100, 30);
		    	        jf_add.add(btn_guess);
		    	     }   	        	
    	        });
          }
          else if(e.getSource()==btn_view)
          {
              
             jf_instruction = new JFrame("Instruction");
    	     jf_instruction.setLayout(null);
    	     jf_instruction.setSize(500, 100);
    	     jf_instruction.setVisible(true);
    	     jf_instruction.setLocationRelativeTo(null);
             jl_instruction=new JLabel("Choose categories,you will get a word from them,guess it!");
	     jl_instruction.setFont(new Font("",10,15));
	     jl_instruction.setBounds(50, 20, 400, 25);
	     jf_instruction.add(jl_instruction);
          }
          else if(e.getSource()==btn_quit)
          {
        	  System.exit(0);
          }
    }   
    
    public static void main(String[] args)
    {
        Menu mobj = new Menu();
        mobj.addComponent();
    }		            
}