package com.flipkart.dao;

import java.util.List;

import com.flipkart.bean.Course;

public interface AdminDAOInterface {
	public void registerUser(int userId);
	public void modifyCourseDetails(String courseId, int userId, String description);
	public List<String[]> addCourse();
	public void removeCourse();
	public List<Course> createCatalog();
	public void notifyStudents(String description, int userID);
	public void notifyBillingDepartment(String description, int userID);
	public int checkSeatsAvailability(String courseCode);
	public void updateSeats(String courseCode, int numStudents);
}
