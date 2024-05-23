package com.flipkart.dao;

public interface UserDAOInterface {
	public void Login(int userID, String name, String password, String role);
	public void Register(String username, String password, String role);
	public void ChangePassword(int userID, String password);
	public void Exit();
}
