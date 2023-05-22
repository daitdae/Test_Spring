package net.softsociety.springpractice2.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.softsociety.springpractice2.dao.PersonDAOPr;
import net.softsociety.springpractice2.domain.PersonPr;

@Service
public class PersonServicePr {
	
	@Autowired
	PersonDAOPr dao;
	
	public int insertPersonPr(PersonPr p) {
		int n = dao.insertPersonPr(p);
		return n;
	}

	public int deletePersonPr(String idnum) {
		int n = dao.deletePersonPr(idnum);
		return n;
	}

	public int delete2PersonPr(String name) {
		int n = dao.delete2PersonPr(name);
		return n;
	}

	public PersonPr selectOnePr(String idnum) {
		PersonPr p = dao.selectOnePr(idnum);
		return p;
	}

	public ArrayList<PersonPr> selectPr() {
		 ArrayList<PersonPr> list = dao.selectPr();
		return list;
	}

	public int updatePersonPr(PersonPr person) {
		int n = dao.updatePersonPr(person);
		return n;
	}

}
