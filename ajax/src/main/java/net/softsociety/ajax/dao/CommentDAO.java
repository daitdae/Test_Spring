package net.softsociety.ajax.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import net.softsociety.ajax.domain.Comment;

@Mapper
public interface CommentDAO {
	
	//리플 저장
	int insertComment(Comment c);
	
	//리플 출력
	public ArrayList<Comment> listComment();
	
	//리플 삭제
	public int deleteComment(int num);
}
