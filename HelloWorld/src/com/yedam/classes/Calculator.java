package com.yedam.classes;
import com.yedam.student.Student;

public class Calculator {
	// 기본생성자. public Calculator() {}
	// 반환값 + 메소드이름 + 매개변수(...)
	int sum(int n1, int n2) {
		int result = n1 + n2;
		return result;
	}
	
	// 메소드 오버로딩
	double sum(double n1, double n2) {
		return n1 + n2;
	}
	
	// 메소드 내에서 return => 메소드의 종료.
	double max(double n1, double n2) {
		if (n1 >= n2) {
			return n1;
		}
		else {
			return n2;
		}
	}
	
	void printStar(int times) {
		for (int i = 1; i <= times; i++) {			
			System.out.print("★");
		}
		System.out.println();
	}
	
	int sumAry(int[] ary) {
		int result = 0;
		for (int i : ary) {
			result += i;
		}
		return result;
	}

	double averageAry(int[] intAry) {
		return (double) sumAry(intAry) / (double) intAry.length;
	}
	
	double max(int[] ary) {
		double result = ary[0];
		for (int i = 1; i < ary.length; i++) {
			if (result < ary[i]) {
				result = ary[i];
			}
		}
		return result;
	}
	
	// 매개값으로 Student[]을 활용해서 영어점수가 가장 높은 값을 반환.
	Student getMaxScore(Student[] ary) {
		Student result = ary[0];
		for (int i = 1; i < ary.length; i++) {
			if (result.englishScore < ary[i].englishScore) {
				result = ary[i];
			}
		}
		return result;
	}
}
