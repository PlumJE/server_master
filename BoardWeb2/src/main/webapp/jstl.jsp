<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<!-- 1.JSTL 라이브러리 있어야 -->
	<!-- 2.JSTL 태그 지시자 선언 -->
	<core:set var="myName" value="홍길동"></core:set>
	<core:out value="${myName}"></core:out>
	
	<!-- myAge라는 변수에 20이라는 값을 저장. -->
	<core:set var="myAge" value="20"></core:set>
	
	<!-- h3태그로 저장된 값을 출력. -->
	<h3><core:out value="${myAge}"></core:out></h3>
	
	<!-- 조건문. -->
	<core:if test="${myAge >= 20}">
		<p>성인입니다.</p>
	</core:if>
	<core:choose>
		<core:when test="${myAge >= 20}">
			<p>성인입니다</p>
		</core:when>
		<core:otherwise>
			<p>미성년입니다</p>
		</core:otherwise>
	</core:choose>
	
	<!-- score=85 저장. -->
	<!-- score가 90이상이면 A, 80이상이면 B, 70이상이면 C, 그외 D -->
	<core:set var="score" value="85"></core:set>
	<core:choose>
		<core:when test="${score >= 90}">
			<h1>A</h1>
		</core:when>
		<core:when test="${score >= 80}">
			<h1>B</h1>
		</core:when>
		<core:when test="${score >= 70}">
			<h1>C</h1>
		</core:when>
		<core:otherwise>
			<h1>D</h1>
		</core:otherwise>
	</core:choose>
	
	<!-- 반복문. for(int i=1; i<=10; i++) {...} -->
	<core:forEach var="i" begin="1" end="10" step="1">
		<core:if test="${i % 2 == 0}">
			<p><core:out value="8 * ${i} = ${8 * i}"/></p>
		</core:if>
	</core:forEach>
</body>
</html>