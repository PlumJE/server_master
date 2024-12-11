package com.yedam.variable;

public class IntExe2 {
	public static void main(String[] args) {
		// 정수형 => byte(1B), short(2B), int(4B), long(8B), char(2B, 문자형으로도 쓰인다)
		// 1B == 8bit.
		byte b1 = 100;
		byte b2 = 100;
		int result = b1 + b2; // byte + byte => int + int
		
		byte result2 = (byte) (b1 + b2);
		System.out.println(result2);
		
		for (int i = 0; i < 30; i++) {
			System.out.println("b1의 값 : " + b1++);
		}
		System.out.println(2147483647);
		long l1 = 1000000000000000000L;
		
		// float(4바이트), double(8바이트)
		double d1 = 0.1;
		double d2 = 0.2;
		double result3 = d1 + d2;
		result3 = 0.345678;
		
		System.out.println("result3의 값 : " + Math.floor(result3 * 1000) / 1000);
		
		double[] doubleAry = {10, 23.4, 11.7, 34.5};
		// doubleAry의 합은 79.6입니다.
		double doubleSum = 0;
		for (int i = 0; i < 4; i++) {
			doubleSum += doubleAry[i];
		}
		System.out.println("doubleAry의 합은 " + doubleSum + "입니다.");
	}
}