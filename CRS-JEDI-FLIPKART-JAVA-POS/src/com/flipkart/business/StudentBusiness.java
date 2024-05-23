/**
 * 
 */
package com.flipkart.business;
import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.RegisteredCourse;
import com.flipkart.dao.*;

/**
 * 
 */
public class StudentBusiness implements StudentInterface {
	StudentDAOInterface stud = new StudentDAOImpl();

	public void addCourse(int userID, String courseCode) {
		stud.addCourse(userID, courseCode);
	}

	public void dropCourse(int userID, String courseCode) {
		stud.dropCourse(userID, courseCode);
	}

	public List<RegisteredCourse> viewReportCard(int userID) {
		 return stud.viewReportCard(userID);
	}

	public void payFees(int userID) {
	    System.out.println("Paying fees for student ID " + userID);
	    PaymentDAOInterface payment = new PaymentDAOImpl();
	    payment.makePayment(userID);
	}

	public List<Course> viewRegisteredCourse(int userID) {
	    return stud.viewRegisteredCourse(userID);
	}

	public List<Course> viewCourseCatalog() {
	    return stud.viewCourseCatalog();
	}
	
	public void checkNotifications() {
		System.out.println("Notification Received");
	}
}
