package AllForms;

import java.awt.*;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.DefaultBoundedRangeModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


import allObjects.Registration;

public class RegistrationForm implements ActionListener {
	
	JFrame frame;
	//id;fname;lname;email;telephone;
	
	JLabel id_lb=new JLabel("ID");
	JLabel name_lb=new JLabel("NAME");
	JLabel email_lb=new JLabel("EMAIL");
	JLabel phone_lb=new JLabel("PHONE NUMBER");
	JLabel country_lb=new JLabel("COUNTRY");
	JLabel district_lb=new JLabel("DISTRICT");
	JLabel sector_lb=new JLabel("SECTOR");
	JLabel password_lb=new JLabel("PASSWORD");
	JLabel confirm_password_lb=new JLabel("CONFIRM PASSWORD");
	
	JTextField id_txf=new JTextField();
	JTextField name_txf=new JTextField();
	JTextField email_txf=new JTextField();
	JTextField phone_txf=new JTextField();
	JTextField country_txf=new JTextField();
	JTextField district_txf=new JTextField();
	JTextField sector_txf=new JTextField();
	JPasswordField password_txf=new JPasswordField();
	JPasswordField confirm_password_txf=new JPasswordField();
	
	JButton submit_btn=new JButton("REGISTER NOW");
	JButton reset_btn=new JButton("RESET");
	JTable table=new JTable();
	JScrollPane scrollPane = new JScrollPane(table);
	
	public RegistrationForm() {
		createWindow();
		setLocationAndSize();
		addComponentsToFrame();
		addActionEvent();
		setFontforall();
	}
	

public void createWindow() {
	frame=new JFrame();
	frame.setTitle("REGISTRATION FORM");
	frame.setBounds(0,0,850,600);
	frame.getContentPane().setLayout(null);
	frame.getContentPane().setBackground(Color.pink);
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setResizable(false);
	
}


private void setLocationAndSize() {
	id_lb.setBounds(10,60,100,30);
	name_lb.setBounds(10, 100, 100, 30);
	email_lb.setBounds(10, 140, 100, 30);
	phone_lb.setBounds(10, 180, 130, 30);
	country_lb.setBounds(10, 220, 100, 30);
	district_lb.setBounds(10, 260, 100, 30);
	sector_lb.setBounds(10, 300, 100, 30);
	password_lb.setBounds(10, 340, 100, 30);
	confirm_password_lb.setBounds(10, 380, 180, 30);
	id_txf.setBounds(200,60,150,30);
	name_txf.setBounds(200, 100, 150, 30);
	email_txf.setBounds(200, 140, 150, 30);
	phone_txf.setBounds(200, 180, 150, 30);
	country_txf.setBounds(200, 220, 150, 30);
	district_txf.setBounds(200, 260, 150, 30);
	sector_txf.setBounds(200, 300, 150, 30);
	password_txf.setBounds(200, 340, 150, 30);
	confirm_password_txf.setBounds(200, 380, 150, 30);
	//Buttons CRUD
	submit_btn.setBounds(30,480, 150, 30);
	reset_btn.setBounds(250,480, 85, 30);
	table.setBounds(450, 100, 400, 400);
	
	


}

private void setFontforall() {
	Font font = new Font("New Times Roman", Font.BOLD, 14);
	id_lb.setFont(font);
	name_lb.setFont(font);
	email_lb.setFont(font);
	phone_lb.setFont(font);
	country_lb.setFont(font);
	district_lb.setFont(font);
	sector_lb.setFont(font);
	password_lb.setFont(font);
	confirm_password_lb.setFont(font);
	
	Font fonti = new Font("Courier New", Font.ITALIC, 14);

	submit_btn.setFont(fonti);
	reset_btn.setFont(fonti);
}

private void addComponentsToFrame() {
	frame.add(id_lb);
	frame.add(name_lb);
	frame.add(email_lb);
	frame.add(phone_lb);
	frame.add(country_lb);
	frame.add(district_lb);
	frame.add(sector_lb);
	frame.add(password_lb);
	frame.add(confirm_password_lb);
	frame.add(id_txf);
	frame.add(name_txf);
	frame.add(email_txf);
	frame.add(phone_txf);
	frame.add(country_txf);
	frame.add(district_txf);
	frame.add(sector_txf);
	frame.add(password_txf);
	frame.add(confirm_password_txf);
	

	//Buttons CRUD
	frame.add(submit_btn);
	frame.add(reset_btn);
	frame.add( table);

	
}
public void addActionEvent()
{
    submit_btn.addActionListener(this);
    reset_btn.addActionListener(this);
}
    
public void actionPerformed(ActionEvent e) {
	 if(e.getSource()==reset_btn)
     {
         id_txf.setText("");
         name_txf.setText("");
         email_txf.setText("");
         phone_txf.setText("");
         country_txf.setText("");
         district_txf.setText("");
         sector_txf.setText("");
         password_txf.setText("");
         confirm_password_txf.setText("");
     }
	
	
	if(e.getSource() == submit_btn) {
		Registration reg=new Registration();
		if(e.getSource()==submit_btn) {
			reg.setName(name_txf.getText());
			reg.setEmail(email_txf.getText());
			reg.setPhone(phone_txf.getText());
			reg.setCountry(country_txf.getText());
			reg.setDistrict(district_txf.getText());
			reg.setSector(sector_txf.getText());
			reg.setPassword(password_txf.getText());
			reg.setConfirm_password(confirm_password_txf.getText());
			reg.register();
			DefaultTableModel tableModel=reg.populateTable();
			table.setModel(tableModel);
	}
	}
}
public static void main(String[] args) {
	RegistrationForm regstr= new RegistrationForm();

}



}
	
