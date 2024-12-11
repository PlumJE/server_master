package com.yedam.inheritance;

/*
 * Child: Parent 클래스
 */
public class Child extends Parent {
	String field2;
	// 생성자: 기본생성자를 생성. Child() => super();
	Child() {
		super("");
	}
	@Override	// 부모의 메소드정의(반환값, 메소드이름, 매개값)
	void method1() {
		// 부모가 가진 메소드를 자식이 재정의 메소드 오버로딩
		System.out.println("자식 method1 호출.");
	}
	void method2() {
		System.out.println("method2 호출.");
	}
	@Override
	public String toString() {
		return "Child [field2=" + field2 + "]";
	}
}