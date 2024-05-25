/**
 * 
 */
package com.flipkart.business;
import java.util.ArrayList;

import java.util.List;

import com.flipkart.bean.*;
import com.flipkart.dao.*;
import com.flipkart.exception.UserNotApprovedException;
/**
 * 
 */

/**
 * This package contains the business logic related to admin operations.
 */
public class AdminBusiness implements AdminInterface{
	
	// Variable to control the availability of Add/Drop functionality
	
	static boolean enableAddDrop =true;
	
	// Instance of AdminDAOInterface for database operations
	
	AdminDAOInterface ad = new AdminDAOImpl();
	
	/**
	 * Enable Add/Drop functionality.
	 */
	
	public void enableAddDrop() {
		enableAddDrop = true;
	}
	
	/**
	 * Disable Add/Drop functionality.
	 */
	
	public void disableAddDrop() {
		enableAddDrop = false;
	}
	
	/**
	 * Register a user.
	 * @param userID ID of the user to be registered.
	 * @throws UserNotApprovedException if user registration is not approved.
	 */
	
	public void registerUser(int userID) throws UserNotApprovedException {
		ad.registerUser(userID);
	}
	
	/**
	 * Modify course details.
	 * @param courseId ID of the course to be modified.
	 * @param userId ID of the user performing the modification.
	 * @param description New description of the course.
	 */

	public void modifyCourseDetails(String courseId, int userId, String description) {
		ad.modifyCourseDetails(courseId, userId, description);
	}
	
	/**
	 * Create catalog of courses.
	 * @return List of courses in the catalog.
	 */

	public void createCatalog(String courseID, int userID, String description) {
		ad.createCatalog(courseID, userID, description);
	}
	
	/**
	 * Notify billing department.
	 * @param description Description of the notification.
	 * @param userID ID of the user for notification.
	 */

	public void notifyBillingDepartment(String description, int userID) {
		ad.notifyBillingDepartment(description, userID);
	}
	
	/**
	 * Notify students.
	 * @param description Description of the notification.
	 * @param userID ID of the user for notification.
	 */

	public void notifyStudents(String description, int userID) {
		ad.notifyStudents(description, userID);
	}
	
	/**
	 * Add a course.
	 */

	public void addCourse() {
		List<String[]> courses = ad.addCourse();
		for (String[] course : courses) {
			int userID = Integer.parseInt(course[0]);
			String courseCode = course[1];
			String type = course[2];
			System.out.println("UserID: " + userID);
			System.out.println("CourseCode: " + courseCode);
			System.out.println("Type: " + type);
			int numStudents = ad.checkSeatsAvailability(courseCode);
			System.out.println(numStudents);
			System.out.println(type);
			if (type.equals("add") && numStudents < 10) {
				System.out.println("Seat added successfully for course: " + courseCode);
				numStudents++;
				ad.updateSeats(courseCode, numStudents, userID, type);
			} else if (type.equals("drop") && numStudents > 3) {
				System.out.println("Seat dropped successfully for course: " + courseCode);
				numStudents--;
				ad.updateSeats(courseCode, numStudents, userID, type);
			} else {
				System.out.println("No action taken for course: " + courseCode);
			}

		}
	}
	
	/**
	 * Remove a course.
	 */
		
	public void removeCourse() {
		List<String[]> courses = ad.removeCourse();
		for (String[] course : courses) {
			int userID = Integer.parseInt(course[0]);
			String courseCode = course[1];
			String type = course[2];
			System.out.println("UserID: " + userID);
			System.out.println("CourseCode: " + courseCode);
			System.out.println("Type: " + type);
			int numStudents = ad.checkSeatsAvailability(courseCode);
			System.out.println(numStudents);
			System.out.println(type);
			if (type.equals("add") && numStudents < 10) {
				System.out.println("Seat added successfully for course: " + courseCode);
				numStudents++;
				ad.updateSeats(courseCode, numStudents,userID, type);
			} else if (type.equals("drop") && numStudents > 3) {
				System.out.println("Seat dropped successfully for course: " + courseCode);
				numStudents--;
				ad.updateSeats(courseCode, numStudents,userID, type);
			} else {
				System.out.println("No action taken for course: " + courseCode);
			}

		}
	}
	
	/**
	 * Allocate professor for a course.
	 */
	
	public void allocateProfessor() {
		System.out.println("Allocating Professor...");
	}

}
