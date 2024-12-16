package com.yedam.dao;

import java.sql.SQLException;

public class MemberDAO extends DAO {
	public String login(String id, String pw) {
		getConn();
		String sql = "select *"
				+ "   from tbl_member"
				+ "   where member_id = ?"
				+ "		and password = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);
			
			// 결과 조회.
			rs = psmt.executeQuery();
			if (rs.next()) {
				return rs.getString("member_name");
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			disConnect();
		}
		return null;
	}
}
