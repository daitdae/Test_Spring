package net.softsociety.spring2.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//vo class에 무조건 삽입한다고 생각
@Data						 //세터게터 투스트링 등등
@NoArgsConstructor			 //기본생성자
@AllArgsConstructor 		 //생성자

public class Person {
	
	String id;
	String password;
	String name;
	String phone;
	String com;


	
}
