package com.flipkart.constant;

public class SQLConstant {
//	Admin
    public static final String SELECT_USER = "SELECT * FROM User WHERE userID = ?";
    public static final String UPDATE_USER_APPROVAL = "UPDATE User SET isApproved = ? WHERE userID = ?";
    public static final String SELECT_COURSE = "SELECT * FROM Course WHERE courseCode = ?";
    public static final String UPDATE_COURSE_DETAILS = "UPDATE Course SET userID = ?, courseDescription = ? WHERE courseCode = ?";
    public static final String SELECT_ALL_COURSES = "SELECT * FROM Course";
    public static final String SELECT_ADD_DROP_REQUEST = "SELECT * FROM AddDropRequest";
    public static final String UPDATE_ADD_DROP_REQUEST_VIEW = "UPDATE AddDropRequest SET view = 1 WHERE courseCode = ?";
    public static final String INSERT_NOTIFICATION = "INSERT INTO Notification (description, userID, type) VALUES (?, ?, ?)";
    
//    Payment
    public static final String INSERT_TRANSACTION = "INSERT INTO Transaction (paymentID, amount, modeofPayment, userID) VALUES (?, ?, ?, ?)";
    public static final String INSERT_ONLINE_PAYMENT = "INSERT INTO OnlinePayment (paymentID, userID, CardNumber, expiryDate) VALUES (?, ?, ?, ?)";
    
//  Professor
  public static final String SELECT_TEACHING_COURSES = "SELECT * FROM Course WHERE userID = ?";
  public static final String SELECT_ENROLLED_STUDENTS = "SELECT * FROM GradeCard WHERE courseCode = ?";
  public static final String UPDATE_GRADE = "UPDATE GradeCard SET grade = ? WHERE courseCode = ? AND userID = ?";
  
//    Student
    public static final String INSERT_ADD_DROP_REQUEST = "INSERT INTO AddDropRequest (userID, courseCode, type) VALUES (?, ?, ?)";
    public static final String SELECT_COURSES = "SELECT * FROM Course";
    public static final String SELECT_GRADE_CARD = "SELECT * FROM GradeCard WHERE userID = ?";
//    public static final String SELECT_REPORT_CARD = "SELECT * FROM GradeCard WHERE userID = ?";
    
//    User
    public static final String INSERT_USER = "INSERT INTO User (name, password, role, isApproved) VALUES (?, ?, ?, ?)";
    public static final String UPDATE_PASSWORD = "UPDATE User SET password = ? WHERE userID = ?";
    

}
