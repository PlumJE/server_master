<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	import="java.util.List"
	import="com.yedam.vo.BoardVO"%>

<jsp:include page="../includes/header.jsp"></jsp:include>
	<h3>글목록(boardList.jsp)</h3>
	<%
	List<BoardVO> list = (List<BoardVO>) request.getAttribute("boardList");
	%>
	<table class="table">
		<thead>
			<tr>
				<th>글번호</th><th>제목</th><th>작성자</th><th>작성일시</th>
			</tr>
		</thead>
		<tbody>
			<%for (BoardVO bvo : list) {%>
			<tr>
				<%
				String link = "board.action?board_no=";
				link += bvo.getBoardNo();
				%>
				<td align="center"><a href=<%=link%>><%=bvo.getBoardNo()%></a></td>
				<td><%=bvo.getTitle()%></td>
				<td><%=bvo.getWriter()%></td>
				<td><%=bvo.getCreationDate()%></td>
			</tr>
			<%}%>
		</tbody>
	</table>
<jsp:include page="../includes/footer.jsp"></jsp:include>