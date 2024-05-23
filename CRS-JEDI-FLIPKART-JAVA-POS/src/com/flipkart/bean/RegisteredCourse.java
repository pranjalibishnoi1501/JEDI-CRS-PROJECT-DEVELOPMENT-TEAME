///**
// * 
// */
package com.flipkart.bean;
//
///**
// * 
// */
//public class RegisteredCourse extends Course{
//	private int rollNumber;
//	private String grade;
//	private boolean priority;
//	
//	public int getRollNumber() {
//		return rollNumber;
//	}
//	public void setRollNumber(int rollNumber) {
//		this.rollNumber = rollNumber;
//	}
//	public String getGrade() {
//		return grade;
//	}
//	public void setGrade(String grade) {
//		this.grade = grade;
//	}
//	public boolean isPriority() {
//		return priority;
//	}
//	public void setPriority(boolean priority) {
//		this.priority = priority;
//	}
//
//}
public class RegisteredCourse extends Course {
    private String grade;
    
    
    // Constructor
    public RegisteredCourse(String grade, String courseCode, int userID, String courseDescription) {
        super(courseCode, userID, courseDescription);
        this.grade = grade;
    }
    
    public RegisteredCourse(String grade, String courseCode) {
    	super(courseCode);
    	this.grade=grade;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}

