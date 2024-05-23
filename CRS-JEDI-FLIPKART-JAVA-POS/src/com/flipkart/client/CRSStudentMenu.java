package com.flipkart.client;
import com.flipkart.business.StudentBusiness;
import java.util.*;
public class CRSStudentMenu {

	public void CreateStudentMenu(int userID) {
	    Scanner input = new Scanner(System.in);
	    int choice=0;

        while(choice!=8) {
	        System.out.println("<-- Enter the number of the operation you intend to do -->");
	        System.out.println("1. View Course Registration");
	        System.out.println("2. Add Course");
	        System.out.println("3. Drop Course");
	        System.out.println("4. View Report Card");
	        System.out.println("5. Pay Fees");
	        System.out.println("6. View Registered Course");
	        System.out.println("7. View Course Catalog");
	        System.out.println("8. Exit");

	        choice = input.nextInt();
			StudentBusiness stud = new StudentBusiness();

	        switch (choice) {
	            case 1:
	                stud.registerCourse();
	                break;
	            case 2:
	                System.out.println("Enter Course ID to add:");
	                int addCourseId = input.nextInt();
	                stud.addCourse(addCourseId);
	                break;
	            case 3:
	                System.out.println("Enter Course ID to drop:");
	                int dropCourseId = input.nextInt();
	                stud.dropCourse(dropCourseId);
	                break;
	            case 4:
	                stud.viewReportCard();
	                break;
	            case 5:
	                stud.payFees(userID);
	                break;
	            case 6:
	                stud.viewRegisteredCourse();
	                break;
	            case 7:
	                stud.viewCourseCatalog();
	                break;
	            case 8:
	                System.out.println("Exiting...");
	                break;
	            default:
	                System.out.println("Invalid choice. Please try again.");
	        }
	    } 

	    input.close();
	}
}
