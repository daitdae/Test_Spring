package net.softsociety.springpractice2.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import net.softsociety.springpractice2.domain.PersonPr;

/**
 * Mybatis의 매퍼 인터페이스
 * **/
@Mapper
public interface PersonDAOPr {
	//저장
	public int insertPersonPr(PersonPr p);

	public int deletePersonPr(String idnum);

	public int delete2PersonPr(String name);

	public PersonPr selectOnePr(String idnum);

	public ArrayList<PersonPr> selectPr();

	public int updatePersonPr(PersonPr person);

}
