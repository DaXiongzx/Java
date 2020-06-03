package ch7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GetScoreFrame extends JFrame{
    JLabel playerNameJl;
    JTextField playerNameJtf;
    JButton scoreJb;
    FileOperation fo;
    GetScoreFrame(){
        super("Win Percent");
        setLayout(null);
        
        
        playerNameJl=new JLabel("     Enter Name   ");
        playerNameJtf=new JTextField();
        scoreJb=new JButton("Get the Win Percent");
        
        playerNameJl.setBounds(10,50,100,30);
        playerNameJtf.setBounds(120,50,120,30);
        scoreJb.setBounds(50,120,150,30);
        
        add(playerNameJl);
        add(playerNameJtf);
        add(scoreJb);
        
        setSize(300,300);
        setVisible(true);
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fo=new FileOperation();
        scoreJb.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae){
            String playerName=playerNameJtf.getText();
            String scorePercent=fo.getData(playerName);
            JOptionPane.showMessageDialog(null, "Win Percentage of "+playerName+":"+scorePercent);
        }
        });
              
    }
   
    
}
