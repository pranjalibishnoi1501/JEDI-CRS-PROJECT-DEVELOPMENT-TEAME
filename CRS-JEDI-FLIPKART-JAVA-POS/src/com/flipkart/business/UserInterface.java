package com.flipkart.business;


public interface UserInterface {
	public void Login(String role);
	public void Register(String username);
	public void ChangePassword(String username);
	public void Exit();
}
