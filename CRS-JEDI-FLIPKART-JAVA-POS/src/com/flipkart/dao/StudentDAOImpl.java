package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.RegisteredCourse;
import com.flipkart.bean.Student;
import com.flipkart.utils.DBUtils;

public class StudentDAOImpl implements StudentDAOInterface{
	
    public void addCourse(int userID, String courseCode) {
        try (Connection connection = DBUtils.getConnection()) {
            String insertQuery = "INSERT INTO AddDropRequest (userID, courseCode, type) VALUES (?, ?, ?)";
            try (PreparedStatement pstmt = connection.prepareStatement(insertQuery)) {
                pstmt.setInt(1, userID);
                pstmt.setString(2, courseCode);
                pstmt.setString(3, "add");
                int rowsInserted = pstmt.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("Course added successfully.");
                } else {
                    System.out.println("Failed to add course.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropCourse(int userID, String courseCode) {
    	try (Connection connection = DBUtils.getConnection()) {
            String insertQuery = "INSERT INTO AddDropRequest (userID, courseCode, type) VALUES (?, ?, ?)";
            try (PreparedStatement pstmt = connection.prepareStatement(insertQuery)) {
                pstmt.setInt(1, userID);
                pstmt.setString(2, courseCode);
                pstmt.setString(3, "drop");
                int rowsInserted = pstmt.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("Course added successfully.");
                } else {
                    System.out.println("Failed to add course.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	public List<Course> viewCourseCatalog(){
		Connection connection=DBUtils.getConnection();
		List<Course> courseList=new ArrayList<Course>();
		try {
			PreparedStatement statement = connection.prepareStatement("Select * from Course");
			
			
			ResultSet results=statement.executeQuery();
			while(results.next())
			{
				courseList.add(new Course(results.getString("courseCode"), results.getInt("userID"), results.getString("courseDescription")));
			}
		}
		catch(SQLException e)
		{
//			logger.error(e.getMessage());
		}
		finally
		{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return courseList;
	}
	
	/////////////////////////////////
	
	public List<Course> viewRegisteredCourse(int userID){
		Connection connection=DBUtils.getConnection();
		List<Course> courseList=new ArrayList<Course>();
		try {
			PreparedStatement statement = connection.prepareStatement("Select * from GradeCard where userID = ?");
			statement.setInt(1, userID);
			ResultSet results=statement.executeQuery();
			while(results.next())
			{
				courseList.add(new Course(results.getString("courseCode")));
			}
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("Registered courses fetched successfully");
			} else {
				System.out.println("Failed to fetch registered courses.");
			}
		}
		catch(SQLException e)
		{
//			logger.error(e.getMessage());
		}
		finally
		{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return courseList;
	}
	
	public List<RegisteredCourse> viewReportCard(int userID){
		Connection connection=DBUtils.getConnection();
		List<RegisteredCourse> courseList2=new ArrayList<RegisteredCourse>();
		try {
			PreparedStatement statement = connection.prepareStatement("Select * from GradeCard where userID = ?");
			statement.setInt(1, userID);
			ResultSet rs=statement.executeQuery();
			
			while(rs.next())
			{
				courseList2.add(new RegisteredCourse(rs.getString(1), rs.getString(3)));
			}
			System.out.println(courseList2.size());
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("Report card fetched successfully");
			} else {
				System.out.println("Failed to fetch report card.");
			}
		}
		catch(SQLException e)
		{
//			logger.error(e.getMessage());
		}
		finally
		{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return courseList2;
	}

}
