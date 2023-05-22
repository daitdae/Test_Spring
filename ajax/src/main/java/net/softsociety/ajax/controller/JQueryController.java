package net.softsociety.ajax.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/jquery")
public class JQueryController {

	@GetMapping("/jq1")
	public String jq1() {
		return "/jquery/jq1";
	}
	
	@GetMapping("/jq2")
	public String jq2() {
		return "/jquery/jq2";
	}
	
	@GetMapping("/jq3")
	public String jq3() {
		return "/jquery/jq3";
	}
	
	@GetMapping("/jq4")
	public String jq4() {
		return "/jquery/jq4";
	}
	
	@GetMapping("/jq5")
	public String jq5() {
		return "/jquery/jq5";
	}
	
	@GetMapping("/jq6")
	public String jq6() {
		return "/jquery/jq6";
	}
}
