<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8' />
<script src='./dist/index.global.js'></script>
<script>
	document.addEventListener('DOMContentLoaded', function() {
		fetch('fullData.do')
		.then(result => result.json())
		.then(result => {
			var calendarEl = document.getElementById('calendar');
			
			var calendar = new FullCalendar.Calendar(calendarEl, {
				headerToolbar: {
					left: 'prev,next today',
					center: 'title',
					right: 'dayGridMonth,timeGridWeek,timeGridDay'
				},
				initialDate: '2024-12-12',
				navLinks: true, // can click day/week names to navigate views
				selectable: true,
				selectMirror: true,
				select: function(arg) {
					var title = prompt('Event Title:');
					if (title) {
						// Ajax 호출.
						fetch('addEvent.do?a=' + title + '&b=' + arg.startStr + '&c=' + arg.endStr)
						.then(result => result.json())
						.then(result => {
							// 화면 출력.
							if (result.retCode == 'OK') {
								calendar.addEvent({
									title: title,
									start: arg.start,
									end: arg.end,
									allDay: arg.allDay
								})
							}	// end of retCode == 'OK'
						})
						.catch(err => console.log(err));
					}
					calendar.unselect();
				},
				eventClick: function(arg) {
					console.log(arg);
					var e = arg.event;
					if (confirm('Are you sure you want to delete this event?')) {
						fetch('deleteEvent.do?a=' + e.title + '&b=' + e.startStr + '&c=' + e.endStr)
						.then(result => result.json())
						.then(result => {
							if (result.retCode == 'OK') {
								console.log("DB에서 지우기 성공");
								arg.event.remove();
							}
						})
					}
				},
				editable: true,
				dayMaxEvents: true, // allow "more" link when too many events
				events: result // [{}, {}, {}, ...]
			});
			
			calendar.render();
		})
		.catch(err => console.log(err));
	});
</script>
<style>
	body {
	  margin: 40px 10px;
	  padding: 0;
	  font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
	  font-size: 14px;
	}
	
	#calendar {
	  max-width: 1100px;
	  margin: 0 auto;
	}
</style>
</head>
<body>
	<div id='calendar'></div>
</body>
</html>
