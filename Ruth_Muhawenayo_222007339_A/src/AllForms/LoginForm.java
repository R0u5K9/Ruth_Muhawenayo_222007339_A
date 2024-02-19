package AllForms;

import java.awt.*;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import allObjects.Login;

import javax.swing.JCheckBox;
import javax.swing.JPasswordField;

public class LoginForm implements ActionListener{

	
	
	
	
	
	JFrame frame;
	JLabel titleLabel= new JLabel("LOGIN FORM");
	JLabel emailLabel= new JLabel("EMAIL");
	JLabel passwordLabel= new JLabel("PASSWORD");
	
	JTextField emailTextField = new JTextField();
	JPasswordField passwordField = new JPasswordField();
	
	JButton loginButton = new JButton("LOGIN");
	JButton resetButton = new JButton("RESET");
	JCheckBox showPassword = new JCheckBox("show password");
	
	public LoginForm() {
		createWindow();
		setLocationAndSize();
		addComponentsToframe();
		addActionEvent();
		setFontforall();
	}
	public void createWindow() {
		frame= new JFrame();
		frame.setTitle("LOGIN FORM");
		frame.setBounds(0,0,600,400);
		frame.getContentPane().setBackground(Color.cyan);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
	}
	
	private void setLocationAndSize() {
		titleLabel.setBounds(180,50,150,30);
		emailLabel.setBounds(20,150,100,30);
		passwordLabel.setBounds(20,220,100,30);
		emailTextField.setBounds(200,150,180,30);
		passwordField.setBounds(200,220,180,30);
		showPassword.setBounds(50,300,100,30);
		loginButton.setBounds(100,300,100,30);
		resetButton.setBounds(300,300,100,30);
	}
	
  private void addComponentsToframe(){
		frame.add(titleLabel);
		frame.add(emailLabel);
		frame.add(passwordLabel);
		frame.add(emailTextField);
		frame.add(passwordField);
		frame.add(loginButton);
		frame.add(resetButton);
		
		
		
	}
	
	public void addActionEvent() {
	loginButton.addActionListener(this);
	resetButton.addActionListener(this);
	}
	
	private void setFontforall(){
		Font font = new Font("New Times Roman", Font.BOLD, 18);
		titleLabel.setFont(font);

		
		
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == loginButton) {
			Login myuser= new Login();
		}
	}
	public static void main(String[]args) {
		LoginForm login= new LoginForm();
	}
	

}

