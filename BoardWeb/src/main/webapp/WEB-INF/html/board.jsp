<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	import="com.yedam.vo.BoardVO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../../includes/header.jsp"></jsp:include>

<h3>글상세화면(board.jsp)</h3>
<!-- 파라미터 추가작업. 2024.12.12 -->
<form action="modifyForm.do">
	<input type="hidden" name="board_no" value="${board.boardNo}">
	<input type="hidden" name="searchCondition" value="${searchCondition}">
	<input type="hidden" name="keyword" value="${keyword}">
	<input type="hidden" name="page" value="${page}">
	<table class="table">
		<thead>
			<tr>
				<th>글번호</th><th>제목</th><th>작성자</th><th>작성일시</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td align="center">${board.boardNo}</td>
				<td>${board.title}</td>
				<td>${board.writer}</td>
				<td>${board.creationDate}</td>
			</tr>
			<tr>
				<td><img src="images/${board.img}"></td>
			</tr>
			<tr>
				<td colspan="4">${board.content}</td>
			</tr>
			<tr>
				<c:if test="${!empty logId && board.writer.equals(logId)}">
					<td colspan="4" align="center">
						<input type="submit" class="btn btn-warning" value="게시글수정">
					</td>
				</c:if>
			</tr>
		</tbody>
	</table>
</form>

<!-- 댓글 부분 -->
<style>
	div.reply .content ul{
		list-style-type: none;
	}
	div.reply .content span{
		display: inline-block;
	}
</style>
<div class="reply">
	<!-- 댓글 등록 -->
	<div class="header">
		댓글내용: <input type="text" class="col-sm-8" id="reply">
		<button class="col-sm-2 btn btn-primary" id="addBtn">댓글등록</button>
	</div>
	<!-- 댓글 목록 -->
	<div class="content">
		<ul>
			<li>
				<!-- span class="col-sm-2">글번호</span -->
				<span class="col-sm-8">내용</span>
				<span class="col-sm-1">작성자</span>
				<span class="col-sm-2"></span>
			</li>
		</ul>
		<ul class="list">
		</ul>
	</div>
	<!-- 댓글 paging -->
	<div class="footer"></div>
</div>
<script>
	let bno = "${board.boardNo}";
	let logId = "${logId}";
</script>
<script src="js/board.js"></script>

<jsp:include page="../../includes/footer.jsp"></jsp:include>