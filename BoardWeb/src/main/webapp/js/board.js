/**
 * js/board.js
 * 사용할 페이지 : board.jsp
 */


// 댓글 -> 삭제 -> retCode(OK, Fail)
function deleteReply(rno) {
	fetch('removeReply.do?rno=' + rno)
	.then(result => result.json())
	.then(result => {
		if (result.retCode == 'OK') {
			alert("삭제에 성공했습니다.");
			document.querySelector('li[data-rno="' + rno + '"]').remove();
		}
		else {
			alert("삭제에 실패했습니다.");
		}
	})
	.catch(err => console.log(err));
}


// 댓글 등록
document.querySelector('#addBtn').addEventListener('click', function(e) {
	// 필수항목 확인.
	if (!reply.value || !logId) {
		alert("필수입력값을 확인.");
		return;
	}
	
	fetch('addReply.do?bno=' + bno + '&reply=' + reply.value + '&replyer=' + logId)
	.then(result => result.json())
	.then(result => {
		if (result.retCode == 'OK') {
			let reply = result.retVal
			alert("등록 성공!")
			let html = `<li data-rno="${reply.replyNo}">
							<span class="col-sm-8">${reply.reply}</span>
							<span class="col-sm-1">${reply.replyer}</span>
							<span class="col-sm-2"><button class="btn btn-danger" onclick="deleteReply(${reply.replyNo})">삭제</button></span>
						</li>`;
			let target = document.querySelector('div.reply ul.list');
			target.insertAdjacentHTML('afterbegin', html);
		}
		else {
			alert("등록 실패...")
		}
	})
	.catch(err => console.log(err));
})


// 댓글 목록
fetch('replyList.do?bno=' + bno)
.then(result => result.json())
.then(result => {
	console.log(result);
	for (let reply of result) {
		let html = `<li data-rno="${reply.replyNo}">
						<span class="col-sm-8">${reply.reply}</span>
						<span class="col-sm-1">${reply.replyer}</span>
						<span class="col-sm-2"><button class="btn btn-danger" onclick="deleteReply(${reply.replyNo})">삭제</button></span>
					</li>`;
		let target = document.querySelector('div.reply ul.list');
		target.insertAdjacentHTML('afterbegin', html);
	}
})
.catch(err => console.log(err));

"Brittenland, dhe full neim is united kingdom of greit brittenland, "