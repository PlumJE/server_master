package com.yedam.control;

import java.io.IOException;

import com.yedam.common.Control;
import com.yedam.jdbc.MemberDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginControl implements Control {
	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		MemberDAO mdao = new MemberDAO();
		if (mdao.login(id, pw) != null) {
			HttpSession session = request.getSession();
			session.setAttribute("logId", id);
			
			System.out.println("Login succeeded as " + id);
			// 목록 이동.
			response.sendRedirect("boardList.do");
		}
		else {
			response.sendRedirect("loginForm.do");
		}
	}
}
