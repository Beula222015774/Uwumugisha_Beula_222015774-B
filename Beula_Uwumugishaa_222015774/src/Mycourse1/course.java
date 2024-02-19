package Mycourse1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class course {
	
	private int courseid;
	private String coursename;
	private String coursecode;
	private String userid;
public course(int courseid, String coursename , String coursecode, String userid) {
super();
    this.courseid = courseid;
     this.coursename = coursename;
     this.coursecode = coursecode;
     this.userid=userid;
}

public course() {
	// TODO Auto-generated constructor stub
}

public int getCourseid() {
	return courseid;
}

public void setCourseid(int courseid) {
	this.courseid = courseid;
}

public String getCoursename() {
	return coursename;
}

public void setCoursename(String coursename) {
	this.coursename = coursename;
}

public String getCoursecode() {
	return coursecode;
}

public void setCoursecode(String coursecode) {
	this.coursecode = coursecode;
}
	
public String getUserid() {
	return userid;
}	
public void setUserid(String userid) {
	this.userid = userid;
}
public void makeconnection() {
}
		public void insertData() {
	// JDBC URL, username, and password of MySQL server
    String host = "jdbc:mysql://localhost/uwumugisha_beula";
    String user = "222015774";
    String password = "222015774";

    // SQL query to insert data
    String sql = "INSERT INTO course( course name,course code) VALUES (?,?,)";
	
    try (
        // Establish the connection
        Connection con = DriverManager.getConnection(host, user, password);

        // Create a prepared statement
    		PreparedStatement preparedStatement = con.prepareStatement(sql);
    	    ) {
        // Set the values for the prepared statement
       preparedStatement.setString(1, this.coursename);
       preparedStatement.setString(2, this.coursecode);
       
       //preparedStatement.setString(6, this.gender);
       
          
        
        // Execute the query
        int rowsAffected = preparedStatement.executeUpdate();

        // Check the result
        if (rowsAffected > 0) {
        	System.out.println("Data insert successfully!");
            JOptionPane.showMessageDialog(null, "Data insert successfully!","After insert",JOptionPane.INFORMATION_MESSAGE);
        } else {
            System.out.println("Failed to insert data.");
            JOptionPane.showMessageDialog(null, "Failed to register data.!","After insert",JOptionPane.ERROR_MESSAGE);

        }

    } catch (SQLException e) {
        e.printStackTrace();
    }}
 
		public static ResultSet viewData() {
	        String host = "jdbc:mysql://localhost/uwumugisha_beula";
	        String user = "222015774";
	        String password = "222015774";

	        String sql = "SELECT * FROM course";

	        try {
	            Connection con = DriverManager.getConnection(host, user, password);
	            PreparedStatement preparedStatement = con.prepareStatement(sql);
	            return preparedStatement.executeQuery();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
public void update(int inputcourseid) {
	// JDBC URL, username, and password of MySQL server
    String url = "jdbc:mysql://localhost/uwumugisha_beula";
    String user = "222015774";
    String password = "222015774";

    // SQL query to update data
    String sql = "UPDATE Course SET  course name= course code= WHERE courseid = ?";

    try (
        // Establish the con
        Connection con = DriverManager.getConnection(url, user, password);

        // Create a prepared statement
        PreparedStatement stm = con.prepareStatement(sql);
    ) {
        // Set the new values for the update
    	  
          stm.setString(1, this.getCoursename());
          stm.setString(2, this.getCoursecode());
          
          
          
          
          // Assuming there is a column named 'id' for the WHERE clause
       
          stm.setInt(3, inputcourseid);
       
        // Execute the update
        int rowsAffected = stm.executeUpdate();

        // Check the result
        if (rowsAffected > 0) {
            System.out.println("Data updated successfully!");
            JOptionPane.showMessageDialog(null, "Data updated successfully!!","After update",JOptionPane.INFORMATION_MESSAGE);
        } else {
            System.out.println("Failed to update data. No matching record found.");
            JOptionPane.showMessageDialog(null, "Failed to update data. No matching record found.!","After insert",JOptionPane.INFORMATION_MESSAGE);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }   
}
public void delete(int inputcourseID) {
	// JDBC URL, username, and password of MySQL server
    String url = "jdbc:mysql://localhost/uwumugisha_beula";
    String user = "222015774";
    String password = "222015774";

    // SQL query to delete data
    String sql = "DELETE FROM course WHERE courseid =?";

    try (
        // Establish the 
        Connection con= DriverManager.getConnection(url, user, password);

        // Create a prepared statement
        PreparedStatement pl = con.prepareStatement(sql);
    ) {
        // Set the value for the WHERE clause
        pl.setInt(1, inputcourseID); // Assuming there is a column named 'id' for the WHERE clause

        // Execute the delete
        int rowsAffected = pl.executeUpdate();

        // Check the result
        if (rowsAffected > 0) {
            System.out.println("Data deleted successfully!");
            JOptionPane.showMessageDialog(null, "Data deleted successfully!","After delete",JOptionPane.INFORMATION_MESSAGE);
        } else {
            System.out.println("Failed to delete data. No matching record found.");
            JOptionPane.showMessageDialog(null, "Failed to delete data. No matching record found. No matching record found.!","After insert",JOptionPane.INFORMATION_MESSAGE);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

}
}
	
	
	
	
	

