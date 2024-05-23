package com.flipkart.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.utils.DBUtils;

public class AdminDAOImpl implements AdminDAOInterface {
	public void registerUser(int userId) {
		try (Connection connection = DBUtils.getConnection()) {
			String selectQuery = "SELECT * FROM User WHERE userID = ?";
			try (PreparedStatement selectStmt = connection.prepareStatement(selectQuery)) {
				selectStmt.setInt(1, userId);
				try (ResultSet rs = selectStmt.executeQuery()) {
					if (rs.next()) {
						int isApproved = rs.getInt("isApproved");
						if (isApproved == 0) { // Check if user is not already approved
							String updateQuery = "UPDATE User SET isApproved = ? WHERE userID = ?";
							try (PreparedStatement updateStmt = connection.prepareStatement(updateQuery)) {
								updateStmt.setInt(1, 1); // Set user as approved
								updateStmt.setInt(2, userId);

								int rowsAffected = updateStmt.executeUpdate();
								if (rowsAffected > 0) {
									System.out.println("User registration successful");
								} else {
									System.out.println("Failed to update user approval status");
								}
							}
						} else {
							System.out.println("User is already approved");
						}
					} else {
						System.out.println("User with ID " + userId + " not found");
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void modifyCourseDetails(String courseId, int userId, String description) {
	    String selectQuery = "SELECT * FROM Course WHERE courseCode = ?";
	    try (Connection conn = DBUtils.getConnection();
	         PreparedStatement selectStmt = conn.prepareStatement(selectQuery)) {
	        selectStmt.setString(1, courseId);
	        try (ResultSet rs = selectStmt.executeQuery()) {
	            if (rs.next()) {
	                String updateQuery = "UPDATE Course SET userID = ?, courseDescription = ? WHERE courseCode = ?";
	                try (PreparedStatement updateStmt = conn.prepareStatement(updateQuery)) {
	                    updateStmt.setInt(1, userId);
	                    updateStmt.setString(2, description);
	                    updateStmt.setString(3, courseId);
	                    int rowsAffected = updateStmt.executeUpdate();
	                    if (rowsAffected > 0) {
	                        System.out.println("Course modified successfully");
	                    } else {
	                        System.out.println("Failed to modify course");
	                    }
	                }
	            } else {
	                System.out.println("Course with ID " + courseId + " not found");
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public List<Course> createCatalog(){
		List<Course> catalog = new ArrayList<>();
	    String query = "SELECT * FROM Course";
	    try (Connection conn = DBUtils.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(query);
	         ResultSet rs = pstmt.executeQuery()) {
	        while (rs.next()) {
	            String courseCode = rs.getString("courseCode");
	            int userID = rs.getInt("userID");
	            String courseDescription = rs.getString("courseDescription");
	            Course course = new Course(courseCode, userID, courseDescription);
	            catalog.add(course);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return catalog;
	}
	
	public void addCourse() {
		String query = "SELECT * FROM AddDropRequest";
	    String updateQuery = "UPDATE AddDropRequest SET view = 1 WHERE courseCode = ?";
	    
	    try (Connection conn = DBUtils.getConnection();
	         PreparedStatement selectStmt = conn.prepareStatement(query);
	         PreparedStatement updateStmt = conn.prepareStatement(updateQuery);
	         ResultSet rs = selectStmt.executeQuery()) {
	        while (rs.next()) {
	            String courseCode = rs.getString("courseCode");
	            String type = rs.getString("type");
	            int view = rs.getInt("view");
	            
	            if (type.equals("add") && view == 0) {
	                // Update view to 1 if it's an add request and not viewed by admin
	                updateStmt.setString(1, courseCode);
	                int rowsAffected = updateStmt.executeUpdate();
	                if (rowsAffected > 0) {
	                    System.out.println("View updated for course: " + courseCode);
	                } else {
	                    System.out.println("Failed to update view for course: " + courseCode);
	                }
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		
	}
	
	public void removeCourse() {
		String query = "SELECT * FROM AddDropRequest";
	    String updateQuery = "UPDATE AddDropRequest SET view = 1 WHERE courseCode = ?";
	    
	    try (Connection conn = DBUtils.getConnection();
	         PreparedStatement selectStmt = conn.prepareStatement(query);
	         PreparedStatement updateStmt = conn.prepareStatement(updateQuery);
	         ResultSet rs = selectStmt.executeQuery()) {
	        while (rs.next()) {
	            String courseCode = rs.getString("courseCode");
	            String type = rs.getString("type");
	            int view = rs.getInt("view");
	            
	            if (type.equals("drop") && view == 0) {
	                // Update view to 1 if it's an add request and not viewed by admin
	                updateStmt.setString(1, courseCode);
	                int rowsAffected = updateStmt.executeUpdate();
	                if (rowsAffected > 0) {
	                    System.out.println("View updated for course: " + courseCode);
	                } else {
	                    System.out.println("Failed to update view for course: " + courseCode);
	                }
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		
	}
	
	public void notifyStudents(String description, int userID) {
		String insertQuery = "INSERT INTO Notification (description, userID, type) VALUES (?, ?, ?)";

		try (Connection conn = DBUtils.getConnection();
				PreparedStatement selectStmt = conn.prepareStatement(insertQuery)) {
			selectStmt.setString(1, description);
			selectStmt.setInt(2, userID);
			selectStmt.setString(3, "course");

			int rowsAffected = selectStmt.executeUpdate();
			if (rowsAffected > 0) {
				System.out.println("Updated");
			} else {
				System.out.println("Not Updated");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public void notifyBillingDepartment(String description, int userID) {
		String insertQuery = "INSERT INTO Notification (description, userID, type) VALUES (?, ?, ?)";

		try (Connection conn = DBUtils.getConnection();
				PreparedStatement selectStmt = conn.prepareStatement(insertQuery)) {
			selectStmt.setString(1, description);
			selectStmt.setInt(2, userID);
			selectStmt.setString(3, "payment");

			int rowsAffected = selectStmt.executeUpdate();
			if (rowsAffected > 0) {
				System.out.println("Updated");
			} else {
				System.out.println("Not Updated");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}

