package com.flipkart.client;
import com.flipkart.business.AdminInterface;
import com.flipkart.bean.Course;
import com.flipkart.business.AdminBusiness;

import java.util.List;
import java.util.Scanner;

public class CRSAdminMenu {
	
	public void admin() {
		Scanner sc = new Scanner(System.in);
		int choice = 0;

		while (choice != 10) {
			System.out.println("<-- Enter the number of the operation you intend to do -->");
			System.out.println("1. Register User");
			System.out.println("2. Modify Course Details");
			System.out.println("3. Create Catalog");
			System.out.println("4. Notify Billing Department");
			System.out.println("5. Allow Student Access");
			System.out.println("6. Enable Add/Drop");
			System.out.println("7. Notify Students");
			System.out.println("8. Add Course");
			System.out.println("9. Remove Course");
			System.out.println("10.Allocate Professor");

			choice = sc.nextInt();
			AdminInterface admin = new AdminBusiness();

			switch (choice) {
				case 1:
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
					List<Course> catalog = admin.createCatalog();
					break;
				case 4:
					String description2 = sc.next();
					int userID2 = sc.nextInt();
					admin.notifyBillingDepartment(description2, userID2);
					break;
				case 5:
					admin.allowStudentAccess();
					break;
				case 6:
//					System.out.println("Choose 1 or 2");
//					System.out.println("1. To enable add/drop");
//					System.out.println("2. To disable ad/drop");
//					int a = sc.nextInt();
//					admin.enableAddDrop(a);
//					break;
				case 7:
					String description1 = sc.next();
					int userID1 = sc.nextInt();
					admin.notifyStudents(description1, userID1);
					break;
				case 8:
					admin.addCourse();
					break;
				case 9:
					admin.removeCourse();
					break;
				case 10:
					admin.allocateProfessor();
				default:
					System.out.println("Invalid choice. Please try again.");
			}
		}

		sc.close();
	}
	
}
