package com.board.domain;

import java.util.Date;

public class BoardVo {
	
	/* 글번호 */
	private int bno;
	
	/* 제목 */
	private String title;
	
	/* 내용 */
	private String content;
	
	/* 작성자 */
	private String writer;
	
	/* 작성일자 */
	private Date regDate;
	
	/* 조회수 */
	private int viewCnt;

	/************************ Getter / Setter *****************************/
	
	/* 글번호 */
	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}
	
	/* 제목 */
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	/* 내용 */
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	/* 작성자 */
	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	/* 작성일자 */
	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	/* 조회수 */
	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
}
