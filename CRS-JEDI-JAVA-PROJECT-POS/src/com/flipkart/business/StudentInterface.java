package com.flipkart.business;

import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.RegisteredCourse;

public interface StudentInterface {
	
	public void addCourse(int userID, String courseCode);

	public void dropCourse(int userID, String courseCode);
	
	public List<RegisteredCourse> viewReportCard(int userID);

	public void payFees(int userID);

	public List<Course> viewRegisteredCourse(int userID);

	public List<Course> viewCourseCatalog();
	
	public List<String>viewNotification(int userID);

}
