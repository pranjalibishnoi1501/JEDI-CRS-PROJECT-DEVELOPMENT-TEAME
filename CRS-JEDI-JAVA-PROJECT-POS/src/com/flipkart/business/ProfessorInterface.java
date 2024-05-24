package com.flipkart.business;

import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;

public interface ProfessorInterface {
	public  List<Course> teachingCourses(int userID);

	public List<Student> viewEnrolledStudents(int userID, String courseCode);

	public void addGrade(int userID, String courseCode, int studID, String grade);

}
