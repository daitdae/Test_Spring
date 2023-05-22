package net.softsociety.springpractice5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.springpractice5.domain.Member;

@Slf4j
@Controller
@RequestMapping("/member")
public class MemberControllerPr {
	
	@GetMapping("/join")
	public String join() {
		return "/memberview/joinFormPr";
	}
	
	@PostMapping("/join")
	public String join(Member member) {
		log.debug("가입데이터{}",member);
		return "redirect:/";
	}
	
}
