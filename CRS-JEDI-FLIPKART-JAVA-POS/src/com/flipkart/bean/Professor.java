/**
 * 
 */
package com.flipkart.bean;

/**
 * 
 */
public class Professor extends User {
	private boolean isApproved;
	private String department;
	public boolean isApproved() {
		return isApproved;
	}
	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
}
