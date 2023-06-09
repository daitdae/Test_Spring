package net.softsociety.spring5.dao;

import org.apache.ibatis.annotations.Mapper;

import net.softsociety.spring5.domain.Member;

@Mapper
public interface MemberDAO {
	
	//회원정보 저장
	int insert(Member member);
	
	//회원정보 조회
	Member select(String memberid);

	//개인정보 수정하는 코드
	int update(Member member);
	
	//탈퇴 코드
	public int delete(String id);

	
	
	
	
	
	

}
