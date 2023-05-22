package net.softsociety.springpractice2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeControllerPr {
	
	@GetMapping({"","/"})
	public String homePr2() {
		return "/homePr2";
	}

}
