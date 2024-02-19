package Myenrollment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class enrollment {
	
	private int enrollmentid;
	private String courseid;
	private String userid;
	private String enrollmentdate;
	private String grade;
	
	
      public enrollment(int enrollmentid, String courseid,String userid, String enrollmentdate, String grade ) {
    	 super();
    	 this.enrollmentid = enrollmentid;
    	 this.courseid = courseid;
    	 this.userid = userid;
    	 this.enrollmentdate = enrollmentdate;
    	 this.grade = grade;
    	 
    	   }


	public enrollment() {
		// TODO Auto-generated constructor stub
	}


	public int getEnrollmentid() {
		return enrollmentid;
	}


	public void setEnrollmentid(int enrollmentid) {
		this.enrollmentid = enrollmentid;
	}


	public String getCourseid() {
		return courseid;
	}


	public void setCourseid(String courseid) {
		this.courseid = courseid;
	}


	public String getUserid() {
		return userid;
	}


	public void setUserid(String userid) {
		this.userid = userid;
	}


	public String getEnrollmentdate() {
		return enrollmentdate;
	}


	public void setEnrollmentdate(String enrollmentdate) {
		this.enrollmentdate = enrollmentdate;
	}


	public String getGrade() {
		return grade;
	}


	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	
	
	public void makeconnection() {
	}
			public void insertData() {
		// JDBC URL, username, and password of MySQL server
	    String host = "jdbc:mysql://localhost/uwumugisha_beula";
	    String user = "222015774";
	    String password = "222015774";

	    // SQL query to insert data
	    String sql = "INSERT INTO enrollment (courseid,userid,enrollmentdate,grade) VALUES (?,?,?,?)";
		
	    try (
	        // Establish the connection
	        Connection con = DriverManager.getConnection(host, user, password);

	        // Create a prepared statement
	    		PreparedStatement preparedStatement = con.prepareStatement(sql);
	    	    ) {
	        // Set the values for the prepared statement
	       preparedStatement.setString(1, this.courseid);
	       preparedStatement.setString(2, this.userid);
	       preparedStatement.setString(3, this.enrollmentdate);
	       preparedStatement.setString(4, this.grade);
	       
	       
	          
	        
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

		        String sql = "SELECT * FROM enrollment";

		        try {
		            Connection con = DriverManager.getConnection(host, user, password);
		            PreparedStatement preparedStatement = con.prepareStatement(sql);
		            return preparedStatement.executeQuery();
		        } catch (SQLException e) {
		            e.printStackTrace();
		            return null;
		        }
		    }
	public void update(int inputenrollmentid) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/uwumugisha_beula";
	    String user = "222015774";
	    String password = "222015774";

	    // SQL query to update data
	    String sql = "UPDATE enrollment SET  courseid=?, userid=?, enrollmentdate=? ,grade=?   WHERE enrollmentid = ?";

	    try (
	        // Establish the con
	        Connection con = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement stm = con.prepareStatement(sql);
	    ) {
	        // Set the new values for the update
	    	  
	          stm.setString(1, this.getCourseid());
	          stm.setString(2, this.getUserid());
	          stm.setString(3, this.getEnrollmentdate());
	          stm.setString(4, this.getGrade());
	          
	          
	          
	          
	          // Assuming there is a column named 'id' for the WHERE clause
	       
	          stm.setInt(5, inputenrollmentid);
	       
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
	public void delete(int inputenrollmentid) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/uwumugisha_beula";
	    String user = "222015774";
	    String password = "";

	    // SQL query to delete data
	    String sql = "DELETE FROM enrollmentWHERE  enrollmentid =?";

	    try (
	        // Establish the 
	        Connection con= DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement pl = con.prepareStatement(sql);
	    ) {
	        // Set the value for the WHERE clause
	        pl.setInt(1, inputenrollmentid); // Assuming there is a column named 'id' for the WHERE clause

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

	

