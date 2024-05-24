package com.flipkart.business;

import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.exception.UserNotApprovedException;

public interface AdminInterface {

	public void registerUser(int userId) throws UserNotApprovedException;

	public void modifyCourseDetails(String courseId, int userId, String description);

	public List<Course> createCatalog();

	public void notifyBillingDepartment(String description, int userID);
	
	public void notifyStudents(String description, int userID);

	public void addCourse();
		
	public void removeCourse();
	
	public void allocateProfessor();

	public void enableAddDrop();

	public void disableAddDrop();

}
