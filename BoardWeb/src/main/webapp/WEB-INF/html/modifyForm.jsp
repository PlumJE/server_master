<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	import="com.yedam.vo.BoardVO"%>

<jsp:include page="../../includes/header.jsp"></jsp:include>
	<h3>게시글 수정화면(modifyForm.jsp)</h3>
	<%BoardVO bvo = (BoardVO) request.getAttribute("board");
	// 파라미터 추가작업. 2024.12.12
	String sc = (String) request.getAttribute("searchCondition");
	String kw = (String) request.getAttribute("keyword");
	String pg = (String) request.getAttribute("page");
	String logId = (String) session.getAttribute("logId");%>
	<form action="modifyBoard.do" method="POST">
		<input type="hidden" name="board_no" value="<%=bvo.getBoardNo()%>">
		<!-- 파라미터 추가작업. 2024.12.12 -->
		<input type="hidden" name="searchCondition" value="<%=sc%>">
		<input type="hidden" name="keyword" value="<%=kw%>">
		<input type="hidden" name="page" value="<%=pg%>">
		<table class="table">
			<tr>
				<th>글번호</th><td><%=bvo.getBoardNo()%></td>
				<th>작성자</th><td><%=bvo.getWriter()%></td>
			</tr>
			<tr>
				<th>제목</th>
				<td colspan="3"><input type="text" name="title" value="<%=bvo.getTitle()%>"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td colspan="3">
					<textarea rows="5" class="form-control" name="content"><%=bvo.getContent()%></textarea>
				</td>
			</tr>
			<tr>
				<th>작성 일자</th><td><%=bvo.getCreationDate()%></td>
				<th>조회수</th><td><%=bvo.getViewCnt()%></td>
			</tr>
			<tr>
				<td colspan="4" align="center">
					<input type="submit" class="btn btn-warning" value="게시글등록">
				</td>
			</tr>
		</table>
	</form>
<jsp:include page="../../includes/footer.jsp"></jsp:include>