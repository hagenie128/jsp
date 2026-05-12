package jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import config.DBManager;

public class JDBCMain6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("검색할 이름 일부:");
		String name =  sc.nextLine();
		
		String sql = "select * from students where name like concat('%', ?, '%')";
		
		// 1. PreparedStatement 생성
		try (PreparedStatement pstmt = DBManager.getInstance().getConn().prepareStatement(sql)) {
			// 2. SQL 실행
			pstmt.setString(1,name);
			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
					System.out.println(
							rs.getString(1) + "/" + rs.getString(2) + "/" 
									+ rs.getString(3) + "/" + rs.getDouble(4));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		sc.close();
	}
}