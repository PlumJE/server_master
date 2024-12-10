package com.yedam.control;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.yedam.common.Control;
import com.yedam.jdbc.BoardDAO;
import com.yedam.vo.BoardVO;


public class ModifyFormControl implements Control {
	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 게시글 번호 n번에 대한 조회결과 html/modifyFrom.jsp 출력.
		// 수정항목은 제목, 내용으로 제한.
		int boardNo = Integer.parseInt(request.getParameter("board_no"));
		BoardDAO bdao = new BoardDAO();
		BoardVO board = bdao.selectBoard(boardNo);
		
		request.setAttribute("board", board);
		request.getRequestDispatcher("html/modifyForm.jsp").forward(request, response);
	}

}
