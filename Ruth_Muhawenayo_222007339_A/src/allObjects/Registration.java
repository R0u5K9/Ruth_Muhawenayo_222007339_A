package allObjects;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Registration {
	    private int id;
		private String name;
		private String email;
		private String phone;
		private String country;
		private String district;
		private String sector;
		private String password;
		private String confirm_password;


	public Registration(int id, String name, String email, String phone, String country, String district, String sector, String password, String confirm_password){
	
	    this.id=id;
		this.name=name;
		this.email=email;
		this.phone=phone;
		this.country=country;
		this.district=district;
		this.sector=sector;
		this.password=password; 
		this.confirm_password=confirm_password;
		
	}

public Registration() {

}
public int getId(){
	return id;
}
public void setId(int id ) {
	this.id=id;
}

	public String getName(){
		return name;
	}
	public void setName(String name ) {
		this.name=name;
	}
	public String getEmail(){
		return email;
	}
	public void setEmail(String email ) {
		this.email=email;
	}
	public String getPhone(){
		return phone;
	}
	public void setPhone(String phone ) {
		this.phone=phone;
	}
	public String getCountry(){
		return country;
	}
	public void setCountry(String country ) {
		this.country=country;
	}
	public String getDistrict(){
		return district;
	}
	public void setDistrict(String district ) {
		this.district=district;
	}
	public String getSector(){
		return sector;
	}
	public void setSector(String sector) {
		this.sector=sector;
	}
	public String getPassword(){
		return password;
	}
	public void setPassword(String password) {
		this.password=password;
	}
	public String getConfirm_password(){
		return confirm_password;
	}
	public void setConfirm_password(String confirm_password) {
		this.confirm_password=confirm_password;
	}
	
	public void register() {
		String host = "jdbc:mysql://localhost/ruth_muhawenayo";
		String user = "root";
		String password = "";
		String sql = "INSERT INTO owners (name, email, phone, country, district, sector, password, confirm_password) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		String sqlQuery = "SELECT id FROM owners";
		
		try (Connection con = DriverManager.getConnection(host, user, password);
				PreparedStatement pstmCheck = con.prepareStatement(sqlQuery);
				PreparedStatement pstm = con.prepareStatement(sql);
				ResultSet resultSet = pstmCheck.executeQuery()) {

			ArrayList<Integer> existingIDs= new ArrayList<>();
			
			while (resultSet.next()) {
				int existingID = resultSet.getInt("id");
				existingIDs.add(existingID);
			
			}

			// Check if the entered username already exists
			if (existingIDs.contains(this.id)) {
				System.out.println("ID you entered already in use, enter another one");
				JOptionPane.showMessageDialog(null, "ID you entered already in use, enter another one");
			} 
			else {
				// Insert new user
				pstm.setString(1, this.name);
				pstm.setString(2, this.email);
				pstm.setString(3, this.phone);
				pstm.setString(4, this.country);
				pstm.setString(5, this.district);
				pstm.setString(6, this.sector);
				pstm.setString(7, this.password);
				pstm.setString(8, this.confirm_password);


				int rowsAffected = pstm.executeUpdate();

				if (rowsAffected > 0) {
					JOptionPane.showMessageDialog(null, "Data inserted successfully!");
				} else {
					JOptionPane.showMessageDialog(null, "Failed to insert data.",
							"Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		public DefaultTableModel populateTable() {
			String host = "jdbc:mysql://localhost/ruth_muhawenayo";
			String user = "root";
			String password = "";

			String sql = "SELECT * FROM owners"; // replace your_table with the actual table name
			DefaultTableModel tableModel = null;// = new DefaultTableModel(data, columnNames);
			try (Connection connection = DriverManager.getConnection(host, user, password);

					PreparedStatement preparedStatement = connection.prepareStatement(sql);
					ResultSet resultSet = preparedStatement.executeQuery()) {

				// Get column names
				int columnCount = resultSet.getMetaData().getColumnCount();

				Vector<String> columnNames = new Vector<>();
				for (int i = 1; i <= columnCount; i++) {
					columnNames.add(resultSet.getMetaData().getColumnName(i));
				}

				// Get data rows
				Vector<Vector<Object>> data = new Vector<>();
				while (resultSet.next()) {
					Vector<Object> row = new Vector<>();
					for (int i = 1; i <= columnCount; i++) {
						row.add(resultSet.getObject(i));
					}
					data.add(row);
				}

				// Create DefaultTableModel and set data
				tableModel = new DefaultTableModel(data, columnNames);
				//table.setModel(tableModel);

			} catch (SQLException e) {
				e.printStackTrace();
			}
			return tableModel;
		
		
		
		
	}

		public void login() {
		
	    	String host = "jdbc:mysql://localhost/ruth_muhawenayo";
	        String user = "root";
	        String password = "";
	        String sql = "SELECT * FROM owners WHERE email = ? AND password = ?";
	        
	    	try(
	    			Connection con = DriverManager.getConnection(host, user, password);
	            		
	                PreparedStatement stm= con.prepareStatement(sql);
	    			
	    			) {
	    		
	    		stm.setString(1, this.email);
	    		stm.setString(2, this.password);
	    		ResultSet rs = stm.executeQuery();
	    		if(rs.next()) {
	    			System.out.println("Data inserted successfully!");
	                JOptionPane.showMessageDialog(null, "Login successfully!","After login",JOptionPane.INFORMATION_MESSAGE);
	    		} else {
	    			JOptionPane.showMessageDialog(null, "Incorect Email and password!","After login",JOptionPane.INFORMATION_MESSAGE);
	    		}
	    		con.close();
	    		
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

			
		}

		


	



	
	

