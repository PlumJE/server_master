package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.Control;
import com.yedam.jdbc.MemberDAO;

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
