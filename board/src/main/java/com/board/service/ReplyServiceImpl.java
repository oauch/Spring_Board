package com.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.board.dao.ReplyDao;
import com.board.domain.ReplyVo;

@Service
public class ReplyServiceImpl implements ReplyService {

	@Inject
	private ReplyDao dao;

	// 댓글 조회
	@Override
	public List<ReplyVo> list(int bno) throws Exception {
	    return dao.list(bno);
	}

	// 댓글 작성
	@Override
	public void write(ReplyVo vo) throws Exception {
	    dao.write(vo);
	}
	
	// 댓글 수정
	@Override
	public void modify(ReplyVo vo) throws Exception {
	    dao.modify(vo);
	}
	
	// 댓글 삭제
	@Override
	public void delete(ReplyVo vo) throws Exception {
	    dao.delete(vo);
	}

	// 단일 댓글 조회
	@Override
	public ReplyVo replySelect(ReplyVo vo) throws Exception {
		
		return dao.replySelect(vo);
	}

}
