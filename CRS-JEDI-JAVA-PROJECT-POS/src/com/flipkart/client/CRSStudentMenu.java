package com.flipkart.client;
import com.flipkart.bean.Course;
import com.flipkart.bean.RegisteredCourse;
import com.flipkart.business.StudentBusiness;
import java.util.*;
public class CRSStudentMenu {

	public void CreateStudentMenu(int userID) {
	    Scanner input = new Scanner(System.in);
	    int choice=0;

        while(choice!=8) {
	        System.out.println("<-- Enter the number of the operation you intend to do -->");
	        System.out.println("1. Add Course");
	        System.out.println("2. Drop Course");
	        System.out.println("3. View Report Card");
	        System.out.println("4. Pay Fees");
	        System.out.println("5. View Registered Course");
	        System.out.println("6. View Course Catalog");
	        System.out.println("7. View Notification");
	        System.out.println("8. Logout");

	        choice = input.nextInt();
			StudentBusiness stud = new StudentBusiness();

	        switch (choice) {
	            case 1:
	                System.out.println("Enter Course ID to add:");
	                String addCourseId = input.next();
	                stud.addCourse(userID, addCourseId);
	                break;
	            case 2:
	                System.out.println("Enter Course ID to drop:");
	                String dropCourseId = input.next();
	                stud.dropCourse(userID, dropCourseId);
	                break;
	            case 3:
	            	List<RegisteredCourse> courseList2 = stud.viewReportCard(userID);
	            	System.out.println("User ID: " + userID);
	            	for (RegisteredCourse course : courseList2) {
					    System.out.println("Course Code: " + course.getCourseCode());
					    System.out.println("Grade: " + course.getGrade());
					    System.out.println();
					}
	                break;
	            case 4:
	                stud.payFees(userID);
	                break;
	            case 5:
	            	List<Course> courseList = stud.viewRegisteredCourse(userID);
	                for (Course course : courseList) {
					    System.out.println("Course Code: " + course.getCourseCode());
					    System.out.println();
					}
	                break;
	            case 6:
	                List<Course> courseList1 = stud.viewCourseCatalog();
	                for (Course course : courseList1) {
					    System.out.println("Course Code: " + course.getCourseCode());
					    System.out.println("User ID: " + course.getUserID());
					    System.out.println("Course Description: " + course.getCourseDescription());
					    System.out.println();
					}
	                break;
	            case 7:
	            	List<String> notification = stud.viewNotification(userID);
	            	for(String noti: notification) {
	            		System.out.println(noti);
	            	}
	            	break;
	            case 8:
	                System.out.println("Logged Out");
	                return;
	            default:
	                System.out.println("Invalid choice. Please try again.");
	        }
	    } 

	    input.close();
	}
}
