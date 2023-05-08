package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBConnect {
	public static void main(String[] args) {
		Connection mysql = JDBConnect.getConnection();
		System.out.println(mysql);
		JDBConnect.closeConnection(mysql);
	}

	static String url = "jdbc:mySQL://localhost:3306/qldkmh";
	static String pass = "huu2003";
	static String user = "root";

	/**
	 * 
	 * @param tạo kết nối
	 * 
	 */
	public static Connection getConnection() {
		Connection mysql = null;

		try {
			// Tải lớp trình điều khiển JDBC của MySQL
			Class.forName("com.mysql.cj.jdbc.Driver");

			mysql = DriverManager.getConnection(url, user, pass);

		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return mysql;
	}

	/**
	 * @param ngắt kết nối
	 */
	public static void closeConnection(Connection mysql) {
		try {
			if (mysql != null) {
				mysql.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
