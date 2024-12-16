package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class BoardFormControl implements Control {
	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 게시글을 등록하는 화면을 호출
		request.getRequestDispatcher("WEB-INF/html/boardForm.jsp").forward(request, response);
	}
}
