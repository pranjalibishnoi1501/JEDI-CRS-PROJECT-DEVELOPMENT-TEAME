package com.flipkart.dao;

import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;

public interface ProfessorDAOInterface {
	public List<Course> teachingCourses(int userID);

	public List<Student> viewEnrolledStudents(int userID, String courseCode);
	
	public void addGrade(int userID, String courseCode, int studID, String grade);

}
