package Myrating;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class rating {
	private int ratingid;
	private String userid;
	private String courseid;
	private String rating;
	private String review;
	  
	public rating(int ratingid, String userid, String courseid, String rating, String review) {
    super();
    this.ratingid = ratingid;
    this.userid = userid;
    this.courseid = courseid;
    this.rating = rating;
    this.review = review;

	}

	public rating() {
		// TODO Auto-generated constructor stub
	}

	public int getRatingid() {
		return ratingid;
	}

	public void setRatingid(int ratingid) {
		this.ratingid = ratingid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getCourseid() {
		return courseid;
	}

	public void setCourseid(String courseid) {
		this.courseid = courseid;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public void makeconnection() {
	}
			public void insertData() {
		// JDBC URL, username, and password of MySQL server
	    String host = "jdbc:mysql://localhost/uwumugisha_beula";
	    String user = "222015774";
	    String password = "222015774";

	    // SQL query to insert data
	    String sql = "INSERT INTO rating(userid,courseid,rating,review) VALUES (?,?,?,?)";
		
	    try (
	        // Establish the connection
	        Connection con = DriverManager.getConnection(host, user, password);

	        // Create a prepared statement
	    		PreparedStatement preparedStatement = con.prepareStatement(sql);
	    	    ) {
	        // Set the values for the prepared statement
	       preparedStatement.setString(1, this.userid);
	       preparedStatement.setString(2, this.courseid);
	       preparedStatement.setString(3, this.rating);
	       preparedStatement.setString(4, this.review);
	       
	          
	        
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

		        String sql = "SELECT * FROM rating";

		        try {
		            Connection con = DriverManager.getConnection(host, user, password);
		            PreparedStatement preparedStatement = con.prepareStatement(sql);
		            return preparedStatement.executeQuery();
		        } catch (SQLException e) {
		            e.printStackTrace();
		            return null;
		        }
		    }
	public void update(int inputratingid) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/uwumugisha_beula";
	    String user = "222015774";
	    String password = "222015774";

	    // SQL query to update data
	    String sql = "UPDATE rating SET  userid=? courseid=? rating=? review=?  WHERE ratingid = ?";

	    try (
	        // Establish the con
	        Connection con = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement stm = con.prepareStatement(sql);
	    ) {
	        // Set the new values for the update
	    	  
	          stm.setString(1, this.getUserid());
	          stm.setString(2, this.getCourseid());
	          stm.setString(3, this.getRating());
	          stm.setString(4, this.getReview());
	         
	          
	          
	          
	          // Assuming there is a column named 'id' for the WHERE clause
	       
	          stm.setInt(5, inputratingid);
	       
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
	public void delete(int inputratingid) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/uwumugisha_beula";
	    String user = "222015774";
	    String password = "222015774";

	    // SQL query to delete data
	    String sql = "DELETE FROM rating WHERE  ratingid =?";

	    try (
	        // Establish the 
	        Connection con= DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement pl = con.prepareStatement(sql);
	    ) {
	        // Set the value for the WHERE clause
	        pl.setInt(1, inputratingid); // Assuming there is a column named 'id' for the WHERE clause

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
