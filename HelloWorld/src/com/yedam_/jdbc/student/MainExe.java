package com.yedam.jdbc.student;

import java.util.ArrayList;
import java.util.Scanner;

public class MainExe {
	static Scanner scn = new Scanner(System.in);
	// db 처리기능.
	static StudentDAO dao = new StudentDAO();
	
	public static void main(String[] args) {
		boolean run = true;
		
		while (true) {
			// 로그인 기능.
			System.out.print("id 입력>> ");
			String id = scn.nextLine();
			System.out.print("비밀번호 입력>> ");
			String password = scn.nextLine();
			
			// 로그인메소드 호출 login()
			String name = dao.login(id, password);
			if (name != null) {
				System.out.println(name + "님 환영합니다!");
				break;
			}
			else {
				System.out.println("다시 로그인하세요.");
			}
		}
		
		while (run) {
			System.out.print("================================\n");
			System.out.print("1.목록 2.등록 3.점수등록 4.삭제 9.종료\n");
			System.out.print("선택>> ");
			int menu = Integer.parseInt(scn.nextLine());
			
			switch (menu) {
			case 1:
				list();
				break;
			case 2:	// 등록.
				System.out.print("학생번호 입력>> ");
				String no = scn.nextLine();
				System.out.print("학생이름 입력>> ");
				String name = scn.nextLine();
				System.out.print("연락처 입력>> ");
				String phone = scn.nextLine();
				
				Student std = new Student();
				std.setStdNo(no);
				std.setStdName(name);
				std.setStdPhone(phone);
				
				if (dao.insertStudent(std)) {
					System.out.println("정상 등록.");
				}
				else {
					System.out.println("등록 실패.");
				}
				break;
			case 3:	// 수정.
				System.out.print("학생번호 입력>> ");
				no = scn.nextLine();
				System.out.print("영어점수 입력>> ");
				int escore = Integer.parseInt(scn.nextLine());
				System.out.print("수학점수 입력>> ");
				int mscore = Integer.parseInt(scn.nextLine());
				
				std = new Student();
				std.setStdNo(no);
				std.setEngScore(escore);
				std.setMathScore(mscore);
				
				if (dao.updateStudent(std)) {
					System.out.println("정상 수정");
				}
				else {
					System.out.println("수정 실패");
				}
				break;
			case 4:
				System.out.print("학생번호 입력>> ");
				no = scn.nextLine();
				
				std = new Student();
				std.setStdNo(no);
				
				if (dao.deleteStudent(std)) {
					System.out.println("정상 삭제");
				}
				else {
					System.out.println("삭제 실패");
				}
				break;
			case 9: // 종료.
				run = false;
			}
		}
		
		System.out.println("end of prog");
	} // end of main.
	
	public static void list() {
		System.out.println("1.학생이름 2.연락처 3.영어");
		System.out.print("선택>> ");
		int menu = Integer.parseInt(scn.nextLine());
		
		Search search = new Search();
		switch (menu) {
		case 1:
			System.out.print("검색할 이름>> ");
			String name = scn.nextLine();
			search.setName(name);
			break;
		case 2:
			System.out.print("검색할 연락처>> ");
			String phone = scn.nextLine();
			search.setPhone(phone);
			break;
		case 3:
			System.out.print("검색할 영어점수>> ");
			int escore = Integer.parseInt(scn.nextLine());
			search.setEngScore(escore);
			break;
		} // end of switch
		
		System.out.println("1.학생번호정렬 2.학생이름정렬");
		System.out.print("선택>> ");
		int orderBy = Integer.parseInt(scn.nextLine());
		
		// 정렬조건 추가.
		switch (orderBy) {
		case 1:
			search.setOrderBy("std_no");
			break;
		case 2:
			search.setOrderBy("std_name");
			break;
		}
		
		ArrayList<String> stdNoList = dao.studentList(search);
		System.out.println("학생번호 이름  전화번호        영어 수학 등록시간");
		for (String stdNo : stdNoList) { // 학생번호, 이름, 연락처
			Student std = dao.selectStudent(stdNo);
			if (std == null)
				continue;
			System.out.println(std.showInfo());
		}
	} // end of list().
}
