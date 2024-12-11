package com.yedam.variable;

public class IntExe4 {
	public static void main(String[] args) {
		int age = 10;	// age에 10이 저장.
		int myAge = age;// myAge에 10이 저장.
		myAge = 20;		// myAge에 20이 저장.
		System.out.println("age=>" + age + ", myAge=>" + myAge);
		
		// 원래는 String msg = new String("Hello, World");이다.
		String msg = "Hello, World";// msg에 "Hello, World"의 주소가 저장
		String myMsg = msg;			// myMsg에 "Hello, World"의 주소가 저장
		myMsg = "Welcome, World";	// myMsg에 "Welcome, World"의 주소가 저장
		System.out.println("msg=>" + msg + ", myMsg=>" + myMsg);
		
		boolean isEqual;
		isEqual = msg == "Hello, World";		// 잘못된 것이다!!
		isEqual = msg.equals("Hello, World");	// 이것이 옳은 방법!!
		System.out.println(isEqual);
	}
}
