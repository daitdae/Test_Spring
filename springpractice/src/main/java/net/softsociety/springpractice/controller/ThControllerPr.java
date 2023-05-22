package net.softsociety.springpractice.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.springpractice.domain.PersonPr;

@Controller
@RequestMapping("/th")
@Slf4j
public class ThControllerPr {
	
	@GetMapping("/thtest1Pr")
	public String thtest1Pr(Model model) {
		String str = "review";
		int num = 100;
		PersonPr p = new PersonPr("아이디","비번","이름","010-1234-5678","SKT");
		String tag = "<marquee>HTML 태그가 포함된 문자열</marquee>";
		String url = "https://google.com";
		
		model.addAttribute("str",str);
		model.addAttribute("num",num);
		model.addAttribute("PersonPr",p);
		model.addAttribute("tag",tag);
		model.addAttribute("url",url);
		
		int a = 1000000;
		double b = 1234.5678;
		double c = 0.5;
		Date d = new Date();
		
		model.addAttribute("inum",a);
		model.addAttribute("dnum",b);
		model.addAttribute("dnum2",c);
		model.addAttribute("date",d);
		
		return "/thView/thview1Pr";
	}
	
	@GetMapping("/thtest2Pr")
	public String thtest2Pr(Model model) {
		String str = "abc";
		int num = 1;
		String values = "JAVA,CSS,HTML";
		
		ArrayList<String>list = new ArrayList<>();
		list.add("첫번째");
		list.add("두번째");
		list.add("세번째");
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("name", "키보드");
		map.put("price",100);
		
		model.addAttribute("str",str);
		model.addAttribute("num",num);
		model.addAttribute("values",values);
		model.addAttribute("list",list);
		model.addAttribute("map",map);
		
		return "/thView/thview2Pr";
	}
}
