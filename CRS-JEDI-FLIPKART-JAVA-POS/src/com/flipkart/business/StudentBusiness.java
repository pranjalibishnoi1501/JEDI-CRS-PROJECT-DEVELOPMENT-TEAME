/**
 * 
 */
package com.flipkart.business;

/**
 * 
 */
public class StudentBusiness implements StudentInterface {
	public void registerCourse() {
	    System.out.println("Registering course for student ");
	}

	public void addCourse( int courseId) {
	    System.out.println("Adding course for student");
	}

	public void dropCourse(int courseId) {
	    
	    System.out.println("Dropping course for student  " );
	}

	public void viewReportCard() {
	    System.out.println("Viewing report card for student ");
	}

	public void payFees() {
	    System.out.println("Paying fees for student ID ");
	}

	public void viewRegisteredCourse() {
	    System.out.println("Viewing registered courses for student ID ");
	}

	public void viewCourseCatalog() {
	    System.out.println("Viewing course catalog for student ");
	}
}
