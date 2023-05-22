package net.softsociety.spring5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import net.softsociety.spring5.dao.MemberDAO;
import net.softsociety.spring5.domain.Member;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	MemberDAO dao;
	
	@Autowired 
	PasswordEncoder encoder;

	@Override
	public int insert(Member member) {
		//비밀번호 암호화
		String pw = encoder.encode(member.getMemberpw());
		
		//암호화 된 비번을 객체안에 세팅
		member.setMemberpw(pw); //이 두개를 db에 저장
		
		int n = dao.insert(member);
		
		return n;
	}

	@Override
	public boolean idcheck(String id) {
//		Member member = dao.select(id);

//		boolean res; //변수 선언
//		if(member == null) {
//			res =false;
//		} else {
//			res= true;
//		}
//		return res;
		
//		boolean res = member != null; //if문의 역할 위를 줄인거
//		return false;
		
//		return member !=null;	//위를  또 줄인것 한문장으로 정리 가능
		
		return dao.select(id) !=null; //맨위 객체부분 까지 모든걸 줄여서 한문장으로 만든것
	}

	@Override	//개인정보 수정 폼으로 이동
	public Member getMember(String id) {
		Member member = dao.select(id);//이걸 안함
		return member;
	}

	@Override	//개인정보 수정 처리
	public int update(Member member) {
		//수정할 비밀번호 있으면 암호화
		if(member.getMemberpw() !=null && member.getMemberpw().length()!=0) {
			String pw = encoder.encode(member.getMemberpw());
			member.setMemberpw(pw);
		}
		int n = dao.update(member);
		return n;
	}

	@Override
	public int delete(String id) {
		int n = dao.delete(id);
		return n;
	}
	
	
	
	
	
	

}
