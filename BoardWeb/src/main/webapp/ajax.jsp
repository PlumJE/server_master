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
		console.log('1');
		fetch('fullData.do')
		.then(result => result.json())
		.then(result => {
			console.log('3');
		})
		.catch(err => console.log(err));
		console.log('2');
	</script>
</body>
</html>