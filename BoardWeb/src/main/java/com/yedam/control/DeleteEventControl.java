package com.yedam.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.dao.ReplyDAO;

public class DeleteEventControl implements Control {
	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("a");
		String sd = request.getParameter("b");
		String ed = request.getParameter("c");
		
		ReplyDAO rdao = new ReplyDAO();
		Map<String, String> inputVal = new HashMap<>();
		
		inputVal.put("title", title);
		inputVal.put("start", sd);
		inputVal.put("end", ed);
		
		if (rdao.deleteEvent(inputVal)) {
			response.getWriter().print("{\"retCode\": \"OK\"}");
		}
		else {
			response.getWriter().print("{\"retCode\": \"Fail\"}");
		}
	}
}
