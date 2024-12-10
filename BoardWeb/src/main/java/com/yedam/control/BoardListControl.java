package com.yedam.control;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.yedam.common.Control;
import com.yedam.jdbc.BoardDAO;
import com.yedam.vo.BoardVO;


public class BoardListControl implements Control {
	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO bdao = new BoardDAO();
		List<BoardVO> boardList = bdao.boardList();
		
		// 요청 객체에 boardList정보를 담아서 jsp페이지로 전달.
		request.setAttribute("boardList", boardList);
		
		// 요청 재지정.
		request.getRequestDispatcher("html/boardList.jsp").forward(request, response);
	}
}
