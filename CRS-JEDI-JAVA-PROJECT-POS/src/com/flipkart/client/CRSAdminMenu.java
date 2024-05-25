package com.flipkart.client;
import com.flipkart.business.AdminInterface;
import com.flipkart.exception.UserNotApprovedException;
import com.flipkart.bean.Course;
import com.flipkart.business.AdminBusiness;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class CRSAdminMenu {
	
	public void admin() throws UserNotApprovedException {
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		while (choice != 9) {
			System.out.println("<-- Enter the number of the operation you intend to do -->");
			System.out.println("1. Register User");
			System.out.println("2. Modify Course Details");
			System.out.println("3. Create Catalog");
			System.out.println("4. Notify Billing Department");
			System.out.println("5. Add Course");
			System.out.println("6. Remove Course");
			System.out.println("7. Enable Add Drop");
			System.out.println("8. Disable Add Drop");
			System.out.println("9. Logout");


			choice = sc.nextInt();
			AdminInterface admin = new AdminBusiness();

			switch (choice) {
				case 1:
					System.out.println("Enter User ID");
					int userID = sc.nextInt();
					admin.registerUser(userID);
					break;
				case 2:
					String courseId = sc.next();
					int userId = sc.nextInt();
					String description = sc.next();
					admin.modifyCourseDetails(courseId, userId, description);
					break;
				case 3:
					System.out.println("Input Course ID: ");
					String courseID1 = sc.next();
					System.out.println("Input Professor User ID: ");
					int userID1 = sc.nextInt();
					System.out.println("Description: ");
					String description1 = sc.next();
					admin.createCatalog(courseID1, userID1, description1);
//					for (Course course : catalog) {
//					    System.out.println("Course Code: " + course.getCourseCode());
//					    System.out.println("User ID: " + course.getUserID());
//					    System.out.println("Description: " + course.getCourseDescription());
//					    System.out.println("------------------------");
//					}
					break;
				case 4:
					System.out.println("Amount to pay: ");
					String description2 = sc.next();
					System.out.println("Enter User ID: ");
					int userID2 = sc.nextInt();
					admin.notifyBillingDepartment(description2, userID2);
					break;
//				case 5:
//					String description1 = sc.next();
//					int userID1 = sc.nextInt();
//					admin.notifyStudents(description1, userID1);
//					break;
				case 5:
					admin.addCourse();
					break;
				case 6:
					admin.removeCourse();
					break;
				case 7:
					admin.enableAddDrop();
					System.out.println("Add drop enabled");
					break;
				case 8:
					admin.disableAddDrop();
					System.out.println("Add drop disabled");
					break;
				case 9:
					System.out.println("Logged Out");
	                return;
				default:
					System.out.println("Invalid choice. Please try again.");
			}
		}

		sc.close();
	}
	
}
