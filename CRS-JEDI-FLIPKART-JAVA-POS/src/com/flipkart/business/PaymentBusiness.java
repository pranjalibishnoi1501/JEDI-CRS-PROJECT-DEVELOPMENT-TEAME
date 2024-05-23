/**
 * 
 */
package com.flipkart.business;
import com.flipkart.dao.*;

/**
 * 
 */
public class PaymentBusiness implements PaymentInterface{
	PaymentDAOInterface paymentDAO = new PaymentDAOImpl();
	
	public void makePayment(int userID) {
		paymentDAO.makePayment(userID);
	}
}
