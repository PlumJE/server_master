package com.yedam.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * JDBC 프로그램
 * 
 * 1. 드라이버 로드
 * 2. DB연결 (Connection)
 * 3. Query 실행해 DB 이용
 * 4. DB 닫기
 */
public class JdbcExe {
	public static void main(String[] args) {
//		insert("Hong", "KHONG", "2024-01-02", "IT_PROG");
//		update("kildong", "010.2345.6789", "3000", 208);
//		delete(208);
		select();
		System.out.println("End of prog");
	}
	
	// 연결.
	public static Connection getConn() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");	// 드라이버 로드
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");	// Connection 객체를 반환
		}
		catch (Exception e) {
			// 예외발생시 명령
			System.out.println("연결 중 에러.");
			e.printStackTrace();
		}
		return conn;	// connection 객체 반환.
	}
	
	// 입력기능.
	public static void insert(String lastName, String email, String hdate, String job) {
		Connection conn = getConn();
		String query = "insert into employees(employee_id, "
				+ "							  last_name, "
				+ "							  email, "
				+ "							  hire_date, "
				+ "							  job_id) "
				+ "		values(employees_seq.nextval, "	// empId
				+ "			   '" + lastName + "', "	// last_name
				+ "			   '" + email + "', "	// email
				+ "			   '" + hdate + "', "	// hire_date
				+ "			   '" + job + "')";
		try {
			Statement stmt = conn.createStatement();
			int r = stmt.executeUpdate(query);
			System.out.println(r + "건 처리됨.");
			conn.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 수정기능.
	public static void update(String first_name, String phone_number, String salary, int employee_id) {
		Connection conn = getConn();
		String query = "update employees "
				+ "		set first_name = '" + first_name + "', "
				+ "		phone_number = '" + phone_number + "', "
				+ "		salary = " + salary
				+ "		where employee_id = " + employee_id;
		try {
			Statement stmt = conn.createStatement();
			int r = stmt.executeUpdate(query);
			System.out.println(r + "건 처리됨.");
			conn.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 삭제기능.
	public static void delete(int employee_id) {
		Connection conn = getConn();
		String query = "delete from employees "
				+ "where employee_id = " + employee_id;
		try {
			Statement stmt = conn.createStatement();
			int r = stmt.executeUpdate(query);
			System.out.println(r + "건 처리됨.");
			conn.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 조회기능.
	public static void select() {
		Connection conn = getConn();
		
		// sql작성. Statement 객체.
		Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from employees");
			
			while (rs.next()) {
				System.out.println(rs.getInt("employee_id") + ", "
						+ rs.getString("first_name") + ", " 
						+ rs.getString("last_name") + ", " 
						+ rs.getInt("salary") + ", "
						+ rs.getString("phone_number") + ", "
						+ rs.getString("email"));
			}
			conn.close();	// 연결 해제.
		}
		catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println("== end of data ==");
	}
}
