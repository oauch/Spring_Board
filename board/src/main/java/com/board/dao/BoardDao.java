package com.board.dao;

import java.util.List;

import com.board.domain.BoardVo;

public interface BoardDao {
	
	// 게시글 목록
	public List<BoardVo> list() throws Exception;
	
	// 게시글 작성
	public void write(BoardVo vo) throws Exception;
	
	// 게시글 조회
	public BoardVo view(int bno) throws Exception;
	
	// 게시물 수정
	public void modify(BoardVo vo) throws Exception;
	
	// 게시뮬 삭제
	public void delete(int bno) throws Exception;
	
	// 게시물 총 갯수
	public int count() throws Exception;	

	// 게시물 목록 + 페이징
	public List<BoardVo> listPage(int displayPost, int postNum) throws Exception;
	
	// 게시물 목록 + 페이징
	public List<BoardVo> listPageSearch(int displayPost, int postNum, String searchType, String keyword) throws Exception;
}
