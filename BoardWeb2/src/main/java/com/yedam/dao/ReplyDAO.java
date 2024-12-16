package com.yedam.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yedam.vo.Reply;

/*
 * 댓글목록, 댓글등록, 댓글삭제
 */
public class ReplyDAO extends DAO {
	private String query = "select a.*"
			+ "		from (select /*+ INDEX(r PK_REPLY) */ rownum rn, r.*"
			+ "			  from tbl_reply r"
			+ "			  where board_no = ?"
			+ "			  order by reply_no) a"
			+ "		where a.rn > (? - 1) * 5"
			+ "		  and a.rn <= ? * 5";
	// 전체 댓글 건수.
	private String replyCount = "select count(1) from tbl_reply where board_no = ?";
	private String insertQuery = "insert into tbl_reply (reply_no, reply, replyer, board_no)"
			+ "			  values(?, ?, ?, ?)";
	private String deleteQuery = "delete from tbl_reply where reply_no = ?";
	// chart, 게시글별 댓글개수
	private String chartQuery = "select board_no || '번 글' as boardNo, count(1) as cnt"
			+ "					 from tbl_reply"
			+ "					 group by board_no";
	// fullcalendar 데이터
	public List<Map<String, Object>> calendarData() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		getConn();
		String sql = "select title, start_date as start, end_date as end "
				+ "	  from tbl_events";
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				Map<String, Object> map = new HashMap<>();
				map.put("title", rs.getString("title"));
				map.put("start", rs.getString("start"));
				map.put("end", rs.getString("end"));
				
				list.add(map);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			disConnect();
		}
		
		return list;
	}
	// 차트데이터
	public List<Map<String, Object>> chartData() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		getConn();
		
		try {
			psmt = conn.prepareStatement(chartQuery);
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				Map<String, Object> map = new HashMap<>();
				map.put("boardNo", rs.getString("boardNo"));
				map.put("cnt", rs.getInt("cnt"));
				
				list.add(map);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			disConnect();
		}
		return list;
	}
	
	// 댓글건수 반환
	public int selectReplyCount(int boardNo) {
		getConn();
		try {
			psmt = conn.prepareStatement(replyCount);
			psmt.setInt(1, boardNo);
			rs = psmt.executeQuery();
			
			// 조회결과가 있으면...
			if (rs.next()) {
				return rs.getInt(1);	// 1은 1번째 칼럼을 뜻한다.
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			disConnect();
		}
		return 0;	// 조회건수X 또는 쿼리X
	}
	
	// 댓글 삭제
	public List<Reply> selectList(int boardNo, int page) {
		getConn();
		List<Reply> rlist = new ArrayList<>(); // 반환될 컬렉션
		try {
			psmt = conn.prepareStatement(query);
			psmt.setInt(1, boardNo);
			psmt.setInt(2, page);
			psmt.setInt(3, page);
			
			// 조회쿼리.
			rs = psmt.executeQuery();
			while (rs.next()) {
				Reply rvo = new Reply();
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
	
	// 댓글 등록
	public boolean insertReply(Reply rvo) {
		getConn();
		try {
			psmt = conn.prepareStatement("select reply_seq.nextval from dual");
			rs = psmt.executeQuery();
			int rno = 0;	// 시퀀스를 먼저 생성해서 rvo에 저장.
			if (rs.next()) {
				rno = rs.getInt(1);
				rvo.setReplyNo(rno);
			}
			
			psmt = conn.prepareStatement(insertQuery);
			psmt.setInt(1, rno);
			psmt.setString(2, rvo.getReply());
			psmt.setString(3, rvo.getReplyer());
			psmt.setInt(4, rvo.getBoardNo());
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
	
	// 댓글 조회
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
