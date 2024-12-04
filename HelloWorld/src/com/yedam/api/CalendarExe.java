package com.yedam.api;

import java.util.Calendar;

public class CalendarExe {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();	// 이런 식으로 인스턴스 생성!!
		cal.set(2024, 1, 1);
		System.out.println(cal.get(Calendar.DAY_OF_WEEK) + "요일");
		System.out.println(cal.getActualMaximum(Calendar.DATE) + "막날");
		
		createCalendar(2024, 1);
	}
	
	// 1일의 요일?, 막날? => 달력.
	static void createCalendar(int year, int month) {
		Calendar cal = Calendar.getInstance();	// 이런 식으로 인스턴스 생성!!
		cal.set(year, month - 1, 1);
		int firstDay = cal.get(Calendar.DAY_OF_WEEK);
		int lastDate = cal.getActualMaximum(Calendar.DATE);
		
		String[] days = {"Sun", "Mon", "Tue", "Wed", "Thr", "Fri", "Sat"};
		for (String day : days) {
			System.out.printf("%4s", day);
		}
		System.out.println();
		// 1일의 위치 지정.
		for (int i = 1; i < firstDay; i++) {
			System.out.printf("%4s", " ");
		}
		// 날짜출력.
		for (int d = 1; d <= lastDate; d++) {
			System.out.printf("%4d", d);
			if ((d + firstDay - 1) % 7 == 0) {
				System.out.println();	// 줄바꿈
			}
		}
	}
}
