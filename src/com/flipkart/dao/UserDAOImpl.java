package com.flipkart.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.flipkart.utils.DBUtils;

public class UserDAOImpl implements UserDAOInterface {
	
	 public boolean Login(int userID, String name, String password, String role) {
		 String query = "SELECT * FROM User WHERE userID= ? AND name = ? AND password = ? AND role = ? AND isApproved = 1";
		    try (Connection conn = DBUtils.getConnection();
		    		
		        PreparedStatement pstmt = conn.prepareStatement(query)) {
		        pstmt.setInt(1, userID);
		        pstmt.setString(2, name);
		        pstmt.setString(3, password);
		        pstmt.setString(4, role);
		        try (ResultSet rs = pstmt.executeQuery()) {
		            return rs.next();
//		            return true;
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		        return false;
		    }
		}
	public void Register(String username, String password, String role) {
		String insertQuery = "INSERT INTO User (name, password, role, isApproved) VALUES (?, ?, ?, ?)";

		try (Connection conn = DBUtils.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(insertQuery)) {
			pstmt.setString(3, role);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			pstmt.setBoolean(4, false);
			int rowsInserted = pstmt.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("User details stored in database");
			} else {
				System.out.println("Failed to store user details in database");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void ChangePassword(int userID, String password){
		try (Connection conn = DBUtils.getConnection()) {
	        String updateQuery = "UPDATE User SET password = ? WHERE userID = ?";
	        try (PreparedStatement pstmt = conn.prepareStatement(updateQuery)) {
	            pstmt.setString(1, password);
	            pstmt.setInt(2, userID);
	            int rowsAffected = pstmt.executeUpdate();
	            if (rowsAffected > 0) {
	                System.out.println("Password updated successfully for user with ID: " + userID);
	            } else {
	                System.out.println("Failed to update password for user with ID: " + userID);
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }	
	}
	
		public void Exit() {
		
	}

}
