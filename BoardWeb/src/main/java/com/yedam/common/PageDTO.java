package com.yedam.common;

import lombok.Data;

@Data
public class PageDTO {
	int startPage;	// 현재 페이지 기준 첫번째 페이지 정보.
	int endPage;	// 현재 페이지 기준 마지막 페이지 정보.
	int currentPage;
	boolean prev, next;
	
	public PageDTO(int page, int totalCnt) {
		currentPage = page;	// 12page
		endPage = (int) Math.ceil(page / 10.0) * 10;	// 20page
		startPage = endPage - 9;	// 11page
		
		// 실제 마지막 페이지.
		int realEnd = (int) Math.ceil(totalCnt / 10.0);	// 87건 => 18페이지.
		System.out.println("realEnd : " + realEnd);
		endPage = endPage < realEnd ? endPage : realEnd;
		
		prev = startPage > 1;
		next = endPage < realEnd;
	}
}
