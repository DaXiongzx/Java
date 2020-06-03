package inventory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;

public class PublisherInfo implements ActionListener{
	JLabel heading,lpubid,lpub_name,lphone,laddress,lcity,lstate,lzip;
	JTextField pub_idField,pub_nameField,phoneField,addressField,cityField,stateField,zipField;
	JButton insert,exit;
	Connection con;
	Statement stmt;
	PreparedStatement stat;
	ResultSet rs;
	JPanel pl;
	JFrame fl;
	
	public PublisherInfo()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb?&useSSL=false&serverTimezone=UTC","root","112233");
			stmt=con.createStatement();
		}
		catch(Exception e)
		{
			System.out.println("Error: "+e);
		}
	}
	
	public void compshow()
	{
		fl=new JFrame("PUBLISHERS");
		pl=new JPanel();
		
		heading=new JLabel("PUBLISHERS INFORMATION");
		lpubid=new JLabel("Publishers ID:");
		lpub_name=new JLabel("Publishers Name:");
		lphone=new JLabel("Phone Number:");
		laddress=new JLabel("Address:");
		lcity=new JLabel("City:");
		lstate=new JLabel("State:");
		lzip=new JLabel("Zip:");
		
		pub_idField=new JTextField(6);
		pub_nameField=new JTextField(50);
		phoneField=new JTextField(15);
		addressField=new JTextField(50);
		cityField=new JTextField(50);
		stateField=new JTextField(50);
		zipField=new JTextField(20);
		
		insert=new JButton("Insert");
		exit=new JButton("Exit");
		
		pl.setLayout(null);
		heading.setBounds(250, 35, 200, 40);
		pl.add(heading);
		
		lpubid.setBounds(75, 90, 200, 30);
		pub_idField.setBounds(400, 90, 100, 25);
		pl.add(lpubid);
		pl.add(pub_idField);
		
		lpub_name.setBounds(75, 120, 200, 30);
		pub_nameField.setBounds(400, 120, 200, 25);
		pl.add(lpub_name);
		pl.add(pub_nameField);

		lphone.setBounds(75, 150, 200, 30);
		phoneField.setBounds(400, 150, 150, 25);
		pl.add(lphone);
		pl.add(phoneField);
		
		laddress.setBounds(75, 180, 200, 30);
		addressField.setBounds(400, 180, 250, 25);
		pl.add(laddress);
		pl.add(addressField);
		
		lcity.setBounds(75, 210, 200, 30);
		cityField.setBounds(400, 210, 200, 25);
		pl.add(lcity);
		pl.add(cityField);
		
		lstate.setBounds(75, 240, 200, 30);
		stateField.setBounds(400, 240, 200, 25);
		pl.add(lstate);
		pl.add(stateField);
		
		lzip.setBounds(75, 270, 200, 30);
		zipField.setBounds(400, 270, 200, 25);
		pl.add(lzip);
		pl.add(zipField);
		
		insert.setBounds(175, 350, 100, 30);
		exit.setBounds(325, 350, 100, 30);
		pl.add(insert);
		pl.add(exit);
		
		fl.add(pl);
		fl.setSize(680,500);
		fl.setVisible(true);
		fl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		insert.addActionListener(this);
		exit.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO ??????????????
		if(arg0.getActionCommand()=="Exit")
		{
			System.exit(0);
		}
		if(arg0.getActionCommand()=="Insert")
		{
			if(!pub_idField.getText().equals(""))
			{
				try
				{
					stat=con.prepareStatement("insert into authors values(?,?,?,?,?,?,?)");
					String pid=pub_idField.getText();
					String pname=pub_nameField.getText();
					String pphone=phoneField.getText();
					String padd=addressField.getText();
					String pcity=cityField.getText();
					String pstate=stateField.getText();
					String pzip=zipField.getText();
					
					stat.setString(1, pid);
					stat.setString(2, pname);
					stat.setString(3, pphone);
					stat.setString(4, padd);
					stat.setString(5, pcity);
					stat.setString(6, pstate);
					stat.setString(7, pzip);
					
					stat.executeUpdate();
					
					pub_idField.setText("");
					pub_nameField.setText("");
					phoneField.setText("");
					addressField.setText("");
					cityField.setText("");
					stateField.setText("");
					zipField.setText("");
					
					JOptionPane.showMessageDialog(fl, "Information has been inserted."," Information", JOptionPane.INFORMATION_MESSAGE);	
				}
				catch(Exception e)
				{
					String msg=e.getMessage();
					if(e.getMessage().equals(msg))
					{
						JOptionPane.showMessageDialog(fl, "Record already exists.", "Warning Message", JOptionPane.INFORMATION_MESSAGE);
						pub_idField.setText("");
						pub_nameField.setText("");
						phoneField.setText("");
						addressField.setText("");
						cityField.setText("");
						stateField.setText("");
						zipField.setText("");
					}
				}
			}
			else
			{
				JOptionPane.showMessageDialog(fl, "Please fill the details properly.", "Error Message", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO ??????????????
		PublisherInfo p=new PublisherInfo();
		p.compshow();
	}
	

}