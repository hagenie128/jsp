package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCMain4 {
	
	public static final String DB_USER = "root";
	public static final String DB_PASSWD = "12345678";

	public static void main(String[] args) {
		//year 가 2022~2024인 데이터만 조회
		try {
			// 1. DB접속 - 접속 정보는 Connection 으로 관리됨
			Connection conn = DriverManager
					.getConnection("jdbc:mysql://localhost/car_db?" + "user=" + DB_USER + "&password=" + DB_PASSWD);
			System.out.println("DB 접속 완료");

			// 2. SQL문 생성
			String sql = "select * from cars where year between ? and ?"; 
			// between 연산자는 특정 범위 내에 있는 값을 검색하는 데 사용됨, 여기서는 year
			// 3. SQL을 실행할 객체 Statement 생성
			try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
				// 4. SQL문에 데이터 셋팅
				pstmt.setInt(1, 2022); // 첫 번째 물음표에 2022 정수를 설정
				pstmt.setInt(2, 2024); // 두 번째 물음표에 2024 정수를 설정
				// 5. SQL문 실행
				try (ResultSet rs = pstmt.executeQuery()) {
					// 6. 데이터 확인
					while (rs.next()) {
						System.out.println(rs.getInt(1) 
								+ "," + rs.getString(2) 
								+ "," + rs.getString(3) 
								+ "," + rs.getInt(4) 
								+ "," + rs.getInt(5) 
								+ "," + rs.getInt(6) 
								+ "," + rs.getString(7));
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
