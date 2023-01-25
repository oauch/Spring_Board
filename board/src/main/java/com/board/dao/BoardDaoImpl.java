package com.board.dao;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.board.domain.BoardVo;

@Repository
public class BoardDaoImpl implements BoardDao {

	@Inject
	private SqlSession sql;
	
	private static String namespace = "com.board.mappers.board";
	
	// 게시글 조회
	@Override
	public List<BoardVo> list() throws Exception {
		return sql.selectList(namespace + ".list");
	}
	
	// 게시글 작성
	@Override
	public void write(BoardVo vo) throws Exception {
		sql.insert(namespace + ".write", vo);
	}
	
	// 게시글 조회
	@Override
	public BoardVo view(int bno) throws Exception {
		return sql.selectOne(namespace + ".view", bno);
	}
	
	// 게시물 수정
	@Override
	public void modify(BoardVo vo) throws Exception {
		sql.update(namespace + ".modify", vo);
	}
	
	// 게시물 삭제
	public void delete(int bno) throws Exception {
		
		sql.delete(namespace + ".delete", bno);
	}
	
	// 게시물 총 갯수
	@Override
	public int count() throws Exception {
		return sql.selectOne(namespace + ".count");	
	}

	// 게시물 목록 + 페이징
	@Override
	public List<BoardVo> listPage(int displayPost, int postNum) throws Exception {

		HashMap<String, Integer> data = new HashMap<String, Integer>();
		
		data.put("displayPost", displayPost);
		data.put("postNum", postNum);
		
		return sql.selectList(namespace + ".listPage", data);
	}

	@Override
	public List<BoardVo> listPageSearch(int displayPost, int postNum, String searchType, String keyword) throws Exception {
		
		HashMap<String, Object> data = new HashMap<String, Object>();
		
		data.put("displayPost", displayPost);
		data.put("postNum", postNum);
		
		data.put("searchType", searchType);
		data.put("keyword", keyword);
		
		return sql.selectList(namespace + ".listPageSearch", data);

	}

}
