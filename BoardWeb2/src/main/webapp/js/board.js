/**
 * js/board.js
 * 사용할 페이지 : board.jsp
 */


// 페이지 정보 지정.
let rpage = 1;


// 댓글정보 -> row 생성
function makeRow(reply = {}) {
	let html = `<li data-rno="${reply.replyNo}">
					<span class="col-sm-8">${reply.reply}</span>
					<span class="col-sm-1">${reply.replyer}</span>
					<span class="col-sm-2"><button class="btn btn-danger" onclick="deleteReply(${reply.replyNo})">삭제</button></span>
				</li>`;
	let target = document.querySelector('div.reply ul.list');
	target.insertAdjacentHTML('afterbegin', html);	// target 태그의 <tag><li/><li/><li/><li/></tag>
}


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


// 댓글 목록 5건씩 출력
function showReplyList() {
	fetch('replyList.do?bno=' + bno + '&rpage=' + rpage)
	.then(result => result.json())
	.then(result => {
		// 기존목록 clear
		document.querySelector('ul.list').innerHTML = '';
		for (let reply of result) {
			makeRow(reply);
		}
		// 페이지 생성
		createPageList();
	})
	.catch(err => console.log(err));
}


// 글번호 -> 전체건수를 활용해서 페이지 계산하는 함수.
function createPageList() {
	fetch('getCount.do?bno=' + bno)
	.then(result => result.json())
	.then(result => {
		let totalCnt = result.replyCount;	// 댓글 전체 건수
		// 이전, 이후 페이지여부, 첫번째 ~ 마지막 페이지.
		let prev, next; // 이전, 이후
		let startPage, endPage, realEnd;
		endPage = Math.ceil(rpage / 10) * 10;	// 현재페이지 기준으로 마지막페이지 계산
		startPage = endPage - 9;				// 마지막페이지 - 9 => 첫페이지.
		
		if (startPage > 1) {
			prev = true;
		}
		
		realEnd = Math.ceil(totalCnt / 5);
		if (endPage >= realEnd) {	// 현재 13 20
			endPage = realEnd;
		}
		else {						// 이후 목록의 존재?
			next = true;
		}
		
		// 목록 작성
		let pagination = document.querySelector('ul.pagination');
		pagination.innerHTML = '';
		// 이전페이지
		if (prev) {
			let html = `<li class="page-item" data-page="${startPage - 1}">
							<a class="page-link" href="#" aria-label="Previous">
								<span aria-hidden="true">&laquo;</span>
							</a>
						</li>`;
			pagination.insertAdjacentHTML('beforeend', html);
		}
		// 목록건수(for 반복문)
		for (let p = startPage; p <= endPage; p++) {
			let html;
			if (p == rpage) {
				html = `<li class="page-item active" data-page="${p}">
							<a class="page-link" href="#">${p}</a>
						</li>`;
			}
			else {
				html = `<li class="page-item" data-page="${p}">
							<a class="page-link" href="#">${p}</a>
						</li>`;
			}
			pagination.insertAdjacentHTML('beforeend', html);
		}
		// 이후페이지
		if (next) {
			let html = `<li class="page-item" data-page="${endPage + 1}">
							<a class="page-link" href="#" aria-label="Next">
								<span aria-hidden="true">&raquo;</span>
							</a>
						</li>`;
			pagination.insertAdjacentHTML('beforeend', html);
		}
		
		// 페이징 a 태그의 클릭.
		document.querySelectorAll('ul.pagination a').forEach(item => {
			item.addEventListener('click', function(e) {
				e.preventDefault();	// 기본기능 차단
				// 목록 출력.
				rpage = item.parentElement.getAttribute('data-page');
				showReplyList();
			})
		})
	})
	.catch(err => console.log(err));
}	// end of createPageList


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
			let reply = result.retVal;
			alert("등록 성공!");
			makeRow(reply);
		}
		else {
			alert("등록 실패...");
		}
	})
	.catch(err => console.log(err));
})


// 댓글 목록
showReplyList();