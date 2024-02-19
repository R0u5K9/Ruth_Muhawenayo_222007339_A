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
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import allObjects.Lost_items;



public class Lost_itemsForm implements ActionListener{
	
	JFrame frame;//id;fname;lname;email;telephone;
	JLabel name_lb=new JLabel("ITEM_NAME");
	JLabel description_lb=new JLabel("DESCRIPTION");
	JLabel location_lb=new JLabel("LOCATION_OF_LOST");
	JLabel lost_date_lb=new JLabel("LOST_DATE");

	JTextField name_txf=new JTextField();
	JTextField description_txf=new JTextField();
	JTextField location_txf=new JTextField();
	JTextField lost_date_txf=new JTextField();
	
	JButton insert_btn=new JButton("Insert");
	JButton Read_btn=new JButton("View");
	JButton update_tbtn=new JButton("Update");
	JButton delete_btn=new JButton("Delete");
	JTable table=new JTable();
	JScrollPane scrollPane = new JScrollPane(table);
	
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int) screensize.getWidth();
	int h=(int) screensize.getHeight();
	

	public Lost_itemsForm() {
		createWindow();
		setLocationAndSize();
		addComponentsToFrame();
		addActionEvent();
		setFontforall();
	}
	private void createWindow() {
		frame=new JFrame();
		frame.setTitle("LOST_ITEMS");
		frame.setBounds(0,0,950,600);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
	}
	private void setLocationAndSize() {
		
		name_lb.setBounds(10, 50, 100, 30);
		description_lb.setBounds(10, 90, 700, 30);
		location_lb.setBounds(10, 130, 180, 30);
		lost_date_lb.setBounds(10, 170, 100, 30);
		
		
		name_txf.setBounds(230, 50, 200, 30);
		description_txf.setBounds(230, 90, 200, 30);
		location_txf.setBounds(230, 130, 200, 30);
		lost_date_txf.setBounds(230, 170, 200, 30);
		
		//Buttons CRUD
		insert_btn.setBounds(10,250, 85, 30);
		Read_btn.setBounds(100,250, 85, 30);
		update_tbtn.setBounds(190,250, 85, 30);
		delete_btn.setBounds(280,250, 85, 30);
		table.setBounds(450, 90, 480, 450);
	}
	private void addActionEvent() {
		insert_btn.addActionListener(this);
		Read_btn.addActionListener(this);
		update_tbtn.addActionListener(this);
		delete_btn.addActionListener(this);
		
		//genderBox.addActionListener(this);
	}
	private void setFontforall() {
		Font font = new Font("Georgia", Font.BOLD, 14);

		
		name_lb.setFont(font);
		description_lb.setFont(font);
		location_lb.setFont(font);
		lost_date_lb.setFont(font);

		
		name_txf.setFont(font);
		description_txf.setFont(font);
		location_txf.setFont(font);
		lost_date_txf.setFont(font);
		
		//Buttons CRUD
		Font fonti = new Font("Courier New", Font.BOLD, 14);

		insert_btn.setFont(fonti);
		Read_btn.setFont(fonti);
		update_tbtn.setFont(fonti);
		delete_btn.setFont(fonti);
	}
	private void addComponentsToFrame() {
		
		frame.add(name_lb);
		frame.add(description_lb);
		frame.add(location_lb);
		frame.add(lost_date_lb);
		
		frame.add(name_txf);
		frame.add(description_txf);
		frame.add(location_txf);
		frame.add(lost_date_txf);
		//Buttons CRUD
		frame.add(insert_btn);
		frame.add(Read_btn);
		frame.add(update_tbtn);
		frame.add(delete_btn);
		frame.add( table);

	}
	
	public void actionPerformed(ActionEvent e) {
		Lost_items lst=new Lost_items();
		if(e.getSource()==insert_btn) {
			lst.setName(name_txf.getText());
			lst.setDescription(description_txf.getText());
			lst.setLocation(location_txf.getText());
			lst.setDate(lost_date_txf.getText());
			lst.insertData(null, null, null, null);
		}
		else if(e.getSource()==Read_btn) {
			lst.displaytwo();
			DefaultTableModel tableModel=lst.populateTable();
			table.setModel(tableModel);
	}
	else if(e.getSource()==update_tbtn) {
		String userInput = JOptionPane.showInputDialog(null, "Enter id:");
		String userInput1=name_txf.getText();
		String userInput2=description_txf.getText();
		String userInput3=location_txf.getText();
		String userInput4=lost_date_txf.getText();
		lst.updatedata(Integer.parseInt(userInput), userInput1, userInput2, userInput3, userInput4);
		
		
}else if (e.getSource()==delete_btn) {
	String userInput = JOptionPane.showInputDialog(null, "Enter id:");
	lst.deletedata(Integer.parseInt(userInput));
    }
	}


	


		
	public static void main(String[] args) {
		Lost_itemsForm lost =new Lost_itemsForm();

	}
	
	
}





