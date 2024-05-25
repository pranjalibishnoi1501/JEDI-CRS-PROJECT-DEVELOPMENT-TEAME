package com.flipkart.dao;

import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
//import java.sql.Statement;
import java.util.Scanner;

import com.flipkart.utils.DBUtils;

public class PaymentDAOImpl implements PaymentDAOInterface {
	int paymentID = new Random().nextInt(900000) + 100000;;
//	   static final String DB_URL = "jdbc:mysql://localhost/CRS-Schema";
//	   static final String USER = "root";
//	   static final String PASS = "Fk!@#%213483";

	public void makePayment(int userID) {
//		Connection conn = null;
		
		// add the scanning on client side
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter Amount to be Paid");
		int amount = scanner.nextInt();
		System.out.print("Enter the Number for Mode of Payment");
		System.out.print("1. Offline");
		System.out.print("2. Online");
		int modeofPayment = scanner.nextInt();
		String insertQuery = "INSERT INTO Transaction (paymentID,amount, modeofPayment, userID) VALUES (?, ?, ?, ?)";

		try (Connection conn = DBUtils.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(insertQuery)) {
			pstmt.setInt(4, userID);
			pstmt.setInt(1, paymentID);
			pstmt.setInt(2, amount);
			pstmt.setInt(3, modeofPayment);
			int rowsInserted = pstmt.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("Online payment details inserted successfully.");
			} else {
				System.out.println("Failed to insert online payment details.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (modeofPayment == 2) {
			System.out.print("Enter Card Number");
			String CardNumber = scanner.next();
			System.out.print("Enter Expiry Date");
			String expiryDate = scanner.next();
			String insertQuery2 = "INSERT INTO OnlinePayment (paymentID, userID, CardNumber, expiryDate) VALUES (?, ?, ?, ?)";
			try (Connection conn = DBUtils.getConnection();
					PreparedStatement pstmt = conn.prepareStatement(insertQuery2)) {
				pstmt.setInt(1, paymentID);
				pstmt.setInt(2, userID);
				pstmt.setString(3, CardNumber);
				pstmt.setString(4, expiryDate);

				int rowsInserted = pstmt.executeUpdate();
				if (rowsInserted > 0) {
					System.out.println("Online payment details inserted successfully.");
				} else {
					System.out.println("Failed to insert online payment details.");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.print("Payment ID: " + paymentID);
		System.out.print("Amount: " + amount);
		System.out.print("User ID: " + userID);
		scanner.close();
	}

}