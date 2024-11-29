package com.yedam.reference;

public class TodoExe1 {
	public static void main(String[] args) {
		// 정수를 담는 배열 크기 5개로 선언.
		// Math.random() 활용 => 50 ~ 100 사이의 정수를 저장.
		int[] intAry = new int[5];
		for (int i = 0; i < intAry.length; i++) {
			int temp = (int) (Math.random() * 50 + 50);
			// 2번째 -> 1번째, 3번째 -> 2번째까지, 4번째 -> 3번째까지 비교.
			boolean exists = false;
			for (int j = 0; j < i; j++) {
				if (intAry[i] == temp) {
					exists = true;
				}
			}
			// 같은 값이 존재하면.. i값을 증가X
			if (exists) {
				continue;
			}
			intAry[i] = temp;
			i++;
		}
		
		// 출력.
		for (int i : intAry) {
			System.out.println(i);
		}
		
		System.out.println("end of prog.");
	}
}
