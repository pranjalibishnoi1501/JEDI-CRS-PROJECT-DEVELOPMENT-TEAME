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
    private int rollNumber;
    private String grade;
    private boolean priority;
    
    // Constructor
    public RegisteredCourse(String courseCode, int userID, String courseDescription, int rollNumber, String grade, boolean priority) {
        super(courseCode, userID, courseDescription);
        this.rollNumber = rollNumber;
        this.grade = grade;
        this.priority = priority;
    }

    // Getters and setters
    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public boolean isPriority() {
        return priority;
    }

    public void setPriority(boolean priority) {
        this.priority = priority;
    }
}
