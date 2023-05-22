package net.softsociety.spring4.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import net.softsociety.spring4.domain.Guestbook;

@Mapper
public interface GuestbookDAO {

	//save
	public int insert(Guestbook gb); //괄호안이 파라미터고 그게 xml파일의 파라미터 타입임
	
	//select (전체 읽기)
	public ArrayList<Guestbook> list();//파라미터 없기때문에 xml에도 없음
	
	//delete
	public int delete(Guestbook gb);
	
}
