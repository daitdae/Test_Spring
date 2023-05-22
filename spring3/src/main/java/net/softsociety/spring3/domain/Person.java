package net.softsociety.spring3.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 회원정보를 저장할 VO클래스
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
	String idnum; 	//주민등록 번호
	String name; 	//이름
	int age; 		//나이
	

}
