package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.yedam.dao.BoardDAO;
import com.yedam.vo.Board;


public class BoardControl implements Control {
	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO bdao = new BoardDAO();
		
		// GET방식 : 조회 vs. POST방식 : 등록.
		if (request.getMethod().equals("GET")) {
			// 파라미터(board_no) + page + searchCondition + keyword;
			int boardNo = Integer.parseInt(request.getParameter("board_no"));
			String page = request.getParameter("page");
			String sc = request.getParameter("searchCondition");
			String kw = request.getParameter("keyword");
			Board board = bdao.selectBoard(boardNo);
			
			// board의 속성에 조회된 결과를 전달
			request.setAttribute("board", board);
			request.setAttribute("serachCondition", sc);
			request.setAttribute("keyword", kw);
			request.setAttribute("page", page);
			
			// 요청 재지정.
			request.getRequestDispatcher("WEB-INF/html/board.jsp").forward(request, response);
		}
		else if (request.getMethod().equals("POST")) {
			String savePath = request.getServletContext().getRealPath("images");
			int maxSize = 1024 * 1024 * 5;
			// multipart요청.
			MultipartRequest mr = new MultipartRequest(
					request,	// 요청정보
					savePath,	// 저장경로
					maxSize,	// 최대사이즈
					"utf-8",	// 인코딩
					new DefaultFileRenamePolicy());	// 리네임 정책
			
			// POST 요청일 경우에는 한글인코딩 방식을 적용해줘야 함.
			request.setCharacterEncoding("utf-8");
			
			String title = mr.getParameter("title");
			String content = mr.getParameter("content");
			String writer = mr.getParameter("writer");
			String img = mr.getFilesystemName("img");	// 리네임 정책에 의해 생성된 파일명.
			
			Board board = new Board();
			board.setTitle(title);
			board.setContent(content);
			board.setWriter(writer);
			board.setImg(img);
			
			if (bdao.insertBoard(board)) {
				response.sendRedirect("boardList.do");
			}
			else {
				request.getRequestDispatcher("WEB-INF/html/boardForm.jsp").forward(request, response);
			}
		}
	}
}
