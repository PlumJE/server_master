package com.yedam;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.yedam.common.Control;
import com.yedam.control.BoardControl;
import com.yedam.control.BoardListControl;

public class FrontControl extends HttpServlet {
	Map<String, Control> map;
	public FrontControl() {
		map = new HashMap<>();	// 필드의 값을 초기화
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		map.put("/boardList.do", new BoardListControl());
		map.put("/board.do", new BoardControl());
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// http://localhost:80/BoardWeb/hello.do
		String uri = request.getRequestURI();
		String context = request.getContextPath();
		String path = uri.substring(context.length());
		System.out.println(path);
		
		// 요청url === 실행할 컨트롤
		Control control = map.get(path);
		control.exec();
	}
}
