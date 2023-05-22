package net.softsociety.springpractice.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import net.softsociety.springpractice.domain.PersonPr;

@Controller
public class ParaControllerPr {
	
	@GetMapping("/param/test1Pr")
	public String test1Pr() {
		return "/paramView/view1Pr";
	}
	@GetMapping("/param/input1Pr")
	public String inputpr1(String name, int age) {
		System.out.println(name);
		System.out.println(age);
		return "/paramView/view1Pr";
	}
	
	@GetMapping("/param/test2Pr")
	public String test2Pr() {
		return "/paramView/view2Pr";
	}
	@PostMapping("/param/input2Pr")
	public String input2Pr(String id, String password, String name, String phone, String com) {
		System.out.println("Id" + id);
		System.out.println("Password" + password);
		System.out.println("Name" + name);
		System.out.println("Phone" + phone);
		System.out.println(com);
		
		return "redirect:/";
	}
	
	@GetMapping("/param/test3Pr")
	public String test3Pr() {
		return "/paramView/view3Pr";
	}
	@PostMapping("/param/input3Pr")
	public String input3Pr(PersonPr p) {
		System.out.println(p);
		return "redirect:/";
	}
	
	@GetMapping("/param/modelPr")
		public String modelPr(Model modelPr) {
			int num=111;
			String str = "서버의 문자열";
			ArrayList<String> list = new ArrayList<>();
			list.add("aaa");
			list.add("bbb");
			list.add("ccc");
			PersonPr p = new PersonPr("abc","123","박준형","010-1234-5678","SKT");
			
			modelPr.addAttribute("number", num);
			modelPr.addAttribute("string", str);
			modelPr.addAttribute("list", list);
			modelPr.addAttribute("person", p);
			
			return "/paramView/modelPr";
	}
	
	
	
	

}
