package com.flipkart.business;

import java.util.List;

import com.flipkart.exception.UserNotApprovedException;

public interface UserInterface {
	public void Login(int userID, String name, String password, String role) throws UserNotApprovedException;
	public void Register(String username, String password, String role);
	public void ChangePassword(int userID, String password);
	public void Exit();
}
