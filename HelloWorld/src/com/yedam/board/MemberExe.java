package com.yedam.board;

/*
 * 회원가입, 회원정보수정, 목록
 */
public class MemberExe {
	private Member[] storage; // 필드.
	
	// 생성자
	public MemberExe() {
		storage = new Member[10];
		storage[0] = new Member("user01", "1111", "홍길동", "010-1111-1111");
		storage[1] = new Member("user02", "2222", "박민석", "010-2222-2222");
		storage[2] = new Member("user03", "3333", "최주찬", "010-3333-3333");
	}
	
	// 메소드.
	// 1.등록.
	public boolean addMember(Member member) {
		for (int i = 0; i < storage.length; i++) {
			if (storage[i] == null) {
				storage[i] = member;
				return true;	// 등록ok.
			}
		}
		return false;	// 등록fail.
	}
	
	// 2.목록.
	public Member[] memberList() {
		return storage;
	}
	
	// 3.아이디 & 비밀번호 => 존재여부 반환
	public boolean login(String id, String pw) {
		for (int i = 0; i < storage.length; i++) {
			Member mem = storage[i];
			if (mem != null && mem.getMemberId().equals(id) && mem.getPassword().equals(pw)) {
				return true;
			}
		}
		return false;
	}
}