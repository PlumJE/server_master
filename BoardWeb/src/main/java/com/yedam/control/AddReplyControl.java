package com.yedam.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.jdbc.ReplyDAO;
import com.yedam.vo.ReplyVO;

public class AddReplyControl implements Control {
	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/json;charset=utf-8");
		
		// parameter(reply, replyer, bno)
		String bno = request.getParameter("bno");
		ReplyVO rvo = new ReplyVO();
		
		rvo.setReply(request.getParameter("reply"));
		rvo.setReplyer(request.getParameter("replyer"));
		rvo.setBoardNo(Integer.parseInt(bno));
		
		// json문자열 생성
		Gson gson = new GsonBuilder().create();
		
		Map<String, Object> resultMap = new HashMap<>();
		
		ReplyDAO rdao = new ReplyDAO();
		if (rdao.insertReply(rvo)) {
			// 성공했을때.
			resultMap.put("retCode", "OK");
			resultMap.put("retVal", rvo);
			
			String json = gson.toJson(resultMap);
			response.getWriter().print(json);
		}
		else {
			response.getWriter().print("{\"retCode\": \"Fail\"}");
		}
	}
}
