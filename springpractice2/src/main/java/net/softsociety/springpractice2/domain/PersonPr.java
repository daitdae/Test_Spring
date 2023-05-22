package net.softsociety.springpractice2.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 회원정보를 저장할 VO클래스
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonPr {
	String idnum;
	String name;
	int age;

}
