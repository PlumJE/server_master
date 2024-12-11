package com.yedam.methods;

public class StudentExe {
	public static void main(String[] args) {
		Student s1 = new Student(1, "홍길동", 70, 75);
		
//		s1.englishScore = 1000;
//		s1.setStudentName("홍길동");
//		s1.setEnglishScore(70);
//		s1.setMathScore(75);
		
		System.out.println(s1.showInfo());
	}
}