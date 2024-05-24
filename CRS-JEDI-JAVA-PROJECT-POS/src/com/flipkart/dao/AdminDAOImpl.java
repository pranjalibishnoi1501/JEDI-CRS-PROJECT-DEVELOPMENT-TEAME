package com.flipkart.dao;
//package com.flipkart.constant.SQLConstant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.flipkart.exception.*;
import com.flipkart.bean.Course;
import com.flipkart.constant.SQLConstant;
import com.flipkart.utils.DBUtils;

public class AdminDAOImpl implements AdminDAOInterface {
	public void registerUser(int userId) throws UserNotApprovedException {
		try (Connection connection = DBUtils.getConnection()) {
			String selectQuery = SQLConstant.SELECT_USER;
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
						throw new UserNotApprovedException(userId);
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
	
//	public void addCourse() {
//		String query = "SELECT * FROM AddDropRequest";
//	    String updateQuery = "UPDATE AddDropRequest SET view = 1 WHERE courseCode = ?";
//	    
//	    try (Connection conn = DBUtils.getConnection();
//	         PreparedStatement selectStmt = conn.prepareStatement(query);
//	         PreparedStatement updateStmt = conn.prepareStatement(updateQuery);
//	         ResultSet rs = selectStmt.executeQuery()) {
//	        while (rs.next()) {
//	            String courseCode = rs.getString("courseCode");
//	            String type = rs.getString("type");
//	            int view = rs.getInt("view");
//	            
//	            if (type.equals("add") && view == 0) {
//	                // Update view to 1 if it's an add request and not viewed by admin
//	                updateStmt.setString(1, courseCode);
//	                int rowsAffected = updateStmt.executeUpdate();
//	                if (rowsAffected > 0) {
//	                    System.out.println("View updated for course: " + courseCode);
//	                } else {
//	                    System.out.println("Failed to update view for course: " + courseCode);
//	                }
//	            }
//	        }
//	    } catch (SQLException e) {
//	        e.printStackTrace();
//	    }
//		
//	}
	
//	public void checkSeatsAvailability(String courseCode, String type) {
//		// update in GradeCard
//		int numStudents = 0;
//	    String query = "SELECT numStudents FROM Course WHERE courseCode = ?";
//	    try (Connection conn = DBUtils.getConnection();
//	            PreparedStatement pstmt = conn.prepareStatement(query)) {
//	           pstmt.setString(1, courseCode);
//	           try (ResultSet rs = pstmt.executeQuery()) {
//	               if (rs.next()) {
//	                   numStudents = rs.getInt("numStudents");
//	               }
//	           }
//	       } catch (SQLException e) {
//	           e.printStackTrace();
//	       }
//	    
//	    if (type.equals("add") && numStudents < 10) {
//	        System.out.println("Seat added successfully for course: " + courseCode);
//	        numStudents++;
//	    }
//	    else if (type.equals("drop") && numStudents > 3) {
//	        System.out.println("Seat dropped successfully for course: " + courseCode);
//	        numStudents--;
//	    }
//	    else {
//	        System.out.println("No action taken for course: " + courseCode);
//	    }
//		
//	}
	public void updateSeats(String courseCode, int numStudents, int userID, String type) {
	    String updateQuery = "UPDATE Course SET numStudents = ? WHERE courseCode = ?";
	    String updateQuery1 = "INSERT INTO GradeCard (courseCode, userID) VALUES (?, ?)";
	    String updateQuery2 = "DELETE FROM GradeCard where courseCode = ? AND userID = ?";
	    String updateQuery3 = "INSERT INTO Notification (type,description,UserID) VALUES (?,?,?)";
	    try (Connection conn = DBUtils.getConnection();
	         PreparedStatement updateStmt = conn.prepareStatement(updateQuery)) {
	        	
	        updateStmt.setInt(1, numStudents);
	        updateStmt.setString(2, courseCode);
	        
	        int rowsAffected = updateStmt.executeUpdate(); // Execute the update query directly
	        PreparedStatement updateStmt1;
	        if(type.equals("add")) {
	        	updateStmt1= conn.prepareStatement(updateQuery1);
	        }
	        else {
	        	updateStmt1=conn.prepareStatement(updateQuery2);
	        }
	        
	        updateStmt1.setString(1, courseCode);
	        updateStmt1.setInt(2, userID);
	        int rows=updateStmt1.executeUpdate();
	        
	        
	        PreparedStatement updateStmt2=conn.prepareStatement(updateQuery3);
	        updateStmt2.setString(1, "course");
	        updateStmt2.setInt(3,userID);
	        if(type.equals("add")) {
	        	updateStmt2.setString(2,courseCode+"Course Added Successfully");
	        }
	        else {
	        	updateStmt2.setString(2,courseCode+"Course Dropped Successfully");
	        }
	        int rows1=updateStmt2.executeUpdate();
	        
	        if (rowsAffected > 0) {
	            System.out.println("NumStudents updated successfully for course: " + courseCode);
	            
	        } else {
	            System.out.println("Failed to update numStudents for course: " + courseCode);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	
//	public void updateSeats(String courseCode, int numStudents) {
//		String updateQuery = "UPDATE Course SET numStudents = ? WHERE courseCode = ?";
//        // Update the numStudents in the Course table
//	    try (Connection conn = DBUtils.getConnection();
//		        PreparedStatement updateStmt = conn.prepareStatement(updateQuery)) {
//	    		
//	    		updateStmt.setInt(1, numStudents);
//		        try (ResultSet rs = updateStmt.executeQuery()) {
//		            if (rs.next()) {
//		            	updateStmt.setInt(1, numStudents);
//				        updateStmt.setString(2, courseCode);
//				        updateStmt.executeUpdate();
//				        System.out.println("NumStudents updated successfully for course: " + courseCode);
//		            }
//		        }
//
//		    } catch (SQLException e) {
//		        e.printStackTrace();
//		    }
//	}
	
	public int checkSeatsAvailability(String courseCode) {
	    int numStudents = 0;
	    String query = "SELECT numStudents FROM Course WHERE courseCode = ?";
	    String updateQuery = "UPDATE Course SET numStudents = ? WHERE courseCode = ?";
	    
	    try (Connection conn = DBUtils.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(query);
	         PreparedStatement updateStmt = conn.prepareStatement(updateQuery)) {
	        
	        pstmt.setString(1, courseCode);
	        
	        try (ResultSet rs = pstmt.executeQuery()) {
	            if (rs.next()) {
	                numStudents = rs.getInt("numStudents");
	            }
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return numStudents;
	}

	
	public List<String[]> addCourse() {
	    List<String[]> updatedCourses = new ArrayList<>();

	    String query = "SELECT * FROM AddDropRequest";
	    

	    try (Connection conn = DBUtils.getConnection();
	         PreparedStatement selectStmt = conn.prepareStatement(query);
	         ResultSet rs = selectStmt.executeQuery()) {
	        while (rs.next()) {
	            String courseCode = rs.getString("courseCode");
	            String type = rs.getString("type");
	            int view = rs.getInt("view");
	            int userID = rs.getInt("userID");
	            String a = rs.getString("userID");
//	            System.out.println(userID+" "+courseCode+" "+view+" "+type);
//	            String updateQuery = "UPDATE AddDropRequest SET view = 1 WHERE courseCode = ? AND userID =?";
	            String updateQuery = "UPDATE AddDropRequest SET view = 1 WHERE courseCode = ? AND userID = ? AND type = ?";

	            
	            PreparedStatement updateStmt = conn.prepareStatement(updateQuery);
	            updateStmt.setString(1, courseCode);
                updateStmt.setInt(2, userID);
                updateStmt.setString(3, "add");
	            
	            if (type.equals("add") && view == 0) {
	            	System.out.println(courseCode);
	                int rowsAffected = updateStmt.executeUpdate();
	                if (rowsAffected > 0) {
	                    System.out.println("View updated for course: " + courseCode);
	                    updatedCourses.add(new String[]{a, courseCode, type});
	                } else {
	                    System.out.println("Failed to update view for course: " + courseCode);
	                }
	            }
	            else {
	            	System.out.println("Else : "+userID+" "+courseCode+" "+view+" "+type);
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return updatedCourses;
	}
	
	public List<String[]> removeCourse() {
	    List<String[]> updatedCourses = new ArrayList<>();

	    String query = "SELECT * FROM AddDropRequest";
	    

	    try (Connection conn = DBUtils.getConnection();
	         PreparedStatement selectStmt = conn.prepareStatement(query);
	         ResultSet rs = selectStmt.executeQuery()) {
	        while (rs.next()) {
	            String courseCode = rs.getString("courseCode");
	            String type = rs.getString("type");
	            int view = rs.getInt("view");
	            int userID = rs.getInt("userID");
	            String a = rs.getString("userID");
	            
//	            String updateQuery = "UPDATE AddDropRequest SET view = 1 WHERE courseCode = ? AND userID =?";
	            String updateQuery = "UPDATE AddDropRequest SET view = 1 WHERE courseCode = ? AND userID = ? AND type = ?";

	            System.out.println(userID+" "+courseCode+" "+view+" "+type);
	            PreparedStatement updateStmt = conn.prepareStatement(updateQuery);
	            updateStmt.setString(1, courseCode);
                updateStmt.setInt(2, userID);
                updateStmt.setString(3, "drop");
	            
	            if (type.equals("drop") && view == 0) {
	            	System.out.println(courseCode);
	                int rowsAffected = updateStmt.executeUpdate();
	                if (rowsAffected > 0) {
	                    System.out.println("View updated for course: " + courseCode);
	                    updatedCourses.add(new String[]{a, courseCode, type});
	                    
	                } else {
	                    System.out.println("Failed to update view for course: " + courseCode);
	                }
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return updatedCourses;
	}
	
//	public void removeCourse() {
//		String query = "SELECT * FROM AddDropRequest";
//	    String updateQuery = "UPDATE AddDropRequest SET view = 1 WHERE courseCode = ?";
//	    
//	    try (Connection conn = DBUtils.getConnection();
//	         PreparedStatement selectStmt = conn.prepareStatement(query);
//	         PreparedStatement updateStmt = conn.prepareStatement(updateQuery);
//	         ResultSet rs = selectStmt.executeQuery()) {
//	        while (rs.next()) {
//	            String courseCode = rs.getString("courseCode");
//	            String type = rs.getString("type");
//	            int view = rs.getInt("view");
//	            
//	            if (type.equals("drop") && view == 0) {
//	                // Update view to 1 if it's an add request and not viewed by admin
//	                updateStmt.setString(1, courseCode);
//	                int rowsAffected = updateStmt.executeUpdate();
//	                if (rowsAffected > 0) {
//	                    System.out.println("View updated for course: " + courseCode);
//	                } else {
//	                    System.out.println("Failed to update view for course: " + courseCode);
//	                }
//	            }
//	        }
//	    } catch (SQLException e) {
//	        e.printStackTrace();
//	    }
//		
//	}
	
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

