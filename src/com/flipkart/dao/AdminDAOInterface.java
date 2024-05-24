package com.flipkart.dao;

import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.exception.UserNotApprovedException;

public interface AdminDAOInterface {
//	public void registerUser(int userId);
	public void registerUser(int userId) throws UserNotApprovedException ;
	public void modifyCourseDetails(String courseId, int userId, String description);
	public List<String[]> addCourse();
	public List<String[]> removeCourse();
	public List<Course> createCatalog();
	public void notifyStudents(String description, int userID);
	public void notifyBillingDepartment(String description, int userID);
	public int checkSeatsAvailability(String courseCode);
	public void updateSeats(String courseCode, int numStudents, int userID, String type);
}
