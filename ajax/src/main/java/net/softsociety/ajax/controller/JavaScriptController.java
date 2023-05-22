package net.softsociety.ajax.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/javascript")
public class JavaScriptController {
	
	@GetMapping("/js1")
	public String js1() {
		return "/javascript/js1";
	}
	
	@GetMapping("/js2")
	public String js2() {
		return "/javascript/js2";
	}
	
	@GetMapping("/js3")
	public String js3() {
		return "/javascript/js3";
	}
	
	@GetMapping("/js4")
	public String js4() {
		return "/javascript/js4";
	}


}
