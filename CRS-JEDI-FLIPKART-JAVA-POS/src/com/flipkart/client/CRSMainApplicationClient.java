package com.flipkart.client;
import com.flipkart.business.UserBusiness;
import com.flipkart.business.UserInterface;
import java.util.Scanner;

public class CRSMainApplicationClient {
    public static void main(String[] args) {
        System.out.println("Welcome to the CRS Application");
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
            	System.out.println("User name:--");
                String username1 = scanner.next();
            	user.Register(username1);
                break;
                
            case 3:
            	System.out.println("User name:--");
                String username2 = scanner.next();
            	user.ChangePassword(username2);
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

