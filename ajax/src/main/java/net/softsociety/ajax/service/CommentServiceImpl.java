package net.softsociety.ajax.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.ajax.dao.CommentDAO;
import net.softsociety.ajax.domain.Comment;

@Service
@Slf4j
public class CommentServiceImpl implements CommentService{
	
	@Autowired
	//CommentDAO CommentDAO; 이렇게 실수함
	CommentDAO dao;

	@Override
	public int insertComment(Comment c) {
		int n = dao.insertComment(c);
		return n;
	}

	@Override
	public ArrayList<Comment> listComment() {
		 ArrayList<Comment> listComment = dao.listComment();
		return listComment;
	}

	@Override
	public int deleteComment(int num) {
		int n = dao.deleteComment(num);
		return n;
	}
	
	
	
	
	
	
}
