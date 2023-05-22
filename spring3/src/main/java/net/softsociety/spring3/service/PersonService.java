package net.softsociety.spring3.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.softsociety.spring3.dao.PersonDAO;
import net.softsociety.spring3.domain.Person;


@Service
public class PersonService {
	@Autowired
	PersonDAO dao; 
	
	public int insertPerson(Person p) {
		int n =dao.insertPerson(p);
		return n;		//삭제 하고 나서 몇개 삭제됬습니다 이런거 알아보고 싶을때
		
	}
	
	public int deletePerson(String idnum) {
		int n = dao.deletePerson(idnum);
		return n;
	}

	public int deletePerson2(String name) {
		int n = dao.deletePerson2(name);
		return n;
	}

	public Person selectOne(String idnum) {
		Person p = dao.selectOne(idnum);
		return p;
	}

	public ArrayList<Person> select() {
		ArrayList<Person> list = dao.select();
		return list;
	}

//	public Person update(String name, String age) {
//		Person n = dao.update(name,age);
//		return n;
//	}

	public int updatePerson(Person person) {
		int n = dao.updatePerson(person);
		return n;
	}

	
	
}
