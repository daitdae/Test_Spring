package net.softsociety.springpractice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@RequestMapping("/ex")
@Slf4j
@Controller
public class Test1ControllerPr {
	
	@GetMapping("/test1Pr")
		public String test1Pr() {
		return "/exView/calcViewPr";
	}
	
	@PostMapping("/test1Pr")
	public String test1Pr(Model model, int num1, int num2, String op) {
		
		int res = 0;
		
		switch(op) {
		case"+": res = num1 + num2; break;
		case"-": res = num1 - num2; break;
		case"*": res = num1 * num2; break;
		case"/": res = num1 / num2; break;
		}
		
		model.addAttribute("num1",num1);
		model.addAttribute("num2",num2);
		model.addAttribute("op",op);
		model.addAttribute("res",res);
		
		return "/exView/calcResultPr";
	}
		
	

}
