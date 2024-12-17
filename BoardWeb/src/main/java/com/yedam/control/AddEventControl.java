package com.yedam.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.dao.ReplyDAO;

public class AddEventControl implements Control {
	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("a");	// 휴가
		String sd = request.getParameter("b");	// 2024-12-16
		String ed = request.getParameter("c");	// 2024-12-19
		
		ReplyDAO rdao = new ReplyDAO();
		Map<String, String> inputVal = new HashMap<>();
		
		inputVal.put("title", title);
		inputVal.put("start", sd);
		inputVal.put("end", ed);		
		if (rdao.insertEvent(inputVal)) {
			response.getWriter().print("{\"retCode\": \"OK\"}");
		}
		else {
			response.getWriter().print("{\"retCode\": \"Fail\"}");
		}
	}
}
