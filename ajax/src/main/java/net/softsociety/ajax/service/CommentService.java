package net.softsociety.ajax.service;

import java.util.ArrayList;

import net.softsociety.ajax.domain.Comment;

public interface CommentService {
	
	//리플 저장
	public int insertComment(Comment c);
	
	//리플 출력
	public ArrayList<Comment> listComment();
	
	//리플 삭제
	public int deleteComment(int num);
}
