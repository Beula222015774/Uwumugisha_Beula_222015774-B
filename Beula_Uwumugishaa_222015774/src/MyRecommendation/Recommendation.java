package MyRecommendation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Recommendation {

	private String recommendationid;
	private String userid;
	private String recommendedcourseid;
	

	  
	public Recommendation( String recommendationid,String userid,String recommendedcourseid) {
    super();
    this.recommendationid = recommendationid;
    this.userid = userid;
    this.recommendedcourseid = recommendedcourseid;
	}


	public Recommendation() {
		// TODO Auto-generated constructor stub
	}


	public String getRecommendationid() {
		return recommendationid;
	}


	public void setRecommendationid(String recommendationid) {
		this.recommendationid = recommendationid;
	}


	public String getUserid() {
		return userid;
	}


	public void setUserid(String userid) {
		this.userid = userid;
	}


	public String getRecommendedcourseid() {
		return recommendedcourseid;
	}


	public void setRecommendedcourseid(String recommendedcourseid) {
		this.recommendedcourseid = recommendedcourseid;
	
	}

	public void makeconnection() {
	}
			public void insertData() {
		// JDBC URL, username, and password of MySQL server
	    String host = "jdbc:mysql://localhost/uwumugisha_beula";
	    String user = "222015774";
	    String password = "222015774";

	    // SQL query to insert data
	    String sql = "INSERT INTO Recommendation ( userid, recommendedcourseid) VALUES (?,?)";
		
	    try (
	        // Establish the connection
	        Connection con = DriverManager.getConnection(host, user, password);

	        // Create a prepared statement
	    		PreparedStatement preparedStatement = con.prepareStatement(sql);
	    	    ) {
	        // Set the values for the prepared statement
	       preparedStatement.setString(1, this.userid);
	       preparedStatement.setString(2, this.recommendedcourseid);
	       
	       
	          
	        
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

		        String sql = "SELECT * FROM recommendation";

		        try {
		            Connection con = DriverManager.getConnection(host, user, password);
		            PreparedStatement preparedStatement = con.prepareStatement(sql);
		            return preparedStatement.executeQuery();
		        } catch (SQLException e) {
		            e.printStackTrace();
		            return null;
		        }
		    }
	public void update(int inputrecommendationid) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/uwumugisha_beula";
	    String user = "222015774";
	    String password = "222015774";

	    // SQL query to update data
	    String sql = "UPDATE recommendation SET  userid=? ,recommendedcourseid=?  WHERE Recommendationid = ?";

	    try (
	        // Establish the con
	        Connection con = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement stm = con.prepareStatement(sql);
	    ) {
	        // Set the new values for the update
	    	  
	          stm.setString(1, this.getUserid());
	          stm.setString(2, this.getRecommendedcourseid());
	       
	          
	          // Assuming there is a column named 'id' for the WHERE clause
	       
	          stm.setInt(3, inputrecommendationid);
	       
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
	    }}
	   
	public void delete(int inputrecommendationid) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/uwumugisha_beula";
	    String user = "222015774";
	    String password = "222015774";
	    // SQL query to delete data
	    String sql = "DELETE FROM recommendation WHERE  Recommendationid =?";

	    try (
	        // Establish the 
	        Connection con= DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement pl = con.prepareStatement(sql);
	    ) {
	        // Set the value for the WHERE clause
	        pl.setInt(1, inputrecommendationid); // Assuming there is a column named 'id' for the WHERE clause

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
