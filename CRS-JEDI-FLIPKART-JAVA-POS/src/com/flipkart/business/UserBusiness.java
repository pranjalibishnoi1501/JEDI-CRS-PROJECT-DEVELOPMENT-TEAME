/**
 * 
 */
package com.flipkart.business;

import com.flipkart.client.CRSAdminMenu;
import com.flipkart.client.CRSProfessorMenu;
import com.flipkart.client.CRSStudentMenu;
import com.flipkart.dao.*;

/**
 * 
 */
public class UserBusiness implements UserInterface {
	
	UserDAOInterface user = new UserDAOImpl();

	public void Login(int userID, String name, String password, String role) {

		if (role.equals("Admin")) {
			CRSAdminMenu adminMenu = new CRSAdminMenu();
			adminMenu.admin();
		} else if (role.equals("Student")) {
			CRSStudentMenu studentMenu = new CRSStudentMenu();
			studentMenu.CreateStudentMenu(userID);
		} else if (role.equals("Professor")) {
			CRSProfessorMenu professorMenu = new CRSProfessorMenu();
			professorMenu.createMenu(userID);
		} else {
			System.out.println("Invalid Role");
		}
	}
	
	public void Register(String username, String password, String role){
		 user.Register(username, password, role);
	}
	
	public void ChangePassword(int userID, String password){
		user.ChangePassword(userID, password);
		
	}
	
	public void Exit() {
		System.out.println("Exiting...");
	}

}
