package com.board.service;

import java.util.List;

import com.board.domain.ReplyVo;

public interface ReplyService {
	
	// 댓글 조회
	public List<ReplyVo> list(int bno) throws Exception;

	// 댓글 조회
	public void write(ReplyVo vo) throws Exception;

	// 댓글 수정
	public void modify(ReplyVo vo) throws Exception;

	// 댓글 삭제
	public void delete(ReplyVo vo) throws Exception;
	
	// 단일 댓글 조회
	public ReplyVo replySelect(ReplyVo vo) throws Exception;
}
