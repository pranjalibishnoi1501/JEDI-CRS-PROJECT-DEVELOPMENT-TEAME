package com.flipkart.dao;

import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.RegisteredCourse;

public interface StudentDAOInterface {
	public void addCourse(int userID, String courseCode);
	public void dropCourse(int userID, String courseCode);
	public List<Course> viewCourseCatalog();
	public List<Course> viewRegisteredCourse(int userID);
	public List<RegisteredCourse> viewReportCard(int userID);
}
