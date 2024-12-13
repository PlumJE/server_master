package com.yedam;

import java.util.List;

import com.yedam.jdbc.ReplyDAO;
import com.yedam.vo.ReplyVO;

public class AppTest {
	public static void main(String[] args) {
		ReplyVO rvo = new ReplyVO();
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
		
		List<ReplyVO> list = rdao.selectList(1);
		for (ReplyVO rv : list) {
			System.out.println(rv.toString());
		}
	}
}
