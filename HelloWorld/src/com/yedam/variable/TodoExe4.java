package com.yedam.variable;
import java.util.Scanner;

public class TodoExe4 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("몇단까지 출력하시겠습니까?>> ");
		int dan = scn.nextInt();
		if (dan < 2) {
			dan = 2;
		}
		else if (dan > 10) {
			dan = 10;
		}
		
		for (int i = 2; i <= dan; i++) {
			System.out.printf("현재 %d 단\t\t", i);
		}
		
		for (int j = 1; j <= 9; j++) {
			System.out.print('\n');
			for (int i = 2; i <= dan; i++) {
				System.out.printf("%d * %d = %3d\t", i, j, i * j);
			}
		}
		System.out.print("\n");
		
		// 별찍기.
		for (int j = 5; j >= 1; j--) {
			for (int i = 1; i <= 5; i++) {
				if (i <= j) {
					System.out.print("*");
				}
			}
			System.out.print("\n");
		}
	
		System.out.println("end of prog.");
	}
}
