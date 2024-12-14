<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<!-- ajax.jsp -->
	<script>
		// Asyncronous Javascript And Xml => ajax
		fetch('replyList.do')
		.then(function(result) {
			console.log(result);
			return result.json();
		})
		.then(function(result) {
			console.log(result);
			let p = document.createElement('p');
			p.innerText = '이름:' + result.name + ', 나이:' + result.age;
			document.querySelector('body').appendChild(p);
		})
		.catch(function(err) {
			console.log(err);
		})
		;
	</script>
</body>
</html>