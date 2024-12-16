<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	import="java.util.List"
	import="com.yedam.vo.Board"
	import="com.yedam.common.PageDTO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../../includes/header.jsp"></jsp:include>

<h3>글목록(boardList.jsp)</h3>
<form action="boardList.do">
	<div class="row">
		<div class="col-sm-4">
			<select name="searchCondition" class="form-control">
				<option value="">선택하세요</option>
				<option value="T" ${!empty searchCondition && searchCondition.equals('T') ? 'selected' : ''}>제목</option>
				<option value="W" ${!empty searchCondition && searchCondition.equals('W') ? 'selected' : ''}>작성자</option>
				<option value="TW" ${!empty searchCondition && searchCondition.equals('TW') ? 'selected' : ''}>제목 & 작성자</option>
			</select>
		</div>
		<div class="col-sm-6">
			<input type="text" name="keyword" class="form-control" value=${!empty keyword ? keyword : ""}>
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
		<c:forEach var="bvo" items="${boardList}">
			<tr>
				<td align="center">
					<a href="board.do?board_no=${bvo.boardNo}&page=${paging.currentPage}&searchCondition=${!empty searchCondition ? searchCondition : ''}&keyword=${!empty keyword ? keyword : ''}">
						${bvo.boardNo}
					</a>
				</td>
				<td><c:out value="${bvo.title}"/></td>
				<td><c:out value="${bvo.writer}"/></td>
				<td>${bvo.creationDate}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<!-- paging -->
<nav aria-label="...">
	<ul class="pagination">
		<c:choose>
			<c:when test="${paging.prev}">
				<li class="page-item">
					<a class="page-link" href="boardList.do?page=${paging.leftestPage - 1}&searchCondition=${!empty searchCondition ? searchCondition : ''}&keyword=${!empty keyword ? keyword : ''}">Previous</a>
				</li>
			</c:when>
			<c:otherwise>
				<li class="page-item disabled">
					<span class="page-link">Previous</span>
				</li>
			</c:otherwise>
		</c:choose>
		
		<c:forEach var="p" begin="${paging.leftestPage}" end="${paging.rightestPage}">
			<c:choose>
				<c:when test="${paging.currentPage == p}">
					<li class="page-item active" aria-current="page">
						<span class="page-link">${p}</span>
					</li>
				</c:when>
				<c:otherwise>
					<li class="page-item"><a class="page-link" href="boardList.do?page=${p}&searchCondition=${!empty searchCondition ? searchCondition : ''}&keyword=${!empty keyword ? keyword : ''}">${p}</a></li>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		
		<c:choose>
			<c:when test="${paging.next}">
				<li class="page-item">
					<a class="page-link" href="boardList.do?page=${paging.rightestPage + 1}&searchCondition=${!empty searchCondition ? searchCondition : ''}&keyword=${!empty keyword ? keyword : ''}">Next</a>
				</li>
			</c:when>
			<c:otherwise>
				<li class="page-item disabled">
					<span class="page-link">Next</span>
				</li>
			</c:otherwise>
		</c:choose>
	</ul>
</nav>
<!-- paging -->

<jsp:include page="../../includes/footer.jsp"></jsp:include>