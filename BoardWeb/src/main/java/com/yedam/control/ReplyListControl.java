package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.jdbc.ReplyDAO;
import com.yedam.vo.ReplyVO;

public class ReplyListControl implements Control {
	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/json;charset=utf-8");
		String bno = request.getParameter("bno");
		// 댓글 -> 자바스크립트 object -> json 문자열
		// 형식 : {문자열or숫자:문자열or숫자, 문자열or숫자:문자열or숫자, ...}
		ReplyDAO rdao = new ReplyDAO();
		List<ReplyVO> list = rdao.selectList(Integer.parseInt(bno));
		
		String json = "";
		for (int i = 0; i < list.size(); i++) {
			json += "{\"replyNo\":" + list.get(i).getReplyNo() + ",";
			json += " \"reply\":\"" + list.get(i).getReply() + "\",";
			json += " \"replyer\":\"" + list.get(i).getReplyer() + "\",";
			json += " \"replyDate\":\"" + list.get(i).getReplyDate() + "\"}";
			if (i < list.size() - 1) {
				json += ", ";
			}
		}
		json = "[" + json + "]";
		response.getWriter().print(json);
	}
}
