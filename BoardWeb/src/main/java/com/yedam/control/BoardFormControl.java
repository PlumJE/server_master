package com.yedam.control;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.yedam.common.Control;


public class BoardFormControl implements Control {
	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 게시글을 등록하는 화면을 호출
		request.getRequestDispatcher("html/boardForm.jsp").forward(request, response);
	}
}
