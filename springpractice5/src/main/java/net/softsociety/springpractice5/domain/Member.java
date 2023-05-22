package net.softsociety.springpractice5.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {
	
	
	String memberid; 		//사용자 식별 ID
	String memberpw; 		//비밀번호
	String membername;		//사용자 이름
	String email; 			//이메일 주소
	String phone;			//전화번호
	String address; 		//주소
	boolean enabled; 		//계정상태(숫자1: 사용가능 0:불가능)
	String rolename;

}
