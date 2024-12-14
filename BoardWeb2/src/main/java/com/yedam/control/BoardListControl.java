package com.yedam.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.PageDTO;
import com.yedam.dao.BoardDAO;
import com.yedam.vo.Board;


public class BoardListControl implements Control {
	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pg = request.getParameter("page");	// 페이지정보.
		String sc = request.getParameter("searchCondition");
		String kw = request.getParameter("keyword");
		
		BoardDAO bdao = new BoardDAO();
		// 실행영역에서는 실제값이 대입. 다시 물어보면 확인하세요...2024.12.12
		// argument(매개값), parameter(매개변수)
		String where = null;
		if (sc.equals("T"))
			where = "title = " + kw;
		else if (sc.equals("W"))
			where = "writer = " + kw;
		else if (sc.equals("TW"))
			where = "title = " + kw + " writer = " + kw;
		int page = pg == null ? 1 : Integer.parseInt(pg);
		
		List<Integer> boardNoList = bdao.selectBoardNoList(where, page);
		PageDTO pageDTO = new PageDTO(page, boardNoList.get(boardNoList.size() - 1));
		
		List<Board> boardList = new ArrayList<>();
		for (Integer i : boardNoList) {
			boardList.add(bdao.selectBoard(i));
		}
		
		// 요청 객체에 boardList정보를 담아서 jsp페이지로 전달.
		request.setAttribute("boardList", boardList);
		request.setAttribute("paging", pageDTO);
		
		request.setAttribute("searchCondition", sc);
		request.setAttribute("keyword", kw);
		
		// 요청 재지정.
		request.getRequestDispatcher("WEB-INF/html/boardList.jsp").forward(request, response);
	}
}
