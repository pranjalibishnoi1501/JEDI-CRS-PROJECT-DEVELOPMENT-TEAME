/**
 * 
 */
package com.flipkart.bean;
//import java.util.ArrayList;

/**
 * 
 */
public class Course {
	private String courseCode;
	private int userID;
	private String courseDescription;
	private int numStudents;
	
	public Course(String courseCode, int userID, String courseDescription) {
        this.courseCode = courseCode;
        this.userID = userID;
        this.courseDescription = courseDescription;
    }
	
	public Course(String courseCode) {
        this.courseCode = courseCode;
    }

	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getCourseDescription() {
		return courseDescription;
	}
	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}	
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public int getNumStudents() {
		return numStudents;
	}

	public void setNumStudents(int numStudents) {
		this.numStudents = numStudents;
	}
	

}
