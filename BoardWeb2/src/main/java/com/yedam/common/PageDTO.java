package com.yedam.common;

import lombok.Data;

@Data
public class PageDTO {
	int leftestPage;	// 가장 왼쪽 페이지
	int rightestPage;	// 가장 오른쪽 페이지
	int currentPage;	// 현재 페이지
	boolean prev, next;
	
	public PageDTO(int page, int totalCnt) {
		int totalPage = (int) Math.ceil(totalCnt / 10.0); // 모든 페이지의 수
		currentPage = page;
		
		leftestPage = (currentPage - 1) / 10 * 10 + 1;
		rightestPage = leftestPage + 9;
		
		prev = leftestPage > 1;
		next = rightestPage < totalPage;
		rightestPage = next ? rightestPage : totalPage;
	}
}
