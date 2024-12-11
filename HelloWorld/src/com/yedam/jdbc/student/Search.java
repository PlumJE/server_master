package com.yedam.jdbc.student;

public class Search {
	private String name;
	private String phone;
	private int engScore = 0;
	private int mathScore = 0;
	private String orderBy = "std_no";
	public String getName() {
		return name;
	}
	public String getPhone() {
		return phone;
	}
	public int getEngScore() {
		return engScore;
	}
	public int getMathScore() {
		return mathScore;
	}
	public String getOrderBy() {
		return orderBy;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setEngScore(int engScore) {
		this.engScore = engScore;
	}
	public void setMathScore(int mathScore) {
		this.mathScore = mathScore;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	
	
}
