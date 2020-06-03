package ch7;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class TicTacToeFrame implements ActionListener {

private JFrame window;
private JButton button1;
private JButton button2;
private JButton button3;
private JButton button4;
private JButton button5;
private JButton button6;
private JButton button7;
private JButton button8;
private JButton button9;
private String letter = "";
private int count = 0;
private boolean win = false;
String player1,player2;

FileOperation fo;

public TicTacToeFrame(String player1,String player2){

fo=new FileOperation();
    
this.player1=player1;    
this.player2=player2;

window = new JFrame("Tic-Tac-Toe");
button1 = new JButton("");
button2 = new JButton("");
button3 = new JButton("");
button4 = new JButton("");
button5 = new JButton("");
button6 = new JButton("");
button7 = new JButton("");
button8 = new JButton("");
button9 = new JButton("");
window.setSize(380,300);
window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
window.setLayout(new GridLayout(3,3));


window.add(button1);
window.add(button2);
window.add(button3);
window.add(button4);
window.add(button5);
window.add(button6);
window.add(button7);
window.add(button8);
window.add(button9);


button1.addActionListener(this);
button2.addActionListener(this);
button3.addActionListener(this);
button4.addActionListener(this);
button5.addActionListener(this);
button6.addActionListener(this);
button7.addActionListener(this);
button8.addActionListener(this);
button9.addActionListener(this);


window.setVisible(true);
}

public void actionPerformed(ActionEvent a) {
count++;


if(count == 1 || count == 3 || count == 5 || count == 7 || count == 9){
letter = "X";
} else if(count == 2 || count == 4 || count == 6 || count == 8 || count == 10){
letter = "O";
}


if(a.getSource() == button1){
button1.setText(letter);
button1.setEnabled(false);
} else if(a.getSource() == button2){
button2.setText(letter);
button2.setEnabled(false);
} else if(a.getSource() == button3){
button3.setText(letter);
button3.setEnabled(false);
} else if(a.getSource() == button4){
button4.setText(letter);
button4.setEnabled(false);
} else if(a.getSource() == button5){
button5.setText(letter);
button5.setEnabled(false);
} else if(a.getSource() == button6){
button6.setText(letter);
button6.setEnabled(false);
} else if(a.getSource() == button7){
button7.setText(letter);
button7.setEnabled(false);
} else if(a.getSource() == button8){
button8.setText(letter);
button8.setEnabled(false);
} else if(a.getSource() == button9){
button9.setText(letter);
button9.setEnabled(false);
}


if( button1.getText() == button2.getText() && button2.getText() == button3.getText() && button1.getText() != ""){
win = true;
}
else if(button4.getText() == button5.getText() && button5.getText() == button6.getText() && button4.getText() != ""){
win = true;
}
else if(button7.getText() == button8.getText() && button8.getText() == button9.getText() && button7.getText() != ""){
win = true;
}


else if(button1.getText() == button4.getText() && button4.getText() == button7.getText() && button1.getText() != ""){
win = true;
}
else if(button2.getText() == button5.getText() && button5.getText() == button8.getText() && button2.getText() != ""){
win = true;
}
else if(button3.getText() == button6.getText() && button6.getText() == button9.getText() && button3.getText() != ""){
win = true;
}


else if(button1.getText() == button5.getText() && button5.getText() == button9.getText() && button1.getText() != ""){
win = true;
}
else if(button3.getText() == button5.getText() && button5.getText() == button7.getText() && button3.getText() != ""){
win = true;
}
else {
win = false;
}


if(win == true){
   System.out.println(letter);
   switch(letter) 
   {
       case "X":JOptionPane.showMessageDialog(null, player1.toUpperCase() + " WINS!");
                
                fo.player1(player1);
                fo.player2(player2);
                fo.writeData(player1);
                break;
        case "O":JOptionPane.showMessageDialog(null, player2.toUpperCase() + " WINS!");
                fo.player1(player1);
                fo.player2(player2);
                fo.writeData(player2);
               
                break;
   }
   
} else if(count == 9 && win == false){
JOptionPane.showMessageDialog(null, "Tie Game!");
}
}

}