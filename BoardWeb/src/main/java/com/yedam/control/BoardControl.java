package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.jdbc.BoardDAO;
import com.yedam.vo.BoardVO;


public class BoardControl implements Control {
	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO bdao = new BoardDAO();
		
		// GET방식 : 조회 vs. POST방식 : 등록.
		if (request.getMethod().equals("GET")) {
			// 파라미터(board_no) + page + searchCondition + keyword;
			int boardNo = Integer.parseInt(request.getParameter("board_no"));
			String page = request.getParameter("page");
			String sc = request.getParameter("searchCondition");
			String kw = request.getParameter("keyword");
			BoardVO board = bdao.selectBoard(boardNo);
			
			// board의 속성에 조회된 결과를 전달
			request.setAttribute("board", board);
			request.setAttribute("serachCondition", sc);
			request.setAttribute("keyword", kw);
			request.setAttribute("page", page);
			
			// 요청 재지정.
			request.getRequestDispatcher("WEB-INF/html/board.jsp").forward(request, response);
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
				request.getRequestDispatcher("WEB-INF/html/boardForm.jsp").forward(request, response);
			}
		}
	}
}
