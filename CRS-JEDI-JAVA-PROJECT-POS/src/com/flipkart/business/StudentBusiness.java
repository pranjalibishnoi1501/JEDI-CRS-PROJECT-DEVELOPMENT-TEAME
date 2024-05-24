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
	AdminBusiness admin = new AdminBusiness();
	public void addCourse(int userID, String courseCode) {
		if(admin.enableAddDrop == true) {
			stud.addCourse(userID, courseCode);
		}
		else {
			System.out.println("Error");
		}
	}

	public void dropCourse(int userID, String courseCode) {
		if(admin.enableAddDrop == true) {
			stud.dropCourse(userID, courseCode);
		}
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
	
	public List<String>viewNotification(int userID){
		return stud.viewNotification(userID);
	}
}
