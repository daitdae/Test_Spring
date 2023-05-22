package net.softsociety.springpractice.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/ex")
@Controller
public class Test3ControllerPr {
	/**
	 * 방문횟수 카운트 예제
	 	방문횟수가 저장된 쿠키를 읽어온다
		없으면 방문횟수는 현재 0으로 처리
		있으면 쿠키에 저장된 숫자가 기존 방문횟수
		방문횟수에 1을 더한다
		쿠키에 증가된 방문횟수를 저장하여 클라이언트로 보낸다
		방문횟수를 Model에 저장하여 html페이지에서 환영 문구 출력 
	 * @param count 쿠키 이름으로 값 읽기
	 * @param response 응답 정보
	 * @param model 모델 객체
	 * @return	출력 HTML 파일 경로
	 */
	
	@GetMapping("/test3Pr")
	public String cookiePr(
			@CookieValue(name="count", defaultValue="0")
			int count
			,HttpServletResponse response
			,Model model) {
		
		count ++;
		model.addAttribute("count", count);
		
		Cookie cookie = new Cookie("count", Integer.toString(count));
		cookie.setMaxAge(60*60*24*365);
		response.addCookie(cookie);
		
		return "/exView/cookiePr";
	}

}
