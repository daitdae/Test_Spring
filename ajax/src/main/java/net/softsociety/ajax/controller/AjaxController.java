package net.softsociety.ajax.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.ajax.domain.Person;

@Slf4j
@Controller
@RequestMapping("/ajax")
public class AjaxController {
	
	//aj1.html로 가기위한 메서드
	@GetMapping("aj1")
	public String aj1() {
		return "/ajax/aj1";
	}
	
	@ResponseBody //ajax쓸때는 이게 필요하다
	//서버로 뭔가를 보냈을때 @ResponseBody가 붙어있단 의미는 어떤 결과물을 바로 리턴
	@GetMapping("test1")
	public void test1() {
		log.debug("Controller의 test1 실행");
		
		//가져올 값 없으면 리턴 지워버린다 그리고 void로
		//return"";
	}
	
	@ResponseBody 
	@GetMapping("test2")
	//서버에 파라미터 보낼때 data: {} 사용 (파라미터 : '보낼값')
    //,data: {str: '클라이언트에서 보내는 값'} 이어서 String str로 받는다
	public String test2(String str) {
		log.debug("str");
		return "서버에서 보내는 값";
	}
	
	@ResponseBody 
	@GetMapping("test3")
	public String test3(String text) {
		String s = text.toUpperCase();
		log.debug("전달된 값{}", text);
		return s;
	}
	
	@GetMapping("aj2")
	public String aj2() {
		return "/ajax/aj2";
	}
	
	@ResponseBody 
	@PostMapping("insert1")
	public void insert1(String name, int age, String phone) {
		//전달받은 값 콘솔에 출력 1번 방식
		log.debug("전달된 값{},{},{}",name,age,phone);
		
	}
	
	//23일 추가 vo객체의 값을 문자열과 객체로 받는 용도
	@ResponseBody 
	@GetMapping("getObject")
	//실제로 주는게 리턴값이 된다
	public Person getObject() {
		Person p = new Person("홍길동",22,"010-1111-1111");
		return p;
	}
	
	@ResponseBody 
	@GetMapping("getList")
	public ArrayList<Person> getList() {
		ArrayList<Person> list = new ArrayList<>();
		list.add(new Person("김길동",22,"010-1111-1111"));
		list.add(new Person("홍길동",24,"010-2222-1111"));
		list.add(new Person("박길동",23,"010-3333-1111"));
		return list;
	}
	
	//배열 받아서 로그로 출력할 때 
	@ResponseBody 
	@PostMapping("sendList")
	public void sendList(String[] ar) {
		for(String s : ar) {
			log.debug(s);
		}
	}
	
	//객체배열 받아줄 때
	@ResponseBody
	@PostMapping("sendObjectList")
	public void sendObjectList(String ar) throws Exception {
		log.debug("전달받은 문자열 : {}", ar);
		
		//ObjectMapper 이게 받은 객체배열을 변환해주는 클래스
		ObjectMapper mapper = new ObjectMapper();
		//readValue라고 하는 메서드가 있음
		//그냥 하면 오류나는데 예외처리 하라고 하는거임
		//귀찮으면 그냥 throws exception
		ArrayList<Person> list 
		= mapper.readValue(ar, new TypeReference<ArrayList<Person>>() {});
		
		log.debug("변환된 객체 : {}", list);
	}

}
