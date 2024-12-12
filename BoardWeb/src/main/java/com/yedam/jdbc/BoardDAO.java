package com.yedam.jdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;
import com.yedam.common.SearchDTO;
import com.yedam.vo.BoardVO;

public class BoardDAO extends DAO {
	public int selectCount() {
		getConn();
		String sql = "select count(1)"
				+ "   from tbl_board";
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();	// 조회
			if (rs.next()) {
				return rs.getInt(1);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			disConnect();
		}
		return 0;
	}
	// 목록.
	public List<BoardVO> boardList(String sc, String kw) {
		getConn();
		String sql = "select *"
				+ "   from tbl_board"
				+ "   where title like '%'||?||'%'"
				+ "		and writer like '%'||?||'%'"
				+ "   order by board_no";
		String title = "%", writer = "%";
		if (sc != null && kw != null) {
			if (sc.contains("T")) {
				title = kw;
			}
			if (sc.contains("W")) {
				writer = kw;
			}
		}
		List<BoardVO> result = new ArrayList<>();	// 반환값
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, title);
			psmt.setString(2, writer);
			rs = psmt.executeQuery();	// 조회
			
			while (rs.next()) {
				BoardVO brd = new BoardVO();
				brd.setBoardNo(rs.getInt("board_no"));
				brd.setTitle(rs.getString("title"));
				brd.setContent(rs.getString("content"));
				brd.setWriter(rs.getString("writer"));
				brd.setViewCnt(rs.getInt("view_cnt"));
				brd.setCreationDate(rs.getString("creation_date"));
				brd.setUpdateDate(rs.getString("update_date"));
				
				result.add(brd);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			disConnect();
		}
		
		return result;
	}
	// 상세조회.
	public BoardVO selectBoard(int boardNo) {
		getConn();
		BoardVO brd = new BoardVO();
		String sql = "select *"
				+ "   from tbl_board"
				+ "   where board_no = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, boardNo);
			rs = psmt.executeQuery();	// 조회
			
			while (rs.next()) {
				brd.setBoardNo(rs.getInt("board_no"));
				brd.setTitle(rs.getString("title"));
				brd.setContent(rs.getString("content"));
				brd.setWriter(rs.getString("writer"));
				brd.setViewCnt(rs.getInt("view_cnt"));
				brd.setCreationDate(rs.getString("creation_date"));
				brd.setUpdateDate(rs.getString("update_date"));
				
				return brd;
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
	// BoardVO 파라미터 => 등록.
	public boolean insertBoard(BoardVO board) {
		getConn();
		String sql = "insert into tbl_board(board_no,"
				+ "		title,"
				+ "		content,"
				+ "		writer)"
				+ "   values(board_seq.nextval,"
				+ "		?,"
				+ "		?,"
				+ "		?)";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, board.getTitle());
			psmt.setString(2, board.getContent());
			psmt.setString(3, board.getWriter());
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
	// 수정.
	public boolean updateBoard(BoardVO board) {
		getConn();
		String sql = "update tbl_board"
				+ "   set title=?, content=?"
				+ "   where board_no=?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, board.getTitle());
			psmt.setString(2, board.getContent());
			psmt.setInt(3, board.getBoardNo());
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
