package net.softsociety.spring4.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.spring4.domain.Guestbook;
import net.softsociety.spring4.service.GuestbookService;


/**
 * 회원 정보의 입력/수정.삭제 조회처리
 **/
@Controller	
@Slf4j
public class GuestbookController {
	@Autowired				
	GuestbookService service;	
	
//	방명록 화면으로 이동(처음에 보여주기만 할 때)
//	@GetMapping("/list")
//	public String list() {
//		return "/list";	
//	}
	
	//방명록 화면으로 이동 모델에 담아서 리스트 보여주는것
	@GetMapping("/list")
	public String list(Model model) {
		ArrayList<Guestbook> glist = service.list();
		model.addAttribute("glist",glist);
		return "/list";	
	}	
	
	//글쓰기 폼으로 이동
	@GetMapping("/write")
	public String write() {
		return "/write";	
	}	
	
	//글 저장
	// redirect 반드시 필요 없으면 그냥 html파일만 보여줌 내용없이
	// 게시판을 다시 실행하고 싶다 하면 redirect 
	@PostMapping("/write")
	public String write(Guestbook gb) {
		int n = service.insert(gb);
		return "redirect:/list";	
	}	
	
	//삭제
	@PostMapping("/delete")
	public String delete(Guestbook gb) {
		log.debug("전달된삭제정보{}",gb);
		int n = service.delete(gb);
		if(n==0) {
			log.debug("삭제실패");
		} else {
			log.debug("삭제성공");
		}
		return "redirect:/list";
	}
	
	
}
