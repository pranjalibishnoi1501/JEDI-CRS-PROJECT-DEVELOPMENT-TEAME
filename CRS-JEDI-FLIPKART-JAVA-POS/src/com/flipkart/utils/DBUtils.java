package com.flipkart.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtils {
	static final String DB_URL = "jdbc:mysql://localhost/CRS-Schema";
	static final String USER = "root";
	static final String PASS = "Fk!@#%213483";

	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;

	}

}
