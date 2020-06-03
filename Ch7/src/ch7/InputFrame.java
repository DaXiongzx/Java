package ch7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InputFrame extends JFrame implements ActionListener{
    
    JLabel player1Jl, player2Jl;
    JTextField player1Jtf,player2Jtf;
    JButton startJb;
    
    InputFrame(){
     super("Inputs Frame");
      
      player1Jl=new JLabel("Enter First Player Name");
      player2Jl=new JLabel("Enter Second Player Name");
      
      player1Jtf=new JTextField();
      player2Jtf=new JTextField();
      
      startJb=new JButton("Start the Game");
      
      
      setLayout(null);
      
      player1Jl.setBounds(10, 30,160,30);
      player1Jtf.setBounds(170,30, 160,30);
      
      player2Jl.setBounds(10, 80,160,30);
       player2Jtf.setBounds(170,80, 160,30);
       
       startJb.setBounds(50,150,150,30);
       
      
      add(player1Jl);
      add(player1Jtf);
      
      add(player2Jl);
      add(player2Jtf);
      
      add(startJb);
      
      
      startJb.addActionListener(this);
      
      
      setSize(380,300);
      setVisible(true);
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      
      
      
    }
    public void actionPerformed(ActionEvent ae){
        
            String player1=player1Jtf.getText();
            String player2=player2Jtf.getText();
            
            TicTacToeFrame ttf=new TicTacToeFrame(player1,player2);
        
    }
}
