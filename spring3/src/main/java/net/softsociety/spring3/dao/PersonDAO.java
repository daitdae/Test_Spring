package net.softsociety.spring3.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import net.softsociety.spring3.domain.Person;

/**
 * Mybatis의 매퍼 인터페이스
 * **/

@Mapper
public interface PersonDAO {
	//저장
	public int insertPerson(Person p); //int를 쓰는이유는 행 갯수가 돌아오기 때문에
	//번호로 삭제
	public int deletePerson(String idnum);
	//이름으로 삭제
	public int deletePerson2(String name);
	//민번으로 1명 조회
	public Person selectOne(String idnum);
	//모든회원 조회
	public ArrayList<Person> select();
	
//	public Person update(String name, String age);
	
	//회원정보수정
	public int updatePerson(Person person);
	
	
}


