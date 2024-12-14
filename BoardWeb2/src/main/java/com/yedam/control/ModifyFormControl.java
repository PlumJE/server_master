package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.dao.BoardDAO;
import com.yedam.vo.Board;


public class ModifyFormControl implements Control {
	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getMethod().equals("GET")) {
			// 게시글 번호 n번에 대한 조회결과 html/modifyFrom.jsp 출력.
			// 수정항목은 제목, 내용으로 제한.
			int boardNo = Integer.parseInt(request.getParameter("board_no"));
			String page = request.getParameter("page");
			String sc = request.getParameter("searchCondition");
			String kw = request.getParameter("keyword");
			
			BoardDAO bdao = new BoardDAO();
			Board board = bdao.selectBoard(boardNo);
			
			request.setAttribute("board", board);
			request.setAttribute("serachCondition", sc);
			request.setAttribute("keyword", kw);
			request.setAttribute("page", page);
			request.getRequestDispatcher("WEB-INF/html/modifyForm.jsp").forward(request, response);
		}
		else if (request.getMethod().equals("POST")) {
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
				
				Board board = new Board();
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

}
