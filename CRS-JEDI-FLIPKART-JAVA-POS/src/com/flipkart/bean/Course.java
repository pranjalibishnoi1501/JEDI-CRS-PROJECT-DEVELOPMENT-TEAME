/**
 * 
 */
package com.flipkart.bean;
import java.util.ArrayList;

/**
 * 
 */
public class Course {
	private String courseCode;
	private String courseName;
	private String professor;
	private int availableSeats = 10;
	private ArrayList<Student>studentsTaking;
	private ArrayList<Course>prerequisites;
	
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getProfessor() {
		return professor;
	}
	public void setProfessor(String professor) {
		this.professor = professor;
	}
	public int getSeats() {
		return availableSeats;
	}
	public void setSeats(int seats) {
		this.availableSeats = seats;
	}
	public ArrayList<Student> getStudentsTaking() {
		return studentsTaking;
	}
	public void setStudentsTaking(ArrayList<Student> studentsTaking) {
		this.studentsTaking = studentsTaking;
	}
	public ArrayList<Course> getPrerequisites() {
		return prerequisites;
	}
	public void setPrerequisites(ArrayList<Course> prerequisites) {
		this.prerequisites = prerequisites;
	}

}
