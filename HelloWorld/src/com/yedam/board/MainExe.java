package com.yedam.board;
import java.util.Scanner;
import java.util.Date;

public class MainExe {
	static Scanner scn = new Scanner(System.in);	// 필드
	static BoardExe bexe = new BoardExe();
	
	public static void main(String[] args) {
		boolean run = true;
		
		MemberExe mexe = new MemberExe();	// 인스턴스.
		
		while (run) {
			System.out.println("1.회원등록 2.목록 3.게시판 9.종료");
			System.out.print("선택>>");
			int menu = Integer.parseInt(scn.nextLine());
			
			switch(menu) {
			case 1:
				System.out.print("회원아이디>> ");
				String id = scn.nextLine();
				System.out.print("회원비밀번호>> ");
				String pw = scn.nextLine();
				System.out.print("회원이름>> ");
				String name = scn.nextLine();
				System.out.print("회원연락처>> ");
				String phone = scn.nextLine();
				
				boolean result = mexe.addMember(new Member(id, pw, name, phone));
				if (result == true) {
					System.out.println("정상 등록되었습니다");
				}
				else {
					System.out.println("등록 처리되지 않았습니다");
				}
				break;
			case 2:
				Member[] list = mexe.memberList();
				for (Member member : list) {
					if (member != null) {
						System.out.println(member.showInfo());
					}
				}
				break;
			case 3:
				// 게시판 관련.
				System.out.print("회원아이디>> ");
				id = scn.nextLine();
				System.out.print("회원비밀번호>> ");
				pw = scn.nextLine();
				if (mexe.login(id, pw)) {	// id와 pw를 체크.
					boardMethod(id);		// 로그인된 사용자 아이디를 활용.
				}
				else {
					System.out.println("id와 pw을 확인하세요");
				}
				break;
			case 9:
				run = false;
				break;
			}
		} // end of while.
		
		System.out.println("프로그램 끝.");
	} // end of main.
	
	// 게시판 관련.
	public static void boardMethod(String id) {
		// 1.추가 2.목록 3.수정 4.삭제 9.상위메뉴 이동
		while (true) {
			System.out.println("1.추가 2.목록 3.수정 4.삭제 9.상위메뉴 이동");
			System.out.println("선택>>");
			int menu = Integer.parseInt(scn.nextLine());
			
			switch (menu) {
			case 1:	// 추가
//				System.out.print("글번호 입력>> ");
//				int bno = Integer.parseInt(scn.nextLine());
				int bno = bexe.getNextNo();
				System.out.print("글제목 입력>> ");
				String title = scn.nextLine();
				System.out.print("글내용 입력>> ");
				String content = scn.nextLine();
//				System.out.print("작성자 입력>> ");
//				String writer = scn.nextLine();
				String writer = id;
//				System.out.print("작성일시 입력>> ");
//				String wdate = scn.nextLine();
				Date wdate = new Date();
				
				Board board = new Board(bno, title, content, writer, wdate);
				if (bexe.insertBoard(board)) {
					System.out.println("게시글 등록 완료");
				}
				else {
					System.out.println("게시글 등록 실패");
				}
				break;
			case 2:	// 목록
				Board[] list = bexe.boardList();
				for (Board brd : list) {
					if (brd != null) {
						System.out.println(brd.showInfo());
					}
				}
				break;
			case 3:	// 수정(제목, 내용) => bno, title, content : Board 타입.
				System.out.print("수정할 글번호 입력>> ");
				bno = Integer.parseInt(scn.nextLine());
				// 글에 대한 권한 체크
				if (!bexe.checkResponsibility(bno, id)) {
					System.out.println("해당글의 권한을 확인하세요.");
					break;
				}
				// 글 수정 메소드 호출.
				System.out.print("글제목 입력>> ");
				title = scn.nextLine();
				System.out.print("글내용 입력>> ");
				content = scn.nextLine();
				if (bexe.updateBoard(bno, title, content)) {					
					System.out.println("정상적으로 삭제되었습니다");
				}
				else {
					System.out.println("수정할 글번호를 확인하세요");
				}
				break;
			case 4:	// 삭제.
				System.out.print("삭제할 글번호 입력>> ");
				bno = Integer.parseInt(scn.nextLine());
				// 글에 대한 권한 체크
				if (!bexe.checkResponsibility(bno, id)) {
					System.out.println("해당글의 권한을 확인하세요.");
					break;
				}
				// 글 삭제 메소드 호출.
				if (bexe.deleteBoard(bno)) {					
					System.out.println("정상적으로 삭제되었습니다");
				}
				else {
					System.out.println("삭제할 글번호를 확인하세요");
				}
				break;
			case 9:	// 상위메뉴(회원관련 메뉴)
				return;
			}
		}
	} // end of boardMethod.
} // end of class.
