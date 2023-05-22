package net.softsociety.spring4.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

	/**
	 * 회원정보와 내용을 저장할 VO클래스
	 **/
	
	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	
	public class Guestbook{
		int num;
		String name;
		String password;
		String contents;
		String inputdate;
	}

