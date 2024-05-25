/**
 * 
 */
package com.flipkart.business;
import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.dao.*;

/**
 * 
 */
public class ProfessorBusiness implements ProfessorInterface{
	ProfessorDAOInterface prof = new ProfessorDAOImpl();
	public List<Course> teachingCourses(int userID) {
		return prof.teachingCourses(userID);
	}

	public List<Student> viewEnrolledStudents(int userID, String courseCode) {
		return prof.viewEnrolledStudents(userID, courseCode);
	}

	public void addGrade(int userID, String courseCode, int studID, String grade) {
		prof.addGrade(userID, courseCode, studID, grade);

	}

}
