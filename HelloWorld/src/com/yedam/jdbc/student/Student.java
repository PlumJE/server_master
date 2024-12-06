package com.yedam.jdbc.student;

/*
 * tbl_student의 칼럼을 필드로 선언.
 * std_no => stdNo;
 */
public class Student {
	private String stdNo;
	private String stdName;
	private String stdPhone;
	private int engScore;
	private int mathScore;
	private String creationDate;
	public String getStdNo() {
		return stdNo;
	}
	public String getStdName() {
		return stdName;
	}
	public String getStdPhone() {
		return stdPhone;
	}
	public int getEngScore() {
		return engScore;
	}
	public int getMathScore() {
		return mathScore;
	}
	public String getCreationDate() {
		return creationDate;
	}
	public void setStdNo(String stdNo) {
		this.stdNo = stdNo;
	}
	public void setStdName(String stdName) {
		this.stdName = stdName;
	}
	public void setStdPhone(String stdPhone) {
		this.stdPhone = stdPhone;
	}
	public void setEngScore(int engScore) {
		this.engScore = engScore;
	}
	public void setMathScore(int mathScore) {
		this.mathScore = mathScore;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	public String showInfo() {
		return stdNo + " " + stdName + " " + stdPhone + " " + engScore + "  " + mathScore + " " + creationDate;
	}
}
