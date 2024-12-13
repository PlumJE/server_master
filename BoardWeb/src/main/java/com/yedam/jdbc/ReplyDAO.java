package com.yedam.jdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;
import com.yedam.vo.ReplyVO;

/*
 * 댓글목록, 댓글등록, 댓글삭제
 */
public class ReplyDAO extends DAO {
	String query = "select * from tbl_reply where board_no = ?";
	String insertQuery = "insert into tbl_reply (reply_no, reply, replyer, board_no)"
			+ "			  values(reply_seq.nextval, ?, ?, ?)";
	String deleteQuery = "delete from tbl_reply where reply_no = ?";
	
	public List<ReplyVO> selectList(int boardNo) {
		getConn();
		List<ReplyVO> rlist = new ArrayList<>(); // 반환될 컬렉션
		try {
			psmt = conn.prepareStatement(query);
			psmt.setInt(1, boardNo);
			
			// 조회쿼리.
			rs = psmt.executeQuery();
			while (rs.next()) {
				ReplyVO rvo = new ReplyVO();
				rvo.setReplyNo(rs.getInt("reply_no"));
				rvo.setReply(rs.getString("reply"));
				rvo.setReplyer(rs.getString("replyer"));
				rvo.setReplyDate(rs.getDate("reply_date"));
				rvo.setBoardNo(rs.getInt("board_no"));
				
				rlist.add(rvo);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			disConnect();
		}
		return rlist;
	}
	
	public boolean deleteReply(int replyNo) {
		getConn();
		try {
			psmt = conn.prepareStatement(deleteQuery);
			psmt.setInt(1, replyNo);
			int r = psmt.executeUpdate();
			
			if (r > 0) {
				return true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			disConnect();
		}
		return false;
	}
}
