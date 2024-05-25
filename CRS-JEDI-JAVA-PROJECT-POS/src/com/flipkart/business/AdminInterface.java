package com.flipkart.business;

import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.exception.UserNotApprovedException;

/**
 * Interface defining methods for admin operations.
 */

public interface AdminInterface {
	
	/**
	 * Register a user.
	 * @param userId ID of the user to be registered.
	 * @throws UserNotApprovedException if user registration is not approved.
	 */

	public void registerUser(int userId) throws UserNotApprovedException;
	
	/**
	 * Modify course details.
	 * @param courseId ID of the course to be modified.
	 * @param userId ID of the user performing the modification.
	 * @param description New description of the course.
	 */

	public void modifyCourseDetails(String courseId, int userId, String description);
	

	/**
	 * Create catalog of courses.
	 * @return List of courses in the catalog.
	 */

	public void createCatalog(String courseID, int userID, String description);
	

	/**
	 * Notify billing department.
	 * @param description Description of the notification.
	 * @param userID ID of the user for notification.
	 */

	public void notifyBillingDepartment(String description, int userID);
	
	/**
	 * Notify students.
	 * @param description Description of the notification.
	 * @param userID ID of the user for notification.
	 */
	
	public void notifyStudents(String description, int userID);
	

	/**
	 * Add a course.
	 */

	public void addCourse();
	
	
	/**
	 * Remove a course.
	 */
		
	public void removeCourse();
	
	/**
	 * Allocate professor for a course.
	 */
	
	public void allocateProfessor();
	
	/**
	 * Enable Add/Drop functionality.
	 */

	public void enableAddDrop();
	
	/**
	 * Disable Add/Drop functionality.
	 */

	public void disableAddDrop();

}
