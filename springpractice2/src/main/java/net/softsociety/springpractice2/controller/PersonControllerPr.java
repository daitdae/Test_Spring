package net.softsociety.springpractice2.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.springpractice2.domain.PersonPr;
import net.softsociety.springpractice2.service.PersonServicePr;

/**
 * 회원 정보의 입력/수정.삭제 조회처리
 **/

@Slf4j
@Controller
public class PersonControllerPr {
	@Autowired
	PersonServicePr servicePr;
	
	@GetMapping("/insertPr")
	public String insertPr() {
		return "/insertFormPr";
	}
	
	@PostMapping("/insertPr")
	public String insertPr(PersonPr personpr) {
		log.debug("전달된 값,{}",personpr);
		
		servicePr.insertPersonPr(personpr);
		
		return "redirect:/";
	}
	
	@GetMapping("/deletePr")
	public String deletePr(String idnum) {
		log.debug("삭제할 민번: {}",idnum);
		servicePr.deletePersonPr(idnum);
		return "redirect:/selectPr";
	}
	
	@GetMapping("/delete2Pr")
	public String delete2Pr(String name) {
		log.debug("삭제할 이름: {}",name);
		servicePr.delete2PersonPr(name);
		return "redirect:/";
	}
	
	@GetMapping("/selectOnePr")
	public String selectOnePr(String idnum, Model model) {
		log.debug("조회할 민번: {}",idnum);
		PersonPr person = servicePr.selectOnePr(idnum);
		model.addAttribute("personPr", person);
		return "/viewPersonPr";
	}
	
	@GetMapping("/selectPr")
	public String selectPr(Model model) {
		ArrayList<PersonPr>list = servicePr.selectPr();
		log.debug("전달된 값,{}",list);
		model.addAttribute("list", list);
		return "/viewlistPr";
	}
	
	@GetMapping("/updatePr")
	public String updatePr(String idnum,Model model) {
		log.debug("값,{}",idnum);
		PersonPr person = servicePr.selectOnePr(idnum);
		model.addAttribute("personPr",person);
		return "/updateFormPr";
	}
	
	@PostMapping("/updatePr")
	public String updatePr(PersonPr person) {
		log.debug("값,{}",person);
		servicePr.updatePersonPr(person);
		return "redirect:/selectPr";
	}
	

}
