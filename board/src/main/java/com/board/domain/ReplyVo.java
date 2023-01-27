package com.board.domain;

import java.util.Date;

public class ReplyVo {
	
	/*
	 * CREATE TABLE tbl_reply (
	rno		INT			NOT NULL AUTO_INCREMENT,
	bno		INT			NOT NULL,
	writer	VARCHAR(30)	NOT NULL,
	content 	TEXT			NOT NULL,
	regDate	TIMESTAMP	NOT NULL DEFAULT NOW(),
	PRIMARY KEY(rno, bno),
	FOREIGN KEY(bno) REFERENCES tbl_board(bno)
); 
	 * */
	
	/* 댓글번호 */
	private int rno;
	
	/* 글 번호 */
	private int bno;
	
	/* 작성자 */
	private String writer;
	
	/* 댓글 내용 */
	private String content;
	
	/* 작성일자 */
	private Date regDate;

	
	/**************************** GETTER / SETTER ************************************/
	
	/* 댓글번호 */
	public int getRno() {
		return rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
	}
	
	/* 글 번호 */
	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}
	
	/* 작성자 */
	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	/* 댓글 내용 */
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	/* 작성일자 */
	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
}
