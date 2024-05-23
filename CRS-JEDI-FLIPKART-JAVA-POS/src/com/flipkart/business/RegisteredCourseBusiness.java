/**
 * 
 */
package com.flipkart.business;
import com.flipkart.dao.*;

/**
 * 
 */
public class RegisteredCourseBusiness implements RegisteredCourseInterface{
	RegisteredCourseDAOInterface addDropCourse = new RegisteredCourseDAOImpl();
	public void dropCourseByAdmin(int userID, String courseCode) {
		addDropCourse.dropCourseByAdmin(userID);
		
	}
	
	public void addCourseByAdmin(int userID, String courseCode) {
		addDropCourse.addCourseByAdmin(userID);
			
	}

}
