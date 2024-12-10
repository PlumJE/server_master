<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	import="com.yedam.vo.BoardVO"%>

<jsp:include page="../includes/header.jsp"></jsp:include>
	<h3>글상세화면(board.jsp)</h3>
	<%
	BoardVO board = (BoardVO) request.getAttribute("board");
	%>
	<table class="table">
		<thead>
			<tr>
				<th>글번호</th><th>제목</th><th>작성자</th><th>작성일시</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td align="center"><%=board.getBoardNo()%></td>
				<td><%=board.getTitle()%></td>
				<td><%=board.getWriter()%></td>
				<td><%=board.getCreationDate()%></td>
			</tr>
			<tr>
				<th colspan="4">내용</th>
			</tr>
			<tr>
				<td colspan="4"><%=board.getContent()%></td>
			</tr>
		</tbody>
	</table>
<jsp:include page="../includes/footer.jsp"></jsp:include>