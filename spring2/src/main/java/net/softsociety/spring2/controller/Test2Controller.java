package net.softsociety.spring2.controller;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/ex")
@Controller
public class Test2Controller {
	
	@GetMapping("/test2")
	public String test2() {
		return "/exView/view2";
	}
	
//	@PostMapping("/test2") 선생님이 한거 나중에 다시 해보기
//	public String test2(Model model, String name, String num, String jumin) {
//		
//		log.debug("전달된 값: {}, {}", name, num);
//		model.addAttribute("name",name);
//		model.addAttribute("jumin",jumin);
//		
//		String gender = null;
//		char ch;
//		int y = 0, m = 0 ,d = 0, age = 0;
//		boolean error = false; 
//		//boolean하나 준비해서 if문안에 다 집어 넣어놔서 에러가 있는 경우 확인
//		
//		//현재년도 구하는 법
//		Calendar c = Calendar.getInstance();
//		int year = c.get(Calendar.YEAR);
//		
//		//글자수 체크
//		if(num.length()!=14) {
//			error = true;
//		}
//		// '-'문자 확인
//		if(num.indexOf('-')!=6) {
//			error = true;
//		}
//		// 성별
//		ch = num.charAt(7);
//		if(ch < '1' || ch > '4') {
//			error = true;
//		}
//		
//		//생년월일
//		y= Integer.parseInt(num.substring(0, 2));
//		m= Integer.parseInt(num.substring(2, 4));
//		d= Integer.parseInt(num.substring(4, 6));
//		
//		//성별
//		gender = ch == '1' || ch =='3' ? "남자":"여자";
//		
//		//나이
//		if(ch =='1' || '2') {
//			age = year - y - 1900;
//			age = year - y - 2000;
//		}  
//		
//		if(error) {
//			log.debug("에러:{}",error);
//			model.addAttribute("error","error");
//			return "/exView/view2";	//입력폼으로 포워딩
//		}
//		model.addAttribute("y",y);
//		model.addAttribute("m",m);
//		model.addAttribute("d",d);
//		model.addAttribute("gender",gender);
//		model.addAttribute("age",age);
		
		
		
	
//  밑에 코드는 내가 한건데 제대로 한거긴함
	@PostMapping("/test2")
	public String test2(Model model
			, String name
			, String jumin
			, String birthYear
			, String birthMonth
			,String birthDay) {
		int temp=0;
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		
////		//성별체크
		
		char gender = jumin.charAt(7);
		temp = ((int)gender)-48; //char 1 = 49 (아스키코드) 
								 //temp에는 1,2,3,4 중 중 하나가 있음
		String g = null;
		if(temp % 2 != 0) {
			g = "남자";
		} else {
			g = "여자";
		}
		

////		//나이계산
		birthYear = null;
		if(temp == 1 || temp ==2) {
			birthYear = "19" + jumin.substring(0,2);
		} else {
			birthYear = "20" + jumin.substring(0,2);
		}
		int age = year-Integer.parseInt(birthYear);
		
		
//		//생년월일 출력
		birthMonth = null;
			birthMonth =  jumin.substring(2,4);
					
		birthDay = null;
			birthDay = jumin.substring(4,6);
		
		model.addAttribute("name",name);
		model.addAttribute("birthYear",birthYear);
		model.addAttribute("birthMonth",birthMonth);
		model.addAttribute("birthDay",birthDay);
		model.addAttribute("g",g);
		model.addAttribute("age",age);
		
		return "/exView/result2";
	}
	


}
