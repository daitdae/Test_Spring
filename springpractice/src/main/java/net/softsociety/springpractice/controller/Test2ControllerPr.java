package net.softsociety.springpractice.controller;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@RequestMapping("/ex")
@Slf4j
@Controller
public class Test2ControllerPr {
	
	/**
	 * 입력한 이름과 주민등록번호를 전달받아 처리 결과를 infoOutput.html에서 출력
	 * @param name	이름
	 * @param num	주민등록번호
	 * @param model
	 * @return 결과 출력 HTML 파일 경로
	 */
	
	@GetMapping("/test2Pr")
	public String test2Pr() {
		return "exView/infoPr";
	}
	
	@PostMapping("/test2Pr")
	public String test2Pr(Model model, String name, String jumin) {
		
		model.addAttribute("name",name);
		model.addAttribute("jumin",jumin);
		
		String gender = null;
		char ch;
		int y=0 , m=0, d=0, age=0;
		boolean error = false;
		
		//현재년도
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		
		//글자수
		if(jumin.length() !=14) {
			error = true;
		}
		
		//'-'문자 확인
		if(jumin.indexOf('-') !=6) {
			error = true;
		}
		
		//성별
		ch = jumin.charAt(7);
		if(ch < '1' || ch > '4') {
			error = true;
		}
		
		try {
			//생년월일
			y = Integer.parseInt(jumin.substring(0,2));
			m = Integer.parseInt(jumin.substring(2,4));
			d = Integer.parseInt(jumin.substring(4,6));
			
			//성별
			gender = ch == '1'|| ch == '3' ? "남자":"여자";
			
			//나이
			if(ch == '1' || ch == '2') {
				age = year - y- 1900;
			} else {
				age = year - y -2000;
			}
		} catch(Exception e) {
			error = true;
		}
		
		if(error) {
			model.addAttribute("error","error");
			return "exView/infoPr";
		}
		
		model.addAttribute("y",y);
		model.addAttribute("m",m);
		model.addAttribute("d",d);
		model.addAttribute("age",age);
		model.addAttribute("gender",gender);
		
		
		return "exView/infoOutputPr";
	}

}
