/**
 * js/board.js
 * 사용할 페이지 : board.jsp
 */
console.log('start');

// 댓글 목록
fetch('replyList.do?bno=' + bno)
.then(result => result.json())
.then(result => {
	console.log(result);
	for (let reply of result) {
		let html = `<li>
						<span class="col-sm-2">${reply.replyNo}</span>
						<span class="col-sm-5">${reply.reply}</span>
						<span class="col-sm-2">${reply.replyer}</span>
						<span class="col-sm-2"><button>삭제</button></span>
					</li>`;
		let target = document.querySelector('div.reply ul');
		target.insertAdjacentHTML('beforeend', html);
	}
})
.catch(err => console.log(err));