package com.yedam.control;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.yedam.common.Control;
import com.yedam.jdbc.BoardDAO;
import com.yedam.vo.BoardVO;


public class BoardControl implements Control {
	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int boardNo = Integer.parseInt(request.getParameter("board_no"));
		
		BoardDAO bdao = new BoardDAO();
		BoardVO board = bdao.selectBoard(boardNo);
		
		// board의 속성에 조회된 결과를 전달
		request.setAttribute("board", board);
		
		// 요청 재지정.
		request.getRequestDispatcher("html/board.jsp").forward(request, response);
	}
}
