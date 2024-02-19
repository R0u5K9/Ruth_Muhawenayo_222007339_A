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

import allObjects.Found_items;



public class Found_itemsForm implements ActionListener {
	
	JFrame frame;//id;fname;lname;email;telephone;
	JLabel item_id_lb=new JLabel("ID");
	JLabel name_lb=new JLabel("ITEM_NAME");
	JLabel description_lb=new JLabel("DESCRIPTION");
	JLabel location_lb=new JLabel("LOCATION_OF_FOUND");
	JLabel found_date_lb=new JLabel("FOUND_DATE");

	JTextField item_id_txf=new JTextField();
	JTextField name_txf=new JTextField();
	JTextField description_txf=new JTextField();
	JTextField location_txf=new JTextField();
	JTextField found_date_txf=new JTextField();
	
	JButton insert_btn=new JButton("Insert");
	JButton Read_btn=new JButton("View");
	JButton update_tbtn=new JButton("Update");
	JButton delete_btn=new JButton("Delete");
	JTable table=new JTable();
	JScrollPane scrollPane = new JScrollPane(table);
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int) screensize.getWidth();
	int h=(int) screensize.getHeight();


public Found_itemsForm() {
	createWindow();
	setLocationAndSize();
	addComponentsToFrame();
	addActionEvent();
	setFontforall();
}
private void createWindow() {
	frame=new JFrame();
	frame.setTitle("FOUND_ITEMS");
	frame.setBounds(0,0,950,600);
	frame.getContentPane().setLayout(null);
	frame.getContentPane().setBackground(Color.yellow);
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setResizable(true);
	}
private void setLocationAndSize() {
	item_id_lb.setBounds(10, 10, 100, 30);
	name_lb.setBounds(10, 50, 100, 30);
	description_lb.setBounds(10, 90, 100, 30);
	location_lb.setBounds(10, 130, 180, 30);
	found_date_lb.setBounds(10, 170, 100, 30);
	
	item_id_txf.setBounds(230, 10, 200, 30);
	name_txf.setBounds(230, 50, 200, 30);
	description_txf.setBounds(230, 90, 200, 30);
	location_txf.setBounds(230, 130, 200, 30);
	found_date_txf.setBounds(230, 170, 200, 30);
	
	//Buttons CRUDs
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
	Font font = new Font("New Times Roman", Font.BOLD, 14);

	item_id_lb.setFont(font);
	name_lb.setFont(font);
	description_lb.setFont(font);
	location_lb.setFont(font);
	found_date_lb.setFont(font);

	item_id_txf.setFont(font);
	name_txf.setFont(font);
	description_txf.setFont(font);
	location_txf.setFont(font);
	found_date_txf.setFont(font);
	
	Font fonti = new Font("Georgia", Font.ITALIC, 14);

	insert_btn.setFont(fonti);
	Read_btn.setFont(fonti);
	update_tbtn.setFont(fonti);
	delete_btn.setFont(fonti);
}
private void addComponentsToFrame() {
	frame.add(item_id_lb);
	frame.add(name_lb);
	frame.add(description_lb);
	frame.add(location_lb);
	frame.add(found_date_lb);
	frame.add(item_id_txf);
	frame.add(name_txf);
	frame.add(description_txf);
	frame.add(location_txf);
	frame.add(found_date_txf);
	//Buttons CRUDku
	frame.add(insert_btn);
	frame.add(Read_btn);
	frame.add(update_tbtn);
	frame.add(delete_btn);
	frame.add( table);

}
public void actionPerformed(ActionEvent e) {
	Found_items fd=new Found_items();
	if(e.getSource()==insert_btn) {
		fd.setName(name_txf.getText());
		fd.setDescription(description_txf.getText());
		fd.setLocation(location_txf.getText());
		fd.setDate(found_date_txf.getText());
		fd.insertData(null, null, null, null);
	}
else if(e.getSource()==Read_btn) {
	fd.viewtwo();
	DefaultTableModel tableModel=fd.populateTable();
	table.setModel(tableModel);
}
else if(e.getSource()==update_tbtn) {
	String userInput = JOptionPane.showInputDialog(null, "Enter id:");
	String userInput1=name_txf.getText();
	String userInput2=description_txf.getText();
	String userInput3=location_txf.getText();
	String userInput4=found_date_txf.getText();
	fd.updatedata(Integer.parseInt(userInput), userInput1, userInput2, userInput3, userInput4);
}
else if (e.getSource()==delete_btn) {
	String userInput = JOptionPane.showInputDialog(null, "Enter id:");
	fd.deletedata(Integer.parseInt(userInput));
    }
	}
	
public static void main(String[] args) {
	Found_itemsForm fnd=new Found_itemsForm();

}
}

