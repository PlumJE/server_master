package com.yedam;

import java.util.List;

import com.yedam.dao.ReplyDAO;
import com.yedam.vo.Reply;

public class AppTest {
	public static void main(String[] args) {
		Reply rvo = new Reply();
		rvo.setReply("댓글테스트1234");
		rvo.setReplyer("user99");
		rvo.setBoardNo(1);
		
		ReplyDAO rdao = new ReplyDAO();
		if (rdao.insertReply(rvo)) {
			System.out.println("성공");
		}
		else {
			System.out.println("실패");
		}
		
		List<Reply> list = rdao.selectList(1);
		for (Reply rv : list) {
			System.out.println(rv.toString());
		}
	}
}
