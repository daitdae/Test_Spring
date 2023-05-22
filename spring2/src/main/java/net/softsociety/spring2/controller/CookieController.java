package net.softsociety.spring2.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/cookie")
@Controller
public class CookieController {
	
	@GetMapping("/ck1")
	public String ck1(HttpServletResponse res) {
		//쿠키 생성(지금 만들어진건 서버에만 있는거)
		Cookie c1 = new Cookie("str","abcde");
		Cookie c2 = new Cookie("num","123");
		
		//쿠키 유지 시간(단위는 초, 계산 식을 써준다)
		c1.setMaxAge(60*60*24*3);
		c2.setMaxAge(60*60*24*3);
		
		//응답정보에 쿠키 추가(그냥 가지말고 쿠키 가지고 가라)
		res.addCookie(c1);
		res.addCookie(c2);
		
		return "redirect:/"; //리턴될때 위의 쿠기가 가는것
	}
	
	@GetMapping("/ck2")		//읽을땐 리퀘스트 정보에 딸려옴
	public String ck2(
			@CookieValue(name="str", defaultValue="없음") String str
			, @CookieValue(name="num", defaultValue="0") int num) {
//		변수선언을 해놓고 
//		어노테이션(요청이 들어왔으면 그 쿠기중에 이름이 str이라는걸 보여준다 근데 그런게 없으면 디폴트 값을 보여준다)
//		쓰고 이름과 디폴트 지정해준다
		
		log.debug("str 쿠키 값 : {}",str);
		log.debug("num 쿠키 값 : {}",num);
		
		return "redirect:/";
	}

	@GetMapping("/ck3")
	// 메소드 정의 하고 쿠키 삭제하는 명령어는 따로 없음 쿠키저장하는거랑 방법 같음 쿠키 유지시간을 0으로 하고 add하면 덮어씌워지면서 삭제가 되는 개념
	// 이름이 str num인 쿠키를 생성한다
	// 유지시간을 0초로 지정한다
	// HttpServletResponse 객체를 통해 쿠키를 저장한다.(동시에 삭제된다)
	// 수정도 같은 방법으로 하면 된다.
	public String ck3(HttpServletResponse res) {
		
		Cookie c1 = new Cookie("str", null);
		Cookie c2 = new Cookie("num", null);
		
		c1.setMaxAge(0);
		c2.setMaxAge(0);
		
		res.addCookie(c1);
		res.addCookie(c2);
		
		return "redirect:/";
		
		
	}


}
