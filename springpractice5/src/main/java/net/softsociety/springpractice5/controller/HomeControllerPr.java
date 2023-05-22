package net.softsociety.springpractice5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeControllerPr {
	
	@GetMapping({"","/"})
	public String homePr5() {
		return "/homePr5";
	}

}
