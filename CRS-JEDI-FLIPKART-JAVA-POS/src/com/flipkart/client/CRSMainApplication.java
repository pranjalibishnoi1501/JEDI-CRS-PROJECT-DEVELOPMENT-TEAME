package client;
import java.util.Scanner;
public class CRSMainApplication {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		CRSMainApplication crsApplication=new CRSMainApplication();
		int choice;	
		//create the main menu
		createMainMenu();
		while (sc.hasNextInt()) {
		choice=sc.nextInt();

		while(choice!=4)
		{
			switch(choice)
			{	
				case 1:
					//login
					crsApplication.loginUser();
					break;
				case 2:
					//student registration
					crsApplication.register();
					break;	
				case 3:
					crsApplication.changePassword();
					break;
				default:
					System.out.println("Invalid Input");
			}
			createMainMenu();
			choice=sc.nextInt();
		 }
		}
	}
	
	public static void createMainMenu()
	{
		System.out.println("----------Welcome to Course Registration System---------");
		System.out.println("1. Login");
		System.out.println("2. Register");
		System.out.println("3. change password");
		System.out.println("4. Exit");
	}
	
	public void loginUser() {
		Scanner sc = new Scanner(System.in);
		System.out.println("logic for user login");
		
		System.out.println("Enter user name");
		String userName = sc.next();
		System.out.println("Enter password");
		String password= sc.next();
		System.out.println("Enter role (ADMIN/PROFESSOR/STUDENT)");
		String role= sc.next();
		
		switch(role) {
	    	case "ADMIN":
	    	case "PROFESSOR": CRSProfessorMenu profMenu= new CRSProfessorMenu();
			  				  profMenu.createMenu();
			  				  break;
	    	case "STUDENT":   CRSStudentMenu studentMenu= new CRSStudentMenu();
	    					  studentMenu.CreateStudentMenu();
	    					  break;
	    	default: break;
	    			
		}
		
	}
	
	public void changePassword() {
		System.out.println("logic for password change");
	}
	
	public void register() {
		System.out.println("logic for user registration");
	}
}

