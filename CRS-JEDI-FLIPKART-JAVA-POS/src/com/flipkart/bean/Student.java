/**
 * 
 */
package com.flipkart.bean;

/**
 * 
 */
public class Student extends User{
	
	private int userID;
	private boolean registrationStatus;
	private boolean isApproved;
	
	public Student(int userID) {
        this.userID = userID;
    }
	
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	public boolean isRegistrationStatus() {
		return registrationStatus;
	}
	public void setRegistrationStatus(boolean registrationStatus) {
		this.registrationStatus = registrationStatus;
	}
	public boolean isApproved() {
		return isApproved;
	}
	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}

}
