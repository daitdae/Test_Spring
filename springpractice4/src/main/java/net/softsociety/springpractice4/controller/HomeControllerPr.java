package net.softsociety.springpractice4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeControllerPr {
	@GetMapping({"","/"})
	public String homePr4() {
		return "/homePr4";
	}

}
