package com.flipkart.exception;

/**
 * Exception to check if user is approved by administration
 * @author JEDI-03
 *
 */
public class UserNotApprovedException extends Exception{
	private static final long serialVersionUID = 1L;
	private int userId;
	
	/**
	 * Constructor
	 * @param userId
	 */
	public UserNotApprovedException(int userId) {
		this.userId = userId;
	}

	/**
	 * Getter for userId
	 * @return
	 */
	public int getUserId() {
		return userId;
	}

}
