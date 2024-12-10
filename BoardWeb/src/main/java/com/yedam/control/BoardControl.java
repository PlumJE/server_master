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
		BoardDAO bdao = new BoardDAO();
		
		// GET방식 : 조회 vs. POST방식 : 등록.
		if (request.getMethod().equals("GET")) {
			// 파라미터(board_no);
			int boardNo = Integer.parseInt(request.getParameter("board_no"));
			BoardVO board = bdao.selectBoard(boardNo);
			
			// board의 속성에 조회된 결과를 전달
			request.setAttribute("board", board);
			
			// 요청 재지정.
			request.getRequestDispatcher("html/board.jsp").forward(request, response);
		}
		else if (request.getMethod().equals("POST")) {
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String writer = request.getParameter("writer");
			
			BoardVO board = new BoardVO();
			board.setTitle(title);
			board.setContent(content);
			board.setWriter(writer);
			
			if (bdao.insertBoard(board)) {
				response.sendRedirect("boardList.do");
			}
			else {
				request.getRequestDispatcher("html/boardForm.jsp").forward(request, response);
			}
		}
	}
}
