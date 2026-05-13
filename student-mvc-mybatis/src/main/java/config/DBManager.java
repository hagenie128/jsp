package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//DB 접속 정보를 가지고 있는 객체
//언제든디 필요할 때마다 Connection 전달
//Connection 받은 곳에서 Statement 생성해서 DB 제어
public class DBManager {
	private static DBManager instance = new DBManager();
	private Connection conn;

	private DBManager() {
		// conn 에 DB 접속 정보 생성
		try {
			// MySQL 드라이버 클래스 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/student_db", "root", "12345678");
			System.out.println("DB 접속 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConn() {
		return conn;
	}

	public static DBManager getInstance() {
		if (instance == null)
			instance = new DBManager();
		return instance;
	}

}
