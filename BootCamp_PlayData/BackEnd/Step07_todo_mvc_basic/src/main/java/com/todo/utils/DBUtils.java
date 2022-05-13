package com.todo.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

// DB와 관련된 설정 정보나 수행들을 관리하는 클래스
public class DBUtils {
	// MySQL 서버 URL
	private static final String DB_URL = "jdbc:mysql://localhost:3306/";
	// 사용하고자 하는 스키마(Database) 이름
	private static final String DATABASE_NAME = "testdb";
	private static final String USER = "root";
	private static final String PASSWORD = "1234";
	
	
	// Java와 MySQL database와 연결하는 메소드
	public static Connection getConnection() throws SQLException {
		Connection connection = DriverManager.getConnection(DB_URL + DATABASE_NAME, USER, PASSWORD);
		return connection;
	}
	
	// DDL, 테이블 생성 메서드
	public static void dropAndCreateTable() {
		// Java와 MySQL 연결
		
		// try - with resources 구문 - 자원을 자동으로 해제하는 구문
		try (Connection connection = getConnection();
				Statement statement = connection.createStatement();
				) {
			// 테이블 제거 SQL, 만약 todo가 존재하다면 제거해
			final String dropTableQueryIfExists = "DROP TABLE IF EXISTS todo";
			
			
			// Query 진행 시켜!
			statement.execute(dropTableQueryIfExists);
			
			
			final String createTableQuery =             
					"CREATE TABLE todo (" +
		            "id SMALLINT(5) unsigned NOT NULL AUTO_INCREMENT," +
		            "title VARCHAR(255)," +
		            "description VARCHAR(255)," +
		            "due_date DATE," +
		            "is_completed BOOLEAN DEFAULT false," +
		            "PRIMARY KEY (id))";
			statement.execute(createTableQuery);
			System.out.println("코드 실행 완료ㄷㄷ");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
