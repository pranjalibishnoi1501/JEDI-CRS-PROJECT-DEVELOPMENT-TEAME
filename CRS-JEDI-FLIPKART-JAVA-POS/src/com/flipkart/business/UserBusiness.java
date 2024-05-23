/**
 * 
 */
package com.flipkart.business;

import com.flipkart.client.CRSAdminMenu;
import com.flipkart.client.CRSProfessorMenu;
import com.flipkart.client.CRSStudentMenu;

/**
 * 
 */
public class UserBusiness implements UserInterface {

	public void Login(String role) {

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
	}
	
	public void Register(String username){
		 System.out.println("User name:--");
         // Registration logic
	}
	
	public void ChangePassword(String username) {
		System.out.println("User name:--");
        // Change Password logic
		
	}
	
	public void Exit() {
		
	}

}
