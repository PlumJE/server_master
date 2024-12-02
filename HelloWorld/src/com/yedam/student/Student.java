package com.yedam.student;

/*
 * 학생의 성적관리 Prog.
 * 학생번호, 학생이름, 영어점수, 수학점수
 * 
 */
public class Student {
	// 필드 == 클래스의 멤버변수
	public int studentNum;
	public String studentName;
	public int englishScore;
	public int mathScore;
	
	// 컴파일러가 디폴트생성자를 암묵적으로 만들어준다.
	// public Student() {}
	
	// 커스텀 생성자
	public Student(int studentNum) {
		this.studentNum = studentNum;
	}
	
	public Student(int studentNum, String studentName) {
		this.studentNum = studentNum;
		this.studentName = studentName;
	}
	
	public Student(int studentNum, String studentName, int englishScore, int mathScore) {
		this.studentNum = studentNum;
		this.studentName = studentName;
		this.englishScore = englishScore;
		this.mathScore = mathScore;
	}
	
	// 메소드 == 클래스의 멤버함수
	public void smile() {
		System.out.println("학생이 웃습니다.");
	}
	
	public void introduce() {
		System.out.println("이름은 " + studentName + "이고 학번은" + studentNum);
	}
	
	public int sumScore() {
		return englishScore + mathScore;
	}
	
	public double avgScore() {
		return sumScore() / 2.0;
	}
}
