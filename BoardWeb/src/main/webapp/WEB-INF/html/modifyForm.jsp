<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	import="com.yedam.vo.Board"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../../includes/header.jsp"></jsp:include>

<h3>게시글 수정화면(modifyForm.jsp)</h3>
<!-- 파라미터 추가작업. 2024.12.12 -->
<form action="modifyForm.do" method="POST">
	<input type="hidden" name="board_no" value="${board.boardNo}">
	<input type="hidden" name="searchCondition" value="${searchCondition}">
	<input type="hidden" name="keyword" value="${keyword}">
	<input type="hidden" name="page" value="${page}">
	<table class="table">
		<tr>
			<th>글번호</th><td>${board.boardNo}</td>
			<th>작성자</th><td>${board.writer}</td>
		</tr>
		<tr>
			<th>제목</th>
			<td colspan="3"><input type="text" name="title" value="${board.title}"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan="3">
				<textarea rows="5" class="form-control" name="content">${board.content}</textarea>
			</td>
		</tr>
		<tr>
			<th>작성 일자</th><td>${board.creationDate}</td>
			<th>조회수</th><td>${board.viewCnt}</td>
		</tr>
		<tr>
			<td colspan="4" align="center">
				<input type="submit" class="btn btn-warning" value="게시글등록">
			</td>
		</tr>
	</table>
</form>
	
<jsp:include page="../../includes/footer.jsp"></jsp:include>