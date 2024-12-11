<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	import="java.util.List"
	import="com.yedam.vo.BoardVO"
	import="com.yedam.common.PageDTO"%>

<jsp:include page="../includes/header.jsp"></jsp:include>
	<h3>글목록(boardList.jsp)</h3>
	<%List<BoardVO> list = (List<BoardVO>) request.getAttribute("boardList");%>
	<form action="boardList.do">
		<div class="row">
			<div class="col-sm-4">
				<select name="searchCondition" class="form-control">
					<option value="">선택하세요</option>
					<option value="T">제목</option>
					<option value="W">작성자</option>
					<option value="TW">제목 & 작성자</option>
				</select>
			</div>
			<div class="col-sm-6">
				<input type="text" name="keyword" class="form-control">
			</div>
			<div class="col">
				<input type="submit" name="검색" class="form-control">
			</div>
		</div>
	</form>
	<table class="table">
		<thead>
			<tr>
				<th>글번호</th><th>제목</th><th>작성자</th><th>작성일시</th>
			</tr>
		</thead>
		<tbody>
			<%for (BoardVO bvo : list) {%>
			<tr>
				<%String link = "board.do?board_no=" + bvo.getBoardNo();%>
				<td align="center"><a href=<%=link%>><%=bvo.getBoardNo()%></a></td>
				<td><%=bvo.getTitle()%></td>
				<td><%=bvo.getWriter()%></td>
				<td><%=bvo.getCreationDate()%></td>
			</tr>
			<%}%>
		</tbody>
	</table>
	<!-- paging -->
	<%PageDTO paging = (PageDTO) request.getAttribute("paging");%>
	<p><%=paging%></p>
	<nav aria-label="...">
		<ul class="pagination">
			<%if (paging.isPrev()) {%>
			<li class="page-item">
				<a class="page-link" href="boardList.do?page=<%=paging.getStartPage()-1%>">Previous</a>
			</li>
			<%}
			else {%>
			<li class="page-item disabled">
				<span class="page-link">Previous</span>
			</li>
			<%}
			
			for (int p = paging.getStartPage(); p <= paging.getEndPage(); p++) {
				if (paging.getCurrentPage() == p) {%>
				<li class="page-item active" aria-current="page">
					<span class="page-link"><%=p%></span>
				</li>
			<%	}
				else {%>
				<li class="page-item"><a class="page-link" href="boardList.do?page=<%=p%>"><%=p%></a></li>
			<%	}
			}
			
			if (paging.isNext()) {%>
			<li class="page-item">
				<a class="page-link" href="boardList.do?page=<%=paging.getEndPage()+1%>">Next</a>
			</li>
			<%}
			else {%>
			<li class="page-item disabled">
				<span class="page-link">Next</span>
			</li>
			<%}%>
		</ul>
	</nav>
	<!-- paging -->
<jsp:include page="../includes/footer.jsp"></jsp:include>