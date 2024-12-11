package com.yedam.reference;
import java.util.Scanner;
/*
 * 은행 프로그램 v 1.0
 * 작성자 : 이지응
 * 작성일시 : 2024.11.29
 */

public class ArrayEx2 {
	public static void main(String[] args) {
		// 은행 프로그램 v1.0
		// 변수 초기화. 10만원 초가불가. -잔고불가
		// 90000원에서 20000원 입금 안됨 
		boolean run = true;
		int balance = 0;
		Scanner scn = new Scanner(System.in);
		
		while (run) {
			System.out.println("-------------------------------------");
			System.out.println("1.예금 2.출금 3.잔고 4.종료               ");
			System.out.println("-------------------------------------");
			System.out.print("선택 >>> ");
			int menu = Integer.parseInt(scn.nextLine());
			int temp;
			
			switch (menu) {
			case 1:
				System.out.print("예금액> ");
				temp = Integer.parseInt(scn.nextLine());
				if (balance + temp <= 100000 && (temp < 20000 || temp > 90000)) {
					balance += temp;
				}
				else {
					System.out.println("입금할 수 없습니다.");
				}
				break;
			case 2:
				System.out.print("출금액> ");
				temp = Integer.parseInt(scn.nextLine());
				if (balance - temp >= 0) {
					balance -= temp;
				}
				else {
					System.out.println("출금할 수 없습니다.");
				}
				break;
			case 3:
				System.out.println("잔고> " + balance);
				break;
			case 4:
				run = false;
			}
		}
		System.out.println("프로그램 종료");
	}
}
