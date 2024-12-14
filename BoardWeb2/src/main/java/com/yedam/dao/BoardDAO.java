package com.yedam.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.common.SearchDTO;
import com.yedam.vo.Board;

public class BoardDAO extends DAO {
	private String selectSomeSql = "select board_no"
			+ "						  from tbl_board";
	private String selectOneSql = "select board_no,"
			+ "						 title,"
			+ "						 content,"
			+ "						 writer,"
			+ "						 view_cnt,"
			+ "						 creation_date,"
			+ "						 update_date,"
			+ "						 img"
			+ "						 from tbl_board"
			+ "						 where board_no = ?";
	private String insertSql = "insert into tbl_board(board_no,"
			+ "					  title,"
			+ "					  content,"
			+ "					  writer,"
			+ "					  img)"
			+ "					values(board_seq.nextval,"
			+ "					  ?,"
			+ "					  ?,"
			+ "					  ?,"
			+ "					  ?)";
	private String updateSql = "update tbl_board"
			+ "					set title=?,"
			+ "					  content=?,"
			+ "					  update_date=sysdate,"
			+ "					  img=?"
			+ "					where board_no=?";
	private String deleteSql = "delete from tbl_board"
			+ "					where board_no=?";
	// 게시글 번호 목록
	public List<Integer> selectBoardNoList(String where, int page) {
		getConn();
		
		String sql = selectSomeSql;
		if (where != null)
			sql += "where " + where;
		sql += "order by board_no";
		
		List<Integer> result = new ArrayList<>();	// 반환값
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();	// 조회
			
			while (rs.next()) {
				
				result.add(rs.getInt("board_no"));
			}
			
			int length = result.size();
			int from = page * 10 - 9;
			int to = page * 10 < length ? page * 10 : length;
			result = result.subList(from, to + 1);
			result.add(length);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			disConnect();
		}
		
		return result;
	}
	// 게시글 번호에 따른 게시글 상세 정보
	public Board selectBoard(int boardNo) {
		getConn();
		Board brd = new Board();
		
		try {
			psmt = conn.prepareStatement(selectOneSql);
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
				brd.setImg(rs.getString("img"));
				
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
	public boolean insertBoard(Board board) {
		getConn();
		
		try {
			psmt = conn.prepareStatement(insertSql);
			psmt.setString(1, board.getTitle());
			psmt.setString(2, board.getContent());
			psmt.setString(3, board.getWriter());
			psmt.setString(4, board.getImg());
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
	public boolean updateBoard(Board board) {
		getConn();
		
		try {
			psmt = conn.prepareStatement(updateSql);
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
	// 삭제.
	public boolean deleteBoard(Board board) {
		getConn();
		
		try {
			psmt = conn.prepareStatement(deleteSql);
			psmt.setInt(1, board.getBoardNo());
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
