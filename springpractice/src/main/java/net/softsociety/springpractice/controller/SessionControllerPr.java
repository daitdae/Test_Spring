package net.softsociety.springpractice.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/session")
@Controller
public class SessionControllerPr {
	
	@GetMapping("stest1Pr")
	public String stest1Pr(HttpSession session) {
		session.setAttribute("id", "adc");
		return "/sessionView/ss1Pr";
	}
	
	@GetMapping("stest2Pr")
	public String stest2Pr(HttpSession session) {
		String id = (String)session.getAttribute("id");
		log.debug("세션의 값:{}", id);
		return "redirect:/";
	}
	
	@GetMapping("stest3Pr")
	public String stest3Pr(HttpSession session) {
		session.removeAttribute("id");
		return "redirect:/";
	}
	
	@GetMapping("stest4Pr")
	public String stest4Pr() {
		return "/sessionView/loginFormPr";
	}
	
	@PostMapping("stest5Pr")
	public String stest5Pr(
			String id
			, String pw
			, HttpSession session
			, HttpServletRequest req) {
		log.debug("요청정보 : {}",req.getRemoteAddr());
		if(id.equals("abc") && pw.equals("123")) {
			session.setAttribute("id", id);
			return "redirect:/";
		} else {
			return "/sessionView/loginFormPr";
		}
	}
	
	@GetMapping("stest6Pr")
	public String stest6Pr(HttpSession session) {
		session.removeAttribute("id");
		return "redirect:/";
	}
	
	

}
