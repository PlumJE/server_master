package com.yedam;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.yedam.jdbc.BoardDAO;
import com.yedam.vo.BoardVO;


/*
 * 1. HttpServlet 상속
 * 2. service() 재정의.
 * 3. parameter(board_no)값을 받아서 조회
 * 4. attribute(board)를 담아서 board.jsp에 전달하고
 * 5. board.jsp에서는 전달받은 값을 출력.
 */

@WebServlet("/board.action")
public class BoardServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int boardNo = Integer.parseInt(request.getParameter("board_no"));
		
		BoardDAO bdao = new BoardDAO();
		BoardVO board = bdao.selectBoard(boardNo);
		
		// board의 속성에 조회된 결과를 전달
		request.setAttribute("board", board);
		
		// 요청 재지정.
		request.getRequestDispatcher("html/board.jsp").forward(request, response);
	}
}
