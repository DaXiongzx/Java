package ch7;
import java.io.*;
import javax.swing.JOptionPane;
public class FileOperation {
    String player1,player2, playerName;
    int winScore=1,lostScore=0;
    
    void player1(String player){
     this.player1=player;       
    }
    void player2(String player){
     this.player2=player;       
    }
    String getData(String player){
       
        playerName=player.toLowerCase();
        String finalScore="";
        //Reading Data
        try(BufferedReader bf = new BufferedReader(new FileReader("record/Score.txt"))){
        	String stringSearch = playerName;
        	int linecount1 = 0;
        	String line;
        	String line1;
        	
        	int linecount = 0;
        	double temp=0.0;
        	double sum = 0.0;
        	while((line = bf.readLine())!=null) {
        		String txt[] = line.split("");
        		for(int i=0;i<txt.length;i++) {
        			System.out.println(txt[i]);
        			if(txt[i].equals(stringSearch)) {
        				temp = Double.parseDouble(txt[i+1]);
        				linecount++;
        				sum+=temp;
        			}
        		}
        		
        	}
        	Double winpercentage=(sum/linecount)*100;
        	finalScore=winpercentage.toString();
        }
         catch (IOException e) {
           
        }  
    return finalScore;
    }
    void writeData(String playerName){
        //Writing Data
    	try(BufferedWriter bw = new BufferedWriter(new FileWriter("record/Score.txt",true))){
    		if(playerName.equals(player1)) {
    			bw.append("\n" + player1.toLowerCase()+""+winScore);
    			bw.append("\n" + player2.toLowerCase()+""+lostScore);
    			bw.append("\n--------------------------");
    		}
    		else {
    			bw.append("\n" + player2.toLowerCase()+""+winScore);
    			bw.append("\n" + player1.toLowerCase()+""+lostScore);
    			bw.append("\n--------------------------");
    		}
    		
    	}
        catch(Exception e){
            
        }
        }
    }

