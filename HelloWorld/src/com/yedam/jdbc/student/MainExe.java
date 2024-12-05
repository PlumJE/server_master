package com.yedam.jdbc.student;

import java.util.ArrayList;
import java.util.Scanner;

public class MainExe {
	public static void main(String[] args) {
		boolean run = true;
		Scanner scn = new Scanner(System.in);
		// db 처리기능.
		StudentDAO dao = new StudentDAO();
		while (run) {
			System.out.print("==================================\n");
			System.out.print("1.목록 2.등록 3.점수등록 4.삭제 9.종료\n");
			System.out.print("선택>> ");
			int menu = Integer.parseInt(scn.nextLine());
			
			switch (menu) {
			case 1:
				System.out.print("조건식 입력(스킵 가능)>> ");
				String condition = scn.nextLine();
				ArrayList<String> stdNoList = dao.studentList(condition);
				
				System.out.println("학생번호 이름  전화번호        영어 수학 등록시간");
				for (String stdNo : stdNoList) { // 학생번호, 이름, 연락처
					Student std = dao.selectStudent(stdNo);
					if (std == null)
						continue;
					System.out.println(std.showInfo());
				}
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
}
