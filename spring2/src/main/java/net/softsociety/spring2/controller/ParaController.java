package net.softsociety.spring2.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import net.softsociety.spring2.domain.Person;

@Controller
public class ParaController {
	
	//입력화면으로 이동   /는무조건 있어야한다.
	@GetMapping("/param/test1")
	public String test1() {
		return "/paramView/view1";
	}
	
	//입력한 내용 전달받아 처리
	@GetMapping("/param/input1")
	public String input1(String name, int age) {	//String->int는 parseInt안써도 int만 붙이면 자동으로 됨
		System.out.println(name);
		System.out.println(age);
		
		return "/paramView/view1";
//		return "redirect:/";	그 전 화면으로 돌아가는 느낌 /있으니깐
	}
	
	
	//입력화면으로 이동(보낼때는 겟방식)
	//처음에 보낼땐 getmapping 이라고 보내야함
	@GetMapping("/param/test2")
	public String test2() {
		return "/paramView/view2";
	}
	
	//오류나던이유 매핑이름 실수 PostMapping이라 해야했던걸 Getmapping 이라고 함 405오류
	@PostMapping("/param/input2")
	public String input2(String id, String password, String name, String phone, String com) {
		System.out.println("ID" + id);
		System.out.println("Password" + password);
		System.out.println("Name" + name);
		System.out.println("Phone" + phone);
		System.out.println(com);
		
		return "redirect:/";
	}
	
	
	//입력화면으로 이동(보낼때는 겟방식)
	@GetMapping("/param/test3")
	public String test3() {
		return "/paramView/view3";
	}
	
	//입력한 내용을 객체로 입력 받아 처리
	@PostMapping("/param/input3")
	public String input3(Person p) {
		System.out.println(p);
		return "redirect:/";
	}
	
	
	//서버의 정보를 사용자한테 보여주는거
	@GetMapping("/param/model")
	public String model(Model model) { 
		//변수만 선언해놓고 기다리면 알아서 꽂아준다 스프링에서 제공해주는 모델이라는 클래스
		//서버에서 보여주고 싶은걸 모델에 담아서 보여줌
		int num = 999;
		String str = "서버의 문자열";
		ArrayList<String> list = new ArrayList<>();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		Person p = new Person("aaa","123","홍길동","010-1234-5678","KT");
		
		//.addAttribute 요거 하나만 알면 됨 다 처리하고 화면에 담기 직전에 모델에 담기위해서 att해주는 거임
		model.addAttribute("number", num); //map구조로 앞에게 key 뒤에게 value
		model.addAttribute("string", str);
		model.addAttribute("list", list);
		model.addAttribute("person", p); //person객체의 tostring 부분이 실행됨
		
		return "/paramView/model";	//포워딩
	}
		

}
