package net.softsociety.spring2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	
	
	//{"","/"}를 쓰는 이유: 경로가 가장 상위
	//						접속경로를 정하는데 두가지이상일때 
	//						아무것도 안적어도 오고 /만 적어도 온다
	//						예를들어 주소창에 아무것도 안썻을때나 /만 적었을때 둘다 나오게
	@GetMapping({"", "/"})	
	public String home() {
		return "home";
	}
	
	
	@GetMapping("/logtest")
	public String logtest() {
		
		String s = "어떤문자열";
		
		System.out.println("logtest 실행됨"+s);	//쓰지말아라
		
		log.error("error");
		log.warn("warn");
		log.info("Info레벨의 출력");
		log.debug("디버깅시 사용: {}",s);	
		//여기서 중괄호는 뒤에거 ,s 를 넣어서 출력하는거임 printf랑 같음
	
		return "/home";
	}
	
	
	

}
