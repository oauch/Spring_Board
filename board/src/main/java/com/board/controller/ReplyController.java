package com.board.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.board.domain.ReplyVo;
import com.board.service.ReplyService;

@Controller
@RequestMapping("/reply/*")
public class ReplyController {
	
	@Inject
	private ReplyService replyService;
	
	// 댓글 조회
	
	// 댓글 작성
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String postWrite(ReplyVo vo) throws Exception{
		
		replyService.write(vo);
		
		return "redirect:/board/view?bno=" + vo.getBno();
	}
	
	// 댓글 수정
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String postMoidfy(ReplyVo vo) throws Exception{
		
		replyService.modify(vo);
		
		return "redirect:/board/view?bno=" + vo.getBno();
	}
	// 댓글 삭제
	
	// 댓글 단일 조회(수정 페이지)
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void getModify(@RequestParam("bno") int bno,
						  @RequestParam("rno") int rno,
						  Model model) throws Exception{
		
		ReplyVo vo = new ReplyVo();
		vo.setBno(bno);
		vo.setRno(rno);
		
		ReplyVo reply = replyService.replySelect(vo);
		
		model.addAttribute("reply", reply);
	}
}
