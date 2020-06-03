package ch8;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class ex2 extends JFrame implements ActionListener{
	  JButton btn_search;	
	  JTextField tx_enter;
	    public ex2()
	    {
	    	tx_enter = new JTextField();
	        setSize(280,220);
	        setVisible(true);
	        setTitle("Search");
	        setLocationRelativeTo(null);
	        btn_search = new JButton("Search");
	        btn_search.addActionListener(this);
	        btn_search.setSize(100, 25);
	        tx_enter.setFont(new Font("",10,30));
	    }
	    
	    public void addComponent()
	    {
	        setLayout(null);       
	        btn_search.setBounds(87,100,100,40);
	        add(btn_search);	
	        tx_enter.setBounds(50,40,180,35);
	        add(tx_enter);
	        setResizable(false);	        
	    }
	    
	    public void actionPerformed(ActionEvent e)
	    {
	    	 if(e.getSource()==btn_search)
	         {
	             String s1=tx_enter.getText();
	             Path target=Paths.get("D:/"+s1); //vmware-0.log
	             Boolean exist=Files.exists(target, LinkOption.NOFOLLOW_LINKS);
	             JFrame jf_instruction = new JFrame("Instruction");
	      	     jf_instruction.setLayout(null);
	      	     jf_instruction.setSize(500, 100);
	      	     jf_instruction.setVisible(true);
	      	     jf_instruction.setLocationRelativeTo(null);
	      	     if(exist==true)
	      	     {
	             JLabel jl_instruction = new JLabel("The file exists");
	  	         jl_instruction.setFont(new Font("",10,20));
	  	         jl_instruction.setBounds(180, 17, 200, 25);
	  	         jf_instruction.add(jl_instruction);
	      	     }
	      	     else
	      	     {
	      	    	 JLabel jl_instruction = new JLabel("The file doesn't exist");
		  	         jl_instruction.setFont(new Font("",10,20));
		  	         jl_instruction.setBounds(160, 17, 200, 25);
		  	         jf_instruction.add(jl_instruction);
	      	     }
	         }
	    }           
	    
	    public static void main(String[] args)
	    {
	        ex2 mobj = new ex2();
	        mobj.addComponent();
	    }   
}