package AllForms;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import allObjects.Admin;


public class AdminForm implements ActionListener{
	JFrame frame;//id;fname;lname;email;telephone;
	JLabel id_lb=new JLabel("ID");
	JLabel name_lb=new JLabel("NAME");
	JLabel phone_lb=new JLabel("PHONE NUMBER");
	JLabel email_lb=new JLabel("EMAIL");
	
	JTextField id_txf=new JTextField();
	JTextField name_txf=new JTextField();
	JTextField phone_txf=new JTextField();
	JTextField email_txf=new JTextField();
	
	JButton insert_btn=new JButton("Insert");
	JButton Read_btn=new JButton("View");
	JButton update_tbtn=new JButton("Update");
	JButton delete_btn=new JButton("Delete");
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int) screensize.getWidth();
	int h=(int) screensize.getHeight();



public AdminForm() {
	createWindow();
	setLocationAndSize();
	addComponentsToFrame();
	addActionEvent();
	setFontforall();
}
private void createWindow() {
frame=new JFrame();
frame.setTitle("ADMIN FORM");
frame.setBounds(0, 0, 600, 400);
frame.getContentPane().setLayout(null);
frame.getContentPane().setBackground(Color.green);
frame.setVisible(true);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setResizable(true);
}

private void setLocationAndSize() {
id_lb.setBounds(10, 10, 100, 30);
name_lb.setBounds(10, 50, 100, 30);
phone_lb.setBounds(10, 90, 100, 30);
email_lb.setBounds(10, 130, 100, 30);

id_txf.setBounds(230, 10, 200, 30);
name_txf.setBounds(230, 50, 200, 30);
phone_txf.setBounds(230, 90, 200, 30);
email_txf.setBounds(230, 130, 200, 30);

insert_btn.setBounds(10,250, 85, 30);
Read_btn.setBounds(100,250, 85, 30);
update_tbtn.setBounds(190,250, 85, 30);
delete_btn.setBounds(280,250, 85, 30);

}
private void addActionEvent() {
	insert_btn.addActionListener(this);
	Read_btn.addActionListener(this);
	update_tbtn.addActionListener(this);
	delete_btn.addActionListener(this);
	//genderBox.addActionListener(this);
}

private void setFontforall() {
	Font font = new Font("New Times Roman", Font.BOLD, 14);

	id_lb.setFont(font);
	name_lb.setFont(font);
	phone_lb.setFont(font);
	email_lb.setFont(font);
	id_txf.setFont(font);
	name_txf.setFont(font);
	phone_txf.setFont(font);
	email_txf.setFont(font);
	
	Font fonti = new Font("Georgia", Font.ITALIC, 14);

	insert_btn.setFont(fonti);
	Read_btn.setFont(fonti);
	update_tbtn.setFont(fonti);
	delete_btn.setFont(fonti);
}
private void addComponentsToFrame() {
	frame.add(id_lb);
	frame.add(name_lb);
	frame.add(phone_lb);
	frame.add(email_lb);
	
	frame.add(id_txf);
	frame.add(name_txf);
	frame.add(phone_txf);
	frame.add(email_txf);
	
	//Buttons CRUD
	frame.add(insert_btn);
	frame.add(Read_btn);
	frame.add(update_tbtn);
	frame.add(delete_btn);
}
public void actionPerformed(ActionEvent e) {
	Admin ad=new Admin();
	
	}
	public static void main(String[] args) {
		AdminForm admin=new AdminForm();

	}
















}

