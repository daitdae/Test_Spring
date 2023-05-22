package net.softsociety.spring5.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.spring5.domain.Member;
import net.softsociety.spring5.service.MemberService;

/**
 * 회원 관련 처리 컨트롤러
 * */
@Slf4j
@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired
	MemberService service;
	
	/*
	 * 회원가입 폼으로 이동
	 * @return 회원가입 양식 HTML
	 * */
	@GetMapping("/join")
	public String join() {
		return "/memberview/joinForm";
	}
	
	//입력폼에서 전달된 값 저장
	@PostMapping("/join")
	public String join(Member member) {
		log.debug("가입데이터 : {}", member);
		service.insert(member);
		return "redirect:/";
	}
	
	@GetMapping("idcheck")
		public String idcheck() {
			return "/memberview/idcheckForm";
	}
	
	//아이디 검색시 
	@PostMapping("/idcheck")
	public String idcheck(String id, Model model) {
		log.debug("검색할 아이디 : {}",id);
		
		boolean res = service.idcheck(id); //dao로 넘어가서 그걸 serviceimpl에서 받아서 검사
		
		model.addAttribute("searchID",id);
		model.addAttribute("result" , res);
		
		return "/memberview/idcheckForm";
	}
	
	/**로그인 폼으로 이동
	 * @return
	 * */
	@GetMapping("/loginForm")	
	public String loginForm() {
		return "/memberview/loginForm";
	}
	
	/**개인정보 수정 폼으로 이동
	 */
	@GetMapping("/mypage")	
	public String mypage(@AuthenticationPrincipal  UserDetails user, Model model) {
		log.debug("인증정보: {}", user.getUsername());
		//db에서 현재 사용자 정보 읽어서 member 객체로 받음
		Member member = service.getMember(user.getUsername());
		//Model에 member객체 담기
		model.addAttribute("member",member);
		//수정폼으로 이동
		return "/memberview/mypageForm";
	}
	
	/**개인정보 수정 처리
	 */
	@PostMapping("/mypage")	
	public String mypage(Member member, @AuthenticationPrincipal UserDetails user) {
		//수정폼에서 사용자가 입력한 정보를 member로 전달받음
		//이름, 전화번호, 이메일, 주소
		//로그인한 id를 읽어서 멤버 객체에 추가저장
		//서비스로 전달하여 db의 내용 수정
		log.debug("수정정보: {}", user.getUsername());
		member.setMemberid(user.getUsername());
		service.update(member); //새로운 이름으로 만들어서 인터페이스에 추가하고 오버라이딩해줘야함
		return "redirect:/";
	}
	
	/**
	 * 회원탈퇴처리
	 */
	@GetMapping("/delete")
	public String delete(String id) {
		service.delete(id);
		return "redirect:/member/logout";
	}
	
	

	

}
