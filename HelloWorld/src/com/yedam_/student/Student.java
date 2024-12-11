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
	
	// 디폴트 생성자
	public Student() {}
	
	// 커스텀 생성자
	public Student(int studentNum) {
		this.studentNum = studentNum;
	}
	
	public Student(int studentNum, String studentName) {
		this(studentNum);
		this.studentName = studentName;
	}
	
	public Student(int studentNum, String studentName, int englishScore, int mathScore) {
		this(studentNum, studentName);
		this.englishScore = englishScore;
		this.mathScore = mathScore;
	}
}
