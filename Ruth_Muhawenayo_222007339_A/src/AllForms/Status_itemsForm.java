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

import allObjects.Status;

	public class Status_itemsForm implements ActionListener {
		
		JFrame frame;//id;fname;lname;email;telephone;
		JLabel id_lb=new JLabel("ID");
		JLabel name_lb=new JLabel("NAME_OF_STATUS");
		
		
		JTextField id_txf=new JTextField();
		JTextField name_txf=new JTextField();
		
		
		JButton insert_btn=new JButton("Insert");
		JButton Read_btn=new JButton("View");
		JButton update_tbtn=new JButton("Update");
		JButton delete_btn=new JButton("Delete");
		JTable table=new JTable();
		JScrollPane scrollPane = new JScrollPane(table);
		Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
		int w=(int) screensize.getWidth();
		int h=(int) screensize.getHeight();


	public Status_itemsForm() {
		createWindow();
		setLocationAndSize();
		addComponentsToFrame();
		addActionEvent();
		setFontforall();
	}
	private void createWindow() {
	frame=new JFrame();
	frame.setTitle("ITEMS_STATUS FORM");
	frame.setBounds(0,0,950,600);
	frame.getContentPane().setLayout(null);
	frame.getContentPane().setBackground(Color.green);
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setResizable(true);
	}
	private void setLocationAndSize() {
	id_lb.setBounds(10, 50, 100, 30);
	name_lb.setBounds(10, 100, 100, 30);

	
	

	id_txf.setBounds(200, 50, 200, 30);
	name_txf.setBounds(200, 100, 200, 30);
	
	

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
	Font fonti = new Font("Georgia", Font.ITALIC, 14);

	insert_btn.setFont(fonti);
	Read_btn.setFont(fonti);
	update_tbtn.setFont(fonti);
	delete_btn.setFont(fonti);

	}
	private void addComponentsToFrame() {
		frame.add(id_lb);
		frame.add(name_lb);
		
		
		frame.add(id_txf);
		frame.add(name_txf);
		
		
		frame.add(insert_btn);
		frame.add(Read_btn);
		frame.add(update_tbtn);
		frame.add(delete_btn);
		frame.add( table);
	}

	public void actionPerformed(ActionEvent e) {
		Status stat=new Status();
		if(e.getSource()==insert_btn) {
			stat.setName(name_txf.getText());
			stat.insertData(null);
		}
			
		else if(e.getSource()==Read_btn) {
			stat.viewtwo();
			DefaultTableModel tableModel=stat.populateTable();
			table.setModel(tableModel);
		}
		else if(e.getSource()==update_tbtn) {
			String userInput = JOptionPane.showInputDialog(null, "Enter status_id:");
			String userInput1=name_txf.getText();
			stat.updatedata(Integer.parseInt(userInput), userInput1);
		}
		else if (e.getSource()==delete_btn) {
			String userInput = JOptionPane.showInputDialog(null, "Enter id:");
			stat.deletedata(Integer.parseInt(userInput));
		    }
			}
		
	public static void main(String[] args) {
		Status_itemsForm status=new Status_itemsForm();
			
			
	}
	}


