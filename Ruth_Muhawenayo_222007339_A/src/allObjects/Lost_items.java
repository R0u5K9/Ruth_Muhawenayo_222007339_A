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
import javax.swing.table.DefaultTableModel;


public class Lost_items {

	private int item_id;
	private String name;
	private String description;
	private String location;
	private String lost_date;
	
	public Lost_items(int item_id, String name, String description, String location, String lost_date) {
		this.item_id=item_id;
		this.name=name;
		this.description=description;
		this.location=location;
		this.lost_date=lost_date;
	}
	
	public Lost_items() {
		
	}
	
	public int getId() {
		return item_id;
	}
	
	public void setItem_id(int item_id) {
		this.item_id=item_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description=description;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location=location;
	}
	public String getLost_date() {
		return lost_date;
	}
	public void setDate(String lost_date) {
		this.lost_date=lost_date;
	}

	@SuppressWarnings("unused")
	public void makeconnection() {
		// JDBC URL, username, and password of MySQL server
	    String host = "jdbc:mysql://localhost/ruth_muhawenayo";
	    String user = "root";
	    String password = "";
	}
	public void insertData(String name,String description, String location,String found_date) {
		// JDBC URL, username, and password of MySQL server
	    String host = "jdbc:mysql://localhost/ruth_muhawenayo";
	    String user = "root";
	    String password = "";

	    // SQL query to insert data
	    String sql = "INSERT INTO lost_items (name, description, location,lost_date) VALUES (?, ?, ?, ?)";

	    try (
	        // Establish the connection
	        Connection con = DriverManager.getConnection(host, user, password);

	        // Create a prepared statement
	        PreparedStatement stm= con.prepareStatement(sql);
	    ) {
	        // Set the values for the prepared statement
	       stm.setString(1, this.name);
	        stm.setString(2, this.description);
	        stm.setString(3, this.location);
	        stm.setString(4, this.lost_date);

	        // Execute the query
	        int rowsAffected = stm.executeUpdate();

	        // Check the result
	        if (rowsAffected > 0) {
	        	System.out.println("Data inserted successfully!");
	            JOptionPane.showMessageDialog(null, "Data inserted successfully!","After insert",JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            System.out.println("Failed to insert data.");
	            JOptionPane.showMessageDialog(null, "Failed to insert data.!","After insert",JOptionPane.ERROR_MESSAGE);

	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }	
	}

	
	public void displayInformation() {
		String url = "jdbc:mysql://localhost/ruth_muhawenayo";
		String user = "root";
		String password = "";
		// SQL query to retrieve data
		String sql = "SELECT * lost_items";

		try (
				// Establish the con
				Connection con = DriverManager.getConnection(url, user, password);
				// Create a prepared statement
				PreparedStatement stm = con.prepareStatement(sql);

				// Execute the query and get the result set
				ResultSet resultSet = stm.executeQuery();
				){
			// Get the number of rows in the result set
			resultSet.last();
			int rowCount = resultSet.getRow();
			resultSet.beforeFirst();

			// Define a 2D array of objects
			Object[][] data = new Object[rowCount][3];

			// Process the result set and save data into the array
			int row = 0;
			while (resultSet.next()) {
				String column1Value = resultSet.getString("item_id");
				//int column1Value = resultSet.getInt("id");
				String column2Value = resultSet.getString("name");
				String column3Value = resultSet.getString("description");
				String column4Value = resultSet.getString("location");
				String column5Value = resultSet.getString("lost_date");
			
				// Save data into the 2D array
				data[row][0] = column1Value;
				data[row][1] = column2Value;
				data[row][2] = column3Value;
				data[row][3] = column4Value;
				data[row][4] = column5Value;

				row++;
			}
			// Print or use the data from the 2D array
						for (Object[] rowArray : data) {
							for (Object value : rowArray) {
								System.out.print(value + " ");
							}
							System.out.println();
						}

					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
	public void displaytwo() {
		String url = "jdbc:mysql://localhost/ruth_muhawenayo";
		String user = "root";
		String password = "";
		// SQL query to retrieve data
		String sql = "SELECT * from lost_items";

		try (
				// Establish the con
				Connection con = DriverManager.getConnection(url, user, password);
				// Create a prepared statement
				PreparedStatement stm = con.prepareStatement(sql);

				// Execute the query and get the result set
				ResultSet resultSet = stm.executeQuery();
				)
		{
			// Process the result set
			while (resultSet.next()) {
				int column1Value = resultSet.getInt("item_id");
				String column2Value = resultSet.getString("name");
				String column3Value = resultSet.getString("description");
				String column4Value = resultSet.getString("location");
				String column5Value = resultSet.getString("lost_date");

				System.out.println("item_id: " + column1Value + ", name: " + column2Value 
						+ ", description: " + column3Value+" , location: "+column4Value
						+", lost_date "+column5Value);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void updatedata(int item_id, String name, String description, String location, String lost_date) {
		String url = "jdbc:mysql://localhost/ruth_muhawenayo";
        String user = "root";
        String password = "";

        // SQL query to update data
        //String sql = "UPDATE user SET username = ?, password = ? where id='"+id+"'";
        String sql ="UPDATE lost_items set name=?, description=?, location=?, lost_date=? where item_id='"+item_id+"'";
        try (
            // Establish the con
            Connection con = DriverManager.getConnection(url, user, password);

            // Create a prepared statement
            PreparedStatement stm = con.prepareStatement(sql);
        		 ) {
            // Set the new values for the update
            stm.setString(1, name);
            stm.setString(2, description);
            stm.setString(3, location);
            stm.setString(4, lost_date);
        
            int result = JOptionPane.showConfirmDialog(null, "Do you really want to update the user with id"+item_id+"\n?", "Question", JOptionPane.YES_NO_OPTION);

            // Check the user's choice
            if (result == JOptionPane.YES_OPTION) {
            	// Execute the update
                int rowsAffected = stm.executeUpdate();

                // Check the result
                if (rowsAffected > 0) {
                   // System.out.println("Data updated successfully!");
                    JOptionPane.showMessageDialog(null, "Data updated successfully!");
                } else {
                    System.out.println("Failed to update data. No matching record found.");
                    JOptionPane.showMessageDialog(null, "Failed to update data. No matching record found.", "Error", JOptionPane.ERROR_MESSAGE);

                }
            } else {
                //System.out.println("User clicked No");
                JOptionPane.showMessageDialog(null, "We will not delete your data");

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	public void deletedata(int item_id) {
		String url = "jdbc:mysql://localhost/ruth_muhawenayo";
		String user = "root";
		String password = "";
		//String userInput = JOptionPane.showInputDialog(null, "Enter id:");
		//id=Integer.parseInt(userInput);
		//System.out.println("User entered: " + userInput);
		// SQL query to delete data

		String sql = "DELETE FROM lost_items WHERE item_id = ?";
		if(item_id==0) 
			JOptionPane.showMessageDialog(null, "No id entered");
		try (
				// Establish the con
				Connection con = DriverManager.getConnection(url, user, password);
				// Create a prepared statement
				PreparedStatement stm = con.prepareStatement(sql);
				) {
			// Set the value for the WHERE clause
						stm.setInt(1, item_id); // Assuming there is a column named 'id' for the WHERE clause

						// Execute the delete

						int result = JOptionPane.showConfirmDialog(null, "Do you really want to delete the item with id "+item_id+"\n?", "Question", JOptionPane.YES_NO_OPTION);

						// Check the user's choice
						if (result == JOptionPane.YES_OPTION) {
							//System.out.println("User clicked Yes");
							int rowsAffected = stm.executeUpdate();
							if (rowsAffected > 0) {
								JOptionPane.showMessageDialog(null, "The item with id: "+item_id+"\n was deleted!");

							} else {
								//System.out.println("Failed to delete data. No matching record found.");

								JOptionPane.showMessageDialog(null, "Failed to delete data. No matching record found.", "Error", JOptionPane.ERROR_MESSAGE);
							}
		}
		 else {
			//System.out.println("User clicked No");
			JOptionPane.showMessageDialog(null, "We can't delete the item");


		}
		// Check the result


	} catch (SQLException e) {
		e.printStackTrace();
	}
}
		public void deletedata2(int item_id) {
	    String url = "jdbc:mysql://localhost/ruth_muhawenayo";
	    String user = "root";
	    String password = "";

	    try (Connection con = DriverManager.getConnection(url, user, password)) {
	        // Check if the user exists before proceeding with deletion
	        if (checkUserExists(con, item_id)) {
	            int result = JOptionPane.showConfirmDialog(null, "Do you really want to delete the user with id " + item_id + "\n?", "Question", JOptionPane.YES_NO_OPTION);

	            if (result == JOptionPane.YES_OPTION) {
	                // Delete associated records from userrole table
	                deleteAssociatedLost_itemsRecords(con, item_id);

	                // Now delete the user record
	                String sql = "DELETE FROM item WHERE userID = ?";
	                try (PreparedStatement stm = con.prepareStatement(sql)) {
	                    stm.setInt(1, item_id);
	                    int rowsAffected = stm.executeUpdate();

	                    if (rowsAffected > 0) {
	                        JOptionPane.showMessageDialog(null, "The item with id: " + item_id + "\n was deleted!");
	                    } else {
	                        JOptionPane.showMessageDialog(null, "Failed to delete item. No matching record found.", "Error", JOptionPane.ERROR_MESSAGE);
	                    }
	                }
	            } else {
	                JOptionPane.showMessageDialog(null, "User chose not to delete the item.");
	            }
	        } else {
	            JOptionPane.showMessageDialog(null, "item with id: " + item_id + " not found.");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	private void deleteAssociatedLost_itemsRecords(Connection con, int item_id2) {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unused")
	private boolean checkUserExists1(Connection con, int item_id2) {
		// TODO Auto-generated method stub
		return false;
	}
	private boolean checkUserExists(Connection con, int item_id2) throws SQLException {
	    String sql = "SELECT * FROM lost_items WHERE userID = ?";
	    try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
	        preparedStatement.setInt(1, item_id);
	        try (ResultSet resultSet = preparedStatement.executeQuery()) {
	            return resultSet.next();
	        }
	    }
	}
	@SuppressWarnings("unused")
	private void deleteAssociatedLost_itemsRecords1(Connection con, int item_id2) throws SQLException {
	    String sql = "DELETE FROM lost_items WHERE item_id = ?";
	    try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
	        preparedStatement.setInt(1, item_id);
	        preparedStatement.executeUpdate();
	    }
	}
	public DefaultTableModel populateTable() {
		String host = "jdbc:mysql://localhost/ruth_muhawenayo";
		String user = "root";
		String password = "";

		String sql = "SELECT * FROM lost_items"; // replace your_table with the actual table name
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


}

