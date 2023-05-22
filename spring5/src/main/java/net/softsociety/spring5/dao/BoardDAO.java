package net.softsociety.spring5.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

import net.softsociety.spring5.domain.Board;
import net.softsociety.spring5.domain.Reply;

/**
 * 게시판관련 매퍼 인터페이스*/
@Mapper
public interface BoardDAO {
	
	//글 저장
	public int write(Board board);
	
	//글 목록
	//public ArrayList<Board> list();
	public ArrayList<Board> list(HashMap<String,String>map, RowBounds rb);
	
	//글 갯수
	public int total(HashMap<String,String>map);
	
	//글 한개 읽기
	public Board read(int num);
	
	//조회수 1추가
	public int add(int num);

	//글 삭제
	public int delete(Board board);
	
	//글 수정
	public int update(Board board);
	
	//댓글 추가
	public int writeReply(Reply reply);
	
	//해당글 리플목록 출력
	public ArrayList<Reply> readReply(int num);
	
	//리플 삭제(이건 맞았음)
	public int deleteReply(Reply reply);

	
	
	
	
	
	
	
	


}
