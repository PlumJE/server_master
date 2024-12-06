package com.yedam.jdbc.student;

import java.util.ArrayList;

public class TestExe {
	public static void main(String[] args) {
		Search search = new Search();
		search.setName("길동");
		search.setPhone("22");
		search.setEngScore(60);
		
		StudentDAO sdao = new StudentDAO();
		ArrayList<String> list = sdao.studentList(search);
		for (String str : list) {
			Student std = new Student();
			std.setStdNo(str);
			System.out.println(std.showInfo());
		}
	}
}
