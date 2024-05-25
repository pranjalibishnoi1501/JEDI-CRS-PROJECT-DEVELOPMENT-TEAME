/**
 * 
 */
package com.flipkart.client;
import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.business.ProfessorBusiness;
import java.util.*;

/**
 * 
 */
public class CRSProfessorMenu {
	public void createMenu(int userID) {
		Scanner in = new Scanner(System.in);
		boolean loggedin = true;
		int input;
		ProfessorBusiness prof = new ProfessorBusiness();
		while (loggedin) {
			System.out.println("----------CRS Professor Menu--------");

			System.out.println("1. View Courses Teaching");
			System.out.println("2. View Enrolled Students");
			System.out.println("3. Record Grades");
			System.out.println("4. Logout");
			System.out.println("--------------------------------");
			System.out.printf("Choose From Menu: ");

			input = in.nextInt();
			switch (input) {
			case 1:
				List<Course> coursesTeaching = prof.teachingCourses(userID);
				for (Course course : coursesTeaching) {
				    System.out.println("Course Code: " + course.getCourseCode());
				    System.out.println("User ID: " + course.getUserID());
				    System.out.println("Course Description: " + course.getCourseDescription());
				    System.out.println();
				}
				break;
			case 2:
				System.out.println("Enter the Course Code");
				String courseCode = in.next();
				List<Student> studentsEnrolled = prof.viewEnrolledStudents(userID, courseCode);
				for (Student student : studentsEnrolled) {
				    System.out.println("Student Id: " + student.getUserID());
				    System.out.println();
				}
				break;
			case 3:
				System.out.println("Enter the Course Code");
				String courseID=in.next();
				System.out.println("Enter the Student ID");
				int studID=in.nextInt();
				System.out.println("Enter the Grade");
				String grade=in.next();
				prof.addGrade(userID, courseID, studID, grade);
				break;
			case 4:
				loggedin = false;
				System.out.println("Logged out");
				return;
			default:
				System.out.println("Please select appropriate option...");
			}
		}
		in.close();
	}

}
