package com.yedam.api;

import java.io.UnsupportedEncodingException;

public class StringExe {
	public static void main(String[] args) {
		char_at();
		equals_();
		get_bytes();
		index_of();
		length_();
		replace_();
		substring_();
		toLowerUpperCase();
		trim_();
		value_of();
	}
	
	public static void char_at() {
		String residentNum = "970319-1698116";
		char sex = residentNum.charAt(7);
		switch (sex) {
		case '1': case '3':
			System.out.println("남자 입니다.");
			break;
		case '2': case '4':
			System.out.println("여자 입니다.");
			break;
		}
	}
	
	public static void equals_() {
		String strVar1 = "엄준식";
		String strVar2 = "엄준식";
		
		boolean result = strVar1 == strVar2;
		System.out.println("strVar1 == strVar2 : " + result);
		result = strVar1.equals(strVar2);
		System.out.println("strVar1.equals(strVar2) : " + result);
	}
	
	public static void get_bytes() {
		String str = "안녕하세요";
		byte[] bytes1 = str.getBytes();
		System.out.println("bytes1.length: " + bytes1.length);
		String str1 = new String(bytes1);
		System.out.println("bytes1->String: " + str1);
		
		try {
			byte[] bytes2 = str.getBytes("EUC-KR");
			System.out.println("bytes2.length: " + bytes2.length);
			String str2 = new String(bytes2, "EUC-KR");
			System.out.println("bytes2->String: " + str2);
			
			byte[] bytes3 = str.getBytes("UTF-8");
			System.out.println("bytes3.length: " + bytes3.length);
			String str3 = new String(bytes3, "UTF-8");
			System.out.println("bytes3->String: " + str3);
		}
		catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	public static void index_of() {
		String subject = "자바 프로그래밍";
		
		int location = subject.indexOf("프로그래밍");
		System.out.println(location);
		
		if (subject.indexOf("자바") != -1) {
			System.out.println("자바와 관련된 책이군요!");
		}
		else {
			System.out.println("자바와 관련없는 책이군요");
		}
	}
	
	public static void length_() {
		String residentNum = "9703191698116";
		int length = residentNum.length();
		if (length == 13) {
			System.out.println("주민번호 자리수가 맞습니다.");
		}
		else  {
			System.out.println("주민번호 자릿수가 틀립니다.");
		}
	}

	public static void replace_() {
		String oldStr = "자바는 객체 지향 언어입니다. 자바는 풍부한 API를 지원합니다.";
		String newStr = oldStr.replace("자바", "JAVA");
		System.out.println(oldStr);
		System.out.println(newStr);
	}
	
	public static void substring_() {
		String residentNum = "970319-1698116";
		
		String firstnum = residentNum.substring(0, 6);
		System.out.println(firstnum);
		
		String secondNum = residentNum.substring(7);
		System.out.println(secondNum);
	}

	public static void toLowerUpperCase() {
		String str1 = "Java Programming";
		String str2 = "JAVA Programming";
		
		System.out.println(str1.equals(str2));
		
		String lowerStr1 = str1.toLowerCase();
		String lowerStr2 = str2.toLowerCase();
		System.out.println(lowerStr1.equals(lowerStr2));
		
		System.out.println(str1.equalsIgnoreCase(str2));
	}

	public static void trim_() {
		String tel1 = "   02";
		String tel2 = "123   	";
		String tel3 = "		1243	";
		
		String tel = tel1.trim() + tel2.trim() + tel3.trim();
		System.out.println(tel);
	}
	
	public static void value_of() {
		String str1 = String.valueOf(10);
		String str2 = String.valueOf(10.5);
		String str3 = String.valueOf(true);
		
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
	}
}