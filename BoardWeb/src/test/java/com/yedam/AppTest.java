package com.yedam;

import com.yedam.jdbc.ReplyDAO;
import com.yedam.vo.ReplyVO;

public class AppTest {
	public static void main(String[] args) {
		ReplyDAO rdao = new ReplyDAO();
		if (rdao.deleteReply(1)) {
			System.out.println("삭제됨");
		}
		else {
			System.out.println("삭제 안됨");
		}
		for (ReplyVO rvo : rdao.selectList(224)) {
			System.out.println(rvo.toString());
		}
	}
}
