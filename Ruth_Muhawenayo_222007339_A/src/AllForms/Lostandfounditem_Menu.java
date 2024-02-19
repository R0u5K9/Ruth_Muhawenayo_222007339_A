package AllForms;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import AllForms.Found_itemsForm;
import AllForms.Lost_itemsForm;
import AllForms.RegistrationForm;
import AllForms.Status_itemsForm;

public class Lostandfounditem_Menu implements ActionListener {

	JFrame frame;
	JMenu home,  Owners, Lost_items, Found_items, Status, more;
	JMenuItem i1, i2, i3, i4, i5, i6, item1, item2,OwnersRead;
	JMenuItem LostRead;
	JMenuItem FoundRead;
	JMenuItem StatusRead;

Lostandfounditem_Menu(){
	createWindow();

}
	private void createWindow() {
		frame = new JFrame("Menu form with main Menu");
		frame.setSize(400, 400);

		JMenuBar mb = new JMenuBar(); // Create a new menu bar
		home = new JMenu("Home");
		Owners = new JMenu("Owners");
		Lost_items= new JMenu("Lost_items");
		Found_items = new JMenu("Found_items");
		Status=new JMenu("Status");
		

		more = new JMenu("More");
		i1 = new JMenuItem("Insert");
		i2 = new JMenuItem("Read");
		i3 = new JMenuItem("Update");
		i4 = new JMenuItem("Delete");
		i5 = new JMenuItem("Item 5");
		i6 = new JMenuItem("Item 6");
		more.add(i5);
		more.add(i6);

		home.add(i1);
		home.add(more); // Add the 'more' submenu to the 'home' menu
		
		OwnersRead = new JMenuItem("Read");
		Owners.add(OwnersRead);
		

		LostRead =new JMenuItem("Read");
		
		Lost_items.add(LostRead);
		
		
		FoundRead =new JMenuItem("Read");
		Found_items.add(FoundRead);
		
		
		StatusRead =new JMenuItem("Read");
		Status.add(StatusRead);
		
		
				
		
		

		

		mb.add(home);
		mb.add(Owners);
		mb.add(Lost_items);
		mb.add(Found_items);
		mb.add(Status);
		
		frame.setJMenuBar(mb);// Set the menu bar to the frame

		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		componentsOnFrame();

	
}
	private void componentsOnFrame() {
		home = new JMenu("Home");
		Owners = new JMenu("Owners");
		Lost_items = new JMenu("Lost items");
		Found_items =new JMenu("Found_items");
		Status =new JMenu("Status");
		
		
		
		more = new JMenu("More");
		i1 = new JMenuItem("Create");
		i2 = new JMenuItem("Read");
		i3 = new JMenuItem("Update");
		i4 = new JMenuItem("Delete");
		i5 = new JMenuItem("Item 5");
		i6 = new JMenuItem("Item 6");
		more.add(i5);
		more.add(i6);

		home.add(i1);
		home.add(more);
		Owners.add(i2);
		Lost_items.add(i2);
		Found_items.add(i2);
		Status.add(i2);
		addactionEvent();

		
	}
	private void addactionEvent() {
		OwnersRead.addActionListener(this);
		LostRead.addActionListener(this);
		FoundRead.addActionListener(this);
		StatusRead.addActionListener(this);
		
	}
	public static void main(String[] args) {
	new Lostandfounditem_Menu();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==OwnersRead) {
			RegistrationForm pf=new RegistrationForm();
			frame.dispose();
		}else if (e.getSource()==LostRead) {
			Lost_itemsForm df=new Lost_itemsForm();
			frame.dispose();
		}else if (e.getSource()==FoundRead) {
			Found_itemsForm nf=new Found_itemsForm();
			frame.dispose();
		}else if (e.getSource()==StatusRead) {
			Status_itemsForm cf=new Status_itemsForm();
			frame.dispose();
			}

	}

}
