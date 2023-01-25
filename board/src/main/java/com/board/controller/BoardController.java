package com.board.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.board.domain.BoardVo;
import com.board.domain.Page;
import com.board.service.BoardSerivce;


@Controller
@RequestMapping("/board/*")
public class BoardController {

	@Inject
	private BoardSerivce service;
	
	// 寃뚯떆臾� 紐⑸줉
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void getList(Model model) throws Exception {
	 
		List<BoardVo> list = null;
	 	list = service.list();
	 
	 	model.addAttribute("list", list);
	}
	
	// 寃뚯떆臾� �옉�꽦
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public void getWirte() throws Exception{
		
	}
	
	// 寃뚯떆湲� �옉�꽦
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String postWrite(BoardVo vo) throws Exception{
		
		service.write(vo);
		
		return "redirect:/board/list";
	}
	
	// 寃뚯떆湲� 議고쉶
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public void getView(@RequestParam("bno") int bno, Model model) throws Exception{
		
		BoardVo vo = service.view(bno);
		
		model.addAttribute("view", vo);
	}
	
	// 寃뚯떆臾� �닔�젙
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void getModify(@RequestParam("bno") int bno, Model model) throws Exception{
		
		BoardVo vo = service.view(bno);
		
		model.addAttribute("view", vo);
	}
	
	// 寃뚯떆臾� �닔�젙
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String postModify(BoardVo vo) throws Exception {

	 service.modify(vo);
	   
	 return "redirect:/board/view?bno=" + vo.getBno();
	}
	
	// 寃뚯떆臾� �궘�젣
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String getDelete(@RequestParam("bno") int bno) throws Exception {
	  
		 service.delete(bno);  
	
		 return "redirect:/board/list";
	}
	
	// 寃뚯떆臾� 紐⑸줉 + �럹�씠吏� 異붽�
	@RequestMapping(value = "/listPage", method = RequestMethod.GET)
	public void getListPage(Model model, @RequestParam("num") int num) throws Exception {
		
		Page page = new Page();
		
		page.setNum(num);
		page.setCount(service.count());
		
		List<BoardVo> list = null;
		list = service.listPage(page.getDisplayPost(), page.getPostNum());
		
		model.addAttribute("list", list);
		/*
		 * model.addAttribute("pageNum", page.getPageNum());
		 * 
		 * model.addAttribute("startPageNum", page.getStartPageNum());
		 * model.addAttribute("endPageNum", page.getEndPageNum());
		 * 
		 * model.addAttribute("prev", page.isPrev()); model.addAttribute("next",
		 * page.isNext());
		 */
		model.addAttribute("page", page);
		
		model.addAttribute("select", num);
		
/*		// 寃뚯떆臾� 珥� 媛��닔
		int count = service.count();
		
		// �븳 �럹�씠吏��뿉 異쒕젰�븷 寃뚯떆臾� 媛��닔
		int postNum = 10;
		
		// �븯�떒 �럹�씠吏� 踰덊샇 ([ 寃뚯떆臾� 珥� 媛��닔 첨 �븳 �럹�씠吏��뿉 異쒕젰�븷 媛��닔 ]�쓽 �삱由�)
		int pageNum = (int)Math.ceil((double)count/postNum);
		
		// 異쒕젰�븷 寃뚯떆臾�
		int displayPost = (num - 1) * postNum;
		
		// �븳踰덉뿉 �몴�떆�븷 �럹�씠吏� 踰덊샇�쓽 媛��닔
		int pageNum_cnt = 10;
		
		// �몴�떆�릺�뒗 �럹�씠吏� 踰덊샇 以� 留덉�留� 踰덊샇
		int endPageNum = (int)(Math.ceil((double)num / (double)pageNum_cnt) * pageNum_cnt);
		
		// �몴�떆�릺�뒗 �럹�씠吏� 踰덊샇 以� 泥ル쾲吏� 踰덊샇
		int startPageNum = endPageNum - (pageNum_cnt - 1);
		
		// 留덉�留� 踰덊샇 �옱怨꾩궛
		int endPageNum_tmp = (int)(Math.ceil((double)count / (double)pageNum_cnt));
		
		if(endPageNum > endPageNum_tmp) {
			endPageNum = endPageNum_tmp;
		}
		
		// �씠�쟾, �떎�쓬
		boolean prev = startPageNum == 1 ? false : true;
		boolean next = endPageNum * pageNum_cnt >= count ? false: true;
		
				
		List<BoardVo> list = null; 
		list = service.listPage(displayPost, postNum);
		model.addAttribute("list", list);		 
		model.addAttribute("pageNum", pageNum);
		
		// �떆�옉 諛� �걹 踰덊샇
		model.addAttribute("startPageNum", startPageNum);
		model.addAttribute("endPageNum", endPageNum);
		
		// �씠�쟾 諛� �떎�쓬
		model.addAttribute("prev", prev);
		model.addAttribute("next", next);
		
		// �쁽�옱 �럹�씠吏�
		model.addAttribute("select", num);
	*/}
	
	// 寃뚯떆臾� 紐⑸줉 + �럹�씠吏� 異붽�
		@RequestMapping(value = "/listPageSearch", method = RequestMethod.GET)
		public void getListPageSearch(Model model, 
				@RequestParam("num") int num,
				@RequestParam(value = "searchType",required = false, defaultValue = "title") String searchType,
				  @RequestParam(value = "keyword",required = false, defaultValue = "") String keyword) throws Exception {
			
			Page page = new Page();
			
			page.setNum(num);
			page.setCount(service.count());
			
			List<BoardVo> list = null;
			list = service.listPageSearch(page.getDisplayPost(), page.getPostNum(), searchType, keyword);
			
			model.addAttribute("list", list);
			model.addAttribute("page", page);
			model.addAttribute("select", num);
		}
}
