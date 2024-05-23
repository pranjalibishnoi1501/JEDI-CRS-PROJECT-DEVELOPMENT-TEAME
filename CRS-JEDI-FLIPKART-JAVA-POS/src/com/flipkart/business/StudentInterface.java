package com.flipkart.business;

public interface StudentInterface {
	public void registerCourse();

	public void addCourse( int courseId);

	public void dropCourse(int courseId);
	
	public void viewReportCard();

	public void payFees(int userID);

	public void viewRegisteredCourse();

	public void viewCourseCatalog();

}
