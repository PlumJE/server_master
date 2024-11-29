package com.yedam.reference;
import java.util.Scanner;

/*
 * 친구정보 저장 기능.
 * 1.추가 2.목록 9.종료
 */

public class FriendManager {
	public static void main(String[] args) {
		boolean run = true;
		Scanner scn = new Scanner(System.in);
		Friend[] storage = new Friend[10];	// 친구정보 저장할 수 있는 공간 10개 확보.
		
		storage[0] = new Friend();	// 반드시 요렇게 사용하세요!!!
		storage[0].friendName = "홍길동";
		storage[0].friendPhone = "010-1111-1111";
		storage[0].friendBirth = "1999-01-01";
		
		while (run) {
			System.out.println("1.추가 2.목록 3.조회(숙제) 9.종료");
			System.out.print("선택>>");
			
			int menu = Integer.parseInt(scn.nextLine());
			switch (menu) {
			case 1: // 추가.
				System.out.print("친구 이름 입력>>");
				String name = scn.nextLine();
				System.out.print("친구 연락처 입력 >>");
				String phone = scn.nextLine();
				System.out.print("친구 생일 입력 >>");
				String birth = scn.nextLine();
				
				for (int i = 0; i < storage.length; i++) {
					if (storage[i] == null) { // 비어있는 위치에 저장.
						storage[i] = new Friend();
						storage[i].friendName = name;
						storage[i].friendPhone = phone;
						storage[i].friendBirth = birth;
						System.out.println("등록 완료!");
						break;
					}
				}
				break;
			case 2: // 목록.
				for (int i = 0; i < storage.length; i++) {
					if (storage[i] != null) {
						System.out.printf("%4s %14s %14s\n", 
								storage[i].friendName, 
								storage[i].friendPhone, 
								storage[i].friendBirth);
					}
				}
				break;
			case 3: // 조회.
				System.out.print("찾는 친구 이름 입력>>");
				String searchname = scn.nextLine();
				boolean iFoundIt = false;
				
				int i;
				for (i = 0; i < storage.length; i++) {
					if (storage[i] != null && storage[i].friendName.equals(searchname)) {
						iFoundIt = true;
						break;
					}
				}
				
				if (iFoundIt) {
					System.out.printf("%4s %14s %14s\n", 
							storage[i].friendName, 
							storage[i].friendPhone,
							storage[i].friendBirth);
				}
				else {
					System.out.println("그런 친구 못 찾겠습니다.");
				}
				break;
			case 9: // 종료.
				run = false;
				break;	// switch 종료.
			default:
				System.out.println("메뉴를 다시 선택하세요");
			} // end of switch.
		} // end of while
		
		System.out.println("프로그램 끝");
	}
}