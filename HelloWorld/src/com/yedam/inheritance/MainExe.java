package com.yedam.inheritance;

public class MainExe {
	public static void main(String[] args) {
		Parent p1 = new Parent();
		p1.field1 = "부모필드";
		p1.method1();
		System.out.println(p1.toString());
		
		Child c1 = new Child();	// 
		c1.field1 = "자식필드";
		c1.method1();
		c1.field2 = "자식필드2";
		c1.method2();
		System.out.println(c1.toString());
	}
}
