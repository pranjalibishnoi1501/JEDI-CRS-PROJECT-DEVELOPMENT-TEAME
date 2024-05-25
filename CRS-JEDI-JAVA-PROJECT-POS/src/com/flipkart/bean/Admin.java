/**
 * 
 */
package com.flipkart.bean;

/**
 * 
 */
public class Admin extends User{
	private static int addDropStatus = 1;

	public static int getAddDropStatus() {
		return addDropStatus;
	}

	public static void setAddDropStatus(int addDropStatus) {
		Admin.addDropStatus = addDropStatus;
	}
}
