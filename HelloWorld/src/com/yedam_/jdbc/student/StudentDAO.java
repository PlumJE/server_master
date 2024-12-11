package com.yedam.jdbc.student;

import java.sql.SQLException;
import java.util.ArrayList;

/*
 * DAO : Data Access Object.
 * 입력, 수정, 삭제, 조회(한개, 전부)
 */
public class StudentDAO extends DAO {
	// 로그인.
	public String login(String id, String password) {
		getConn();
		String sql = "select *"
				+ "   from tbl_member"
				+ "   where member_id = ?"
				+ "   and password = ?";
		
		try {
			psmt = conn.prepareStatement(sql);	// 쿼리 실행. 결과 반환.
			psmt.setString(1, id);
			psmt.setString(2, password);
			
			rs = psmt.executeQuery();
			while (rs.next()) {
				return rs.getString("member_name");
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			disconnect();	// 연결해제.			
		}
		
		return null;
	}
	
	// 등록.
	public boolean insertStudent(Student std) {
		getConn();
		String sql = "insert into tbl_student (std_no, "
				+ "							   std_name,"
				+ "							   std_phone)"
				+ "values(?, ?, ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, std.getStdNo());
			psmt.setString(2, std.getStdName());
			psmt.setString(3, std.getStdPhone());
			int r = psmt.executeUpdate();
			System.out.println(r + "개의 줄이 수정");
			
			if (r > 0) {
				return true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			disconnect();
		}
		
		return false;
	}
	
	// 점수등록.
	public boolean updateStudent(Student std) {
		getConn();
		String sql = "update tbl_student set eng_score = ?, math_score = ?"
				+ "where std_no = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, std.getEngScore());
			psmt.setInt(2, std.getMathScore());
			psmt.setString(3, std.getStdNo());
			int r = psmt.executeUpdate();
			System.out.println(r + "개의 줄이 수정");
			
			if (r > 0) {
				return true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			disconnect();
		}
		
		return false;
	}
	
	// 삭제.
	public boolean deleteStudent(Student std) {
		getConn();
		String sql = "delete from tbl_student where std_no = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, std.getStdNo());
			int r = psmt.executeUpdate();
			System.out.println(r + "개의 줄이 삭제");
			
			if (r > 0) {
				return true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			disconnect();
		}
		
		return false;
	}
	
	// 학생 1명 보기
	public Student selectStudent(String stdNo) {
		getConn();
		String sql = "select * from tbl_student where std_no=?";
		
		try {
			psmt = conn.prepareStatement(sql);	// 쿼리 실행. 결과 반환.
			psmt.setString(1, stdNo);
			rs = psmt.executeQuery();
			
			// 반복 ArrayList에 담는 작업.
			while (rs.next()) {
				Student std = new Student();
				std.setStdNo(rs.getString("std_no"));	// 인스턴스 생성.
				std.setStdName(rs.getString("std_name"));
				std.setStdPhone(rs.getString("std_phone"));
				std.setEngScore(rs.getInt("eng_score"));
				std.setMathScore(rs.getInt("math_score"));
				std.setCreationDate(rs.getDate("creation_date"));
				return std;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			disconnect();	// 연결해제.
		}
		return null;
	}
	
	// 학생목록.
	public ArrayList<String> studentList(Search search) {
		getConn();
		ArrayList<String> stdNoList = new ArrayList<String>();
		
		String sql = "select std_no,"
				+ "   std_name,"
				+ "   std_phone,"
				+ "   eng_score,"
				+ "   math_score,"
//				+ "   to_char(creation_date, 'yyy-mm-dd hh24:mi:ss')"
				+ "   creation_date"
				+ "	  from tbl_student"
				+ "	  where std_name like '%'||?||'%' "
				+ "   and std_phone like '%'||?||'%' "
				+ "	  and eng_score >= ?";
		if (search.getOrderBy().equals("std_no")) {
			sql += " order by std_no";
		}
		else if (search.getOrderBy().equals("std_name")) {
			sql += " order by std_name";
		}
		
		try {
			psmt = conn.prepareStatement(sql);	// 쿼리 실행. 결과 반환.
			psmt.setString(1, search.getName());
			psmt.setString(2, search.getPhone());
			psmt.setInt(3, search.getEngScore());
			
			rs = psmt.executeQuery();
			// 반복 ArrayList에 담는 작업.
			while (rs.next()) {
				stdNoList.add(rs.getString("std_no"));	// ArrayList에 추가.
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			disconnect();	// 연결해제.			
		}
		
		return stdNoList;
	}
}
