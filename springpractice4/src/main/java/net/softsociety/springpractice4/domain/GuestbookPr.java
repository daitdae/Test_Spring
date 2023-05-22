package net.softsociety.springpractice4.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 회원정보와 내용을 저장할 VO클래스
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor

public class GuestbookPr {	
	int num;              //NUMBER PRIMARY KEY      --글번호 
    String name;          //VARCHAR2(30) NOT NULL   --이름
    String password;      //VARCHAR2(30) NOT NULL   --비밀번호
    String contents;      //VARCHAR2(2000) NOT NULL --글 내용
    String inputdate;     //DATE DEFAULT SYSDATE    --작성시간

}
