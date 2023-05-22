package net.softsociety.spring2.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/session") //method앞에 경로 한번에 들어감 (get post 동일)
@Controller
public class SessionController {
	
	@GetMapping("/stest1")	//로그인 기능
	public String stest1(HttpSession session) {
		session.setAttribute("id", "abc"); //session.setAttribute(이름, 값) 세션이 유지되는 동안 저장된다.
		return "/sessionView/ss1";
	}
	
	@GetMapping("/stest2")	//id로 저장받음 이름이 id인것을 꺼내옴
							//로그인했나 안했나 확인하는 기능
	public String stest2(HttpSession session) {
		String id = (String)session.getAttribute("id"); //string인데 object타입으로 받아와서 형변환 해줘야함
														//키 값을 id라는 이름으로 저장했는데 그 안에는 String으로 무언가를 저장함 그래서 스트링 id넣어주는것
		log.debug("세션의값: {}", id);	//자바 코드로 읽는 방법, 세션값을 자바에서 쓸일도 많기 때문
		return "redirect:/"; 			//그냥 상위경로로 리다이렉트
	}
	
	@GetMapping("/stest3")	//로그아웃기능
	public String stest3(HttpSession session) {
		session.removeAttribute("id");
		return "redirect:/";
	}
	
	@GetMapping("/stest4")
	public String stest4() {	//세션 필요없음 로그인한 아이디랑 비번 보내기만 하면 되서
		return "/sessionView/loginForm";
	}
	
	@PostMapping("/stest5")
	public String stest5(
			String id			//옆으로 길게 하지말고 이런식으로 변수를 한줄에 하나씩만
			, String pw
			, HttpSession session
			, HttpServletRequest req) { 
		
		log.debug("요청정보 : {}" , req.getRemoteAddr()); //접속자의 ip주소를 알아내는 것
		//String s = req.getParameter("id");	//원래는 하나씩 읽었어야함 
		
		//ID하고 비밀번호가 맞는지 확인 (abc 123)
		if(id.equals("abc") && pw.equals("123")) {
			//맞으면 세션에 "id"이름으로 ID를 저장하고 메인화면으로 리다이렉트
			session.setAttribute("id", id);	//안됬던게 이거 안넣음 
			return "redirect:/";
		} else{										//else 썻어야함
			//틀리면 로그인 form html로 포워딩
			return "/sessionView/loginForm";
		}
	}
	
	@GetMapping("/stest6")
	public String stest6(HttpSession session) {
		session.removeAttribute("id");
		return "redirect:/";
	}
		
}
