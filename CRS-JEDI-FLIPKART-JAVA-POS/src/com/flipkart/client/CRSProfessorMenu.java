/**
 * 
 */
package com.flipkart.client;
import com.flipkart.business.ProfessorBusiness;
import java.util.*;

/**
 * 
 */
public class CRSProfessorMenu {
	public void createMenu() {
		Scanner in = new Scanner(System.in);
		boolean loggedin = true;
		int input;
		ProfessorBusiness prof = new ProfessorBusiness();
		while (loggedin) {
			System.out.println("----------CRS Professor Menu--------");

			System.out.println("1. Sign Up for the Course");
			System.out.println("2. View Enrolled Students");
			System.out.println("3. Record Grades");
			System.out.println("4. Logout");
			System.out.println("--------------------------------");
			System.out.printf("Choose From Menu: ");

			input = in.nextInt();
			switch (input) {
			case 1:
				prof.signUpCourses();
				break;
			case 2:
				prof.viewEnrolledStudents();
				break;
			case 3:
				prof.addGrade();
				break;
			case 4:
				loggedin = false;
				System.out.println("Logging out");
				return;
			default:
				System.out.println("Please select appropriate option...");
			}
		}
		in.close();
	}

}
