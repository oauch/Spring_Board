package com.board.dao;

import java.util.List;

import com.board.domain.BoardVo;

public interface BoardDao {
	
	public List<BoardVo> list() throws Exception;
}
