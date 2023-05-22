package net.softsociety.spring5.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Board {
	
	int boardnum; 	 	//번호
	String memberid;	//작성자ID 
	String title; 		//제목
	String contents; 	//내용 
	String inputdate; 	//작성일
	int hits; 			//조회수
	String originfile;	//첨부파일 원래이름
	String savedfile;	//첨부파일 서버에 저장

}
