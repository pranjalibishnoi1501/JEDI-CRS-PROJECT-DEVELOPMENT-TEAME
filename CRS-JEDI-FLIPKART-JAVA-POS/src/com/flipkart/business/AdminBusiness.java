/**
 * 
 */
package com.flipkart.business;
import java.util.ArrayList;

import java.util.List;

import com.flipkart.bean.*;
import com.flipkart.dao.*;
/**
 * 
 */
public class AdminBusiness implements AdminInterface{
	
	AdminDAOInterface ad = new AdminDAOImpl();
	
	public void registerUser(int userID) {
		ad.registerUser(userID);
	}

	public void modifyCourseDetails(String courseId, int userId, String description) {
		ad.modifyCourseDetails(courseId, userId, description);
	}

	public List<Course> createCatalog() {
		return ad.createCatalog();
	}

	public void notifyBillingDepartment(String description, int userID) {
		ad.notifyBillingDepartment(description, userID);
	}

	public void notifyStudents(String description, int userID) {
		ad.notifyStudents(description, userID);
	}

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
			System.out.println("nymStudents");
			if (type == "add" && numStudents < 10) {
				System.out.println("Seat added successfully for course: " + courseCode);
				numStudents++;
				ad.updateSeats(courseCode, numStudents);
			} else if (type == "drop" && numStudents > 3) {
				System.out.println("Seat dropped successfully for course: " + courseCode);
				numStudents--;
				ad.updateSeats(courseCode, numStudents);
			} else {
				System.out.println("No action taken for course: " + courseCode);
			}

		}
	}
		
	public void removeCourse() {
		ad.removeCourse();
	}
	
	public void allocateProfessor() {
		System.out.println("Allocating Professor...");
	}

}
