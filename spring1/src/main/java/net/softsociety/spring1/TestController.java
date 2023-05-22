package net.softsociety.spring1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
	
		@GetMapping("/test1") //요 경로명으로 들어오면 view1을 실행한다. 겹치는 주소 있으면 안됨
							  // 여기서 /는 인사이트의 가장 상위 url
		public String test1() { 
			return "/view1";	// 여기서 /는 template 밑의 경로를 의미
		}
		
		@GetMapping("/aaa/bbb") //경로는 내 마음대로 지정가능, 접속방법이 달라짐, URL, 프로젝트의 가장 상위기준 절대경로
		public String test2() {
			return "/view2";
		}
		
		@GetMapping("/test3")
		public String test3() {
			return "/view3";
		}
		
		@GetMapping("/ccc/ddd")
		public String test4() {
			return "/view4";
		}
		
		@GetMapping("/test5")
		public String test5() {
			return "/view5";
		}
		
		@GetMapping("/test7")
		public String test7() {
			return "/view7";
		}
		
		@GetMapping("/test8")
		public String test8() {
			return "/view8";
		}
	
}
