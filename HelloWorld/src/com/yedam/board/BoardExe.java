package com.yedam.board;
import java.util.Date;

/*
 * 1.등록 2.목록
 */
public class BoardExe {
	private Board[] storage;	// 필드.
	
	public BoardExe() {	// 초기화.
		storage = new Board[10];
		storage[0] = new Board(3, "파이썬은 재밌어", "열심히 합시다", "user01", new Date());
		storage[1] = new Board(2, "오늘은 화요일", "3일이나 남았네", "user02", new Date());
		storage[9] = new Board(1, "프로그래밍", "재미있네", "user03", new Date());
	}
	
	// 게시글 등록.
	public boolean insertBoard(Board board) {
		for (int i = 0; i < storage.length; i++) {
			if (storage[i] == null) {
				storage[i] = board;
				return true;
			}
		}
		return false;
	}
	
	// 목록
	public Board[] boardList() {
		// 정렬.
		for (int i = 0; i < storage.length - 1; i++) {
			for (int j = 0; j < storage.length - 1; j++) {
				Board temp;
				if (storage[j] == null || storage[j + 1] == null || storage[j].getBoardNo() <= storage[j + 1].getBoardNo()) {
					continue;
				}
				// 위치변경 [i] <--> [i+1]
				temp = storage[j];
				storage[j] = storage[j + 1];
				storage[j + 1] = temp;
			} // end of 1st for
		} // end of 2nd for
		return storage;
	}
	
	// 글번호 가져오는 메소드.
	// null이 아닌 카운트에 +1 한 값을 반환. (X)
	// boardNo의 max값에 +1 한 값을 반환. (O)
	public int getNextNo() {
		int max = 1;
		for (int i = 0; i < storage.length; i++) {
			if (storage[i] != null && max < storage[i].getBoardNo()) {
				max = storage[i].getBoardNo();
			}
		}
		return max + 1;
	}
	
	// 글수정기능 => 매개값은 글번호+제목+내용, 반환값 true/false, updateBoard()
	public boolean updateBoard(int boardNum, String title, String content) {
		for (int i = 0; i < storage.length; i++) {
			if (storage[i] != null && storage[i].getBoardNo() == boardNum) {
				storage[i].setTitle(title);
				storage[i].setContent(content);
				return true;
			}
		}
		return false;
	}
	
	// 글삭제기능 => 매개값은 글번호, 반환값은 true/false, deleteBoard
	public boolean deleteBoard(int boardNum) {
		for (int i = 0; i < storage.length; i++) {
			if (storage[i] != null && storage[i].getBoardNo() == boardNum) {
				storage[i] = null;	// 삭제는 null값을 대입.
				return true;
			}
		}
		return false;
	}
	
	// 삭제, 수정 권한 있는지 체크 => 매개값은 글번호, 작성자, 반환값은 true/false
	// checkResponsibility()
	protected boolean checkResponsibility(int boardNum, String writer) {
		for (Board temp : storage) {
			if (temp != null && temp.getBoardNo() == boardNum && temp.getWriter().equals(writer)) {
				return true;
			}
		}
		return false;
	}
}
