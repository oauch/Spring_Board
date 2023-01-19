package com.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.board.dao.BoardDao;
import com.board.domain.BoardVo;

@Service
public class BoardServiceImpl implements BoardSerivce {

 @Inject
 private BoardDao dao;
 
 @Override
 public List<BoardVo> list() throws Exception {

  return dao.list();
 }
}