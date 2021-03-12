package com.webjjang.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.webjjang.board.service.BoardServiceImpl;
import com.webjjang.board.util.Criteria;
import com.webjjang.board.util.PageingInfo;

@Controller
public class BoardController {

	private final String MODULE_NAME = "board";
	
	@Autowired
	private BoardServiceImpl service;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "redirect:/board/list";
	}
	
	//게시판 리스트
	@GetMapping("/board/list")
	public String list(Model model, Criteria cri) {
		System.out.println("--------------------");
		System.out.println("this is list()");
		System.out.println("cri : " + cri);
		System.out.println("getBoardList(cri) : " + service.getBoardList(cri));
		System.out.println("service.getCountAll(cri) : " + service.getCountAll(cri));
		model.addAttribute("list",service.getBoardList(cri));
		model.addAttribute("pageMaker",new PageingInfo(cri, service.getCountAll(cri)));
		return MODULE_NAME + "/list";
	}

//	
//	//게시판 글보기
//	@GetMapping("/view.do")
//	public String view(Model model, PageObject pageObject, int no, int inc) {
//		
//		return MODULE_NAME + "/view";
//	}
//	
//	//게시판 글쓰기 폼
//	@GetMapping("/write.do")
//	public String writeForm() {
//		return MODULE_NAME + "/write";
//	}
//	
//	//게시판 글쓰기 처리 - 제목,내용,작성자,비밀번호
//	@PostMapping("/write.do")
//	public String write(BoardVO vo) {
//		
//		//화면에 JSP를 보여주지 않고 바로 리스트로 이동
//		return "redirect:list.do";
//	}
//	
//	//게시판 글수정 폼
//	@GetMapping("/update.do")
//	public String updateForm(Model model, int no, int inc) {
//		return MODULE_NAME + "/update";
//	}
//	
//	//게시판 글수정 처리 - 글번호,제목,내용,작성자,비밀번호
//	@PostMapping("/update.do")
//	public String update(BoardVO vo) {
//		
//		//화면에 JSP를 보여주지 않고 바로 글보기로 이동
//		return "redirect:view.do?no=" + vo.getNo() + "&inc=0";
//	}
//
//	//게시판 글삭제 처리 - 글번호,비밀번호
//	@PostMapping("/delete.do")
//	public String delete(BoardVO vo) {
//		
//		//화면에 JSP를 보여주지 않고 바로 글보기로 이동
//		return "redirect:list.do";
//	}
//	

	
	
	

}
