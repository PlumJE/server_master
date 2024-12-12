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
		String page = request.getParameter("page");	// 페이지정보.
		//page = page == null ? "1" : page;
		String sc = request.getParameter("searchCondition");
		String kw = request.getParameter("keyword");
		
		// @AllArgsConstructor
		// 페이지, 검색조건, 키워드 => 게시글 목록
		//SearchDTO search = new SearchDTO(Integer.parseInt(page), sc, kw);
		
		BoardDAO bdao = new BoardDAO();
		// 실행영역에서는 실제값이 대입. 다시 물어보면 확인하세요...2024.12.12
		// argument(매개값), parameter(매개변수)
		List<BoardVO> boardList = bdao.boardList(sc, kw);
		int totalCnt = bdao.selectCount();
		PageDTO pageDTO = new PageDTO(Integer.parseInt(page), totalCnt);
		System.out.println("totalCnt = " + totalCnt);
		
		// 요청 객체에 boardList정보를 담아서 jsp페이지로 전달.
		request.setAttribute("boardList", boardList);
		request.setAttribute("paging", pageDTO);
		
		request.setAttribute("searchCondition", sc);
		request.setAttribute("keyword", kw);
		
		// 요청 재지정.
		request.getRequestDispatcher("WEB-INF/html/boardList.jsp").forward(request, response);
	}
}
