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
				<td colspan="4"><%=board.getContent()%></td>
			</tr>
			<tr>
				<td colspan="4" align="center">
					<%String link = "modifyForm.do?board_no=" + board.getBoardNo();%>
					<a href=<%=link%>><input type="submit" value="게시글수정"></a>
				</td>
			</tr>
		</tbody>
	</table>
<jsp:include page="../includes/footer.jsp"></jsp:include>