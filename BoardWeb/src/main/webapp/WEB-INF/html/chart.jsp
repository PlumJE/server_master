<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
		<script type="text/javascript">
			let aryData = [
				['게시글번호', '댓글건수']
			];
			
			console.log('1');
			console.log('2');
			
			// Ajax(비동기처리방식);
			fetch('chartData.do')
			.then(result => result.json())
			.then(result => {
				console.log('2-1');	// 동기적 실행 때문에 얘가 가장 마지막에 실행
				result.forEach(item => {
					aryData.push([item.boardNo, item.cnt]);
				});
				google.charts.load('current', {'packages':['corechart']});
				google.charts.setOnLoadCallback(drawChart);
			})
			.catch(err => console.log(err));
			
			console.log('3');
			
			function drawChart() {
				var data = google.visualization.arrayToDataTable(aryData);
				var options = {
					title: 'My Daily Activities'
				};
				
				var chart = new google.visualization.PieChart(document.getElementById('piechart'));
				
				chart.draw(data, options);
			}
		</script>
	</head>
	<body>
		<div id="piechart" style="width: 900px; height: 500px;"></div>
	</body>
</html>
