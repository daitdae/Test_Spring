package net.softsociety.springpractice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeControllerPr {
	
	@GetMapping({"","/"})
	public String homePr() {
		return "homePr";
	}
	
	@GetMapping("/logtest")
		public String logtest() {
			String s = "어떤 문자열";
			
			System.out.println("logtest 실행됨" +s); 
			
			log.error("error");
			log.warn("warn");
			log.info("Info 레벨의 출력");
			log.debug("디버깅시 사용:{}",s);
			
			return "/homePr";
		}
	

}
