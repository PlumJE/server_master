package com.yedam.api;

import java.util.Date;

public class StringTest {
	public static void main(String[] args) {
		test1();
		test2();
		test3();
		test4();
	}

	static void test1() {
		// 현재 시간을 yyyy/MM/dd hh:mm:ss 로 출력.
		Date now = new Date();
		answer1(now);
	}
	static void answer1(Date today) {
		String year = String.valueOf(today.getYear() + 1900);// 1900년부터 시작하기 때문이다!!
		String month = String.valueOf(today.getMonth() + 1);// 월
		String date = String.valueOf(today.getDate());		// 일
		String hour = String.valueOf(today.getHours());		// 시
		String minute = String.valueOf(today.getMinutes());	// 분
		String second = String.valueOf(today.getSeconds());	// 초
		
		System.out.printf("%s/%s/%s %s:%s:%s\n", year, month, date, hour, minute, second);
	}
	
	static void test2() {
		// 주민번호를 받아서 성별을 구별하는 프로그램.
		String[] numbers = { "9501231234567", "950405 2345678", "980102-0345678" };
		for (int i = 0; i < numbers.length; i++) {
			String result = answer2(numbers[i]);
			System.out.println(numbers[i] + "는 " + result + "입니다.");
		}
	}
	static String answer2(String ssn) {
		int index = ssn.length() - 7;
		switch (ssn.charAt(index)) {
		case '1': case '3':
			return "남자";
		case '2': case '4':
			return "여자";
		default:
			return "에러";
		}
	}
	
	static void test3() {
		// 파일의 확장자를 구하는 코드.
		String[] files = { "c:/temp/rose.jpg", "d:/download/new.txt", "temp/good.jpeg" };
		for (int i = 0; i < files.length; i++) {
			String result = answer3(files[i]);
			System.out.println(files[i] + "의 확장자는 " + result + "입니다.");
		}
	}
	static String answer3(String name) {
		int index = name.indexOf(".");
		return name.substring(index + 1);
	}
	
	static void test4() {
		// 파일의 이름을 구하는 코드.
		String[] files = { "c:/temp/rose.jpg", "d:/download/new.txt", "temp/good.jpeg" };
		for (int i = 0; i < files.length; i++) {
			String result = answer4(files[i]);
			System.out.println("파일 이름은 " + result + "입니다.");
		}
	}
	static String answer4(String name) {
		int startPos = name.lastIndexOf("/");
		int endPos = name.indexOf(".");
		return name.substring(startPos + 1, endPos);
	}
}