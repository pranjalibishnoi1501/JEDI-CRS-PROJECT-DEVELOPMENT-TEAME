package com.flipkart.dao;

//import com.flipkart.utils.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.flipkart.utils.*;
import com.flipkart.bean.Course;
import com.flipkart.bean.Student;

public class ProfessorDAOImpl implements ProfessorDAOInterface {
	public List<Course> teachingCourses(int userID) {
		Connection connection=DBUtils.getConnection();
		List<Course> courseList=new ArrayList<Course>();
		try {
			PreparedStatement statement = connection.prepareStatement("select * from course where userID=?");
			
			statement.setLong(1, userID);
			
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
	
	////////////////////////////////////
	
	public List<Student> viewEnrolledStudents(int userID, String courseCode) {
		List<Course> courseList = teachingCourses(userID);
		int flag = 1;
		for (Course course : courseList) {
		    if(course.getCourseCode() == courseCode) {
		    	flag = 0;
		    	break;
		    }
		}
		if(flag == 1)
		{
			// TODO Throw Exception
		}
		Connection connection=DBUtils.getConnection();
		List<Student> studentList=new ArrayList<Student>();
		try {
			PreparedStatement statement = connection.prepareStatement("Select * from GradeCard where courseCode=?");
			
			statement.setString(1, courseCode);
			
			ResultSet results=statement.executeQuery();
			while(results.next())
			{
				studentList.add(new Student(results.getInt("userID")));
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
		return studentList;
	}
	
	
	/////////////////////////////////////////
	
	public void addGrade(int userID, String courseCode, int studID, String grade) {
		List<Student> studentList1 = viewEnrolledStudents(userID, courseCode);
		int flag = 1;
		for (Student student : studentList1) {
		    if(student.getUserID() == studID) {
		    	flag = 0;
		    	break;
		    }
		}
		if(flag == 1) {
			// TODO Throw Exception
		}
		Connection connection=DBUtils.getConnection();
		List<Student> studentList=new ArrayList<Student>();
		try {
			PreparedStatement statement = connection.prepareStatement("update GradeCard set grade=? where courseCode=? and userID=?");
			statement.setString(1, grade);
			statement.setString(2, courseCode);
			statement.setInt(3, studID);
			
			int rowsUpdated = statement.executeUpdate();
	        if (rowsUpdated > 0) {
	            System.out.println("Grade updated successfully.");
	        } else {
	            System.out.println("Failed to update grade.");
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
		
		
	}

}
