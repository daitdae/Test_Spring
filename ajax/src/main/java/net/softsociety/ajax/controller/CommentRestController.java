package net.softsociety.ajax.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.ajax.domain.Comment;
import net.softsociety.ajax.service.CommentService;


@Slf4j
@Controller
@RequestMapping("/comment")
@ResponseBody 
public class CommentRestController {
	@Autowired
	CommentService service;
	
	@PostMapping("insertComment")
	public void insert(Comment c) {
		//서비스로 전달하여 db에 저장
		/*
		 * 1. 이름, 글내용 전달받아 db에 저장
		 * 2. 번호를 전달받아 db에서 삭제
		 * 3. db의 모든 정보를 ArrayList<Comment> */
		
		service.insertComment(c);
		log.debug("전달된 값{}",c);
	}
	
	// 댓글 읽기
	@GetMapping("list")
	public ArrayList<Comment> list(){
		ArrayList<Comment> list = service.listComment();
		log.debug("전달된 값{}",list);
		return list;
	}
	
	//댓글 삭제 (선생님이 한거)
	@GetMapping("deleteComment")
	public int delete(int num) {
		int res = service.deleteComment(num);
		log.debug("전달된 값{}",res);
		return res;
	}
	
	//댓글 삭제 내가 한건데 리다이렉트나 포워딩이 안된다 
	//이유는 @ResponseBody 넣었기때문에 ajax이므로 이렇게 하면 리턴값이
//	그냥 html파일의 success("요부분")에 꽂힌다 그러므로 만약 리다이렉트나 
//	다른처리를 하기위해서는 여기가 아닌 javascript부분에서 해야한다
//	@GetMapping("deleteComment")
//	public String delete(int num) {
//		int res = service.deleteComment(num);
//		log.debug("전달된 값{}",res);
//		return "res";
//	}
	

}
