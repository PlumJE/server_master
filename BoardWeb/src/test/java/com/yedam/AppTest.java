package com.yedam;

import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.dao.ReplyDAO;

public class AppTest {
	public static void main(String[] args) {
		ReplyDAO rdao = new ReplyDAO();
		List<Map<String, Object>> result = rdao.calendarData();
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(result);
		
		System.out.println(json);
	}
}
