package com.todo.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

// DB�� ���õ� ���� ������ ������� �����ϴ� Ŭ����
public class DBUtils {
	// MySQL ���� URL
	private static final String DB_URL = "jdbc:mysql://localhost:3306/";
	// ����ϰ��� �ϴ� ��Ű��(Database) �̸�
	private static final String DATABASE_NAME = "testdb";
	private static final String USER = "root";
	private static final String PASSWORD = "1234";
	
	
	// Java�� MySQL database�� �����ϴ� �޼ҵ�
	public static Connection getConnection() throws SQLException {
		Connection connection = DriverManager.getConnection(DB_URL + DATABASE_NAME, USER, PASSWORD);
		return connection;
	}
	
	// DDL, ���̺� ���� �޼���
	public static void dropAndCreateTable() {
		// Java�� MySQL ����
		
		// try - with resources ���� - �ڿ��� �ڵ����� �����ϴ� ����
		try (Connection connection = getConnection();
				Statement statement = connection.createStatement();
				) {
			// ���̺� ���� SQL, ���� todo�� �����ϴٸ� ������
			final String dropTableQueryIfExists = "DROP TABLE IF EXISTS todo";
			
			
			// Query ���� ����!
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
			System.out.println("�ڵ� ���� �Ϸᤧ��");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
