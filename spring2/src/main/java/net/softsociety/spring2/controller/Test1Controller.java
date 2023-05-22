package net.softsociety.spring2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/ex")
@Controller
public class Test1Controller {
	/*
	 * 계산기 폼 화면으로 이동
	 * @return 계산기 폼 html 파일*/
	
	@GetMapping("/test1")
	public String test1() {
		return "/exView/view1";
	}
	//---------------------------------------------------------- 여까진 성공//
	
	/*
	 * 계산기 폼에서 입력한 값을 전달받아 계산하고 결과페이지로 포워딩
	 * @param model
	 * @param op 연산자
	 * @param num1 피연산자1
	 * @param num2 피연산자2
	 * @return 결과 출력할 HTML파일*/
	
	@PostMapping("/test1")
	public String test1(Model model, String op, int num1, int num2) {
		
		//계산처리하는곳(스프링방식 사용)
		int res=0; //초기화 해야함, 이거 안함 이건 입력받는게 아니라 위에 넣으면 안됨
		
		switch(op) { //이거안함
		case "+": res = num1 + num2; break;
		case "-": res = num1 - num2; break;
		case "*": res = num1 * num2; break;
		case "/": res = num1 / num2; break;
		}
		
		model.addAttribute("num1",num1);
		model.addAttribute("num2",num2);
		model.addAttribute("op",op);
		//---------------------------------------------------------- 여까진 성공(그냥 위 모델 어트리 출력하는거까지 계산쪽 제외)//
		model.addAttribute("res",res); //이거 안함
		
		
		return "/exView/result";
	}
	
	

}
