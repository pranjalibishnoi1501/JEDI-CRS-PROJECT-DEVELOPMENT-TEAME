/**
 * 
 */
package com.flipkart.business;
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

	public void allowStudentAccess() {
		System.out.println("Allowing student access...");
	}

	public void notifyStudents(String description, int userID) {
		ad.notifyStudents(description, userID);
	}

	public void addCourse() {
		ad.addCourse();
	}
		
	public void removeCourse() {
		ad.removeCourse();
	}
	
	public void allocateProfessor() {
		System.out.println("Allocating Professor...");
	}

}
