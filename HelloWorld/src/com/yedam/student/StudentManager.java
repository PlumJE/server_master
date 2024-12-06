package com.yedam.student;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

/*
 * CRUD 처리.
 * 1.추가 2.목록 3.수정(영어, 수학) 4.삭제 9.종료
 */
public class StudentManager {
	static Student[] students = new Student[10];	// 친구정보 저장할 수 있는 공간 10개 확보.
	
	public static void main(String[] args) {
		//another();
		init();
		
		boolean run = true;
		Scanner scn = new Scanner(System.in);
		int newnum = 3;
		
		while (run) {
			System.out.println("1.추가 2.목록 3.조회 4.수정 5.삭제 6.상세조회(합계,평균) 7.합계점수기준 정렬 9.종료");
			System.out.print("선택>>");
			
			int menu = scn.nextInt();
			switch (menu) {
			case 1: // 추가.
				System.out.print("이름 입력>>");
				String name = scn.next();
				System.out.print("영어점수 입력 >>");
				int english_score = scn.nextInt();
				System.out.print("수학점수 입력 >>");
				int math_score = scn.nextInt();
				
				for (int i = 0; i < students.length; i++) {
					if (students[i] == null) {		// 비어있는 위치에 저장.
						students[i] = new Student(newnum++, name, english_score, math_score);	// 인스턴스 생성
						System.out.println("등록 완료!");
						break;
					}
				}
				break;
			case 2: // 목록.
				for (int i = 0; i < students.length; i++) {
					if (students[i] != null) {
						System.out.printf("%3d %20s %3d %3d\n", students[i].studentNum, 
								students[i].studentName, students[i].englishScore, students[i].mathScore);
					}
				}
				break;
			case 3: // 조회.
				System.out.print("번호 입력>>");
				int searchnum = scn.nextInt();
				
				for (int i = 0; i < students.length; i++) {
					if (students[i] != null && students[i].studentNum == searchnum) {
						System.out.printf("%3d %20s %3d %3d\n",
								students[i].studentNum, 
								students[i].studentName, 
								students[i].englishScore, 
								students[i].mathScore);
						break;	// for 반복문 종료
					}
					else if (i == students.length - 1) {
						System.out.println("그런 친구 못 찾겠습니다.");
					}
				}
				break;
			case 4: // 수정 => 이름, 연락처 입력
				System.out.print("번호 입력>>");
				int num = scn.nextInt();
				System.out.print("이름 입력>>");
				String name1 = scn.next();
				System.out.print("영어점수 입력>>");
				int english_score1 = scn.nextInt();
				System.out.print("수학점수 입력>>");
				int math_score1 = scn.nextInt();
				
				// 10개 중에서 6개 저장, 4개 null
				for (int i = 0; i < students.length; i++) {
					if (students[i] != null && students[i].studentNum == num) {
						students[i].studentName = name1;
						students[i].englishScore = english_score1;
						students[i].mathScore = math_score1;
						System.out.println("수정되었습니다.");
						break;	// for 반복문 종료
					}
					else if (i == students.length - 1) {
						System.out.println("그런 친구 못 찾겠습니다.");
					}
				}
				break;
			case 5: // 삭제
				System.out.print("번호 입력>>");
				int num1 = scn.nextInt();
				
				// 10개 중에서 6개 저장, 4개 null
				for (int i = 0; i < students.length; i++) {
					if (students[i] != null && students[i].studentNum == num1) {
						students[i] = null;
						System.out.println("삭제되었습니다.");
						break;
					}
					else if (i == students.length - 1) {
						System.out.println("그런 친구 못 찾겠습니다.");
					}
				}
				break;
			case 6: // 상세조회
				System.out.print("번호 입력>>");
				int searchnum1 = scn.nextInt();
				
				int sum;
				double avg;
				for (int i = 0; i < students.length; i++) {
					if (students[i] != null && students[i].studentNum == searchnum1) {
						sum = students[i].englishScore + students[i].mathScore;
						avg = sum / 2.0;
						System.out.printf("%3d %20s %3d %3d\n",
								students[i].studentNum, 
								students[i].studentName, 
								students[i].englishScore, 
								students[i].mathScore);
						System.out.printf("합계는 %d, 평균은 %f\n", sum, avg);
						break;	// for 반복문 종료
					}
					else if (i == students.length - 1) {
						System.out.println("그런 친구 못 찾겠습니다.");
					}
				}
				break;
				
			case 7: // 합계기준으로 정렬
				Arrays.sort(students, new Comparator<Student>() {
					@Override
					public int compare(Student a, Student b) { // a는 앞의 수 b는 뒤의 수
				        if (a == null || b == null) {
				        	return 0;
				        }
						int a_sum = a.englishScore + a.mathScore;
				        int b_sum = b.englishScore + b.mathScore;
				        return b_sum - a_sum;
				    }
				});
				
				int sum1;
				double avg1;
				for (int i = 0; i < students.length; i++) {
					if (students[i] != null) {
						sum1 = students[i].englishScore + students[i].mathScore;
						avg1 = sum1 / 2.0;
						System.out.printf("%3d %20s %3d %3d\n",
								students[i].studentNum, 
								students[i].studentName, 
								students[i].englishScore, 
								students[i].mathScore);
						System.out.printf("합계는 %d, 평균은 %f\n", sum1, avg1);
					}
				}
				break;
			case 9: // 종료.
				run = false;
				break;	// switch 종료.
			default:
				System.out.println("메뉴를 다시 선택하세요");
			} // end of switch.
		} // end of while
	}
	
	static void init() {
		students[0] = new Student(1);
		students[0].studentName = "홍길동";
		students[0].englishScore = 90;
		students[0].mathScore = 80;

		students[1] = new Student(2);
		students[1].studentName = "박문식";
		students[1].englishScore = 70;
		students[1].mathScore = 78;
	}
}
