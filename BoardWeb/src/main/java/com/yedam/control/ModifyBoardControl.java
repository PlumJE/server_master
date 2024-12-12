package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.jdbc.BoardDAO;
import com.yedam.vo.BoardVO;

public class ModifyBoardControl implements Control {
	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 수정화면에서 submit 이벤트가 발생하면 데이터베이스의 정보를 수정.
		// 정상적으로 수정이 완료되면 목록이동.
		// 수정에러가 발생하면 수정화면으로 이동.
		if (request.getMethod().equals("POST")) {
			request.setCharacterEncoding("utf-8");
			
			int boardNo = Integer.parseInt(request.getParameter("board_no"));
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			// 파라미터 추가작업. 2024.12.12
			String sc = (String) request.getAttribute("searchCondition");
			String kw = (String) request.getAttribute("keyword");
			String pg = (String) request.getAttribute("page");
			
			BoardVO board = new BoardVO();
			board.setBoardNo(boardNo);
			board.setTitle(title);
			board.setContent(content);
			
			BoardDAO bdao = new BoardDAO();
			if (bdao.updateBoard(board)) {
				String addr = "board.do?page=" + pg + "&searchCondition=" + sc + "&keyword=" + kw + "&board_no=" + boardNo;
				response.sendRedirect(addr);
			}
			else {
				request.getRequestDispatcher("WEB-INF/html/modifyForm.jsp").forward(request, response);
			}
		}
	}
}
