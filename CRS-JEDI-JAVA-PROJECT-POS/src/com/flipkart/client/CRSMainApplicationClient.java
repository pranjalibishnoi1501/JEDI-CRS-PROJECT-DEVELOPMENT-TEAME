package com.flipkart.client;
import com.flipkart.business.UserBusiness;
import com.flipkart.business.UserInterface;
import com.flipkart.exception.UserNotApprovedException;

import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CRSMainApplicationClient {
    public static void main(String[] args) throws UserNotApprovedException {
        System.out.println("Welcome to the CRS Application");
        LocalDateTime currentDateTime = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);

        System.out.println("Current Date and Time: " + formattedDateTime);
        System.out.println("Enter the Choice :-->");
        System.out.println("1. Login");
        System.out.println("2. Registration of the student");
        System.out.println("3. Change Password");
        System.out.println("4. Exit");
        UserInterface user = new UserBusiness();
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt(); 
        switch (choice) {
            case 1:
                System.out.println("User ID:--");
                int userID = scanner.nextInt();
                System.out.println("User Name:--");
                String name = scanner.next();
                System.out.println("Password:--");
                String password = scanner.next();
                System.out.println("Role:-- Admin/Student/Professor");
                String role = scanner.next();
                user.Login(userID, name, password, role);
                break;
                
            case 2:
            	System.out.println("User Name:--");
                String username1 = scanner.next();
                System.out.println("Password");
                String password1 = scanner.next();
                System.out.println("Role");
                String role1 = scanner.next();
            	user.Register(username1, password1, role1);
                break;
                
            case 3:
            	System.out.println("User ID:--");
                int userID1 = scanner.nextInt();
                System.out.println("Password");
                String password2 = scanner.next();
            	user.ChangePassword(userID1,password2);
                break;
                
            case 4:
                user.Exit();
                break;
                
//            default:
//                System.out.println("Invalid Choice");
        }
        
        scanner.close();
    }
}

