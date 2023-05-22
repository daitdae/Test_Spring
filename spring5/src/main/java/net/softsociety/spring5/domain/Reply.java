package net.softsociety.spring5.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Reply {

	
	int replynum;	//댓글번호
	int boardnum;	//본문글번호
	String memberid; //작성자 ID
	String replytext; //댓글내용
	String inputdate; //작성일
}
