package com.flipkart.dao;

import java.util.List;

public interface UserDAOInterface {
	public boolean Login(int userID, String name, String password, String role);
	public void Register(String username, String password, String role);
	public void ChangePassword(int userID, String password);
	public void Exit();
}
