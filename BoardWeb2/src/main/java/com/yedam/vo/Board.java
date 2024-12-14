package com.yedam.vo;

import lombok.Data;

/*
 * VO: Value Object
 * Lombok 사용: 1. Lombok 다운로드 설치
 * 			   2. Lombok 라이브러리 다운로드
 * 			   3. eclipse 재실행
 * 			   4. 어노테이션
 */

@Data
public class Board {
	private int boardNo; // 형식을 board_no에서 boardNo로 바꿈.
	private String title;
	private String content;
	private String writer;
	private int viewCnt;
	private String creationDate;
	private String updateDate;
	private String img;	// 이미지의 파일(경로)명.
}
