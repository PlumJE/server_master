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

<jsp:include page="../../includes/footer.jsp"></jsp:include>