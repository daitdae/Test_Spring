package net.softsociety.spring3.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.spring3.domain.Person;
import net.softsociety.spring3.service.PersonService;

/**
 * 회원 정보의 입력/수정.삭제 조회처리
 **/
@Controller	
@Slf4j
public class PersonController {
	@Autowired				//변수 앞에(여러개가 필요하면 다 붙여줘야함) 선언만하면 찾아다가 대입해준다 객체가 있는것만 사용가능
	PersonService service;	//현재클래스의 모든변수에서 다 사용가능
	
	//입력 폼으로 이동
	@GetMapping("/insert")
	public String insert() {
		return "/insertForm";	//앞의 슬래시는 템플릿 폴더를 의미함	
	}							//템플릿 밑의 insertForm 폴더를 가져와라
	
	//입력폼에서 전달된 값 저장(전달받은 값을 서비스에 저장해 라고 명령)
	@PostMapping("/insert")
	public String insert(Person person) {
		log.debug("전달된 값,{}", person);
		//저장처리
		
		service.insertPerson(person);	//서비스 객체 만든거를 그걸 필요할때마다 가져오는 명령어
		
		return "redirect:/";
	}
	
	//전달된 주민등록번호의 회원삭제
	@GetMapping("/delete")
	public String delete(String idnum) {
		log.debug("삭제할 주민등록번호 : {}", idnum);
		
		//서비스 클래스로 주민등록번호 전달하여 삭제
		service.deletePerson(idnum);
		//메인화면으로 리다이렉트
		//return "redirect:/";
		//셀렉트 창으로 리다이렉트
		return "redirect:/select";
	}
	
	//전달된 이름의 회원 삭제
	@GetMapping("/delete2")
	public String delete2(String name) {
		log.debug("삭제할 이름 : {}", name);
		
		//서비스 클래스로 이름 전달하여 삭제
		service.deletePerson2(name);
		
		//메인으로 리다이렉트
		return "redirect:/";
	}
	
	//한명의 정보 조회
	@GetMapping("/selectOne")
	public String selectOne(String idnum, Model model) {
		log.debug("조회할 주민등록번호 : {}", idnum);
		
		//person 객체를 만들어서 서비스 클래스로 전달하여 조회
		Person person = service.selectOne(idnum);
		//model에 객체 추가
		model.addAttribute("person",person);
		
		//html문서로 리턴해주기
		return "/viewPerson";
	}
	
	//모든 정보 조회
	@GetMapping("/select")
	public String select(Model model) {
		ArrayList<Person> list = service.select();
		model.addAttribute("list",list);
		return "/viewlist";
	}
	
	//수정폼으로 이동
	@GetMapping("/update")
	public String update(String idnum, Model model) {
		Person person = service.selectOne(idnum);
		model.addAttribute("person",person);
		return "/updateForm";
	}
	
//	@PostMapping("/update") 내가 한것
//	public String update(String name, String age, Model model) {
//		log.debug("전달된 값,{}", name, age);
//		Person person = service.update(name,age);
//		
//		model.addAttribute("person",person);
//		model.addAttribute("name",name);
//		model.addAttribute("age",age);
//		return "/viewlist";
//	}
	
	//수정한 데이터 처리
	@PostMapping("/update")
	public String update(Person person) {
		service.updatePerson(person);
		return "redirect:/select";
	}

}
