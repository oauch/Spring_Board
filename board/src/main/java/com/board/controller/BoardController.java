package com.board.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.board.domain.BoardVo;
import com.board.service.BoardSerivce;


@Controller
@RequestMapping("/board/")
public class BoardController {

	@Inject
	private BoardSerivce service;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void getList(Model model) throws Exception {
	 
	 List<BoardVo> list = null;
	 list = service.list();
	 
	 model.addAttribute("list", list);
		 
	   
	}
}