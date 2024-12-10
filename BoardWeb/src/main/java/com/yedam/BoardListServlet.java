package com.yedam;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.yedam.jdbc.BoardDAO;
import com.yedam.vo.BoardVO;

/*
 * 1. HttpServlet 상속
 * 2. service() 재정의.
 * 3. parameter(board_no)값을 받아서 조회
 * 4. attribute(board)를 담아서 board.jsp에 전달하고
 * 5. board.jsp에서는 전달받은 값을 출력.
 */

@WebServlet("/boardList.action")
public class BoardListServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO bdao = new BoardDAO();
		List<BoardVO> boardList = bdao.boardList();
		
		// 요청 객체에 boardList정보를 담아서 jsp페이지로 전달.
		request.setAttribute("boardList", boardList);
		
		// 요청 재지정.
		request.getRequestDispatcher("html/boardList.jsp").forward(request, response);
	}
}