package com.yedam.student;

public class StudentExe {
	public static void main(String[] args) {
		Student s1 = new Student(1);	// 실체 생성(인스턴스 생성)
		s1.studentName = "홍길동";
		s1.englishScore = 60;
		s1.mathScore = 70;
//		System.out.println(s1.studentNum + ", " + s1.studentName + 
//				"의 합계점수는 " + s1.sumScore() +
//				" 평균은 " + s1.avgScore());
		
		Student s2 = new Student(2, "김길동");
		s2.englishScore = 70;
		s2.mathScore = 75;
//		System.out.println(s2.studentNum + ", " + s2.studentName + 
//				"의 합계점수는 " + s2.sumScore() +
//				" 평균은 " + s2.avgScore());
		
		Student s3 = new Student(3, "최길동", 80, 90);
		System.out.println(s3.studentNum + ", " + s3.studentName + 
				", eng:" + s3.englishScore + 
				", math:" + s3.mathScore);
	}
}