package com.flipkart.client;
import com.flipkart.business.AdminInterface;
import com.flipkart.business.AdminBusiness;
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
					admin.registerUser();
					break;
				case 2:
					admin.modifyCourseDetails();
					break;
				case 3:
					admin.createCatalog();
					break;
				case 4:
					admin.notifyBillingDepartment();
					break;
				case 5:
					admin.allowStudentAccess();
					break;
				case 6:
					admin.enableAddDrop();
					break;
				case 7:
					admin.notifyStudents();
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
