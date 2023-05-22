package net.softsociety.spring2.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.spring2.domain.Person;

@Slf4j
@Controller
@RequestMapping("/th")
public class ThController {
	
	@GetMapping("/thtest1")
	public String thtest1(Model model) { //한번하고 사라질거라 모델로 받아줌
		String str = "abcd";
		int num = 100;
		Person p = new Person("aaa","111","홍길동","010-1234-5678","SKT");
		String tag = "<marquee>HTML 태그가 포함된 문자열</marquee>";
		String url = "https://google.com";
		
		model.addAttribute("str",str);
		model.addAttribute("num",num);
		model.addAttribute("person",p);
		model.addAttribute("tag",tag);
		model.addAttribute("url",url);
		
		//11일에 추가한 부분(요 밑으로 쭉)
		int a = 1000000;
		double b = 1234.5678;
		double c = 0.5;
		Date d = new Date();
		
		model.addAttribute("inum",a);
		model.addAttribute("dnum",b);
		model.addAttribute("dnum2",c);
		model.addAttribute("date",d);
		
		return "/thView/thview1";
	}
	
	@GetMapping("/thtest2")
	public String thtest2(Model model) {
		String str = "abc";
		int num = 1;
		String values = "Java,CSS,HTML";
		
		ArrayList<String> list = new ArrayList<>();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("name", "키보드");
		map.put("price", 100);
		
		model.addAttribute("str",str);
		model.addAttribute("num",num);
		model.addAttribute("values",values);
		model.addAttribute("list",list);
		model.addAttribute("map",map);
		
		return "/thView/thview2";
	}
	

}
