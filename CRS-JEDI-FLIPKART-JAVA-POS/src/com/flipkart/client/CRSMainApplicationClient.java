package com.flipkart.client;

import java.util.Scanner;

public class CRSMainApplicationClient {
    public static void main(String[] args) {
        System.out.println("Welcome to the CRS Application");
        System.out.println("Enter the Choice :-->");
        System.out.println("1. Login");
        System.out.println("2. Registration of the student");
        System.out.println("3. Change Password");
        System.out.println("4. Exit");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt(); 
        switch (choice) {
            case 1:
                System.out.println("User name:--");
                String username = scanner.next();
                System.out.println("Password:--");
                String password = scanner.next();
                System.out.println("Role:-- Admin/Student/Professor");
                String role = scanner.next();
                
                if (role.equals("Admin")) {
                	CRSAdminMenu adminMenu = new CRSAdminMenu();
                    adminMenu.admin();
                } else if (role.equals("Student")) {
                	CRSStudentMenu studentMenu = new CRSStudentMenu();
                    studentMenu.CreateStudentMenu();
                } else if (role.equals("Professor")) {
                	CRSProfessorMenu professorMenu = new CRSProfessorMenu();
                    professorMenu.createMenu();
                } else {
                    System.out.println("Invalid Role");
                }
                break;
                
            case 2:
                System.out.println("User name:--");
                // Registration logic
                break;
                
            case 3:
                System.out.println("User name:--");
                // Change Password logic
                break;
                
            case 4:
                System.out.println("Exiting...");
                break;
                
            default:
                System.out.println("Invalid Choice");
        }
        
        scanner.close();
    }
}

