package net.softsociety.springpractice.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@RequestMapping("/cookie")
@Slf4j
@Controller
public class CookieControllerPr {
	
	@GetMapping("/ck1Pr")
	public String ck1Pr(HttpServletResponse res) {
		Cookie c1 = new Cookie("str","abcdefg");
		Cookie c2 = new Cookie("num","12345");
		
		c1.setMaxAge(60*60*24*3);
		c2.setMaxAge(60*60*24*3);
		
		res.addCookie(c1);
		res.addCookie(c2);
		
		return "redirect:/";
	}
	
	@GetMapping("/ck2Pr")
	public String ck2Pr(
			@CookieValue(name="str", defaultValue="없음") String str
			,@CookieValue(name="num", defaultValue="0") int num) {
		log.debug("str 쿠키값 : {}",str);
		log.debug("num 쿠키값 : {}",num);
		return "redirect:/";
	}
	
	@GetMapping("ck3Pr")
	public String ck3Pr(HttpServletResponse res) {
		Cookie c1 = new Cookie("str",null);
		Cookie c2 = new Cookie("num",null);
		
		c1.setMaxAge(0);
		c2.setMaxAge(0);
		
		res.addCookie(c1);
		res.addCookie(c2);
		
		return "redirect:/";
	}
	

}
