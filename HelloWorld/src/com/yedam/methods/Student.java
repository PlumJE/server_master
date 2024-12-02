package com.yedam.methods;

/*
 * 학생의 성적관리 Prog.
 * 학생번호, 학생이름, 영어점수, 수학점수
 * 
 */
public class Student {
	// 필드 == 클래스의 멤버변수
	private int studentNum;
	private String studentName;
	private int englishScore;
	private int mathScore;
	
	// 생성자.
	public Student(int studentNum, String studentName, int englishScore, int mathScore) {
		super();
		this.studentNum = studentNum;
		this.studentName = studentName;
		this.englishScore = englishScore;
		this.mathScore = mathScore;
	}

	// getter, setter. 메소드.
	public int getStudentNum() {
		return studentNum;
	}

	public void setStudentNum(int studentNum) {
		this.studentNum = studentNum;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getEnglishScore() {
		return englishScore;
	}

	public void setEnglishScore(int englishScore) {
		this.englishScore = englishScore;
	}

	public int getMathScore() {
		return mathScore;
	}

	public void setMathScore(int mathScore) {
		this.mathScore = mathScore;
	}
	
	// showInfo()
	public String showInfo() {
		return "학번: " + studentNum + ", 이름: " + studentName + ", 영어: " + englishScore + ", 수학: " + mathScore;
	}
}
