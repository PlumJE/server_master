package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.common.PageDTO;
import com.yedam.jdbc.BoardDAO;
import com.yedam.vo.BoardVO;


public class BoardListControl implements Control {
	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pg = request.getParameter("page");	// 페이지정보.
		String sc = request.getParameter("searchCondition");
		String kw = request.getParameter("keyword");
		
		BoardDAO bdao = new BoardDAO();
		// 실행영역에서는 실제값이 대입. 다시 물어보면 확인하세요...2024.12.12
		// argument(매개값), parameter(매개변수)
		int page = pg == null ? 1 : Integer.parseInt(pg);
		int max = page * 10 < bdao.selectCount() ? page * 10 : bdao.selectCount();
		
		List<BoardVO> boardList = bdao.boardList(sc, kw);
		PageDTO pageDTO = new PageDTO(page, bdao.selectCount());
		boardList = boardList.subList(page * 10 - 10, max);
		
		// 요청 객체에 boardList정보를 담아서 jsp페이지로 전달.
		request.setAttribute("boardList", boardList);
		request.setAttribute("paging", pageDTO);
		
		request.setAttribute("searchCondition", sc);
		request.setAttribute("keyword", kw);
		
		// 요청 재지정.
		request.getRequestDispatcher("WEB-INF/html/boardList.jsp").forward(request, response);
	}
}
