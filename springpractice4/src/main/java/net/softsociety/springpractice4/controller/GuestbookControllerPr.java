package net.softsociety.springpractice4.controller;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.springpractice4.domain.GuestbookPr;
import net.softsociety.springpractice4.service.GuestbookServicePr;

@Slf4j
@Controller
public class GuestbookControllerPr {
	@Autowired
	GuestbookServicePr servicePr;
	
	//방명록 화면으로 이동
	@GetMapping("/listPr4")
	public String listPr4(Model model) {
		ArrayList<GuestbookPr>glist = servicePr.list();
		model.addAttribute("glist",glist);
		return "/listPr4";
	}
	
	//글쓰기 폼으로 이동
	@GetMapping("/writePr4")
	public String writePr4() {
		return "/writePr4";
	}
	
	//글 저장
	@PostMapping("/writePr4")
	public String writePr4(GuestbookPr gb) {
		int n = servicePr.insert(gb);
		return "redirect:/listPr4";
	}
	
	//삭제
	@PostMapping("/delete")
	public String delete(GuestbookPr gb) {
		log.debug("전달된삭제정보: {}",gb);
		int n = servicePr.delete(gb);
		if(n==0) {
			log.debug("삭제실패");
		} else {
			log.debug("삭제성공");
		}
		return "redirect:/listPr4";
	}

}
