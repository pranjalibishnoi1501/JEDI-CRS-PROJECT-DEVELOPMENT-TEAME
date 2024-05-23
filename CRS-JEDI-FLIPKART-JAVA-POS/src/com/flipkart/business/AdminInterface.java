package com.flipkart.business;

import java.util.List;

import com.flipkart.bean.Course;

public interface AdminInterface {
	
	public void registerUser(int userID);

	public void modifyCourseDetails(String courseId, int userId, String description);

	public List<Course> createCatalog();

	public void notifyBillingDepartment(String description, int userID);

	public void allowStudentAccess();
	
	public void notifyStudents(String description, int userID);

	public void addCourse();
		
	public void removeCourse();
	
	public void allocateProfessor();

}
